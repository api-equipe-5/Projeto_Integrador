import geopandas as gpd 

class Table():

    def __init__(self, tableName, connector):
        self.name = tableName
        self.connector = connector
        query = f'SELECT * FROM {self.name}'
        self.dataFrame = gpd.GeoDataFrame.from_postgis(query, self.connector)
    

    def extractShapefile(self, tableName, downloadFolder, enc = "UTF-8"):
        self.dataFrame.to_file(f'/{downloadFolder}/{tableName}', enconding = enc)
        return self.name


