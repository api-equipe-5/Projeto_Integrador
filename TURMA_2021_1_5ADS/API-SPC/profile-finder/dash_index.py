# imports
import socket
import dash
import dash_table
# import dash_auth
#from dash_extensions import Download
from dash.dependencies import Input, Output
import dash_core_components as dcc
import dash_html_components as html
import dash_bootstrap_components as dbc
import dash_daq as daq
import pandas as pd
import plotly.graph_objs as go
import pickle
# import psycopg2
import numpy as np
import folium
import io
from dash.dependencies import Input, Output, State
from app import app
#import geopandas
import plotly.express as px
from dash.exceptions import PreventUpdate

from sklearn.manifold import TSNE

from biblioteca_recomendacao import get_content_based_recommendations




##############

from sklearn.preprocessing import  MinMaxScaler 
from sklearn.cluster import KMeans
from sklearn.decomposition import  PCA
from mpl_toolkits.mplot3d import Axes3D

import matplotlib.pyplot as plt

import asyncio


df2 = pd.read_csv('assets/olist_segmentado.csv')

df3 = pd.read_csv('assets/olist_processado.csv')


#Normalização com média 0 e desvio 1
normaliza = MinMaxScaler()

#Aplica a normalização
#X_std = normaliza.fit_transform(df2)


#transformando os dados normalizados em um dataframe
#df2 = pd.DataFrame(X_std, columns=['ano', 'mes', 'customer_city_codes', 'customer_state_codes'])

#Realizando a aplicação do Kmeans
km = KMeans(n_clusters=4)
clusters = km.fit_predict(df2)
df2['cluster'] = clusters


#plota o gráfico de dispersão
fig4 = plt.figure(figsize=(20,10))
ax = fig4.add_subplot(111, projection='3d')

x = df2['ano']
y = df2['mes']
z = df2['customer_city_codes']

ax.scatter(x, y, z, marker='s', c=df2['cluster'], s=40, cmap='tab10')

plt.xlabel('Ano')
plt.ylabel('Mês')
ax.set_zlabel('Cidade')

fig4 = px.scatter_3d(df2, x= x, y=y, z=z,
                    color='cluster', symbol='cluster')



#############







# Create map object

df = pd.read_csv('assets/dataset2.csv')
# filename = 'assets/dados.json'
# df = geopandas.read_file(filename, driver='GeoJSON')
geracoes = df['geracoes'].unique()
produtos = df['top10_produtos'].unique()
renda = df['renda'].unique()
estado = df['SIGLA_UF'].unique()
estado = sorted(estado)
colunas = df.columns


veteranos = df[df['geracoes'] == '1900 a 1940 - veteranos']
boomers = df[df['geracoes'] == '1940 a 1959 - baby boomers ']
ger_x = df[df['geracoes'] == '1980 a 1994 - geração y']
ger_y = df[df['geracoes'] == '1960 a 1979 - geração x']
ger_z = df[df['geracoes'] == '1994 a 2010 - geração z']

trace1 = go.Bar(
    x=veteranos['renda'].unique(),
    y=veteranos.groupby('renda')['geracoes'].count(),
    marker_color=px.colors.qualitative.Dark24[0],  # color
    text=veteranos.groupby('renda')['geracoes'].count(),  # label/text
    textposition="outside",  # text position
    name="veteranos",  # legend name
)

trace2 = go.Bar(
    x=boomers['renda'].unique(),
    y=boomers.groupby('renda')['geracoes'].count(),
    marker_color=px.colors.qualitative.Dark24[1],  # color
    text=boomers.groupby('renda')['geracoes'].count(),  # label/text
    textposition="outside",  # text position
    name="baby boomers",  # legend name
)

trace3 = go.Bar(
    x=ger_x['renda'].unique(),
    y=ger_x.groupby('renda')['geracoes'].count(),
    marker_color=px.colors.qualitative.Dark24[2],  # color
    text=ger_x.groupby('renda')['geracoes'].count(),  # label/text
    textposition="outside",  # text position
    name="geração x",  # legend name
)

