import pandas as pd
print('\n\n * Biblioteca Pandas importada')
# Dados Principais

if 'fatec_fonte' not in globals():      
    fatec_fonte = pd.read_excel("dados/importados/STG_FNT_ITT.xlsx")
    print(' * DataFrame fatec_fonte criado')
    
if 'modalidade' not in globals():
    modalidade = pd.read_excel("dados/importados/STG_MDL.xlsx")
    print(' * DataFrame modalidade criado')
    
#pagamento = pd.read_excel("dados/principais/STG_PGT.xlsx")
#movimento = pd.read_excel("dados/principais/STG_MVT_CRD.xlsx")

# Dados Complementares
if 'fatec_operacao' not in globals():
    fatec_operacao = pd.read_excel("dados/importados/fatec_opr.xlsx")
    print(' * DataFrame fatec_operacao criado')

if 'fatec_movimento' not in globals():    
    fatec_movimento = pd.read_excel("dados/importados/fatec_mvt.xlsx")
    print(' * DataFrame fatec_movimento criado')

if 'fatec_pagamento' not in globals():    
    fatec_pagamento = pd.read_excel("dados/importados/fatec_pgt.xlsx")
    print(' * DataFrame fatec_pagamento criado')

if 'pessoa_fisica' not in globals():    
    pessoa_fisica = pd.read_excel("dados/importados/fatec_pessoa_fisica.xlsx")
    print(' * DataFrame pessoa_fisica criado')
    
def limpa_espacos(df):  # Removendo espaços dos campos das tabelas
    for coluna in df:
        coluna_temporaria = list()
        for campo in df[coluna]:
            if type(campo) == str:
                coluna_temporaria.append(campo.strip())
            else:
                coluna_temporaria.append(campo)
        df[coluna].update(pd.Series(coluna_temporaria))


# lista de dataframes
dataframes = [fatec_operacao, fatec_movimento, fatec_pagamento, modalidade, fatec_fonte]

for df in dataframes:  # limpando todas as listas
    limpa_espacos(df)
print(' * Limpeza dos campos nos DataFrames realizada \n\n')
                
                
def adiciona_coluna_fonte(dataframe): # Nome do dataframe que voce deseja adicionar a coluna fonte
    lista_fontes = list() # lista de fontes a serem adicionadas no dataframe

    for index in list(dataframe['id_opr_cad_pos']):
        if index in list(fatec_operacao['id_opr_cad_pos']):
            for ID in zip(list(fatec_operacao['id_opr_cad_pos']), list(fatec_operacao['id_fnt'])):
                if index == ID[0]:
                    lista_fontes.append(ID[1])
        else:
            lista_fontes.append("Não encontrado")

    return dataframe.insert(loc = dataframe.shape[1], column = "id_fnt", value = lista_fontes)

def adiciona_coluna_modalidade(dataframe):
    lista_modalidades = list()

    for index in list(dataframe['id_opr_cad_pos']):
        if index in list(fatec_operacao['id_opr_cad_pos']):
            for ID in zip(list(fatec_operacao['id_opr_cad_pos']), list(fatec_operacao['cod_mdl'])):
                if index == ID[0]:
                    lista_modalidades.append(ID[1])
        else:
            lista_modalidades.append("Não encontrado")
    
    return dataframe.insert(loc = dataframe.shape[1], column = "cod_mdl", value = lista_modalidades)

'''
def coluna_fonte():
    dataframes = [fatec_movimento, fatec_pagamento]
    for dataframe in dataframes:
        adiciona_coluna_fonte(dataframe)
    return

'''

#O código abaixo verifica que a tabela de movimento ou operação já possuem as colunas de modalidade e fonte.
#Caso não possuam, as funções "adiciona_coluna_fonte" e "adiciona_coluna_modalidade" serão executadas

if 'id_fnt' not in fatec_pagamento or 'id_fnt' not in fatec_movimento:
    try:
        if 'id_fnt' not in fatec_pagamento:
            print(' * Adição da coluna "id_fnt" iniciada em fatec_pagamento')
            adiciona_coluna_fonte(fatec_pagamento)
            print(' * Adição da coluna "id_fnt" finalizada em fatec_pagamento')
            fatec_pagamento.to_excel("dados/importados/fatec_pgt.xlsx", sheet_name = "tabela 1", index = False)
            print(' * Arquivo .xlsx de operação atualizado')

        if  'id_fnt' not in fatec_movimento:
            print(' * Adição da coluna "id_fnt" iniciada em fatec_movimento')
            adiciona_coluna_fonte(fatec_movimento)
            fatec_movimento.to_excel("dados/importados/fatec_mvt.xlsx", sheet_name = "tabela 1", index = False)
            print(' * Adição da coluna "id_fnt" finalizada em fatec_movimento')

    except ValueError:
        pass
    
if 'cod_mdl' not in fatec_movimento:
    try:
        print(' * Adição da coluna "cod_mdl" iniciada em fatec_movimento')
        adiciona_coluna_modalidade(fatec_movimento)
        fatec_movimento.to_excel("dados/importados/fatec_mvt.xlsx", sheet_name = "tabela 1", index = False)
        print(' * Adição da coluna "cod_mdl" finalizada em fatec_movimento')

    except ValueError:
        pass

indice_fontes = list(set(fatec_operacao['id_fnt']))
indice_fontes.sort()
