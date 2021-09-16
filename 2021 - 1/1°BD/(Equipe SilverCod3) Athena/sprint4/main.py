from operator import or_

import speech_recognition as sr
import playsound
from gtts import gTTS
import random
import time
import os
import pyttsx3
import config
from pydub import AudioSegment
from pydub import effects
from pyttsx3.drivers import sapi5
from BD import *
from tkinter import *
import smtplib
from email.mime.text import MIMEText
import credenciais

error = random.choice(config.lista_erros)

vcon = conexaobanco()


class person:
    name = ''

    def setName(self, name):
        self.name = name


class asis:
    name = ''

    def setName(self, name):
        self.name = name


def there_exists(terms):
    try:
        for term in terms:
            if term in voice_data:
                return True
    except TypeError:
        record_audio()


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
                time.sleep(4)
                speak('Não consegui entender, repita novamente')
                return record_audio()
            except sr.RequestError:
                speak('Desculpe, serviço indisponível no momento')
            except sr.WaitTimeoutError:
                print('Serviço indisponível no momento, tente novamente !')
                exit()
            print(">>", voice_data.lower())
            return voice_data.lower()
    except TypeError:
        time.sleep(1)
        speak(error)
        time.sleep(3)
    except sr.WaitTimeoutError:
        time.sleep(1)
        speak('Olá, você está aí ?')
        return record_audio()


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
    fast_sound = speed_change(sound, 1.4)
    fast_sound.export(audio_file[:-4] + 'new.mp3', format='mp3')
    playsound.playsound('audio' + str(r) + 'new.mp3')
    print(asis_obj.name + ":", audio_string)

    os.remove(audio_file)
    os.remove('audio' + str(r) + 'new.mp3')


