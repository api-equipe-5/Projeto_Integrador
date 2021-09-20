from django.urls import path
from . import views
from . import VagaMethods

urlpatterns = [
    path('buscar_vaga/<str:pk>',views.View.buscarvaga),
    path('inserir_vaga',views.View.insert_vaga),
    path('atualizar_vaga/<str:pk>',views.View.updatevaga),
    path('excluir_vaga/<str:pk>',views.View.delete_vaga),
    path('buscar_curriculo/<str:pk>', views.View.buscarCurriculo),
    path('inserir_curriculo',views.View.cadastrarCurriculo),
    path('atualizar_curriculo/<str:pk>',views.View.atualizarCurriculo),
    path('excluir_curriculo/<str:pk>',views.View.deletarCurriculo),
    path('busca_VT0/<str:VagaID>',views.View.buscarPorVagaVT0),
    path('buscaPorVaga/<str:VagaID>',views.View.buscarPorVaga),
    path('buscaPorVagaEX/<str:VagaID>',VagaMethods.Vaga.buscarPorVagaEX),
]

