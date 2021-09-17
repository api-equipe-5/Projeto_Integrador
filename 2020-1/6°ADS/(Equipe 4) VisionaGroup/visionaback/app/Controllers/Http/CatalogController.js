'use strict';

const STAT_API = 'https://sat-api.developmentseed.org';
const axios = use('axios');

class CatalogController {
  async search({ request }) {
    const {
      dateInit,
      dateEnd,
      cloudCover,
      page,
      bbox,
    } = this.normalizeSearchRequest(request.get());
    return this.getCatalog({ dateEnd, dateInit, cloudCover, page, bbox });
  }

  normalizeSearchRequest({ dateInit, dateEnd, cloudCover, page, bbox }) {
    return {
      dateInit: new Date(dateInit),
      dateEnd: new Date(dateEnd),
      cloudCover: parseInt(cloudCover, 10),
      page: parseInt(page, 10),
      bbox: bbox.map((val) => parseFloat(val, 10)),
    };
  }

  async getCatalog({ dateInit, dateEnd, cloudCover, page, bbox, intersects }) {
    const requestData = {
      bbox,
      time: `${dateInit.toISOString()}/${dateEnd.toISOString()}`, // '2020-01-01T00:00:00Z/2020-06-09T00:00:00Z',
      intersects,
      query: {
        'eo:cloud_cover': {
          lt: cloudCover,
          gt: -1,
        },
      },
      sort: [
        {
          field: 'eo:cloud_cover',
          direction: 'asc',
        },
      ],
      page,
      limit: 10,
    };
    const { data } = await axios.default.post(
      `${STAT_API}/stac/search`,
      requestData
    );
    return this.normalizeCatalogData({ data });
  }

  normalizeCatalogData({ data }) {
    return {
      pagination: this.getCatalogPagination(data),
      list: this.normalizeFeature(data),
    };
  }

  getCatalogPagination({ meta: { page, limit, found } }) {
    return {
      page,
      limit,
      found,
      pages: Math.ceil(found / limit),
    };
  }

  normalizeFeature({ features }) {
    return features.map((feature) => {
      const {
        id,
        properties: { 'eo:cloud_cover': cloudCover, datetime, collection },
        assets: {
          thumbnail: { href: thumbnail },
        },
      } = feature;
      return {
        id,
        cloudCover,
        thumbnail,
        datetime,
        collection,
      };
    });
  }

  async getBand({ params, response }) {
    const { catalog_id: catalogId, scene_id: sceneId, band } = params;
    const scene = await this.getScene(catalogId, sceneId);
    const bands = this.extractSceneBands(scene);
    const { href } = bands.filter(({ name }) => name === band)[0];
    response.redirect(href);
  }

  async getScene(catalogId, sceneId) {
    const { data } = await axios.default.get(
      `${STAT_API}/collections/${catalogId}/items/${sceneId}`
    );
    return data;
  }

  extractSceneBands(scene) {
    const {
      properties: { collection },
      assets,
    } = scene;
    let bandNames;
    const resultNames = ['B02', 'B03', 'B04', 'B08'];
    if (collection === 'landsat-8-l1') {
      bandNames = ['B2', 'B3', 'B4', 'B8'];
    } else {
      bandNames = [...resultNames];
    }
    return bandNames
      .map((name) => assets[name].href)
      .map((href, id) => ({ name: resultNames[id], href }));
  }

  searchGeoJSON({ request }) {
    const { dateInit, dateEnd, cloudCover, page, geojson } = request.post();
    return this.getCatalog({
      dateEnd: new Date(dateEnd),
      dateInit: new Date(dateInit),
      cloudCover,
      page,
      intersects: geojson,
    });
  }
}

module.exports = CatalogController;
