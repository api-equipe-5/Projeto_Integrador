from flask import jsonify
import string
import random
import service.neurallNeworkServices as nn
import service.uploadToAws as upload
import rasterio
import numpy as np


def saveRaster(name, pred, h, w, crs, transform):
    with rasterio.open(
        f'tmp/{name}.tiff',
        'w',
        driver='GTiff',
        height=pred.shape[0],
        width=pred.shape[1],
        count=1,
        dtype=pred.dtype,
        crs=crs,
        transform=transform,
    ) as dst:
        dst.write(pred, 1)


def randomString(stringLength=8):
    letters = string.ascii_lowercase
    return ''.join(random.choice(letters) for i in range(stringLength))


def predict(request):
    content = request.json
    bands = {
        "b02": content["b02"],
        "b03": content["b03"],
        "b04": content["b04"],
        "b08": content["b08"],
        "ndvi": content["ndvi"]
    }
    b02, profile = downloadRaster(bands["b02"], True)
    b02 = b02.flatten() / 19920.0
    b03 = downloadRaster(bands["b03"]).flatten() / 18482.0
    b04 = downloadRaster(bands["b04"]).flatten() / 17506.0
    b08 = downloadRaster(bands["b08"]).flatten() / 16091.0
    ndvi = downloadRaster(bands["ndvi"]).flatten() / 21845.0
    out = []
    for i in range(0, 400*400):
        out.append([b02[i], b03[i], b04[i], b08[i], ndvi[i]])
    out = np.array(out)
    pred = nn.predict(out)
    img_out = []
    for i in range(0, 400):
        img_out.append([])
        for j in range(0, 400):
            img_out[i].append(65000 if pred[j+i*400][0] > 0.01 else 0)
    img_out = np.array(img_out, np.uint8)
    name = randomString()
    saveRaster(name, img_out, profile["height"],
               profile["width"], profile["crs"], profile["transform"])
    upload.upload_to_aws(f'tmp/{name}.tiff', 'visionabucket', f'{name}.tiff')
    return jsonify({"status": True, "name": name})


def downloadRaster(name, profile=None):
    url = f's3://visionabucket/{name}.tiff'
    with rasterio.open(url) as dataset:
        if(profile):
            return [dataset.read(1), dataset.profile]
        return dataset.read(1)
