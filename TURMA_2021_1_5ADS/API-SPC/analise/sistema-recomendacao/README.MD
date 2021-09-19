# Sistema de Recomendação de Produtos de um 'Market Place'

- [No notebook Pré Processamento](pre_processamento.ipynb) Está detalhado o passo a passo desde a obtenção dos dados da Olist e o processamento dos dados brutos até o resultado final [dataset processado](olist_processado.csv).

- [Recomendação por Filtro Colaborativo](recomendacao-filtro_colaborativo.ipynb) - Sistema de recomendação item-item computando similaridade usando técnicas de vizinho mais próximo - KNN, utilizando notas de *Review's* dos clientes.

- [Recomendação Baseado no Conteúdo](recomendacao-baseado_conteudo.ipynb). A filtragem colaborativa falha em incorporar novos usuários que ainda não classificaram e novos itens que não possuem classificações ou comentários. Foi usado a Similaridade do Cosseno para construir o sistema de recomendação Baseada em Contéudo para contornar esse problema.

- [Recomendação Baseado no Conteúdo com Cluster](recomendacao-baseado_conteudo_cluster.ipynb). Foi usado as Similaridade do Cosseno, Euclidiana e de Manhattan e aplicado uma Segmentação utilizando o Kmeans para construir o sistema de recomendação Baseada em Contéudo para refinar o sitema de recomendação geral utilizado no notebook acima.

- [Como encontrar o valor ótimo de K em KNN](knn_k.ipynb) Visualize a taxa de erro vs. gráfico K para encontrar o valor K mais adequado[1].

[1] - [Tutorial](https://towardsdatascience.com/how-to-find-the-optimal-value-of-k-in-knn-35d936e554eb#:~:text=The%20optimal%20K%20value%20usually,be%20aware%20of%20the%20outliers.)


## Conclusão

- O Sistema de Recomendação Baseado no Conteúdo se mostrou mais eficaz e simples de ser construído.
- Para o Sistema de Recomendação por Filtro Colaborativo, é necessária fazer uma análise do número de 'k' previamente.
- Como refinamento do nosso Sistema de Recomendação Baseado no Conteúdo, foi utilizado anteriormente uma segmentação dos clientes utilizando o Kmeans e logo depois a matriz de similaridade usando a distância euclidiana, pois a mesma foi mais eficaz, apresentando uma maior granularidade e diversidade nas distâncias, utilizaremos ela no nosso produto final.


### Para mais esclarecimentos sobre as técnicas e ferramentas utilizadas, consultar o notebook das análises.


## Recomendações para o uso:

iniciar > CMD > enter

pip install -r requirements.txt

jupyter notebook

Veja os notebooks no diretório que acabou de baixar, tem a extensão ipynb


- Caso escolha Docker

iniciar > CMD > enter

```
make start

```
