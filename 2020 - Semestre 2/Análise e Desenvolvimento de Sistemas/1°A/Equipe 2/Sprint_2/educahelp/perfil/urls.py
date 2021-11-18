from django.urls import path
from . import views

app_name = 'perfil'

urlpatterns = [
    path('', views.Criar.as_view(), name='criar'),
    path('atualizar1/', views.Atualizar1.as_view(), name='atualizar1'),
    path('login/', views.Login.as_view(), name='login'),
    path('logout/', views.Logout.as_view(), name='logout'),
    path('atualizar/', views.atualizar, name='atualizar'),
]
