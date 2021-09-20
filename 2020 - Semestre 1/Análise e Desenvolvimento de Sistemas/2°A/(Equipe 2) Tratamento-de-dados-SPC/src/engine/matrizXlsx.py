import xlrd
import sys

def matriz_xlsx(file):
    file_workbook = xlrd.open_workbook(f'./src/database/xlsx/{file}')
    file = file_workbook.sheet_by_index(0)
    metadado = [[]]
    matriz = []

    for column in range(file.ncols):
        matriz.append([])     
        for line in range(file.nrows):
            if not line:
              metadado[0].append(str(file.row(line)[column]).replace("text:", "").replace("'", ""))
            if line:
                if 'text' in str(file.row(line)[column]):
                    matriz[column].append(str(file.row(line)[column]).replace("text:", "").replace("'", ""))
                else:
                    matriz[column].append(str(file.row(line)[column]).replace("number:", "").replace(".0", ""))
    
    return(metadado + matriz)



matriz = matriz_xlsx(sys.argv[1])
texto = "|"
for array in matriz:
  for elemento in array:
    texto += f'{elemento},'
  texto += '|'

print(texto)