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


semana = ["segunda", "terça", "quarta", "quinta", "sexta", "sabado"]
materias = []
dias_semana = []
horario_materia = []

try:
    while True:
        semana_dia = (str(input('dia da semana: ')).strip().split()[0].lower())
        if semana_dia not in semana:
            print(semana_dia)
            print("Parece que você digitou algo invalido, tente novamente !")
            continue
        if semana_dia != "sabado":
            x = semana_dia + "-feira"
            dias_semana.append(x)
        else:
            dias_semana.append(semana_dia)
        resp = str(input(f'Gostaria de cadastrar um novo dia da semana ? '
                            f'[SIM/NAO] : ')).upper().strip()[0]
        if resp == "S":
            continue
        if resp == "N":
            break
    print(dias_semana)
except ValueError:
    print('Valor digitado inválido, tente novamente !')
for posi, c in enumerate(dias_semana):
    while True:
        try:
            materia = input(f'Qual matéria gostaria de cadastrar para "{dias_semana[posi]}" ?: ').strip().lower()
            materias.append(materia)
            resp = str(input(f'Gostaria de cadastrar uma nova matéria para "{dias_semana[posi]}" ?: '
                                f'[SIM/NAO] : ')).upper().strip()[0]
            if resp == "S":
                continue
            if resp == "N":
                for pos, c in enumerate(materias):
                    horario_inicial = input(
                        f'Quando começa a aula da matéria: "{materias[pos]}" (hh:mm) ?: ').strip().replace(" ", ":")
                    horario_final = input(
                        f'Quando termina a aula da matéria: "{materias[pos]}" (hh:mm) ?: ').strip().replace(" ",
                                                                                                            ":")
                    horario_materia.append(f"{horario_inicial}-{horario_final}")
                    try:
                        with open("aulas.txt", "a") as arquivo:
                            arquivo.write(f'Dia: {dias_semana[posi]} '
                                            f'Aulas: {materias[pos]} = horario: {horario_materia[pos]} \n')
                            vsql = "INSERT INTO Horarios_ (DIASEMANA,MATERIA, HORARIO)VALUES('"+dias_semana[posi]+"','"+materias[pos]+"','"+horario_materia[pos]+"')"
                        inserir(vcon, vsql)
                    except Exception as error:
                        print('>> Arquivo não encontrado, tente novamente !')
                        print(error)
                materias.clear()
                break
        except Exception as error:
            print('>> Encontramos algum erro, por gentileza tente novamente')
            print(error)
        break
