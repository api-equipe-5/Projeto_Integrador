horas_pretendidas = int(input('Quantas horas você pretende estudar? '))
horas_cumpridas = int(input('Quantas horas você estudou? '))

import numpy as np
import matplotlib.pyplot as plt

horas = ['Horas Pretendidas', 'Horas Cumpridas']
horas2 = [horas_pretendidas, horas_cumpridas]

plt.bar(horas, horas2, color='purple')

plt.xticks(horas)
plt.ylabel('HORAS')
plt.xlabel('HORAS DE ESTUDO')
plt.title('METAS DE ESTUDO')
plt.show()
