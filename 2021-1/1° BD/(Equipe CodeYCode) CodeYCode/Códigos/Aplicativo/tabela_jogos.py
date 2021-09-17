import requests
from bs4 import BeautifulSoup
import pandas as pd
import func


def tabela_jogos_hoje():

    resposta = requests.get('https://www.goal.com/br/not%C3%ADcias/programacao-partidas-futebol-tv-aberta-fechada-onde-assistir/1jf3cuk3yh5uz18j0s89y5od6w')
    lista_jogos = []
    partidas = []
    content = resposta.content
    site = BeautifulSoup(content, 'html.parser')
    tabela_jogos = site.find('table', attrs={'class': 'tableizer-table'})
    jogos = tabela_jogos.findAll('td')
    for jogo in jogos:
        partidas.append(jogo.text)
    j = 0
    lista_partidas = []
    while j < len(partidas):
        clube = partidas[0 + j]
        lista_jogos.append(clube)
        campeonato = partidas[1 + j]
        horario = partidas[2 + j]
        onde_assistir = partidas[3 + j]
        #ver_internet = partidas[4 + j]
        lista_partidas.append([clube, campeonato, horario, onde_assistir])
        j += 5
    tab_partidas_e_horários = pd.DataFrame(lista_partidas, columns=['JOGO', 'CAMPEONATO', 'HORÁRIO', 'ONDE ASSISTIR'])
    return lista_jogos

#print(tabela_jogos_hoje())



for i in tabela_jogos_hoje():
    if func.encontrar_comando(jogo, i):
        print(i)
    else:
        print('nada')
