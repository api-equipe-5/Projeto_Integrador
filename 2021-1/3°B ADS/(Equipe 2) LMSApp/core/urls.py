from django.urls import path
from django.contrib.auth import views as auth_views
from .views import IndexView#LoginView SignupView, LogoutView
from allauth import account
from allauth import socialaccount



urlpatterns=[
    path('', IndexView.as_view(), name='index'),


    #path('', SignupView.as_view(), name='signup'),
   #path('', LogoutView.as_view(), name='logout'),
]

