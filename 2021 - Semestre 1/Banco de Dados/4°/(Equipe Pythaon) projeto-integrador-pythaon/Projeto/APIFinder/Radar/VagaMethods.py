import json
import pymongo
import dns

from .Finder import *
from . import Vaga
from .CurriculoMethods import Curriculo
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

class Vaga:

   def createConnection():
      return pymongo.MongoClient("mongodb+srv://dbUser:system@cluster0.5hlez.mongodb.net/Finder?retryWrites=true&w=majority")

   @csrf_exempt
   def buscarPorVagaVT0(VagaID):
      client = Vaga.createConnection()
      db = client["Finder"]
      vaga = db["vagas"]
      curriculos = db["Inscrito"]
      vaga = vaga.find_one({"VagaIdExterno" : VagaID})  
      query = { 
         "$or" : [
         {"coordenadas": {"$near": {"$maxDistance": 3000, "$geometry":{"type": "Point", "coordinates":[vaga['coordenadas']['coordinates'][0], vaga['coordenadas']['coordinates'][1]]}}}}
         ]
      }
      result_curriculos = curriculos.find(query)
      if result_curriculos:
         IdCol = [str(result['_id']) for result in result_curriculos]
         IdExterno = [str(result['InscritoIdExterno']) for result in result_curriculos]
         return JsonResponse({
                     "candidatos" : IdCol,
                     "IdExterno" : IdExterno,
                     "message" : ""
                     })
      else:
         return JsonResponse({
                     "candidatos" : [],
                     "message" : "Nenhum candidato encontrado para esta vaga."
                     }, status=200)
   @csrf_exempt
   def buscarPorVaga(VagaID):
      # Inicia conexão com o banco
      client = Vaga.createConnection()

      mydb = client["Finder"]
      curriculos = mydb["Inscrito"]
      vagas = mydb["vagas"]

         # Recupera a vaga recebida por parâmetro
      vaga = vagas.find_one({"VagaIdExterno" : VagaID})

      if vaga:
         searchRequisitos = '|'.join([str(requisito['descricao']) for requisito in vaga['competencia']])

         query = {
               "$or" : [ 
                  # { "tipoContratoDesejadoInscrito" : { "$regex": vaga['tipoContratacaoPerfilVaga'] } },
                  { "perfilProfissionalTituloInscrito" : { "$regex":searchRequisitos } },
                  { "perfilProfissionalDescricaoInscrito" : { "$regex": searchRequisitos } },
                  { "experienciaProfissional.descricao": { "$regex": searchRequisitos } },
                  { "formacao.curso": { "$regex": searchRequisitos } },
                  { "competencia.descricao": { "$regex": searchRequisitos } } 
               ] 
         }

         result_curriculos = curriculos.find(query)
         IdCol = [str(result['_id']) for result in result_curriculos]
      
      return IdCol
   
   @csrf_exempt
   def buscaFiltrada(request):
      client = Vaga.createConnection()
      mydb = client["Finder"]
      curriculos = mydb["Inscrito"]
      parametros = json.loads(request.body)
      query = {}
         
      try:
         for item in parametros:
            if isinstance(item, dict):
               if item['tipo'] == 'texto':
                  if isinstance(item['valor'], list): query[item['chave']] = { "$regex": '(?i)' + '|'.join([str(requisito) for requisito in item['valor']])  }
                  else: query[item['chave']] = { "$regex": '(?i)' + item['valor'] }
               elif item['tipo'] == 'distancia': 
                  query[item['chave']] = {
                           "$near" : {
                              "$geometry"    : { "type": "Point",  "coordinates": item['valor'] },
                              "$minDistance" : item['mindist'],
                              "$maxDistance" : item['maxdist']
                           }
                  }
               elif item['tipo'] == 'data':
                  if 'eq'  in item: query[item['chave']] = { "$eq" : item['eq'] }
                  if 'ne'  in item: query[item['chave']] = { "$ne" : item['ne'] }
                  if 'gt'  in item: query[item['chave']] = { "$gt" : item['gt'] }
                  if 'gte' in item: query[item['chave']] = { "$gte" : item['gte'] }
                  if 'lt'  in item: query[item['chave']] = { "$lt" : item['lt'] }
                  if 'lte' in item: query[item['chave']] = { "$lte" : item['lte'] }
                     # if 'in'  in item: query[item['chave']] = { "$in" : item['in'] }
                     # if 'nin' in item: query[item['chave']] = { "$nin" : item['nin'] } 
            else:
               return JsonResponse({"message": "Parâmetros inválidos."}, status=500)
         print(query)
         data = time.time()
         curriculos = curriculos.find(query)
         print("Tempo de execução: ",time.time() - data)
      except:
         return JsonResponse({"message": "Erro ao gerar a busca. Os parâmetros enviados contém erros."}, status=500)
         
      return JsonResponse(json.loads(dumps(curriculos)), safe=False)
   
   @csrf_exempt
   def buscarPorVaga(VagaID):
      # Inicia conexão com o banco
      client = Vaga.createConnection()

      mydb = client["Finder"]
      curriculos = mydb["Inscrito"]
      vagas = mydb["vagas"]

      # Recupera a vaga recebida por parâmetro
      vaga = vagas.find_one({"VagaIdExterno" : VagaID})

      if vaga:
         searchRequisitos = '|'.join([str(requisito['descricao']) for requisito in vaga['competencia']])

         query = {
               "$or" : [ 
                  # { "tipoContratoDesejadoInscrito" : { "$regex": vaga['tipoContratacaoPerfilVaga'] } },
                  { "perfilProfissionalTituloInscrito" : { "$regex":searchRequisitos } },
                  { "perfilProfissionalDescricaoInscrito" : { "$regex": searchRequisitos } },
                  { "experienciaProfissional.descricao": { "$regex": searchRequisitos } },
                  { "formacao.curso": { "$regex": searchRequisitos } },
                  { "competencia.descricao": { "$regex": searchRequisitos } } 
               ] 
         }

         result_curriculos = curriculos.find(query)

         if result_curriculos:
            IdCol = [str(result['_id']) for result in result_curriculos]

            Curriculo.UpdateListCurriculos(IdCol, VagaID)
            return JsonResponse({
                                 "candidatos" : IdCol,
                                 "message" : ""
                              })
         else:
            return JsonResponse({
                                 "candidatos" : [],
                                 "message" : "Nenhum candidato encontrado para esta vaga."
                              }, status=200)
      else:
         return JsonResponse({"message" : "Vaga não encontrada"}, status=200)
   
   @csrf_exempt
   def delete_vaga(pk):
      client = Vaga.createConnection()
      db = client["Finder"]
      col = db["vagas"]

      result = col.delete_many({"VagaIdExterno": pk})
      # result
      return JsonResponse({"message":"Vaga excluida com sucesso."}, status=200)
   
   @csrf_exempt
   def updatevaga(pk, request):
      client = Vaga.createConnection()
      db = client["Finder"]
      col = db["vagas"]

      result = col.update_one({"VagaIdExterno" : pk}, json.loads(request.body))

      Observer.notifyObserver(pk)

      # result
      return JsonResponse({"message":"Vaga atualizada com sucesso."}, status=200)
   
   @csrf_exempt
   def insert_vaga(request):
      client = Vaga.createConnection()
      db = client["Finder"]
      col = db["vagas"]
      vaga = json.loads(request.body)
      result = col.insert_one(vaga)

      IdVaga = vaga.get("VagaIdExterno")

      Observer.registerObserver(IdVaga)

      return JsonResponse({"message" : "Vaga cadastrada com sucesso."}, status=200)
   
   @csrf_exempt
   def buscarvaga(request, pk):
      client = Vaga.createConnection()
      db = client["Finder"]
      col = db["vagas"]
   
      vaga = col.find_one({"VagaIdExterno" : pk})
         
      if vaga:
         return JsonResponse(dumps(vaga), safe=False)
      else:
         return JsonResponse({"message" : "Vaga não encontrada."}, status=200)
      
   @csrf_exempt
   def buscarPorVagaEX(request,VagaID):
      if request.method == 'GET':
            # Inicia conexão com o banco
         client = Vaga.createConnection()

         mydb = client["test"]
         curriculos = mydb["Inscrito"]
         vagas = mydb["vagas"]

         # Recupera a vaga recebida por parâmetro
         vaga = vagas.find_one({"VagaIdExterno" : VagaID})

         if vaga:
            
            searchRequisitos =  ' '.join([str(requisito['descricao']) for requisito in vaga['competencia']])
            searchRequisitos += ' ' + ' '.join([str(requisito['DescricaoPalavraChave']) for requisito in vaga['PalavraChave']])
            searchRequisitos += ' ' + vaga['tituloVaga']

            # result_curriculos = curriculos.find(
            #    { 
            #       "$text": { "$search": searchRequisitos } 
            #    },
            #    { 
            #       "score" : { "$meta" : "textScore" }
            #    }  
            # ).limit(10)
            
            result_curriculos = curriculos.find(
                  { "$text": { "$search": searchRequisitos } },
                  { "score" : { "$meta" : "textScore" } }  
            ).limit(10)
            
            if result_curriculos:
               IdCol = [str(result['_id']) for result in result_curriculos]
               
               if 'ValeTransporte' in vaga:
                  result_curriculos = curriculos.find(
                     {"coordenadas": {"$near": {"$maxDistance": 3333, "$geometry":{"type": "Point", "coordinates":[
                                                            vaga['coordenadas']['coordinates'][0],
                                                            vaga['coordenadas']['coordinates'][1]
                                                         ]}}}}
                  )
                  IdCol = [str(result['_id']) for result in result_curriculos]
               
               return JsonResponse({
                                    "candidatos" : IdCol,
                                    "message" : ""
                                 })
            else:
                  return JsonResponse({
                                       "candidatos" : [],
                                       "message" : "Nenhum candidato encontrado para esta vaga."
                                    }, status=200)
         else:
            return JsonResponse({"message" : "Vaga não encontrada"}, status=200)
      else:
         return JsonResponse({"message": "Erro na requisição. Método esperado: GET."}, status=500)