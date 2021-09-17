from flask import request, jsonify
from controller import predict as predictController, mask as maskController


def router(app):
    @app.route('/', methods=['GET'])
    def index():
        return jsonify({"name": "IA TALHAO"})

    @app.route('/predict', methods=['POST'])
    def predict():
        return predictController.predict(request)

    @app.route('/generate-mask', methods=['POST'])
    def generateMask():
        return maskController.mask(request)
