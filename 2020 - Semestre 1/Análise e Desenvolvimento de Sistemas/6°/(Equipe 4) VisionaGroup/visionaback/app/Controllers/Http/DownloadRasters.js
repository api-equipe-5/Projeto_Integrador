'use strict';

const axios = use('axios');
const fs = use('fs');
const Drive = use('Drive');
const path = use('path');
const crypto = use('crypto');

class DownloadRasters {
  async index({ response, request }) {
    try {
      const coords = request.input('coords');
      const getCoords = coords;
      const b02 = await this.getRaster('B02', getCoords);
      const b03 = await this.getRaster('B03', getCoords);
      const b04 = await this.getRaster('B04', getCoords);
      const b08 = await this.getRaster('B08', getCoords);
      const ndvi = await this.getRaster('NDVI', getCoords);
      const iaResponse = await this.sendToIa({ b02, b03, b04, b08, ndvi });
      response.json({
        status: true,
        date: new Date(),
        names: iaResponse,
      });
    } catch (error) {
      response.status(500).json({
        status: false,
        date: new Date(),
        names: 'InternalServerError',
      });
    }
  }

  async getRaster(band, coords) {
    const url = `http://services.sentinel-hub.com/ogc/wms/067aeea3-60ea-4af8-b5bb-68364de2459b?REQUEST=GetMap&LAYERS=${band}&MAXCC=10&WIDTH=400&HEIGHT=400&TIME=2020-05-01&GEOMETRY=POLYGON((${coords}))&CRS=EPSG%3A4326&BGCOLOR=000000&TRANSPARENT=false&FORMAT=image%2Ftiff`;
    const folderName = path.resolve(__dirname, '../../../tmp');
    const name = crypto.randomBytes(8).toString('hex');
    await this.download(url, folderName, name);
    await this.uploadToAws(name, `${folderName}/${name}.tiff`);
    fs.unlinkSync(`${folderName}/${name}.tiff`);

    return name;
  }

  async download(url, folderName, name) {
    const stream = await axios({
      method: 'get',
      url,
      responseType: 'stream',
    });

    await this.streamToFolder(folderName, name, stream);
  }

  streamToFolder(folderName, name, res) {
    return new Promise((resolve, reject) => {
      const stream = res.data.pipe(
        fs.createWriteStream(`${folderName}/${name}.tiff`)
      );
      stream.on('finish', resolve);
      stream.on('error', reject);
    });
  }

  async sendToIa({ b02, b03, b04, b08, ndvi } = {}) {
    const { data } = await axios.post(`${process.env.IA_ENDPOINT}/predict`, {
      b02,
      b03,
      b04,
      b08,
      ndvi,
    });
    return data;
  }

  async uploadToAws(name, filePath) {
    const file = fs.createReadStream(filePath);
    await Drive.put(`${name}.tiff`, file, {
      ContentType: 'image/tiff',
      ACL: 'public-read',
    });
  }
}

module.exports = DownloadRasters;
