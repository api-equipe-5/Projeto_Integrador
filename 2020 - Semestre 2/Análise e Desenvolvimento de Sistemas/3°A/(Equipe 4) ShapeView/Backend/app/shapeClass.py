import postgresql
import psycopg2
import geopandas as gpd
from sqlalchemy import create_engine
import fiona

class ShapeClass():
    def __init__(self):
        self.isConnected = False
        pass

    def conect(self, host, port, database, user, password): ## CONECTION DB
        try:
            self.connector = psycopg2.connect(host=f"{host}",port=f"{port}",database=f"{database}",
            user=f"{user}",password=f"{password}")
            self.cur = self.connector.cursor()
            self.cur.execute("SELECT version();")
            record = self.cur.fetchone()
            print("You are connected to - ", record,"\n")
            return True
        except:
            return False
    
    def getTablesDB(self): ## TABLE NAMES DB
        sql = ("SELECT table_name FROM information_schema.tables WHERE table_schema='public'")
        self.cur.execute(sql)
        tables = self.cur.fetchall()
        self.tablesDB = []
        removeTables = ["geography_columns", "geometry_columns", "spatial_ref_sys"]
        for table in tables:
            if table[0] not in removeTables:
                self.tablesDB.extend(table)
        return self.tablesDB

    def getColumns(self, tableName): ## COLUMN NAMES DB
        for i in self.tablesDB:
            sqlColumns = (f"SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = '{tableName}'")
            self.cur.execute(sqlColumns)
            columns = self.cur.fetchall()

            self.columnsDB = []
            for column in columns:
                if column[0]:
                    self.columnsDB.extend(column)
            return self.columnsDB

    def upload_in_DB(self, tableName, shp_adress, list_columnsDB, list_columnsSHP): ## EXPORTING DATA TO DB
        self.shp = gpd.read_file(f'/home/mateus/Desktop/AGENCIA_NACIONAL_AGUAS/{shp_adress}')    
        columnsDB = str()
        columnsSHP = str()

        for content in list_columnsDB:
            if content == 'geom':
                columnsDB += str(content)
                break
            columnsDB += str(content) + ', '

        allRows = []
        for cont in range(0, len(self.shp['fid'])):
            for column in self.shp[list_columnsSHP]:
                if column in list_columnsSHP:
                    for row in self.shp[column]:
                        if row not in allRows:
                            allRows.append(row)
                            columnsSHP += f"'{row}'" + ', '
                            if row == 'Fim do Curso Dagua' or row == 'Inicio do Curso Dagua':
                                allRows.remove(row)
                            break

            columnsSHP = columnsSHP [:-2]
            sql = (f"INSERT INTO {tableName} ({columnsDB}) VALUES ({columnsSHP})")
            self.cur.execute(sql)
            self.connector.commit()
            print("sucess insert")
            columnsSHP = ''
        return 
    
    ## SPRINT 4 ##

    def importSHP_from_DB(self, tableName): ## DB DATA IMPORT
        sql = (f"select * from {tableName}")
        # engine = create_engine(f"postgresql://{user}:{password}@localhost:{port}/{database}")
        SHP = gpd.read_postgis(sql, self.connector, geom_col="geom",crs=None,index_col=None,coerce_float=True,parse_dates=None, params=None,chunksize=None)

        SHP.to_file(f'/home/mateus/Desktop/Shapefile tratado/{tableName}',driver='ESRI Shapefile', schema=None, index=None)
        return