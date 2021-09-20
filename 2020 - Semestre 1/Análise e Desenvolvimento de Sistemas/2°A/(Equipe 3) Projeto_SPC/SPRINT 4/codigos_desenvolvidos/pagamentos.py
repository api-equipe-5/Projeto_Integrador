import pandas as pd
import numpy as np
import datetime
from plotly.offline import iplot
import plotly.graph_objs as go
from plotly.subplots import make_subplots
import os


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


def validacao (relatorio, pasta, tabela_pgt, tabela_mdl, tabela_fnt):
    print ("Gerando Relatório de Validação da Tabela STG_PGT...")
    
    # In[4]:


    #Carregas os dataframes

    df = pd.read_excel (tabela_pgt)
    cf = pd.read_excel (tabela_mdl)
    bf = pd.read_excel (tabela_fnt)


    # In[5]:


    #df


    # In[6]:


    #df.dtypes


    # # Verificando os tipos das colunas

    # In[7]:


    #Trata as datas
    df.DAT_VCT = pd.to_datetime(df.DAT_VCT, format='%d%m%Y', errors='coerce')
    df.DAT_RSS_FNT_ITT = pd.to_datetime(df.DAT_RSS_FNT_ITT, format='%Y-%m-%d', errors='coerce')
    df.DAT_INC_DBO = pd.to_datetime(df.DAT_INC_DBO, format='%Y-%m-%d', errors='coerce')

    #Verifica as linhas das colunas o tipo desejado
    dict_tipo = {'ID_STG_PGT': int, 'VLR_PGT_FAT': int, 'DAT_VCT': datetime.date, 'COD_MDL': str,
                 'QTD_CLI_CAD_POS': int, 'QTD_PGT': int, 'ID_FNT_ITT': int, 'DES_TIP_PSS': ('F' or 'J'),
                 'DAT_RSS_FNT_ITT': datetime.date, 'DAT_INC_DBO': datetime.date}
    dict_analise = {}
    for coluna, tipo in dict_tipo.items():
        dict_analise[coluna] = len([linha for linha in df[coluna]
                                    if (type(linha) == tipo) or (linha == tipo) or (isinstance(linha, tipo))])

    #Calcula a porcentagem do preenchimento por coluna
    final = [x * 100 / len (df) for x in dict_analise.values()]

    #Cria um dataframe
    tipo_review = pd.DataFrame({'Porcentagem': final},
                               index=df.columns)
    tipo_review = tipo_review.rename_axis('Colunas', axis='columns')
    #tipo_review


    # In[8]:


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
    #iplot(fig)
    fig.write_html(pasta + "/pgt_tipo.html")


    # # Define quais colunas possuem dados sensíveis

    # In[9]:


    #Cria um dataframe definindo as colunas com dados sensíveis
    dado_sensivel = ['Não', 'Não', 'Não', 'Não', 'Não', 'Não', 'Sim', 'Não', 'Não', 'Não']

    sensibilidade_review = pd.DataFrame({'Dado Sensível': dado_sensivel},
                                          index=df.columns)
    sensibilidade_review = sensibilidade_review.rename_axis('Colunas', axis='columns')

    visualiza = (sensibilidade_review
                    .style
                    .applymap(destaque))
    write_to_html_file(visualiza, title='', filename=pasta + "/pgt_tab_sensibilidade.html")
    visualiza


    # # Verifica as informações com outras tabelas

    # In[10]:


    #Compara os valores da Tabela PGT com a Tabela FNT
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

    #Cria um dataframe
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
    write_to_html_file(visualiza, title='', filename=pasta + "/pgt_tab_correspondencia.html")
    visualiza


    # # Analisa quantos campos não são duplicados

    # In[11]:


    #Analisa o número de valores únicos e que não foram duplicados
    unico = [len(np.unique(df.ID_STG_PGT)) * 100 / len (df)]
    ff = df[['VLR_PGT_FAT', 'DAT_VCT', 'COD_MDL', 'QTD_CLI_CAD_POS', 'QTD_PGT', 'ID_FNT_ITT', 'DES_TIP_PSS',
             'DAT_RSS_FNT_ITT', 'DAT_INC_DBO']]

    for x in ff.columns:
        coluna = df
        coluna = coluna.replace(0,np.nan)
        soma = coluna.groupby(f'{x}').count()
        soma = soma[soma.ID_STG_PGT == 1]
        soma = soma.ID_STG_PGT.sum()
        unico.append (soma * 100 / len (coluna[x]))

    #Cria um dataframe
    unico_review = pd.DataFrame({'Campos Não Duplicados': unico},
                               index=df.columns)
    unico_review = unico_review.rename_axis('Colunas', axis='columns')
    #unico_review


    # In[12]:


    #Plota em formato gráfico e exporta em HTML
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
    fig.write_html(pasta + "/pgt_unicos.html")


    # # Analisando o preenchimento das colunas

    # In[13]:


    #df.dtypes


    # In[14]:


    #Completa espaços vazios com zero
    df = df.loc[:, df.columns != ('DAT_VCT', 'DAT_RSS_FNT_ITT', 'DAT_INC_DBO')]
    df.fillna(0)

    #Converte as colunas para os valores corretos
    df.ID_STG_PGT = df.ID_STG_PGT.astype (np.int64)
    df.VLR_PGT_FAT = df.VLR_PGT_FAT.astype (np.int64)
    df.COD_MDL = df.COD_MDL.astype(str)
    df.QTD_CLI_CAD_POS = df.QTD_CLI_CAD_POS.astype(np.int64)
    df.QTD_PGT = df.QTD_PGT.astype(np.int64)
    df.ID_FNT_ITT = df.ID_FNT_ITT.astype (np.int64)
    df.DES_TIP_PSS = df.DES_TIP_PSS.astype (str)
    #df.dtypes


    # In[15]:


    #Completa espaços vazios com zero e exclui as linhas com valor zero
    analisar = df.fillna(0)
    analisar = analisar != 0
    analisar = analisar.sum()
    analisar

    #Calcula a porcentagem de preenchimento das colunas
    situacao = {x[0] : (x[1] * 100 / len (df)) for x in analisar.items()}

    #Cria um dataframe
    tabela_review = pd.DataFrame({'COMPLETUDE (%)' : [x for x in situacao.values()]},
                                 index = [x for x in situacao.keys()])
    tabela_review = tabela_review.rename_axis('Colunas', axis='columns')
    tabela_review['COMPLETUDE (%)'][2] = len(df.DAT_VCT) * 100 / len (df)
    #tabela_review


    # In[16]:


    #Plota em formato gráfico e exporta para HTML
    data = [go.Bar(x=tabela_review['COMPLETUDE (%)'],
                   y=[x for x in situacao.keys()],
                   orientation = 'h',
                   marker=dict(color='#3749E9')
                  )]

    fig = go.Figure(data=data)
    fig.update_yaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_xaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(xaxis=dict(ticksuffix = '%'))
    #iplot(fig)
    fig.write_html(pasta + "/pgt_preenchimento.html")


    # # Contando número de datas diferentes

    # In[17]:


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

    for x in datas_inc.ID_STG_PGT:
        conta = x * 100 / len(df)
        porcentagem.append (conta)

    for x in datas_rss.ID_STG_PGT:
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
    write_to_html_file(visualiza, title='', filename=pasta + "/pgt_tab_datas.html")
    visualiza


    # # Indicadores de Validação

    # In[18]:


    #Calcula a média de preenchimento da remessa
    media_preenchimento = sum (tabela_review['COMPLETUDE (%)']) / df.shape[1]

    #Calcula de validação  
    media_validacao = (sum (final) /df.shape[1] + sum (porcentagens) / len (porcentagens)  + sum (porcentagem) / len (porcentagem) ) / 3

    #media_preenchimento, media_validacao

    html_string = '''<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="author" content="git: diegosilva89, ud21">
  <title>METAlitcs - STG_PGT</title>
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
          <p>STG_PGT</p>
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
            <div class="stg-in">
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
                <iframe src=pags/pgt_preenchimento.html></iframe>
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
                <iframe src=pags/pgt_tab_datas.html></iframe>
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
                <iframe src=pags/pgt_tipo.html></iframe>
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
                <iframe src=pags/pgt_tab_correspondencia.html></iframe>
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
                <iframe src=pags/pgt_unicos.html></iframe>
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
                <iframe src=pags/pgt_tab_sensibilidade.html></iframe>
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
    
    f = open(relatorio + '/table_PGT.html','w', encoding='utf-8')
    f.write(html_string)
    f.close()

    print (f"O Relatório de Validação da Tabela STG_PGT foi criado com sucesso!")

def resultados (relatorio, pasta, tabela_pgt, tabela_mdl):
    print ("Gerando Relatório de Resultados dos Pagamentos...")

    # In[4]:


    #Carregas os dataframes
    df = pd.read_excel (tabela_pgt)
    cf = pd.read_excel (tabela_mdl)


    # In[5]:


    #df


    # In[6]:


    #df.dtypes


    # In[7]:


    #Trata as datas
    df.DAT_VCT = pd.to_datetime(df.DAT_VCT, format='%d%m%Y', errors='coerce')
    df.DAT_RSS_FNT_ITT = pd.to_datetime(df.DAT_RSS_FNT_ITT, format='%Y-%m-%d', errors='coerce')
    df.DAT_INC_DBO = pd.to_datetime(df.DAT_INC_DBO, format='%Y-%m-%d', errors='coerce')

    #Completa espaços vazios com zero
    df = df.loc[:, df.columns != ('DAT_VCT', 'DAT_RSS_FNT_ITT', 'DAT_INC_DBO')]
    df.fillna(0)

    #Converte as colunas para os valores corretos
    df.ID_STG_PGT = df.ID_STG_PGT.astype (np.int64)
    df.VLR_PGT_FAT = df.VLR_PGT_FAT.astype (np.int64)
    df.COD_MDL = df.COD_MDL.astype(str)
    df.QTD_CLI_CAD_POS = df.QTD_CLI_CAD_POS.astype(np.int64)
    df.QTD_PGT = df.QTD_PGT.astype(np.int64)
    df.ID_FNT_ITT = df.ID_FNT_ITT.astype (np.int64)
    df.DES_TIP_PSS = df.DES_TIP_PSS.astype (str)
    #df.dtypes


    # # Analisando o valor dos pagamentos vencidos por modalidades

    # In[8]:


    #Converte todos os valores para acrescentar dois decimais
    for c in df.VLR_PGT_FAT:
        d = c * 0.01
        df.VLR_PGT_FAT = df.VLR_PGT_FAT.replace(c, d)


    # In[9]:


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


    # In[10]:


    #Compara a data de vencimento com a data de alteração e exclui as linhas com datas não vencidas
    vencidos = df
    ts = pd.Timestamp
    for x in range (len (df.DAT_VCT)):
        if ts.date(df.DAT_VCT[x]) > ts.date(df.DAT_RSS_FNT_ITT[x]) or (str(df.DAT_VCT[x]) == 'NaT'):
            vencidos = vencidos.drop (x)

    #print (len (vencidos))
    novo_vencidos = vencidos

    #Cria um dataframe
    vencidos = vencidos[['DES_MDL', 'VLR_PGT_FAT', 'QTD_CLI_CAD_POS', 'QTD_PGT']]
    vencidos = vencidos.groupby('DES_MDL').sum()
    vencidos = vencidos.rename(columns={'VLR_PGT_FAT': 'Totais dos Pagamentos', 'QTD_PGT': 'Número de Pagamentos',
                                    'QTD_CLI_CAD_POS': 'Número de Clientes'}).sort_values(by = 'Totais dos Pagamentos', ascending = True)
    vencidos = vencidos.rename_axis('Modalidades', axis='columns')
    vencidos.index.name = None

    visualiza = vencidos.replace(to_replace = 0, value = np.nan)

    visualiza = (visualiza
                    .style
                    .format(formatacao, na_rep="-")
                    .highlight_null(null_color='#F2F200')
                    .apply(highlight_max)
                    .apply(highlight_min))
    write_to_html_file(visualiza, title='', filename=pasta + "/pgt_tab_vencidos.html")
    visualiza


    # In[11]:


    #Define escalas para o tamanho máximo padrão dos gráficos
    vencidos_range = [0, round(max(vencidos['Totais dos Pagamentos']))]

    #Filtra valores menores ou iguais a 100 milhões
    vencidos_menor = vencidos[vencidos['Totais dos Pagamentos'] > 0]
    vencidos_menor = vencidos_menor[vencidos_menor['Totais dos Pagamentos'] <= 100000000]
    vencidos_menor = vencidos_menor.sort_values(by = 'Totais dos Pagamentos', ascending = True)

    #Filtra valores maiores que 100 milhões
    vencidos_maior = vencidos[vencidos['Totais dos Pagamentos'] > 100000000]
    vencidos_maior = vencidos_maior.sort_values(by = 'Totais dos Pagamentos', ascending = False)

    #Plota em formato gráfico e exporta para HTML
    fig = make_subplots(rows=1, cols=2, column_widths=[0.7, 0.7])

    fig.add_trace(go.Bar(x=vencidos_menor.index,
               y=vencidos_menor['Totais dos Pagamentos'].dropna(),
               marker=dict(color='#3749E9')
              ),
        row=1, col=1
    )

    fig.add_trace(go.Bar(x = vencidos_maior.index,
               y = vencidos_maior['Totais dos Pagamentos'].dropna(),
               marker=dict(color='#3749E9')
              ),
        row=1, col=2
    )

    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_yaxes(range=vencidos_range)
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(showlegend=False)

    #iplot(fig)
    fig.write_html(pasta + "/pgt_pagamentos_vencidos.html")


    # # Verificando o valor total de pagamentos por modalidades

    # In[12]:


    #Cria um dataframe
    total_pagamentos = df[['DES_MDL', 'VLR_PGT_FAT']]
    total_pagamentos = total_pagamentos.groupby('DES_MDL').sum().sort_values(by = 'VLR_PGT_FAT')
    #total_pagamentos


    # In[13]:


    #Define escalas para o tamanho máximo padrão dos gráficos
    total_pagamentos_range = [0, round(max(total_pagamentos.VLR_PGT_FAT))]

    #Filtra valores menores ou iguais a 100 milhões
    total_pagamentos_menor = total_pagamentos[total_pagamentos['VLR_PGT_FAT'] > 0]
    total_pagamentos_menor = total_pagamentos_menor[total_pagamentos_menor['VLR_PGT_FAT'] <= 100000000]
    total_pagamentos_menor = total_pagamentos_menor.sort_values(by = 'VLR_PGT_FAT', ascending = True)

    #Filtra valores maiores que 100 milhões
    total_pagamentos_maior = total_pagamentos[total_pagamentos['VLR_PGT_FAT'] > 100000000]
    total_pagamentos_maior = total_pagamentos_maior.sort_values(by = 'VLR_PGT_FAT', ascending = False)

    #Plota em formato gráfico e exporta para HTML
    fig = make_subplots(rows=1, cols=2, column_widths=[0.6, 0.6])

    fig.add_trace(go.Bar(x=total_pagamentos_menor.index,
               y=total_pagamentos_menor['VLR_PGT_FAT'].dropna(),
               marker=dict(color='#112244')
              ),
        row=1, col=1
    )

    fig.add_trace(go.Bar(x = total_pagamentos_maior.index,
               y = total_pagamentos_maior['VLR_PGT_FAT'].dropna(),
               marker=dict(color='#112244')
              ),
        row=1, col=2
    )

    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_yaxes(range=total_pagamentos_range)
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(showlegend=False)

    #iplot(fig)
    fig.write_html(pasta + "/pgt_total_pagamentos.html")


    # # Comparando os Valores de Pagamentos Vencidos e Totais

    # In[14]:


    #Plota em formato gráfico e exporta para HTML
    data = [go.Bar(x=vencidos.index,
                   y=vencidos['Totais dos Pagamentos'],
                   name='Pagamentos Vencidos',
                   marker=dict(color='#3749E9')
                  ),
            go.Bar(x=total_pagamentos.index,
                   y=total_pagamentos['VLR_PGT_FAT'],
                   name='Pagamentos Totais',
                   marker=dict(color='#112244')
                  )]

    fig = go.Figure(data=data)

    fig = go.Figure(data=data)
    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(xaxis={'categoryorder':'total ascending'}, showlegend=True)

    #iplot(fig)
    fig.write_html(pasta + "/pgt_vencidos_totais.html")


    # # Analisando o número total de pagamentos por modalidades

    # In[15]:


    #Cria um dataframe
    num_pagamentos = df[['DES_MDL', 'QTD_PGT']]
    num_pagamentos = num_pagamentos.groupby('DES_MDL').sum().sort_values(by = 'QTD_PGT')
    #num_pagamentos


    # In[16]:


    #Define escalas para o tamanho máximo padrão dos gráficos
    num_pagamentos_range = [0, round(max(num_pagamentos.QTD_PGT))]

    #Filtra valores menores ou iguais a 10 mil
    num_pagamentos_menor = num_pagamentos[num_pagamentos['QTD_PGT'] > 0]
    num_pagamentos_menor = num_pagamentos_menor[num_pagamentos_menor['QTD_PGT'] <= 10000]
    num_pagamentos_menor = num_pagamentos_menor.sort_values(by = 'QTD_PGT', ascending = True)

    #Filtra valores maiores que 10 mil e menores ou iguais a 1 milhão
    num_pagamentos_medio = num_pagamentos[num_pagamentos['QTD_PGT'] > 10000]
    num_pagamentos_medio = num_pagamentos_medio[num_pagamentos_medio['QTD_PGT'] <= 1000000]
    num_pagamentos_medio = num_pagamentos_medio.sort_values(by = 'QTD_PGT', ascending = True)

    #Filtra valores maiores que 1 milhão
    num_pagamentos_maior = num_pagamentos[num_pagamentos['QTD_PGT'] > 1000000]
    num_pagamentos_maior = num_pagamentos_maior.sort_values(by = 'QTD_PGT', ascending = True)

    #Plota em formato gráfico e exporta para HTML
    fig = make_subplots(rows=1, cols=3, column_widths=[0.4, 0.5, 0.5])

    fig.add_trace(go.Bar(x=num_pagamentos_menor.index,
               y=num_pagamentos_menor['QTD_PGT'].dropna(),
               marker=dict(color='#112244')
              ),
        row=1, col=1
    )

    fig.add_trace(go.Bar(x = num_pagamentos_medio.index,
               y = num_pagamentos_medio['QTD_PGT'].dropna(),
               marker=dict(color='#112244')
              ),
        row=1, col=2
    )

    fig.add_trace(go.Bar(x = num_pagamentos_maior.index,
               y = num_pagamentos_maior['QTD_PGT'].dropna(),
               marker=dict(color='#112244')
              ),
        row=1, col=3
    )

    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_yaxes(range=num_pagamentos_range)
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(showlegend=False)

    #iplot(fig)
    fig.write_html(pasta + "/pgt_num_pagamentos.html")


    # # Contando o número de clientes por modalidades

    # In[17]:


    #Cria um dataframe
    clientes = df[['DES_MDL', 'QTD_CLI_CAD_POS']]
    clientes = clientes.groupby('DES_MDL').sum().sort_values(by = 'QTD_CLI_CAD_POS')
    #clientes


    # In[18]:


    #Define escalas para o tamanho máximo padrão dos gráficos
    clientes_range = [0, round(max(clientes.QTD_CLI_CAD_POS))]

    #Filtra valores menores ou iguais a 10 mil
    clientes_menor = clientes[clientes['QTD_CLI_CAD_POS'] > 0]
    clientes_menor = clientes_menor[clientes_menor['QTD_CLI_CAD_POS'] <= 10000]
    clientes_menor = clientes_menor.sort_values(by = 'QTD_CLI_CAD_POS', ascending = True)

    #Filtra valores maiores que 10 mil e menores ou iguais a 1 milhão
    clientes_medio = clientes[clientes['QTD_CLI_CAD_POS'] > 10000]
    clientes_medio = clientes_medio[clientes_medio['QTD_CLI_CAD_POS'] <= 1000000]
    clientes_medio = clientes_medio.sort_values(by = 'QTD_CLI_CAD_POS', ascending = True)

    #Filtra valores maiores que 1 milhão
    clientes_maior = clientes[clientes['QTD_CLI_CAD_POS'] > 1000000]
    clientes_maior = clientes_maior.sort_values(by = 'QTD_CLI_CAD_POS', ascending = True)

    #Plota em formato gráfico e exporta para HTML
    fig = make_subplots(rows=1, cols=3, column_widths=[0.4, 0.5, 0.5])

    fig.add_trace(go.Bar(x=clientes_menor.index,
               y=clientes_menor['QTD_CLI_CAD_POS'].dropna(),
               marker=dict(color='#00B7CC')
              ),
        row=1, col=1
    )

    fig.add_trace(go.Bar(x = clientes_medio.index,
               y = clientes_medio['QTD_CLI_CAD_POS'].dropna(),
               marker=dict(color='#00B7CC')
              ),
        row=1, col=2
    )

    fig.add_trace(go.Bar(x = clientes_maior.index,
               y = clientes_maior['QTD_CLI_CAD_POS'].dropna(),
               marker=dict(color='#00B7CC')
              ),
        row=1, col=3
    )

    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_yaxes(range=clientes_range)
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(showlegend=False)

    #iplot(fig)
    fig.write_html(pasta + "/pgt_clientes.html")


    # # Comparando o número de clientes com o número de pagamentos

    # In[19]:


    #Plota em formato gráfico e exporta para HTML
    data = [go.Bar(x=clientes.index,
                   y=clientes.QTD_CLI_CAD_POS,
                   name='Número de Clientes',
                   marker=dict(color='#00B7CC')
                  ),
            go.Bar(x=num_pagamentos.index,
                   y=num_pagamentos.QTD_PGT,
                   name='Número de Pagamentos',
                   marker=dict(color='#112244')
                  )]

    fig = go.Figure(data=data)

    fig = go.Figure(data=data)
    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(xaxis={'categoryorder':'total ascending'}, showlegend=True)

    #iplot(fig)
    fig.write_html(pasta + "/pgt_clientes_num_pagamentos.html")


    # # Gerando uma tabela geral dos pagamentos por modalidades

    # In[20]:


    #Cria um dataframe geral com as colunas de totais de pagamentos, clientes, e número de pagamentos
    tabela = df[['DES_MDL', 'VLR_PGT_FAT', 'QTD_CLI_CAD_POS', 'QTD_PGT']]
    tabela = tabela.groupby('DES_MDL').sum()
    tabela = tabela.rename(columns={'VLR_PGT_FAT': 'Totais dos Pagamentos', 'QTD_PGT': 'Número de Pagamentos',
                                    'QTD_CLI_CAD_POS': 'Número de Clientes'}).sort_values(by = 'Totais dos Pagamentos', ascending = True)
    tabela = tabela.rename_axis('Modalidades', axis='columns')
    tabela.index.name = None

    visualiza = tabela.replace(to_replace = 0, value = np.nan)

    visualiza = (visualiza
                    .style
                    .format(formatacao, na_rep="-")
                    .highlight_null(null_color='#F2F200')
                    .apply(highlight_max)
                    .apply(highlight_min))
    write_to_html_file(visualiza, title='', filename=pasta + "/pgt_tab_modalidades.html")
    visualiza


    # # Calculando os indicadores gerais

    # In[21]:


    #Calcula os resultados totais da remessa
    remessa_total_pagamentos = df.VLR_PGT_FAT.sum()
    remessa_num_pagamentos = df.QTD_PGT.sum()
    remessa_num_vencidos = novo_vencidos.QTD_PGT.sum()

    #remessa_total_pagamentos, remessa_num_pagamentos, remessa_num_vencidos

    html_string = '''<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="author" content="git: diegosilva89, ud21">
  <title>METAlitcs - Pagamentos</title>
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
          <p>Pagamentos</p>
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
            <div class="stg-in">
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
        <div class="static_graph_container_03">
          <div class="graph_one">
            <!-- graph form -->
            <div class="head">
              <div class="title">Valor Total de Pagamentos</div>
            </div>
            <div class="content_percent">
                <div class="percent_value">R$ ''' + str("{:,.2f}".format(remessa_total_pagamentos)) + '''</div>              
            </div>
            <!-- graph form -->
          </div>
          <div class="graph_two">
            <!-- graph form -->
            <div class="head">
              <div class="title">Quantidade Total de Registros Vencidos</div>
            </div>
            <div class="content_percent">
                <div class="percent_value">''' + str(int(remessa_num_vencidos)) + '''</div>              
            </div>
            <!-- graph form -->
          </div>
          <div class="graph_three">
            <!-- graph form -->
            <div class="head">
              <div class="title">Quantidade Total de Pagamentos</div>
            </div>
            <div class="content_percent">
                <div class="percent_value">''' + str(int(remessa_num_pagamentos)) + '''</div>              
            </div>
            <!-- graph form -->
          </div>
        </div>
        <div class="dynamic_graph_container_result_PGT">
          <div class="graph_five">
            <!-- graph form -->
            <div class="head">
              <div class="title">Comparação dos Valores Totais de Pagamentos e Pagamentos Vencidos</div>
              <div class="paragraph">Por modalidades</div>
            </div>
            <div class="content">
              <iframe src=pags/pgt_vencidos_totais.html></iframe>
            </div>
            <!-- graph form -->
          </div>
          <div class="graph_six">
            <!-- graph form -->
            <div class="head">
              <div class="title">Tabela de Pagamentos por Modalidades</div>
              <div class="paragraph">Valor de pagamentos, número de clientes e número de pagamentos</div>
            </div>
            <div class="content">
              <iframe src=pags/pgt_tab_modalidades.html></iframe>
            </div>
            <!-- graph form -->
          </div>
          <div class="graph_seven">
            <!-- graph form -->
            <div class="head">
              <div class="title">Tabela de Pagamentos Vencidos por Modalidades</div>
              <div class="paragraph">Valor de pagamentos, número de clientes e número de pagamentos</div>
            </div>
            <div class="content">
              <iframe src=pags/pgt_tab_vencidos.html></iframe>
            </div>
            <!-- graph form -->
          </div>
          <div class="graph_eight">
            <!-- graph form -->
            <div class="head">
              <div class="title">Valor Total de Pagamentos Vencidos</div>
              <div class="paragraph">Por modalidades</div>
            </div>
            <div class="content">
              <iframe src=pags/pgt_pagamentos_vencidos.html></iframe>
            </div>
            <!-- graph form -->
          </div>
          <div class="graph_nine">
            <!-- graph form -->
            <div class="head">
              <div class="title">Valor Total de Pagamentos</div>
              <div class="paragraph">Por modalidades</div>
            </div>
            <div class="content">
              <iframe src=pags/pgt_total_pagamentos.html></iframe>
            </div>
            <!-- graph form -->
          </div>
          <div class="graph_ten">
            <!-- graph form -->
            <div class="head">
              <div class="title">Comparação do Número Total de Clientes e Pagamentos</div>
              <div class="paragraph">Por modalidades</div>
            </div>
            <div class="content">
              <iframe src=pags/pgt_clientes_num_pagamentos.html></iframe>
            </div>
            <!-- graph form -->
          </div>
          <div class="graph_eleven">
            <!-- graph form -->
            <div class="head">
              <div class="title">Número Total de Clientes</div>
              <div class="paragraph">Por modalidades</div>
            </div>
            <div class="content">
              <iframe src=pags/pgt_clientes.html></iframe>
            </div>
            <!-- graph form -->
          </div>
          <div class="graph_twelve">
            <!-- graph form -->
            <div class="head">
              <div class="title">Número Total de Pagamentos</div>
              <div class="paragraph">Por modalidades</div>
            </div>
            <div class="content">
              <iframe src=pags/pgt_num_pagamentos.html></iframe>
            </div>
            <!-- graph form -->
          </div>
        </div>
      </div>
    </div>
  </main>
