print("\n##########  TABELA PAGAMENTO  ##########")
from data import fatec_pagamento, fatec_movimento, fatec_operacao, modalidade, indice_fontes
print(" * Dados importados")

'''
COMPLETUDE
'''


def completude(DataFrame):
    '''
    As matriz abaixo armazenará os campos incompletos de cada fonte, no seguinte formato
    [fonte, quantidade_incompletos]
    [fonte, quantidade_incompletos]...
    '''
    matriz_fontes_incompletos = list([fonte, 0] for fonte in indice_fontes)
    
    for linha in range(DataFrame.shape[0]):
        if DataFrame.iloc[linha].isnull().sum() > 0 or list(DataFrame.iloc[linha]).count('NULL') > 0: #Checando se há algum campo nulo na linha, tanto NaN quanto 'NULL'
            fonte = DataFrame.iloc[linha]['id_fnt']
            posicao = indice_fontes.index(fonte)
            #Somando o segundo valor da array à soma de campos nulos encontrados na linha
            matriz_fontes_incompletos[posicao][1] += DataFrame.iloc[linha].isnull().sum() + list(DataFrame.iloc[linha]).count('NULL')
    
    matriz_completude_porcentagem = list()

    for fonte in range(len(indice_fontes)):
        #A variável abaixo registra quantos campos existem referentes à fonte possuem a fonte em questão. 
        # Estamos multiplicando pela quantidade de colunas - 1 pois uma das colunas apenas identifica a fonte.
        campos_fonte_total = DataFrame.query(f'id_fnt == {indice_fontes[fonte]}')['id_fnt'].count() * (DataFrame.shape[1] - 1)
        campos_incompletos = matriz_fontes_incompletos[fonte][1]
        porcentagem = 100 - ((campos_incompletos / campos_fonte_total) * 100)
        matriz_completude_porcentagem.append([indice_fontes[fonte], porcentagem])
    
    return matriz_completude_porcentagem


'''
CONSISTÊNCIA
'''


def consistencia(df_base, series_base, series_referencia):
    matriz = list([fonte] for fonte in indice_fontes)
    for fonte in indice_fontes:
        campos_inconsistentes = list()
        for campo in range(len(series_base)):
            if df_base['id_fnt'][campo] == fonte and campo not in series_referencia:
                campos_inconsistentes.append(campo)
        
        porcentagem = 100 - (len(campos_inconsistentes) / len(series_base)) * 100
        matriz[indice_fontes.index(fonte)].append(porcentagem)
    
    return matriz


'''
CONFIABILIDADE
'''


def verifica_valor(df, coluna, fonte):
    campos_invalidos = list()
    
    for index in zip(df[coluna], df['id_fnt']):
        if index[1] == fonte:
            try:
                float(index[0])
                
            except ValueError:
                if index[0] != 'NULL':
                    campos_invalidos.append(index[0])
    
    porcentagem = 100 - (len(campos_invalidos) / len(df[coluna])) * 100

    return porcentagem, campos_invalidos


def validaNumerico(df, colunas):
    matriz = list([fonte] for fonte in indice_fontes)

    for index in range(len(matriz)):
        campos_inconsistentes = list()

        for coluna in colunas:
            porcentagem = verifica_valor(df, coluna, matriz[index][0])
            campos_inconsistentes.append(porcentagem[0])
    
        porcentagem = sum(campos_inconsistentes) / len(colunas)
        matriz[index].append(porcentagem)
        campos_inconsistentes.clear()
    return matriz
    
'''
GERAÇÃO DA MATRIZ COM TODOS OS INDICADORES ACIMA, PARA A TABELA DE PAGAMENTO
'''


def indicadores_fatec_pagamento():
    #completude, consistência, confiabilidade
    #Gerando a matriz de completude
    matriz_completude = completude(fatec_pagamento)
    print(" * Matriz completude criada")

    #O indicador de consistência receberá estes 3 valores. A consistência de "id_opr_cad_pos", "id_mvt_cad_pos" e "cod_mdl" nas tabelas de referência
    matriz_consistencia_opr = consistencia(fatec_pagamento, fatec_pagamento['id_opr_cad_pos'], fatec_operacao['id_opr_cad_pos'])
    matriz_consistencia_mvt = consistencia(fatec_pagamento, fatec_pagamento['id_mvt_cad_pos'], fatec_movimento['id_mvt_cad_pos'])
    matriz_consistencia_mdl = consistencia(fatec_pagamento, fatec_pagamento['cod_mdl'], modalidade['COD_MDL'])

    matriz_consistencia = list()
    for fonte in range(len(indice_fontes)):
        media = (matriz_consistencia_opr[fonte][1] + matriz_consistencia_mvt[fonte][1] + matriz_consistencia_mdl[fonte][1]) / 3
        matriz_consistencia.append([indice_fontes[fonte], media])
    print(" * Matriz consistencia criada")

    colunas_analisadas = ['vlr_pgt_tfm']
    confiabilidade = validaNumerico(fatec_pagamento, colunas_analisadas)
    print(" * Matriz confiabilidade criada")


    matriz_final = list([fonte] for fonte in indice_fontes)
    print(' * Matriz Final Criada --------- PAGAMENTO')

    for fonte in range(len(indice_fontes)):
        #adicionando completude
        matriz_final[fonte].append(matriz_completude[fonte][1])
        #adicionando consistência
        matriz_final[fonte].append(matriz_consistencia[fonte][1])
        #adicionando confiabilidade
        matriz_final[fonte].append(confiabilidade[fonte][1])
    
    return matriz_final 
print(" * Funções definidas . . . Chamando função dos indicadores")


print(' * INDICADORES DA TABELA MOVIMENTO')
for fonte in indicadores_fatec_pagamento():
    print(fonte)
print('\n')
    



    

