# Identificação de talhão

Este projeto utiliza uma rede neural para o reconhecimento de talhões em imagens de satélite. 

As imagens baixadas do Sentinel-2 servem como base para o treinamento da rede. A partir de um arquivo shapefile, é possível extrair os valores dos pixels que se sobrepõem 
nas imagens de satélite. As entradas da rede consistem dos pixels extraídos das bandas 02 azul, 03 verde, 04 vermelho e 08 infravermelho, além do valor do NDVI que é um 
número entre -1 e 1 representando os diferentes estados de uma plantação (banda infravermelho - vermelho / banda infravermelho + vermelho).


## Google Colab
O projeto foi executado no Google Colab devido a capacidade de processamento disponibilizado pelo Google.

Para rodar no google **[Colab](https://colab.research.google.com/drive/1oLuDwMBRHBWYXFX21G68pyOSfyFyqOZb?usp=sharing)** é necessário fazer download dos arquivos **LEM_shapes.zip** (no repositório) e do **[dataset](https://drive.google.com/open?id=14daAWOO7z0XD3ljgl8dDxfAyZSMSs_nD)** já processado



## Shapefile 
![shapefile](imagens/shapefile.png "Shapefile")

## Banda 04 
![b04](imagens/b04.png "Shapefile")

## Imagem de treinamento
![label_treinamento](imagens/label_treinamento.png "Shapefile")

## Predição
![predicao](imagens/predicao.png "Shapefile")

