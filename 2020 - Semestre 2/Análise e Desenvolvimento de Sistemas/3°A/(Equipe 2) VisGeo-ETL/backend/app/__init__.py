import os
from flask import Flask
import shapefile
import postgresql
from flask_cors import CORS

#Getting the directory where the app is running
basedir = os.path.abspath(os.path.dirname(__file__))

app = Flask(__name__)
CORS(app)

from app.view import view
