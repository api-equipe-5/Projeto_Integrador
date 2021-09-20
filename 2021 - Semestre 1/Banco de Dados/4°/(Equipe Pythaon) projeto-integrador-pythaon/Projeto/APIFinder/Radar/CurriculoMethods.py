import json
import pymongo
import dns

from .Finder import *
from . import Vaga
from .Vaga import Observer
import time

from pymongo import MongoClient

from django.shortcuts import render
from django.http import HttpResponse
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt

from bson import ObjectId
from bson.json_util import dumps
from bson.objectid import ObjectId

class Curriculo:

   def createConnection():
      return pymongo.MongoClient("mongodb+srv://dbUser:system@cluster0.5hlez.mongodb.net/Finder?retryWrites=true&w=majority")

   @csrf_exempt
   def cadastrarCurriculo(request):
      client = Vaga.createConnection()         
      db = client["Finder"]
      col = db["Inscrito"]

      result = col.insert_one(json.loads(request.body))
         
         # result
      return JsonResponse({"message":"Curriculo inserido com sucesso."}, status=200)

   @csrf_exempt
   def atualizarCurriculo(request, pk):
      client = Vaga.createConnection()
      db = client["Finder"]
      col = db["Inscrito"]

      result = col.update_one({"InscritoIdExterno" : pk}, json.loads(request.body))
         # result
      return JsonResponse({"message":"Curriculo atualizado com sucesso."}, status=200)

   @csrf_exempt
   def deletarCurriculo(pk):
      client = Vaga.createConnection()
      db = client["Finder"]
      col = db["Inscrito"]

      result = col.delete_many({"InscritoIdExterno" : pk})
      # result
      return JsonResponse({"message" : "Curriculo excluido com sucesso."}, status=200)

   @csrf_exempt
   def buscarCurriculo(request, pk):
      client = Vaga.createConnection()
      db = client["Finder"]
      curriculos = db["Inscrito"]

      curriculo = curriculos.find_one({ "InscritoIdExterno": pk })

      if curriculo:
         return JsonResponse(dumps(curriculo), safe=False)
      else:
         return JsonResponse({"message" : "Curriculo não encontrado."}, status=200)

   def UpdateListCurriculos(IdCol, pk):
      client = Vaga.createConnection()
      db = client["Finder"]
      col = db["vagas"]

      query = { "$set": { "IncritoIdSelecionado": IdCol }}

      result = col.update_one({"VagaIdExterno" : pk}, query)
      # result
      return JsonResponse({"message":"Lista de curriculos selecionados atualizada com sucesso."}, status=200)

   def CurriculosList(VagaID):
      client = Vaga.createConnection()

      mydb = client["Finder"]
      curriculos = mydb["Inscrito"]
      vagas = mydb["vagas"]

      # Recupera a vaga recebida por parâmetro
      vaga = vagas.find_one({"VagaIdExterno" : VagaID})

      if vaga:

         searchRequisitos =  ' '.join([str(requisito['descricao']) for requisito in vaga['competencia']])
         searchRequisitos += ' ' + ' '.join([str(requisito['DescricaoPalavraChave']) for requisito in vaga['PalavraChave']])
         searchRequisitos += ' ' + vaga['tituloVaga']
         
         result_curriculos = curriculos.find(
                  { "$text": { "$search": searchRequisitos } },
                  { "score" : { "$meta" : "textScore" } }).limit(10)
         
         IdCol = [str(result['_id']) for result in result_curriculos]
         
         if 'ValeTransporte' in vaga:
            result_curriculos = curriculos.find(
               {"coordenadas": {"$near": {"$maxDistance": 3000, "$geometry":{"type": "Point", "coordinates":[
                                                      vaga['coordenadas']['coordinates'][0],
                                                      vaga['coordenadas']['coordinates'][1]
                                                   ]}}}}
            )
            IdCol = [str(result['_id']) for result in result_curriculos]
         
         # result_curriculos = curriculos.find(query)
         IdCol = [str(result['_id']) for result in result_curriculos]
     
      return IdCol
   
   