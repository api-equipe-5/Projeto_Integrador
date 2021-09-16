from config import sai_som 
import requests
import json

requisição = requests.get('https://economia.awesomeapi.com.br/all')

cotação = requisição.json()
def cotacao():
    sai_som('''
        Bem-vindo(a) a cotação do dia!
        Atualmente temos o valor atual das seguintes moedas:
        Dólar - Euro - Libra e Bitcoin!
    ''')
    sai_som('Qual a moeda que deseja cotação?: ')
    Valor_moeda = str(input('')).strip().upper()

    if Valor_moeda == 'DOLAR':
        
        #####################################################
        sai_som('Cotação do Dolar')
        
        sai_som('Moeda: ' + cotação ['USD'] ['name'])

        sai_som('Data: ' + cotação ['USD'] ['create_date'])

        sai_som('Valor Atual R$: ' + cotação ['USD']['bid'])

        
    if Valor_moeda == 'EURO':       
        sai_som('Cotação do Euro')

        sai_som('Moeda: ' + cotação ['EUR'] ['name'])

        sai_som('Data: ' + cotação ['EUR'] ['create_date'])
        
        sai_som('Valor Atual R$: ' + cotação ['EUR'] ['bid'])
        
    if Valor_moeda == 'LIBRA':
        sai_som('Cotação do Libra')

        sai_som('Moeda: ' + cotação ['GBP'] ['name'])

        sai_som('Data: ' + cotação ['GBP'] ['create_date'])
        
        sai_som('Valor Atual R$: ' + cotação['GBP'] ['bid'])

        
    if Valor_moeda == 'BITCOIN':       
        sai_som('Cotação do Bitcoin')
        
        sai_som('Moeda: ' + cotação ['BTC'] ['name'])

        sai_som('Data: ' + cotação ['BTC'] ['create_date'])

        sai_som('Valor Atual R$: ' + cotação ['BTC'] ['bid'])

        
    else:
        sai_som('Moeda não cadastrada!')