trace4 = go.Bar(
    x=ger_y['renda'].unique(),
    y=ger_y.groupby('renda')['geracoes'].count(),
    marker_color=px.colors.qualitative.Dark24[3],  # color
    text=ger_y.groupby('renda')['geracoes'].count(),  # label/text
    textposition="outside",  # text position
    name="geração y",  # legend name
)

trace5 = go.Bar(
    x=ger_z['renda'].unique(),
    y=ger_z.groupby('renda')['geracoes'].count(),
    marker_color=px.colors.qualitative.Dark24[4],  # color
    text=ger_z.groupby('renda')['geracoes'].count(),  # label/text
    textposition="outside",  # text position
    name="geração z",  # legend name
)

data = [trace1, trace2, trace3, trace4, trace5]  # combine two charts/columns
# define how to display the columns
layout = go.Layout(
    barmode="group", title="Faixa Salarial x Gerações - Brasil")
fig1 = go.Figure(data=data, layout=layout)
fig1.update_layout(
    title=dict(x=0.5),  # center the title
    xaxis_title="Faixa Salarial",  # setup the x-axis title
    yaxis_title="Total Pessoas",  # setup the x-axis title
    margin=dict(l=20, r=20, t=60, b=20),  # setup the margin
    paper_bgcolor="aliceblue",  # setup the background color
)
fig1.update_traces(texttemplate="%{text:.2s}")  # text formart


