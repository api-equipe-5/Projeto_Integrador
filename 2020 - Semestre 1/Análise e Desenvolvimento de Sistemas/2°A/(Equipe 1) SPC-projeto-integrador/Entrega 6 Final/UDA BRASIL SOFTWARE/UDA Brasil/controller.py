#from completude import completude_fontes_opr
#from consistencia import consistencia_id_operacao_mvt, consistencia_modalidade_opr
from data import indice_fontes
from operacao import indicadores_fatec_operacao
from movimento import indicadores_fatec_movimento
from pagamento import indicadores_fatec_pagamento

operacao = indicadores_fatec_operacao()
movimento = indicadores_fatec_movimento()
pagamento = indicadores_fatec_pagamento()

# consistencia_id_operacao_mvt = consistencia_id_operacao_mvt()
# consistencia_modalidade_opr = consistencia_modalidade_opr()
# completude_fontes_opr = completude_fontes_opr()
'''
GET_RANKING ANTIGO
def get_ranking():

    ranking = list()
    for fonte in range(len(indice_fontes)):
        completude = completude_fontes_opr[fonte][1]
        
        consistencia = (consistencia_id_operacao_mvt[fonte][1] + consistencia_modalidade_opr[fonte][1]) / 2

        confiabilidade = 100 #valor temporário

        pontuacao = (completude + confiabilidade + consistencia) / 3
        
        ranking.append([f'{pontuacao:.2f}', indice_fontes[fonte], f'{completude:.2f}', f'{confiabilidade:.2f}', f'{consistencia:.2f}']) #'fonte + 1' pois possui o mesmo valor que a posição da fonte

        ranking.sort(reverse = True)

    for posicao in range(len(ranking)):
        ranking[posicao].append(posicao + 1)
                    
    return ranking
'''

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
