from django.conf.urls import url, include
from django.contrib import admin
from rest_framework import routers
from . import views
admin.autodiscover()

router = routers.DefaultRouter()
router.register(r'project', views.ProjectsViewSet)
router.register(r'task', views.TaskViewSet)
router.register(r'person', views.PersonViewSet)
router.register(r'habilidades', views.HabilidadesViewSet)
router.register(r'distribute', views.DistributeViewSet)
router.register(r'distributehab', views.HabilidadeDistViewSet)
router.register(r'hoursfree', views.HoursFreeSet, basename='freehours')

urlpatterns = [
    url(r'request', views.index_page, name='home'),
    url(r'^$', views.index_page, name='home'),
    url(r'gantt', views.gantt, name='grafs'),



    # urls para inserção de projetos, pessoas, tarefas
    url(r'projeto/save', views.save_project, name='save_projeto'),
    url(r'tarefa/save', views.save_task, name='save_task'),
    url(r'person/save', views.save_person, name='save_person'),
    url(r'dist/save', views.save_dist, name='save_dist'),

    # apis para front

    url(r'^', include(router.urls)),
    url(r'^api-auth/', include('rest_framework.urls')),
]
