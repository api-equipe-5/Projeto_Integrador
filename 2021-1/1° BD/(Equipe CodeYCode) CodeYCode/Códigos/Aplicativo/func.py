#Bibliotecas demandadas pelo programa
import speech_recognition as sr
from googlesearch import search
import pyttsx3
import webbrowser
import sqlite3
from datetime import datetime
import datetime
import requests
from bs4 import BeautifulSoup
import pandas as pd


#listas de suporte
lista_comandos = ['bete', 'beth', 'bet', 'Bete', 'Beth', 'Bet']
list_times = ['América Mineiro', 'Athletico Paranaense', 'Atlético Goianiense', 'Atlético Mineiro', 'Bahia', 'Bragantino', 'Ceará', 'Chapecoense', 'Corinthians', 'Cuiabá', 'Flamengo', 'Fluminense', 'Fortaleza', 'Grêmio', 'Internacional', 'Juventude', 'Palmeiras', 'Santos', 'São Paulo', 'Sport', 'Avaí', 'Botafogo', 'Brasil de Pelotas', 'Brusque', 'CRB', 'CSA', 'Confiança', 'Coritiba', 'Cruzeiro', 'Goiás', 'Guarani', 'Londrina', 'Náutico', 'Operário', 'Ponte Preta', 'Remo', 'Sampaio Corrêa', 'Vasco', 'Vila Nova', 'Vitória']
lista_sites_apostas = ['bet365', 'betway', '1XBet', 'rivalo']
indices = ['primeiro', 'segundo', 'terceiro', 'quarto']
list_meses = ['janeiro', 'fevereiro', 'março', 'abril', 'maio', 'junho', 'julho', 'agosto', 'setembro', 'outubro', 'novembro', 'dezembro']
list_dias_mes = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31']
lista_anos = ['2021', '2022', '2023', '2024', '2025', '2026', '2027', '2030', '2031']
#Declaração de funções a serem chamadas ao longo do programa

def ouvir_microfone(): #função para ouvir o microfone
    microfone = sr.Recognizer()
    with sr.Microphone() as source:
        microfone.adjust_for_ambient_noise(source)
        audio = microfone.listen(source)
        try:
            frase = microfone.recognize_google(audio, language='pt-BR')
            return frase
        except sr.UnknownValueError:
            return "Não entendi!"

def encontrar_comando (comando, frase): #encontra a palavra chave em uma frase qualquer
    if comando in frase:
        return True
    else:
        return False

def sintese_voz(entrada_de_texto): #função para sintetizar voz
    falar = pyttsx3.init('sapi5')
    falar.say(entrada_de_texto)
    falar.runAndWait()

def pesquisa_web(termo): #realiza a pesquisa em google.com e imprime os links
    list_sites_resultados = []
    pesquisa = search(termo, num_results=10, lang="pt")
    for i in pesquisa:
        list_sites_resultados.append(i)
    return list_sites_resultados

def abrir_site(site):
    webbrowser.open(site, new=0, autoraise=True)

def verificar_data(dia, mes, ano):
    data = f"{ano}"

def consulta_time(time):
    if time in list_times:
        return True
    else:
        return False

def consulta_meses(mes):
    if mes in list_meses:
        return True
    else:
        return False

def consulta_dia(dia):
    if dia in list_dias_mes:
        return True
    else:
        return False

def consulta_ano(ano):
    if ano in lista_anos:
        return True
    else:
        return False
        
def consulta_data(dia, mes, ano):
    if consulta_dia(dia) and consulta_meses(mes.lower()) and consulta_ano(ano):
        return True
    else:
        return False

def gerar_data(dia, mes, ano):
    data = (f'{dia}/{list_meses.index(mes) + 1}/{ano}')
    return data

def lembrete_jogo():
    banco = sqlite3.connect('teste_agenda.db')
    cursor = banco.cursor()
    cursor.execute("SELECT* FROM jogos2 WHERE data='"+data_atual()+"'")
    jogos = 0
    for jogo in cursor:
        jogos += 1
        time_1 = jogo[1]
        time_2 = jogo[2]
        horario = jogo[4]
        sintese_voz(f'{time_1} e {time_2} jogam hoje às {horario}')
    if jogos == 0:
        sintese_voz("Nenhum jogo da sua agenda acontecendo hoje!")
    banco.close()

def data_atual():
    data_atual = datetime.datetime.now()
    #data_e_hora_em_texto = data_e_hora_atuais.strftime('%d/%m/%Y')
    data_em_texto = '{}/{}/{}'.format(data_atual.day, data_atual.month, data_atual.year)
    return data_em_texto

def data_ontem():
    data_atual = datetime.datetime.now()
    data_ontem = data_atual - datetime.timedelta(days=1)
    data_texto = '{}/{}/{}'.format(data_ontem.day, data_ontem.month, data_ontem.year)
    return data_texto

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
    #tab_partidas_e_horários = pd.DataFrame(lista_partidas, columns=['JOGO', 'CAMPEONATO', 'HORÁRIO', 'ONDE ASSISTIR'])
    return lista_jogos

def buscar_jogo_pagina(jogo, lista):
   for i in lista:
        if jogo in i:
           return i

def exibir_agenda():
    banco = sqlite3.connect('teste_agenda.db')
    cursor = banco.cursor()
    cursor.execute("SELECT id,time1, time2, data, horario data from jogos2 ")
    jogos = 0
    for jogo in cursor:
        #print(jogo)
        jogos += 1
        time_1 = jogo[1]
        time_2 = jogo[2]
        data = jogo[3]
        horario = jogo[4]
        sintese_voz(f' {time_1} e {time_2} jogam dia {data} às {horario}')
    if jogos == 0:
        sintese_voz("Não há nenhum Jogo armazenado na sua agenda")
    banco.close()

def inserir_na_agenda(time1, time2, data, horario):
    try:
        banco = sqlite3.connect('teste_agenda.db')
        cursor = banco.cursor()
        cursor.execute("INSERT INTO jogos2(time1, time2, data, horario) VALUES('"+time1+"', '"+time2+"', '"+data+"', '"+horario+"')")
        banco.commit()
        banco.close()
        #print("Agenda atualizada")

    except sqlite3.Error as erro:
        print(f'Erro ao inserir: {erro}')

def deletar_na_agenda(time1, time2):
    try:
        banco = sqlite3.connect('teste_agenda.db')
        cursor = banco.cursor()
        cursor.execute("DELETE FROM jogos2 WHERE time1 = '"+time1+"' and time2 = '"+time2+"'")
        banco.commit()
        banco.close()
        #print("Dados apagados com sucesso!")

    except sqlite3.Error as erro:
        print(f'Erro ao excluir: {erro}')

def limpa_agenda_automaticamente(data_ontem):
    
    try:
        banco = sqlite3.connect('teste_agenda.db')
        cursor = banco.cursor()
        cursor.execute("DELETE FROM jogos2 WHERE data = '"+data_ontem+"'")
        banco.commit()
        banco.close()
        #print("Dados apagados com sucesso!")

    except sqlite3.Error as erro:
        print(f'Erro ao excluir: {erro}')

def atualizar_na_agenda(time1, time2, data, horario):
    banco = sqlite3.connect('teste_agenda.db')
    cursor = banco.cursor()
    cursor.execute("UPDATE jogos2 SET data = '"+data+"', horario = '"+horario+"' WHERE time1 = '"+time1+"' and time2 = '"+time2+"'")
    banco.commit()
    banco.close()
    #print("Dados atualizados com sucesso")


