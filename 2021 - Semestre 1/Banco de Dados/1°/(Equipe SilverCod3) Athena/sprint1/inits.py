import datetime


class SystemInfo:
    def __init__(self):
        pass

    @staticmethod
    def get_time():
        now = datetime.datetime.now()
        resposta = f"são {now.hour} horas e {now.minute} minutos"
        return resposta


version = 1.0


def intro():
    msg = f"Assistente - version {version} / by: Time SilverCode"
    print("-" * len(msg) + "\n{}\n".format(msg) + "-" * len(msg))


lista_erros = [
    "Não entendi nada",
    "Desculpe, não entendi",
    "Repita novamente por favor"
]
