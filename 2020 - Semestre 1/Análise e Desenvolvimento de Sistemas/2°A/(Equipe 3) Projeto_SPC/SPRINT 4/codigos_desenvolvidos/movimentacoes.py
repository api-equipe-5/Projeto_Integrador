import pandas as pd
import numpy as np
import datetime
from plotly.offline import iplot
import plotly.graph_objs as go
from plotly.subplots import make_subplots


#Define as funções personalizadas necessárias
def write_to_html_file(df, title='', filename='out.html'):
    result = '''
<html>
<head>
<style>

    h2 {
        text-align: center;
        font-family: Helvetica, Arial, sans-serif;
    }
    body{ 
        display: flex;
        align-items: center;
        justify-content: center;
    }
    table { 
        margin-left: auto;
        margin-right: auto;
        width: 90%;
        color: #707070;
    }
    table, th, td {
        border: 1px solid #707070;
        border-collapse: collapse;
    }
    th {
        padding: 5px;
        text-align: left;
        font-family: Helvetica, Arial, sans-serif;
        font-size: 90%;
    }
    td {
        padding: 5px;
        text-align: right;
        font-family: Helvetica, Arial, sans-serif;
        font-size: 90%;
    }
    table tbody tr:hover {
        background-color: #dddddd;
    }
    .wide {
        width: 90%; 
    }

</style>
</head>
<body>
    '''
    result += '<h2> %s </h2>\n' % title
    if type(df) == pd.io.formats.style.Styler:
        result += df.render()
    else:
        result += df.to_html(classes='wide', escape=False)
    result += '''
</body>
</html>
'''
    with open(filename, 'w') as f:
        f.write(result)

formatacao = {'Totais dos Pagamentos':"R$ {:,.2f}", 'Pagamentos Atrasados':"R$ {:,.2f}", 'Pagamentos em Dia':"R$ {:,.2f}",
              'Pagamentos Adiantados':"R$ {:,.2f}", 'Número de Pagamentos':"{:,.0f}", 'Número de Clientes':"{:,.0f}",
             'Número de Clientes Atrasados':"{:,.0f}",'Número de Clientes em Dia':"{:,.0f}", 'Número de Clientes Adiantados':"{:,.0f}",
             'Número de Pagamentos Atrasados':"{:,.0f}",'Número de Pagamentos em Dia':"{:,.0f}", 'Número de Pagamentos Adiantados':"{:,.0f}"}

formata_pct = {'% Atrasados':"{:.2f}%", '% em Dia':"{:.2f}%", '% Adiantados':"{:.2f}%"}

def highlight_max(s):    
    is_max = s == s.max()
    return ['color: white; background-color: #3749E9' if v else '' for v in is_max]

def highlight_min(s):
    is_max = s == s.min()
    return ['color: white; background-color: #112244' if v else '' for v in is_max]

def destaque(val):
    color = '#F2F200' if val == 'Sim' else ''
    return 'background: {}'.format(color)

def destaque_coluna(val):
    color = '#F2F200' if val == 0 else ''
    return 'background: {}'.format(color)


