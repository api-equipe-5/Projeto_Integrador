## Entrega 3 (16/05)

- Previsão de inicio: 26/04 
- Termino: 16/05

Nesta sprint foi implementado machine learning com base nos dados OList de 2016 à 2018. Foi criado um sistema de recomendação de produtos automatizado.

## Sistema de recomendação de produtos

Foi feito dois sistemas de recomendação, um por filtro colaborativo e o outro baseado no conteúdo.

- [Recomendação por Filtro Colaborativo](https://github.com/EricaSantos2109/API-SPC/blob/main/analise/sistema-recomendacao/recomendacao-filtro_colaborativo.ipynb) - Sistema de recomendação item-item computando similaridade usando técnicas de vizinho mais próximo - KNN, utilizando notas de *Review's* dos clientes.

- [Recomendação Baseado no Conteúdo](https://github.com/EricaSantos2109/API-SPC/blob/main/analise/sistema-recomendacao/recomendacao-baseado_conteudo.ipynb). A filtragem colaborativa falha em incorporar novos usuários que ainda não classificaram e novos itens que não possuem classificações ou comentários. Foi usado a Similaridade do Cosseno para construir o sistema de recomendação Baseada em Contéudo para contornar esse problema.

Conclusão:

- O Sistema de Recomendação Baseado no Conteúdo se mostrou mais eficaz e simples de ser construído.
- Para o Sistema de Recomendação por Filtro Colaborativo, é necessária fazer uma análise do número de 'k' previamente.
- Para a Sprint 4 será utilizado também o algoritmo K-Means para clusterizar os dados e fazer um sistema de recomendação mais refinado.

### Para acessar o que foi desenvolvido acesse a URL ao lado: [[Clique aqui para visualizar]](https://github.com/EricaSantos2109/API-SPC/tree/main/analise/sistema-recomendacao)

## Nesta Sprint foi realizada

Algumas perguntas para se ter um insight do dataset. 
- Quais são as categorias mais populares? 

![Categorias](https://github.com/EricaSantos2109/API-SPC/blob/main/relatorios-sprint/imagens/categorias.png)

O gráfico acima mostra que as categorias, Banho, Mesa, Cama, Móveis e Acessórios são os produtos mais populares. Os menos populares são Seguros e Serviços.


- Qual o mês que um produto específico é comprado?

Como vimos na separação de categorias, percebemos que a Categoria "Cama, Mesa e Banho" é a mais popular e o produto mais comprado dessa categoria foi "99a4788cb24856965c36a24e339b6058".

![Produto mês](https://github.com/EricaSantos2109/API-SPC/blob/main/relatorios-sprint/imagens/produto_mes.png)

O produto específico foi mais comprado nos períodos de Outono/Inverno.


- Qual a faixa de valor da maioria dos produtos?

![Produto valor](https://github.com/EricaSantos2109/API-SPC/blob/main/relatorios-sprint/imagens/produtos_valor.png)

Podemos ver no gráfico acima que a maioria dos produtos estão entre os valores de 0 a 100 reais (Cerca de 70 mil compras estão nesse valor)


Para tornar nosso recomendador mais amigável, podemos usar um pacote Python chamado fuzzywuzzy que encontrará o produto mais semelhante a uma string que você passar.
Criamos uma função chamada busca_produto() que aproveita o algoritmo de correspondência de string de fuzzywuzzy para obter o título mais semelhante a uma string inserida pelo usuário.

![Sistema Busca](https://github.com/EricaSantos2109/API-SPC/blob/main/relatorios-sprint/imagens/sistema_busca.png)


Por fim, podemos testar nosso recomendador ainda mais com outros produtos, utilizando a função que inclui o produto de interesse e o número de recomendações.

![Sistema recomendação based](https://github.com/EricaSantos2109/API-SPC/blob/main/relatorios-sprint/imagens/sistema_recomendacao_content_based.png)

## Documentos criados e atualizados conforme a evolução do projeto:

[[Link para os documentos]](https://github.com/EricaSantos2109/API-SPC/tree/main/documentos/sprint-3)

- BSC
- Design Thinking
- Itil
- Checklist
- Escopo
- Gerenciamento de custo (Planejado x Realizado)
- Gerenciamento de Cronograma (Planejado x Realizado)

## Relatórios gerados para a sprint 3:

[[Link para os relatórios]](https://github.com/EricaSantos2109/API-SPC/tree/main/documentos/sprint-3)

- Plano de gerenciamento de Riscos
- Registro dos riscos
- Matriz das Comunicações - Matriz RACI


## Documentações
- Itil v3
- Plano de gerenciamento de Riscos
- Atualização do Design Thinking
- Atualização do gerenciamento de custo (Planejado x Realizado)
- Atualização do gerenciamento de Cronograma (Planejado x Realizado)
- Gerenciamento de Comunicações - Matriz RACI
- Registro dos Riscos
- Atualização do modelo de gestão estratégica - BSC
- Atualização do Escopo

## Ferramentas Utilizadas
- Linguagem de programação Python
- Jupyter Notebook
- Bibliotecas: 
	- Scikit learning
	- Scipy
	- Pandas
	- Numpy
	- Matplotlib
	- Seaborn
    - Fuzzywuzzy

![Sprint 3](https://github.com/EricaSantos2109/API-SPC/blob/main/relatorios-sprint/imagens/sprint-tres.png)

