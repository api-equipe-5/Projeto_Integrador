from flask import Flask, request, jsonify
from imgurpython import ImgurClient
from crop import cropImg, reprojectA
import json
from tensorflow import keras
from tensorflow.keras.models import load_model
import numpy as np
#import pandas as pd
import rasterio
from flask_cors import CORS
import requests
import matplotlib.pyplot as plt
app = Flask(__name__)
CORS(app)


@app.route('/ia', methods=['POST'])
def ia():
    print('chegou aqui')
    body = request.get_json()
    print(body[0])
    for item in body[1:]:
        print("baixando ", item['assets']['B5']['href'])
        r = requests.get(item['assets']['B5']['href'])
        if r.status_code == 200:
            f = open(item['_id'] + ".tif", "wb")
            print("baixando")
            f.write(r.content)
            f.close()
            reprojectA(item['_id'])
            cropImg(body[0], item['_id'])

    imgs_ids = []
    for item in body[1:]:
        raster = rasterio.open("cropped" + item["_id"] + ".tif")
        w = raster.width
        h = raster.height
        raster = raster.read(1)
        img_id = predict(raster, h, w)
        imgs_ids.append(img_id)
    print(imgs_ids)
    res = {}
    res['links'] = imgs_ids
    return res, 200


def upload(file):
    client_id = 'afae1e846ae1a56'
    client_secret = '2776c2df4ec2a2ce91b75857113d277921e61854'

    client = ImgurClient(client_id, client_secret)
    image = client.upload_from_path(file)
    return image['link']


def predict(x, h, w):
    model = load_model('modelo.h5')

    x = x.flatten()
    x = x / 10000
    preds = model.predict(x, batch_size=128000)
    
    mean = np.mean(preds)
    # print(mean)
    #print(np.unique(preds, return_counts=True))
    sh_preds = np.reshape(preds, (h, w))
    a = np.where(sh_preds > mean, 1, 0)

    print(preds)
    sh_preds = np.reshape(preds, (h, w))
    spec = plt.imshow(sh_preds)
    plt.savefig('image.png', bbox_inches='tight', pad_inches=0)
    img_id = upload('image.png')

    return img_id

if __name__ == "__main__":
    app.run(port=8922, debug=True)
