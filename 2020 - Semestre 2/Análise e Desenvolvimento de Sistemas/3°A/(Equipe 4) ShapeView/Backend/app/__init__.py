import os
from flask import Flask
from flask_cors import CORS

basedir = os.path.abspath(os.path.dirname(__file__))

app = Flask(__name__)
CORS(app)


from app import views
