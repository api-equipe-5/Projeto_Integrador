import xlrd

def return_tuple(file):
    newFile = xlrd.open_workbook(f'../database/xlsx/{file}.xlsx')
    newFile_sh = newFile.sheet_by_index(0)
    namesRow = []
    dictRow = []

    for column in range(newFile_sh.ncols):
        namesRow.append(str(newFile_sh.row(0)[column]).replace("text:", "").replace("'", ""))
        dictRow.append([])
        for line in range(newFile_sh.nrows):
            if line != 0:
                if 'text' in str(newFile_sh.row(line)[column]):
                    dictRow[column].append(str(newFile_sh.row(line)[column]).replace("text:", "").replace("'", ""))
                else:
                    dictRow[column].append(str(newFile_sh.row(line)[column]).replace("number:", "").replace(".0", ""))

    newDict = dict(zip(namesRow, dictRow))
    return newDict, namesRow

def verificarNullById (var,id):
    verified = []
    cont = []
    for i in range(len(var)):
        if var[i] == "empty:''":
            verified.append(var[i].replace("empty:''", "Id:")+id[i])
        else:
            if var.count(var[i]) != 1:
                cont.append(f'Id:{id[i]}  Item:{var[i]}')
            pass
    return verified,cont

def chamarNullID(file,funcDict):
    newDict = funcDict[0] 
    newNomes = funcDict[1]

    for i in newNomes:
        print(f'\nIdentificador {i}\nVazios:')
        print(verificarNullById(newDict[i],newDict[newNomes[0]])[0])
        print('Repetidos')
        print(verificarNullById(newDict[i], newDict[newNomes[0]])[1])

def main():
    file = ['STG_MVT_CRD','STG_FNT_ITT','STG_MDL','STG_OPR_ITT','STG_PGT']

    escolha = 2
    
    if escolha == 2:
        for i in file:
            chamarNullID(i,return_tuple(i))

if __name__ == "__main__":
    main()
