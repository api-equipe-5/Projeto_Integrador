from tkinter import *
import tkinter as tk
import xlrd
import pandas as pd
from tkinter import messagebox
from tkinter import ttk
from tkinter import filedialog



LARGE_FONT= ("Verdana 40")
a="./Tabela_unica.xlsx"
df1 =pd.read_excel(a)

class AEP(tk.Tk):

    def __init__(self, *args, **kwargs):
        
        tk.Tk.__init__(self, *args, **kwargs)
        container = tk.Frame(self)

        container.pack(side="top", fill="both", expand = True)

        container.grid_rowconfigure(0, weight=1)
        container.grid_columnconfigure(0, weight=1)

        self.frames = {}

        for F in (StartPage, PageOne, PageTwo):

            frame = F(container, self)

            self.frames[F] = frame

            frame.grid(row=0, column=0, sticky="nsew")

        self.show_frame(StartPage)

    def show_frame(self, cont):

        frame = self.frames[cont]
        frame.tkraise()


        
class StartPage(tk.Frame):

    def __init__(self, parent, controller):
        def ExitApplication():
            app.destroy()
        tk.Frame.__init__(self,parent)
        img = PhotoImage(file = "Imagem/Nome.png")
        label = tk.Label(self, image=img,width=1000,height=300,bg="white")
        label.image = img
        label.pack()

        bcomecar = tk.Button(self, text="Começar", relief=GROOVE, bg="#455DD8", fg="white", font="Verdana 11",
                            command=lambda: controller.show_frame(PageOne))
        bcomecar.place(x=200,y=400)

        bajuda = tk.Button(self, text="Ajuda", relief=GROOVE, bg="#455DD8", fg="white", font="Verdana 11",
                            command=lambda: controller.show_frame(PageTwo))
        bajuda.place(x=470,y=400)

        bsair = tk.Button(self, text="Sair", relief=GROOVE, bg="#455DD8", fg="white", font="Verdana 11",
                            command=ExitApplication)
        bsair.place(x=720,y=400)
        


class PageOne(tk.Frame):
 
    def __init__(self, parent, controller):


                 

        def ver():
            x = entradacpf.get()
            c = 0
            i = 0
            global na
            na = "APTO"
            espy = 50
            while c<=12044:
                if int(x) == df1['cpf'][c]:
                    label.pack_forget()
                    labelv.pack()
                    linha = (df1.loc[[c]])
                    cpf = linha.cpf.values
                    valorparc = linha.vlr_ctrd_fta_tfm.values
                    valorcon = linha.vlr_ctrd.values
                    valorpag = linha.vlr_pgt_tfm.values
                    saldodev = linha.sdo_ddr_tfm.values
                    datavenpar = linha.dat_vct_tfm.values
                    datavenulpar = linha.dat_vct_ult_pcl.values
                    status = linha.status.values
                    lbcpf = tk.Label(labelv,text=f"{cpf}")
                    lbcpf.config(width=50,bg="white", anchor=W)
                    lbcpf.place(x=5, y=espy)

                    lbvalorparc = tk.Label(labelv,text=f"{valorparc}")
                    lbvalorparc.config(width=50,bg="white", anchor=W)
                    lbvalorparc.place(x=90, y=espy)

                    lbvalorcon = tk.Label(labelv,text=f"{valorcon}")
                    lbvalorcon.config(width=33,bg="white", anchor=W)
                    lbvalorcon.place(x=210,y=espy)

                    lbvalorpag = tk.Label(labelv,text=f"{valorpag}")
                    lbvalorpag.config(width=33,bg="white", anchor=W)
                    lbvalorpag.place(x=320, y=espy)

                    lbsaldodev = tk.Label(labelv,text=f"{saldodev}")
                    lbsaldodev.config(width=33,bg="white", anchor=W)
                    lbsaldodev.place(x=440, y=espy)

                    lbdatavenpar = tk.Label(labelv,text=f"{datavenpar}")
                    lbdatavenpar.config(width=33,bg="white", anchor=W)
                    lbdatavenpar.place(x=550, y=espy)

                    lbvenulpar = tk.Label(labelv,text=f"{datavenulpar}")
                    lbvenulpar.config(width=33,bg="white", anchor=W)
                    lbvenulpar.place(x=750, y=espy)


                    if status == 'NÃO APTO':
                        na = 'NÃO APTO'

                    i=i+1
                    espy=espy+30
                c=c+1
                infolabel.config(text=f"STATUS: {na}")
                infolabel.place(x=700,y=370)
            if i==0:
                message = tk.messagebox.showwarning("ATENÇÃO","CPF Inválido!")
        def refresh():
            entradacpf.delete(0, END)
            labelv.pack_forget()
            label.pack()
            oklabel.config(text="")
            ok.set('')
            infolabel.config(text="")

        def doc():
            import_file_path = filedialog.askopenfilename()
            oklabel.config(text=f"{import_file_path}")
            ok.set(import_file_path)
            oklabel.place(x=100,y=550)
        def concluir():
            x=entradacpf.get()
            if x == '' or ok.get() == '':
                msgnao = tk.messagebox.showwarning("ATENÇÃO","Preencha todos os campos!")
            elif na == "NÃO APTO":
                msgnaoapto = tk.messagebox.showwarning("NÃO APTO","Este consumidor não está apto!")
            else:
                msgparabens = tk.messagebox.showinfo("FINALIZADO",f"{x} foi incluso no Auxílio Emergencial Positivo!")
            
        tk.Frame.__init__(self, parent)
        label = tk.Label(self, text="Verificação", font=LARGE_FONT)
        label.config(width=27,height=3,bg="#455DD8",fg="white")
        label.pack()

        labelv = tk.Label(self)
        labelv.config(width=125,height=20,bg="white")
        tit = tk.Label(labelv, text="CPF       Valor Parcelado     Valor Consórcio       Valor Consórcio      Saldo Devedor      Data Vencimento Parcela       Vencimento Última Parcela",font="Verdana 8")
        tit.place(x=20,y=10)
        labelv.pack_forget()

        bback = tk.Button(self, text="Voltar", relief=GROOVE, bg="#455DD8", fg="white", font="Verdana 11",
                            command=lambda: controller.show_frame(StartPage))
        bback.place(x=50,y=340)

        lb1 = Label(self, text="Informe CPF do consumidor", font="Verdana 11")
        lb1.place(x=395,y=340)
  
        entradacpf = Entry(self, font="Verdana 11")
        entradacpf.place(x=400,y=370)

        infolabel = tk.Label(self)
        infolabel.pack_forget()

        bverif= tk.Button(self, text="Verificar", relief=GROOVE, bg="#455DD8", fg="white", font="Verdana 11",
                     command=ver)
        bverif.place(x=415,y=400)

        blimpar= tk.Button(self, text="Limpar", relief=GROOVE, bg="#455DD8", fg="white", font="Verdana 11",
                     command= refresh)
        blimpar.place(x=515,y=400)
        doclabel = tk.Label(self, text="Documento Comprobatório: ",font="Verdana 11")
        doclabel.place(x=100,y=500)
        bdoc = tk.Button(self, text="Selecionar", relief=GROOVE,command=doc, bg="#455DD8", fg="white", font="Verdana 11")
        bdoc.place(x=100,y=520)
        ok = tk.StringVar()
        ok.set('')
        oklabel = tk.Label(self,textvariable=ok,text="")
        lbinf= Label(self, text ="Situações Emergenciais: ",
                             font = "Verdana 11").place(x=500, y= 500)
        v = tk.IntVar()
        v.set(1)
        checkn = Radiobutton(self,text = "Desastre Natural",variable=v,value=1, font="Verdana 10").place(x=500, y =530)
        checkd = Radiobutton(self,text = "Desemprego",variable=v,value=2, font="Verdana 10").place(x=500, y=550)
        checkp = Radiobutton(self,text = "Pandemia",variable=v,value=3, font="Verdana 10").place(x=500, y=570)
        checks = Radiobutton(self,text = "Problemas de Saúde",variable=v,value=4, font="Verdana 10"). place(x=500, y = 590)

        bconc = tk.Button(self, text="Concluir", relief=GROOVE, bg="#455DD8", fg="white", font="Verdana 11",
                          command=concluir).place(x=700,y=600)

        

