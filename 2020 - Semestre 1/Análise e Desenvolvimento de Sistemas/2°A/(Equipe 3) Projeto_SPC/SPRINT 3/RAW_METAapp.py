print (f"Bem-vindo ao gerador de relatórios \
       \ndos lotes recebidos do CADASTRO POSITIVO")
print ('\n')
print (f"A análise dos arquivos pode demorar")
print ('\n')
print (f"Aguarde...")
print ('\n')

#Importa as bibliotecas necessárias
import pandas as pd
import numpy as np
import datetime
from plotly.offline import iplot
import plotly.graph_objs as go
from plotly.subplots import make_subplots
import os
import os.path as path
import subprocess

pasta ="./relatorio/pags"


access_rights = 0o777

try:
    os.mkdir('relatorio', access_rights)
except OSError:
    print ("\tAVISO: A criação da pasta (relatorio) falhou ou a pasta já existe")
    #print ("\tAVISO: A criação da pasta %s falhou ou a pasta já existe" % pasta)
else:
    print ("\tPasta (relatorio) criada com sucesso!")
    #print ("\tPasta %s criada com sucesso!" % pasta)

try:
    os.mkdir('relatorio/pags', access_rights)
except OSError:
    print ("\tAVISO: A criação da pasta (pags) falhou ou a pasta já existe")
    #print ("\tAVISO: A criação da pasta %s falhou ou a pasta já existe" % pasta)
else:
    print ("\tPasta (pags) criada com sucesso!")
    #print ("\tPasta %s criada com sucesso!" % pasta)

if not path.exists('STG_FNT_ITT.xlsx'): 
    print ("\tAVISO: O arquivo STG_FNT_ITT.xlsx não encontrado, erros poderão surgir")

if not path.exists('STG_MDL.xlsx'): 
    print ("\tAVISO: O arquivo STG_MDL.xlsx não encontrado, erros poderão surgir")

