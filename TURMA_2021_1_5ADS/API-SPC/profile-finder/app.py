"""
Script to configure DashBoard Profile Finder app to access the database

DBConnectionHandler : class to handle the conection to different databases

app: dash and flask configs


ToDO:
* 
"""
#############################
# #imports 
import dash
import dash_table
# import dash_auth
from dash.dependencies import Input, Output
import dash_bootstrap_components as dbc
import dash_core_components as dcc
import dash_html_components as html
import pandas as pd
import plotly.graph_objs as go
import pickle
# import psycopg2
import numpy as np
import dash_daq as daq


###################################

# class DBConnectionHandler(object):    
#     def __init__(self):
#         self.__connection = None
#         self.__infos = {
#             'Local_db': {'host': 'localhost', 'port': '5432', 'dbname': 'brow', 'user': 'postgres', 'password': '97235532'}
#         }
#         self.__actual_db = self.__infos["Local_db"]

#     def connect(self):
#         self.__connection = psycopg2.connect(**self.__actual_db)

#     def disconnect(self):
#         self.__connection.close()

#     def change_db(self, db_name):
#         self.__actual_db = self.__infos[db_name]

#     def cursor(self):
#         return self.__connection.cursor()

#     def connection(self):
#         return self.__connection

#####################################################
##################### app ###########################
#####################################################


# Creating the App
import flask
server = flask.Flask(__name__)



# VALID_USERNAME_PASSWORD_PAIRS = {
#     'hello': 'world'
# }

app = dash.Dash(__name__, server=server,prevent_initial_callbacks=True)
#app = dash.Dash(__name__, server=server,external_stylesheets=external_stylesheets)
# auth = dash_auth.BasicAuth(
#     app,
#     VALID_USERNAME_PASSWORD_PAIRS
# )

app.config['suppress_callback_exceptions']=True
#app.scripts.config.serve_locally=True
app.title = "ProfileFinder"


#################################################
############# Global variables ##################
#################################################
#db_handler = DBConnectionHandler()
#db_handler.connect()
profileFinder_color ='#0076C6'

########## #Init data ##########

# main_table.py

