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


def validacao (relatorio, pasta, tabela_opr, tabela_mdl, tabela_fnt):
    print ("Gerando Relatório de Validação da Tabela STG_OPR_ITT...")
    
    # In[4]:


    # DataFrame principal.
    dados_STG_OPR_ITT = pd.read_excel(tabela_opr) # DataFrame de Operações.

    # DataFrame para validação (esse será usado para validar as modalidades do principal).
    dados_STG_MDL = pd.read_excel(tabela_mdl) # DataFrame das Modalidades.

    # DataFrame para validação (esse será usado para validar os ID's das fontes do principal).
    dados_STG_FNT_ITT = pd.read_excel(tabela_fnt) # DataFrame das Fontes.

    #dados_STG_OPR_ITT


    # In[5]:


    #dados_STG_OPR_ITT


    # ## Validando os tipos de dados das colunas

    # In[6]:


    # Tratando as datas.
    dados_STG_OPR_ITT.DAT_RSS_FNT_ITT = pd.to_datetime(dados_STG_OPR_ITT.DAT_RSS_FNT_ITT, format='%Y-%m-%d', errors='coerce')
    dados_STG_OPR_ITT.DAT_INC_DBO = pd.to_datetime(dados_STG_OPR_ITT.DAT_INC_DBO, format='%Y-%m-%d', errors='coerce')

    # Adicionando os tipos das respectivas colunas.
    dict_tipo = {'ID_STG_OPR_ITT': int, 'VLR_CTRD_CSC': float, 'QTD_PCL': int, 'VLR_SDO_DDR': float,
                 'QTD_CLI_CAD_POS': int, 'QTD_OPR': int, 'ID_FNT_ITT': int, 'ID_MDL': str,
                 'DES_TIP_PSS': ('F' or 'J'), 'DAT_RSS_FNT_ITT': datetime.date, 'DAT_INC_DBO': datetime.date}

    dict_analise = {}

    # Realizando a verificação.
    for coluna, tipo in dict_tipo.items():
        
        dict_analise[coluna] = len([linha for linha in dados_STG_OPR_ITT[coluna] 
                                    if type(linha) == tipo or linha == tipo or isinstance(linha, tipo)])
                

    total = dados_STG_OPR_ITT.shape[0]

    # Convertendo o valor obtido para porcentagem.
    final = [x * 100 / total for x in dict_analise.values()]

    tipo_review = pd.DataFrame({'Porcentagem': final},
                               index = dict_analise.keys())
    tipo_review = tipo_review.rename_axis('Colunas', axis = 'columns')
    #tipo_review


    # In[7]:


    #Plota em formato gráfico e exporta em HTML
    data = [go.Bar(x = final,
                   y = [x for x in dict_analise.keys()],
                   orientation = 'h',
                   marker=dict(color='#112244')
                  )]

    fig = go.Figure(data=data)
    fig.update_yaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_xaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(xaxis=dict(ticksuffix = '%'))
    #iplot(fig)
    fig.write_html(pasta + "/opr_tipo.html")


    # ## Definindo dados sensíveis

    # In[8]:


    #Cria um dataframe definido as colunas com dados sensíveis
    dado_sensivel = {x: 'Não' for x in dados_STG_OPR_ITT.columns}
    dado_sensivel['ID_FNT_ITT'] = 'Sim'

    sensibilidade_review = pd.DataFrame({'Dado Sensível': dado_sensivel},
                                          index = dado_sensivel.keys())

    sensibilidade_review = sensibilidade_review.rename_axis('Colunas', axis = 'columns')

    visualiza = (sensibilidade_review
                    .style
                    .applymap(destaque))
    write_to_html_file(visualiza, title='', filename=pasta + "/opr_tab_sensibilidade.html")
    visualiza


    # ## Validando as Modalidades e os ID's Fonte

    # ### Modalidades

    # In[9]:


    # Pegando os IDs para serem validado.
    modalidades = dados_STG_OPR_ITT['ID_MDL']

    # Atribuindo os códigos existentes em uma lista para poder usar o 'in'. 
    codigos_existentes = [x for x in dados_STG_MDL['COD_MDL']] 

    count_validos_mdl = len([codigo for codigo in modalidades if codigo in codigos_existentes])

    porcentagem_mdl = count_validos_mdl * 100 / len(modalidades)


    # ### ID Fonte

    # In[10]:


    # Pegando os IDs para serem validado.
    fontes = dados_STG_OPR_ITT['ID_FNT_ITT']

    # Atribuindo os códigos existentes em uma lista para poder usar o 'in'. 
    codigos_existentes = [x for x in dados_STG_FNT_ITT['ID_STG_FNT_ITT']] 

    count_validos_fontes = len([codigo for codigo in fontes if codigo in codigos_existentes])

    porcentagem_fontes = count_validos_fontes * 100 / len(fontes)


    # In[11]:


    #Cria um dataframe
    colunas_validar = ['Códigos de Modalidades', 'IDs de Fontes']
    encontrados = [len(modalidades), len(fontes)]
    porcentagens = [porcentagem_mdl, porcentagem_fontes]

    correspondencia_review = pd.DataFrame({'Encontrados': encontrados,
                                           'Correspondência': porcentagens},
                                          index = colunas_validar)
    correspondencia_review = correspondencia_review.rename_axis('Colunas', axis='columns')

    visualiza = (correspondencia_review
                    .style
                    .format({'Correspondência':"{:.2f}%"})
                    .applymap(destaque_coluna, subset=pd.IndexSlice[:, ['Correspondência']]))
    write_to_html_file(visualiza, title='', filename=pasta + "/opr_tab_correspondencia.html")
    visualiza


    # ## Analisando Campos Únicos

    # In[12]:


    #Analisa o número de valores únicos e que não foram duplicados
    unico = [len(np.unique(dados_STG_OPR_ITT.ID_STG_OPR_ITT)) * 100 / len (dados_STG_OPR_ITT)]
    ff = dados_STG_OPR_ITT[['VLR_CTRD_CSC', 'QTD_PCL', 'VLR_SDO_DDR',
             'QTD_CLI_CAD_POS', 'QTD_OPR', 'ID_FNT_ITT',
             'ID_MDL', 'DES_TIP_PSS',
             'DAT_RSS_FNT_ITT', 'DAT_INC_DBO']]
        
    for x in ff.columns:
        coluna = dados_STG_OPR_ITT
        coluna = coluna.replace(0,np.nan)
        soma = coluna.groupby(f'{x}').count()
        soma = soma[soma.ID_STG_OPR_ITT == 1]
        soma = soma.ID_STG_OPR_ITT.sum()
        unico.append (soma * 100 / len (coluna[x]))

    #Cria um dataframe
    unico_review = pd.DataFrame({'Campos Não Duplicados': unico},
                               index=dados_STG_OPR_ITT.columns)
    unico_review = unico_review.rename_axis('Colunas', axis='columns')
    #unico_review


    # In[13]:


    #Plota em gráfico de barras horizontal
    data = go.Bar(y = unico, 
                  x = dados_STG_OPR_ITT.columns, 
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
    fig.write_html(pasta + "/opr_unicos.html")


    # ## Filtrando os casos especiais e analisando o preenchimento das células

    # In[14]:


    # Completando espaços vázios com zeros.
    dados_STG_OPR_ITT = dados_STG_OPR_ITT.fillna(0)

    dict_tipo = {'ID_STG_OPR_ITT': np.int64, 'VLR_CTRD_CSC': np.float64, 'QTD_PCL': np.int64, 'VLR_SDO_DDR': np.float64,
                 'QTD_CLI_CAD_POS': np.int64, 'QTD_OPR': np.int64, 'ID_FNT_ITT': np.int64, 'ID_MDL': str,
                 'DES_TIP_PSS': str}

    for coluna, tipo in dict_tipo.items():
        dados_STG_OPR_ITT[coluna] = dados_STG_OPR_ITT[coluna].astype(tipo)
        
    #dados_STG_OPR_ITT.dtypes


    # ## Analisando a Completude dos dados

    # In[15]:


    #Completa espaços vazios com zero e exclui as linhas com valor zero
    analisar = dados_STG_OPR_ITT.drop(columns = ['VLR_CTRD_CSC', 'VLR_SDO_DDR'])
    analisar = analisar != 0
    analisar = analisar.sum()

    filtro = dados_STG_OPR_ITT[dados_STG_OPR_ITT.ID_MDL == 'C01']
    consorcio = filtro[['VLR_CTRD_CSC', 'VLR_SDO_DDR']]
    consorcio = consorcio != 0
    consorcio = consorcio.sum()

    situacao = [(x * 100) / len (dados_STG_OPR_ITT) for x in analisar]
    situacao.extend ((x * 100) / len (filtro) for x in consorcio)

    tabela_labels = [x for x in analisar.index]
    tabela_labels.extend (x for x in consorcio.index)

    #Cria um dataframe
    tabela_review = pd.DataFrame({'COMPLETUDE (%)' : situacao},
                                 index = tabela_labels)
    tabela_review = tabela_review.rename_axis('Colunas', axis='columns')
    tabela_review = tabela_review.T 
    tabela_review = tabela_review[dados_STG_OPR_ITT.columns]
    tabela_review = tabela_review.T 
    #tabela_review


    # #### Criando um gráfico.

    # In[16]:


    #Plota em formato gráfico e exporta para HTML
    data = go.Bar(x = tabela_review['COMPLETUDE (%)'], 
                  y = tabela_review.index, 
                  orientation = 'h', 
                  marker = {'color' : '#3749E9'})

    layout = go.Layout(title = '', 
                       yaxis = {'title': ''}, 
                       xaxis = {'title': ''})

    fig = go.Figure(data = data, layout = layout)
    fig.update_yaxes(showline = True, linewidth = 1, linecolor = '#717171')
    fig.update_xaxes(showgrid = True, gridwidth = 1, gridcolor = '#D9D9DE')
    fig.update_layout({'plot_bgcolor': '#FFFFFF', 'paper_bgcolor': '#FFFFFF'})
    fig.update_layout(xaxis=dict(ticksuffix = '%'))
    #iplot(fig)
    fig.write_html(pasta + "/opr_completude_sem_consorcio.html")


    # ## Recência dos Dados

    # In[17]:


    #Analisando a recência de dados
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

    analise =  pd.DataFrame({'Datas Encontradas' : dados, 
                             'Ocorrência' : ocorrencia}, 
                            index = nome_coluna)

    analise = analise.rename_axis('Colunas', axis='columns')
    analise.index.name = None

    visualiza = (analise
                    .style
                    .format({'Ocorrência':"{:.2f}%"})
                    .applymap(destaque_coluna, subset=pd.IndexSlice[:, ['Ocorrência']]))
    write_to_html_file(visualiza, title='', filename=pasta + "/opr_tab_datas.html")
    visualiza


    # # Indicadores de Validação

    # In[18]:


    #Calcula a média de preenchimento da remessa
    media_preenchimento = sum (situacao) / dados_STG_OPR_ITT.shape[1]

    #Calcula de validação  
    media_validacao = (sum (final) /dados_STG_OPR_ITT.shape[1] + sum (porcentagens) / len (porcentagens)  + sum (ocorrencia) / len (ocorrencia) ) / 3

    #media_preenchimento, media_validacao

    html_string = '''<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="author" content="git: diegosilva89, ud21">
  <title>METAlitcs - STG_OPR_ITT</title>
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
          <p>STG_OPR_ITT</p>
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
            <div class="stg-in">
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
                <iframe src=pags/opr_completude_sem_consorcio.html></iframe>
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
                <iframe src=pags/opr_tab_datas.html></iframe>
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
                <iframe src=pags/opr_tipo.html></iframe>
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
                <iframe src=pags/opr_tab_correspondencia.html></iframe>
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
                <iframe src=pags/opr_unicos.html></iframe>
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
                <iframe src=pags/opr_tab_sensibilidade.html></iframe>
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

    f = open(relatorio + '/table_OPR.html','w', encoding='utf-8')
    f.write(html_string)
    f.close()
    
    print (f"O Relatório de Validação da Tabela STG_OPR_ITT foi criado com sucesso!")

def resultados (relatorio, pasta, tabela_opr, tabela_mdl):
    print ("Gerando Relatório de Resultados das Operações...")
    
    # In[4]:


    # DataFrame principal.
    dados_STG_OPR_ITT = pd.read_excel(tabela_opr) # DataFrame de Operações.

    # DataFrame para validação (esse será usado para validar as modalidades do principal).
    dados_STG_MDL = pd.read_excel(tabela_mdl) # DataFrame das Modalidades.

    #dados_STG_OPR_ITT


    # In[5]:


    #dados_STG_OPR_ITT


    # ## Filtrando os casos especiais e analisando o preenchimento das células

    # In[6]:


    # Tratando as datas.
    dados_STG_OPR_ITT.DAT_RSS_FNT_ITT = pd.to_datetime(dados_STG_OPR_ITT.DAT_RSS_FNT_ITT, format='%Y-%m-%d', errors='coerce')
    dados_STG_OPR_ITT.DAT_INC_DBO = pd.to_datetime(dados_STG_OPR_ITT.DAT_INC_DBO, format='%Y-%m-%d', errors='coerce')

    # Completando espaços vázios com zeros.
    dados_STG_OPR_ITT = dados_STG_OPR_ITT.fillna(0)

    dict_tipo = {'ID_STG_OPR_ITT': np.int64, 'VLR_CTRD_CSC': np.float64, 'QTD_PCL': np.int64, 'VLR_SDO_DDR': np.float64,
                 'QTD_CLI_CAD_POS': np.int64, 'QTD_OPR': np.int64, 'ID_FNT_ITT': np.int64, 'ID_MDL': str,
                 'DES_TIP_PSS': str}

    for coluna, tipo in dict_tipo.items():
        dados_STG_OPR_ITT[coluna] = dados_STG_OPR_ITT[coluna].astype(tipo)
        
    #dados_STG_OPR_ITT.dtypes


    # ## Convertendo os valores para acrescentar dois decimais

    # In[7]:


    # Colunas a serem convertidas.
    colunas = ['VLR_CTRD_CSC', 'VLR_SDO_DDR']

    for coluna in colunas:
    #    print('-' * 60 + f'\nColuna: {coluna}\n')
        
        for index, antes in enumerate(dados_STG_OPR_ITT[coluna].dropna()):
            depois = antes * 0.01
            dados_STG_OPR_ITT[coluna] = dados_STG_OPR_ITT[coluna].replace(antes, depois) # Trocando o velho pelo novo.

    #        if index < 10: # Essa parte serve somente para limitar a amostragem dos valores.
    #            print(f'R${depois:>20.2f}') # Mostrando alguns exemplos.
        
    #    print('-' * 60)


    # ## Adicionando uma nova coluna (MDL_DESCRICAO) ao DataFrame principal

    # ### Primeiramente criando um dicionário com o código e sua respectiva descrição para facilitar o processo

    # In[8]:


    # Escolhendo as colunas necessárias.
    new = dados_STG_MDL[['COD_MDL', 'DES_MDL']] 
    dictionary = new.set_index('COD_MDL').T.to_dict('list') # Convertendo em um dicionário (valores em lista).

    for key, value in dictionary.items():
        dictionary[key] = str(value).strip("['']") # Convertendo os valores (em lista) para string.
        
    #dictionary # Mostrando o dicionário final.


    # ### Linha por linha atribuindo ao respectivo código a sua descrição

    # In[9]:


    # Linha por linha atribuindo ao respectivo código a sua descrição
    x = [dictionary.get(codigo, f'{codigo} (MODALIDADE NAO ENCONTRADA)') 
         for index, codigo in enumerate(dados_STG_OPR_ITT['ID_MDL'])]

    dados_STG_OPR_ITT['MDL_DESCRICAO'] = x

    #dados_STG_OPR_ITT[['ID_MDL', 'MDL_DESCRICAO']].head()


    # ## Analisando a soma das operações por modalidades

    # In[10]:


    #Cria um dataframe
    analisar = dados_STG_OPR_ITT[['MDL_DESCRICAO', 'QTD_OPR']].dropna()

    operacoes = analisar.groupby('MDL_DESCRICAO').sum().sort_values(by = 'QTD_OPR', ascending = False)
    #operacoes


    # ### Criando um gráfico

    # In[11]:


    #Define escalas para o tamanho máximo padrão dos gráficos
    operacoes_range = [0, round(max(operacoes.QTD_OPR))]

    #Filtra valores menores ou iguais a 1 milhão
    operacoes_menor = operacoes[operacoes['QTD_OPR'] > 0]
    operacoes_menor = operacoes_menor[operacoes_menor['QTD_OPR'] <= 1000]
    operacoes_menor = operacoes_menor.sort_values(by = 'QTD_OPR', ascending = True)

    #Filtra valores menores ou iguais a 1 milhão
    operacoes_medio = operacoes[operacoes['QTD_OPR'] > 1000]
    operacoes_medio = operacoes_medio[operacoes_medio['QTD_OPR'] <= 50000]
    operacoes_medio = operacoes_medio.sort_values(by = 'QTD_OPR', ascending = True)

    #Filtra valores maiores que 1 milhão e menores e iguais a 5 bilhões
    operacoes_maior = operacoes[operacoes['QTD_OPR'] > 50000]
    operacoes_maior = operacoes_maior.sort_values(by = 'QTD_OPR', ascending = True)

    fig = make_subplots(rows=3, cols=1, row_heights=[0.3, 0.6, 0.4])

    fig.add_trace(go.Bar(y=operacoes_menor.index,
                         x=operacoes_menor['QTD_OPR'],
                         orientation = 'h',
                         marker=dict(color='#112244')
                        ),
                  row = 3, col = 1
    )

    fig.add_trace(go.Bar(y = operacoes_medio.index,
                         x = operacoes_medio['QTD_OPR'],
                         orientation = 'h',
                         marker = dict(color = '#112244')
                        ),
                  row = 2, col = 1
    )

    fig.add_trace(go.Bar(y = operacoes_maior.index,
                         x = operacoes_maior['QTD_OPR'],
                         orientation = 'h',
                         marker = dict(color = '#112244')
                        ),
                  row = 1, col = 1
    )

    fig.update_yaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_xaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_xaxes(range=operacoes_range)
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(showlegend=False)

    #iplot(fig)

    fig.write_html(pasta + "/opr_soma_opr_por_mdl.html")


    # ## Analisando a soma das parcelas por modalidades

    # In[12]:


    #Cria um dataframe
    analisar = dados_STG_OPR_ITT[['MDL_DESCRICAO', 'QTD_PCL']].dropna()

    parcelas = analisar.groupby('MDL_DESCRICAO').sum().sort_values(by = 'QTD_PCL', ascending = False)
    #parcelas


    # ### Criando um gráfico

    # In[13]:


    #Define escalas para o tamanho máximo padrão dos gráficos
    parcelas_range = [0, round(max(parcelas.QTD_PCL))]

    #Filtra valores menores ou iguais a 1 milhão
    parcelas_menor = parcelas[parcelas['QTD_PCL'] > 0]
    parcelas_menor = parcelas_menor[parcelas_menor['QTD_PCL'] <= 500]
    parcelas_menor = parcelas_menor.sort_values(by = 'QTD_PCL', ascending = True)

    #Filtra valores menores ou iguais a 1 milhão
    parcelas_medio = parcelas[parcelas['QTD_PCL'] > 500]
    parcelas_medio = parcelas_medio[parcelas_medio['QTD_PCL'] <= 5000]
    parcelas_medio = parcelas_medio.sort_values(by = 'QTD_PCL', ascending = True)

    #Filtra valores maiores que 1 milhão e menores e iguais a 5 bilhões
    parcelas_maior = parcelas[parcelas['QTD_PCL'] > 5000]
    parcelas_maior = parcelas_maior.sort_values(by = 'QTD_PCL', ascending = True)

    fig = make_subplots(rows=1, cols=3, column_widths=[0.6, 0.2, 0.5])

    fig.add_trace(go.Bar(x=parcelas_menor.index,
                         y=parcelas_menor['QTD_PCL'],
                         marker=dict(color='#3749E9')
                        ),
                  row = 1, col = 1
    )

    fig.add_trace(go.Bar(x = parcelas_medio.index,
                         y = parcelas_medio['QTD_PCL'],
                         marker = dict(color = '#3749E9')
                        ),
                  row = 1, col = 2
    )

    fig.add_trace(go.Bar(x = parcelas_maior.index,
                         y = parcelas_maior['QTD_PCL'],
                         marker = dict(color = '#3749E9')
                        ),
                  row = 1, col = 3
    )

    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_yaxes(range=parcelas_range)
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(showlegend=False)

    #iplot(fig)

    fig.write_html(pasta + "/opr_soma_pcl_por_mdl.html")


    # ## Analisando a soma de clientes por modalidades

    # In[14]:


    #Cria um dataframe
    analisar = dados_STG_OPR_ITT[['MDL_DESCRICAO', 'QTD_CLI_CAD_POS']].dropna()

    clientes = analisar.groupby('MDL_DESCRICAO').sum().sort_values(by = 'QTD_CLI_CAD_POS', ascending = False)
    #clientes


    # ### Criando um gráfico

    # In[15]:


    #Define escalas para o tamanho máximo padrão dos gráficos
    clientes_range = [0, round(max(clientes.QTD_CLI_CAD_POS))]

    #Filtra valores menores ou iguais a 1 milhão
    clientes_menor = clientes[clientes['QTD_CLI_CAD_POS'] > 0]
    clientes_menor = clientes_menor[clientes_menor['QTD_CLI_CAD_POS'] <= 1000]
    clientes_menor = clientes_menor.sort_values(by = 'QTD_CLI_CAD_POS', ascending = True)

    #Filtra valores menores ou iguais a 1 milhão
    clientes_medio = clientes[clientes['QTD_CLI_CAD_POS'] > 1000]
    clientes_medio = clientes_medio[clientes_medio['QTD_CLI_CAD_POS'] <= 100000]
    clientes_medio = clientes_medio.sort_values(by = 'QTD_CLI_CAD_POS', ascending = True)

    #Filtra valores maiores que 1 milhão e menores e iguais a 5 bilhões
    clientes_maior = clientes[clientes['QTD_CLI_CAD_POS'] > 100000]
    clientes_maior = clientes_maior.sort_values(by = 'QTD_CLI_CAD_POS', ascending = True)

    fig = make_subplots(rows=1, cols=3, column_widths=[0.5, 0.5, 0.3])

    fig.add_trace(go.Bar(x=clientes_menor.index,
                         y=clientes_menor['QTD_CLI_CAD_POS'],
                         marker=dict(color='#112244')
                        ),
                  row = 1, col = 1
    )

    fig.add_trace(go.Bar(x = clientes_medio.index,
                         y = clientes_medio['QTD_CLI_CAD_POS'],
                         marker = dict(color = '#112244')
                        ),
                  row = 1, col = 2
    )

    fig.add_trace(go.Bar(x = clientes_maior.index,
                         y = clientes_maior['QTD_CLI_CAD_POS'],
                         marker = dict(color = '#112244')
                        ),
                  row = 1, col = 3
    )

    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_yaxes(range=clientes_range)
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(showlegend=False)

    #iplot(fig)

    fig.write_html(pasta + "/opr_soma_cliente_por_mdl.html")


    # ## Agrupando clientes e parcelas por modalidades

    # In[16]:


    #Plota em formato tabela e exporta para HTML
    data = [go.Bar(x=clientes.index,
                   y=clientes.QTD_CLI_CAD_POS,
                   name='Número de Clientes',
                   marker=dict(color='#3749E9')
                  ),
            go.Bar(x=parcelas.index,
                   y=parcelas.QTD_PCL,
                   name='Número de Parcelas',
                   marker=dict(color='#112244')
                  )]

    fig = go.Figure(data=data)

    fig = go.Figure(data=data)
    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(xaxis={'categoryorder':'total ascending'}, showlegend=True)

    #iplot(fig)
    fig.write_html(pasta + "/opr_clientes_parcelas.html")


    # ## Adicionando uma nova coluna (VLR_PAGO) ao DataFrame temporário

    # ### Primeiramente criando uma lista com o resultado da subtração

    # In[17]:


    # Selecionando somente as linhas com o ID_MDL igual a C01 (consórcio).
    analisar = dados_STG_OPR_ITT[dados_STG_OPR_ITT['ID_MDL'] == 'C01'] 
    analisar = analisar[['VLR_CTRD_CSC', 'VLR_SDO_DDR']] # Selecionando somente as colunas necessárias.

    total = [] # Lista temporária.

    for index in analisar.index: # Efeituando a conta e jogando o resultado na lista.
        total.append(round(analisar['VLR_CTRD_CSC'][index] - analisar['VLR_SDO_DDR'][index], 2))

        
    analisar['VLR_PAGO'] = total # Adicionando a lista.
    #analisar.head(10) 


    # In[18]:


    #Plota em formato grafico
    lista_somas = [analisar['VLR_SDO_DDR'].sum(), analisar['VLR_CTRD_CSC'].sum(), analisar['VLR_PAGO'].sum()]
    lista_nomes = ['Saldo Devedor', 'Valor Contratado', 'Valor Pago']

    data = [go.Bar(x = lista_nomes,
                   y = lista_somas,
                   marker = dict(color = ['#FFAA00', '#112244', '#00B7CC'])
                  )]

    fig = go.Figure(data = data)
    fig.update_xaxes(showline = True, linewidth = 1, linecolor = '#717171')
    fig.update_yaxes(showgrid = True, gridwidth = 1, gridcolor = '#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(showlegend = False)

    #iplot(fig)
    fig.write_html(pasta + "/opr_grafico_valor_consorcio.html")


    # ## Dataframe resumido

    # In[19]:


    #Cria uma nova tabela com os dados resumidos
    tabela = dados_STG_OPR_ITT[['MDL_DESCRICAO', 'QTD_PCL', 'QTD_CLI_CAD_POS', 'QTD_OPR']]
    tabela = tabela.groupby('MDL_DESCRICAO').sum()
    tabela = tabela.rename(columns={'QTD_PCL': 'Número de Parcelas', 'QTD_CLI_CAD_POS': 'Número de Clientes',
                                    'QTD_OPR': 'Número de Operações'}).sort_values(by = 'Número de Parcelas', ascending = True)
    tabela = tabela.rename_axis('Modalidades', axis='columns')
    tabela.index.name = None

    visualiza = tabela.replace(to_replace = 0, value = np.nan)

    visualiza = (visualiza
                    .style
                    .format(formatacao, na_rep="-")
                    .highlight_null(null_color='#F2F200')
                    .apply(highlight_max)
                    .apply(highlight_min))
    write_to_html_file(visualiza, title='', filename=pasta + "/opr_tab_modalidades.html")
    visualiza


    # ## Calculando os indicadores gerais

    # In[20]:


    #Calcula os resultados totais da remessa
    total_vlr_contratado = dados_STG_OPR_ITT['VLR_CTRD_CSC'].sum()
    total_qtd_pcl = dados_STG_OPR_ITT['QTD_PCL'].sum()
    total_vlr_saldo_devedor = dados_STG_OPR_ITT['VLR_SDO_DDR'].sum()
    total_qtd_opr = dados_STG_OPR_ITT['QTD_OPR'].sum()

    #total_vlr_contratado, total_qtd_pcl, total_vlr_saldo_devedor, total_qtd_opr    

    html_string = '''<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="author" content="git: diegosilva89, ud21">
  <title>METAlitcs - Operações</title>
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
          <p>Operações</p>
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
            <div class="stg-in">
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
                <div class="title">Valor Total Contratado</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">R$ ''' + str("{:,.2f}".format(total_vlr_contratado)) + '''</div>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_two">
              <!-- graph form -->
              <div class="head">
                <div class="title"> Valor Total do Saldo Devedor</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">R$ ''' + str("{:,.2f}".format(total_vlr_saldo_devedor)) + '''</div>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_three">
              <!-- graph form -->
              <div class="head">
                <div class="title">Quantidade Total de Parcelas</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">''' + str(int(total_qtd_pcl)) + '''</div>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_four">
              <!-- graph form -->
              <div class="head">
                <div class="title">Quantidade Total de Operações</div>
              </div>
              <div class="content_percent">
                  <div class="percent_value">''' + str(int(total_qtd_opr)) + '''</div>
              </div>
              <!-- graph form -->
            </div>
          </div>
          <div class="dynamic_graph_container_result_OPR">
            <div class="graph_five">
              <!-- graph form -->
              <div class="head">
                <div class="title">Número Total de Operações</div>
                <div class="paragraph">Por modalidades</div>
              </div>
              <div class="content">
                <iframe src=pags/opr_soma_opr_por_mdl.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_six">
              <!-- graph form -->
              <div class="head">
                <div class="title">Valores Totais de Consórcio</div>
                <div class="paragraph">Por valor contratado, saldo devedor e valor pago</div>
              </div>
              <div class="content">
                <iframe src=pags/opr_grafico_valor_consorcio.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_seven">
              <!-- graph form -->
              <div class="head">
                <div class="title">Tabela de Operações por Modalidades</div>
                <div class="paragraph">Número de parcelas, número de clientes e número de operações</div>
              </div>
              <div class="content">
                <iframe src=pags/opr_tab_modalidades.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_eight">
              <!-- graph form -->
              <div class="head">
                <div class="title">Comparação do Número Total de Clientes e Operações</div>
                <div class="paragraph">Por modalidades</div>
              </div>
              <div class="content">
                <iframe src=pags/opr_clientes_parcelas.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_nine">
              <!-- graph form -->
              <div class="head">
                <div class="title">Número Total de Clientes</div>
                <div class="paragraph">Por modalidades</div>
              </div>
              <div class="content">
                <iframe src=pags/opr_soma_cliente_por_mdl.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_ten">
              <!-- graph form -->
              <div class="head">
                <div class="title">Número Total de Parcelas</div>
                <div class="paragraph">Por modalidades</div>
              </div>
              <div class="content">
                <iframe src=pags/opr_soma_pcl_por_mdl.html></iframe>
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
    
    f = open(relatorio + '/result_OPR.html','w', encoding='utf-8')
    f.write(html_string)
    f.close()
    
    print (f"O Relatório de Resultados das Operações foi criado com sucesso!")