if path.exists('STG_MVT_CRD.xlsx'):

    #Define variáveis para as tabelas que serão analisadas

    df = pd.read_excel ('STG_MVT_CRD.xlsx')
    cf = pd.read_excel ('STG_MDL.xlsx')
    bf = pd.read_excel ('STG_FNT_ITT.xlsx')

    #Trata as datas
    df.DAT_RSS_FNT_ITT = pd.to_datetime(df.DAT_RSS_FNT_ITT, format='%Y-%m-%d', errors='coerce')
    df.DAT_INC_DBO = pd.to_datetime(df.DAT_INC_DBO, format='%Y-%m-%d', errors='coerce')

    #Verifica as linhas das colunas o tipo desejado
    tipo_ID_STG_MVT_CRD = len([x for x in range(len(df)) if df.ID_STG_MVT_CRD[x].dtype == np.int64])
    tipo_VLR_SDO_UTZ_CRD_RTO = len([x for x in range(len(df)) if df.VLR_SDO_UTZ_CRD_RTO[x].dtype == np.float64])
    tipo_VLR_TOT_FAT = len([x for x in range(len(df)) if df.VLR_TOT_FAT[x].dtype == np.float64])
    tipo_VLR_MIM_FAT = len([x for x in range(len(df)) if df.VLR_MIM_FAT[x].dtype == np.float64])
    tipo_VLR_PCL_FAT = len([x for x in range(len(df)) if df.VLR_PCL_FAT[x].dtype == np.float64])
    tipo_QTD_CLI_CAD_POS = len([x for x in range(len(df)) if df.QTD_CLI_CAD_POS[x].dtype == np.int64])
    tipo_QTD_MVT = len([x for x in range(len(df)) if df.QTD_MVT[x].dtype == np.int64])
    tipo_DES_TIP_PSS = len([x for x in range(len(df)) if df.DES_TIP_PSS[x] == ('F' or 'J')])
    tipo_ID_FNT_ITT = len([x for x in range(len(df)) if df.ID_FNT_ITT[x].dtype == np.int64])
    tipo_COD_MDL = len([x for x in range(len(df)) if type(df.COD_MDL[x]) == str])
    tipo_DAT_RSS_FNT_ITT = len([x for x in range(len(df)) if isinstance(df.DAT_RSS_FNT_ITT[x], datetime.date)])
    tipo_DAT_INC_DBO = len([x for x in range(len(df)) if isinstance(df.DAT_INC_DBO[x], datetime.date)])

    tipos = [tipo_ID_STG_MVT_CRD, tipo_VLR_SDO_UTZ_CRD_RTO, tipo_VLR_TOT_FAT, tipo_VLR_MIM_FAT,
             tipo_VLR_PCL_FAT, tipo_QTD_CLI_CAD_POS, tipo_QTD_MVT, tipo_DES_TIP_PSS,
             tipo_ID_FNT_ITT, tipo_COD_MDL, tipo_DAT_RSS_FNT_ITT, tipo_DAT_INC_DBO]
    tipos = [tipo * 100 / len(df) for tipo in tipos]

    tipo_review = pd.DataFrame({'Porcentagem': tipos},
                               index=df.columns)

    #Plota em formato gráfico e exporta para HTML
    data = [go.Bar(x=tipos,
                   y=df.columns,
                   orientation = 'h',
                   marker=dict(color='#3749E9')
                  )]

    fig = go.Figure(data=data)
    fig.update_yaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_xaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))

    fig.write_html(pasta + "/mvt_tipo.html")

    #Cria um dataframe definido as colunas com dados sensíveis
    dado_sensivel = ['Não', 'Não', 'Não', 'Não', 'Não', 'Não', 'Não', 'Não', 'Sim', 'Não', 'Não', 'Não']

    sensibilidade_review = pd.DataFrame({'Dado Sensível': dado_sensivel},
                                          index=df.columns)
    sensibilidade_review = sensibilidade_review.rename_axis('Colunas', axis='columns')

    #Plota em formato tabela e exporta para HTML
    cores = []
    for x in range (len (sensibilidade_review)):
        if x % 2 == 0:
            cores.append('#DEDEDE')
        else:
            cores.append('#ECECEC')

    fig = go.Figure(data=[go.Table(
        header=dict(values=['<b>Colunas</b>', '<b>Dado Sensível</b>'],
                    font=dict(color='#707070', size=14),
                    height=30,
                    line_color = '#707070',
                    fill_color='#ECECEC',
                    align='left'),
        cells=dict(values=[sensibilidade_review.index,
                           dado_sensivel],
                   font=dict(color='#707070', size=14),
                   height=30,
                   line_color = '#707070',
                   fill_color=[cores*2],
                   align=['left', 'right', 'right', 'right']))
    ])

    fig.update_layout(xaxis={'categoryorder':'total ascending'})

    fig.write_html(pasta + "/mvt_tab_sensibilidade.html")

    #Compara os valores da Tabela MVT com a Tabela FNT
    fontes = df.groupby('ID_FNT_ITT').count().index
    modalidades = df.groupby('COD_MDL').count().index

    verificabf = []
    for x in bf.ID_STG_FNT_ITT:
        verificabf.append (x)

    diferente = 0
    for x in df.ID_FNT_ITT:
        if x not in verificabf:
            diferente += 1

    if diferente == 0:
        porcentagem_FNT = 100
    else:
        porcentagem_FNT = 100 - (diferente *100/len(df.ID_FNT_ITT))

    verificacf = []
    for x in cf.COD_MDL:
        verificacf.append (x)

    diferente = 0
    for x in df.COD_MDL:
        if x not in verificacf:
            diferente += 1

    #Faz o cálculo de porcentagem baseado no valor total de linhas
    if diferente == 0:
        porcentagem_COD = 100
    else:
        porcentagem_COD = 100 - (diferente *100/len(df.COD_MDL))
        
    porcentagens = [porcentagem_FNT, porcentagem_COD]
    existencia_labels = ['IDs de Fontes', 'Códigos de Modalidades']
    encontrados = [len(fontes), len(modalidades)]

    correspondencia_review = pd.DataFrame({'Encontrados': encontrados,
                                           'Correspondência': porcentagens},
                                          index=existencia_labels)
    correspondencia_review = correspondencia_review.rename_axis('Colunas', axis='columns')

    #Plota em formato tabela e exporta para HTML
    cores = []
    for x in range (len (correspondencia_review)):
        if x % 2 == 0:
            cores.append('#DEDEDE')
        else:
            cores.append('#ECECEC')

    fig = go.Figure(data=[go.Table(
        header=dict(values=['<b>Colunas</b>', '<b>Encontrados</b>', '<b>Correspondência</b>'],
                    font=dict(color='#707070', size=14),
                    height=30,
                    line_color = '#707070',
                    fill_color='#ECECEC',
                    align='left'),
        cells=dict(values=[correspondencia_review.index,
                           correspondencia_review.Encontrados,
                           correspondencia_review.Correspondência],
                   font=dict(color='#707070', size=14),
                   height=30,
                   line_color = '#707070',
                   fill_color=[cores*2],
                   align=['left', 'right', 'right', 'right']))
    ])

    fig.update_layout(xaxis={'categoryorder':'total ascending'})

    fig.write_html(pasta + "/mvt_correspondencia.html")

    #Define as variáveis excluindo as modalidades que não fazem parte da categoria
    nocredcard = df[df.COD_MDL != 'D01'] #Desprezo a linha do Cartão de Crédito
    nocredcard = nocredcard[nocredcard.COD_MDL != 'E01'] #Desprezo a linha do Cheque Especial
    rotativo = df[df.COD_MDL == 'E01'] #Analiso apenas a linha do Cheque Especial
    cred = df[df.COD_MDL == 'D01'] #Analiso apenas a linha do Cartão de Crédito

    #Verifica se as linhas das colunas não estão vazias
    coluna_data_inc = df.DAT_INC_DBO.notna().mean().round(4) * 100
    coluna_data_rss = df.DAT_RSS_FNT_ITT.notna().mean().round(4) * 100

    colunas = [nocredcard.VLR_PCL_FAT, cred.VLR_MIM_FAT, cred.VLR_TOT_FAT, 
               df.QTD_CLI_CAD_POS, df.QTD_MVT, rotativo.VLR_SDO_UTZ_CRD_RTO, df.COD_MDL]
    campos_validos = [coluna.notna().mean().round(4) * 100 for coluna in colunas]
    campos_validos.append (coluna_data_inc)
    campos_validos.append (coluna_data_rss)

    #Define um conjunto de rótulos para o index
    preenchimento_labels = ['VLR_PCL_FAT', 'VLR_MIM_FAT', 
                            'VLR_TOT_FAT', 'QTD_CLI_CAD_POS', 
                            'QTD_MVT', 'VLR_SDO_UTZ_CRD_RTO', 'COD_MDL',
                            'DAT_INC_DBO', 'DAT_RSS_FNT_ITT']

    #Cria uma nova tabela com todos os dados obtidos
    tabela_review = pd.DataFrame({'Campos Válidos': campos_validos},
                               index=preenchimento_labels)
    tabela_review = tabela_review.rename_axis('Colunas', axis='columns')

    #Plota em formato gráfico e exporta para HTML
    data = [go.Bar(x=campos_validos,
                   y=preenchimento_labels,
                   orientation = 'h',
                   marker=dict(color='#3749E9')
                  )]

    fig = go.Figure(data=data)
    fig.update_yaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_xaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.write_html(pasta + "/mvt_preenchimento.html")

    #Separa por grupos os valores diferentes encontrados nas colunas de datas
    datas_inc = df[['DAT_INC_DBO', 'ID_STG_MVT_CRD']]
    datas_inc = datas_inc.groupby('DAT_INC_DBO').count().sort_values(by = 'ID_STG_MVT_CRD', ascending = False)

    datas_rss = df[['DAT_RSS_FNT_ITT', 'ID_STG_MVT_CRD']]
    datas_rss = datas_rss.groupby('DAT_RSS_FNT_ITT').count().sort_values(by = 'ID_STG_MVT_CRD', ascending = False)

    #Analisa os valores únicos encontrados e calcula a porcentagem de seu tamanho com o número de linhas da tabela
    conta = 0
    porcentagem = []
    for x in datas_inc.ID_STG_MVT_CRD:
        conta = x * 100 / len(df)
        porcentagem.append (conta)

    conta = 0
    porcentagem = []
    for x in datas_rss.ID_STG_MVT_CRD:
        conta = x * 100 / len(df)
        porcentagem.append (conta)

    #Acrescenta o resultado ao dataframe
    datas_inc['Porcentagem'] = porcentagem
    datas_inc = datas_inc.rename_axis('Datas Encontradas', axis='columns').drop('ID_STG_MVT_CRD', 1)

    datas_rss['Porcentagem'] = porcentagem
    datas_rss = datas_rss.rename_axis('Datas Encontradas', axis='columns').drop('ID_STG_MVT_CRD', 1)

    #Concatena e cria uma tabela com todos os resultados
    dados = [datas_inc, datas_rss]
    datas_encontradas = pd.concat(dados)
    datas_encontradas.index.name = None

    #Plota em formato tabela e exporta para HTML
    cores = []
    for x in range (len (datas_encontradas)):
        if x % 2 == 0:
            cores.append('#DEDEDE')
        else:
            cores.append('#ECECEC')
            
    fig = go.Figure(data=[go.Table(
        header=dict(values=['<b>Datas Encontradas</b>','<b>Porcentagem</b>'],
                    font=dict(color='#707070', size=14),
                    height=30,
                    line_color = '#707070',
                    fill_color='#ECECEC',
                    align='left'),
        cells=dict(values=[datas_encontradas.index,
                           datas_encontradas.Porcentagem.map('{:,.0f}%'.format)],
                   font=dict(color='#707070', size=14),
                   height=30,
                   line_color = '#707070',
                   fill_color=[cores*2],
                   align=['left', 'right', 'right', 'right']))
    ])

    fig.update_layout(xaxis={'categoryorder':'total ascending'})

    fig.write_html(pasta + "/mvt_tab_datas.html")

    #Converte todos os valores para acrescentar dois decimais
    for c in df.VLR_PCL_FAT:
        d = c * 0.01
        df.VLR_PCL_FAT = df.VLR_PCL_FAT.replace(c, d)

    for c in df.VLR_TOT_FAT:
        d = c * 0.01
        df.VLR_TOT_FAT = df.VLR_TOT_FAT.replace(c, d)
        
    for c in df.VLR_MIM_FAT:
        d = c * 0.01
        df.VLR_MIM_FAT = df.VLR_MIM_FAT.replace(c, d)

    for c in df.VLR_SDO_UTZ_CRD_RTO:
        d = c * 0.01
        df.VLR_SDO_UTZ_CRD_RTO = df.VLR_SDO_UTZ_CRD_RTO.replace(c, d)

    #Adiciona uma nova coluna ao dataframe com a descrição das modalidades
    new = cf[['COD_MDL', 'DES_MDL']]
    dictionary = new.set_index('COD_MDL').T.to_dict('list')
    for key, value in dictionary.items():
        dictionary[key] = str(value).strip("['']")
    df['DES_MDL'] = [dictionary[resp] for resp in df['COD_MDL']]

    #Filtra a tabela analisada para criar um novo dataframe
    credito = df.query('DES_MDL == "CARTAO DE CREDITO"')
    credito = credito[['DES_MDL', 'VLR_TOT_FAT', 'VLR_MIM_FAT']].groupby(['DES_MDL']).max().dropna()

    cheque = df.query('DES_MDL == "CHEQUE ESPECIAL E CONTA GARANTIDA"')
    cheque = cheque[['DES_MDL', 'VLR_SDO_UTZ_CRD_RTO']].groupby(['DES_MDL']).max().dropna()

    parcelas_labels = [x for x in df.DES_MDL]
    parcelas_labels.append ('CARTAO DE CREDITO - VLR TOTAL FATURA')
    parcelas_labels.append ('CARTAO DE CREDITO - VLR MINIMO FATURA')
    parcelas_labels.append ('CHEQUE ESPECIAL - SALDO DEVEDOR')

    parcelas_values = [x for x in df.VLR_PCL_FAT]
    parcelas_values.append (credito.loc['CARTAO DE CREDITO','VLR_TOT_FAT'])
    parcelas_values.append (credito.loc['CARTAO DE CREDITO','VLR_MIM_FAT'])
    parcelas_values.append (cheque.loc['CHEQUE ESPECIAL E CONTA GARANTIDA','VLR_SDO_UTZ_CRD_RTO'])

    movimentacoes_values = [x for x in df.QTD_MVT]
    movimentacoes_values.append (float("nan"))
    movimentacoes_values.append (float("nan"))
    movimentacoes_values.append (float("nan"))

    clientes_values = [x for x in df.QTD_CLI_CAD_POS]
    clientes_values.append (float("nan"))
    clientes_values.append (float("nan"))
    clientes_values.append (float("nan"))

    #Cria uma nova tabela com todos os dados obtidos
    parcela = pd.DataFrame({'Valor das Parcelas': parcelas_values,
                            'Número de Movimentações' : movimentacoes_values,
                            'Número de Clientes': clientes_values},
                           index = parcelas_labels)
    parcela = parcela.rename_axis('Modalidades', axis='columns')

    #Plota em formato tabela e exporta para HTML
    parcela = parcela.sort_index()
    conv_parcelas = parcela['Valor das Parcelas'].map('R$ {:,.2f}'.format)
    conv_movimentacoes = parcela['Número de Movimentações'].map('{:,.0f}'.format)
    conv_clientes = parcela['Número de Clientes'].map('{:,.0f}'.format)

    cores = []
    for x in range (len (parcela)):
        if x % 2 == 0:
            cores.append('#DEDEDE')
        else:
            cores.append('#ECECEC')
            
    fig = go.Figure(data=[go.Table(
        header=dict(values=['<b>Modalidades</b>','<b>Valor das Parcelas</b>','<b>Número de Movimentações</b>','<b>Número de Clientes</b>'],
                    font=dict(color='#707070', size=14),
                    height=30,
                    line_color = '#707070',
                    fill_color='#ECECEC',
                    align='left'),
        cells=dict(values=[parcela.index.fillna('-'),
                           conv_parcelas.replace('R$ nan', '-'*20),
                           conv_movimentacoes.replace('nan', '-'*20),
                           conv_clientes.replace('nan', '-'*20)],
                   font=dict(color='#707070', size=14),
                   height=30,
                   line_color = '#707070',
                   fill_color=[cores*4],
                   align=['left', 'right', 'right', 'right']))
    ])

    fig.update_layout(xaxis={'categoryorder':'total ascending'})

    fig.write_html(pasta + "/mvt_tab_modalidades.html")

    #Define escalas para o tamanho máximo padrão dos gráficos
    parcelas_range = [0, round(max(parcelas_values))]
    movimentacoes_range = [0, round(max(movimentacoes_values))]
    clientes_range = [0, round(max(clientes_values))]

    #Filtra valores menores ou iguais a 1 milhão
    parcela_menor = parcela[parcela['Valor das Parcelas'] <= 100000000]
    parcela_menor = parcela_menor.sort_values(by = 'Valor das Parcelas', ascending = True)

    #Filtra valores maiores que 1 milhão e menores e iguais a 5 milhões
    parcela_maior = parcela[parcela['Valor das Parcelas'] > 100000000]
    parcela_maior = parcela_maior[parcela_maior['Valor das Parcelas'] <= 5000000000]
    parcela_maior = parcela_maior.sort_values(by = 'Valor das Parcelas', ascending = False)

    #Define variáveis para a modalidade de crédito
    credito_labels = ['CARTAO DE CREDITO - VLR TOTAL FATURA', 'CARTAO DE CREDITO - VLR MINIMO FATURA']
    credito_values = [credito.loc['CARTAO DE CREDITO','VLR_TOT_FAT'], credito.loc['CARTAO DE CREDITO','VLR_MIM_FAT']]

    #Plota em formato gráfico e exporta para HTML
    cores = []
    for x in parcela_maior.index:
        if x == 'CHEQUE ESPECIAL - SALDO DEVEDOR':
            cores.append('#E93759')
        else:
            cores.append('#112244')


    fig = make_subplots(rows=1, cols=3, column_widths=[0.7, 0.2, 0.7])

    fig.add_trace(go.Bar(x=parcela_menor.index,
               y=parcela_menor['Valor das Parcelas'].dropna(),
               marker=dict(color='#112244')
              ),
        row=1, col=1
    )

    fig.add_trace(go.Bar(x = credito_labels,
               y = credito_values,
               marker=dict(color=['#CFE509', '#3749E9'])
              ),
        row=1, col=2
    )

    fig.add_trace(go.Bar(x=parcela_maior.index,
               y=parcela_maior['Valor das Parcelas'].dropna(),
               marker=dict(color=cores)
              ),
        row=1, col=3
    )

    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_yaxes(range=parcelas_range)
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(showlegend=False)

    fig.write_html(pasta + "/mvt_modalidades.html")

    #Plota em formato tabela e exporta para HTML
    data = [go.Bar(x=df.DES_MDL,
                   y=df.QTD_CLI_CAD_POS,
                   name='Clientes',
                   marker=dict(color='#3749E9')
                  ),
            go.Bar(x=df.DES_MDL,
                   y=df.QTD_MVT,
                   name='Movimentações',
                   marker=dict(color='#112244')
                  )]

    fig = go.Figure(data=data)

    fig = go.Figure(data=data)
    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(xaxis={'categoryorder':'total ascending'}, showlegend=False)

    fig.write_html(pasta + "/mvt_clientes_movimentacoes.html")

    #Filtra valores menores ou iguais a 1 mil
    cliente_menor = df[df.QTD_CLI_CAD_POS <= 1000]
    cliente_menor = cliente_menor.sort_values(by = 'QTD_CLI_CAD_POS', ascending = True)

    #Filtra valores maiores que 1 mil e menores ou iguais a 100 mil
    cliente_medio = df[df.QTD_CLI_CAD_POS <= 100000]
    cliente_medio = cliente_medio[cliente_medio.QTD_CLI_CAD_POS > 1000]
    cliente_medio = cliente_medio.sort_values(by = 'QTD_CLI_CAD_POS', ascending = True)

    #Filtra valores maiores que 100 mil
    cliente_maior = df[df.QTD_CLI_CAD_POS > 100000]
    cliente_maior = cliente_maior.sort_values(by = 'QTD_CLI_CAD_POS', ascending = True)

    #Plota em formato tabela e exporta para HTML
    fig = make_subplots(rows=1, cols=3, column_widths=[0.4, 0.5, 0.6])

    fig.add_trace(go.Bar(x=cliente_menor.DES_MDL,
               y=cliente_menor.QTD_CLI_CAD_POS,
               marker=dict(color='#3749E9')
              ),
        row=1, col=1
    )

    fig.add_trace(go.Bar(x = cliente_medio.DES_MDL,
               y = cliente_medio.QTD_CLI_CAD_POS,
               marker=dict(color='#3749E9')
              ),
        row=1, col=2
    )

    fig.add_trace(go.Bar(x=cliente_maior.DES_MDL,
               y=cliente_maior.QTD_CLI_CAD_POS,
               marker=dict(color='#3749E9')
              ),
        row=1, col=3
    )

    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_yaxes(range=clientes_range)
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(showlegend=False)

    fig.write_html(pasta + "/mvt_clientes.html")

    #Filtra valores menores ou iguais a 1 mil
    movimentacao_menor = df[df.QTD_MVT <= 1000]
    movimentacao_menor = movimentacao_menor.sort_values(by = 'QTD_MVT', ascending = True)

    #Filtra valores maiores que 1 mil e menores ou iguais a 100 mil
    movimentacao_medio = df[df.QTD_MVT <= 100000]
    movimentacao_medio = movimentacao_medio[movimentacao_medio.QTD_MVT > 1000]
    movimentacao_medio = movimentacao_medio.sort_values(by = 'QTD_MVT', ascending = True)

    #Filtra valores maiores que 100 mil
    movimentacao_maior = df[df.QTD_MVT > 100000]
    movimentacao_maior = movimentacao_maior.sort_values(by = 'QTD_MVT', ascending = True)

    #Plota em formato tabela e exporta para HTML
    fig = make_subplots(rows=1, cols=3, column_widths=[0.3, 0.2, 1])

    fig.add_trace(go.Bar(x=movimentacao_menor.DES_MDL,
               y=movimentacao_menor.QTD_MVT,
               marker=dict(color='#112244')
              ),
        row=1, col=1
    )

    fig.add_trace(go.Bar(x = movimentacao_medio.DES_MDL,
               y = movimentacao_medio.QTD_MVT,
               marker=dict(color='#112244')
              ),
        row=1, col=2
    )

    fig.add_trace(go.Bar(x=movimentacao_maior.DES_MDL,
               y=movimentacao_maior.QTD_MVT,
               marker=dict(color='#112244')
              ),
        row=1, col=3
    )

    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_yaxes(range=movimentacoes_range)
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(showlegend=False)
    fig.write_html(pasta + "/mvt_movimentacoes.html")



    print (f"\tO Relatório da Tabela STG_MVT_CRD.xlsx foi criado com sucesso!")


