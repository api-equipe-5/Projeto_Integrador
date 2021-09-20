import geopandas as gpd
import matplotlib as plt
from flask import json
import fiona 

class Shp():
    def __init__(self, Adress): 
        self.data = gpd.read_file(f'/home/mateus/Desktop/AGENCIA_NACIONAL_AGUAS/{Adress}')

    def getColumns(self): ## COLUMN NAMES SHAPEFILE
        self.array = []
        for column in self.data:
            self.array.append(column)
        return self.array


