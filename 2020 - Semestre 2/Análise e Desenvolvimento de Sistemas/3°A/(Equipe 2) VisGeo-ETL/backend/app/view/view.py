#Python modules
import os
import zipfile

#Flask modules
from flask import request, redirect, url_for, render_template, json, Response, jsonify, send_file, send_from_directory
from werkzeug.utils import secure_filename

#Custom modules
from app import app
from app.domain.shape import Shapefile
from app.domain.table import Table
from app.domain.user import User
from app.infrastructure.shapefileRepository import ShapefileRepository

#Global variables
currentFileName = None
globalTableName = None
connections = dict()

# @app.route('/auth', methods=['GET', 'POST'])
# def auth():
#     global connection
#     global credentials
#     credentials = dict(request.json)
#     if connection.credentialsAreValid(credentials):
#         return json.dumps({"isConnected": True})
#     return json.dumps({"isConnected": False})

@app.route('/auth', methods=['GET', 'POST'])
def auth():
    credentials = dict(request.json)
    connections[request.json['token']] = ShapefileRepository()
    if connections[request.json['token']].credentialsAreValid(credentials):
        return json.dumps({"isConnected": True})
    return json.dumps({"isConnected": False})


UPLOAD_FOLDER = os.path.join(os.getcwd(), 'shapefiles')
@app.route('/uploads', methods=['POST'])
def upload():
    file = request.files['shapefiles']
    savePath = os.path.join(UPLOAD_FOLDER, secure_filename(file.filename))
    file.save(savePath)
    return Response(status=201)
    

@app.route('/getFieldsAndTables', methods=['POST'])
def fields():
    fileName = request.json['filename']
    shapefile = Shapefile(f'shapefiles/{fileName}.shp')
    return jsonify(fields = shapefile.getFields(),
                   tables = connections[request.json['token']].getTables())


@app.route('/columns/<tableName>', methods=['POST'])
def columns(tableName):
    return json.dumps(connections[request.json['token']].getColumnsNames(tableName))


@app.route('/save', methods=['POST'])
def save():
    selectedFields = request.json["message"]
    fileName = request.json['filename']
    tableName = request.json['tableName']
    shapefile = Shapefile(f'shapefiles/{fileName}.shp')
    shapefile.format(selectedFields)
    returnedMessage = connections[request.json['token']].shpToPostgis(shapefile.DataDrame, connections[request.json['token']].getColumnsNames(tableName), tableName)
    return jsonify(message = returnedMessage)


@app.route('/searchTables', methods=['POST'])
def searchTables():
    return jsonify(connections[request.json['token']].getTables())


DOWNLOAD_FOLDER = os.path.join(os.getcwd(), 'download')
@app.route('/recoverFile/', methods = ["GET", "POST"])
def recoverFile():
    tableName = request.json["selectedTable"]
    selectedTable = Table(tableName, connections[request.json['token']].connector)
    try:
        selectedTable.extractShapefile(tableName, DOWNLOAD_FOLDER)
    except ValueError as erro:
        return erro + " - Shapefile vazio"
    #return redirect(f'/downloadFile/{tableName}')
    return Response(status=201)
    

@app.route('/downloadFile/<filename>', methods = ["GET", "POST"])
def download(filename):
    #filename = request.json["selectedTable"]
    downloadedFileName = f'{filename}.zip'
    downloadedFile = zipfile.ZipFile(f'{DOWNLOAD_FOLDER}/' + downloadedFileName, 'w')
    extensions = [".shp", ".shx", ".dbf", ".cpg", ".qix", ".prj"]
    for extension in extensions:
        try:
            downloadedFile.write(f'download/{filename}/' + filename + extension, arcname = filename + extension)
        except:
            pass
    
    downloadedFile.close()
    return send_from_directory(directory = DOWNLOAD_FOLDER, filename = downloadedFileName)


@app.route('/saveDirectly', methods = ['POST'])
def saveDirectly():
    filename = request.json["filename"]
    shapefile = Shapefile(f'shapefiles/{filename}.shp')
    connections[request.json['token']].saveDirectly(shapefile.DataDrame, filename)
    return Response(status = 201)
