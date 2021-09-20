import numpy as np
import pandas as pd
import sklearn
import matplotlib.pyplot as plt
# import seaborn as sns


from sklearn.cluster import KMeans
from sklearn.decomposition import  PCA
from sklearn.preprocessing import  MinMaxScaler

import warnings
warnings.simplefilter(action='ignore', category=FutureWarning)

df2 = pd.read_csv('assets/olist_processado.csv')

df2['product_category_name_split'] = df2['product_category_name'].apply(lambda x: x.split('_'))

from collections import Counter

categoria_counts = Counter(c for categorias in df2['product_category_name_split'] for c in categorias)

deletar = ["e", "de", "2", "la"]

for cat in deletar:
    del categoria_counts[cat]

categoria_count_df2 = pd.DataFrame([categoria_counts]).T.reset_index()

categoria_count_df2.columns = ['categorias', 'count']
categoria_count_df2 = categoria_count_df2.sort_values(by='count', ascending=False)

categoria_count_df2.columns = ['categorias', 'count']
categoria_count_df2 = categoria_count_df2.sort_values(by='count', ascending=False)
categoria_count_df2 = categoria_count_df2.nlargest(30, 'count')


df2['order_purchase_timestamp'] = pd.to_datetime(df2['order_purchase_timestamp'])
df2['ano'], df2['mes'], df2['dia'], df2['hora']  = df2['order_purchase_timestamp'].apply(lambda x: x.year), df2['order_purchase_timestamp'].apply(lambda x: x.month), df2['order_purchase_timestamp'].apply(lambda x: x.day), df2['order_purchase_timestamp'].apply(lambda x: x.hour)

prod_categoria = df2.query('product_category_name == "cama_mesa_banho"')



prod= prod_categoria.groupby(['product_id']).count().reset_index()
prod = prod.sort_values(by='customer_id', ascending=False)
prod = prod.nlargest(5, 'customer_id')



prod_id_geral = df2.query('product_id == "99a4788cb24856965c36a24e339b6058"')



df2['product_id'].nunique()

df2 = df2[~df2['price'].isnull()]

def round_down(preco):
    return preco - (preco%100)

df2['preco_arredondado'] = df2['price'].apply(round_down)

df2_preco = df2.loc[(df2["preco_arredondado"] >= 0) & (df2["preco_arredondado"] < 1000)]

data = df2[['customer_city', 'customer_state', 'review_score', 'customer_lat', 'customer_long',
              'product_category_name', 'quantidade_item', 'product_category_name_split','ano', 'mes', 'dia',
              'preco_arredondado']]


data['customer_city'] = data['customer_city'].astype('category')
city = dict(enumerate(data['customer_city'].cat.categories))
data['customer_city_codes'] = data['customer_city'].cat.codes
data['customer_city_reversed'] = data['customer_city_codes'].map(city)

data['customer_state'] = data['customer_state'].astype('category')
state = dict(enumerate(data['customer_state'].cat.categories))
data['customer_state_codes'] = data['customer_state'].cat.codes
data['customer_state_reversed'] = data['customer_state_codes'].map(state)

data['product_category_name'] = pd.Categorical(df2['product_category_name'])
df2['product_category_name'] = data['product_category_name'].astype('category')
prod_code = dict(enumerate(data['product_category_name'].cat.categories))
data['product_category_name_codes'] = data['product_category_name'].cat.codes
data['product_category_name_reversed'] = data['product_category_name_codes'].map(prod_code)



corr = data.corr()

df2_seg = data[['ano', 'mes', 'customer_city_codes', 'customer_state_codes']]

df2_seg.dropna(inplace=True)
df2_seg.isnull().sum()

normaliza = MinMaxScaler()

X_std = normaliza.fit_transform(df2_seg)

ks = range(1,10)
inertias = []
for k in ks:
    #cria o objeto para modelo k-means para os testes
    model = KMeans(n_clusters=k)
    
    #aplica nos componentes selecionados
    model.fit(X_std)
    
    #adiciona os valores para a distância (agitação)
    inertias.append(model.inertia_)

df_norma = pd.DataFrame(X_std, columns=['ano', 'mes', 'customer_city_codes', 'customer_state_codes'])

km = KMeans(n_clusters=4)
clusters = km.fit_predict(df_norma)
df_norma['cluster'] = clusters

retorno = normaliza.inverse_transform(X_std)

df_retorno = pd.DataFrame(retorno, columns=['ano', 'mes', 'customer_city_codes', 'customer_state_codes'])
df_retorno['cluster'] = clusters

cluster_0 = df_retorno[df_retorno['cluster'] == 0]
cluster_1 = df_retorno[df_retorno['cluster'] == 1]
cluster_2 = df_retorno[df_retorno['cluster'] == 2]
cluster_3 = df_retorno[df_retorno['cluster'] == 3]

# cluster_2 = cluster_2.astype('int8')

cluster_0['customer_city_codes_reversed'] = cluster_0['customer_city_codes'].map(city)
cluster_0['customer_state_codes_reversed'] = cluster_0['customer_state_codes'].map(state)

cluster_1['customer_city_codes_reversed'] = cluster_1['customer_city_codes'].map(city)
cluster_1['customer_state_codes_reversed'] = cluster_1['customer_state_codes'].map(state)

cluster_2['customer_city_codes_reversed'] = cluster_2['customer_city_codes'].map(city)
cluster_2['customer_state_codes_reversed'] = cluster_2['customer_state_codes'].map(state)

cluster_3['customer_city_codes_reversed'] = cluster_3['customer_city_codes'].map(city)
cluster_3['customer_state_codes_reversed'] = cluster_3['customer_state_codes'].map(state)

