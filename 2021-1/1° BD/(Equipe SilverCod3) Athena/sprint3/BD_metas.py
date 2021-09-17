import sqlite3
from sqlite3 import Error
def conexaobanco():
    caminho ="C:\\Users\\Famil\\OneDrive\\Área de Trabalho\\Fatec - 1 semestre\\banquinho\\Banco_Athena.db"
    con = None
    try:
        con = sqlite3.connect(caminho)
    except Error as ex:
        print(ex)
    return con

vcon = conexaobanco()
def inserir(conexao,sql):                 
    try:
        c = conexao.cursor()
        c.execute(sql)
        conexao.commit()  
        print('registro inserido')
    except Error as ex:
        print(ex)

materia = []
tempo_estudado = []
hora_estudada = []
tempo_estudado_restante = []
while True:
    materia_cadastro = str(input('Qual matéria gostaria de cadastrar: ')).strip()
    materia.append(materia_cadastro)
    resp = str(input('Gostaria de cadastrar outra materia ? [s/n]: ')).strip().lower()[0]
    if resp != "n":
        if resp == "s":
            continue
        else:
            print('Dado inconsistente, tente novamente')
            continue
    else:
        break
print(''' Defina uma meta
 [1] - Meta semanal
 [2] - Meta quinzenal
 [3] - Meta mensal''')
while True:
    resp_meta = int(input('Qual a meta desejada ?: '))
    if resp_meta not in range(1, 4):
        print('Valor digitado incorreto, tente novamente por gentileza')
        continue
    else:
        if resp_meta == 1:
            for c in materia:
                time = str(input(f'Digite quantas horas para sua meta SEMANAL. - Matéria: "{c}" [hh:mm]: ')).strip().replace(" ", ":").replace(" e ", ":")
                tempo_estudado.append(time)
        if resp_meta == 2:
            for c in materia:
                time = str(input(f'Digite quantas horas para sua meta QUINZENAL. - Matéria: "{c}" [hh:mm]: ')).strip().replace(" ", ":").replace(" e ", ":")
                tempo_estudado.append(time)
        if resp_meta == 3:
            for c in materia:
                time = str(input(f'Digite quantas horas para sua meta MENSAL. - Matéria: "{c}" [hh:mm]: ')).strip().replace(" ", ":").replace(" e ", ":")
                tempo_estudado.append(time)
    break
while True:
    resp_hora = str(input('Para qual matéria gostaria de adcionar horas estudadas ?: '))
    if resp_hora not in materia:
        print('Não encontrei essa matéria, tente novamente')
        continue
    else:
        hora = str(input(f'Quantas horas gostaria de cadastrar para a matéria "{resp_hora}" [hh:mm]: '))
        hora_estudada.append(hora)
        continuar = str(input('Gostaria de continuar ? [s/n]: ')).strip().lower()[0]
        if continuar != "n":
            if continuar == "s":
                continue
            else:
                print('Dado inconsistente, tente novamente')
                continue
        else:
            break
with open("novo_dado.txt", "a+", encoding='utf-8') as arquivo:
    for pos, c in enumerate(materia):
        arquivo.write(f"Matéria: {materia[pos]} - Tempo/Meta = {tempo_estudado[pos]} - Hora estudada {hora_estudada[pos]}\n" )
        vsql = "INSERT INTO Metas (MATERIA,META,HORA_ESTUDADA)VALUES('"+materia[pos]+"','"+tempo_estudado[pos]+"','"+hora_estudada[pos]+"')"
        inserir(vcon, vsql)
