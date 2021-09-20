from django.urls import path
from . import views

app_name = 'perfil'

urlpatterns = [
    path('', views.Criar.as_view(), name='criar'),
    path('atualizar1/', views.Atualizar1.as_view(), name='atualizar1'),
    path('login/', views.Login.as_view(), name='login'),
    path('logout/', views.Logout.as_view(), name='logout'),
    path('atualizar/', views.atualizar, name='atualizar'),
    path('contato/', views.Contato, name='contato'),
    path('relatorio/', views.Relatorio, name='relatorio'),
    path('interface/', views.Interface, name='interface'),
    path('meus_pedidos/', views.Meus_pedidos, name='meus_pedidos'),
    path('interface2/', views.Interface2, name='interface2')
]
