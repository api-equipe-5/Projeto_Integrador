from tkinter import *

class Gui():
    """Classe que define a interface gráfica da aplicação
    """
    x_pad = 5
    y_pad = 3
    width_entry = 30


    #Criando a janela...
    window          = Tk()
    window.wm_title("Verificar e Notificar Clientes")
    window['bg'] = '#2b2b2b'
    window.iconbitmap('spc.ico')

    #Criando variáveis que armazenarão o texto inserido pelo usuário...
    txtNome         = StringVar()
    txtScore        = IntVar()
    txtEmail        = StringVar()
    txtCPF          = StringVar()
    scoredefinido   = StringVar()


    #Criando os objetos que estarão na janela...
    lblnothing     = Label(window, text="", background='#2b2b2b')
    lblnome        = Label(window, text="Nome", background='#2b2b2b', font=('times new roman', 10), foreground=('white'))
    lblscore       = Label(window, text="Score", background='#2b2b2b', font=('times new roman', 10), foreground=('white'))
    lblemail       = Label(window, text="Email", background='#2b2b2b', font=('times new roman', 10), foreground=('white'))
    lblcpf         = Label(window, text="CPF", background='#2b2b2b', font=('times new roman', 10), foreground=('white'))
    lblSituacao    = Label(window, text="Situação: ", background='#2b2b2b', font=('times new roman', 10), foreground=('white'))
    lblSituacaodef = Label(window, textvariable=scoredefinido, background='#2b2b2b', font=('times new roman', 15, 'bold'), foreground=('white'))
    entNome        = Entry(window, textvariable=txtNome, width=width_entry)
    entScore       = Entry(window, textvariable=txtScore, width=width_entry)
    entEmail       = Entry(window, textvariable=txtEmail, width=width_entry)
    entCPF         = Entry(window, textvariable=txtCPF, width=width_entry)
    listClientes   = Listbox(window, width=120)
    scrollClientes = Scrollbar(window)
    btnViewAll     = Button(window, text="Ver todos", background='#8a8a8a', font=('century gothic', 10, 'bold'))
    btnBuscar      = Button(window, text="Buscar", background='#8a8a8a', font=('century gothic', 10, 'bold'))
    btnInserir     = Button(window, text="Inserir", background='#8a8a8a', font=('century gothic', 10, 'bold'))
    btnUpdate      = Button(window, text="Atualizar Selecionados", background='#8a8a8a', font=('century gothic', 10, 'bold'))
    btnDel         = Button(window, text="Deletar Selecionados", background='#8a8a8a', font=('century gothic', 10, 'bold'))
    btnClose       = Button(window, text="Fechar", background='red', font=('century gothic', 10, 'bold'))
    btnEnviarEmail = Button(window, text="Enviar Email ao Selecionados", background='#8a8a8a', font=('century gothic', 10, 'bold'))

    #Associando os objetos a grid da janela...
    lblnome.grid(row=0,column=0)
    lblscore.grid(row=1,column=0)
    lblemail.grid(row=2,column=0)
    lblcpf.grid(row=3,column=0)
    lblSituacao.grid(row=4,column=0)
    lblSituacaodef.grid(row=4,column=1)
    entNome.grid(row=0, column=1, padx=50, pady=50)
    entScore.grid(row=1, column=1)
    entEmail.grid(row=2, column=1)
    entCPF.grid(row=3, column=1)
    listClientes.grid(row=0, column=2, rowspan=15)
    scrollClientes.grid(row=0, column=6, rowspan=15)
    btnViewAll.grid(row=5, column=0, columnspan=2)
    btnBuscar.grid(row=6, column=0, columnspan=2)
    btnInserir.grid(row=7, column=0, columnspan=2)
    btnUpdate.grid(row=8, column=0, columnspan=2)
    btnDel.grid(row=9, column=0, columnspan=2)
    btnEnviarEmail.grid(row=10, column=0, columnspan=2)
    lblnothing.grid(row=11, column=0, columnspan=2)
    btnClose.grid(row=12, column=0, columnspan=2)


    #Associando a Scrollbar com a Listbox...
    listClientes.configure(yscrollcommand=scrollClientes.set)
    scrollClientes.configure(command=listClientes.yview)


    #Adicionando um pouco de SWAG a interface...
    for child in window.winfo_children():
        widget_class = child.__class__.__name__
        if widget_class == "Button":
            child.grid_configure(sticky='WE', padx=x_pad, pady=y_pad)
        elif widget_class == "Listbox":
            child.grid_configure(padx=0, pady=0, sticky='NS')
        elif widget_class == "Scrollbar":
            child.grid_configure(padx=0, pady=0, sticky='NS')
        else:
            child.grid_configure(padx=x_pad, pady=y_pad, sticky='N')




    def run(self):
        Gui.window.mainloop()
