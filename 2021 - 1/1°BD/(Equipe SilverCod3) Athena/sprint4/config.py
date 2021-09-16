import datetime
import smtplib
from email.mime.text import MIMEText
import credenciais
from tkinter import *


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


version = 1.3


def intro():
    msg = f"Assistente - version {version} / by: Time SilverCode"
    print("-" * len(msg) + "\n{}\n".format(msg) + "-" * len(msg))


# def email():
#     # conexão com os servidores do google
#     smtp_ssl_host = 'smtp.gmail.com'
#     smtp_ssl_port = 465
#     # email e senha da conta google
#     username = 'athena.assistant021@gmail.com'
#     password = credenciais.KEY
#
#     from_addr = 'athena.assistant021@gmail.com'
#     to_addrs = vEmail.get()
#
#     message = MIMEText("Olá, cheguei !")
#     message['subject'] = 'Athena Assistant'
#     message['from'] = from_addr
#     message['to'] = ', '.join(to_addrs)
#
#     try:
#         server = smtplib.SMTP_SSL(smtp_ssl_host, smtp_ssl_port)
#         server.login(username, password)
#         server.sendmail(from_addr, to_addrs, message.as_string())
#         server.quit()
#
#         print('Notificação enviada com sucesso!')
#     except Exception as err:
#         print(f'Falha ao enviar notificação. :{err}')
#
#
# app = Tk()
# vEmail = Entry(app)
# app.title("Athena")
# app.geometry("720x480")
# app.configure(background="#A020F0")
# Label(app, text=" Insira aqui seu E-mail para receber lembretes:", background="#A020F0", foreground="#000",
#       anchor="w").place(x=220, y=140, width=250, height=20)
#
# vEmail.place(x=200, y=200, width=300, height=20)
# Button(app, text="Cadastrar", command=email).place(x=235, y=260, width=230, height=20)
# app.mainloop()

lista_erros = [
    "Não entendi nada",
    "Desculpe, não entendi",
    "Repita novamente por favor"
]