</body>

</html>'''

    f = open(relatorio + '/result_PGT.html','w', encoding='utf-8')
    f.write(html_string)
    f.close()

    print (f"O Relatório de Resultados dos Pagamentos foi criado com sucesso!")

def indice_em_dia_geral (relatorio, pasta, tabela_pgt, tabela_mdl):
    print ("Gerando Relatório dos Índices de Pagamentos em Dia...")
    
    # In[4]:


    #Carregas os dataframes
    df = pd.read_excel (tabela_pgt)
    cf = pd.read_excel (tabela_mdl)


    # In[5]:


    #df


    # In[6]:


    #df.dtypes


    # # Gerando uma tabela geral dos pagamentos por modalidades

    # In[7]:


    #Trata as datas
    df.DAT_VCT = pd.to_datetime(df.DAT_VCT, format='%d%m%Y', errors='coerce')
    df.DAT_RSS_FNT_ITT = pd.to_datetime(df.DAT_RSS_FNT_ITT, format='%Y-%m-%d', errors='coerce')
    df.DAT_INC_DBO = pd.to_datetime(df.DAT_INC_DBO, format='%Y-%m-%d', errors='coerce')

    #Completa espaços vazios com zero
    df = df.loc[:, df.columns != ('DAT_VCT', 'DAT_RSS_FNT_ITT', 'DAT_INC_DBO')]
    df.fillna(0)

    #Converte as colunas para os valores corretos
    df.ID_STG_PGT = df.ID_STG_PGT.astype (np.int64)
    df.VLR_PGT_FAT = df.VLR_PGT_FAT.astype (np.int64)
    df.COD_MDL = df.COD_MDL.astype(str)
    df.QTD_CLI_CAD_POS = df.QTD_CLI_CAD_POS.astype(np.int64)
    df.QTD_PGT = df.QTD_PGT.astype(np.int64)
    df.ID_FNT_ITT = df.ID_FNT_ITT.astype (np.int64)
    df.DES_TIP_PSS = df.DES_TIP_PSS.astype (str)
    #df.dtypes


    # In[8]:


    #Converte todos os valores para acrescentar dois decimais
    for c in df.VLR_PGT_FAT:
        d = c * 0.01
        df.VLR_PGT_FAT = df.VLR_PGT_FAT.replace(c, d)


    # In[9]:


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


    # In[10]:


    #Cria um dataframe geral com as colunas de totais de pagamentos, clientes, e número de pagamentos
    tabela = df[['DES_MDL', 'VLR_PGT_FAT', 'QTD_CLI_CAD_POS', 'QTD_PGT']]
    tabela = tabela.groupby('DES_MDL').sum()
    tabela = tabela.rename(columns={'VLR_PGT_FAT': 'Totais dos Pagamentos', 'QTD_PGT': 'Número de Pagamentos',
                                    'QTD_CLI_CAD_POS': 'Número de Clientes'}).sort_values(by = 'Totais dos Pagamentos', ascending = True)
    tabela = tabela.rename_axis('Modalidades', axis='columns')
    tabela.index.name = None


    # # Fazendo as análises preliminares para gerar os Índices de Pagamentos em Dia

    # In[11]:


    #Compara a data de vencimento com a data de alteração e exclui as linhas com datas não vencidas
    atrasados = df
    ts = pd.Timestamp
    for x in range (len (df.DAT_VCT)):
        if ts.date(df.DAT_VCT[x]) >= ts.date(df.DAT_RSS_FNT_ITT[x]) or (str(df.DAT_VCT[x]) == 'NaT'):
            atrasados = atrasados.drop (x)

    #print (len (atrasados))
    novo_atrasados = atrasados

    #Cria um dataframe
    atrasados = atrasados[['DES_MDL', 'VLR_PGT_FAT', 'QTD_CLI_CAD_POS', 'QTD_PGT']]
    atrasados = atrasados.groupby('DES_MDL').sum().sort_values(by = 'VLR_PGT_FAT', ascending = True)
    atrasados = atrasados.rename(columns={'VLR_PGT_FAT': 'Pagamentos Atrasados', 'QTD_PGT': 'Número de Pagamentos Atrasados',
                                    'QTD_CLI_CAD_POS': 'Número de Clientes Atrasados'}).sort_values(by = 'Pagamentos Atrasados', ascending = True)

    atrasados = atrasados.rename_axis('Modalidades', axis='columns')
    atrasados.index.name = None
    #atrasados


    # In[12]:


    #Compara a data de vencimento com a data de alteração e exclui as linhas com datas vencidas e não vencidas
    em_dia = df
    ts = pd.Timestamp
    for x in range (len (df.DAT_VCT)):
        if (df.DAT_VCT[x] < ts.date(df.DAT_RSS_FNT_ITT[x])) or (df.DAT_VCT[x] > ts(df.DAT_RSS_FNT_ITT[x])) or (str(df.DAT_VCT[x]) == 'NaT'):
            em_dia = em_dia.drop (x)

    #print (len (em_dia))
    novo_em_dia = em_dia

    #Cria um dataframe
    em_dia = em_dia[['DES_MDL', 'VLR_PGT_FAT', 'QTD_CLI_CAD_POS', 'QTD_PGT']]
    em_dia = em_dia.groupby('DES_MDL').sum().sort_values(by = 'VLR_PGT_FAT', ascending = True)
    em_dia = em_dia.rename(columns={'VLR_PGT_FAT': 'Pagamentos em Dia', 'QTD_PGT': 'Número de Pagamentos em Dia',
                                    'QTD_CLI_CAD_POS': 'Número de Clientes em Dia'}).sort_values(by = 'Pagamentos em Dia', ascending = True)
    em_dia = em_dia.rename_axis('Modalidades', axis='columns')
    em_dia.index.name = None
    #em_dia


    # In[13]:


    #Compara a data de vencimento com a data de alteração e exclui as linhas com datas vencidas
    adiantados = df
    ts = pd.Timestamp
    for x in range (len (df.DAT_VCT)):
        if ts.date(df.DAT_VCT[x]) <= ts.date(df.DAT_RSS_FNT_ITT[x]) or (str(df.DAT_VCT[x]) == 'NaT'):
            adiantados = adiantados.drop (x)

    #print (len (adiantados))
    novo_adiantados = adiantados

    #Cria um dataframe
    adiantados = adiantados[['DES_MDL', 'VLR_PGT_FAT', 'QTD_CLI_CAD_POS', 'QTD_PGT']]
    adiantados = adiantados.groupby('DES_MDL').sum().sort_values(by = 'VLR_PGT_FAT', ascending = True)
    adiantados = adiantados.rename(columns={'VLR_PGT_FAT': 'Pagamentos Adiantados', 'QTD_PGT': 'Número de Pagamentos Adiantados',
                                    'QTD_CLI_CAD_POS': 'Número de Clientes Adiantados'}).sort_values(by = 'Pagamentos Adiantados', ascending = True)
    adiantados = adiantados.rename_axis('Modalidades', axis='columns')
    adiantados.index.name = None
    #adiantados


    # In[14]:


    #conta_linhas = (len (novo_atrasados)) + (len (novo_em_dia)) + (len (novo_adiantados))
    #conta_linhas, df.shape[0]


    # In[15]:


    #Cria um novo dataframe concatenando os dataframes anteriores
    dados = [tabela, atrasados, em_dia, adiantados]
    tabela_indice = pd.concat(dados)
    tabela_indice = tabela_indice.groupby(tabela_indice.index).sum()
    #tabela_indice


    # # Índice de Pagamentos em Dia por Valores

    # In[16]:


    #Cria um dataframe apenas com os valores de pagamentos
    tabela_valores = tabela_indice[['Pagamentos Atrasados', 'Pagamentos em Dia', 'Pagamentos Adiantados']]

    visualiza = tabela_valores.replace(to_replace = 0, value = np.nan).sort_values(by = 'Pagamentos Atrasados', ascending = True)

    visualiza = (visualiza
                    .style
                    .format(formatacao, na_rep="-")
                    .highlight_null(null_color='#F2F200')
                    .apply(highlight_max)
                    .apply(highlight_min))
    write_to_html_file(visualiza, title='', filename=pasta + "/pgt_tab_indice_dia_valores.html")
    visualiza


    # In[17]:


    #Calcula as porcentagens do dataframe de valor de pagamentos
    tabela_valores_pct = tabela_indice

    pgt_atrasados = [(tabela_valores_pct['Pagamentos Atrasados'][x] / tabela_valores_pct['Totais dos Pagamentos'][x])*100 for x in range (len (tabela_valores_pct))]
    tabela_valores_pct['% Atrasados'] = pgt_atrasados

    pgt_em_dia = [(tabela_valores_pct['Pagamentos em Dia'][x] / tabela_valores_pct['Totais dos Pagamentos'][x])*100 for x in range (len (tabela_valores_pct))]
    tabela_valores_pct['% em Dia'] = pgt_em_dia

    pgt_adiantados = [(tabela_valores_pct['Pagamentos Adiantados'][x] / tabela_valores_pct['Totais dos Pagamentos'][x])*100 for x in range (len (tabela_valores_pct))]
    tabela_valores_pct['% Adiantados'] = pgt_adiantados

    #Cria um novo dataframe de porcentagens
    tabela_valores_pct = tabela_valores_pct[['% Atrasados', '% em Dia', '% Adiantados']]
    tabela_valores_pct

    formata_pct = {'% Atrasados':"{:.2f}%", '% em Dia':"{:.2f}%", '% Adiantados':"{:.2f}%"}

    visualiza = tabela_valores_pct.replace(to_replace = 0, value = np.nan).sort_values(by = '% Atrasados', ascending = True)

    visualiza = (visualiza
                    .style
                    .format(formata_pct, na_rep="-")
                    .highlight_null(null_color='#F2F200')
                    .apply(highlight_max)
                    .apply(highlight_min))
    write_to_html_file(visualiza, title='', filename=pasta + "/pgt_tab_pct_indice_dia_valores.html")
    visualiza


    # In[18]:


    #Plota em formato gráfico e exporta para HTML
    data = [go.Bar(y=tabela_valores_pct.index,
                   x=tabela_valores_pct['% Atrasados'],
                   orientation='h',
                   name='Atrasados',
                   marker=dict(color='#E93759')
                  ),
            go.Bar(y=tabela_valores_pct.index,
                   x=tabela_valores_pct['% em Dia'],
                   orientation='h',
                   name='Em Dia',
                   marker=dict(color='#112244')
                  ),
            go.Bar(y=tabela_valores_pct.index,
                   x=tabela_valores_pct['% Adiantados'],
                   orientation='h',
                   name='Adiantados',
                   marker=dict(color='#3749E9')
                  )]


    fig = go.Figure(data=data)

    fig = go.Figure(data=data)
    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(xaxis={'categoryorder':'total ascending'}, showlegend=True, barmode='stack')

    #iplot(fig)
    fig.write_html(pasta + "/pgt_indice_dia_valores.html")


    # In[19]:


    #Calcula os resultados do índice por valores de pagamentos
    data_vencimento = [x for x in range (len (df)) if str(df.DAT_VCT[x]) != 'NaT']

    media_valores_pct = (tabela_valores_pct['% Adiantados'].sum() + tabela_valores_pct['% em Dia'].sum())/ (len (tabela_valores_pct))
    media_valores = (tabela_valores['Pagamentos Adiantados'].sum() + tabela_valores['Pagamentos em Dia'].sum())/ (len (tabela_valores))
    media_acuracia = len (data_vencimento) * 100 / len (df)

    #media_valores_pct, media_valores, media_acuracia


    # # Índice de Pagamentos em Dia por Número de Clientes

    # In[20]:


    #Cria um dataframe somente com o número de clientes
    tabela_clientes = tabela_indice[['Número de Clientes Atrasados', 'Número de Clientes em Dia', 'Número de Clientes Adiantados']]

    visualiza = tabela_clientes.replace(to_replace = 0, value = np.nan).sort_values(by = 'Número de Clientes Atrasados', ascending = True)

    visualiza = (visualiza
                    .style
                    .format(formatacao, na_rep="-")
                    .highlight_null(null_color='#F2F200')
                    .apply(highlight_max)
                    .apply(highlight_min))
    write_to_html_file(visualiza, title='', filename=pasta + "/pgt_tab_indice_dia_clientes.html")
    visualiza


    # In[21]:


    #Calcula as porcentagens do dataframe de número de clientes
    tabela_clientes_pct = tabela_indice

    pgt_atrasados = [(tabela_clientes_pct['Número de Clientes Atrasados'][x] / tabela_clientes_pct['Número de Clientes'][x])*100 for x in range (len (tabela_clientes_pct))]
    tabela_clientes_pct['% Atrasados'] = pgt_atrasados

    pgt_em_dia = [(tabela_clientes_pct['Número de Clientes em Dia'][x] / tabela_clientes_pct['Número de Clientes'][x])*100 for x in range (len (tabela_clientes_pct))]
    tabela_clientes_pct['% em Dia'] = pgt_em_dia

    pgt_adiantados = [(tabela_clientes_pct['Número de Clientes Adiantados'][x] / tabela_clientes_pct['Número de Clientes'][x])*100 for x in range (len (tabela_clientes_pct))]
    tabela_clientes_pct['% Adiantados'] = pgt_adiantados

    #Cria um novo dataframe de porcentagens
    tabela_clientes_pct = tabela_clientes_pct[['% Atrasados', '% em Dia', '% Adiantados']]
    tabela_clientes_pct

    visualiza = tabela_clientes_pct.replace(to_replace = 0, value = np.nan).sort_values(by = '% Atrasados', ascending = True)

    visualiza = (visualiza
                    .style
                    .format(formata_pct, na_rep="-")
                    .highlight_null(null_color='#F2F200')
                    .apply(highlight_max)
                    .apply(highlight_min))
    write_to_html_file(visualiza, title='', filename=pasta + "/pgt_tab_pct_indice_dia_clientes.html")
    visualiza


    # In[22]:


    #Plota em formato gráfico e exporta para HTML
    data = [go.Bar(y=tabela_clientes_pct.index,
                   x=tabela_clientes_pct['% Atrasados'],
                   orientation='h',
                   name='Atrasados',
                   marker=dict(color='#E93759')
                  ),
            go.Bar(y=tabela_clientes_pct.index,
                   x=tabela_clientes_pct['% em Dia'],
                   orientation='h',
                   name='Em Dia',
                   marker=dict(color='#112244')
                  ),
            go.Bar(y=tabela_clientes_pct.index,
                   x=tabela_clientes_pct['% Adiantados'],
                   orientation='h',
                   name='Adiantados',
                   marker=dict(color='#00B7CC')
                  )]


    fig = go.Figure(data=data)

    fig = go.Figure(data=data)
    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(xaxis={'categoryorder':'total ascending'}, showlegend=True, barmode='stack')

    #iplot(fig)
    fig.write_html(pasta + "/pgt_indice_dia_clientes.html")


    # In[23]:


    #Calcula os resultados do índice por número de clientes
    media_clientes_pct = (tabela_clientes_pct['% Adiantados'].sum() + tabela_clientes_pct['% em Dia'].sum())/ (len (tabela_clientes_pct))
    media_clientes = (tabela_clientes['Número de Clientes Adiantados'].sum() + tabela_clientes['Número de Clientes em Dia'].sum())/ (len (tabela_clientes))

    #media_clientes_pct, media_clientes


    # # Índice de Pagamentos em Dia por Número de Pagamentos

    # In[24]:


    #Cria um dataframe somente com o número de pagamentos
    tabela_num_pagamentos = tabela_indice[['Número de Pagamentos Atrasados', 'Número de Pagamentos em Dia', 'Número de Pagamentos Adiantados']]

    visualiza = tabela_num_pagamentos.replace(to_replace = 0, value = np.nan).sort_values(by = 'Número de Pagamentos Atrasados', ascending = True)

    visualiza = (visualiza
                    .style
                    .format(formatacao, na_rep="-")
                    .highlight_null(null_color='#F2F200')
                    .apply(highlight_max)
                    .apply(highlight_min))
    write_to_html_file(visualiza, title='', filename=pasta + "/pgt_tab_indice_dia_num_pagamentos.html")
    visualiza


    # In[25]:


    #Calcula as porcentagens do dataframe de número de pagamentos
    tabela_num_pagamentos_pct = tabela_indice

    pgt_atrasados = [(tabela_num_pagamentos_pct['Número de Pagamentos Atrasados'][x] / tabela_num_pagamentos_pct['Número de Pagamentos'][x])*100 for x in range (len (tabela_num_pagamentos_pct))]
    tabela_num_pagamentos_pct['% Atrasados'] = pgt_atrasados

    pgt_em_dia = [(tabela_num_pagamentos_pct['Número de Pagamentos em Dia'][x] / tabela_num_pagamentos_pct['Número de Pagamentos'][x])*100 for x in range (len (tabela_num_pagamentos_pct))]
    tabela_num_pagamentos_pct['% em Dia'] = pgt_em_dia

    pgt_adiantados = [(tabela_num_pagamentos_pct['Número de Pagamentos Adiantados'][x] / tabela_num_pagamentos_pct['Número de Pagamentos'][x])*100 for x in range (len (tabela_num_pagamentos_pct))]
    tabela_num_pagamentos_pct['% Adiantados'] = pgt_adiantados

    #Cria um novo dataframe de porcentagens
    tabela_num_pagamentos_pct = tabela_num_pagamentos_pct[['% Atrasados', '% em Dia', '% Adiantados']]
    tabela_num_pagamentos_pct

    visualiza = tabela_num_pagamentos_pct.replace(to_replace = 0, value = np.nan).sort_values(by = '% Atrasados', ascending = True)

    visualiza = (visualiza
                    .style
                    .format(formata_pct, na_rep="-")
                    .highlight_null(null_color='#F2F200')
                    .apply(highlight_max)
                    .apply(highlight_min))
    write_to_html_file(visualiza, title='', filename=pasta + "/pgt_tab_pct_indice_dia_num_pagamentos.html")
    visualiza


    # In[26]:


    #Plota em formato gráfico e exporta para HTML
    data = [go.Bar(y=tabela_num_pagamentos_pct.index,
                   x=tabela_num_pagamentos_pct['% Atrasados'],
                   orientation='h',
                   name='Atrasados',
                   marker=dict(color='#E93759')
                  ),
            go.Bar(y=tabela_num_pagamentos_pct.index,
                   x=tabela_num_pagamentos_pct['% em Dia'],
                   orientation='h',
                   name='Em Dia',
                   marker=dict(color='#112244')
                  ),
            go.Bar(y=tabela_num_pagamentos_pct.index,
                   x=tabela_num_pagamentos_pct['% Adiantados'],
                   orientation='h',
                   name='Adiantados',
                   marker=dict(color='#FFAA00')
                  )]


    fig = go.Figure(data=data)

    fig = go.Figure(data=data)
    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(xaxis={'categoryorder':'total ascending'}, showlegend=True, barmode='stack')

    #iplot(fig)
    fig.write_html(pasta + "/pgt_indice_dia_num_pagamentos.html")


    # In[27]:


    #Calcula os resultados do índice por número de pagamentos
    media_num_pagamentos_pct = (tabela_num_pagamentos_pct['% Adiantados'].sum() + tabela_num_pagamentos_pct['% em Dia'].sum())/ (len (tabela_num_pagamentos_pct))
    media_num_pagamentos = (tabela_num_pagamentos['Número de Pagamentos Adiantados'].sum() + tabela_num_pagamentos['Número de Pagamentos em Dia'].sum())/ (len (tabela_num_pagamentos))

    #media_num_pagamentos_pct, media_num_pagamentos

    html_string = '''<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="author" content="git: diegosilva89, ud21">
  <title>METAlitcs - Modalidades</title>
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
          <p>Índice de Pagamentos em Dia</p>
        </div>
        <div class="rightbox">
          <p>Por Modalidades</p>
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
          <div class="stg-in">
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
          <div class="dynamic_graph_container_index_MOD">
            <div class="graph_one">
              <!-- graph form -->
              <div class="head">
                <div class="title">Porcentagem Média de Valores Totais de Pagamentos em Dia e Adiantados</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">''' + str(int(media_valores_pct)) + '''%</div>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_two">
              <!-- graph form -->
              <div class="head">
                <div class="title">Média de Valores Totais de Pagamentos Em Dia e Adiantados</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">R$ ''' + str("{:,.2f}".format(media_valores)) + '''</div>                
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_three">
              <!-- graph form -->
              <div class="head">
                <div class="title">Acurácia da Análise</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">''' + str(int(media_acuracia)) + '''%</div>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_four">
              <!-- graph form -->
              <div class="head">
                <div class="title">Tabela de Porcentagem de Valores Totais por Modalidades</div>
                <div class="paragraph">Atrasados, em dia e adiantados</div>
              </div>
              <div class="content">
                <iframe src=pags/pgt_tab_pct_indice_dia_valores.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_five">
              <!-- graph form -->
              <div class="head">
                <div class="title">Valores Atrasados, em Dia e Adiantados</div>
                <div class="paragraph">Porcentagem de campos preenchidos</div>
              </div>
              <div class="content">
                <iframe src=pags/pgt_indice_dia_valores.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_six">
              <!-- graph form -->
              <div class="head">
                <div class="title">Tabela de Valores Totais de Pagamentos por Modalidades</div>
                <div class="paragraph">Atrasados, em dia e adiantados</div>
              </div>
              <div class="content">
                <iframe src=pags/pgt_tab_indice_dia_valores.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_seven">
              <!-- graph form -->
              <div class="head">
                <div class="title">Porcentagem Média de Números Totais de Clientes em Dia e Adiantados</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">''' + str(int(media_clientes_pct)) + '''%</div>                
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_eight">
              <!-- graph form -->
              <div class="head">
                <div class="title">Média de Números Totais de Clientes Em Dia e Adiantados</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">''' + str(int(media_clientes)) + '''</div>                
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_nine">
              <!-- graph form -->
              <div class="head">
                <div class="title">Acurácia da Análise</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">''' + str(int(media_acuracia)) + '''%</div>                
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_ten">
              <!-- graph form -->
              <div class="head">
                <div class="title">Tabela de Porcentagem de Números de Clientes Totais por Modalidades</div>
                <div class="paragraph">Atrasados, em dia e adiantados</div>
              </div>
              <div class="content">
                <iframe src=pags/pgt_tab_pct_indice_dia_clientes.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_eleven">
              <!-- graph form -->
              <div class="head">
                <div class="title">Número de Clientes Atrasados, em Dia e Adiantados</div>
                <div class="paragraph">Porcentagem de campos preenchidos</div>
              </div>
              <div class="content">
                <iframe src=pags/pgt_indice_dia_clientes.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_twelve">
              <!-- graph form -->
              <div class="head">
                <div class="title">Tabela de Número de Clientes por Modalidades</div>
                <div class="paragraph">Atrasados, em dia e adiantados </div>
              </div>
              <div class="content">
                <iframe src=pags/pgt_tab_indice_dia_clientes.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_thirteen">
              <!-- graph form -->
              <div class="head">
                <div class="title">Porcentagem Média de Números Totais de Pagamentos em Dia e Adiantados</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">''' + str(int(media_num_pagamentos_pct)) + '''%</div>                 
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_fourteen">
              <!-- graph form -->
              <div class="head">
                <div class="title">Média de Números Totais de Pagamentos em Dia e Adiantados</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">''' + str(int(media_num_pagamentos)) + '''</div>                 
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_fifteen">
              <!-- graph form -->
              <div class="head">
                <div class="title">Acurácia da Análise</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">''' + str(int(media_acuracia)) + '''%</div>                
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_sixteen">
              <!-- graph form -->
              <div class="head">
                <div class="title">Tabela de Porcentagem de Números de Pagamentos por Modalidades</div>
                <div class="paragraph">Atrasados, em dia e adiantados</div>
              </div>
              <div class="content">
                <iframe src=pags/pgt_tab_pct_indice_dia_num_pagamentos.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_seventeen">
              <!-- graph form -->
              <div class="head">
                <div class="title">Número de Pagamentos Atrasados, em Dia e Adiantados</div>
                <div class="paragraph">Porcentagem de campos preenchidos</div>
              </div>
              <div class="content">
                <iframe src=pags/pgt_indice_dia_num_pagamentos.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_eighteen">
              <!-- graph form -->
              <div class="head">
                <div class="title">Tabela de Porcentagem de Número de Pagamentos por Modalidades</div>
                <div class="paragraph">Atrasados, em dia e adiantados</div>
              </div>
              <div class="content">
                <iframe src=pags/pgt_tab_indice_dia_num_pagamentos.html></iframe>
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
    
    f = open(relatorio + '/index_MOD.html','w', encoding='utf-8')
    f.write(html_string)
    f.close()
    
    print (f"O Relatório dos Índices de Pagamentos em Dia foi criado com sucesso!")
