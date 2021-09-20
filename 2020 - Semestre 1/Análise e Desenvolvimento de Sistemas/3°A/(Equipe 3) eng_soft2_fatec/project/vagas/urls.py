from django.urls import include, path
from vagas import views

urlpatterns = [
    path('vagas/', include([
        path(
            '',
            views.VagaListView.as_view(),
            name='vaga_list'
        ),
        path(
            'novo/',
            views.VagaCreateView.as_view(),
            name='vaga_form'
        ),
        path(
            'publico',
            views.VagaListView.as_view(),
            name='pub_vagas'
        ),
        # path(
        #     'json/',
        #     views.autofill_campos_ocupacaoimovel,
        #     name='resposta_json'
        # ),
        path(
            '<int:pk>/',
            views.VagaUpdateView.as_view(),
            name='vaga_form'
        )
    ])),
    path('competencias/', include([
        path(
            '',
            views.CompetenciaListView.as_view(),
            name='competencia_list'
        ),
        path(
            'novo/',
            views.CompetenciaCreateView.as_view(),
            name='competencia_form'
        ),
        path(
            '<int:pk>/',
            views.CompetenciaUpdateView.as_view(),
            name='competencia_form'
        ),
    ])),
    path('candidatos/', include([
        path(
            '',
            views.CandidatoListView.as_view(),
            name='candidato_list'
        ),
        path(
            'novo/',
            views.CandidatoCreateView.as_view(),
            name='candidato_form'
        ),
        path(
            'publico/novo/candidato',
            views.CandidatoCreateView.as_view(),
            name='pub_candidato_form'
        ),
        path(
            '<int:pk>/',
            views.CandidatoUpdateView.as_view(),
            name='candidato_form'
        ),
    ])),
    path('habilidades/', include([
        path(
            '',
            views.HabilidadeListView.as_view(),
            name='habilidade_list'
        ),
        path(
            'novo/',
            views.HabilidadeCreateView.as_view(),
            name='habilidade_form'
        ),
        path(
            '<int:pk>/',
            views.HabilidadeUpdateView.as_view(),
            name='habilidade_form'
        ),
    ])),
]
