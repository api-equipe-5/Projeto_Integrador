import speech_recognition as sr
import playsound
from gtts import gTTS
import random
import time
import os
import pyttsx3
import config
from tkinter import *
from pydub import AudioSegment
from pydub import effects
from pyttsx3.drivers import sapi5

error = random.choice(config.lista_erros)


class person:
    name = ''

    def setName(self, name):
        self.name = name


class asis:
    name = ''

    def setName(self, name):
        self.name = name


def there_exists(terms):
    for term in terms:
        if term in voice_data:
            return True


def speak(text):
    voices = engine.getProperty("voices")
    engine.setProperty("voice", voices[0].id)
    engine.setProperty('rate', 255)
    engine.say(text)
    engine.runAndWait()
    print(asis_obj.name + ":", text)


engine = pyttsx3.init()
r = sr.Recognizer()  # initialise a recogniser


# listen for audio and convert it to text:
def record_audio(ask=""):
    try:
        with sr.Microphone() as source:
            if ask:
                speak(ask)
            audio = r.listen(source, 5, 5)
            r.adjust_for_ambient_noise(source, duration=1)
            voice_data = ''
            try:
                voice_data = r.recognize_google(audio, language='pt-BR')
            except sr.UnknownValueError:
                time.sleep(10)
                print('Deu erro aquiiiiiii')
                speak(error)
                exit()
            except sr.RequestError:
                speak('Desculpe, serviço indisponível no momento')
            except sr.WaitTimeoutError:
                print('Serviço indisponível no momento, tente novamente !')
                exit()
            print(">>", voice_data.lower())
            return voice_data.lower()
    except TypeError:
        speak('tem alguém aí ?')
        time.sleep(6)
        exit()
    except sr.WaitTimeoutError:
        speak('tem alguém aí ?')
        time.sleep(5)
        exit()


def speed_change(sound, speed=1.0):
    sound_with_altered_frame_rate = sound._spawn(sound.raw_data, overrides={
        "frame_rate": int(sound.frame_rate * speed)
    })
    return sound_with_altered_frame_rate.set_frame_rate(sound.frame_rate)


def speak(audio_string):
    audio_string = str(audio_string)
    tts = gTTS(text=audio_string, lang='pt', slow=False)
    r = random.randint(1, 20000000)
    audio_file = 'audio' + str(r) + '.mp3'
    tts.save(audio_file)
    sound = AudioSegment.from_file(audio_file)
    fast_sound = speed_change(sound, 1.6)
    fast_sound.export(audio_file[:-4] + 'new.mp3', format='mp3')
    playsound.playsound('audio' + str(r) + 'new.mp3')
    os.remove(audio_file)
    os.remove('audio' + str(r) + 'new.mp3')
    print(asis_obj.name + ":", audio_string)


