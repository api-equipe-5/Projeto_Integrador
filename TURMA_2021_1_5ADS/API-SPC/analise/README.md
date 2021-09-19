# Análise do Perfil do cliente

## Para a Análise Descritiva dos Dados

Realizamos alguns 'Insights' a partir das informações contidas nos dados brutos.
Além de outras perguntas, queremos sanar os seguintes questionamentos:

- Qual é a faixa etária dos clientes?
- Qual a faixa salarial de maior ocorrência?
- Qual a Faixa Salarial de cada Geração?
- Os clientes estão concentrados em quais municípios/regiões?
- Qual segmento teremos ao agrupar dados do Município, Faixa Salarial e Faixa Etária?

**Recorte de Geração**
Foi realizada uma revisão bibliográfica em alguns artigos, pode-se perceber que algumas empresas de marketings segmentam seus clientes de acordo com o Recorte de Gerações. Os anos na divisão de gerações diferem de um artigo para o outro. Para esse estudo foi utilizado as informações de 2017 da Revista Exame (https://bit.ly/2PxsdBy) e de 2018 do SINGEP (https://bit.ly/3flbqgh).

Esse recorte geracional foi realizado com auxílio da biblioteca pandas, utilizando o método '.cut()'.

**Quais regiões estão os clientes**
Foi utilizado os dados do IBGE e com o auxílio da biblioteca 'geopandas', foi realizada a intersecção da geometria dos dados brutos dos clientes com a geometria da Malha Municipal.


Foi realizado duas técnicas para segmentar os clientes.

- A primeira foi utilizando o método 'groupby' da biblioteca pandas, utilizando como argumentos o Estado e ou Município, a renda e a geração dos clientes.

- A segunda foi utilizando um Algoritmo Não Supervisionado o K-Means.

## Conclusão

1. O Dataset tem cerca de 1250 dados faltantes das colunas de longitude e latitude, foi decidido não remover essas linhas pois havia informações sobre a faixa salarial e data de nascimento e geração desse clientes. Porém, não é possível saber onde eles estão localizados.

2. Não há registro no Dataset da faixa salarial de 1.140,00 a 1.900,00 reais. 

3. A segmentação é muito importante em diferentes áreas da empresa, na:

    - Análise do Cliente -  é possível entender melhor os seus clientes;
    - Análise do Concorrente - É mais fácil reconhecer e enfrentar a concorrência concentrando-se em uma pequena parte do mercado;
    - Alocação efetiva de recurso - Os recursos escassos das empresas podem ser concentrados com maior efetividade em poucos clientes, ao invés de difundi-los ao longo das massas.
    - Planejamento estratégico de Marketing - Planejar se torna mais fácil quando a empresa tem uma clara imagem de seus melhores clientes.
    - Expansão do mercado - Uma boa segmentação pode aumentar o tamanho do mercado trazendo novos clientes, os quais se enquadram no perfil típico de cliente, mas não reconheciam o produto.


4. Tanto a segmentação da análise descritiva como a segmentação utilizando o K-Means foi eficaz para segmentar os clientes. 

5. Próximo passo é uma Pesquisa Bibliográfica para entender melhor as classes aqui segmentadas. Ex: Qual o perfil de consumo da Geração X? E da classe econômica C? O município que mais tem clientes é o Rio de Janeiro, então os municípes tem focado o consumo nos últimos anos?  Entre outros.

### Para mais esclarecimentos sobre as técnicas e ferramentas utilizadas, consultar o notebook da análise.

## Recomendações para o uso:

Os dados shapefile do Brasil do IBGE no site: https://bit.ly/39e59PB

É necessário descompactar a pasta zip BR_Municipios_2020, nesse diretório.

iniciar > CMD > enter

pip install -r requirements.txt

jupyter notebook

Veja os notebooks no diretório que acabou de baixar, tem a extensão ipynb


- Caso escolha Docker

iniciar > CMD > enter

```
make start

```




