from random import choice
import speech_recognition as sr
import pyttsx3

version = '1.0'

def intro():
    msg = 'Assistente - version {} / by'.format(version)
    print('-' * len(msg) + '\n{}\n'.format(msg) + '-' * len(msg) )


lista_erros = [
        'Não entendi nada, repita',
        'Esse erro me custou R$0,97 centavos',
        'Sempre que você errar a fala\n EU VOU ESTAR LÁ\n'

]

conversas = {
    'Olá' : 'Oi, tudo bem?',
    'Tudo, e você?' : 'Estou bem, obrigado'

}

comandos = {
    'Desligar' : 'Desligando',
    'Reiniciar' : 'Reiniciando'

}
reproducao = pyttsx3.init()

def sai_som(mensagem, imprimir=True):
    if imprimir:
        print(mensagem)
    reproducao.say(mensagem)
    reproducao.runAndWait()

