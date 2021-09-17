import sys

from dicionarioXlsx import return_tuple
from dicionarioCsv import tuple_csv

def contRepetidos(var):
    cont = 0
    unico = 0
    for i in var:
        if var.count(i) != 1:
            cont += 1
        else:
            unico += 1
    contVazios = var.count("empty:''")
    contDuplicados = cont - contVazios

    return [ unico, contDuplicados, contVazios ]


def chamarRelatorio(file,funcDict):
    texto = ''
    texto += f'Tabela"{file}",'
    for i in funcDict[1]:
        texto += f'{i},'
        valores = contRepetidos(funcDict[0][i])
        texto += f'({valores[0]}) Campos com valores unicos,({valores[1]}) Duplicados,({valores[2]}) Campos vazios,'

    print(texto)

def main():

    try:
        chamarRelatorio(sys.argv[1], return_tuple(sys.argv[1]))
    except:
        chamarRelatorio(sys.argv[1], tuple_csv(sys.argv[1]))


if __name__ == "__main__":
    main()
