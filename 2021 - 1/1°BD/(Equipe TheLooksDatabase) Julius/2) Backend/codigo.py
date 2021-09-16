#Pergunta para o cliente
from config import sai_som
def codigo():
    sai_som('De qual empresa deseja saber o código de ação? ')
    cod_acao = str(input('')).upper()

    #Imprimi o valor e printa o código de ação
    if cod_acao == ('NETFLIX'):
        sai_som('O código de ação dessa empresa é: NFLX34')

    elif cod_acao == ('ITAU'):
        sai_som('O código de ação dessa empresa é: ITUB3F')

    elif cod_acao == ('VALE'):
        sai_som('O código de ação dessa empresa é: VALE5')

    elif cod_acao == ('PETROBRAS'):
        sai_som('O código de ação dessa empresa é: PETR4F')

    elif cod_acao == ('FACEBOOK'):
        sai_som('O código de ação dessa empresa é: FB')
