from win10toast import ToastNotifier

from datetime import datetime

data_atual = datetime.now()

data_em_texto = data_atual.strftime('%d/%m/%Y %H:%M')

toast = ToastNotifier()

toast.show_toast('Athena', 'Aula de Algoritmos', duration=20, icon_path='athena2.ico')
