import json
import pymongo
import dns

from .Finder import *
from . import Vaga
from .VagaMethods import Vaga
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

class View:

   def createConnection():
      return pymongo.MongoClient("mongodb+srv://dbUser:system@cluster0.5hlez.mongodb.net/Finder?retryWrites=true&w=majority")

   @csrf_exempt
   def buscarvaga(request, pk):
      if request.method == "GET":
         return Vaga.buscarvaga(pk)
      else:
         return JsonResponse({"message": "Erro na requisição. Método esperado: GET."}, status=500)

   @csrf_exempt
   def insert_vaga(request):
      if request.method == "POST":
         return Vaga.insert_vaga(request)
      else:
         return JsonResponse({"message": "Erro na requisição. Método esperado: POST."}, status=500)

   @csrf_exempt
   def updatevaga(request, pk):
      if request.method == "PUT":
         return Vaga.updatevaga(pk, request)
      else:
         return JsonResponse({"message":"Erro na requisição. Método esperado: PUT."}, status=500)  

   @csrf_exempt
   def delete_vaga(request, pk):
      if request.method == "DELETE":
         return Vaga.delete_vaga(pk)
      else:
         return JsonResponse({"message":"Erro na requisição. Método esperado: DELETE."}, status=500) 

   @csrf_exempt
   def buscarCurriculo(request, pk):
      if request.method == 'GET':
         return Curriculo.buscarCurriculo(request, pk)
      else:
         return JsonResponse({"message": "Erro na requisição. Método esperado: GET."}, status=500)

   @csrf_exempt
   def cadastrarCurriculo(request):
      if request.method == "POST":
         return Curriculo.cadastrarCurriculo(request)
      else:
         return JsonResponse({"message":"Erro na requisição. Método esperado: POST."}, status=500) 

   @csrf_exempt
   def atualizarCurriculo(request, pk):
      if request.method == "PUT":
         return Curriculo.atualizarCurriculo(request, pk)
      else:
         return JsonResponse({"message":"Erro na requisição. Método esperado: PUT."}, status=500)   

   @csrf_exempt
   def deletarCurriculo(request, pk):
      if request.method == "DELETE":
         return Curriculo.deletarCurriculo(pk)
      else:
         return JsonResponse({"message" : "Erro na requisição. Método esperado: DELETE."}, status=500)   

   @csrf_exempt
   def buscarPorVaga(request,VagaID):
      if request.method == 'GET':
         return Vaga.buscarPorVaga(VagaID)

   @csrf_exempt
   def buscarPorVagaVT0(request,VagaID):
      if request.method == 'GET':
         return Vaga.buscarPorVagaVT0(VagaID)
      else:
         return JsonResponse({"message": "Erro na requisição. Método esperado: GET."}, status=500)

   @csrf_exempt
   def buscarPorVaga(request,VagaID):
      if request.method == 'GET':
         return Vaga.buscarPorVaga(VagaID)
      else:
         return JsonResponse({"message": "Erro na requisição. Método esperado: GET."}, status=500)
   
   @csrf_exempt
   def buscaFiltrada(request):
      if request.method == 'GET':
         return Vaga.buscaFiltrada(request)
