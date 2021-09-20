from datetime import datetime
def temporizador():
    first = datetime.now().replace(microsecond=0)
    input("Digite qualquer coisa para parar o contador: ")
    second = datetime.now().replace(microsecond=0)
    tempo_percorrido = (second - first)
    return print(f"O tempo total é de {tempo_percorrido}")
temporizador()
