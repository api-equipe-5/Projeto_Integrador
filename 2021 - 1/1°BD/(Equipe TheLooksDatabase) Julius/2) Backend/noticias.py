from config import sai_som
import requests
from bs4 import BeautifulSoup
#Site utilizado: https://www.infomoney.com.br/ (Podendo haver expansão)
response = requests.get('https://www.infomoney.com.br/')
conteudo = response.content
site = BeautifulSoup(conteudo, 'html.parser')

#Html da notícia
noticias = site.find('div', attrs={'class': 'col-12 col-lg-6'})
noticias2 = site.find('div', attrs={'class': 'col-12 col-lg-6 px-0 px-lg-3 mb-3 mb-lg-0'})

def informacoes():
    #Notícia 1:
    atributo1 = noticias.find('div', attrs={'class': 'row m-0 border-t-mobile py-3 py-lg-0 pb-lg-3'})
    titulo1 = atributo1.find('span', attrs={'class': 'hl-title hl-title-4'})
    resposta1 = titulo1.text
    sai_som(resposta1)
    print()

    #Notícia 2
    atributo2 = noticias.find('div', attrs={'class': 'row m-0 py-3 border-t'})
    titulo2 = atributo2.find('span', attrs={'class': 'hl-title hl-title-4'})
    resposta2 = titulo2.text
    sai_som(resposta2 )
    print()

    #Notícia 3
    atributo3 = noticias2.find('div', attrs={'class': 'row m-0 mx-3 mx-lg-0 mt-3 position-relative'})
    titulo3 = atributo3.find('span', attrs={'class': 'hl-title hl-title-8'})
    resposta3 = titulo3.text[15:]
    sai_som(resposta3 )
    print()
    #row m-0 mx-3 mx-lg-0 mt-3 mt-lg-2 position-relative

    #Notícia 4
    atributo4 = noticias2.find('div', attrs={'class': 'row m-0 mx-3 mx-lg-0 mt-3 mt-lg-2 position-relative'})
    titulo4 = atributo4.find('span', attrs={'class': 'hl-title hl-title-8'})
    resposta4 = titulo4.text[15:]
    sai_som(resposta4)
    print()

