from django.urls import path
from . import views


app_name = 'page'


urlpatterns = [
    path('aboutus/', views.aboutUs, name='aboutUs'),
    path('linkedin/', views.linkedIn, name='linkedIn'),
    path('facebook/', views.facebook, name='facebook'),
    path('instagram/', views.instagram, name='instagram'),
    path('twitter/', views.twitter, name='twitter'),
]