def respond(voice_data):
    if there_exists(['oi', 'olá', 'prazer']):
        greetings = [f"olá, como posso te ajudar {person_obj.name}",
                     f"olá, tudo bem ? {person_obj.name}", f"estou ouvindo {person_obj.name}",
                     f"como eu posso te ajudar {person_obj.name} ?", f"olá {person_obj.name}"]
        greet = greetings[random.randint(0, len(greetings) - 1)]
        speak(greet)

    if there_exists(["meu nome é", "eu me chamo", "sou a", "sou o", "me chamo"]):
        person_name = voice_data.split(" ")[-1].strip()
        speak(f"Como eu posso te ajudar, {person_name}")
        person_obj.setName(person_name)

    if there_exists(["qual é o seu nome", "qual é teu nome", "me diga seu nome", "qual é seu nome", "seu nome",
                     "teu nome"]):
        if person_obj.name:
            speak(f"meu nome é {asis_obj.name}, muito prazer {person_obj.name}")
        else:
            speak("meu nome é Athena. E como você se chama?")

    if there_exists(["como você está", "tudo bem com você", "tudo bem"]):
        speak(f"Estou muito bem, obrigado por perguntar,  {person_obj.name}")

    if there_exists(["calcule a média", "media", "média"]):
        speak("Por favor, digite os valores no arquivo que irá abrir, para calcular sua média")
        janela = Tk()

        def bt_click():

            if str(ed1.get()).isnumeric() and str(ed2.get()).isnumeric():
                num1 = int(ed1.get())
                num2 = int(ed2.get())

                lb['text'] = (num1 + num2) / 2
            else:
                lb['text'] = 'Valores informados são inválidos'
                speak(lb['text'])

        ed1 = Entry(janela)
        ed1.place(x=115, y=100)
        ed2 = Entry(janela)
        ed2.place(x=115, y=130)

        bt = Button(janela, text='Calcular Média', width=20, command=bt_click, bg='gold2')
        bt.place(x=100, y=170)

        lb = Label(janela, text='Olá, sou Athena sua assistente!', bg='azure')
        lb.place(x=90, y=50)
        lb = Label(janela, text='Infome as notas para média', bg='azure')
        lb.place(x=100, y=70)

        janela['bg'] = 'azure'
        janela.geometry('400x300+200+200')
        janela.mainloop()

    if there_exists(["que horas são", "horário", "qual hora", "que horas"]):
        speak(config.SystemInfo.get_time())

    if there_exists(["que dia é hoje", "data de hoje", "qual dia é hoje"]):
        speak(config.SystemInfo.get_date())

    if there_exists(["athena agendar data", "agende uma data", "marque uma prova", "marque um trabalho"
                        , "agende uma prova", "agende um trabalho", "marcar trabalho"]):
        mes = ["janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto",
               "setembro", "outubro", "novembro", "dezembro"]

        with open("date_save.csv", "a+", encoding='utf-8') as arquivo:
            speak("Qual o Título do evento ?")
            x = record_audio()
            while True:
                try:
                    speak(f"ok, quando é o evento ?")
                    date_event = record_audio().strip().split()
                    if date_event[2] not in mes:
                        if date_event[2].isnumeric() not in range(1, 13):
                            speak('Não encontrei esse mês, vamos tentar novamente !')
                            time.sleep(2)
                            continue
                    break
                except ValueError:
                    speak(f"Não entendi muito bem ,poderia repetir por gentileza")
                    time.sleep(2)
                    continue
                except IndexError:
                    speak(f"Não entendi muito bem ")
                    time.sleep(2)
                    continue
            if date_event[2].isnumeric():
                speak(f"Voce agendou um '{x}' para o dia {date_event[0]} do {date_event[2]} ")
                arquivo.write(f"Título: '{x}' para o dia {date_event[0]}/{date_event[2]} \n")
            if date_event[2].isalpha():
                speak(f"Voce agendou um '{x}' para o dia {date_event[0]} de {date_event[2]} ")
                arquivo.write(f"Título: '{x}' para o dia {date_event[0]} de {date_event[2]} \n")
    if there_exists(["cadastrar matéria", "nova matéria", "nova materia", "cadastrar aula"]):
        try:
            semana = ["segunda", "terça", "quarta", "quinta", "sexta", "sabado", "sábado",
                      "segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira"]
            materias = []
            dias_semana = []
            horario_materia = []

            try:
                while True:
                    speak("Para qual dia da semana ?")
                    semana_dia = record_audio().strip()
                    if semana_dia not in semana:
                        speak('Não encontrei esse dia no meu banco de dados, repita por gentileza em alguns instantes')
                        time.sleep(2)
                        continue
                    if semana_dia != "sabado" and semana_dia != "segunda-feira" and semana_dia != "terça-feira" and semana_dia != "quarta-feira" and semana_dia != "quinta-feira" and semana_dia != "sexta-feira":
                        x = semana_dia + "-feira"
                        dias_semana.append(x)
                    else:
                        dias_semana.append(semana_dia)
                    speak('Gostaria de cadastrar um novo dia da semana ? ')
                    resp = record_audio().strip().upper()[0]
                    if resp == "S":
                        continue
                    if resp == "N":
                        break
            except ValueError:
                speak('Deu erro aqui, fala de novo por favor')
            for posi, c in enumerate(dias_semana):
                while True:
                    try:
                        speak(
                            f'Qual matéria gostaria de cadastrar para "{dias_semana[posi]}" ? ')
                        materia = record_audio().strip().lower()
                        materias.append(materia)
                        speak(f'Gostaria de cadastrar uma nova matéria para "{dias_semana[posi]}" ? ')
                        resp = record_audio().upper().strip()[0]
                        if resp == "S":
                            continue
                        if resp == "N":
                            for pos, c in enumerate(materias):
                                speak(f'Quando começa a aula da matéria: "{materias[pos]}"  ? ')
                                horario_inicial = record_audio().strip().replace(" ", ":").replace(" e ", ":")
                                speak(f'Quando termina a aula da matéria: "{materias[pos]}"  ? ')
                                horario_final = record_audio().strip().replace(" ", ":").replace(" e ", ":")
                                horario_materia.append(f"{horario_inicial}-{horario_final}")
                                try:
                                    with open("aulas.txt", "a+", encoding='utf-8') as arquivo:
                                        arquivo.write(f'Dia: {dias_semana[posi]} '
                                                      f'Aulas: {materias[pos]} = horario: {horario_materia[pos]} \n')
                                except Exception as error:
                                    print('>> Arquivo não encontrado, tente novamente !')
                                    print(error)
                            materias.clear()
                            speak('Dados salvos')
                            exit()
                    except Exception as error:
                        print('>> Encontramos algum erro, por gentileza tente novamente')
                        print(error)
                    break

        except Exception as errorr:
            print(errorr)


if __name__ == '__main__':
    time.sleep(1)

    config.intro()
    # config.email()
    asis_obj = asis()
    asis_obj.name = 'Athena'
    person_obj = person()
    speak("Olá, quem está falando comigo ?")

    person_obj.name = ""
    engine = pyttsx3.init()
    while 1:
        voice_data = record_audio()  # get the voice input
        respond(voice_data)  # respond
