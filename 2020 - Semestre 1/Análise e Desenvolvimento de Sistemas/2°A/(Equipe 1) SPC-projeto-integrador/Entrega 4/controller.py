import pandas as pd 
import os
import datetime
import matplotlib.pyplot as plt

modalidade = pd.read_excel('../dados/STG_MDL.xlsx')
pagamento = pd.read_excel('../dados/STG_PGT.xlsx')
movimento = pd.read_excel('../dados/STG_MVT_CRD.xlsx')
operacao = pd.read_excel('../dados/STG_OPR_ITT.xlsx')
fonte = pd.read_excel('../dados/STG_FNT_ITT.xlsx')

modalidade.columns = ['id_mod', 'codigo_mod', 'descri_mod', 'DAT_INC_DBO']
pagamento.columns = ['id_pagamento', 'vlr_pago', 'data_vencimento', 'codigo_mod', 'qtd_clientes', 'qtd_pagamento', 'id_fonte', 'tipo_pessoa', 'DAT_RSS_FNT_ITT', 'DAT_INC_DBO']
movimento.columns = ['id_movi', 'vlr_saldo', 'vlr_total_fat', 'vlr_min_fat', 'vlr_parcela_fat', 'qtd_clientes', 'qtd_movi', 'tipo_pessoa', 'id_fonte', 'codigo_mod', 'DAT_RSS_FNT_ITT', 'DAT_INC_DBO']
operacao.columns = ['id_operacao', 'vlr_contrato', 'qtd_parcelas', 'vlr_pendente', 'qtd_clientes', 'qtd_operacao', 'id_fonte', 'id_mod', 'tipo_pessoa', 'DAT_RSS_FNT_ITT', 'DAT_INC_DBO']
fonte.columns = ['id_fonte', 'cnpj', 'complemento', 'NOM_COM', 'NOM_RAZ_SCL', 'DAT_INC_DBO']

def plot_completude(DataFrame):
    cont_nulos = int()
    nulos = DataFrame.isnull().sum()
    for i in nulos:
        nulos += i
    
    cont_total = int()
    total = DataFrame.count()
    for i in total:
        cont_total += i
        
    x = ['Campos completos']
    y = [cont_total]
    
    x2 = ['Campos nulos']
    y2 = [cont_nulos]
    
    plt.title(f"Completude da tabela {DataFrame.nome}")
    plt.bar(x, y, label = 'Completos', color = 'g')
    plt.bar(x2, y2, label = 'Nulos', color = 'r')
    plt.legend()

def checar_string(Fonte):
    NOM = pd.DataFrame(Fonte, columns = ['NOM_COM', 'NOM_RAZ_SCL'])
    NOM_COM = []
    RAZ_SCL = []
    cont_a = 0
    cont_b = 0
    for x in NOM.columns:
        for y in NOM[x]:
            
            if x == 'NOM_COM':
                cont_a += 1
                if type(y) != str:
                    NOM_COM.append(cont_a)
                    
            if x == 'NOM_RAZ_SCL':
                cont_b += 1
                if type(y) != str:
                    RAZ_SCL.append(cont_b)
                    
    print(f'Foram identificados {len(NOM_COM)} dados incoerentes na coluna Nome Comercial \ne na coluna Nome Razão Social foram identificados {len(RAZ_SCL)} dados incoerentes')    