def first(cluster):
    if cluster == 0:
        return list(cluster_0.index)
    elif cluster == 1:
        return list(cluster_1.index)
    elif cluster == 2:
        return list(cluster_2.index)
    elif cluster == 3:
        return list(cluster_3.index)

def second(cluster, ind_list):
    if cluster == 0:
        cluster0_original = df2.iloc[ind_list]
        return cluster0_original
    elif cluster == 1:
        cluster1_original = df2.iloc[ind_list]
        return cluster1_original
    elif cluster == 2:
        cluster2_original = df2.iloc[ind_list]
        return cluster2_original
    elif cluster == 3:
        cluster3_original = df2.iloc[ind_list]
        return cluster3_original

def third(cluster, cluster_original):
    if cluster == 0:
        return pd.get_dummies(cluster_original['product_category_name'])
    elif cluster == 1:
        return pd.get_dummies(cluster_original['product_category_name'])
    elif cluster == 2:
        return pd.get_dummies(cluster_original['product_category_name'])
    elif cluster == 3:
        return pd.get_dummies(cluster_original['product_category_name'])

def fourth(cluster, cluster_original):
    if cluster == 0:
        return pd.get_dummies(cluster_original['preco_arredondado'])
    elif cluster == 1:
        return pd.get_dummies(cluster_original['preco_arredondado'])
    elif cluster == 2:
        return pd.get_dummies(cluster_original['preco_arredondado'])
    elif cluster == 3:
        return pd.get_dummies(cluster_original['preco_arredondado'])


from sklearn.metrics.pairwise import cosine_similarity, euclidean_distances, manhattan_distances


from fuzzywuzzy import process

def busca_produto(produto, cluster, cluster_original):
    if cluster == 0:
        todos_produtos = cluster_original['product_id'].tolist()
        match_proximo = process.extractOne(produto, todos_produtos)
        return match_proximo[0]
    elif cluster == 1:
        todos_produtos = cluster_original['product_id'].tolist()
        match_proximo = process.extractOne(produto, todos_produtos)
        return match_proximo[0]
    elif cluster == 2:
        todos_produtos = cluster_original['product_id'].tolist()
        match_proximo = process.extractOne(produto, todos_produtos)
        return match_proximo[0]
    elif cluster == 3:
        todos_produtos = cluster_original['product_id'].tolist()
        match_proximo = process.extractOne(produto, todos_produtos)
        return match_proximo[0]

# produto = busca_produto('99a4788cb24856965c36a24e339b6058')

def produto_idx(cluster, cluster_original):
    if cluster == 0:
        return dict(zip(cluster_original['product_id'].unique(), list(cluster_original.index)))
    elif cluster == 1:
        return dict(zip(cluster_original['product_id'].unique(), list(cluster_original.index)))
    elif cluster == 2:
        return dict(zip(cluster_original['product_id'].unique(), list(cluster_original.index)))
    elif cluster == 3:
        return dict(zip(cluster_original['product_id'].unique(), list(cluster_original.index)))

def prod_por_nome(nome):
    id = df2.loc[df2["product_category_name"] == nome, "product_id"].unique()
    return id[0]

# prod_por_nome('moveis_decoracao')
# n_recommendations=20
# sim_scores = list(enumerate(cosine_sim[idx]))
# sim_scores = sorted(sim_scores, key=lambda x: x[1], reverse=True)
# sim_scores = sim_scores[1:(n_recommendations+1)]
# similar_produto = [i[0] for i in sim_scores]

# produto_recomendado = cluster1_original[['product_id', 'product_category_name']].iloc[similar_produto]

def get_content_based_recommendations(cluster, produto_string, n_recommendations=10):
    # print(cluster, produto_string)
    ind_list = first(cluster)
    cluster_original = second(cluster, ind_list)
    categoria = third(cluster, cluster_original)
    categoria_preco_arredondado = fourth(cluster, cluster_original)
    categoria_features = pd.concat([categoria, categoria_preco_arredondado], axis=1)
    manhat_sim = manhattan_distances(categoria_features, categoria_features)
    euclid_sim = euclidean_distances(categoria_features, categoria_features)
    cosine_sim = cosine_similarity(categoria_features, categoria_features)
    # prod_id = prod_por_nome(produto_string)
    produto = busca_produto(produto_string, cluster, cluster_original)
    idx_first = produto_idx(cluster, cluster_original)
    idx = idx_first[produto]
    sim_scores_euc = list(enumerate(euclid_sim[idx]))
    sim_scores_euc = sorted(sim_scores_euc, key=lambda x: x[1], reverse=True)
    sim_scores_euc = sim_scores_euc[1:(n_recommendations+1)]
    similar_produto_euc = [i[0] for i in sim_scores_euc]
    # print(f"Porque você comprou {produto}:")
    produto_recomendado = cluster_original[['product_id', 'product_category_name']].iloc[similar_produto_euc]
    # print(produto_recomendado.drop_duplicates(subset='product_category_name', keep='first'))
    return produto_recomendado.drop_duplicates(subset='product_id', keep='first')

# get_content_based_recommendations(0, 'telefonia')

# n_recommendations=10
# sim_scores_euc = list(enumerate(euclid_sim[idx]))
# sim_scores_euc = sorted(sim_scores_euc, key=lambda x: x[1], reverse=True)
# sim_scores_euc = sim_scores_euc[1:(n_recommendations+1)]
# similar_produto_euc = [i[0] for i in sim_scores_euc]


# produto_recomendado_euc = cluster1_original[['product_id', 'product_category_name']].iloc[similar_produto_euc]