def respond(voice_data):
    if there_exists(
            ['quais são suas funções', 'o que você faz', 'quais suas funções', 'o que voce faz ?', 'qual sua função',
             'qual é sua função']):
        speak(
            'Eu estou aqui para te auxiliar em seus estudos ! Você pode dizer: "Agende uma data" para agendar um evento')
        time.sleep(3)
        speak('Cadastre sua grade de estudos dizendo: "Cadastrar matéria"')
        time.sleep(3)
        speak('Caso queira saber de mais alguma funcionalidade basta dizer "Help" que eu venho te ajudar !')

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
                     "teu nome", "como voce se chama", "como você se chama"]):
        if person_obj.name:
            speak(f"meu nome é {asis_obj.name}, muito prazer {person_obj.name}")
        else:
            speak("meu nome é Athena. E como você se chama?")

    if there_exists(["como você está", "tudo bem com você", "tudo bem"]):
        speak(f"Estou muito bem, obrigado por perguntar,  {person_obj.name}")

    if there_exists(["calcule a média", "mostrar média", "visualizar média"]):
        speak("Para qual matéria gostaria de calcular sua média ")
        vsqlin = " SELECT * FROM GERAL"
        res = consulta(vcon, vsqlin)
        materias_media = []
        for result in res:
            materias_media.append(result[1])
        voice = record_audio().strip().lower()
        index_media = materias_media.index(voice)
        if voice in materias_media:
            if res[index_media][4] != -1 or res[index_media][5] != -1 or res[index_media][6] != \
                    -1 or res[index_media][7] != -1:
                media = (res[index_media][4] + res[index_media][5] + res[index_media][6] + res[index_media][7]) / 4
                speak(f'a média para a matéria "{voice}" é: {media}')
            else:
                speak('Não foi possível calcular sua média, tente cadastrar todas suas notas e tente novamente!')
        else:
            speak('Não encontrei essa matéria no meu banco de dados, para criar uma nova matéria basta dizer '
                  '"Cadastrar Matéria" ')
            return record_audio()

    if there_exists(["cadastrar notas", "cadastrar nota", "adicionar notas", "adicionar nota"]):
        speak('para qual matéria gostaria de cadastrar suas notas? ')
        vsqlin = " SELECT * FROM GERAL"
        res = consulta(vcon, vsqlin)
        materias_notas = []
        for result in res:
            materias_notas.append(result[1])
        voice = record_audio().strip().lower()
        index_notas = materias_notas.index(voice)
        if voice in materias_notas:
            if res[index_notas][4] != -1 or res[index_notas][5] != -1 or res[index_notas][6] != \
                    -1 or res[index_notas][7] != -1:
                speak('Deseja substituir sua nota atual?')
                resps = record_audio().strip().lower()[0]
                if resps == "n":
                    speak(f'qual nota deseja atribuir para a matéria: "{voice}"?')
                    notas_int = record_audio().strip()
                    if res[index_notas][5] == -1:
                        update("NOTAS_2", int(notas_int), res[index_notas][5])
                        speak('registro concluído')
                    elif res[index_notas][6] == -1:
                        update("NOTAS_3", int(notas_int), res[index_notas][6])
                        speak('registro concluído')
                    elif res[index_notas][7] == -1:
                        update("NOTAS_4", int(notas_int), res[index_notas][7])
                        speak('registro concluído')
                    else:
                        speak('alcançou o limite máximo de registros, tente substituir sua nota atual')
                        time.sleep(2)
                if resps == "s":
                    speak('deseja alterar a nota do: 1º, 2º, 3º ou 4º índice ?')
                    indice_int = record_audio().strip().split()[0]
                    if indice_int == "primeiro":
                        speak(f'qual nota deseja atribuir para a matéria: "{voice}" no 1º índice ')
                        int_notas = record_audio().strip()
                        update("NOTAS", int(int_notas), res[index_notas][4])
                        speak('registro concluído')
                    if indice_int == "segundo":
                        speak(f'qual nota deseja atribuir para a matéria: "{voice}" no 2º índice ')
                        int_notas = record_audio().strip()
                        update("NOTAS_2", int(int_notas), res[index_notas][5])
                        speak('registro concluído')
                    if indice_int == "terceiro":
                        speak(f'qual nota deseja atribuir para a matéria: "{voice}" no 3º índice ')
                        int_notas = record_audio().strip()
                        update("NOTAS_3", int(int_notas), res[index_notas][6])
                        speak('registro concluído')
                    if indice_int == "quarto":
                        speak(f'qual nota deseja atribuir para a matéria: "{voice}" no 4º índice ')
                        int_notas = record_audio().strip()
                        update("NOTAS_4", int(int_notas), res[index_notas][7])
                        speak('registro concluído')
                else:
                    speak('Não entendi o que voce disse, repita por favor!')
                    return record_audio()
            else:
                speak(f'qual nota deseja atribuir para a matéria: "{voice}"')
                notas_int = record_audio().strip()
                update("NOTAS", int(notas_int), res[index_notas][4])
        else:
            speak('Não encontrei essa matéria no meu banco de dados, para criar uma nova matéria basta dizer '
                  '"Cadastrar Matéria" ')
            return record_audio()

    if there_exists(["definir metas", "criar metas", "adicionar metas"]):
        speak('para qual matéria gostaria de cadastrar uma nova meta de estudos semanal ? ')
        vsqlin = " SELECT * FROM GERAL"
        res = consulta(vcon, vsqlin)
        materias_metas = []
        for result in res:
            materias_metas.append(result[1])
        voice = record_audio().strip().lower()
        index_metas = materias_metas.index(voice)
        if voice in materias_metas:
            if res[index_metas][9] != -1:
                speak('gostaria de substituir o valor atual ?')
                voice2 = record_audio().strip().lower()[0]
                if voice2 == "s":
                    speak(f'quantas horas serão definidas para metas da matéria: "{voice}"')
                    metas_int = record_audio().strip().split()
                    update("HORAS_META", int(metas_int[0]), res[index_metas][9])
                    speak('registro salvo')
                if voice2 == "n":
                    speak('ok, qualquer dúvida é só me chamar !')
                    return record_audio()
            elif res[index_metas][9] == -1:
                speak(f'quantas horas serão definidas para metas da matéria: "{voice}"')
                metas_int2 = record_audio().strip().split()
                update("HORAS_META", int(metas_int2[0]), res[index_metas][9])
                speak('registro salvo')
        else:
            speak('Não encontrei essa matéria no meu banco de dados, para criar uma nova matéria basta dizer '
                  '"Cadastrar Matéria" ')
            return record_audio()

    if there_exists(["horas estudadas", "hora estudada", "horas que estudei"]):
        try:
            speak('para qual matéria gostaria de cadastras as horas estudadas? ')
            vsqlin = " SELECT * FROM GERAL"
            res = consulta(vcon, vsqlin)
            materias_horas = []
            for result in res:
                materias_horas.append(result[1])
            voice = record_audio().strip().lower()
            index_horas = materias_horas.index(voice)
            if voice in materias_horas:
                if res[index_horas][10] != -1:
                    speak('gostaria de substituir o valor atual ?')
                    voice2 = record_audio().strip().lower()[0]
                    if voice2 == "s":
                        speak(f'quantas horas você estudou para a matéria: "{voice}"')
                        horas_int = record_audio().strip().split()
                        update("HORAS_ESTUDADAS", int(horas_int[0]), res[index_horas][10])
                        speak('registro salvo')
                    if voice2 == "n":
                        speak('ok, qualquer dúvida é só me chamar !')
                        return record_audio()
                elif res[index_horas][10] == -1:
                    speak(f'quantas horas serão definidas para metas da matéria: "{voice}"')
                    metas_int2 = record_audio().strip().split()
                    update("HORAS_ESTUDADAS", int(metas_int2[0]), res[index_horas][10])
                    speak('registro salvo')
        except ValueError:
            speak('Não encontrei essa matéria no meu banco de dados, para criar uma nova matéria basta dizer '
                  '"Cadastrar Matéria" ')
            return record_audio()

    if there_exists(["consultar metas", "visualizar gráfico", "verificar metas", "metas estudadas"]):
        try:
            speak('para qual matéria gostaria de visualizar as horas estudadas? ')
            vsqlin = " SELECT * FROM GERAL"
            res = consulta(vcon, vsqlin)
            materias_consultas = []
            for result in res:
                materias_consultas.append(result[1])
            voice = record_audio().strip().lower()
            index_consulta = materias_consultas.index(voice)
            if voice in materias_consultas:
                if res[index_consulta][9] != -1 and res[index_consulta][10] != -1:
                    count = res[index_consulta][10] - res[index_consulta][9]
                    if count < 0:
                        speak(f'sua meta ainda não foi atingida, você estudou um total de {res[index_consulta][10]} '
                              f'horas semanais e ainda faltam {count * -1} horas para atingir a meta!')
                    elif count >= 0:
                        speak(f'Parabéns! Sua meta foi alcançada, você estudou um total de {res[index_consulta][10]} '
                              f'horas semanais, e a meta estipulada foi de {res[index_consulta][9]} horas ')
        except ValueError:
            speak('Não encontrei essa matéria no meu banco de dados, para criar uma nova matéria basta dizer '
                  '"Cadastrar Matéria" ')
            return record_audio()
    if there_exists(["que horas são", "horário", "qual hora", "que horas"]):
        speak(config.SystemInfo.get_time())

    if there_exists(["que dia é hoje", "data de hoje", "qual dia é hoje"]):
        speak(config.SystemInfo.get_date())

    if there_exists(['isso é tudo', "até mais", "tchau"]):
        greet = [f'Até mais {person_obj.name} !', 'até breve', 'Até a próxima !']
        speak(random.choice(greet))
        time.sleep(2)
        exit()
    if there_exists(["registrar faltas", "anotar faltas", "adicionar faltas", "cadastrar faltas",
                     "cadastrar falta", "registrar falta", "anotar falta"]):
        try:
            vsqlin = " SELECT * FROM GERAL"
            res = consulta(vcon, vsqlin)
            materias_faltas = []
            for result in res:
                materias_faltas.append(result[1])
            speak('Para qual matéria gostaria de registrar suas faltas?')
            fal = record_audio().strip().lower().split()
            if fal[0] in materias_faltas:
                index = materias_faltas.index(fal[0])
                if res[index][8] == -1:
                    speak(f'quantas faltas gostaria de registrar para a matéria: "{fal[0]}"')
                    int_faltas = record_audio().strip()
                    update("FALTAS", int(int_faltas), res[index][8])
                else:
                    speak(' Voce deseja "somar" ou "remover" suas faltas ?')
                    resp = record_audio().strip().lower()
                    if resp == "somar":
                        speak('Para qual matéria gostaria de adicionar suas faltas?')
                        fal = record_audio().strip().lower().split()
                        if fal[0] in materias_faltas:
                            speak(f'Quantas faltas gostaria de adicionar para a matéria: "{fal[0]}"')
                            int_faltas = record_audio().strip()
                            index = materias_faltas.index(fal[0])
                            update("FALTAS", int(int_faltas) + res[index][8], res[index][8])
                        else:
                            speak('Não encontrei essa matéria no meu banco de dados, para criar uma nova matéria '
                                  'basta dizer "Cadastrar Matéria" ')
                    if resp == "remover":
                        speak('Para qual matéria gostaria de remover suas faltas ?')
                        fal = record_audio().strip().lower().split()
                        if fal[0] in materias_faltas:
                            speak(f'Quantas faltas gostaria de remover para a matéria: "{fal[0]}"')
                            int_faltas = record_audio().strip()
                            index = materias_faltas.index(fal[0])
                            update("FALTAS", res[index][8] - int(int_faltas), res[index][8])
        except ValueError:
            speak('Não entendi o que voce disse, tente novamente!')
            return record_audio()

    if there_exists(["mostrar faltas", "verificar faltas", "consultar faltas"]):
        try:
            speak('Para qual matéria gostaria de verificar suas faltas? ')
            vsqlin = " SELECT * FROM GERAL"
            res = consulta(vcon, vsqlin)
            mostrar_faltas = []
            for result in res:
                mostrar_faltas.append(result[1])
            resp = record_audio().strip().lower()
            index_faltas = mostrar_faltas.index(resp)
            if resp in mostrar_faltas:
                speak(f'você está com {res[index_faltas][8]} faltas na matéria: "{resp}"')
        except ValueError:
            speak('Não encontrei essa matéria no meu banco de dados, para criar uma nova matéria basta dizer '
                  '"Cadastrar Matéria" ')
            return record_audio()

    if there_exists(["registrar e-mail", "cadastrar e-mail", "trocar e-mail"]):
        speak('por favor digite seu e-mail na aba de registros que irá aparecer')

        def email():
            # conexão com os servidores do google
            smtp_ssl_host = 'smtp.gmail.com'
            smtp_ssl_port = 465
            # email e senha da conta google
            username = 'athena.assistant021@gmail.com'
            password = 'athena2021'

            from_addr = 'athena.assistant021@gmail.com'
            to_addrs = vEmail.get()

            message = MIMEText('CHEGUEI PORRA')
            message['subject'] = 'Athena Assistant'
            message['from'] = from_addr
            message['to'] = ', '.join(to_addrs)
            athena.quit()

            try:
                server = smtplib.SMTP_SSL(smtp_ssl_host, smtp_ssl_port)
                server.login(username, password)
                server.sendmail(from_addr, to_addrs, message.as_string())
                server.quit()

                print('Notificação enviada com sucesso!')

            except Exception as err:
                print(f'Falha ao enviar notificação. :{err}')

        def texto(text, background, foreground, anchor, x, y, w, h):
            txt = Label(athena, text=text, background=background, foreground=foreground, anchor=anchor)
            txt.place(x=x, y=y, width=w, height=h)

        def botao(text, command, x, y, width, height):
            Button(athena, text=text, command=command).place(x=x, y=y, width=width, height=height)

        athena = Tk()
        athena.title("Athena")
        athena.geometry("720x480")
        athena.configure(background="#A020F0")
        athena.iconbitmap("athena.ico")

        texto("Insira aqui seu E-mail para reber lembretes: ", "#A020F0", "#000", "w", 220, 140, 250, 20)
        vEmail = Entry(athena)
        vEmail.place(x=200, y=200, width=300, height=20)
        botao("Cadastrar", email, 235, 260, 230, 20)

        athena.mainloop()
        update('USER', respon[1][2], vEmail.get())
    if there_exists(["athena agendar data", "agende uma data", "marque uma prova", "marque um trabalho",
                     "agende uma prova", "agende um trabalho", "marcar trabalho"]):

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
            if x[::-1][0] == "a":
                if date_event[2].isnumeric():
                    speak(f"Voce agendou uma '{x}' para o dia {date_event[0]} do {date_event[2]} ")
                    arquivo.write(f"Título: '{x}' para o dia {date_event[0]}/{date_event[2]} \n")
                if date_event[2].isalpha():
                    speak(f"Voce agendou uma '{x}' para o dia {date_event[0]} de {date_event[2]} ")
                    arquivo.write(f"Título: '{x}' para o dia {date_event[0]} de {date_event[2]} \n")
            else:
                if date_event[2].isnumeric():
                    speak(f"Voce agendou um '{x}' para o dia {date_event[0]} do {date_event[2]} ")
                    arquivo.write(f"Título: '{x}' para o dia {date_event[0]}/{date_event[2]} \n")
                if date_event[2].isalpha():
                    speak(f"Voce agendou um '{x}' para o dia {date_event[0]} de {date_event[2]} ")
                    arquivo.write(f"Título: '{x}' para o dia {date_event[0]} de {date_event[2]} \n")

    if there_exists(["cadastrar matéria", "nova matéria", "nova materia", "cadastrar aula", "cadastrar nova matéria"]):
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
                                horario_inicial = record_audio().strip().replace(" ", ":").replace(" e ", ":").replace(
                                    'horas', "00")
                                speak(f'Quando termina a aula da matéria: "{materias[pos]}"  ? ')
                                horario_final = record_audio().strip().replace(" ", ":").replace(" e ", ":").replace(
                                    'horas', "00")
                                horario_materia.append(f"{horario_inicial}-{horario_final}")

                                with open("aulas.txt", "a+", encoding='utf-8') as arquivo:
                                    arquivo.write(f'Dia: {dias_semana[posi]} '
                                                  f'Aulas: {materias[pos]} = horario: {horario_materia[pos]} \n')
                                    add_banco("MATERIA", "DIA_SEMANA", "HORARIOS", materias[pos], dias_semana[posi],
                                              horario_materia[pos])

                            materias.clear()
                    except Exception as error:
                        print('>> Encontramos algum erro, por gentileza tente novamente')
                        print(error)
                    break

        except Exception as errorr:
            print(errorr)


