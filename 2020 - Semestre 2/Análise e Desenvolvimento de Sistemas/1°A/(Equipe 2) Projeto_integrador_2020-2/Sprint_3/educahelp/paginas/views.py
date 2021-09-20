from django.shortcuts import render
from django.views import View



def aboutUs(request):
    return render(request, 'aboutus.html')


def linkedIn(request):
    return render(request, 'linkedin.html')

def facebook(request):
    return render(request, 'facebook.html')

def instagram(request):
    return render(request, 'Instagram.html')

def twitter(request):
    return render(request, 'twitter.html')

