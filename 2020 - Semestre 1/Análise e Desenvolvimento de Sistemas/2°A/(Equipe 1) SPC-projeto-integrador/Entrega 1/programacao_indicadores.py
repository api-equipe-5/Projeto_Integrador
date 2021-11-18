import pymysql

conexao = pymysql.connect(
    host='localhost',
    user='root',
    passwd='',
    database='spc_db'
)

cursor = conexao.cursor()
fonte = "select * from fonte"
modalidade = "select * from modalidade"
movimento = "select * from movimento"
operacao = "select * from operacao"
pagamento = "select * from pagamento"

lista_spc_db = [fonte, modalidade, movimento, operacao, pagamento]


# Funções:

# Função: Verifica a quantidade de digitos do CNPJ:
def digitos_cnpj(lista):
    CNPJ = []
    for z in lista:
            if len(z[1]) == 8:
                if len(z[2]) <= 6:
                    complemento = str(z[2])
                    while len(complemento) < 6:
                        complemento = '0' + complemento
                cnpj_pessoa = str(z[0]) + "|" + str(z[1]) + "-" + complemento
                CNPJ.append(cnpj_pessoa)
    return CNPJ



# Função: Contabilizando os duplicados (Função especifica para o CNPJ):
def duplicados_cnpj(lista):
    duplicado_id = []
    correto_id = []
    correto = []

    for z in lista:
        CNPJ = z[4:]
        if CNPJ not in correto: #adicionando CNPJS da lista a lista correto
            correto.append(CNPJ)
            correto_id.append(z)
        else: #caso depois da acição o valor repetir adicionar ao duplicados
            duplicado_id.append(z)
    return duplicado_id



# Função para verificar os duplicados:
def duplicados(lista):
    duplicado = []
    correto = []

    for z in lista:
        if z not in correto:
            correto.append(z)
        else:
            duplicado.append(z)
    return duplicado



# Função para verificar se o campo esta nulo:
def nulo(lista):
    nulo = []

    for z in lista:
        for y in z:

            # Programação para a tabela fonte, modalidade e pagamento:
            if x == fonte or x == modalidade or x == pagamento:
                if y == "":
                    nulo.append(str(z[0]))

            # Programação para a tabela movimento:
            if x == movimento:
                if y == "" and not y[9] == "E01" and not y[9] == "D01":
                    nulo.append(str(z[0]))

            # Programação para a tabela operação:
            if x == operacao:
                if y == "" and not y[7] == "C01":
                    nulo.append(str(z[0]))
    return nulo



# Função para conta os valores da tabela movimento e operação:
def contar_quantidade(lista):
    modalidade_dicionario = {
    'A01' : [0, 0],
    'A02' : [0, 0],
    'A04' : [0, 0],
    'A05' : [0, 0],
    'A99' : [0, 0],
    'B01' : [0, 0],
    'B02' : [0, 0],
    'B03' : [0, 0],
    'B04' : [0, 0],
    'B05' : [0, 0],
    'B06' : [0, 0],
    'B07' : [0, 0],
    'B99' : [0, 0],
    'C01' : [0, 0],
    'D01' : [0, 0],
    'E01' : [0, 0],
    'E02' : [0, 0],
    'F01' : [0, 0],
    'G01' : [0, 0],
    }
    if x == operacao:
        for y in lista:
            if modalidade_dicionario[y[7]]:
                modalidade_dicionario[y[7]][0] += int(y[4])
                modalidade_dicionario[y[7]][1] += int(y[5])
    return modalidade_dicionario


# Somando a quantidade de movimentações da tabela operação e pagamento:
def somar_quantidade(dicionario, lista):
    if x == pagamento:
        for y in lista:
            if dicionario[y[3]]:
                dicionario[y[3]][0] += int(y[4])
                dicionario[y[3]][1] += int(y[5])
    return dicionario



# Inicio da analise:
print("\nAnálise referente a base de dados da SPC Brasil: \n\n")

