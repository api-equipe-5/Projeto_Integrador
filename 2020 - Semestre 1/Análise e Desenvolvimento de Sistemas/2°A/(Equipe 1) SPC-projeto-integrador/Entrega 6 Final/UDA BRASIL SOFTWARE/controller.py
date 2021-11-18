#from completude import completude_fontes_opr
#from consistencia import consistencia_id_operacao_mvt, consistencia_modalidade_opr
from data import indice_fontes
from operacao import indicadores_fatec_operacao
from movimento import indicadores_fatec_movimento
from pagamento import indicadores_fatec_pagamento
import matplotlib.pyplot as plt

operacao = indicadores_fatec_operacao()
movimento = indicadores_fatec_movimento()
pagamento = indicadores_fatec_pagamento()


def grafico_operacao():
    # Gráfico de confiabilidade por fontes na tabela operacao
    plt.style.use("ggplot")
    valores = list(valor[3] for valor in operacao)
    fontes = list(str(fontes[0]) for fontes in operacao)

    plt.bar(fontes, valores, width=0.6)
    plt.xlabel('Fontes por ID')
    plt.ylabel('Confiabilidade em porcentagem')
    plt.savefig('app/static/img/confiabilidade_operacao.png')
    plt.cla()


    # Gráfico de consistencia por fontes na tabela operacao
    plt.style.use("ggplot")
    valores = list(valor[2] for valor in operacao)
    fontes = list(str(fontes[0]) for fontes in operacao)

    plt.bar(fontes, valores, width=0.6)
    plt.xlabel('Fontes por ID')
    plt.ylabel('Consistência dos dados em porcentagem')

    plt.savefig('app/static/img/consistencia_operacao.png')
    plt.cla()


    # Gráfico de completude por fontes na tabela operacao
    plt.style.use("ggplot")
    valores = list(valor[1] for valor in operacao)
    fontes = list(str(fontes[0]) for fontes in operacao)

    plt.bar(fontes, valores, width=0.6)
    plt.xlabel('Fontes por ID')
    plt.ylabel('Completude em porcentagem')
    plt.savefig('app/static/img/completude_operacao.png')
    plt.cla()
    return





def grafico_movimento():
    # Gráfico de confiabilidade por fontes na tabela movimento
    plt.style.use("ggplot")
    valores = list(valor[3] for valor in movimento)
    fontes = list(str(fontes[0]) for fontes in movimento)

    plt.bar(fontes, valores, width=0.6)
    plt.xlabel('Fontes por ID')
    plt.ylabel('Confiabilidade em porcentagem')

    plt.savefig('app/static/img/confiabilidade_movimento.png')
    plt.cla()


    # Gráfico de consistencia por fontes na tabela movimento
    plt.style.use("ggplot")
    valores = list(valor[2] for valor in movimento)
    fontes = list(str(fontes[0]) for fontes in movimento)
    plt.style.use("ggplot")

    plt.bar(fontes, valores, width=0.6)
    plt.xlabel('Fontes por ID')
    plt.ylabel('Consistência dos dados em porcentagem')

    plt.savefig('app/static/img/consistencia_movimento.png')
    plt.cla()


    # Gráfico de completude por fontes na tabela movimento
    plt.style.use("ggplot")
    valores = list(valor[1] for valor in movimento)
    fontes = list(str(fontes[0]) for fontes in movimento)

    plt.bar(fontes, valores, width=0.6)
    plt.xlabel('Fontes por ID')
    plt.ylabel('Completude em porcentagem')
    plt.savefig('app/static/img/completude_movimento.png')
    plt.cla()
    return



def grafico_pagamento():
    # Gráfico de confiabilidade por fontes na tabela pagamento
    plt.style.use("ggplot")
    valores = list(valor[3] for valor in pagamento)
    fontes = list(str(fontes[0]) for fontes in pagamento)

    plt.style.use("ggplot")
    plt.bar(fontes, valores, width=0.6)
    plt.xlabel('Fontes por ID')
    plt.ylabel('Confiabilidade dos dados em porcentagem')

    plt.savefig('app/static/img/confiabilidade_pagamento.png')
    plt.cla()


    # Gráfico de consistencia por fontes na tabela pagamento
    plt.style.use("ggplot")
    valores = list(valor[2] for valor in pagamento)
    fontes = list(str(fontes[0]) for fontes in pagamento)

    plt.bar(fontes, valores, width=0.6, color = '#6A5ACD')
    plt.xlabel('Fontes por ID')
    plt.ylabel('Confiabilidade em porcentagem')
    plt.savefig('app/static/img/consistencia_pagamento.png')
    plt.cla()


    # Gráfico de completude por fontes na tabela pagamento
    plt.style.use("ggplot")
    valores = list(valor[1] for valor in pagamento)
    fontes = list(str(fontes[0]) for fontes in pagamento)

    plt.bar(fontes, valores, width=0.6)

    plt.savefig('app/static/img/completude_pagamento.png')
    plt.cla()
    return


grafico_operacao()
grafico_movimento()
grafico_pagamento()

#DEFINIÇÂO DO RANKING

def get_ranking():
    ranking = list()
    
    for fonte in range(len(indice_fontes)):
        media_completude = (operacao[fonte][1] + pagamento[fonte][1] + movimento[fonte][1]) / 3
        media_consistencia = (operacao[fonte][2] + pagamento[fonte][2] + movimento[fonte][2]) / 3
        media_confiabilidade = (operacao[fonte][3] + pagamento[fonte][3] + movimento[fonte][3]) / 3

        pontuacao = (media_completude + media_consistencia + media_confiabilidade) / 3

        ranking.append([f'{pontuacao:.2f}', indice_fontes[fonte], f'{media_completude:.2f}', f'{media_consistencia:.2f}', f'{media_confiabilidade:.2f}'])        
    
        #Aqui é realizada a ordenação, de forma reversa para a maior pontuação vir primeiro
    
    ranking.sort(reverse=True)
    
    #Este for adiciona a colocação das fontes no ranking, na última posição de cada lista
    for posicao in range(len(ranking)):
        ranking[posicao].append(posicao + 1)
    print('Retornando ranking \n\n')
    return ranking
