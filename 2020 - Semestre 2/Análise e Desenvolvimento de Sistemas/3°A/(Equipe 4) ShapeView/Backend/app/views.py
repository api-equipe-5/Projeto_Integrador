import os
import matplotlib.pyplot as plt
import geopandas as gpd

from flask import request, Response, redirect, url_for, render_template,json,jsonify
from werkzeug.utils import secure_filename
from flask_cors import CORS, cross_origin

from app import app
CORS(app)

from app.shapeClass import ShapeClass
from app.dom.shp import Shp
from app.dom.geometric import geometricForm

#GLOBAL
con = ShapeClass()
shapefile = dict()
host = str()
port = str()
database = str()
user = str()
password = str()
file = str()


@app.route('/con', methods=['GET', 'POST']) ## CONECTION DB
@cross_origin(supports_credentials=True)
def conn():
    global con
    global host 
    global port 
    global database
    global user
    global password

    host = request.json["host"]
    port = request.json["port"]
    database = request.json["database"]
    user = request.json["user"]
    password = request.json["password"]
    
    connect = con.conect( host, port, database, user, password)
    if connect:
        return json.dumps({"isConnected": True})
    return json.dumps({"isConnected": False})


@app.route('/getTablesDB', methods=['GET']) ## TABLE NAMES DB
@cross_origin(supports_credentials=True)
def tablesDB():
    return jsonify(tablesDB = con.getTablesDB())


@app.route('/getColumnsDB', methods=['POST']) ## COLUMN NAMES DB
@cross_origin(supports_credentials=True)
def columnsDB():
    tableName = str(request.json['tableName'])
    return jsonify(ColumnsDB = con.getColumns(tableName))


@app.route('/getColumns', methods=['POST']) ## COLUMN NAMES SHAPEFILE
@cross_origin(supports_credentials=True)
def column():
    global file
    file = str(request.json['shapefile'])
    shapefile = Shp(file)
    
    return jsonify(columns = shapefile.getColumns())



@app.route('/upload', methods=['GET', 'POST']) ## EXPORTING DATA TO DB
@cross_origin(supports_credentials=True)
def upload():
    tableName = request.json["tableName"]
    shp_adress = request.json["shp_adress"]
    list_columnsDB = request.json["list_columnsDB"]
    list_columnsSHP = request.json["list_columnsSHP"]

    return jsonify(upload = con.upload_in_DB(tableName, shp_adress, list_columnsDB, list_columnsSHP))

##SPRINT 4##

@app.route('/getGeometric', methods=['POST']) ## DISPLAY OF GEOMETRIC SHAPES FOR THE USER
@cross_origin(supports_credentials=True)
def geometric():
    form = request.json['geom']
    geometricForm(form)

    return Response(status = 201)

@app.route('/import', methods=['POST']) ## DB DATA IMPORT
@cross_origin(supports_credentials=True)
def importSHP():
    table = request.json['table']
    con.importSHP_from_DB(table)

    return Response(status = 201)

