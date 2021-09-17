from django.shortcuts import render
from django.views.generic import TemplateView
from django.contrib.auth import views as auth_views
from django.urls import path
from django.urls import reverse_lazy
# from allauth import templates

class IndexView(TemplateView):
    template_name='index.html'

#class LoginView(TemplateView):
#    template_name = 'login.html'




