import pandas as pd

# Importando os Dados

fatec_operacao = pd.read_excel("dados/alterados/fatec_opr.xlsx")

'''
fatec_movimento = pd.read_csv("../Dados/Complementares/fatec_mvt.csv", sep = '|', encoding='UTF-8', header = 1)
fatec_pagamento = pd.read_csv("../Dados/Complementares/fatec_pgt.csv", sep = '|', encoding='UTF-8', header = 1)

# Retirando as colunas desnecessárias

fatec_operacao_colunas = fatec_operacao.columns[1:len(fatec_operacao.columns) - 1]
fatec_movimento_colunas = fatec_movimento.columns[1:len(fatec_movimento.columns) - 1]
fatec_pagamento_colunas = fatec_pagamento.columns[1:len(fatec_pagamento.columns) - 1]

# Armazenando o nome de uma coluna de cada tabela numa váriavel

#coluna_fatec_operacao = fatec_operacao.columns[1]
coluna_fatec_movimento = fatec_movimento.columns[1]
coluna_fatec_pagamento = fatec_pagamento.columns[1]

# Armazenando o nome de uma coluna de cada tabela numa váriavel

fatec_operacao = pd.DataFrame(fatec_operacao, columns = fatec_operacao_colunas)
fatec_movimento = pd.DataFrame(fatec_movimento, columns = fatec_movimento_colunas)
fatec_pagamento = pd.DataFrame(fatec_pagamento, columns = fatec_pagamento_colunas)

# Redefinindo o nome de cada coluna

#fatec_operacao.columns = ['id_opr_cad_pos', 'doc_cli', 'tip_cli', 'qtd_pcl', 'dat_vct_ult_pcl', 'vlr_ctrd_fta_tfm', 'sdo_ddr_tfm', 'vlr_ctrd', 'id_ult_rss_opr', 'id_mdl', 'cod_mdl', 'id_fnt']
fatec_movimento.columns = ['id_opr_cad_pos', 'id_mvt_cad_pos', 'dat_vct', 'qtd_pcl_vnc', 'qtd_pcl_pgr', 'vlr_tot_fat_tfm',	'vlr_min_fat_tfm', 'vlr_pcl_tfm', 'tip_mvt', 'prd']
fatec_pagamento.columns = ['id_opr_cad_pos', 'id_mvt_cad_pos', 'id_pgt_cad_pos', 'dat_pgt', 'dat_vct_tfm', 'vlr_pgt_tfm', 'cod_mdl', 'cmd']

# Retirando os valores nulos entre as quebras de página:

#fatec_operacao = fatec_operacao[(pd.isna(fatec_operacao['id_opr_cad_pos']) != True)]
fatec_movimento = fatec_movimento[(pd.isna(fatec_movimento['id_opr_cad_pos']) != True)]
fatec_pagamento = fatec_pagamento[(pd.isna(fatec_pagamento['id_opr_cad_pos']) != True)]

# Usando a váriavel anterior para retirar as quebrar de página:

#fatec_operacao = fatec_operacao[(fatec_operacao['id_opr_cad_pos'] != coluna_fatec_operacao)]
fatec_movimento = fatec_movimento[(fatec_movimento['id_opr_cad_pos'] != coluna_fatec_movimento)]
fatec_pagamento = fatec_pagamento[(fatec_pagamento['id_opr_cad_pos'] != coluna_fatec_pagamento)]
'''

fontes_ids = list(int(float(str(i).strip())) for i in list(fatec_operacao['id_fnt']))
fatec_operacao['id_fnt'].update(pd.Series(fontes_ids))

#Removendo espaços dos campos das tabelas

def limpa_espacos():
    for coluna in fatec_operacao:
        coluna_temporaria = list()
        for campo in fatec_operacao[coluna]:
            if type(campo) == str:
                coluna_temporaria.append(campo.strip())
            else:
                coluna_temporaria.append(campo)
        fatec_operacao[coluna].update(pd.Series(coluna_temporaria))
    
limpa_espacos()        

#Função que calcula a quantidade total de campos para um determinada fonte
def campos_totais_opr(fonte):
    return fatec_operacao.query(f"id_fnt == {fonte}")['id_fnt'].count() * fatec_operacao.shape[1]

#Função que calcula quantos campos nulos existem por conta da modalidade D01 e C01, as quais são as únicas que 
#precisam da coluna 'sdo_ddr_tfm'
def nulos_permitidos(fonte):
    return fatec_operacao.query(f"sdo_ddr_tfm == 'NULL' and cod_mdl not in ['D01', 'C01'] and id_fnt == {fonte}")['sdo_ddr_tfm'].count()


#Função que retorna a porcentagem de campos nulos de acordo com a fonte, na tabela de operação
def completude_opr(fonte):
    campos_nulos = 0
    for coluna in fatec_operacao.columns:
        campos_nulos += fatec_operacao.query(f"{coluna} == 'NULL' and id_fnt == {fonte}")['id_fnt'].count()
    
    nulos_totais = campos_nulos - nulos_permitidos(fonte)
    return 100 - ((nulos_totais / campos_totais_opr(fonte)) * 100)
    
    
#Função que integra as 3 funções anteriores, retornando uma lista com a fonte e a porcentagem de sua respectiva 
#completude dos dados
def completude_fontes_operacao():
    indice_fontes = set(list(int(float(str(i).strip())) for i in list(fatec_operacao['id_fnt'])))
    matriz_completude = list()
    for fonte in indice_fontes:
        porcentagem = completude_opr(fonte)
        matriz_completude.append([fonte, porcentagem])
    matriz_completude.sort()
    return matriz_completude