app.layout = html.Div(className="div-wrapper",
    children=[        
        html.Div(className="top-bar",
                 children=[
                     html.P(className="logo", children=["Profile Finder"])
                 ]
                 ),
        html.Div(className="menu-bar-left",
                 children=[
                     html.Div(style={'width': '100px', 'height': '100%', 'float': 'left',  'marginTop': '10px'},
                              children=[
                         html.Img(src="/assets/imgs/stats.png", width="35px",
                                  height="35px", style={'marginTop': '5px', 'paddingLeft': '10px', 'borderLeft': '3px solid yellow'})
                     ]),

                 ]),  # menu1

        html.Div(className="menu-bar-filters", children=[
            html.Div(className="categories",
                     children=[
                         html.Div(className="filter-title-div",
                                  children=[html.Span(className="filter-title-span", children=['Localização'])
                                            ]),
                         html.P(className='estadoTitle', children=['Estado:']),
                         dcc.Dropdown(id='state_dropdown', className="filter-dropdown", style={ 'borderColor': '#315475'},
                                      options=[{'label': i.upper(), 'value': i}
                                               for i in estado],
                                      value=[],
                                      disabled=False,
                                      clearable=True,
                                      multi=False
                                      ),
                         html.P(className='estadoTitle', children=['Cidade:']),
                         dcc.Dropdown(id='city_dropdown', className="filter-dropdown", style={ 'borderColor': '#315475'},
                                      options=[],
                                      value=[],
                                      disabled=False,
                                      clearable=True,
                                      multi=False
                                      )
                     ]),

        ]),  # menu 2

        html.Div(className="top-title", children=[
            dcc.Tabs(
        id="tabs-with-classes",
        value='tab-1',
        parent_className='custom-tabs',
        className='custom-tabs-container',
        children=[
            dcc.Tab(
                label='Gráficos',
                value='tab-1',
                className='custom-tab',
                selected_className='custom-tab--selected',
                children=[
                    html.Div(style={}, children=[                        
                        html.Div(className="graph-1",
                            children=[
                                html.P(className="graph-title", children=["GRÁFICO POR ESTADO"]),
                                dcc.Graph(
                                    id='our_graph',
                                    figure=fig1,
                                    #config={"displayModeBar": False},
                                ),
                            ]),
                        html.Div(className="graph-2",
                            children=[
                                html.P(className="graph-title", children=["GRÁFICO POR CIDADE"]),
                                dcc.Graph(
                                    id='our_graph1',
                                    figure=fig1,
                                    
                                    #config={"displayModeBar": False},
                                ),
                            ]),
                            html.Div(className="graph-3",
                            children=[   
                                html.P(className="graph-title", children=["MAPA DE CLUSTER"]),                             
                                html.Iframe(src="/assets/mapa_cluster.html",
                                    style={"height": "500px", "width": "100%"})
                            ]),          
                    ])
                    
                ]
            ),
            dcc.Tab(
                label='Produtos',
                value='tab-2',
                className='custom-tab',
                selected_className='custom-tab--selected',
                children=[
                    dash_table.DataTable(
                    id='table',
                    columns=[{"name": "Produtos mais vendidos", "id": "0"}],    
                    style_cell={'textAlign': 'center'},     
                    style_header={'backgroundColor': 'rgb(206, 206, 206)', 'fontWeight': 'bold'},          
                    )]
            ),
            dcc.Tab(
                label='Recomendação de produtos',
                value='tab-3',
                className='custom-tab',
                selected_className='custom-tab--selected',
                children=[
                    html.Div(className='grafico-cluster', children=[
                        dcc.Graph(
                        style={'height': '500px', 'borderColor': '#315475'},
                        id="teste123",
                        figure = fig4,
                        )

                    ]),
                    html.Div(className='passo-a-passo', children=[
                        html.H1(style={'float' : 'left', 'width': '100%', 'marginTop': '50px'},children=["Passo 1"]),
                        html.P(style={'float' : 'left', 'width': '100%'}, children=["Selecione um dos clusters:"]),
                        dcc.Dropdown(id='clusters_dropdown', className="filter-dropdown", style={'borderColor': '#315475'},
                                      options=[
                                        {'label': 'Cluster 0', 'value': '0'},
                                       {'label': 'Cluster 1', 'value': '1'},
                                       {'label': 'Cluster 2', 'value': '2'},
                                       {'label': 'Cluster 3', 'value': '3'}],
                                      value=[],
                                      disabled=False,
                                      clearable=True,
                                      multi=False
                        ),
                        html.H1(style={'float' : 'left', 'width': '100%', 'marginTop': '50px'}, children=["Passo 2"]),
                        html.P(style={'float' : 'left', 'width': '100%'}, children=["Selecione um dos produtos:"]),
                        dcc.Dropdown(id='produtos_dropdown', className="filter-dropdown", style={'borderColor': '#315475'},
                                      options=[],
                                      value=[],
                                      disabled=False,
                                      clearable=True,
                                      multi=False
                        ),
                        html.Button('Pesquisar', id='submit-val', n_clicks=0, className="btn-pesquisar")

                    ]),
                    html.Div(id='recomendacao', className='recomendacao-produtos', children=[dash_table.DataTable(
                    id='table1',
                    columns=[{"name": "Produtos recomendados", "id": '0'}],    
                    style_cell={'textAlign': 'center'},     
                    style_header={'backgroundColor': 'rgb(206, 206, 206)', 'fontWeight': 'bold'},          
                    )])
                ]
            ),              
        ]),
             
        ]),

        html.Div(id='tabs-content-classes'),

        
        

        
    ])