else:
    print ("\tERRO: Arquivo STG_MVT_CRD.xlsx não encontrado")


if path.exists('STG_FNT_ITT.xlsx'):

    #dataframe do o arquivo .xlsx
    cd = pd.read_excel("STG_FNT_ITT.xlsx")

    #pd.set_option('display.max_rows', None)

    #Trata as datas
    cd.DAT_INC_DBO = pd.to_datetime(cd.DAT_INC_DBO, format='%Y-%m-%d', errors='coerce')

    #Verifica as linhas das colunas o tipo desejado
    tipo_ID_STG_FNT_ITT = len([x for x in range(len(cd)) if cd.ID_STG_FNT_ITT[x].dtype == np.int64])
    tipo_NUM_CNPJ = len([x for x in range(len(cd)) if cd.NUM_CNPJ[x].dtype == np.int64])
    tipo_NUM_CMP_CNPJ = len([x for x in range(len(cd)) if cd.NUM_CMP_CNPJ[x].dtype == np.int64])
    tipo_NOM_COM = len([x for x in range(len(cd)) if type(cd.NOM_COM[x]) == str])
    tipo_NOM_RAZ_SCL = len([x for x in range(len(cd)) if type(cd.NOM_RAZ_SCL[x]) == str])
    tipo_DAT_INC_DBO = len([x for x in range(len(cd)) if isinstance(cd.DAT_INC_DBO[x], datetime.date)])

    #Define variáveis para criação do dataframe
    tipos = [tipo_ID_STG_FNT_ITT, tipo_NUM_CNPJ, tipo_NUM_CMP_CNPJ, tipo_NOM_COM,
             tipo_NOM_RAZ_SCL, tipo_DAT_INC_DBO]
    tipos = [tipo * 100 / len(cd) for tipo in tipos]

    #Cria o dataframe
    tipo_review = pd.DataFrame({'Porcentagem': tipos},
                               index=cd.columns)

    #Plota em formato gráfico e exporta para HTML
    data = [go.Bar(x=tipos,
                   y=cd.columns,
                   orientation = 'h',
                   marker=dict(color='#3749E9')
                  )]

    fig = go.Figure(data=data)
    fig.update_yaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_xaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))

    fig.write_html(pasta + "/fnt_tipo.html")

    #Cria um dataframe definido as colunas com dados sensíveis
    dado_sensivel = ['Sim', 'Sim', 'Sim', 'Sim', 'Sim', 'Não']
    sensibilidade_review = pd.DataFrame({'Dado Sensível': dado_sensivel},
                                          index=cd.columns)
    sensibilidade_review = sensibilidade_review.rename_axis('Colunas', axis='columns')

    #Plota em formato tabela e exporta para HTML
    cores = []
    for x in range (len (sensibilidade_review)):
        if x % 2 == 0:
            cores.append('#DEDEDE')
        else:
            cores.append('#ECECEC')

    fig = go.Figure(data=[go.Table(
        header=dict(values=['<b>Colunas</b>', '<b>Dado Sensível</b>'],
                    font=dict(color='#707070', size=14),
                    height=30,
                    line_color = '#707070',
                    fill_color='#ECECEC',
                    align='left'),
        cells=dict(values=[sensibilidade_review.index,
                           dado_sensivel],
                   font=dict(color='#707070', size=14),
                   height=30,
                   line_color = '#707070',
                   fill_color=[cores*2],
                   align=['left', 'right', 'right', 'right']))
    ])

    fig.update_layout(xaxis={'categoryorder':'total ascending'})
    fig.write_html(pasta + "/fnt_tab_sensibilidade.html")

    analisar = cd.notnull().count() # Contando quantos não são nulos.

    total_linhas = cd.shape[0] # Pegando o total de linhas.

    # Colocando em um dicionário os nomes das colunas e seus respectivos totais de não nulos.
    # Também transformando os totais em porcentagem.
    situacao = {x[0] : (x[1] * 100 / total_linhas) for x in analisar.items()}

    # Criando um DataFrame com as informações recolhidas.
    situacao_plot = pd.DataFrame({'COMPLETUDE (%)' : [x for x in situacao.values()]},
                                 index = [x for x in situacao.keys()])

    #Plota em gráfico de barras horizontal
    data = go.Bar(x = [x for x in situacao.values()], 
                  y = [x for x in situacao.keys()], 
                  orientation = 'h', 
                  marker = {'color' : '#3749E9'})

    layout = go.Layout(title = '', 
                       yaxis = {'title': ''}, 
                       xaxis = {'title': 'Porcentagem da Validação (%)'})

    fig = go.Figure(data = data, layout = layout)
    fig.update_yaxes(showline = True, linewidth = 1, linecolor = '#717171')
    fig.update_xaxes(showgrid = True, gridwidth = 1, gridcolor = '#D9D9DE')
    fig.update_layout({'plot_bgcolor': '#FFFFFF', 'paper_bgcolor': '#FFFFFF'})
    fig.write_html(pasta + "/fnt_preenchimento.html")

    #Separa por grupos os valores diferentes encontrados nas colunas de datas
    datas_inc = cd[['DAT_INC_DBO', 'ID_STG_FNT_ITT']]
    datas_inc = datas_inc.groupby('DAT_INC_DBO').count().sort_values(by = 'ID_STG_FNT_ITT', ascending = False)

    #Analisa os valores únicos encontrados e calcula a porcentagem de seu tamanho com o número de linhas da tabela
    conta = 0
    porcentagem = []
    for x in datas_inc.ID_STG_FNT_ITT:
        conta = x * 100 / len(cd)
        porcentagem.append (conta)

    #Acrescenta o resultado ao dataframe
    datas_inc['Porcentagem'] = porcentagem
    datas_inc = datas_inc.rename_axis('Datas Encontradas', axis='columns').drop('ID_STG_FNT_ITT', 1)


    #Concatena e cria uma tabela com todos os resultados
    dados = [datas_inc]
    datas_encontradas = pd.concat(dados)
    datas_encontradas.index.name = None

    #Plota em formato tabela e exporta para HTML
    cores = []
    for x in range (len (datas_encontradas)):
        if x % 2 == 0:
            cores.append('#DEDEDE')
        else:
            cores.append('#ECECEC')
            
    fig = go.Figure(data=[go.Table(
        header=dict(values=['<b>Datas Encontradas</b>','<b>Porcentagem</b>'],
                    font=dict(color='#707070', size=14),
                    height=30,
                    line_color = '#707070',
                    fill_color='#ECECEC',
                    align='left'),
        cells=dict(values=[datas_encontradas.index,
                           datas_encontradas.Porcentagem.map('{:,.0f}%'.format)],
                   font=dict(color='#707070', size=14),
                   height=30,
                   line_color = '#707070',
                   fill_color=[cores*2],
                   align=['left', 'right', 'right', 'right']))
    ])

    fig.update_layout(xaxis={'categoryorder':'total ascending'})

    fig.write_html(pasta + "/fnt_tab_datas.html")

    #Drepeza as linhas vazias
    df = cd[cd['ID_STG_FNT_ITT'].notna()]
    df = df[df['NUM_CNPJ'].notna()]
    df = df[df['NUM_CMP_CNPJ'].notna()]
    df = df[df['NOM_COM'].notna()]
    df = df[df['NOM_RAZ_SCL'].notna()]
    df = df[df['DAT_INC_DBO'].notna()]

    #Agrupa por nomes idênticos
    analise = df.groupby('NOM_RAZ_SCL').count().sort_values(by = 'NUM_CNPJ', ascending = False)
    analise

    #Depreza os nomes idênticos
    nome_repetido = analise[analise['ID_STG_FNT_ITT'] > 1]
    lista = nome_repetido.index

    #Adiciona a listas os CNPJs por nomes idênticos ou únicos
    cnpj_inv = []
    cnpj_c_inv = []
    cnpj_val = []
    cnpj_c_val = []
    for x in range (len (df)):
        if df.NOM_RAZ_SCL[x] in lista:
            cnpj_inv.append (df.NUM_CNPJ[x])
            cnpj_c_inv.append (df.NUM_CMP_CNPJ[x])
        else:    
            cnpj_val.append (df.NUM_CNPJ[x])
            cnpj_c_val.append (df.NUM_CMP_CNPJ[x])


    #Analisa apenas os CNPJs cuja a linha da coluna NUM_CNPJ possui valor único
    cnpjList_val = []
    for c in range (len(cnpj_val)):
        cnpj = str(cnpj_val[c]) + str(cnpj_c_val[c])
        cnpjList_val.append(cnpj)

    #Verifica o tamanho do CNPJ e adiciona a listas de validos ou inválidos, com mais ou com menos de 14 caracteres
    cnpj_valido_val, cnpj_valido, cnpj_nao_valido = [], [], []
    cnpj_mais, cnpj_menos = [], []
    for c in range (len(cnpjList_val)):
        charCNPJ = len(cnpjList_val[c])
        if charCNPJ == 14:
            cnpj_valido_val.append(cnpjList_val[c])
        else:
            cnpj_nao_valido.append(cnpjList_val[c])
        if charCNPJ > 14:
            cnpj_mais.append(cnpjList_val[c])
        if charCNPJ < 14:
            cnpj_menos.append(cnpjList_val[c])

    #Analisa apenas os CNPJs cuja a linha da coluna NUM_CNPJ possui valores idênticos
    cnpjList_inv = []
    for c in range (len(cnpj_inv)):
        cnpj = str(cnpj_inv[c]) + str(cnpj_c_inv[c])
        cnpjList_inv.append(cnpj)

    #Verifica o tamanho do CNPJ e adiciona a listas de validos ou inválidos, com mais ou com menos de 14 caracteres
    for c in range (len(cnpjList_inv)):
        charCNPJ = len(cnpjList_inv[c])
        if charCNPJ == 14:
            cnpj_valido.append(cnpjList_inv[c])
        else:
            cnpj_nao_valido.append(cnpjList_inv[c])
        if charCNPJ > 14:
            cnpj_mais.append(cnpjList_inv[c])
        if charCNPJ < 14:
            cnpj_menos.append(cnpjList_inv[c])

    #len(cnpjList_val), len(cnpjList_inv), len(cnpj_valido_val), len(cnpj_valido), len(cnpj_nao_valido), len(cnpj_mais), len(cnpj_menos)

    #Plota em gráfico de setores
    cnpjs_unicos = len(np.unique(cnpj_valido_val))
    cnpjs_unicos = cnpjs_unicos + len(np.unique(cnpj_valido))
    cnpjs_identicos = len(cnpj_valido_val) + len(cnpj_valido) - cnpjs_unicos

    valores_unicos = cnpjs_unicos*100/(len(cnpj_valido_val) + len(cnpj_valido))
    valores_identicos = 100 - valores_unicos

    labels = ['CNJPs Validados Únicos', 'CNJPs Validados Idênticos']
    colors = ['#cfe509', '#3749e9']
    sizes = [valores_unicos, valores_identicos]
    explode = (0, 0.05)

    fig = go.Figure(data=[go.Pie(labels=labels, values=sizes)])
    fig.update_traces(marker=dict(colors=colors, line=dict(color='#000000', width=0)))
    
    fig.write_html(pasta + "/fnt_cnpjs_unicos.html")

    #Plota em gráfico de setores
    cnpjs_unicos = np.unique(cnpj_valido_val)
    cnpjs_unicos = len(cnpjs_unicos)
    cnpjs_identicos = len(cnpj_valido_val) - cnpjs_unicos

    #CNPJs válidos
    op_vld = cnpjs_unicos
    vld = (op_vld*100) / len(df)

    #CNPJs descartados, mas válidos
    op_inv = len(cnpj_valido) + cnpjs_identicos
    inv = (op_inv*100) / len(df)

    #CNPJs não válidos
    op_nvld = len(cnpj_nao_valido)
    nvld = (op_nvld*100) / len(df)

    labels = 'Válidos', 'Invalidados', 'Não válidos'
    colors = ['#cfe509', '#3749e9', '#112244']
    sizes = [vld, inv, nvld]
    explode = (0, 0.05, 0.05)

    fig = go.Figure(data=[go.Pie(labels=labels, values=sizes)])
    fig.update_traces(marker=dict(colors=colors, line=dict(color='#000000', width=0)))
    fig.write_html(pasta + "/fnt_cnpjs_validos.html")

    #Plota em gráfico de setores
    # +14 Char
    op_mais14 = len(cnpj_mais)
    mais_14_char = (op_mais14*100) / len (df)

    # -14 Char
    op_menos14 = len(cnpj_menos)
    menos_14_char = (op_menos14*100) / len (df)

    labels = '+14 Caracteres', '-14 Caracteres', '14 Caracteres (Correto)'
    colors = ['#cfe509', '#3749e9', '#112244']
    sizes = [mais_14_char, menos_14_char, vld+inv]
    explode = (0.03, 0.03, 0.03)

    fig = go.Figure(data=[go.Pie(labels=labels, values=sizes)])
    fig.update_traces(marker=dict(colors=colors, line=dict(color='#000000', width=0)))

    fig.write_html(pasta + "/fnt_cnpjs_caracteres.html")

    #Plota em gráfico de setores
    nome_identico = analise[analise['ID_STG_FNT_ITT'] > 1]
    nome_identico = nome_identico.ID_STG_FNT_ITT.sum()*100/len(df)
    nome_unico = 100 - nome_identico

    labels = ['Nomes Únicos', 'Nomes Idênticos']
    colors = ['#cfe509', '#3749e9', '#112244']
    sizes = [nome_unico, nome_identico]
    explode = (0, 0.05)

    fig = go.Figure(data=[go.Pie(labels=labels, values=sizes)])
    fig.update_traces(marker=dict(colors=colors, line=dict(color='#000000', width=0)))
    fig.write_html(pasta + "/fnt_nomes_unicos.html")

    print (f"\tO Relatório da Tabela STG_FNT_ITT.xlsx foi criado com sucesso!")
    


