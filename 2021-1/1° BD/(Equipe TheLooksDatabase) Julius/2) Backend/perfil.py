from config import sai_som

def perfil():
    result = 0
    sai_som('Você já fez sua reserva de emergência? ')
    p1 = str(input('')).upper()

    sai_som('Aceitaria riscos para maximizar ganhos? ')
    p2 = str(input('')).upper()

    sai_som('Tem a meta de guardar dinheiro para um futuro a longo prazo, como aposentadoria? ')
    p3 = str(input('')).upper()

    sai_som('Você tem experiência ou formação no mercado financeiro? ')
    p4 = str(input('')).upper()

    sai_som('Você já investe ou investiu nos últimos meses? ')
    p5 = str(input('')).upper()

    sai_som('Você conseguiria destinar de 10% a 15% do seu salario a investimentos? ')
    p6 = str(input('')).upper()


    if p1 == 'SIM':
        result +=2
    else:
        result +=1
    if p2 == 'SIM':
        result +=2
    else:
        result +=1
    if p3 == 'SIM':
        result +=2
    else:
        result +=1
    if p4 == 'SIM':
        result +=2
    else:
        result +=1
    if p5 == 'SIM':
        result +=2
    else:
        result +=1
    if p6 == 'SIM':
        result +=2
    else:
        result +=1


    if result <8:
        sai_som(f'Você é um investidor Iniciante pois sua pontuação foi de {result} pontos!')
    if result >= 8 and result <10:
        sai_som(f'Você é um investidor Pleno pois sua pontuação foi de {result} pontos!')
    if result >= 10:
        sai_som(f'Você é um investidor Experiente pois sua pontuação foi de {result} pontos!')


   


   


   

  
