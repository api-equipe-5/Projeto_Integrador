class User():

    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.isConnected = False
        self.currentTable = None
        self.currentTable = None
        self.shapefile = None


    def setConnection(self, connection):
        self.connection = connection
        self.isConnected = True


    def setTable(self, tableName):
        self.currentTable = tableName
    

    def setShapefile(self, shapefile):
        self.shapefile = shapefile


    def disconnect(self):
        self.connection = None
        self.isConnected = False
    

    

    