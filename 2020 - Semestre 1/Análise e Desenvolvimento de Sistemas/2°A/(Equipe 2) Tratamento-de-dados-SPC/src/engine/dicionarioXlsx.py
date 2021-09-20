import xlrd

def return_tuple(file):
    newFile = xlrd.open_workbook(f'./src/database/xlsx/{file}.xlsx')
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