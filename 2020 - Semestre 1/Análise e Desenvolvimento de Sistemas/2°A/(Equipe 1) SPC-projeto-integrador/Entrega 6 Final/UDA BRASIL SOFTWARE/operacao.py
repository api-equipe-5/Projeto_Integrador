print("\n##########  TABELA OPERAÇÃO  ##########")
import pandas as pd
from data import fatec_operacao, fatec_fonte, indice_fontes, modalidade, pessoa_fisica

print(' * Dados importados')
# Declarando variáveis globais

referencia_fonte = list(fatec_operacao['id_fnt'])

# Este arquivo irá análisar cada fonte e irá retornar os indicadores já calculados


'''
CONFIABILIDADE
'''

def validaCpf(cpf, d1=0, d2=0, i=0):
    while i<10:
        d1,d2,i=(d1+(int(cpf[i])*(11-i-1)))%11 if i<9 else d1,(d2+(int(cpf[i])*(11-i)))%11,i+1
        
   
    return (int(cpf[9])==(11-d1 if d1>1 else 0)) and (int(cpf[10])==(11-d2 if d2>1 else 0))


def validaCnpj(cnpj):
    str(cnpj)

    if (not cnpj) or (len(cnpj) < 14):
        return False

    # Pega apenas os 12 primeiros dígitos do CNPJ e gera os 2 dígitos que faltam
    inteiros = list(map(int, cnpj))
    novo = inteiros[:12]

    mascara_validacao = [5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2] # Fornecida pela receita federal
    while len(novo) < 14:
        r = sum([x*y for (x, y) in zip(novo, mascara_validacao)]) % 11
        if r > 1:
            f = 11 - r
        else:
            f = 0
        novo.append(f)
        mascara_validacao.insert(0, 6)

    # Se o número gerado coincidir com o número original, é válido
    return novo == inteiros


def documentosInvalidos(fonte):
 
    cpf_invalidos = list()
    cnpj_invalidos = list()
    dataframe = fatec_operacao[(fatec_operacao["id_fnt"] == fonte)]
    listDoc = [list(dataframe["doc_cli"]), list(dataframe["tip_cli"])]

    
    for index in range(len(listDoc)):
        if listDoc[1][index] == "F":
            #Garantindo que listDoc[0][index] terá 11 caracteres
            if len(str(listDoc[0][index])) != 11:
                cpf_invalidos.append(listDoc[0][index])
            
            elif not validaCpf(str(listDoc[0][index])):
                cpf_invalidos.append(listDoc[0][index])
          
        
        else:
            if not validaCnpj(listDoc[0][index]):
                 cnpj_invalidos.append(listDoc[0][index])
    

    porcentagem = ((len(cpf_invalidos) + len(cnpj_invalidos)) / len(listDoc)) * 100
    return porcentagem, cpf_invalidos, cnpj_invalidos


def datasInvalidas_operacao(fonte):
    datas_invalidas = list()
    dataframe = fatec_operacao[(fatec_operacao['id_fnt'] == fonte)]
    for index in zip(list(dataframe['id_opr_cad_pos']), list(dataframe['dat_vct_ult_pcl'])):
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
COMPLETUDE
'''

def campos_totais_opr(fonte):
    return fatec_operacao.query(f"id_fnt == {fonte}")['id_fnt'].count() * fatec_operacao.shape[1]

# Função que calcula quantos campos nulos existem por conta da modalidade D01 e C01, as quais são as únicas que
# precisam da coluna 'sdo_ddr_tfm'


def nulos_permitidos_opr(fonte):
    return fatec_operacao.query(f"sdo_ddr_tfm == 'NULL' and cod_mdl not in ['D01', 'C01'] and id_fnt == {fonte}")['sdo_ddr_tfm'].count()


# Função que retorna a porcentagem de campos nulos de acordo com a fonte, na tabela de operação
def completude_opr(fonte):

    referencia_fontes = list(fatec_operacao['id_fnt'])
    campos_nulos = int()

    for linha in range(len(referencia_fontes)):
        if referencia_fontes[linha] == fonte:
            campos_nulos += fatec_operacao.loc[linha].isna().sum()

    nulos_totais = campos_nulos - nulos_permitidos_opr(fonte)
    return 100 - ((nulos_totais / campos_totais_opr(fonte)) * 100)

# Função que integra as 3 funções anteriores, retornando uma lista com a fonte e a porcentagem de sua respectiva
# completude dos dados


def completude_fontes_opr():
    matriz_completude = list()
    for fonte in indice_fontes:
        porcentagem = completude_opr(fonte)
        matriz_completude.append([fonte, porcentagem])
    matriz_completude.sort()
    return matriz_completude


'''
UNIÃO DOS TRÊS INDICADORES
Abaixo estamos contatenando todas as funções no seu respectivo indicador
'''

# Retorna a matriz de confiabilidade, completude e consistencia de todas as fontes
def indicadores_fatec_operacao(): 
    #Criando a matriz, em que cada array recebe as fontes de forma ordenada
    matriz_fatec_operacao = list([fonte] for fonte in indice_fontes)
    print(' * Matriz criada')

    #O código abaixo fará a mesma adição na matriz, porém para o indicador de completude
    completude = completude_fontes_opr()
    print(' * Função de completude chamada')

    for linha in range(len(completude)):
        matriz_fatec_operacao[linha].append(completude[linha][1])

    
    #a função abaixo retorna uma matriz com a fonte e a consistencia entre as duas series abaixo inseridas como argumento
    consistenciaMatriz = consistencia(fatec_operacao, fatec_operacao['doc_cli'], pessoa_fisica['cpf'])
    print(' * Matriz consistência criada')
    
    
    #o loop abaixo adicionará à todas as listas da matriz "matriz_fatec_operacao" a consistência recebida acima
    for linha in range(len(consistenciaMatriz)):
        matriz_fatec_operacao[linha].append(consistenciaMatriz[linha][1])
    

    print(' * Matriz confiabilidade criada')
    #O código abaixo fará a mesma adição na matriz, porém para o indicador de confiabilidade
    colunas = ['vlr_ctrd_fta_tfm', 'sdo_ddr_tfm', 'vlr_ctrd']
    valida_Numerico = validaNumerico(fatec_operacao, colunas)
    for fonte in range(len(matriz_fatec_operacao)):
        media_porcentagem_invalida = (documentosInvalidos(indice_fontes[fonte])[0] + datasInvalidas_operacao(indice_fontes[fonte])[0] + valida_Numerico[fonte][1]) / 3
        confiabilidade = 100 - media_porcentagem_invalida
        matriz_fatec_operacao[fonte].append(confiabilidade)

    print(' * Matriz Final Criada --------- OPERAÇÃO')
    return matriz_fatec_operacao

print(' * Funções definidas, chamando função dos indicadores')


print(' * INDICADORES DA TABELA OPERAÇÃO')
for fonte in indicadores_fatec_operacao():
    print(fonte)
print('\n')