from .Mongo_Connection import *

class Finder:

    db_instance = None

    def init(self):
        self.db_instance = Mongo_Connection()

    def search(self, requisitos):
        results = self.db_instance.find_curriculos(requisitos)
        if results.count() == 0:
            print("Nenhum curriculo encontrado...")
        else:
            print("Database response...")
        return results