import sqlite3


def exibir_agenda():
    banco = sqlite3.connect('teste_agenda.db')
    cursor = banco.cursor()
    cursor.execute("SELECT id,time1, time2, data, horario data from jogos2 ")
    for i in cursor:
        print (i)
    banco.close()

def inserir_na_agenda(time1, time2, data, horario):
    try:
        banco = sqlite3.connect('teste_agenda.db')
        cursor = banco.cursor()
        cursor.execute("INSERT INTO jogos2(time1, time2, data, horario) VALUES('"+time1+"', '"+time2+"', '"+data+"', '"+horario+"')")
        banco.commit()
        banco.close()
        print("Agenda atualizada")

    except sqlite3.Error as erro:
        print(f'Erro ao inserir: {erro}')
    print()

def deletar_na_agenda(id):
    try:
        banco = sqlite3.connect('teste_agenda.db')
        cursor = banco.cursor()
        cursor.execute("DELETE FROM jogos2 WHERE id = '"+id+"'")
        banco.commit()
        banco.close()
        print("Dados apagados com sucesso!")

    except sqlite3.Error as erro:
        print(f'Erro ao excluir: {erro}')
    print()

def atualizar_na_agenda(time, data):
    banco = sqlite3.connect('teste_agenda.db')
    cursor = banco.cursor()
    cursor.execute("UPDATE agenda1 SET data = '"+data+"' WHERE time = '"+time+"'")
    banco.commit()
    banco.close()
    print("Dados atualizados com sucesso")
    print()





    


#Criar Tabela
#banco = sqlite3.connect('teste_agenda.db')
#cursor = banco.cursor()
#cod_sql = "CREATE TABLE jogos2 (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , time1 VARCHAR(40) , time2 VARCHAR(40) , data VARCHAR(10) , horario VARCHAR(10)) ;"
#cursor.execute(cod_sql)


#Inserir dados na tabela
#inserir_na_agenda('Cruzeiro', 'São Paulo', '13/01/2021', '13:00')

# try:
# banco = sqlite3.connect('teste_agenda.db')
# cursor = banco.cursor()
#
# # cursor.execute("CREATE TABLE agenda1 (time text, data text)")
#
# # cursor.execute("INSERT INTO agenda1 VALUES('Cruzeiro', '20/05/2020')")
# #
#     cursor.execute("DELETE FROM agenda1 WHERE data = '14/12/2021'")
#     banco.commit()
#     banco.close()
#     print("messagem")
#
# except sqlite3.Error as erro:
#     print(f'Erro ao excluir: {erro}')


# cursor.execute("SELECT * FROM agenda1")
# print(cursor.fetchall())
#time = input("Time: ")
#data = input("Data do jogo: ")
#atualizar_na_agenda(time, data)
#inserir_na_agenda(time, data)


#deletar_na_agenda(time)
# inserir_na_agenda("cruzeiro", "12/07/2021")
#exibir_agenda()

