from . import views
import json

import pymongo

from bson import ObjectId
from bson.json_util import dumps
from bson.objectid import ObjectId
#from .views import View

class Observer:

	observers = []
	view_func = None

	# def __init__(self): #Construtor da classe.
	# 	self.observers = []
	# 	self.view_func = views.View()
        

	def registerObserver(IdVaga):
		views.View.CurriculosList(IdVaga)
		Observer.observers.append(IdVaga)
		print("Observer added!")

	def removeObserver(self, IDVaga):
		for x in self.observers:
			if(IDVaga == x):
				self.observers.remove(x)

	def notifyObserver(IdVaga):
		results = views.View.CurriculosList(IdVaga)
		Observer.UpdateObserver(IdVaga, results)
		print("Finished!")
 
	def UpdateObserver(IDVaga, results):
		views.View.UpdateListCurriculos(results, IDVaga)
		print("Função para add curriculo a collection")
		print(dumps(results))


