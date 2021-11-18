print("\n##########  TABELA MOVIMENTO  ##########")
import pandas as pd 
from data import fatec_movimento, fatec_operacao, fatec_fonte, indice_fontes
print(" * Dados importados")

# DECLARANDO VARIAVEIS GLOBAIS

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



#Este arquivo irá análisar cada fonte e retornará os indicadores ja calculados


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

def datasInvalidas_movimento(fonte):
    datas_invalidas = list()
    dataframe = fatec_movimento[(fatec_movimento['id_fnt'] == fonte)]
    for index in zip(list(dataframe['id_mvt_cad_pos']), list(dataframe['dat_vct'])):

        try:
            int(index[1])
            if len(str(int(index[1]))) < 8 and len(str(int(index[1]))):
                datas_invalidas.append(index[1])
            
        except ValueError:
            datas_invalidas.append(index[1])

    porcentagem = (len(datas_invalidas) / dataframe.shape[0]) * 100
    return porcentagem, datas_invalidas



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
UNIÃO DOS TRÊS INDICADORES
Abaixo estamos concatenando todas as funções no seu respectivo indicador
'''

def indicadores_fatec_movimento():
    # Criando a matriz, em que cada array recebe as fontes de forma ordena
    matriz_fatec_movimento = list([fonte] for fonte in indice_fontes)

    #COMPLETUDE
    # A função abaixo retorna uma matriz com a fonte e a completude dos campos do dataframe

    matriz_completude = completude(fatec_movimento)

    print(" * Matriz completude criada")
    for fonte in range(len(indice_fontes)):
        matriz_fatec_movimento[fonte].append(matriz_completude[fonte][1])

    # CONSISTENCIA
    # A função abaixo retorna uma matriz com a fonte e a consistência entre as duas series abaixo inseridas como argumento
    consistenciaMatriz = consistencia(fatec_movimento, fatec_movimento['id_opr_cad_pos'], fatec_operacao['id_opr_cad_pos'])
    print(" * Matriz consistência criada")


    # O loop abaixo adicionará à todas as listas da matriz "matriz_fatec_operacao" a consistência recebida acima
    for linha in range(len(consistenciaMatriz)):
        matriz_fatec_movimento[linha].append(consistenciaMatriz[linha][1])


    # CONFIABILIDADE
    # O código abaixo fará a mesma adição na matriz, porém para o indicador de confiabilidade
    for fonte in range(len(matriz_fatec_movimento)):
        porcentagem_invalida = datasInvalidas_movimento(indice_fontes[fonte])[0]
        confiabilidade = 100 - porcentagem_invalida
        matriz_fatec_movimento[fonte].append(confiabilidade)
    print(' * Matriz confiabilidade criada')

    print(' * Matriz Final Criada --------- MOVIMENTO')
    return matriz_fatec_movimento
print(" * Funções definidas, Chamando função dos indicadores")


print(' * INDICADORES DA TABELA MOVIMENTO')
for fonte in indicadores_fatec_movimento():
    print(fonte)
print('\n')