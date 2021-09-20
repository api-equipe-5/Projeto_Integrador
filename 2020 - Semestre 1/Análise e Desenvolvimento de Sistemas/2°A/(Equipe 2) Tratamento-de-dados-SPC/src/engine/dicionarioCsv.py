import csv

def date_csv(file):
  with open(f'./src/database/csv/{file}.csv', 'r') as csv_file:
    csv_reader = csv.reader(csv_file)

    next(csv_reader)

    c = 0

    lista = []

    metadados =[]

    corpo_tratado = []
    metadado_tratado = []

    for line in csv_reader:
      if c ==0:
        metadados.append(line[0].split('|'))
      if(c != 0):
        lista.append(line[0].split('|'))
      c += 1

    for metadado in metadados[0]:
      if metadado:
          metadado_tratado.append(str(metadado).replace(" ",""))

    for item in lista:
      nova_lista = []
      for i in item:
        if(i):
          if '+--' not in i:
            nova_lista.append(i)            
          
      corpo_tratado.append(nova_lista) 
    
    return corpo_tratado,metadado_tratado

def tuple_csv(file_to_run):
  data = date_csv(f'{file_to_run}')
 
  data_tratado = []

  for i in data[0]:
    cont = 0
    for z in i:
      data_tratado.append([])
      data_tratado[cont].append(z)
      cont += 1

  dicionario = dict(zip(data[1],data_tratado))

  return dicionario,data[1]
