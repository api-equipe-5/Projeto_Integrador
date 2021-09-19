# -*- coding: utf-8 -*-
from core import menu_mixin
from tools.views import base as tools_views
from django.shortcuts import get_object_or_404
from django.http import JsonResponse
from vagas.forms import (VagaForm, VagaSearchForm,
                         CompetenciaForm, CompetenciaSearchForm,
                         CandidatoForm, CandidatoSearchForm,
                         HabilidadeSearchForm, HabilidadeForm,
                         VagaCandidatoSearchForm)
from vagas.models import (Vaga, Competencia, Candidato, Habilidade)
from datetime import date, datetime
from django.shortcuts import redirect


class VagaListView(
    menu_mixin.ProjetoMenuMixin,
    tools_views.BaseListView
):
    filter_by_user = False
    permission_required = []
    form_class = VagaSearchForm
    current_section = 'vagas'
    sub_current_section = 'vagas'

class VagaCandidatoListView(
    menu_mixin.ProjetoMenuMixin,
    tools_views.BaseListView
):
    filter_by_user = False
    permission_required = ''
    form_class = VagaCandidatoSearchForm
    current_section = 'vagas'
    sub_current_section = 'vagas'

class VagaCreateView(
    menu_mixin.ProjetoMenuMixin,
    tools_views.BaseCreateView
):
    filter_by_user = False
    permission_required = ''
    current_section = 'vagas'
    sub_current_section = 'vagas'
    model = Vaga
    form_class = VagaForm


class VagaUpdateView(
    menu_mixin.ProjetoMenuMixin,
    tools_views.BaseUpdateView
):
    filter_by_user = False
    detail_url = False
    permission_required = []
    current_section = 'vagas'
    sub_current_section = 'vagas'
    model = Vaga
    form_class = VagaForm

    def get_form(self, form_class=None):
        form = super().get_form(form_class)
        form['candidato'].field.choices = {}
        return form

class CompetenciaListView(
    menu_mixin.ProjetoMenuMixin,
    tools_views.BaseListView
):
    filter_by_user = False
    permission_required = ''
    form_class = CompetenciaSearchForm
    current_section = 'skills'
    sub_current_section = 'competencias'


class CompetenciaCreateView(
    menu_mixin.ProjetoMenuMixin,
    tools_views.BaseCreateView
):
    filter_by_user = False
    permission_required = ''
    current_section = 'skills'
    sub_current_section = 'competencias'
    model = Competencia
    form_class = CompetenciaForm


class CompetenciaUpdateView(
    menu_mixin.ProjetoMenuMixin,
    tools_views.BaseUpdateView
):
    filter_by_user = False
    detail_url = False
    permission_required = ''
    current_section = 'skills'
    sub_current_section = 'competencias'
    model = Competencia
    form_class = CompetenciaForm


class CandidatoListView(
    menu_mixin.ProjetoMenuMixin,
    tools_views.BaseListView
):
    filter_by_user = False
    permission_required = ''
    form_class = CandidatoSearchForm
    current_section = 'vagas'
    sub_current_section = 'candidatos'


class CandidatoCreateView(
    menu_mixin.ProjetoMenuMixin,
    tools_views.BaseCreateView
):
    filter_by_user = False
    permission_required = []
    current_section = 'vagas'
    sub_current_section = 'candidatos'
    model = Candidato
    form_class = CandidatoForm


class CandidatoUpdateView(
    menu_mixin.ProjetoMenuMixin,
    tools_views.BaseUpdateView
):
    filter_by_user = False
    detail_url = False
    permission_required = []
    current_section = 'vagas'
    sub_current_section = 'candidatos'
    model = Candidato
    form_class = CandidatoForm


class HabilidadeListView(
    menu_mixin.ProjetoMenuMixin,
    tools_views.BaseListView
):
    filter_by_user = False
    permission_required = ''
    form_class = HabilidadeSearchForm
    current_section = 'skills'
    sub_current_section = 'habilidades'


class HabilidadeCreateView(
    menu_mixin.ProjetoMenuMixin,
    tools_views.BaseCreateView
):
    filter_by_user = False
    permission_required = ''
    current_section = 'skills'
    sub_current_section = 'habilidades'
    model = Habilidade
    form_class = HabilidadeForm


class HabilidadeUpdateView(
    menu_mixin.ProjetoMenuMixin,
    tools_views.BaseUpdateView
):
    filter_by_user = False
    detail_url = False
    permission_required = ''
    current_section = 'skills'
    sub_current_section = 'habilidades'
    model = Habilidade
    form_class = HabilidadeForm