if __name__ == '__main__':
    time.sleep(1)
    config.intro()
    asis_obj = asis()
    asis_obj.name = 'Athena'
    person_obj = person()
    playsound.playsound('bright.mp3')
    engine = pyttsx3.init()
    vsqli = " SELECT * FROM USER"
    respon = consulta(vcon, vsqli)
    if not respon:
        speak('Olá, sou sua assistente pessoal, estou aqui para te auxiliar em seus estudos! ')
        time.sleep(2)
        speak('Antes de mais nada, gostaria de te conhecer melhor!! Qual é o teu nome ? ')
        name = record_audio().strip().capitalize()
        person_obj.name = name
        vsqlindo = "INSERT INTO USER ('NOME')VALUES('" + name + "') "
        inserir(vcon, vsqlindo)
        speak(f'Muito prazer em te conhecer {name}! eu me chamo {asis_obj.name}')
        time.sleep(2)
        while True:
            speak('Gostaria de cadastrar seu e-mail para receber notificações sobre eventos agendados ?')
            resp = record_audio().strip().lower()[0]
            if resp == "s":
                speak('por favor digite seu e-mail na aba de registros que irá aparecer')


                def email():
                    # conexão com os servidores do google
                    smtp_ssl_host = 'smtp.gmail.com'
                    smtp_ssl_port = 465
                    # email e senha da conta google
                    username = 'athena.assistant021@gmail.com'
                    password = 'athena2021'

                    from_addr = 'athena.assistant021@gmail.com'
                    to_addrs = vEmail.get()

                    message = MIMEText('CHEGUEI PORRA')
                    message['subject'] = 'Athena Assistant'
                    message['from'] = from_addr
                    message['to'] = ', '.join(to_addrs)
                    athena.quit()

                    try:
                        server = smtplib.SMTP_SSL(smtp_ssl_host, smtp_ssl_port)
                        server.login(username, password)
                        server.sendmail(from_addr, to_addrs, message.as_string())
                        server.quit()

                        print('Notificação enviada com sucesso!')

                    except Exception as err:
                        print(f'Falha ao enviar notificação. :{err}')


                def texto(text, background, foreground, anchor, x, y, w, h):
                    txt = Label(athena, text=text, background=background, foreground=foreground, anchor=anchor)
                    txt.place(x=x, y=y, width=w, height=h)


                def botao(text, command, x, y, width, height):
                    Button(athena, text=text, command=command).place(x=x, y=y, width=width, height=height)

                athena = Tk()
                athena.title("Athena")
                athena.geometry("720x480")
                athena.configure(background="#A020F0")
                athena.iconbitmap("athena.ico")

                texto("Insira aqui seu E-mail para reber lembretes: ", "#A020F0", "#000", "w", 220, 140, 250, 20)
                vEmail = Entry(athena)
                vEmail.place(x=200, y=200, width=300, height=20)
                botao("Cadastrar", email, 235, 260, 230, 20)

                athena.mainloop()
                vsq1 = f"INSERT INTO USER ('EMAIL')VALUES('" + vEmail.get() + "') "
                inserir(vcon, vsq1)
                speak(
                    f'Para me conhecer um pouco melhor {person_obj.name}, basta dizer "qual sua função" que eu te dou umas dicas ! ')
                break
            if resp == "n":
                speak('Ok, caso queira cadastrar um novo e-mail, basta dizer "registrar e-mail" ')
                time.sleep(3)
                ema = "não cadastrado"
                vsq = f"INSERT INTO USER ('EMAIL')VALUES('" + ema + "') "
                inserir(vcon, vsq)
                speak(f'{person_obj.name} ,para me conhecer um pouco melhor , basta dizer "qual sua função" que eu explico '
                      f'melhor para você')
                break
            else:
                speak('Não entendi sua resposta, repita por gentileza em alguns instantes')
                time.sleep(3)
                continue
    else:
        speak(f'Olá {respon[0][1]}, em que posso te ajudar ?')
    while 1:
        voice_data = record_audio()  # get the voice input
        respond(voice_data)  # respond

vcon.close()
