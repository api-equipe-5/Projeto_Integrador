import api_imdb
import numpy as np
import skfuzzy as fuzzy
from skfuzzy import control as ctrl
from collections import Counter
import matplotlib.pyplot as plt
import random
#pip install scikit-fuzzy
#pip install matplotlib

#OS IFS
#Se score_filme for alto e ano_do_filme for alto a recomendação é alta
#Se score_filme for médio e ano_do_filme for alta a recomendação é média
#Se score_filme for baixo e ano_do_filme for alta/média/baixo a recomendação é baixa
#Se score_filme for alta e ano_do_filme for média/baixo a recomendação é média

# variaveis ponto chave
ano = ctrl.Antecedent(np.arange(1920,2020,1),'ano')
rank = ctrl.Antecedent(np.arange(0,10,1),'rank')
recomendacao = ctrl.Consequent(np.arange(0,100,1),'recomendacao')

#divide por 4 rank
#divisão 2015-2020 novo . 2000 - 2015 medio menor que 2000 velho

rank.automf(names=['pessimo','ruim','medio','bom','otimo'])
recomendacao.automf(names=['muito_baixa','baixa','media','alta','muito_alta'])
ano['atual'] = fuzzy.trimf(ano.universe, [2015,2020,2020])
ano['classico'] = fuzzy.trapmf(ano.universe,[1920,2000,2015,2020])
ano['antigo'] = fuzzy.trimf(ano.universe,[1920,1920,2000])

#grafico matplolib
#ano.view()

#regras Rank e Ano 
rule1 = ctrl.Rule(rank['otimo'] & ano['atual'], recomendacao['muito_alta'])
rule2 = ctrl.Rule(rank['otimo'] & ano['classico'] | rank['bom'] & ano['atual'] | rank['otimo'] & ano['antigo'], recomendacao['alta'])
rule3 = ctrl.Rule(rank['bom'] & ano['classico'] | rank['bom'] & ano['antigo'] | rank['medio'] & ano['classico'] | rank['medio'] & ano['atual'], recomendacao['media'])
rule4 = ctrl.Rule(rank['ruim'] & ano['atual'] | rank['ruim'] & ano['classico'] | rank['medio'] & ano['antigo'], recomendacao['baixa'])
rule5 = ctrl.Rule(rank['pessimo'] & ano['atual'] | rank['pessimo'] & ano['classico'] | rank['pessimo'] & ano['antigo'] | rank['ruim'] & ano['antigo'], recomendacao['muito_baixa'])

recomendacao_crtl = ctrl.ControlSystem([rule1,rule2,rule3,rule4,rule5])
recomendacao_simulacao = ctrl.ControlSystemSimulation(recomendacao_crtl)

def filtroSugestao (filme, block_list):
    filmes_recomendacoes = {'filme':[], 'recomendacao':[]}
    lista_filmes = api_imdb.listaFilmeSugerido(filme, block_list)
    for index,filme in enumerate (lista_filmes['filme']):
        recomendacao_simulacao.input['rank'] = lista_filmes['rating'][index]
        recomendacao_simulacao.input['ano'] = lista_filmes['ano'][index]
        recomendacao_simulacao.compute()
        filmes_recomendacoes['recomendacao'].append(recomendacao_simulacao.output['recomendacao'])
        filmes_recomendacoes['filme'].append(lista_filmes['filme'][index])
    filme_escolhido = filmes_recomendacoes['filme'].pop(filmes_recomendacoes['recomendacao'].index(max(filmes_recomendacoes['recomendacao'], key=float)))
    return filme_escolhido

#array = []
#print('\n \nO filme com maior recomendação é : ', filtroSugestao("Star Wars: The Clone Wars", array))

def getFilmeByGrupo(filmes, block_list):
    return filtroSugestao(random.choice(filmes), (filmes + block_list))