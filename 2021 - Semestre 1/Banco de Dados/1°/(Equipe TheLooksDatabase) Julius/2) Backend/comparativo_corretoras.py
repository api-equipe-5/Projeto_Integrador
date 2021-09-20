from config import sai_som
import sqlite3
con = sqlite3.connect('corretoras.db')
cur = con.cursor()

def comparativo():
    sai_som('''
        
        Bem-vindo ao comparativo de corretoras!
        
    ''')
    print('''
        Compare duas corretoras em um quesito desejado.
        Atualmente, temos as seguintes corretoras:
        - XP;
        - Itau;
        - Ativa;
        - Rico;
        - Bradesco;
        - Icap;
        - Easynet;
        - Mirae;
        - Banco do brasil;
        - Santander.
        
    ''')

    sai_som('Diga, qual vai ser a primeira corretora: ')
    corretora = input('')


    sai_som('Qual a segunda corretora que deseja fazer uma comparação: ')
    corretora2 = input('')


    sai_som('''
        Atualmente, temos os seguintes critérios de comparação:

    ''')
    print('''
        - Segurança;
        - Experiencia investidor;
        - Avaliação final;
        - Custos mensais 3;
        - Custos mensais 5;
        - Custos mensais 10.
    ''')
    sai_som('Qual o critério de comparação:  ')
    comparativo = input('')


    dict_corretora = {
    'xp': 3,
    'itau': 114,
    'ativa': 147,
    'rico': 386,
    'bradesco': 72,
    'icap': 735,
    'easynet': 90,
    'mirae': 262,
    'banco do brasil': 820,
    'santander': 27
    }

    dict_fator_comparativo = {
        'segurança': 'segurança',
        'experiencia investidor': 'experiencia_investidor',
        'avaliação final': 'avaliação_final',
        'custos mensais 3': 'custos_mensais_3op',
        'custos mensais 5': 'custos_mensais_5op',
        'custos mensais 10': 'custos_mensais_10op'
    }

    custos_mensais= []

    query_parameters = (dict_corretora[corretora.lower()], dict_corretora[corretora2.lower()])

    for row in cur.execute(f'SELECT {dict_fator_comparativo[comparativo.lower()]} FROM corretoras WHERE cod_corretora == ? or cod_corretora == ?', query_parameters):
        custos_mensais.append(row[0])

    sai_som(f'Os dados da corretora {corretora} são de: {custos_mensais[0]} e da corretora {corretora2} são de: {custos_mensais[1]} ')

    con.commit()
    con.close()
