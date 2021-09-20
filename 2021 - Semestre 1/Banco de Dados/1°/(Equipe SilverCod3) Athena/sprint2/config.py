import datetime
import smtplib
from email.mime.text import MIMEText
import credenciais


class SystemInfo:
    def __init__(self):
        pass

    @staticmethod
    def get_time():
        now = datetime.datetime.now()
        resposta = f"são {now.hour} horas e {now.minute} minutos"
        return resposta

    @staticmethod
    def get_date():
        datenow = datetime.date.today()
        resp = f"hoje é {datenow.day} do {datenow.month} de {datenow.year}"
        return resp


version = 1.1


def intro():
    msg = f"Assistente - version {version} / by: Time SilverCode"
    print("-" * len(msg) + "\n{}\n".format(msg) + "-" * len(msg))


def email():
    # conexão com os servidores do google
    smtp_ssl_host = 'smtp.gmail.com'
    smtp_ssl_port = 465
    # email e senha da conta google
    username = 'athena.assistant021@gmail.com'
    password = credenciais.KEY

    from_addr = 'athena.assistant021@gmail.com'
    to_addrs = input('Digite seu e-mail: ')

    # MIMEText para enviar apenas textos

    message = MIMEText('Olá, bem vindo, sou Athena, sua assistente de estudos!')
    message['subject'] = 'Athena Assistant'
    message['from'] = from_addr
    message['to'] = ', '.join(to_addrs)

    try:
        server = smtplib.SMTP_SSL(smtp_ssl_host, smtp_ssl_port)
        server.login(username, password)
        server.sendmail(from_addr, to_addrs, message.as_string())
        server.quit()
        print('Notificação enviada com sucesso!')
    except Exception as err:
        print(f'Falha ao enviar notificação. :{err}')


lista_erros = [
    "Não entendi nada",
    "Desculpe, não entendi",
    "Repita novamente por favor"
]
