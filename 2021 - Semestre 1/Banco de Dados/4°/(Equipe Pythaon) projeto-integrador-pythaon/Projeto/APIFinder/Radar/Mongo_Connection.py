import pymongo
from pymongo import MongoClient
from .Finder import *

class Mongo_Connection:

    db_instance = None
    collection = None

    def init(self):
        self.db_instance = self.create_connection()
        self.collection = self.get_collection()

    def create_connection(self):
        return pymongo.MongoClient(
            "mongodb+srv://dbUser:system@cluster0.5hlez.mongodb.net/Finder?retryWrites=true&w=majority")

    def get_collection(self):
        return self.db_instance.Finder.curriculo

    def find_curriculos(self, requisitos):
        return self.collection.find({"nome": requisitos})#{'score' : { '$meta' : "textScore" }}).sort([('score' , { '$meta' : "textScore" }),('created_time' , 1 )])#


#db.system.namespace.find( { name: 'test.' + collName } ); encontrar uma coleção