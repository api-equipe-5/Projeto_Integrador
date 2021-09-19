from django import forms
from tools import forms as tools_forms
from vagas.models import (Vaga, Competencia, Candidato, Habilidade, Beneficio)
from vagas.choices import (CATEGORIAS, HORARIO_TRAB, ESTADOS)
from django_select2.forms import ModelSelect2MultipleWidget


class VagaSearchForm(tools_forms.BaseSearchForm):
    class Meta:
        base_qs = Vaga.objects.filter()
        search_fields = [
            'nome_vaga',
            'id_vaga',
        ]


class VagaCandidatoSearchForm(tools_forms.BaseSearchForm):
    class Meta:
        base_qs = Vaga.objects.filter()
        search_fields = [
            'candidato',
        ]

class VagaForm(
    forms.ModelForm
):

    beneficios = forms.ModelMultipleChoiceField(
        queryset=Beneficio.objects.all(),
        required=True,
        widget=ModelSelect2MultipleWidget(
            model=Beneficio,
            search_fields=[
                'nome__icontains',
            ]
        )
    )

    competencia = forms.ModelMultipleChoiceField(
        queryset=Competencia.objects.all(),
        required=True,
        widget=ModelSelect2MultipleWidget(
            model=Competencia,
            search_fields=[
                'nome__icontains',
            ]
        )
    )

    candidato = forms.ModelMultipleChoiceField(
        queryset=Candidato.objects.all(),
        required=False,
        widget=ModelSelect2MultipleWidget(
            model=Candidato,
            search_fields=[
                'nome__icontains',
                'cpf__icontains'
            ]
        )
    )

    def get_competencia(self):
        return [label for value, label in self.fields['competencia'].choices if value in self['competencia'].value()]

    def get_cidade(self):
        num_cidade = self["cidade"].value()
        return self.get_value_on_choice_list(num_cidade, ESTADOS)

    def get_categoria(self):
        num_categoria = self["categoria"].value()
        return self.get_value_on_choice_list(num_categoria, CATEGORIAS)

    def get_horario_trab(self):
        num_horario_trab = self["horario_trab"].value()
        return self.get_value_on_choice_list(num_horario_trab, HORARIO_TRAB)

    def get_value_on_choice_list(self, number, choice_list):
        for index, choice in choice_list:
            if index == number:
                return choice
        return None


    class Meta:
        model = Vaga
        fields = [
            'id_vaga',
            'nome_vaga',
            'qtd_vaga',
            'categoria',
            'cidade',
            'beneficios',
            'competencia',
            'horario_trab',
            'descricao',
            'exp_requerida',
            'status',
            'candidato',
        ]

    def __init__(self, *args, **kwargs):
        super(VagaForm, self).__init__(*args, **kwargs)
        self.fields['id_vaga'].widget.attrs['placeholder'] = '2020/001'


class CompetenciaSearchForm(tools_forms.BaseSearchForm):
    class Meta:
        base_qs = Competencia.objects.filter()
        search_fields = [
            'nome__icontains',
            'nivel_icontains',
        ]


class CompetenciaForm(
    forms.ModelForm
):

    class Meta:
        model = Competencia
        fields = [
            'nome',
            'nivel'
        ]


class CandidatoSearchForm(tools_forms.BaseSearchForm):
    class Meta:
        base_qs = Candidato.objects.filter()
        search_fields = [
            'nome__icontains',
            'cpf__icontains',
        ]


class CandidatoForm(
    forms.ModelForm
):

    class Meta:
        model = Candidato
        fields = [
            'nome',
            'sexo',
            'email',
            'cpf',
            'ddd',
            'celular',
            'ddd2',
            'telefone',
            'rua',
            'bairro',
            'cidade',
            'numero_end',
            'complemento',
            'estado',
            'curriculo',
            'habilidades',
            'observacoes'
        ]


class HabilidadeSearchForm(tools_forms.BaseSearchForm):
    class Meta:
        base_qs = Habilidade.objects.filter()
        search_fields = [
            'nome__icontains',
        ]


class HabilidadeForm(
    forms.ModelForm
):

    class Meta:
        model = Habilidade
        fields = [
            'nome',
            'tipo'
        ]