# Verificando as tabelas:
for x in lista_spc_db:
    cursor.execute(x)

    # Tabela Fonte:
    if x == fonte:

        # Declarando variaveis:
        linha_fonte = []
        cnpj_correto = []
        cnpj_duplicados_id = []
        complemento = ""
        fonte_nulo = []

        for y in cursor:
            linha_fonte.append(y)

            # Verificando se o cnpj possui 14 digitos
            cnpj_correto = digitos_cnpj(linha_fonte)

            # Verificando se o cnpj é duplicado:
            cnpj_duplicados_id = duplicados_cnpj(cnpj_correto)

            # Verificando se a tabela possui um campo nulo:
            fonte_nulo = nulo(linha_fonte)

        print(f'''Tabela Fonte:

Número de cnpj corretos: {len(cnpj_correto)}
Total de cnpj's fora do padrão: {len(linha_fonte) - len(cnpj_correto)}
Total de cnpj's duplicados: {len(cnpj_duplicados_id)}
Total de campos nulos: {len(fonte_nulo)}
Total de cnpj's: {len(linha_fonte)} \n\n''')





    # Tabela Modalidade:
    if x == modalidade:

        # Declarando variaveis:
        linha_modalidade = []
        modalidade_nulo = []
        modalidade_duplicado = []

        for y in cursor:
            linha_modalidade.append(y)

        # Verificando se a tabela possui algum campo nulo:
        modalidade_nulo = nulo(linha_modalidade)

        # Verificando se a tabela possui valores duplicados:
        modalidade_duplicado = duplicados(linha_modalidade)

        print(f'''Tabela Modalidade:

Total de campos nulos: {len(modalidade_nulo)}
Total de valores duplicados: {len(modalidade_duplicado)}
Total de linhas verificadas: {len(linha_modalidade)} \n\n''')





    # Tabela Movimento:
    if x == movimento:

        # Declarando as Variaveis:
        linha_movimento = []
        movimento_nulo = []
        movimento_duplicado = []

        for y in cursor:
            linha_movimento.append(y)

        # Verificando se a tabela possui algum campo nulo:
        movimento_nulo = nulo(linha_movimento)

        # Verificando se a tabela possui valores duplicados:
        movimento_duplicado = duplicados(linha_movimento)

        print(f'''Tabela Movimento:

Total de Campos nulos: {len(movimento_nulo)}
Total de valores duplicados: {len(movimento_duplicado)}
Total de linhas verificadas: {len(linha_movimento)} \n\n''')





    # Tabela Operacao:
    if x == operacao:

        # Declarando as variaveis:
        operacao_nulo = []
        operacao_duplicado = []
        operacao_quantidade = {}
        linha_operacao = []

        for y in cursor:
            linha_operacao.append(y)

        # Verificando se a tabela possui algum campo nulo:
        operacao_nulo = nulo(linha_operacao)

        # Verificando se a tabela possui valores duplicados:
        operacao_duplicado = duplicados(linha_operacao)

        # Verificando a quantidade de movimentações:
        operacao_quantidade = contar_quantidade(linha_operacao)

        print(f'''Tabela Operação:

Total de Campos nulos: {len(operacao_nulo)}
Total de valores duplicados: {len(operacao_duplicado)}
Total de linhas verificadas: {len(linha_operacao)} \n\n''')





    # Tabela Pagamento:
    if x == pagamento:

        # Declarando as Variaveis:
        pagamento_nulo = []
        pagamento_duplicado = []
        pagamento_quantidade = {}
        linha_pagamento = []

        for y in cursor:
            linha_pagamento.append(y)

        # Verificando se a tabela possui algum campo nulo:
        pagamento_nulo = nulo(linha_pagamento)

        # Verificando se a tabela possui algum campo duplicado:
        pagamento_duplicado = duplicados(linha_pagamento)

        # Verificando a quantidade movimentações:
        pagamento_quantidade = somar_quantidade(operacao_quantidade, linha_pagamento)

        print(f'''Tabela Pagamento:

Total de Campos nulos: {len(pagamento_nulo)}
Total de valores duplicados: {len(pagamento_duplicado)}
Total de linhas verificadas: {len(linha_pagamento)} \n\n''')



        for y in pagamento_quantidade:
            print(f"{y}  {pagamento_quantidade[y]}")
