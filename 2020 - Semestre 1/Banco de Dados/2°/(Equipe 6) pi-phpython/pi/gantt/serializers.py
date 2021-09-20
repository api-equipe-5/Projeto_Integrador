from .models import (
    tb_Projeto,
    tb_Tarefa,
    tb_Pessoa,
    tb_pes_Trf,
    tb_hab_pes,
    tb_habilidades,

)
from rest_framework import serializers


class ProjectSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = tb_Projeto
        fields = (
            'prj_id',
            'prj_nome',
            'prj_datainicio',
            'prj_prazoentrega',
            'prj_escopo',
            'prj_color',
            'prj_cost',
            'prj_hrs_dev',
            'prj_progresso'
        )


class TaskSerializer(serializers.ModelSerializer):
    class Meta:
        model = tb_Tarefa
        fields = (
            'trf_id',
            'trf_name',
            'trf_datainicial',
            'trf_datafinal',
            'trf_prazo',
            'trf_interdependencia',
            'trf_entregavel',
            'trf_progresso',

            'fk_prj_id'
        )


class PersonSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = tb_Pessoa
        fields = (
            'pes_id',
            'pes_nome',
            'pes_contato',
            'pes_salario',
            'pes_faltas',
            'pes_hrs_disponivel'
        )


class DistributeSerializer(serializers.ModelSerializer):
    class Meta:
        model = tb_pes_Trf
        fields = (
            'pes_trf_id',
            'fk_pes_id',
            'fk_trf_id',
        )


class HabilidadeDistSerializer(serializers.ModelSerializer):
    class Meta:
        model = tb_hab_pes
        fields = (
            'pes_hab_id',
            'fk_pes_id',
            'fk_hab_id'
        )


class HabilidadeSerializer(serializers.ModelSerializer):
    class Meta:
        model = tb_habilidades
        fields = (
            'hab_id',
            'hab_nome'
        )


class HoursFreeSerializer(serializers.Serializer):
    pes_id = serializers.IntegerField()
    pessoa = serializers.CharField()
    horas_atribuidas = serializers.IntegerField()
    horas_totais = serializers.IntegerField()
    horas_restante = serializers.IntegerField()
    horas_totais_ano = serializers.IntegerField()
    horas_restante_ano = serializers.IntegerField()