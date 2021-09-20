from django.contrib import admin
from .models import tb_Tarefa, tb_Pessoa, tb_Projeto, tb_Dev_Trf, tb_pes_Trf
# Register your models here.


class TarefaAdmin(admin.ModelAdmin):
    list_display = [
        'trf_id',
        'trf_name',
        'trf_datainicial',
        'trf_datafinal',
        'trf_prazo',
        'trf_interdependencia',
        'trf_entregavel'
    ]
    search_fields = ['trf_id', 'trf_name']


class ProjetoAdmin(admin.ModelAdmin):
    list_display = [
        'prj_id',
        'prj_nome',
        'prj_escopo',
        'prj_datainicio',
        'prj_prazoentrega'
    ]
    search_fields = ['prj_id', 'prj_nome', 'prj_escopo']


class PessoaAdmin(admin.ModelAdmin):
    list_display = [
        'pes_id',
        'pes_nome',
        'pes_contato',
    ]
    search_fields = ['dev_nome']


admin.site.register(tb_Tarefa, TarefaAdmin)
admin.site.register(tb_Pessoa, PessoaAdmin)
admin.site.register(tb_Projeto, ProjetoAdmin)
admin.site.register(tb_Dev_Trf)
admin.site.register(tb_pes_Trf)