def validacao (relatorio, pasta, tabela_mvt, tabela_mdl, tabela_fnt):
    print ("Gerando Relatório de Validação da Tabela STG_MVT_CRD...")
    
    # In[4]:


    #Define variáveis para as tabelas que serão analisadas

    df = pd.read_excel (tabela_mvt)
    cf = pd.read_excel (tabela_mdl)
    bf = pd.read_excel (tabela_fnt)


    # In[5]:


    #df


    # # Validando o tipo de valor

    # In[6]:


    #Trata as datas
    df.DAT_RSS_FNT_ITT = pd.to_datetime(df.DAT_RSS_FNT_ITT, format='%Y-%m-%d', errors='coerce')
    df.DAT_INC_DBO = pd.to_datetime(df.DAT_INC_DBO, format='%Y-%m-%d', errors='coerce')

    #Verifica as linhas das colunas o tipo desejado
    dict_tipo = {'ID_STG_MVT_CRD': int, 'VLR_SDO_UTZ_CRD_RTO': float, 'VLR_TOT_FAT': float, 'VLR_MIM_FAT': float,
                 'VLR_PCL_FAT': float, 'QTD_CLI_CAD_POS': int, 'QTD_MVT': int, 'DES_TIP_PSS': ('F' or 'J'),
                 'ID_FNT_ITT': int, 'COD_MDL': str, 'DAT_RSS_FNT_ITT': datetime.date, 'DAT_INC_DBO': datetime.date}
    dict_analise = {}
    for coluna, tipo in dict_tipo.items():
        dict_analise[coluna] = len([linha for linha in df[coluna]
                                    if (type(linha) == tipo) or (linha == tipo) or (isinstance(linha, tipo))])
                
    #Calcula a porcentagem de preenchimento das colunas
    final = [x * 100 / len (df) for x in dict_analise.values()]

    #Cria um dataframe
    tipo_review = pd.DataFrame({'Porcentagem': final},
                               index=df.columns)
    tipo_review = tipo_review.rename_axis('Colunas', axis='columns')
    #tipo_review


    # In[7]:


    #Plota em formato gráfico e exporta para HTML
    data = [go.Bar(x = final,
                   y = df.columns,
                   orientation = 'h',
                   marker=dict(color='#112244')
                  )]

    fig = go.Figure(data=data)
    fig.update_yaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_xaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(xaxis=dict(ticksuffix = '%'))
    ##iplot(fig)
    fig.write_html(pasta + "/mvt_tipo.html")


    # # Definindo dados sensíveis

    # In[8]:


    #Cria um dataframe definido as colunas com dados sensíveis
    dado_sensivel = ['Não', 'Não', 'Não', 'Não', 'Não', 'Não', 'Não', 'Não', 'Sim', 'Não', 'Não', 'Não']

    sensibilidade_review = pd.DataFrame({'Dado Sensível': dado_sensivel},
                                          index=df.columns)
    sensibilidade_review = sensibilidade_review.rename_axis('Colunas', axis='columns')

    visualiza = (sensibilidade_review
                    .style
                    .applymap(destaque))
    write_to_html_file(visualiza, title='', filename=pasta + "/mvt_tab_sensibilidade.html")
    visualiza


    # # Analisando o cruzamento de tabelas

    # In[9]:


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

    visualiza = (correspondencia_review
                    .style
                    .format({'Correspondência':"{:.2f}%"})
                    .applymap(destaque_coluna, subset=pd.IndexSlice[:, ['Correspondência']]))
    write_to_html_file(visualiza, title='', filename=pasta + "/mvt_tab_correspondencia.html")
    visualiza


    # # Analisando os campos duplicados

    # In[10]:


    #Analisa o número de valores únicos e que não foram duplicados
    unico = [len(np.unique(df.ID_STG_MVT_CRD)) * 100 / len (df)]
    ff = df[['VLR_SDO_UTZ_CRD_RTO', 'VLR_TOT_FAT', 'VLR_MIM_FAT', 'VLR_PCL_FAT', 'QTD_CLI_CAD_POS',
             'QTD_MVT', 'DES_TIP_PSS', 'ID_FNT_ITT',
             'COD_MDL', 'DAT_RSS_FNT_ITT', 'DAT_INC_DBO']]

    for x in ff.columns:
        coluna = df
        if x == 'VLR_SDO_UTZ_CRD_RTO':
            coluna = df[df.COD_MDL == 'E01'] #Analiso apenas a linha do Cheque Especial
        if x == 'VLR_TOT_FAT':
            coluna = df[df.COD_MDL == 'D01'] #Analiso apenas a linha do Cartão de Crédito
        if x == 'VLR_MIM_FAT':
            coluna = df[df.COD_MDL == 'D01'] #Analiso apenas a linha do Cartão de Crédito
        if x == 'VLR_PCL_FAT':
            coluna = df[df.COD_MDL != 'D01'] #Desprezo a linha do Cartão de Crédito
            coluna = coluna[coluna.COD_MDL != 'E01'] #Desprezo a linha do Cheque Especial
        coluna = coluna.replace(0,np.nan)
        soma = coluna.groupby(f'{x}').count()
        soma = soma[soma.ID_STG_MVT_CRD == 1]
        soma = soma.ID_STG_MVT_CRD.sum()
        unico.append (soma * 100 / len (coluna[x]))

    #Cria um dataframe
    unico_review = pd.DataFrame({'Campos Não Duplicados': unico},
                               index=df.columns)
    unico_review = unico_review.rename_axis('Colunas', axis='columns')
    #unico_review


    # In[11]:


    #Define as variáveis excluindo as modalidades que não fazem parte da categoria
    nocredcard = df[df.COD_MDL != 'D01'] #Desprezo a linha do Cartão de Crédito
    nocredcard = nocredcard[nocredcard.COD_MDL != 'E01'] #Desprezo a linha do Cheque Especial
    rotativo = df[df.COD_MDL == 'E01'] #Analiso apenas a linha do Cheque Especial
    cred = df[df.COD_MDL == 'D01'] #Analiso apenas a linha do Cartão de Crédito

    #Verifica se as linhas das colunas não estão vazias
    coluna_id = [x for x in df.ID_STG_MVT_CRD]
    coluna_saldo_rot = [x for x in rotativo.VLR_SDO_UTZ_CRD_RTO]
    coluna_credito_tot = [x for x in cred.VLR_TOT_FAT]
    coluna_credito_min = [x for x in cred.VLR_MIM_FAT]
    coluna_parcelas_tot = [x for x in nocredcard.VLR_PCL_FAT]
    coluna_clientes = [x for x in df.QTD_CLI_CAD_POS]
    coluna_movimentacoes = [x for x in df.QTD_MVT]
    coluna_tipo_pessoa = [x for x in df.DES_TIP_PSS]
    coluna_id_fnt = [x for x in df.ID_FNT_ITT]
    coluna_modalidades = [x for x in df.COD_MDL]
    coluna_data_rss = [x for x in df.DAT_RSS_FNT_ITT]
    coluna_data_inc = [x for x in df.DAT_INC_DBO]

    campos_validos = [coluna_id, coluna_saldo_rot, coluna_credito_tot, coluna_credito_min, coluna_parcelas_tot,
                      coluna_clientes, coluna_movimentacoes, coluna_tipo_pessoa, coluna_id_fnt, coluna_modalidades,
                      coluna_data_rss, coluna_data_inc]


    # In[12]:


    #Plota em gráfico de barras horizontal
    data = go.Bar(y = unico, 
                  x = df.columns, 
                  marker = {'color' : '#00B7CC'})

    layout = go.Layout(title = '', 
                       yaxis = {'title': ''}, 
                       xaxis = {'title': ''})

    fig = go.Figure(data = data, layout = layout)
    fig.update_xaxes(showline = True, linewidth = 1, linecolor = '#717171')
    fig.update_yaxes(showgrid = True, gridwidth = 1, gridcolor = '#D9D9DE')
    fig.update_layout({'plot_bgcolor': '#FFFFFF', 'paper_bgcolor': '#FFFFFF'})
    fig.update_layout(yaxis=dict(ticksuffix = '%'))
    #iplot(fig)
    fig.write_html(pasta + "/mvt_unicos.html")


    # # Filtrando os casos especiais e analisando o preenchimento das células

    # In[13]:


    #Completa espaços vaszios com zero
    df = df.fillna(0)

    #Converte as colunas para os valores corretos
    df.ID_STG_MVT_CRD = df.ID_STG_MVT_CRD.astype (np.int64)
    df.VLR_SDO_UTZ_CRD_RTO = df.VLR_SDO_UTZ_CRD_RTO.astype (np.float64)
    df.VLR_TOT_FAT = df.VLR_TOT_FAT.astype(np.float64)
    df.VLR_MIM_FAT = df.VLR_MIM_FAT.astype(np.float64)
    df.VLR_PCL_FAT = df.VLR_PCL_FAT.astype(np.float64)
    df.QTD_CLI_CAD_POS = df.QTD_CLI_CAD_POS.astype (np.int64)
    df.QTD_MVT = df.QTD_MVT.astype (np.int64)
    df.DES_TIP_PSS = df.DES_TIP_PSS.astype (str)
    df.ID_FNT_ITT = df.ID_FNT_ITT.astype (np.int64)
    df.COD_MDL = df.COD_MDL.astype (str)
    #df.dtypes


    # In[14]:


    #Define as variáveis excluindo as modalidades que não fazem parte da categoria
    nocredcard = df[df.COD_MDL != 'D01'] #Desprezo a linha do Cartão de Crédito
    nocredcard = nocredcard[nocredcard.COD_MDL != 'E01'] #Desprezo a linha do Cheque Especial
    rotativo = df[df.COD_MDL == 'E01'] #Analiso apenas a linha do Cheque Especial
    cred = df[df.COD_MDL == 'D01'] #Analiso apenas a linha do Cartão de Crédito

    #Verifica se as linhas das colunas não estão vazias
    coluna_id = len([x for x in df.ID_STG_MVT_CRD if x != 0]) * 100 / len (df.ID_STG_MVT_CRD)
    coluna_saldo_rot = len([x for x in rotativo.VLR_SDO_UTZ_CRD_RTO if x != 0]) * 100 / len (rotativo.VLR_SDO_UTZ_CRD_RTO)
    coluna_credito_tot = len([x for x in cred.VLR_TOT_FAT if x != 0]) * 100 / len (cred.VLR_TOT_FAT)
    coluna_credito_min = len([x for x in cred.VLR_MIM_FAT if x != 0]) * 100 / len (cred.VLR_MIM_FAT)
    coluna_parcelas_tot = len([x for x in nocredcard.VLR_PCL_FAT if x != 0]) * 100 / len (nocredcard.VLR_PCL_FAT)
    coluna_clientes = len([x for x in df.QTD_CLI_CAD_POS if x != 0]) * 100 / len (df.QTD_CLI_CAD_POS)
    coluna_movimentacoes = len([x for x in df.QTD_MVT if x != 0]) * 100 / len (df.QTD_MVT)
    coluna_tipo_pessoa = len([x for x in df.DES_TIP_PSS if x != 0]) * 100 / len (df.DES_TIP_PSS)
    coluna_id_fnt = len([x for x in df.ID_FNT_ITT if x != 0]) * 100 / len (df.ID_FNT_ITT)
    coluna_modalidades = len([x for x in df.COD_MDL if x != 0]) * 100 / len (df.COD_MDL)
    coluna_data_rss = len([x for x in df.DAT_RSS_FNT_ITT if x != 0]) * 100 / len (df.DAT_RSS_FNT_ITT)
    coluna_data_inc = len([x for x in df.DAT_INC_DBO if x != 0]) * 100 / len (df.DAT_INC_DBO)

    campos_validos = [coluna_id, coluna_saldo_rot, coluna_credito_tot, coluna_credito_min, coluna_parcelas_tot,
                      coluna_clientes, coluna_movimentacoes, coluna_tipo_pessoa, coluna_id_fnt, coluna_modalidades,
                      coluna_data_rss, coluna_data_inc]

    #Cria uma nova tabela com todos os dados obtidos
    tabela_review = pd.DataFrame({'Campos Válidos': campos_validos},
                               index=df.columns)
    tabela_review = tabela_review.rename_axis('Colunas', axis='columns')
    #tabela_review


    # In[15]:


    #Plota em formato gráfico e exporta para HTML
    data = [go.Bar(x=campos_validos,
                   y=df.columns,
                   orientation = 'h',
                   marker=dict(color='#3749E9')
                  )]

    fig = go.Figure(data=data)
    fig.update_yaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_xaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(xaxis=dict(ticksuffix = '%'))
    #iplot(fig)
    fig.write_html(pasta + "/mvt_preenchimento.html")


    # # Descobrindo as datas na tabela

    # In[16]:


    #Separa por grupos os valores diferentes encontrados nas colunas de datas
    datas_inc = df[df['DAT_INC_DBO'] != 0]
    datas_inc = datas_inc.groupby('DAT_INC_DBO').count()
    datas_inc

    datas_rss = df[df['DAT_RSS_FNT_ITT'] != 0]
    datas_rss = datas_rss.groupby('DAT_RSS_FNT_ITT').count()
    datas_rss

    #Analisa os valores únicos encontrados e calcula a porcentagem de seu tamanho com o número de linhas da tabela
    conta = 0
    porcentagem = []

    for x in datas_inc.ID_STG_MVT_CRD:
        conta = x * 100 / len(df)
        porcentagem.append (conta)

    for x in datas_rss.ID_STG_MVT_CRD:
        conta = x * 100 / len(df)
        porcentagem.append (conta)

    #Concatena e cria uma tabela com todos os resultados
    dados = [datas_inc, datas_rss]
    datas_encontradas = pd.concat(dados)
    datas_encontradas = pd.DataFrame({'Porcentagem': porcentagem},
                               index=datas_encontradas.index)
    datas_encontradas = datas_encontradas.rename_axis('Datas Encontradas', axis='columns')
    datas_encontradas.index.name = None

    visualiza = (datas_encontradas
                    .style
                    .format({'Porcentagem':"{:.2f}%"})
                    .applymap(destaque_coluna, subset=pd.IndexSlice[:, ['Porcentagem']]))
    write_to_html_file(visualiza, title='', filename=pasta + "/mvt_tab_datas.html")
    visualiza


    # # Indicadores de Validação

    # In[17]:


    #Calcula a média de preenchimento da remessa
    media_preenchimento = sum (campos_validos) / df.shape[1]

    #Calcula de validação  
    media_validacao = (sum (final) /df.shape[1] + sum (porcentagens) / len (porcentagens)  + sum (porcentagem) / len (porcentagem) ) / 3

    #media_preenchimento, media_validacao

    html_string = '''<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="author" content="git: diegosilva89, ud21">
  <title>METAlitcs - STG_MVT_CRD</title>
  <link rel="stylesheet" href="_style.css">
  <link rel="icon" href="">
</head>

<body>
  <main>
    <div class="header">
      <div class="metalitcs">
        <p><b>METAlitcs</b></p>
      </div>
      <div class="location">
        <div class="leftbox">
          <p>Validação das Tabelas</p>
        </div>
        <div class="rightbox">
          <p>STG_MVT_CRD</p>
        </div>
      </div>
    </div>

    <div class="container">
      <div class="container-menu-col">
        <div class="menu-col">
          <div class="index">
            <p>Validação das Tabelas</p>
          </div>
          <a style="text-decoration: none;" href="table_FNT.html">
            <div class="stg">
              <p>STG_FNT_ITT</p>
            </div>
          </a>
          <a style="text-decoration: none;" href="table_MVT.html">
            <div class="stg-in">
              <p>STG_MVT_CRD</p>
            </div>
          </a>
          <a style="text-decoration: none;" href="table_OPR.html">
            <div class="stg">
              <p>STG_OPR_ITT</p>
            </div>
          </a>
          <a style="text-decoration: none;" href="table_PGT.html">
            <div class="stg">
              <p>STG_PGT</p>
            </div>
          </a>

          <div class="index">
            <p>Resultados da Remessa</p>
          </div>
          <a style="text-decoration: none;" href="result_MVT.html">
            <div class="stg">
              <p>Movimentações</p>
            </div>
          </a>
          <a style="text-decoration: none;" href="result_OPR.html">
            <div class="stg">
              <p>Operações</p>
            </div>
          </a>
          <a style="text-decoration: none;" href="result_PGT.html">
            <div class="stg">
              <p>Pagamentos</p>
            </div>
          </a>

          <div class="index">
            <p>Índice de Pagamentos em Dia</p>
          </div>
          <a style="text-decoration: none;" href="index_MOD.html">
            <div class="stg">
              <p>Por Modalidades</p>
            </div>
          </a>
          <a style="text-decoration: none;" href="index_FaixaVAL.html">
            <div class="stg">
              <p>Por Faixas de Valores</p>
            </div>
          </a>
        </div>
      </div>

      <!-- content of graphs and etc. -->
      <div class="container-content-col">
        <section id="graphs">
          <div class="static_graph_container_01">
            <div class="graph_one">
              <!-- graph form -->
              <div class="head">
                <div class="title">Validade da Tabela</div>
              </div>
              <div class="content">
                <div class="content_percent"> 
                    <div class="percent_value">''' + str(int(media_validacao)) + '''%</div>
                </div>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_two">
              <!-- graph form -->
              <div class="head">
                <div class="title">Média de Preenchimento da Tabela</div>
              </div>
              <div class="content">
                <div class="content_percent">
                    <div class="percent_value">''' + str(int(media_preenchimento)) + '''%</div>
                </div>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_three">
              <!-- graph form -->
              <div class="head">
                <div class="title">Verificação de Campos Não Nulos</div>
                <div class="paragraph">Porcentagem de campos preenchidos por colunas</div>
              </div>
              <div class="content">
                <iframe src=pags/mvt_preenchimento.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_four">
              <!-- graph form -->
              <div class="head">
                <div class="title">Datas Encontradas</div>
                <div class="paragraph">Porcentagem de campos preenchidos nas colunas DAT_INC_DBO e DAT_RSS_FNT_ITT</div>
              </div>
              <div class="content">
                <iframe src=pags/mvt_tab_datas.html></iframe>
              </div>
              <!-- graph form -->
            </div>
          </div>

          <div class="dynamic_graph_container_MVT">
            <div class="graph_one">
              <!-- graph form -->
              <div class="head">
                <div class="title">Validação dos Tipos de Dados</div>
                <div class="paragraph">Porcentagem de campos preenchidos por colunas</div>
              </div>
              <div class="content">
                <iframe src=pags/mvt_tipo.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_two">
              <!-- graph form -->
              <div class="head">
                <div class="title">Validação das IDs de Modalidades e das IDs das Fontes</div>
                <div class="paragraph">Porcentagem de campos preenchidos comparando a existência dos dados encontrados com as tabelas de origem</div>
              </div>
              <div class="content">
                <iframe src=pags/mvt_tab_correspondencia.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_three">
              <!-- graph form -->
              <div class="head">
                <div class="title">Verificação de Dados Idênticos</div>
                <div class="paragraph">Porcentagem de campos preenchidos por colunas</div>
              </div>
              <div class="content">
                <iframe src=pags/mvt_unicos.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_four">
              <!-- graph form -->
              <div class="head">
                <div class="title">Definição das Colunas com Dados Sensíveis</div>
                <div class="paragraph">Porcentagem de campos preenchidos por colunas</div>
              </div>
              <div class="content">
                <iframe src=pags/mvt_tab_sensibilidade.html></iframe>
              </div>
              <!-- graph form -->
            </div>
          </div>
        </section>
      </div>

    </div>
  </main>
</body>

</html>'''

    f = open(relatorio + '/table_MVT.html','w', encoding='utf-8')
    f.write(html_string)
    f.close()

    print(f"O Relatório de Validação da Tabela STG_MVT_CRD foi criado com sucesso!")