class PageTwo(tk.Frame):

    def __init__(self, parent, controller):
        tk.Frame.__init__(self, parent)
        label = tk.Label(self, text="Ajuda", font=LARGE_FONT)
        label.config(width=27,height=3,bg="#455DD8",fg="white")
        label.pack()

        bback = tk.Button(self, text="Voltar", relief=GROOVE, bg="#455DD8", fg="white", font="Verdana 11",
                            command=lambda: controller.show_frame(StartPage))
        bback.place(x=50,y=230)
        lbtitulo = tk.Label(self, text="Como usar a ferramenta", font=("Verdana 17"))
        lbtitulo.place(x=30,y=270)
        lbtitulo.config(width=120,anchor=W,justify=LEFT)
        lbp1 = tk.Label(self,text="Passo1 : Na Página Principal, clique no botão 'Começar'.", font=("Verdana 10"))
        lbp1.config(width=120, anchor=W)
        lbp1.place(x=30, y=335)
        lbp2 = tk.Label(self,text="Passo2 : Insira o CPF da pessoa solicitante no campo indicado, e aperte o botão 'Verificar'. Caso o CPF inserido não esteja na base de\ndados, será exibida a mensagem de CPF inválido.", font=("Verdana 10"))
        lbp2.config(width=120, anchor=W, justify=LEFT)
        lbp2.place(x=30, y=370)
        lbp3 = tk.Label(self,text="Passo3 : Com o CPF validado, aparecerá uma tabela com o histórico de pagamento do consumidor, para que o funcionário verifique se\nestá dentro dos padrões para prosseguir.", font=("Verdana 10"))
        lbp3.config(width=120, anchor=W, justify=LEFT)
        lbp3.place(x=30, y=420)
        lbp4 = tk.Label(self,text="Passo4 : Selecione o documento que comprova a necessidade do consumidor através do botão de importação de arquivo(verifique se o\ndocumento é válido antes de importar).", font=("Verdana 10"))
        lbp4.config(width=120, anchor=W, justify=LEFT)
        lbp4.place(x=30, y=470)
        lbp5 = tk.Label(self,text="Passo5 : Clique na Caixa de Seleção da situação emergencial na qual o consumidor se encontra.", font=("Verdana 10"))
        lbp5.config(width=120, anchor=W, justify=LEFT)
        lbp5.place(x=30, y=520)
        lbp6 = tk.Label(self,text="Passo6 : Clique no botão 'Concluir', e será exibida a Mensagem de Aprovação do cliente no Auxílio Emergencial Positivo.", font=("Verdana 10"))
        lbp6.config(width=120, anchor=W, justify=LEFT)
        lbp6.place(x=30, y=555)
        


app = AEP()
app.title("Auxílio Emergencial Positivo")
app.geometry("1000x700")
app.resizable(0,0)
app.iconbitmap("spc.ico")
app.mainloop()

