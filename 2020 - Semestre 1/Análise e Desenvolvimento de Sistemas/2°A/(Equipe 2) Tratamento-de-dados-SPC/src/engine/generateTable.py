import xlsxwriter
import sys

matriz = sys.argv[1]

nuevaMatriz = []
    
elContador = -1
for col in matriz.split('|'):
    nuevaMatriz.append([])
    for row in col.split(','):
        if row == '':
            break
        nuevaMatriz[elContador].append(row)
    elContador +=1

matriz = nuevaMatriz

workbook = xlsxwriter.Workbook('generatedTables/tabela_padronizada.xlsx')
worksheet = workbook.add_worksheet()

for col in range(len(matriz[0])+1):
    for row in range(len(matriz[col])):
        if col == 0:
            worksheet.write(col,row,matriz[col][row])
        worksheet.write(row +1,col -1 ,matriz[col][row])
      
workbook.close()