def resultados (relatorio, pasta, tabela_mvt, tabela_mdl):
    print ("Gerando Relatório de Resultados das Movimentações...")

    
    # In[4]:


    #Define variáveis para as tabelas que serão analisadas

    df = pd.read_excel (tabela_mvt)
    cf = pd.read_excel (tabela_mdl)


    # In[5]:


    #df


    # # Filtrando os casos especiais e analisando o preenchimento das células

    # In[6]:


    #Trata as datas
    df.DAT_RSS_FNT_ITT = pd.to_datetime(df.DAT_RSS_FNT_ITT, format='%Y-%m-%d', errors='coerce')
    df.DAT_INC_DBO = pd.to_datetime(df.DAT_INC_DBO, format='%Y-%m-%d', errors='coerce')

    #Completa espaços vaszios com zero
    df = df.fillna(0)

    #Converte as colunas para os valores corretos
    df.ID_STG_MVT_CRD = df.ID_STG_MVT_CRD.astype (np.int64)
    df.VLR_SDO_UTZ_CRD_RTO = df.VLR_SDO_UTZ_CRD_RTO.astype (np.float64)
    df.VLR_TOT_FAT = df.VLR_TOT_FAT.astype(np.float64)
    df.VLR_MIM_FAT = df.VLR_MIM_FAT.astype(np.float64)
    df.VLR_PCL_FAT = df.VLR_PCL_FAT.astype(np.float64)
    df.QTD_CLI_CAD_POS = df.QTD_CLI_CAD_POS.astype (np.int64)
    df.QTD_MVT = df.QTD_MVT.astype (np.int64)
    df.DES_TIP_PSS = df.DES_TIP_PSS.astype (str)
    df.ID_FNT_ITT = df.ID_FNT_ITT.astype (np.int64)
    df.COD_MDL = df.COD_MDL.astype (str)
    #df.dtypes


    # # Analisando o valor das parcelas por modalidade

    # In[7]:


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


    # In[8]:


    #Escolhe as colunas necessárias.
    new = cf[['COD_MDL', 'DES_MDL']]

    #Converte em um dicionário (valores em lista).
    dictionary = new.set_index('COD_MDL').T.to_dict('list')

    #Converte os valores (em lista) para string.
    for key, value in dictionary.items():
        dictionary[key] = str(value).strip("['']")

    #Verifica se existe no dicionário e adiciona a uma lista
    descricao = []
    for resp in df['COD_MDL']:
        if resp in dictionary:
            descricao.append(dictionary[resp])
        else:
            descricao.append(f'{resp} (MODALIDADE NAO ENCONTRADA)')

    #Cria uma nova coluna com as descrições encontradas
    df['DES_MDL'] = descricao


    # In[9]:


    #Filtra a tabela analisada para criar um novo dataframe
    credito = df.query('DES_MDL == "CARTAO DE CREDITO"')
    credito = credito.groupby(['DES_MDL']).max().dropna()

    cheque = df.query('DES_MDL == "CHEQUE ESPECIAL E CONTA GARANTIDA"')
    cheque = cheque.groupby(['DES_MDL']).max().dropna()

    ff = df[df.DES_MDL != "CARTAO DE CREDITO"]
    ff = ff[ff.DES_MDL != "CHEQUE ESPECIAL E CONTA GARANTIDA"]

    parcelas_labels = [x for x in ff.DES_MDL]
    parcelas_labels.append ('CARTAO DE CREDITO - VLR TOTAL FATURA')
    parcelas_labels.append ('CARTAO DE CREDITO - VLR MINIMO FATURA')
    parcelas_labels.append ('CHEQUE ESPECIAL - SALDO DEVEDOR')

    parcelas_values = [x for x in ff.VLR_PCL_FAT]
    parcelas_values.append (credito.loc['CARTAO DE CREDITO','VLR_TOT_FAT'])
    parcelas_values.append (credito.loc['CARTAO DE CREDITO','VLR_MIM_FAT'])
    parcelas_values.append (cheque.loc['CHEQUE ESPECIAL E CONTA GARANTIDA','VLR_SDO_UTZ_CRD_RTO'])

    movimentacoes_values = [x for x in ff.QTD_MVT]
    movimentacoes_values.append (credito.loc['CARTAO DE CREDITO','QTD_MVT'])
    movimentacoes_values.append (credito.loc['CARTAO DE CREDITO','QTD_MVT'])
    movimentacoes_values.append (cheque.loc['CHEQUE ESPECIAL E CONTA GARANTIDA','QTD_MVT'])

    clientes_values = [x for x in ff.QTD_CLI_CAD_POS]
    clientes_values.append (credito.loc['CARTAO DE CREDITO','QTD_CLI_CAD_POS'])
    clientes_values.append (credito.loc['CARTAO DE CREDITO','QTD_CLI_CAD_POS'])
    clientes_values.append (cheque.loc['CHEQUE ESPECIAL E CONTA GARANTIDA','QTD_CLI_CAD_POS'])

    #Cria uma nova tabela com todos os dados obtidos
    parcela = pd.DataFrame({'Modalidades': parcelas_labels,
                            'Valor das Parcelas': parcelas_values,
                            'Número de Movimentações' : movimentacoes_values,
                            'Número de Clientes': clientes_values})
    parcela = parcela.set_index('Modalidades').rename_axis('Modalidades', axis='columns').sort_values(by = 'Valor das Parcelas', ascending = True)
    parcela.index.name = None

    visualiza = parcela.replace(to_replace = 0, value = np.nan)

    visualiza = (visualiza
                    .style
                    .format({'Valor das Parcelas':"R$ {:,.2f}", 'Número de Movimentações':"{:,.0f}", 'Número de Clientes':"{:,.0f}"}, na_rep="-")
                    .highlight_null(null_color='#F2F200')
                    .apply(highlight_max)
                    .apply(highlight_min))
    write_to_html_file(visualiza, title='', filename=pasta + "/mvt_tab_modalidades.html")
    visualiza


    # In[10]:


    #Reformata o dataframe
    parcela = pd.DataFrame({'Valor das Parcelas': parcelas_values,
                            'Número de Movimentações' : movimentacoes_values,
                            'Número de Clientes': clientes_values},
                          index=parcelas_labels)
    parcela = parcela.rename_axis('Modalidades', axis='columns')

    #Define escalas para o tamanho máximo padrão dos gráficos
    parcelas_range = [0, round(max(parcelas_values))]
    movimentacoes_range = [0, round(max(movimentacoes_values))]
    clientes_range = [0, round(max(clientes_values))]

    #Filtra valores menores ou iguais a 1 milhão
    parcela_menor = parcela[parcela['Valor das Parcelas'] > 0]
    parcela_menor = parcela_menor[parcela_menor['Valor das Parcelas'] <= 100000000]
    parcela_menor = parcela_menor.sort_values(by = 'Valor das Parcelas', ascending = True)

    #Filtra valores maiores que 1 milhão e menores e iguais a 5 bilhões
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
               marker=dict(color=['#00B7CC', '#FFAA00'])
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

    #iplot(fig)

    fig.write_html(pasta + "/mvt_modalidades.html")


    # # Analisando o número de clientes e movimentações por modalidade

    # In[11]:


    #Plota em formato tabela e exporta para HTML
    data = [go.Bar(x=df.DES_MDL,
                   y=df.QTD_CLI_CAD_POS,
                   name='Número de Clientes',
                   marker=dict(color='#3749E9')
                  ),
            go.Bar(x=df.DES_MDL,
                   y=df.QTD_MVT,
                   name='Número de Movimentações',
                   marker=dict(color='#112244')
                  )]

    fig = go.Figure(data=data)

    fig = go.Figure(data=data)
    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(xaxis={'categoryorder':'total ascending'}, showlegend=True)

    #iplot(fig)
    fig.write_html(pasta + "/mvt_clientes_movimentacoes.html")


    # # Analisando o número de clientes por modalidade

    # In[12]:


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

    #iplot(fig)

    fig.write_html(pasta + "/mvt_clientes.html")


    # # Analisando o número de movimentações por modalidade

    # In[13]:


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

    #iplot(fig)
    fig.write_html(pasta + "/mvt_movimentacoes.html")


    # # Calculando os indicadores gerais

    # In[14]:


    #Calcula os resultados totais da remessa
    remessa_total_parcelas = df.VLR_PCL_FAT.sum()
    remessa_total_credito = df.VLR_TOT_FAT.sum()
    remessa_minimo_credito = df.VLR_MIM_FAT.sum()
    remessa_num_movimentacoes = df.QTD_MVT.sum()

    #remessa_total_parcelas, remessa_total_credito, remessa_minimo_credito, remessa_num_movimentacoes

    html_string = '''<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="author" content="git: diegosilva89, ud21">
  <title>METAlitcs - Movimentações</title>
  <link rel="stylesheet" href="_style.css">
  <link rel="icon" href="">
</head>

<body>
  <main>
    <div class="header">
      <div class="metalitcs">
        <p><b>METAlitcs</b></p>
      </div>
      <div class="location">
        <div class="leftbox">
          <p>Resultados da Remessa</p>
        </div>
        <div class="rightbox">
          <p>Movimentações</p>
        </div>
      </div>
    </div>

    <div class="container">
      <div class="container-menu-col">
        <div class="menu-col">
          <div class="index">
            <p>Validação das Tabelas</p>
          </div>
          <a style="text-decoration: none;" href="table_FNT.html">
            <div class="stg">
              <p>STG_FNT_ITT</p>
            </div>
          </a>
          <a style="text-decoration: none;" href="table_MVT.html">
            <div class="stg">
              <p>STG_MVT_CRD</p>
            </div>
          </a>
          <a style="text-decoration: none;" href="table_OPR.html">
            <div class="stg">
              <p>STG_OPR_ITT</p>
            </div>
          </a>
          <a style="text-decoration: none;" href="table_PGT.html">
            <div class="stg">
              <p>STG_PGT</p>
            </div>
          </a>

          <div class="index">
            <p>Resultados da Remessa</p>
          </div>
          <a style="text-decoration: none;" href="result_MVT.html">
            <div class="stg-in">
              <p>Movimentações</p>
            </div>
          </a>
          <a style="text-decoration: none;" href="result_OPR.html">
            <div class="stg">
              <p>Operações</p>
            </div>
          </a>
          <a style="text-decoration: none;" href="result_PGT.html">
            <div class="stg">
              <p>Pagamentos</p>
            </div>
          </a>

          <div class="index">
            <p>Índice de Pagamentos em Dia</p>
          </div>
          <a style="text-decoration: none;" href="index_MOD.html">
            <div class="stg">
              <p>Por Modalidades</p>
            </div>
          </a>
          <a style="text-decoration: none;" href="index_FaixaVAL.html">
            <div class="stg">
              <p>Por Faixas de Valores</p>
            </div>
          </a>
        </div>
      </div>

      <!-- content of graphs and etc. -->
      <div class="container-content-col">
        <section id="graphs">
          <div class="static_graph_container_02">
            <div class="graph_one">
              <!-- graph form -->
              <div class="head">
                <div class="title">Valor Total das Parcelas</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">R$ ''' + str("{:,.2f}".format(remessa_total_parcelas)) + '''</div>                
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_two">
              <!-- graph form -->
              <div class="head">
                <div class="title">Valor Total das Faturas do Cartão de Crédito</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">R$ ''' + str("{:,.0f}".format(remessa_total_credito)) + '''</div>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_three">
              <!-- graph form -->
              <div class="head">
                <div class="title">Valor Mínimo das Faturas do Cartão de Crédito</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">R$ ''' + str("{:,.2f}".format(remessa_minimo_credito)) + '''</div>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_four">
              <!-- graph form -->
              <div class="head">
                <div class="title">Quantidade Total de Movimentações</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">''' + str(int(remessa_num_movimentacoes)) + '''</div>
              </div>
              <!-- graph form -->
            </div>
          </div>
          <div class="dynamic_graph_container_result_MVT">
            <div class="graph_five">
              <!-- graph form -->
              <div class="head">
                <div class="title">Valor Total das Movimentações</div>
                <div class="paragraph">Valor das parcelas, valor das faturas ou saldo devedor por modalidades</div>
              </div>
              <div class="content">
                <iframe src=pags/mvt_modalidades.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_six">
              <!-- graph form -->
              <div class="head">
                <div class="title">Tabela de Movimentações por Modalidades</div>
                <div class="paragraph">Valor de parcelas, valor de faturas (cartão de crédito) ou saldo devedor 
                  (cheque especial), número de clientes e número de movimentações
                </div>
              </div>
              <div class="content">
                <iframe src=pags/mvt_tab_modalidades.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_seven">
              <!-- graph form -->
              <div class="head">
                <div class="title">Comparação do Número Total de Clientes e Movimentações</div>
                <div class="paragraph">Por modalidades</div>
              </div>
              <div class="content">
                <iframe src=pags/mvt_clientes_movimentacoes.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_eight">
              <!-- graph form -->
              <div class="head">
                <div class="title">Número Total de Clientes</div>
                <div class="paragraph">Por modalidades</div>
              </div>
              <div class="content">
                <iframe src=pags/mvt_clientes.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_nine">
              <!-- graph form -->
              <div class="head">
                <div class="title">Número Total de Movimentações</div>
                <div class="paragraph">Por modalidades</div>
              </div>
              <div class="content">
                <iframe src=pags/mvt_movimentacoes.html></iframe>
              </div>
              <!-- graph form -->
            </div>
          </div>
        </section>
      </div>
  </main>
</body>

</html>'''

    f = open(relatorio + '/result_MVT.html','w', encoding='utf-8')
    f.write(html_string)
    f.close()

    print (f"O Relatório de Resultados das Movimentações foi criado com sucesso!")
