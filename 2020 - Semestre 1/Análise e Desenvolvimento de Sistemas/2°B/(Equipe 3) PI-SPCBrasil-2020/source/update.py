import csv
from tkinter import *
import tkinter as tk
from tkinter import filedialog
import os

class Application:
    
    def __init__(self, master=None):
        
        self.fonte = ("Verdana", "8")

        #Parametrizações containers
            #Container 1 - Título
        self.container1 = Frame(master)
        self.container1["pady"] = 10
        self.container1.pack()
            #Container 2 - Campo Entrada
        self.container2 = Frame(master)
        self.container2["padx"] = 20
        self.container2["pady"] = 5
        self.container2.pack()
            #Container 3 - Campo Saída
        self.container3 = Frame(master)
        self.container3["padx"] = 20
        self.container3["pady"] = 5
        self.container3.pack()
            #Container 3 - Campo Saída
        self.container4 = Frame(master)
        self.container4["padx"] = 20
        self.container4["pady"] = 5
        self.container4.pack()
            #Container 5 - Processar
        self.container5 = Frame(master)
        self.container5["padx"] = 20
        self.container5["pady"] = 5
        self.container5.pack()
            #Container 5 - Mensagem
        self.container6 = Frame(master)
        self.container6["pady"] = 5
        self.container6.pack()
        
        #Atributos dos containers e suas propriedades
            #Atributos - Container 1 - Título
        self.titulo = Label(self.container1, text="Processar arquivos")
        self.titulo["font"] = ("Arial", "10", "bold")
        self.titulo.pack()

            #Atributos - Container 2 - Label, Input e Button - PSF
        self.lblPSF = Label(self.container2, 
        text="PSF:", font=self.fonte, width=8)
        self.lblPSF.pack(side=LEFT)
 
        self.txtPSF = Entry(self.container2)
        self.txtPSF["width"] = 50
        self.txtPSF["font"] = self.fonte
        self.txtPSF.pack(side=LEFT)
 
        self.btnPSF = Button(self.container2, text="Selecionar", 
        font=self.fonte, width=8)
        self.btnPSF["command"] = self.selecionaArquivoPSF
        self.btnPSF.pack(side=RIGHT)
        
            #Atributos - Container 3 - Label, Input e Button - END_PSF
        self.lblEND_PSF = Label(self.container3, 
        text="END_PSF:", font=self.fonte, width=8)
        self.lblEND_PSF.pack(side=LEFT)
 
        self.txtEND_PSF = Entry(self.container3)
        self.txtEND_PSF["width"] = 50
        self.txtEND_PSF["font"] = self.fonte
        self.txtEND_PSF.pack(side=LEFT)
 
        self.btnEND_PSF = Button(self.container3, text="Selecionar", 
        font=self.fonte, width=8)
        self.btnEND_PSF["command"] = self.selecionaArquivoEND_PSF
        self.btnEND_PSF.pack(side=RIGHT)

            #Atributos - Container 4 - Label, Input e Button - OPR
        self.lblOPR = Label(self.container4, 
        text="OPR:", font=self.fonte, width=8)
        self.lblOPR.pack(side=LEFT)
 
        self.txtOPR = Entry(self.container4)
        self.txtOPR["width"] = 50
        self.txtOPR["font"] = self.fonte
        self.txtOPR.pack(side=LEFT)
 
        self.btnOPR = Button(self.container4, text="Selecionar", 
        font=self.fonte, width=8)
        self.btnOPR["command"] = self.selecionaArquivoOPR
        self.btnOPR.pack(side=RIGHT)
        
            #Atributos - Container 4  
        self.btnProcessar = Button(self.container5)
        self.btnProcessar["text"] = "Processar"
        self.btnProcessar["font"] = ("Calibri", "8")
        self.btnProcessar["width"] = 12
        self.btnProcessar["command"] = self.correcaoPF
        self.btnProcessar.pack(side=LEFT)

        self.btnContinuar = Button(self.container5)
        self.btnContinuar["text"] = "Sair"
        self.btnContinuar["font"] = ("Calibri", "8")
        self.btnContinuar["width"] = 12
        self.btnContinuar["command"] = self.sair
        self.btnContinuar.pack(side=RIGHT)
  
        self.lblmsg = Label(self.container6, text="")
        self.lblmsg["font"] = ("Verdana", "9", "italic")
        self.lblmsg.pack()
  
        #Método selecionar arquivo ETRADA
    def selecionaArquivoPSF(self):  
        root = tk.Tk()
        root.withdraw()

        file_path = filedialog.askopenfilename()
 
        self.txtPSF.insert(INSERT, file_path)
        
        #Método selecionar arquivo SAIDA
    def selecionaArquivoEND_PSF(self):  
        root = tk.Tk()
        root.withdraw()

        file_path = filedialog.askopenfilename()
        
        self.txtEND_PSF.insert(INSERT, file_path)
        
        #Método selecionar arquivo SAIDA
    def selecionaArquivoOPR(self):  
        root = tk.Tk()
        root.withdraw()

        file_path = filedialog.askopenfilename()
 
        self.txtOPR.insert(INSERT, file_path)

    def sair(self):
        root.destroy()
        sys.exit()

    # Função para correção PRIMEIRA FASE;
    # Remover espaços, \n e linhas indesejadas.
    def correcaoPF(self):
        local = os.environ['temp']
        if (self.txtPSF.get() != '') and (self.txtEND_PSF.get() != '') and (self.txtOPR.get() != ''): 
            self.lblmsg["text"] = "Processando..."
            
            arquivoPSF = open(self.txtPSF.get())
            arquivoEND_PSF = open(self.txtEND_PSF.get())
            arquivoOPR = open(self.txtOPR.get())
            
            arquivoSaidaPSF = open(f'{local}\PSF_NOVO.csv', 'w', newline = '')
            arquivoSaidaEND_PSF = open(f'{local}\END_PSF_NOVO.csv', 'w', newline = '')
            arquivoSaidaOPR = open(f'{local}\OPR_NOVO.csv', 'w', newline = '')
         
            escreverPSF = csv.writer(arquivoSaidaPSF)
            escreverEND_PSF = csv.writer(arquivoSaidaEND_PSF)
            escreverOPR = csv.writer(arquivoSaidaOPR)

            
            #Correção PSF
            while True:
                linhaNova = []
                linha = arquivoPSF.readline()
                
                if linha == [''] or linha == '':
                    break
                if linha[0] == '+':
                    continue
                
                linha = linha.split('|')
                if (linha.count('') > 0):
                    linha.remove('')
                if (linha.count('\n') > 0):
                    linha.remove('\n')
                    
                for dado in linha:
                    linhaNova.append(dado.strip())

                escreverPSF.writerow(linhaNova)
                linhaNova = []
                
            #Correção END_PSF
            while True:
                linhaNova = []
                linha = arquivoEND_PSF.readline()
                
                if linha == [''] or linha == '':
                    break
                if linha[0] == '+':
                    continue
                
                linha = linha.split('|')
                if (linha.count('') > 0):
                    linha.remove('')
                if (linha.count('\n') > 0):
                    linha.remove('\n')
                    
                for dado in linha:
                    linhaNova.append(dado.strip())

                escreverEND_PSF.writerow(linhaNova)
                linhaNova = []
                
            #Correção OPR
            while True:
                linhaNova = []
                linha = arquivoOPR.readline()
                
                if linha == [''] or linha == '':
                    break
                if linha[0] == '+':
                    continue
                
                linha = linha.split('|')
                if (linha.count('') > 0):
                    linha.remove('')
                if (linha.count('\n') > 0):
                    linha.remove('\n')
                    
                for dado in linha:
                    linhaNova.append(dado.strip())

                escreverOPR.writerow(linhaNova)
                linhaNova = []
                
            # Fechar arquivos.
            arquivoPSF.close()
            arquivoEND_PSF.close()
            arquivoOPR.close()
            
            arquivoSaidaPSF.close()
            arquivoSaidaPSF.close()
            arquivoSaidaPSF.close()
            
            self.lblmsg["text"] = "Processamento realizado com sucesso."
            
                        
        elif self.txtPSF.get() == '':
            self.lblmsg["text"] = "Selecionar o arquivo PSF."
        elif self.txtEND_PSF.get() == '':
            self.lblmsg["text"] = "Selecionar o arquivo END_PSF."
        elif self.txtOPR.get() == '':
            self.lblmsg["text"] = "Selecionar o arquivo OPR."
        
  
root = Tk()
Application(root)
root.mainloop(0)











            