@app.callback(
    Output(component_id='our_graph', component_property='figure'),
    [Input(component_id='state_dropdown', component_property='value')]
)
def groupby_estado(estado):
    filtered_data = df[df['SIGLA_UF'] == estado]

    veteranos = filtered_data[filtered_data['geracoes']
                              == '1900 a 1940 - veteranos']
    boomers = filtered_data[filtered_data['geracoes']
                            == '1940 a 1959 - baby boomers ']
    ger_x = filtered_data[filtered_data['geracoes']
                          == '1960 a 1979 - geração x']
    ger_y = filtered_data[filtered_data['geracoes']
                          == '1980 a 1994 - geração y']
    ger_z = filtered_data[filtered_data['geracoes']
                          == '1994 a 2010 - geração z']

    trace1 = go.Bar(
        x=veteranos['renda'].unique(),
        y=veteranos.groupby('renda')['geracoes'].count(),
        marker_color=px.colors.qualitative.Dark24[0],  # color
        text=veteranos.groupby('renda')['geracoes'].count(),  # label/text
        textposition="outside",  # text position
        name="veteranos",  # legend name
    )

    trace2 = go.Bar(
        x=boomers['renda'].unique(),
        y=boomers.groupby('renda')['geracoes'].count(),
        marker_color=px.colors.qualitative.Dark24[1],  # color
        text=boomers.groupby('renda')['geracoes'].count(),  # label/text
        textposition="outside",  # text position
        name="baby boomers",  # legend name
    )

    trace3 = go.Bar(
        x=ger_x['renda'].unique(),
        y=ger_x.groupby('renda')['geracoes'].count(),
        marker_color=px.colors.qualitative.Dark24[2],  # color
        text=ger_x.groupby('renda')['geracoes'].count(),  # label/text
        textposition="outside",  # text position
        name="geração x",  # legend name
    )

    trace4 = go.Bar(
        x=ger_y['renda'].unique(),
        y=ger_y.groupby('renda')['geracoes'].count(),
        marker_color=px.colors.qualitative.Dark24[3],  # color
        text=ger_y.groupby('renda')['geracoes'].count(),  # label/text
        textposition="outside",  # text position
        name="geração y",  # legend name
    )

    trace5 = go.Bar(
        x=ger_z['renda'].unique(),
        y=ger_z.groupby('renda')['geracoes'].count(),
        marker_color=px.colors.qualitative.Dark24[4],  # color
        text=ger_z.groupby('renda')['geracoes'].count(),  # label/text
        textposition="outside",  # text position
        name="geração z",  # legend name
    )

    # combine two charts/columns
    data = [trace1, trace2, trace3, trace4, trace5]
    # define how to display the columns
    layout = go.Layout(
        barmode="group", title="Faixa Salarial x Gerações - " + estado.upper())
    fig1 = go.Figure(data=data, layout=layout)
    fig1.update_layout(
        title=dict(x=0.5),  # center the title
        xaxis_title="Faixa Salarial",  # setup the x-axis title
        yaxis_title="Total Pessoas",  # setup the x-axis title
        margin=dict(l=20, r=20, t=60, b=20),  # setup the margin
        paper_bgcolor="aliceblue",  # setup the background color
    )
    fig1.update_traces(texttemplate="%{text:.2s}")  # text formart

    return fig1


@app.callback(
    Output(component_id='our_graph1', component_property='figure'),
    [Input(component_id='city_dropdown', component_property='value'),
     Input(component_id='state_dropdown', component_property='value')]
)
def groupby_cidade(cidade, estado):
    if cidade == []:
        raise PreventUpdate
    else:
        filtered_data = df[df['NM_MUN'] == cidade]

        veteranos = filtered_data[filtered_data['geracoes']
                                == '1900 a 1940 - veteranos']
        boomers = filtered_data[filtered_data['geracoes']
                                == '1940 a 1959 - baby boomers ']
        ger_x = filtered_data[filtered_data['geracoes']
                            == '1960 a 1979 - geração x']
        ger_y = filtered_data[filtered_data['geracoes']
                            == '1980 a 1994 - geração y']
        ger_z = filtered_data[filtered_data['geracoes']
                            == '1994 a 2010 - geração z']


        trace1 = go.Bar(
            x=veteranos['renda'].unique(),
            y=veteranos.groupby('renda')['geracoes'].count(),
            marker_color=px.colors.qualitative.Dark24[0],  # color
            text=veteranos.groupby('renda')['geracoes'].count(),  # label/text
            textposition="outside",  # text position
            name="veteranos",  # legend name
        )

        trace2 = go.Bar(
            x=boomers['renda'].unique(),
            y=boomers.groupby('renda')['geracoes'].count(),
            marker_color=px.colors.qualitative.Dark24[1],  # color
            text=boomers.groupby('renda')['geracoes'].count(),  # label/text
            textposition="outside",  # text position
            name="baby boomers",  # legend name
        )

        trace3 = go.Bar(
            x=ger_x['renda'].unique(),
            y=ger_x.groupby('renda')['geracoes'].count(),
            marker_color=px.colors.qualitative.Dark24[2],  # color
            text=ger_x.groupby('renda')['geracoes'].count(),  # label/text
            textposition="outside",  # text position
            name="geração x",  # legend name
        )

        trace4 = go.Bar(
            x=ger_y['renda'].unique(),
            y=ger_y.groupby('renda')['geracoes'].count(),
            marker_color=px.colors.qualitative.Dark24[3],  # color
            text=ger_y.groupby('renda')['geracoes'].count(),  # label/text
            textposition="outside",  # text position
            name="geração y",  # legend name
        )

        trace5 = go.Bar(
            x=ger_z['renda'].unique(),
            y=ger_z.groupby('renda')['geracoes'].count(),
            marker_color=px.colors.qualitative.Dark24[4],  # color
            text=ger_z.groupby('renda')['geracoes'].count(),  # label/text
            textposition="outside",  # text position
            name="geração z",  # legend name
        )

        # combine two charts/columns
        data = [trace1, trace2, trace3, trace4, trace5]
        # define how to display the columns
        layout = go.Layout(
            barmode="group", title="Faixa Salarial x Gerações - " + cidade.upper() + " - " + estado.upper())
        fig1 = go.Figure(data=data, layout=layout)
        fig1.update_layout(
            title=dict(x=0.5),  # center the title
            xaxis_title="Faixa Salarial",  # setup the x-axis title
            yaxis_title="Total Pessoas",  # setup the x-axis title
            margin=dict(l=20, r=20, t=60, b=20),  # setup the margin
            paper_bgcolor="aliceblue",  # setup the background color
        )
        fig1.update_traces(texttemplate="%{text:.2s}")  # text formart

        return fig1


