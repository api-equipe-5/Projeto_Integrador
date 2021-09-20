from django import forms
from .models import tb_Projeto, tb_Tarefa, tb_Pessoa, tb_Dev_Trf


class PostProjeto(forms.ModelForm):
    class Meta:
        model = tb_Projeto
        fields = (
            'prj_nome',
            'prj_datainicio',
            'prj_prazoentrega',
            'prj_escopo',
            'prj_color'
        )


class PostTarefa(forms.ModelForm):
    class Meta:
        model = tb_Tarefa
        fields = (
            'trf_name',
            'trf_datainicial',
            'trf_datafinal',
            'trf_prazo',
            'trf_interdependencia',
            'trf_entregavel',
            'fk_prj_id'
        )


class PostPessoa(forms.ModelForm):
    class Meta:
        model = tb_Pessoa
        fields = (
            'pes_nome',
            'pes_contato'
        )


class PostDistr(forms.ModelForm):
    class Meta:
        model = tb_Dev_Trf
        fields = (
            'fk_pes_id',
            'fk_trf_id',
            'fk_prj_id'
        )