else:
    print ("\tERRO: Arquivo STG_FNT_ITT.xlsx não encontrado")

if path.exists('STG_OPR_ITT.xlsx'):

    # DataFrame principal.
    dados_STG_OPR_ITT = pd.read_excel('STG_OPR_ITT.xlsx') # DataFrame de Operações.

    # DataFrame para validação (esse será usado para validar as modalidades do principal).
    dados_STG_MDL = pd.read_excel('STG_MDL.xlsx') # DataFrame das Modalidades.

    # DataFrame para validação (esse será usado para validar os ID's das fontes do principal).
    dados_STG_FNT_ITT = pd.read_excel('STG_FNT_ITT.xlsx') # DataFrame das Fontes.

    linhas = dados_STG_OPR_ITT.shape[0] # Pegando o total de linhas.
    colunas = dados_STG_OPR_ITT.shape[1] # Pegando o total de colunas.

    dados_STG_OPR_ITT.DAT_RSS_FNT_ITT = pd.to_datetime(dados_STG_OPR_ITT.DAT_RSS_FNT_ITT, format='%Y-%m-%d', errors='coerce')
    dados_STG_OPR_ITT.DAT_INC_DBO = pd.to_datetime(dados_STG_OPR_ITT.DAT_INC_DBO, format='%Y-%m-%d', errors='coerce')

    dict_tipo = {'ID_STG_OPR_ITT': int, 'VLR_CTRD_CSC': float, 'QTD_PCL': int, 'VLR_SDO_DDR': float,
                 'QTD_CLI_CAD_POS': int, 'QTD_OPR': int, 'ID_FNT_ITT': int, 'ID_MDL': str,
                 'DES_TIP_PSS': ('F' or 'J'), 'DAT_RSS_FNT_ITT': datetime.date, 'DAT_INC_DBO': datetime.date}

    dict_analise = {}

    for coluna, tipo in dict_tipo.items():
        
        dict_analise[coluna] = len([linha for linha in dados_STG_OPR_ITT[coluna] 
                                    if (type(linha) == tipo) or (linha == tipo) or (isinstance(linha, tipo))])
                

    total = dados_STG_OPR_ITT.shape[0]

    final = [x * 100 / total for x in dict_analise.values()]

    tipo_review = pd.DataFrame({'Porcentagem': final},
                               index=dict_analise.keys())

    data = [go.Bar(x = final,
                   y = [x for x in dict_analise.keys()],
                   orientation = 'h',
                   marker=dict(color='#3749E9')
                  )]

    fig = go.Figure(data=data)
    fig.update_yaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_xaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))

    fig.write_html(pasta + '/opr_tipo.html')

    #Cria um dataframe definido as colunas com dados sensíveis
    dado_sensivel = ['Não', 'Não', 'Não', 'Não', 'Não', 'Não', 'Sim', 'Não', 'Não', 'Não', 'Não']

    sensibilidade_review = pd.DataFrame({'Dado Sensível': dado_sensivel},
                                          index = dados_STG_OPR_ITT.columns)

    sensibilidade_review = sensibilidade_review.rename_axis('Colunas', axis = 'columns')

    #Plota em formato tabela e exporta para HTML
    cores = []
    for x in range (len (sensibilidade_review)):
        if x % 2 == 0:
            cores.append('#DEDEDE')
        else:
            cores.append('#ECECEC')

    fig = go.Figure(data=[go.Table(
        header=dict(values=['<b>Colunas</b>', '<b>Dado Sensível</b>'],
                    font=dict(color='#707070', size=14),
                    height=30,
                    line_color = '#707070',
                    fill_color='#ECECEC',
                    align='left'),
        cells=dict(values=[sensibilidade_review.index,
                           dado_sensivel],
                   font=dict(color='#707070', size=14),
                   height=30,
                   line_color = '#707070',
                   fill_color=[cores*2],
                   align=['left', 'right', 'right', 'right']))
    ])

    fig.update_layout(xaxis={'categoryorder':'total ascending'})

    fig.write_html(pasta + '/opr_dados_sensiveis.html')

    modalidades = dados_STG_OPR_ITT['ID_MDL'].unique() # Pegando somente os IDs únicos para ser validado.

    # Atribuindo os códigos existentes em uma lista para poder usar o 'in'. 
    codigos_existentes = [x for x in dados_STG_MDL['COD_MDL']] 

    count_validos_mdl = len([codigo for codigo in modalidades if codigo in codigos_existentes])

    porcentagem_mdl = count_validos_mdl * 100 / len(modalidades)

    fontes = dados_STG_OPR_ITT['ID_FNT_ITT'].unique() # Pegando somente os IDs únicos para ser validado.

    # Atribuindo os códigos existentes em uma lista para poder usar o 'in'. 
    codigos_existentes = [x for x in dados_STG_FNT_ITT['ID_STG_FNT_ITT']] 

    count_validos_fontes = len([codigo for codigo in fontes if codigo in codigos_existentes])

    porcentagem_fontes = count_validos_fontes * 100 / len(fontes)

    colunas_validar = ['Códigos de Modalidades', 'IDs de Fontes']
    encontrados = [len(modalidades), len(fontes)]
    porcentagens = [porcentagem_mdl, porcentagem_fontes]

    correspondencia_review = pd.DataFrame({'Encontrados': encontrados,
                                           'Correspondência': porcentagens},
                                          index = colunas_validar)
    correspondencia_review = correspondencia_review.rename_axis('Colunas', axis='columns')

    #Plota em formato tabela e exporta para HTML
    cores = []
    for x in range (len (correspondencia_review)):
        if x % 2 == 0:
            cores.append('#DEDEDE')
        else:
            cores.append('#ECECEC')

    fig = go.Figure(data=[go.Table(
        header=dict(values=['<b>Colunas</b>', '<b>Encontrados</b>', '<b>Correspondência</b>'],
                    font=dict(color='#707070', size=14),
                    height=30,
                    line_color = '#707070',
                    fill_color='#ECECEC',
                    align='left'),
        cells=dict(values=[correspondencia_review.index,
                           correspondencia_review.Encontrados,
                           correspondencia_review.Correspondência],
                   font=dict(color='#707070', size=14),
                   height=30,
                   line_color = '#707070',
                   fill_color=[cores*2],
                   align=['left', 'right', 'right', 'right']))
    ])

    fig.update_layout(xaxis={'categoryorder':'total ascending'})

    fig.write_html(pasta + '/opr_correspondencia.html')

    # Retirando as colunas VLR_CTRD_CSC e VLR_SDO_DDR para realizar a análise.
    temp = dados_STG_OPR_ITT.drop(columns = ['VLR_CTRD_CSC', 'VLR_SDO_DDR'])

    # Retirando as linhas com o ID_MDL igual a C01 (consórcio).
    temp = temp[temp['ID_MDL'] != 'C01'] 
    analisar = temp.notnull().count() # Contando quantos não são nulos.

    total_linhas = temp.shape[0] # Pegando o total de linhas.

    # Colocando em um dicionário os nomes das colunas e seus respectivos totais de não nulos.
    # Também transformando os totais em porcentagem.
    situacao = {x[0] : (x[1] * 100 / total_linhas) for x in analisar.items()}

    # Criando um DataFrame com as informações recolhidas.
    situacao_plot = pd.DataFrame({'COMPLETUDE (%)' : [x for x in situacao.values()]},
                                 index = [x for x in situacao.keys()])

    data = go.Bar(x = [x for x in situacao.values()], 
                  y = [x for x in situacao.keys()], 
                  orientation = 'h', 
                  marker = {'color' : '#3749E9'})

    layout = go.Layout(title = '', 
                       yaxis = {'title': ''}, 
                       xaxis = {'title': 'Porcentagem da Validação (%)'})

    fig = go.Figure(data = data, layout = layout)
    fig.update_yaxes(showline = True, linewidth = 1, linecolor = '#717171')
    fig.update_xaxes(showgrid = True, gridwidth = 1, gridcolor = '#D9D9DE')
    fig.update_layout({'plot_bgcolor': '#FFFFFF', 'paper_bgcolor': '#FFFFFF'})

    fig.write_html(pasta + "/opr_completude_sem_consorcio.html")

    # Copiando o DataFrame principal.
    temp = dados_STG_OPR_ITT.copy()
    # Selecionando somente as linhas com o ID_MDL igual a C01 (consórcio).
    temp = temp[temp['ID_MDL'] == 'C01']
    analisar = temp.notnull().count() # Contando quantos não são nulos.

    total_linhas = temp.shape[0] # Pegando o total de linhas.

    # Colocando em um dicionário os nomes das colunas e seus respectivos totais de não nulos.
    # Também transformando os totais em porcentagem.
    situacao = {x[0] : (x[1] * 100 / total_linhas) for x in analisar.items()}

    # Criando um DataFrame com as informações recolhidas.
    situacao_plot = pd.DataFrame({'COMPLETUDE (%)' : [x for x in situacao.values()]},
                                 index = [x for x in situacao.keys()])

    data = go.Bar(x = [x for x in situacao.values()], 
                  y = [x for x in situacao.keys()], 
                  orientation = 'h', 
                  marker = {'color' : '#3749E9'})

    layout = go.Layout(title = '', 
                       yaxis = {'title': ''}, 
                       xaxis = {'title': 'Porcentagem da Validação (%)'})

    fig = go.Figure(data = data, layout = layout)
    fig.update_yaxes(showline = True, linewidth = 1, linecolor = '#717171')
    fig.update_xaxes(showgrid = True, gridwidth = 1, gridcolor = '#D9D9DE')
    fig.update_layout({'plot_bgcolor': '#FFFFFF', 'paper_bgcolor': '#FFFFFF'})

    fig.write_html(pasta + "/opr_completude_com_consorcio.html")

    analisar = dados_STG_OPR_ITT[['ID_STG_OPR_ITT', 'DAT_RSS_FNT_ITT']] 
    DAT_RSS_FNT_ITT = analisar.groupby('DAT_RSS_FNT_ITT').count()

    analisar = dados_STG_OPR_ITT[['ID_STG_OPR_ITT', 'DAT_INC_DBO']]
    DAT_INC_DBO = analisar.groupby('DAT_INC_DBO').count()

    colunas = [DAT_RSS_FNT_ITT, DAT_INC_DBO]
    total_linhas = analisar.shape[0]
    dados = []
    ocorrencia = []
    nome_coluna = []

    for coluna in colunas:
        dados.extend(x for x in coluna.index.values)
        ocorrencia.extend([x * 100 / total_linhas for x in coluna.ID_STG_OPR_ITT.values])
        nome_coluna.extend([coluna.index.name] * (len(dados) - len(nome_coluna)))

    analise =  pd.DataFrame({'DADOS' : [x for x in dados], 
                             'OCORRÊNCIA (%)' : [f'{x:.2f}' for x in ocorrencia]}, 
                            index = [x for x in nome_coluna])

    analise.index.name = 'COLUNAS'

    colunas = ['VLR_CTRD_CSC', 'VLR_SDO_DDR'] # Colunas a serem convertidas.

    for coluna in colunas:

        for index, antes in enumerate(dados_STG_OPR_ITT[coluna].dropna()):
            depois = antes * 0.01
            dados_STG_OPR_ITT[coluna] = dados_STG_OPR_ITT[coluna].replace(antes, depois) # Trocando o velho pelo novo.

    new = dados_STG_MDL[['COD_MDL', 'DES_MDL']] # Escolhendo as colunas necessárias.
    dictionary = new.set_index('COD_MDL').T.to_dict('list') # Convertendo em um dicionário (valores em lista).

    for key, value in dictionary.items():
        dictionary[key] = str(value).strip("['']") # Convertendo os valores (em lista) para string.
        
    dados_STG_OPR_ITT['MDL_DESCRICAO'] = [dictionary[resp] for resp in dados_STG_OPR_ITT['ID_MDL']]

    analisar = dados_STG_OPR_ITT[['MDL_DESCRICAO', 'ID_STG_OPR_ITT']]

    mdl_mais_usadas = analisar.groupby('MDL_DESCRICAO').count().sort_values(by = 'ID_STG_OPR_ITT', ascending = False)

    data = [go.Bar(x = mdl_mais_usadas.index,
                   y = mdl_mais_usadas['ID_STG_OPR_ITT'],
                   marker = dict(color = '#112244')
                  )]

    fig = go.Figure(data = data)
    fig.update_xaxes(showline = True, linewidth = 1, linecolor = '#717171')
    fig.update_yaxes(showgrid = True, gridwidth = 1, gridcolor = '#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(showlegend = False)

    fig.write_html(pasta + "/opr_mdl_mais_usadas.html")

    analisar = dados_STG_OPR_ITT[['MDL_DESCRICAO', 'QTD_OPR']].dropna()

    soma_opr_por_mdl = analisar.groupby('MDL_DESCRICAO').sum().sort_values(by = 'QTD_OPR', ascending = False)

    fig = make_subplots(rows=1, cols=2, column_widths=[0.3, 0.4])

    fig.add_trace(go.Bar(x=soma_opr_por_mdl.index[:4],
               y=soma_opr_por_mdl['QTD_OPR'][:4],
               marker=dict(color='#112244')
              ),
        row=1, col=1
    )

    fig.add_trace(go.Bar(x = soma_opr_por_mdl.index[4:],
                         y = soma_opr_por_mdl['QTD_OPR'][4:],
                         marker = dict(color = '#3749E9')
                        ),
                  row = 1, col = 2
    )

    fig.update_xaxes(showline = True, linewidth = 1, linecolor = '#717171')
    fig.update_yaxes(showgrid = True, gridwidth = 1, gridcolor = '#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(showlegend = False)

    fig.write_html(pasta + "/opr_soma_opr_por_mdl.html")

    analisar = dados_STG_OPR_ITT[['MDL_DESCRICAO', 'QTD_PCL']].dropna()

    soma_parcela_por_mdl = analisar.groupby('MDL_DESCRICAO').sum().sort_values(by = 'QTD_PCL', ascending = False)

    fig = make_subplots(rows = 1, cols = 2, column_widths = [0.1, 0.4])

    fig.add_trace(go.Bar(x = soma_parcela_por_mdl.index[:2],
                         y = soma_parcela_por_mdl['QTD_PCL'][:2],
                         marker = dict(color = '#112244')
                        ),
                  row = 1, col = 1
    )

    fig.add_trace(go.Bar(x = soma_opr_por_mdl.index[4:],
                         y = soma_opr_por_mdl['QTD_OPR'][4:],
                         marker = dict(color = '#3749E9')
                        ),
                  row = 1, col = 2
    )

    fig.update_xaxes(showline = True, linewidth = 1, linecolor = '#717171')
    fig.update_yaxes(showgrid = True, gridwidth = 1, gridcolor = '#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(showlegend = False)

    fig.write_html(pasta + "/opr_soma_pcl_por_mdl.html")

    # Selecionando somente as linhas com o ID_MDL igual a C01 (consórcio).
    analisar = dados_STG_OPR_ITT[dados_STG_OPR_ITT['ID_MDL'] == 'C01'] 
    analisar = analisar[['VLR_CTRD_CSC', 'VLR_SDO_DDR']] # Selecionando somente as colunas necessárias.

    total = [] # Lista temporária.

    for index in analisar.index: # Efeituando a conta e jogando o resultado na lista.
        total.append(round(analisar['VLR_CTRD_CSC'][index] - analisar['VLR_SDO_DDR'][index], 2))

        
    analisar['VLR_PAGO'] = total # Adicionando a lista.

    lista_somas = [analisar['VLR_PAGO'].sum(), analisar['VLR_SDO_DDR'].sum(), analisar['VLR_CTRD_CSC'].sum()]
    lista_nomes = ['Valor Pago', 'Valor Não Pago', 'Valor Total']

    data = [go.Bar(x = lista_nomes,
                   y = lista_somas,
                   marker = dict(color = ['#CFE509', '#112244', '#3749E9'])
                  )]

    fig = go.Figure(data = data)
    fig.update_xaxes(showline = True, linewidth = 1, linecolor = '#717171')
    fig.update_yaxes(showgrid = True, gridwidth = 1, gridcolor = '#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(xaxis = {'categoryorder': 'total descending'}, showlegend = False)

    fig.write_html(pasta + "/opr_grafico_valor_consorcio.html")

    print (f"\tO Relatório da Tabela STG_OPR_ITT.xlsx foi criado com sucesso!")






else:
    print ("\tERRO: Arquivo STG_OPR_ITT.xlsx não encontrado")
    

print ('\n')
print ('Digite:')
print ('\n')
print ('1 - Para abrir a primeira página do relatório')
print ('2 - Para abrir a pasta com todos os arquivos gerados')
print ('3 - Para fechar esse programa')
print ('\n')



def comando(x):
    if x == 1:
        os.system ("start " + "./relatorio/table_FNT.html")
    elif x == 2:
        subprocess.Popen('explorer "relatorio"')
    else:
        return 0

comando(int(input('Digite o comando: ')))