@app.callback(
    Output('city_dropdown', 'options'),
    Input('state_dropdown', 'value'))
def set_cities_options(estado):
    return [{'label': i.upper(), 'value': i} for i in df.loc[df["SIGLA_UF"] == estado, "NM_MUN"].unique()]

@app.callback(
    Output('table', 'data'),
    Input('city_dropdown', 'value'))
def update_table(cidade):
    cidade = df3.loc[df3["customer_city"] == cidade,
                'product_category_name'].unique()
    # print(cidade[0])
    # prod = cidade[0].strip('][').split(', ')
    new = []
    i = 0
    for x in cidade:
        if i < 10:
            new.append(x)
            i += 1

    df1 = pd.DataFrame(new)
    return df1.to_dict('rows')


@app.callback(
    Output('produtos_dropdown', 'options'),
    Input('city_dropdown', 'value'))
    
def set_prods_options(cidade):
    cidade = df3.loc[df3["customer_city"] == cidade,
                'product_id'].unique()
    new = []
    i = 0
    for x in cidade:
        if i <= 10:
            new.append(x)
            i += 1
    return [{'label': i, 'value': i} for i in new]
    

# @app.callback(
#     Output('table1', 'data'),
#     Input('clusters_dropdown', 'value'),
#     Input('produtos_dropdown', 'value'))
# def recomenda(cluster, prod):
#     if cluster and prod:
#         prod1 = get_content_based_recommendations(int(cluster), prod)
#         df1 = pd.DataFrame(prod1)
#         new = []
#         for x in df1.to_dict('rows'):
#             new.append("produto: " + x['product_id'] + " | categoria: " + x['product_category_name'])
#             #print(x['product_category_name'])
#         df = pd.DataFrame(new)
#         return df.to_dict('rows')

@app.callback(
    dash.dependencies.Output('table1', 'data'),
    [dash.dependencies.Input('submit-val', 'n_clicks')],
    [dash.dependencies.State('produtos_dropdown', 'value'), dash.dependencies.State('clusters_dropdown', 'value')])
def update_output(n_clicks, prod, cluster):
    prod1 = get_content_based_recommendations(int(cluster), prod)
    df1 = pd.DataFrame(prod1)
    new = []
    for x in df1.to_dict('rows'):
        new.append("produto: " + x['product_id'] + " | categoria: " + x['product_category_name'])
        #print(x['product_category_name'])
    df = pd.DataFrame(new)
    return df.to_dict('rows')
    

host = socket.gethostbyname(socket.gethostname())

if __name__ == '__main__':
    app.run_server(debug=True, host=host, port=8080)