def valida_cnpj():
    
  # Declarando listas e variaveis
  valida_cnpj = pd.DataFrame(fonte, columns = ['cnpj', 'complemento'])
  cnpj = []
  complemento = []
  certos_cnpj = []
  certos_complemento = []

  # Verificando se a primeira parte do CPJN possui 10 digitos
  for x in valida_cnpj['cnpj']:
      if len(str(x)) == 10:
          cnpj.append(str(x))
      else:
          cnpj.append('a')

  # Verificando se a segunda parte do CNPJ possui 4 digitos
  for x in valida_cnpj['complemento']:
      if len(str(x)) == 4:
          complemento.append(str(x))
      else:
          complemento.append('a')

  # Verificando se ao somar as duas partes do CNPJ irá dar 14 digitos
  for x in range(valida_cnpj.shape[0]):
      if len(cnpj[x]) + len(complemento[x]) == 14:
          certos_cnpj.append(cnpj[x])
          certos_complemento.append(complemento[x])
          
  validos = fonte['cnpj'].isin(certos_cnpj)
  cnpj_validos = fonte[validos]
  print(f"A tabela de fontes possui um total de {fonte.shape[0]} CNPJ's.\n{cnpj_validos.shape[0]} destes possuem tamanho de dígitos válidos e {fonte.shape[0] - cnpj_validos.shape[0]} inválidos.")

  x = ['Válidos']
  y = [cnpj_validos.shape[0]]
  x2 = ['Inválidos']
  y2 = [fonte.shape[0] - cnpj_validos.shape[0]]
  x3 = ['Totais']
  y3 = [fonte.shape[0]]
    
  plt.title(f"Quantidade de CNPJ's válidos e inválidos na tabela de fontes.")
  plt.bar(x, y, label = 'Completos', color = 'b')
  plt.bar(x2, y2, label = 'Nulos', color = 'r')
  plt.bar(x3, y3, label = 'Total', color = 'y')
  plt.legend()
  plt.show()
  
def gap_id(df):
    IDs = df[df.columns[0]].to_list()
    padrao = range(min(IDs), max(IDs) + 1)
    faltante = list()
    for ID in padrao:
        if ID not in IDs:
            faltante.append(ID)
    if len(faltante) == 0:
        print(f"100% dos ID's da tabela {df.nome} são sequenciais, pois não apresentam nenhum gap.")
        return
    print(f"Existe um gap de {(len(faltante)/len(list(IDs))) * 100:.3f}% na sequência de ID's da tabela {df.nome}\nAbaixo a lista dos ID's faltantes:\n {str(faltante)[1:-1]}\n")


def valida_modalidade(dataframe, exibir = True):
    invalidos = list()
    referencia = [ID for ID in modalidade['codigo_mod']]
    amostra = [ID for ID in dataframe['codigo_mod']]
    for ID in amostra:
      if ID not in referencia:
        invalidos.append(ID)
        
    porcentagem = (len(invalidos) / len(amostra)) * 100
    
    if len(invalidos) == 0:
        if exibir:
            print(f"100% dos códigos de modalidade da tabela de {dataframe.nome} estão referenciados na tabela de modalidade")    
        return porcentagem
    
    else:
        if exibir:
            print(f"{porcentagem}% dos ID's da tabela de {dataframe.nome} não estão referenciados na tabela de fontes. Os ID's incorretos estão listados abaixo:\n{str(invalidos)[1:-1]}")
        return porcentagem

def formata_data_vencimento(DataFrame):
    DataCerta = []
    lista = DataFrame['data_vencimento'].to_list()
    for i in lista:
        if len(str(i)) == 8:
            dia = str(i)[0:2]
            mes = str(i)[2:4]
            ano = str(i)[4:]
            if int(dia) < 32 and int(mes) < 13 and int(ano) > 0:
                dat = str(i)[0:2] + '-' + str(i)[2:4] + '-' + str(i)[4:]
            else:
                dat = 'Data possui informações invalidas'
            DataCerta.append(dat)
    DataCerta = pd.Series(DataCerta)
    DataFrame['data_vencimento'].update(DataCerta)
    print(f'As datas da tabela {DataFrame.nome} foram alteradas com sucesso')

def analisa_arquivo(arquivo):
  if arquivo[-4:].lower() not in '.xlsx' or type(arquivo) != str: #Confirmando que o arquivo foi inserido como string e com a extensão
    print('ERRO: Inserir o nome do arquivo entre aspas e identificando a extensão.')
    return

  info = os.stat(arquivo) #Aqui, entre aspas, deve ser colocado o caminho do arquivo
  criacao = info[9]
  modificacao = info[8]
  criacao = datetime.datetime.fromtimestamp(criacao)
  modificacao = datetime.datetime.fromtimestamp(modificacao)
  print('Data de criação do arquivo:', criacao.strftime("%d/%m/%y - %Hh%M"))
  print('Data da última modificação do arquivo', modificacao.strftime("%d/%m/%y - %Hh%M"))

    
