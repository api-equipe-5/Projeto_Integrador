from currency_converter import CurrencyConverter
from config import sai_som

def Conversor_Moedas():

    c = CurrencyConverter()

    sai_som('''
        Para realizar a conversão, use os seguintes códigos:
    ''')
    print('''

        'EUR' - para Euros;
        'CAD' - para dólar Canadense;
        'USD' - para dólar americano;
        'BRL' - para real brasileiro;
        'GBP' - para libra;

    ''')

    sai_som('Qual é a moeda do seu valor? ')
    actually = str(input('')).upper()
    
    sai_som('Qual é o seu valor? ')
    valor = float(input(''))
    
    sai_som('Qual é a sua moeda final? ')
    final = str(input('')).upper()
    
    convert = c.convert(valor, actually, final)

    sai_som(f'{valor} {actually} são {convert:.2f} {final}. ')

