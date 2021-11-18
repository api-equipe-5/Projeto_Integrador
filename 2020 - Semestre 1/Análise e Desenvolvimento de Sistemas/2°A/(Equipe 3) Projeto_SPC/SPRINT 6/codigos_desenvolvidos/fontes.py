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


def validacao (relatorio, pasta, tabela_fnt):
    print ("Gerando Relatório de Validação da Tabela STG_FNT_ITT...")

    # In[4]:
    

    #dataframe do o arquivo .xlsx

    df = pd.read_excel(tabela_fnt)


    # In[5]:


    #df


    # # Valida os tipos das colunas

    # In[6]:


    #df.dtypes


    # In[7]:


    #Trata as datas
    df.DAT_INC_DBO = pd.to_datetime(df.DAT_INC_DBO, format='%Y-%m-%d', errors='coerce')

    #Verifica as linhas das colunas o tipo desejado
    dict_tipo = {'ID_STG_FNT_ITT': int, 'NUM_CNPJ': int, 'NUM_CMP_CNPJ': int, 'NOM_COM': str,
                 'NOM_RAZ_SCL': str, 'DAT_INC_DBO': datetime.date}
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
    data = [go.Bar(y=final,
                   x=df.columns,
                   marker=dict(color='#112244')
                  )]

    fig = go.Figure(data=data)
    fig.update_xaxes(showline=True, linewidth=1, linecolor='#717171')
    fig.update_yaxes(showgrid=True, gridwidth=1, gridcolor='#D9D9DE')
    fig.update_layout(dict(plot_bgcolor = '#FFFFFF', paper_bgcolor = '#FFFFFF'))
    fig.update_layout(yaxis=dict(ticksuffix = '%'))
    #iplot(fig)
    fig.write_html(pasta + "/fnt_tipo.html")


    # # Define as colunas com dados sensíveis

    # In[9]:


    #Cria um dataframe definido as colunas com dados sensíveis
    dado_sensivel = ['Sim', 'Sim', 'Sim', 'Sim', 'Sim', 'Não']

    sensibilidade_review = pd.DataFrame({'Dado Sensível': dado_sensivel},
                                          index=df.columns)
    sensibilidade_review = sensibilidade_review.rename_axis('Colunas', axis='columns')

    visualiza = (sensibilidade_review
                    .style
                    .applymap(destaque))
    write_to_html_file(visualiza, title='', filename=pasta + "/fnt_tab_sensibilidade.html")
    visualiza


    # # Analisando os campos duplicados

    # In[10]:


    #Analisa o número de valores únicos e que não foram duplicados
    unico = [len(np.unique(df.ID_STG_FNT_ITT)) * 100 / len (df)]
    ff = df[['NUM_CNPJ', 'NUM_CNPJ', 'NUM_CMP_CNPJ', 'NOM_COM', 'DAT_INC_DBO']]

    for x in ff.columns:
        coluna = df
        coluna = coluna.replace(0,np.nan)
        soma = coluna.groupby(f'{x}').count()
        soma = soma[soma.ID_STG_FNT_ITT == 1]
        soma = soma.ID_STG_FNT_ITT.sum()
        unico.append (soma * 100 / len (coluna[x]))

    #Cria um dataframe
    unico_review = pd.DataFrame({'Campos Não Duplicados': unico},
                               index=df.columns)
    unico_review = unico_review.rename_axis('Colunas', axis='columns')
    #unico_review


    # In[11]:


    #Plota em gráfico de barras horizontal
    data = go.Bar(x = unico, 
                  y = df.columns, 
                  orientation = 'h', 
                  marker = {'color' : '#00B7CC'})

    layout = go.Layout(title = '', 
                       yaxis = {'title': ''}, 
                       xaxis = {'title': ''})

    fig = go.Figure(data = data, layout = layout)
    fig.update_yaxes(showline = True, linewidth = 1, linecolor = '#717171')
    fig.update_xaxes(showgrid = True, gridwidth = 1, gridcolor = '#D9D9DE')
    fig.update_layout({'plot_bgcolor': '#FFFFFF', 'paper_bgcolor': '#FFFFFF'})
    fig.update_layout(xaxis=dict(ticksuffix = '%'))
    #iplot(fig)
    fig.write_html(pasta + "/fnt_unicos.html")


    # # Verifica a completude da tabela

    # In[12]:


    #Completa espaços vaszios com zero
    df = df.fillna(0)

    #Converte as colunas para os valores corretos
    df.ID_STG_FNT_ITT = df.ID_STG_FNT_ITT.astype(np.int64)
    df.NUM_CNPJ = df.NUM_CNPJ.astype(np.int64)
    df.NUM_CMP_CNPJ = df.NUM_CMP_CNPJ.astype(np.int64)
    df.NOM_COM = df.NOM_COM.astype (str)
    df.NOM_RAZ_SCL = df.NOM_RAZ_SCL.astype (str)
    #df.dtypes


    # In[13]:


    #Calcula o número de linhas completas por coluna
    coluna_id = len([x for x in df.ID_STG_FNT_ITT if x != 0]) * 100 / len (df.ID_STG_FNT_ITT)
    coluna_num_cnpj = len([x for x in df.NUM_CNPJ if x != 0]) * 100 / len (df.NUM_CNPJ)
    coluna_num_comp = len([x for x in df.NUM_CMP_CNPJ if x != 0]) * 100 / len (df.NUM_CMP_CNPJ)
    coluna_nome_com = len([x for x in df.NOM_COM if x != 0]) * 100 / len (df.NOM_COM)
    coluna_nome_raz = len([x for x in df.NOM_RAZ_SCL if x != 0]) * 100 / len (df.NOM_RAZ_SCL)
    coluna_data_inc = len([x for x in df.DAT_INC_DBO if x != 0]) * 100 / len (df.DAT_INC_DBO)

    campos_validos = [coluna_id, coluna_num_cnpj, coluna_num_comp, coluna_nome_com, coluna_nome_raz, coluna_data_inc]

    #Define um conjunto de rótulos para o index
    preenchimento_labels = ['ID_STG_FNT_ITT', 'NUM_CNPJ', 
                            'NUM_CMP_CNPJ', 'NOM_COM', 
                            'NOM_RAZ_SCL', 'DAT_INC_DBO']

    #Cria uma nova tabela com todos os dados obtidos
    tabela_review = pd.DataFrame({'Campos Válidos': campos_validos},
                               index=preenchimento_labels)
    tabela_review = tabela_review.rename_axis('Colunas', axis='columns')
    #tabela_review


    # In[14]:


    #Plota em gráfico de barras horizontal
    data = go.Bar(x = campos_validos, 
                  y = preenchimento_labels, 
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
    fig.write_html(pasta + "/fnt_preenchimento.html")


    # In[15]:


    #Separa por grupos os valores diferentes encontrados nas colunas de datas
    datas_inc = df[df['DAT_INC_DBO'] != 0]
    datas_inc = datas_inc.groupby('DAT_INC_DBO').count()
    datas_inc

    #Analisa os valores únicos encontrados e calcula a porcentagem de seu tamanho com o número de linhas da tabela
    conta = 0
    porcentagem = []
    for x in datas_inc.ID_STG_FNT_ITT:
        conta = x * 100 / len(df)
        porcentagem.append (conta)

    #Cria um dataframe
    datas_encontradas = pd.DataFrame({'Porcentagem': porcentagem},
                               index=datas_inc.index)
    datas_encontradas = datas_encontradas.rename_axis('Datas Encontradas', axis='columns')
    datas_encontradas.index.name = None

    visualiza = (datas_encontradas
                    .style
                    .format({'Porcentagem':"{:.2f}%"})
                    .applymap(destaque_coluna, subset=pd.IndexSlice[:, ['Porcentagem']]))
    write_to_html_file(visualiza, title='', filename=pasta + "/fnt_tab_datas.html")
    visualiza


    # # Analisa os CNPJs válidos desconsiderado linhas nulas, cnpjs inválidos e nomes idênticos

    # In[16]:


    #Agrupa por nomes idênticos
    nome_identico = df.groupby('NOM_RAZ_SCL').count().sort_values(by = 'NUM_CNPJ', ascending = False)

    #Depreza os nomes idênticos
    nome_identico = nome_identico[nome_identico['ID_STG_FNT_ITT'] > 1]

    #Adiciona a listas os CNPJs por nomes idênticos ou únicos
    cnpj_nome_identico = [df.NUM_CNPJ[x] for x in range (len (df)) if df.NOM_RAZ_SCL[x] in nome_identico.index]
    cnpj_c_nome_identico = [df.NUM_CMP_CNPJ[x] for x in range (len (df)) if df.NOM_RAZ_SCL[x] in nome_identico.index]
    cnpj_nome_unico = [df.NUM_CNPJ[x] for x in range (len (df)) if df.NOM_RAZ_SCL[x] not in nome_identico.index]
    cnpj_c_nome_unico = [df.NUM_CMP_CNPJ[x] for x in range (len (df)) if df.NOM_RAZ_SCL[x] not in nome_identico.index]


    # In[17]:


    #Analisa apenas os CNPJs cuja a linha da coluna NUM_CNPJ possui valor único
    cnpjList_nome_unico = [str(cnpj_nome_unico[c]) + str(cnpj_c_nome_unico[c]) for c in range (len(cnpj_nome_unico))]

    #Verifica o tamanho do CNPJ e adiciona a listas de validos ou inválidos, com mais ou com menos de 14 caracteres
    cnpj_valido_nome_unico = [cnpjList_nome_unico[c] for c in range (len(cnpjList_nome_unico)) if len(cnpjList_nome_unico[c]) == 14]
    cnpj_nao_valido = [cnpjList_nome_unico[c] for c in range (len(cnpjList_nome_unico)) if len(cnpjList_nome_unico[c]) != 14]
    cnpj_mais = [cnpjList_nome_unico[c] for c in range (len(cnpjList_nome_unico)) if len(cnpjList_nome_unico[c]) > 14]
    cnpj_menos = [cnpjList_nome_unico[c] for c in range (len(cnpjList_nome_unico)) if len(cnpjList_nome_unico[c]) < 14]

    #Analisa apenas os CNPJs cuja a linha da coluna NUM_CNPJ possui valores idênticos
    cnpjList_nome_identico = [str(cnpj_nome_identico[c]) + str(cnpj_c_nome_identico[c]) for c in range (len(cnpj_nome_identico))]

    #Verifica o tamanho do CNPJ e adiciona a listas de validos ou inválidos, com mais ou com menos de 14 caracteres
    cnpj_valido_nome_identico = [cnpjList_nome_identico[c] for c in range (len(cnpjList_nome_identico)) if len(cnpjList_nome_identico[c]) == 14]
    cnpj_nao_valido.extend([(cnpjList_nome_identico[c]) for c in range (len(cnpjList_nome_identico)) if len(cnpjList_nome_identico[c]) != 14])
    cnpj_mais.extend([(cnpjList_nome_identico[c]) for c in range (len(cnpjList_nome_identico)) if len(cnpjList_nome_identico[c]) > 14])
    cnpj_menos.extend([(cnpjList_nome_identico[c]) for c in range (len(cnpjList_nome_identico)) if len(cnpjList_nome_identico[c]) < 14])

    #len(cnpjList_nome_unico), len(cnpjList_nome_identico), len(cnpj_valido_nome_unico), len(cnpj_valido_nome_identico), \
    #len(cnpj_nao_valido), len(cnpj_mais), len(cnpj_menos)


    # # Gráfico dos CNPJs Únicos

    # In[18]:


    #Plota em gráfico de setores
    cnpjs_unicos = len(np.unique(cnpj_valido_nome_unico)) + len(np.unique(cnpj_valido_nome_identico))
    cnpjs_identicos = len(cnpj_valido_nome_unico) + len(cnpj_valido_nome_identico) - cnpjs_unicos

    valores_unicos = cnpjs_unicos*100/(len(cnpj_valido_nome_unico) + len(cnpj_valido_nome_identico))
    valores_identicos = 100 - valores_unicos

    labels = ['CNJPs Validados Únicos', 'CNJPs Validados Idênticos']
    colors = ['#3749e9', '#112244']
    sizes = [valores_unicos, valores_identicos]
    explode = (0, 0.05)

    fig = go.Figure(data=[go.Pie(labels=labels, values=sizes)])
    fig.update_traces(marker=dict(colors=colors, line=dict(color='#000000', width=0)))
    fig.update_traces(texttemplate='%{percent:.2%f}')
    #iplot(fig)
    fig.write_html(pasta + "/fnt_cnpjs_unicos.html")


    # # Gráfico de todos os CNPJs válidos desconsiderado linhas nulas, cnpjs inválidos e nomes idênticos

    # In[19]:


    #Plota em gráfico de setores
    cnpjs_unicos = len(np.unique(cnpj_valido_nome_unico))
    cnpjs_identicos = len(cnpj_valido_nome_unico) - cnpjs_unicos

    #CNPJs válidos
    conta = cnpjs_unicos
    valores_validos_unicos = (conta*100) / len(df)

    #CNPJs descartados, mas válidos
    conta = len(cnpj_valido_nome_identico) + cnpjs_identicos
    valores_validos_identicos = (conta*100) / len(df)

    #CNPJs não válidos
    conta = len(cnpj_nao_valido)
    valores_nao_validos = (conta*100) / len(df)

    labels = 'Válidos', 'Invalidados', 'Não válidos'
    colors = ['#00B7CC', '#3749e9', '#112244']
    sizes = [valores_validos_unicos, valores_validos_identicos, valores_nao_validos]
    explode = (0, 0.05, 0.05)

    fig = go.Figure(data=[go.Pie(labels=labels, values=sizes)])
    fig.update_traces(marker=dict(colors=colors, line=dict(color='#000000', width=0)))
    fig.update_traces(texttemplate='%{percent:.2%f}')
    #iplot(fig)
    fig.write_html(pasta + "/fnt_cnpjs_validos.html")


    # # Gráfico de todos os CNPJs por número de carácteres

    # In[20]:


    #Plota em gráfico de setores
    # =14 Char
    exat_14_char = valores_validos_unicos + valores_validos_identicos

    # +14 Char
    conta = len(cnpj_mais)
    mais_14_char = (conta*100) / len (df)

    # -14 Char
    conta = len(cnpj_menos)
    menos_14_char = (conta*100) / len (df)

    labels = '+14 Caracteres', '-14 Caracteres', '14 Caracteres (Correto)'
    colors = ['#3749e9', '#112244', '#00B7CC']
    sizes = [mais_14_char, menos_14_char, exat_14_char]
    explode = (0.03, 0.03, 0.03)

    fig = go.Figure(data=[go.Pie(labels=labels, values=sizes)])
    fig.update_traces(marker=dict(colors=colors, line=dict(color='#000000', width=0)))
    fig.update_traces(texttemplate='%{percent:.2%f}')
    #iplot(fig)
    fig.write_html(pasta + "/fnt_cnpjs_caracteres.html")


    # # Gráfico de Nomes Únicos

    # In[21]:


    #Plota em gráfico de setores
    nome_identico = nome_identico.ID_STG_FNT_ITT.sum()*100/len(df)
    nome_unico = 100 - nome_identico

    labels = ['Nomes Únicos', 'Nomes Idênticos']
    colors = ['#3749e9', '#112244']
    sizes = [nome_unico, nome_identico]
    explode = (0, 0.05)

    fig = go.Figure(data=[go.Pie(labels=labels, values=sizes)])
    fig.update_traces(marker=dict(colors=colors, line=dict(color='#000000', width=0)))
    fig.update_traces(texttemplate='%{percent:.2%f}')
    #iplot(fig)
    fig.write_html(pasta + "/fnt_nomes_unicos.html")


    # # Indicadores de Validação

    # In[22]:


    #Calcula a média de preenchimento da remessa
    media_preenchimento = sum (campos_validos) / df.shape[1]

    #Calcula de validação
    media_validacao = valores_validos_unicos

    #media_preenchimento, media_validacao

    html_string = '''<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="author" content="git: diegosilva89, ud21">
  <title>METAlitcs - STG_FNT_ITT</title>
  <link rel="stylesheet" href="content/style.css">
  <link rel="icon" href="content/favicon.png">
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
          <p>STG_FNT_ITT</p>
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
            <div class="stg-in">
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

          <div class="index_two_rows">
            <p>Índice de Pagamentos<br>em Dia</p>
          </div>
          <a style="text-decoration: none;" href="index_MOD.html">
            <div class="stg">
              <p>Por Modalidades</p>
            </div>
          </a>
          <div class="index_two_rows">
            <p>Índice de Número de Pagamentos por Clientes</p>
          </div>
          <a style="text-decoration: none;" href="index_FaixaVAL.html">
            <div class="stg">
              <p>Por Faixas de Valores</p>
            </div>
          </a>
        </div>
      </div>

      <div class="container-content-col">
        <section id="graphs">
          <div class="static_graph_container_01">
            <div class="graph_one">
              <!-- graph form -->
              <div class="head">
                <div class="title">Validade da Tabela</div>
              </div>
              <div class="table_content">
                <div class="table_value">''' + str(int(media_validacao)) + '''%</div>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_two">
              <!-- graph form -->
              <div class="head">
                <div class="title">Média de Preenchimento da Tabela</div>
              </div>
              <div class="table_content">
                <div class="table_value">''' + str(int(media_preenchimento)) + '''%</div>
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
                <iframe src=content/fnt_preenchimento.html></iframe>
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
                <iframe src=content/fnt_tab_datas.html></iframe>
              </div>
              <!-- graph form -->
            </div>
          </div>

          <div class="dynamic_graph_container_FNT">
            <div class="graph_one">
              <!-- graph form -->
              <div class="head">
                <div class="title">Validação dos Tipos de Dados</div>
                <div class="paragraph">Porcentagem de campos preenchidos por colunas</div>
              </div>
              <div class="content">
                <iframe src=content/fnt_tipo.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_two">
              <!-- graph form -->
              <div class="head">
                <div class="title">Definição das Colunas com Dados Sensíveis</div>
                <div class="paragraph">Porcentagem de campos preenchidos por colunas</div>
              </div>
              <div class="content">
                <iframe src=content/fnt_tab_sensibilidade.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_three">
              <!-- graph form -->
              <div class="head">
                <div class="title">Validação de Dados idênticos</div>
                <div class="paragraph">Porcentagem de campos preenchidos por colunas</div>
              </div>
              <div class="content">
                <iframe src=content/fnt_unicos.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_four">
              <!-- graph form -->
              <div class="head">
                <div class="title">Validade Geral da Tabela</div>
                <div class="paragraph">Porcentagem de campos de CNPJs váidos (somente linhas com Razões Sociais 
                  Únicas), invalidados (inclui CNPJs válidos, mas em linhas com Razões Sociais Idênticas) e não
                  válidos (CNPJs com mais ou menos de 14 caracteres)</div>
              </div>
              <div class="content">
                <iframe src=content/fnt_cnpjs_validos.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_five">
              <!-- graph form -->
              <div class="head">
                <div class="title">CNPJs Únicos x idênticos</div>
                <div class="paragraph">Porcentagem de campos com dados únicos x idênticos</div>
              </div>
              <div class="content">
                <iframe src=content/fnt_cnpjs_unicos.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_six">
              <!-- graph form -->
              <div class="head">
                <div class="title">Contagem de Caracteres dos CNPJs</div>
                <div class="paragraph">Porcentagem de campos com 14 caracteres, mais de 14 e menos de 14 da 
                  soma das colunas NUM_CNPJ e NUM_COMP
                </div>
              </div>
              <div class="content">
                <iframe src=content/fnt_cnpjs_caracteres.html></iframe>
              </div>
              <!-- graph form -->
            </div>
            <div class="graph_seven">
              <!-- graph form -->
              <div class="head">
                <div class="title">Razão Social Únicos x Idênticos</div>
                <div class="paragraph">Porcentagem de campos com dados únicos x idênticos</div>
              </div>
              <div class="content">
                <iframe src=content/fnt_nomes_unicos.html></iframe>
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

    f = open(relatorio + '/table_FNT.html','w', encoding='utf-8')
    f.write(html_string)
    f.close()

    print(f"O Relatório de Validação da Tabela STG_FNT_ITT foi criado com sucesso!")
