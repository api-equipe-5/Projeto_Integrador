import sqlite3
from sqlite3 import Error


# INSERIR DADOS NA TABELA DO BD#


def conexaobanco():
    caminho = "C:\\Users\\igor_\\OneDrive\\Área de Trabalho\\SQLiteStudio\\db_athena.db"
    con = None
    try:
        con = sqlite3.connect(caminho)
    except Error as ex:
        print(ex)
    return con


vcon = conexaobanco()

# vsql = """CREATE TABLE GERAL(
#                 N_ID INTEGER PRIMARY KEY AUTOINCREMENT,
#                 MATERIA VARCHAR(30) ,
#                 DIA_SEMANA VARCHAR(30) ,
#                 HORARIOS DEFAULT -1 ,
#                 NOTAS INTEGER DEFAULT -1,
#                 NOTAS_2 INTEGER DEFAULT -1,
#                 NOTAS_3 INTEGER DEFAULT -1,
#                 NOTAS_4 INTEGER DEFAULT -1,
#                 FALTAS INTEGER DEFAULT -1,
#                 HORAS_META INTEGER DEFAULT -1,
#                 HORAS_ESTUDADAS INTEGER DEFAULT -1
#             );"""
vsql = """CREATE TABLE USER(
                N_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                NOME VARCHAR(30),
                EMAIL VARCHAR(30)
            );"""


def criarTabela(conexao, sql):
    try:
        c = conexao.cursor()
        c.execute(sql)
        print("Tabela criada")
    except Error as ex:
        print(ex)


def inserir(conexao, sql):
    c = conexao.cursor()
    c.execute(sql)
    conexao.commit()
    print('registro inserido')


def add_banco(MATERIAS=None, DIA_SEMANA=None, HORARIO=None, variavel1=None, variavel2=None, variavel3=None):
    vsqlindo = f"INSERT INTO GERAL ({MATERIAS}, {DIA_SEMANA},{HORARIO})VALUES('" + variavel1 + "','" + variavel2 + "','" + variavel3 + "') "
    inserir(vcon, vsqlindo)


def consulta(conexao, sql):
    c = conexao.cursor()
    c.execute(sql)
    resultado = c.fetchall()
    return resultado


def atualizar(conexao, sql):
    try:
        c = conexao.cursor()
        c.execute(sql)
        conexao.commit()  # PRECISA DO COMMIT PRA FIXAR OS DADOS#
    except Error as ex:
        print(ex)
    finally:
        print('registro atualizado')


def update(BANCO, variavel, c):
    VSQL = f"UPDATE {BANCO} SET {BANCO} = {variavel} WHERE {BANCO} = {c} "
    atualizar(vcon, VSQL)


def nova_coluna(NEW_COLUN):
    coluna = f"ALTER TABLE GERAL ADD COLUMN {NEW_COLUN} INTEGER;"
    atualizar(vcon, coluna)

#
# criarTabela(vcon, vsql)
# vcon.close()
