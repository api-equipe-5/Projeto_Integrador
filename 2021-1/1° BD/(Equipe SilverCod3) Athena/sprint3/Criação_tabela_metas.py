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
 
vsql= """CREATE TABLE Horariosteste(
            N_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            DIASEMANA VARCHAR(30),
            MATERIA VARCHAR(14),
            HORARIO VARCHAR(30)
  cria      );"""
def rTabela(conexao,sql):
    try:
        c = conexao.cursor()
        c.execute(sql)
        print("Tabela criada")
    except Error as ex:
        print(ex)

criarTabela(vcon,vsql)
vcon.close()
