import speech_recognition as sr
import pyttsx3
from random import choice
from config import *
from calculadora import *
from Conversor import *
from cotação import *
from noticias import *
from perfil import *
from comparativo_corretoras import *
from metas import *
from codigo import *

reproducao = pyttsx3.init()

def sai_som(mensagem, imprimir=True):
    if imprimir:
        print(mensagem)
    reproducao.say(mensagem)
    reproducao.runAndWait()

def menu(user_name): 
    sai_som(f'{user_name} bem-vindo ao Julius! Escolha uma das opções: ')
    print('''
    1 - Conversor;
    2 - Calculadora;
    3 - Cotação;
    4 - Notícias;
    5 - Perfil;
    6 - Código;
    7 - Comparativo;
    8 - Metas.
    ''')

        
def assistente():
    sai_som('Oi, qual é o seu nome?')
    user_name = ''
    
    while True:
            resposta_erro_aleatoria = choice(lista_erros)
            rec = sr.Recognizer()

            with sr.Microphone() as s: #Para usar o microfone
                rec.adjust_for_ambient_noise(s)

                while True: #Enquanto isso for verdadeiro, vai executar o bloco de ações abaixo
                    try:
                        audio = rec.listen(s)
                        user_name = rec.recognize_google(audio, language ='pt') 
                        break
                    except sr.UnknownValueError: #Se não conseguir, retorne isso (Necessário especificar o erro)
                        sai_som(resposta_erro_aleatoria)
                break
    
    
    rec = sr.Recognizer()
    
    with sr.Microphone() as s: #Para usar o microfone
        rec.adjust_for_ambient_noise(s)
        sair = False
        while not sair: #Enquanto isso for verdadeiro, vai executar o bloco de ações abaixo
            menu(user_name)
            try:
                resposta_erro_aleatoria = choice(lista_erros)
                audio = rec.listen(s)
                entrada = rec.recognize_google(audio, language ='pt')
                print('{}: {}'.format(user_name, entrada))

                #Conversor de moedas(Real, Dólar, Euro e Libra) (1)
                if 'conversor' in entrada:
                    entrada = entrada.replace('Conversor',' ')
                    resposta = Conversor_Moedas()
                    
                    sai_som('{}'.format(resposta))       
                    
                #Calculadora de Juros Compostos (2)
                if 'calculadora' in entrada:
                    entrada = entrada.replace('Calculadora', ' ')
                    resposta = calculadora()
                    
                    sai_som('{}'.format(resposta))
                    
                #Cotação do dia (3)
                if 'cotação' in entrada:
                    entrada = entrada.replace('cotação', ' ')
                    resposta = cotacao()
                    
                    sai_som('{}'.format(resposta))

                #Últimas notícias da investing (4)
                if 'notícias' in entrada:
                    entrada = entrada.replace('noticias', ' ')
                    resposta = informacoes()
                    
                    sai_som('{}'.format(resposta))

                #Traçar perfil do usuário (5)
                if 'perfil' in entrada:
                    entrada = entrada.replace('perfil', ' ')
                    resposta = perfil()
                    
                    sai_som('{}'.format(resposta))

                #Codigo
                if 'código' in entrada:
                    entrada = entrada.replace('codigo', ' ')
                    resposta = codigo()
                    
                    sai_som('{}'.format(resposta))

                #Comparativo entre duas corretoras (6)
                if 'comparativo' in entrada:
                    entrada = entrada.replace('comparativo', ' ')
                    resposta = comparativo()
                    
                    sai_som('{}'.format(resposta))
                
                #Metas
                if 'metas' in entrada:
                    entrada = entrada.replace('metas', ' ')
                    resposta = metas()
                    
                    sai_som('{}'.format(resposta))
                
                if 'sair' in entrada:
                    sair = True
                                                               
            
            except sr.UnknownValueError: #Se não conseguir, retorne isso (Necessário especificar o erro)
                sai_som(resposta_erro_aleatoria)
                    
               
if __name__ == '__main__':
    intro()
    sai_som('Iniciando')
    assistente()

               

            

                



    
   
