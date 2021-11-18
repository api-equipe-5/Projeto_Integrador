from completude import completude_fontes_operacao
from consistencia import consistencia_modalidade_operacao

def get_ranking():
    completude = completude_fontes_operacao()
    consistencia = consistencia_modalidade_operacao()

    ranking = list()

    for fonte in range(len(completude)):
        media = (completude[fonte][1] + consistencia[fonte][1]) / 2 
        ranking.append([f"{media:.2f}", completude[fonte][0], f"{completude[fonte][1]:.2f}", f"{consistencia[fonte][1]:.2f}"])
        ranking.sort(reverse=True)
    
    for posicao in range(len(ranking)):
        ranking[posicao].append(posicao + 1)

    return ranking