def valida_idfonte(dataframe):
    invalidos = list()
    referencia = [ID for ID in fonte['id_fonte']]
    amostra = [ID for ID in dataframe['id_fonte']]
    for ID in amostra:
      if ID not in referencia:
        invalidos.append(ID)

    if len(invalidos) == 0:
      print(f"100% dos ID's de fontes da tabela {dataframe.nome} são válidos, de acordo com a tabela de fontes")

    else:
      porcentagem = (len(invalidos) / len(amostra)) * 100
      print(f"{porcentagem}% dos ID's da tabela de {dataframe.nome} não estão referenciados na tabela de fontes. Os ID's incorretos estão listados abaixo:")
      print(invalidos)
      

def negocio_movimento(dataframe):
    return {'Total utilizado': dataframe["vlr_saldo"].sum(), 'Total fatura': dataframe["vlr_total_fat"].sum(), 'Total mínimo da fatura': dataframe["vlr_min_fat"].sum(), 'Total da parcela': dataframe["vlr_parcela_fat"].sum(), 'Quantidade de movimentações': dataframe["qtd_movi"].sum()}


def negocio_pagamento(dataframe):
    data, cont = str(datetime.date.today()).replace('-', ''), 0
    for vencimento in dataframe["data_vencimento"]:
        vencimento = str(vencimento)
        vencimento = vencimento[4:] + vencimento[2:4] + vencimento[:2]
        if vencimento < data:
            cont += 1

    return dataframe["vlr_pago"].sum(), dataframe["qtd_pagamento"].sum(), cont

def plot_pagamentos():
    valores = negocio_pagamento(pagamento)
    plt.style.use("ggplot")
    plt.figure(figsize = (10,10))
    plt.title(f"Indicador de negócio - Pagamentos")
    nomes = ['Valor total de pagamentos', 'Quantidade de registros vencidos', 'Quantidade de Pagamentos']
    
    for i in range(3):
        
        plt.bar(nomes[i], valores[i], color = 'royalblue')
    
    plt.show()
    
def negocio_parcelas_total(DataFrame):
    return DataFrame["qtd_parcelas"].sum()

def negocio_parcelas_mod(DataFrame):
    modalidades = list(modalidade['codigo_mod'])
    final = list()
    temp = list()
    for i in modalidades:
        query = f'id_mod == "{i}"'
        temp = operacao.query(query)["qtd_parcelas"].sum()
        final.append([i, temp])
    return final

def negocio_operacao_vlrtotal():
    return operacao["vlr_contrato"].sum()

def negocio_op_parcelas():
    valores = negocio_parcelas_mod(operacao)
    plt.style.use("ggplot")
    plt.figure(figsize = (10,10))
    quantias = list(i[1] for i in valores)
    quantias.append(negocio_parcelas_total(operacao))
    mods = list(i[0] for i in valores)
    mods.append('Total')
    plt.barh(mods, quantias, color = 'royalblue')
    plt.xlabel("\nQuantidade de parcelas")
    plt.ylabel("Códigos das Modalidades\n")
    plt.title("\nOperação - Quantidade de parcelas por modalidade\n")
    plt.show()

def negocio_saldo_ddr():
    return operacao["vlr_pendente"].sum()

def plot_movimento():
    valores = negocio_movimento(movimento)
    plt.style.use("ggplot")
    plt.figure(figsize = (10,10))
    plt.title(f"Indicador de negócio - Movimentação")
    plt.bar(['Total utilizado'], valores['Total utilizado'], color = 'royalblue')
    plt.bar(['Total fatura'], valores['Total fatura'], color = 'darkblue')
    plt.bar(['Total mínimo da fatura'], valores['Total mínimo da fatura'], color = 'royalblue')
    plt.bar(['Total da parcela'], valores['Total da parcela'], color = 'darkblue')
    plt.bar(['Quantidade de movimentações'], valores['Quantidade de movimentações'], color = 'royalblue')
    plt.show()
