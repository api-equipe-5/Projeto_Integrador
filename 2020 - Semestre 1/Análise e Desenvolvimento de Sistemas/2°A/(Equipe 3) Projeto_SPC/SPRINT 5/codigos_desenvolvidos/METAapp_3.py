import tkinter as tkinter
from tkinter import *
from tkinter import filedialog, messagebox
import tkinter.ttk as ttk
import time
import threading

import fontes
import movimentacoes
import operacoes
import pagamentos
import time
import os
import shutil

class app_menu(object):
    
    def __init__(self):
        
        self.root = tkinter.Tk()
        self.root.geometry('550x350')
        self.root.configure(bg='white')
        
        self.root.title("Gerador de Relatórios - SPC Brasil")

        #TITULO DO MENU
        self.textMenu = Label(text="Selecione os arquivos para análise:",
                   bg="white",
                   font=("Arial", 12, 'bold'),
                   width=38,
                   height=3)
        self.textMenu.grid(row=0,column=1)

        #ROTULOS
        self.lblFNT = Label(self.root, text="STG_FNT_ITT", bg="white",)
        self.lblFNT.grid(row=1,column=0, sticky=E)

        self.lblMDL = Label(self.root, text="STG_MVT_CRD", bg="white")
        self.lblMDL.grid(row=3,column=0, sticky=E)

        self.lblMVT = Label(self.root, text="STG_MDL", bg="white",)
        self.lblMVT.grid(row=2,column=0, sticky=E)

        self.lblOPR = Label(self.root, text="STG_OPR_ITT", bg="white")
        self.lblOPR.grid(row=4,column=0, sticky=E)

        self.lblPGT = Label(self.root, text="STG_PGT", bg="white")
        self.lblPGT.grid(row=5,column=0, sticky=E)

        #ENTRADAS DE DADOS
        global entrada1
        entrada1 = self.entrada1 = Entry(self.root, width=55,
                 borderwidth=1,
                 relief="solid")
        self.entrada1.grid(row=1,column=1)

        global entrada2
        entrada2 = self.entrada2 = Entry(self.root, width=55,
                 borderwidth=1,
                 relief="solid")
        self.entrada2.grid(row=2,column=1)

        global entrada3
        entrada3 = self.entrada3 = Entry(self.root, width=55,
                 borderwidth=1,
                 relief="solid")
        self.entrada3.grid(row=3,column=1)

        global entrada4
        entrada4 = self.entrada4 = Entry(self.root, width=55,
                 borderwidth=1,
                 relief="solid")
        self.entrada4.grid(row=4,column=1)

        global entrada5
        entrada5 = self.entrada5 = Entry(self.root, width=55,
                 borderwidth=1,
                 relief="solid")
        self.entrada5.grid(row=5,column=1)

        #BOTOES
        self.btnEntrada1 = Button(self.root, text="Selecionar",                   
                   bg="white",
                   borderwidth=1,
                   relief="solid",
                   command=lambda:self.SelecionarArquivo(self.entrada1))
        self.btnEntrada1.grid(row=1,column=2, pady=5)
        
        self.btnEntrada2 = Button(self.root, text="Selecionar",
                   bg="white",
                   borderwidth=1,
                   relief="solid",
                   command=lambda:self.SelecionarArquivo(self.entrada2))
        self.btnEntrada2.grid(row=2,column=2, pady=5)

        self.btnEntrada3 = Button(self.root, text="Selecionar",
                   bg="white",
                   borderwidth=1,
                   relief="solid",
                   command=lambda:self.SelecionarArquivo(self.entrada3))
        self.btnEntrada3.grid(row=3,column=2, pady=5)

        self.btnEntrada4 = Button(self.root, text="Selecionar",
                   bg="white",
                   borderwidth=1,
                   relief="solid",                       
                   command=lambda:self.SelecionarArquivo(self.entrada4))
        self.btnEntrada4.grid(row=4,column=2, pady=5)

        self.btnEntrada5 = Button(self.root, text="Selecionar",
                   bg="white",
                   borderwidth=1,
                   relief="solid",
                   command=lambda:self.SelecionarArquivo(self.entrada5))
        self.btnEntrada5.grid(row=5,column=2, pady=5)

        self.btnGenerate = Button(self.root, text="Gerar Relatório",
                   bg="white",
                   borderwidth=1,
                   relief="solid",
                   command=self.inicia_thread)
        self.btnGenerate.grid(row=6,column=1, pady=5)

        #ROTULOS DA BARRA DE CARREGAMENTO
        global lbldialog
        lbldialog = self.lbldialog = Label(self.root, text="", bg="white")
        self.lbldialog.grid(row=7,column=1)

        global lbldialog2
        lbldialog2 = self.lbldialog2 = Label(self.root, text="", bg="white")
        self.lbldialog2.grid(row=9,column=1)

        #BARRA DE CARREGAMENTO
        self.progbar = ttk.Progressbar(self.root)
        self.progbar.config(maximum=4, mode='indeterminate')
        self.progbar.grid(row=8,column=1)

    def inicia_thread(self):
        self.btnGenerate['state'] = 'disable'
        self.progbar.start()
        self.thread_secundario = threading.Thread(target=GerarRelatorio)
        self.thread_secundario.start()
        self.root.after(50, self.checa_thread)

    def checa_thread(self):
        if self.thread_secundario.is_alive():
            self.root.after(50, self.checa_thread)
        else:
            self.progbar.stop()
            self.btnGenerate['state'] = 'normal'

    def SelecionarArquivo(self, entrada):
        filename = filedialog.askopenfilename(filetypes=(("Arquivos XLSX",".xlsx"),("Todos os Arquivos",".*")))
        entrada.insert(END, filename)

def GerarRelatorio():
    relatorio=filedialog.askdirectory()
    print (f"Pasta selecionada: {relatorio}")
    lbldialog.config(text=f"Pasta selecionada: {relatorio}")

    print ('Gerando relatórios, aguarde...')
    lbldialog.config(text='Gerando relatórios, aguarde...')

    css_string = '''/* global */


/* ------------------------------------------------------------------------------------------------------------------- */

body {
    font-family: "Open Sans", Arial, Helvetica, sans-serif;
    padding: 0;
    margin: 0;
    background: #DFDFDF;
} 

main {
    max-width: 100%;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    padding-bottom: 0.5px;
}

/* template's rules */


/* ------------------------------------------------------------------------------------------------------------------- */

.header {
    display: grid;
    grid-template-columns: 0.5fr 3fr;
    grid-template-areas: "sideMenu contentMenu";
    height: 50px;
    font-size: small;
}

/* where the metalicts title goes */
.metalitcs {
    background: #112244;
    color: #ffffff;
    grid-area: sideMenu;  
}

.metalitcs p {
    padding: 5px;
    margin-left: 20px;
}

/* where left and rightbox goes */
.location {
    background: #112244;
    color: #ffffff;
    box-shadow: -10px 0px 10px 0.5px rgba(0, 0, 0, 0.1);
    grid-area: contentMenu;
}

.leftbox { 
    float:left;  
    background:#112244; 
    width:25%; 
    height: 50px; 
}

.leftbox p {
    padding: 5px;
    margin-left: 10px;
}

.rightbox{ 
    float:left;  
    background:#112244;
    width: 25%;
    height: 50px;
    box-shadow: 0.25px 0px white, -0.25px 0px white;
} 

.rightbox p {
    padding: 5px;
    margin-left: 10px;
}

/* side menu and page's content */


/* ------------------------------------------------------------------------------------------------------------------- */

/* where side menu and page's content goes*/
.container {
    display: grid;
    grid-template-columns: 0.5fr 3fr;
    grid-template-areas: "menu-col content-col";
    font-size: small;
}

/* for side menu only */
.container-menu-col {
    margin-top: 30px;
}

/* where divs goes */
.menu-col {
    height: 100%;
    font-weight: bold;
    grid-area: menu-col;
}

/* where page's content goes */
.container-content-col {
    height: 100%;
    box-shadow: -5px 0px 100px 0px rgba(0, 0, 0, 0.1);
    overflow: hidden;
    grid-area: content-col;
}

/* dark blue divs */
.index {
    width: 100%;
    height: 50px;
    background: #112244;
    color: white;
    text-align: center;
    vertical-align: middle;
    line-height: 50px;
    box-shadow: 0px 1px 10px 0px rgba(0, 0, 0, 0.1), 0px -1px 10px 0px rgba(0, 0, 0, 0.1);
}
.index_two_rows p{
    width: 100%;
    height: 50px;
    background: #112244;
    color: white;
    text-align: center;
    vertical-align: middle;
    line-height: 15px;
    padding-top: 1rem;
    box-shadow: 0px 1px 10px 0px rgba(0, 0, 0, 0.1), 0px -1px 10px 0px rgba(0, 0, 0, 0.1);
}

/* light blue divs */
.stg-in {
    width: 100%;
    height: 50px;
    background: #3749E9;
    color: white;
    text-align: center;
    vertical-align: middle;
    line-height: 50px;
    box-shadow: 0px 1px 10px 0px rgba(0, 0, 0, 0.1), 0px -1px 10px 0px rgba(0, 0, 0, 0.1);
}

.stg-in:hover {
    background: rgba(116, 114, 115, 0.247);
    color: black;
}

/* white divs */
.stg {
    width: 100%;
    height: 50px;
    background: #ffffff;
    color: black;
    text-align: center;
    vertical-align: middle;
    line-height: 50px;
    box-shadow: 0px 1px 10px 0px rgba(0, 0, 0, 0.1), 0px -1px 10px 0px rgba(0, 0, 0, 0.1);
}

.stg:hover {
    background: rgba(116, 114, 115, 0.247);
}

/* rules for the graphs */


/* ------------------------------------------------------------------------------------------------------------------- */

.head {
    height: 40px;
    text-align: left;
    padding: 10px 0 0 10px;
    background: rgba(116, 114, 115, 0.247);
}

/* inside of head*/
.title {
    font-size: 10pt;
    font-weight: bold;
    color: #4e4e4e;
}

/* inside of head*/
.paragraph {
    font-size: 7pt;
    color: #707070;
}

/* imported graphs */
iframe {
    width: 100%;
    height: 100%;
    border-style: none;
}

.content {
    background: #ffffff;
    width: auto;
    height: 80%;
}

.table_value {
    font-size: 30pt;
    font-weight: bolder;
    color: #707070;
}

.table_content {
    background: #ffffff;
    width: auto;
    height: 80%;
    display: grid;
    justify-content: center;
    align-content: center;
}

.result_value {
    font-size: 12pt;
    font-weight: bolder;
    color: #707070;
}

.result_content {
    background: #ffffff;
    width: auto;
    height: 60%;
    display: grid;
    justify-content: center;
    align-content: center;
}

.indexMOD_value {
    font-size: 15pt;
    font-weight: bolder;
    color: #707070;
}

.indexMOD_content {
    background: #ffffff;
    width: auto;
    height: 60%;
    display: grid;
    justify-content: center;
    align-content: center;
}

/* graphs for grid */
/* the bonus graphs can be placed wherever you like to */


/* ------------------------------------------------------------------------------------------------------------------- */

.graph_one {
    background-color: #ffffff;
    grid-area: one;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_two {
    background-color: #ffffff;
    grid-area: two;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_three {
    background-color: #ffffff;
    grid-area: three;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_four {
    background-color: #ffff;
    grid-area: four;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_five {
    background-color: #ffffff;
    grid-area: five;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_six {
    background-color: #ffffff;
    grid-area: six;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_seven {
    background-color: #ffffff;
    grid-area: seven;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_eight {
    background-color: #ffffff;
    grid-area: eight;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_nine {
    background-color: #ffffff;
    grid-area: nine;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_ten {
    background-color: #ffffff;
    grid-area: ten;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_eleven {
    background-color: #ffffff;
    grid-area: eleven;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_twelve {
    background-color: #ffffff;
    grid-area: twelve;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_thirteen {
    background-color: #ffffff;
    grid-area: thirteen;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_fourteen {
    background-color: #ffffff;
    grid-area: fourteen;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_fifteen {
    background-color: #ffffff;
    grid-area: fifteen;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_sixteen {
    background-color: #ffffff;
    grid-area: sixteen;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_seventeen {
    background-color: #ffffff;
    grid-area: seventeen;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.graph_eighteen {
    background-color: #ffffff;
    grid-area: eighteen;
    box-shadow: 30px 0px 40px rgba(0, 0, 0, 0.1), -30px 0px 40px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

/* static and dynamic containers - no mediaquery*/
/* each page have it own container because of specific layout */

/* ------------------------------------------------------------------------------------------------------------------- */

/* static_graph_container is the same for all pages that requires it */
.static_graph_container_01 {
    display: grid;
    grid-template-columns: 1fr 1fr 3fr;
    grid-template-rows: 30vh 50vh 10vh;
    grid-gap: 10px;
    grid-template-areas: "one two three" 
                         "four four three";
    margin: 43px 50px 0px 50px;
}

.dynamic_graph_container_FNT {
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 70vh 70vh 70vh 70vh;
    grid-gap: 10px;
    grid-template-areas: "one two" 
                         "three three"
                         "four five" 
                         "six seven";
    margin: -60px 50px 50px 50px;
}

.dynamic_graph_container_MVT {
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 30vh 30vh 30vh 30vh;
    grid-gap: 10px;
    grid-template-areas: "one two"
                         "one three" 
                         "four three"
                         "four three";
    margin: -60px 50px 50px 50px;
}

.dynamic_graph_container_OPR {
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 30vh 30vh 30vh 30vh;
    grid-gap: 10px;
    grid-template-areas: "one two"
                         "one three" 
                         "four three"
                         "four three";
    margin: -60px 50px 50px 50px;
}

.dynamic_graph_container_PGT {
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 30vh 30vh 30vh 30vh;
    grid-gap: 10px;
    grid-template-areas: "one two"
                         "one three" 
                         "four three"
                         "four three";
    margin: -60px 50px 50px 50px;
}

.static_graph_container_02 {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
    grid-template-rows: 20vh;
    grid-gap: 10px;
    grid-template-areas: "one two three four five";
    margin: 43px 50px 0px 50px;
}

.dynamic_graph_container_result_MVT {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-template-rows: 80vh 80vh 80vh 80vh 80vh;
    grid-gap: 10px;
    grid-template-areas:
                         "one one one one"
                         "two two two two"
                         "three three three three"
                         "four four four four"
                         "five five five five";
    margin: 10px 50px 50px 50px;
}

.dynamic_graph_container_result_OPR {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-rows: 80vh 80vh 80vh 80vh 80vh;
    grid-gap: 10px;
    grid-template-areas: "one one two"
                         "three three three"
                         "four four four"
                         "five five five"
                         "six six six";
    margin: 10px 50px 50px 50px;
}

.static_graph_container_03 {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-template-rows: 20vh;
    grid-gap: 10px;
    grid-template-areas: "one two three four";
    margin: 43px 50px 0px 50px;
}

.dynamic_graph_container_result_PGT {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-template-rows: 80vh 50vh 80vh 80vh 80vh 80vh 80vh;
    grid-gap: 10px;
    grid-template-areas: "one one one one"
                         "two two three three"
                         "four four four four"
                         "five five five five"
                         "six six six six"
                         "seven seven seven seven"
                         "eight eight eight eight";
    margin: 10px 50px 50px 50px;
}

.dynamic_graph_container_index_MOD {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr 0.5fr;
    grid-template-rows: 20vh 30vh 30vh 30vh 20vh 30vh 30vh 30vh 20vh 30vh 30vh 30vh;
    grid-gap: 10px;
    grid-template-areas: "one two three four four"
                         "five five five four four"
                         "five five five six six"
                         "five five five six six"
                         
                         "seven eight nine ten ten"
                         "eleven eleven eleven ten ten"
                         "eleven eleven eleven twelve twelve"
                         "eleven eleven eleven twelve twelve"
                         
                         "thirteen fourteen fifteen sixteen sixteen"
                         "seventeen seventeen seventeen sixteen sixteen"
                         "seventeen seventeen seventeen eighteen eighteen"
                         "seventeen seventeen seventeen eighteen eighteen";
    margin: 43px 50px 50px 50px;
}

.dynamic_graph_container_index_MOD .title {
    font-size: 8pt;
}

.dynamic_graph_container_index_FaixaVAL {
    display: grid;
    grid-template-columns: 1fr;
    grid-template-rows: 100vh 180vh;
    grid-gap: 10px;
    grid-template-areas: "one"
                         "two";
    margin: 43px 50px 50px 50px;
}

'''
    
    f = open(relatorio + '/_style.css','w', encoding='utf-8')
    f.write(css_string)
    f.close()
    print ('O arquivo _style.css foi criado com sucesso!')
    lbldialog2.config(text='O arquivo _style.css foi criado com sucesso!')
    
    
    pags = "/pags"
    fonts = relatorio + "/fonts"
    pasta = relatorio + pags
    access_rights = 0o777
    try:
        os.mkdir(pasta, access_rights)
    except OSError:
        print (f"AVISO: Algo inesperado aconteceu ao criar a subpasta pags.")
        lbldialog2.config(text=f"AVISO: Algo inesperado aconteceu ao criar a subpasta pags.")
    else:
        print (f"A subpasta pags foi criada com sucesso!")
        lbldialog2.config(text=f"A subpasta pags foi criada com sucesso!")
    try:
        os.mkdir(fonts, access_rights)
    except OSError:
        print (f"AVISO: Algo inesperado aconteceu ao criar a subpasta fonts.")
        lbldialog2.config(text=f"AVISO: Algo inesperado aconteceu ao criar a subpasta fonts.")
    else:
        print (f"A subpasta fonts foi criada com sucesso!")
        lbldialog2.config(text=f"A subpasta fonts foi criada com sucesso!")

    original = './fonts/Open_Sans.zip'
    alvo = fonts + '/Open_Sans.zip'
    try:
        shutil.copyfile(original, alvo)
    except OSError:
        print (f"AVISO: Algo inesperado aconteceu ao criar o arquivo Open_Sans.zip.")
        lbldialog2.config(text=f"AVISO: Algo inesperado aconteceu ao criar o arquivo Open_Sans.zip.")
    else:
        print (f"O arquivo Open_Sans.zip foi criado com sucesso!")
        lbldialog2.config(text=f"O arquivo Open_Sans.zip foi criado com sucesso!")
    
    tabela_fnt = entrada1.get()
    tabela_mdl = entrada2.get()
    tabela_mvt = entrada3.get()
    tabela_opr = entrada4.get()
    tabela_pgt = entrada5.get()

    #BLOCO VALIDACAO
    try:
        lbldialog2.config(text='Gerando Relatório de Validação da Tabela STG_FNT_ITT...')
        fontes.validacao(relatorio, pasta, tabela_fnt)
    except FileNotFoundError:
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_FNT_ITT.\nO usuário não selecionou o arquivo.')
        raise 
    else:
        lbldialog2.config(text='O Relatório de Validação da Tabela STG_FNT_ITT foi criado com sucesso!')

    try:
        lbldialog2.config(text='Gerando Relatório de Validação da Tabela STG_MVT_CRD...')
        movimentacoes.validacao(relatorio, pasta, tabela_mvt, tabela_mdl, tabela_fnt)
    except FileNotFoundError:
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_MVT_CRD.\nCertifique-se que os arquivos STG_MVT_CRD, STG_FNT_ITT e STG_MDL foram incluídos.')
        raise
    else:
        lbldialog2.config(text='O Relatório de Validação da Tabela STG_MVT_CRD foi criado com sucesso!')

    try:
        lbldialog2.config(text='Gerando Relatório de Validação da Tabela STG_OPR_ITT...')
        operacoes.validacao(relatorio, pasta, tabela_opr, tabela_mdl, tabela_fnt)    
    except FileNotFoundError:
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_OPR_ITT.\nCertifique-se que os arquivos STG_OPR_ITT, STG_FNT_ITT e STG_MDL foram incluídos.')
        raise
    else:
        lbldialog2.config(text='O Relatório de Validação da Tabela STG_OPR_ITT foi criado com sucesso!')

    try:
        lbldialog2.config(text='Gerando Relatório de Validação da Tabela STG_PGT...')
        pagamentos.validacao(relatorio, pasta, tabela_pgt, tabela_mdl, tabela_fnt)  
    except FileNotFoundError:
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_PGT.\nCertifique-se que os arquivos STG_PGT, STG_FNT_ITT e STG_MDL foram incluídos.')
        raise
    else:
        lbldialog2.config(text='O Relatório de Validação da Tabela STG_PGT foi criado com sucesso!')

    #BLOCO RESULTADOS
    try:
        lbldialog2.config(text='Gerando Relatório de Resultados das Movimentações...')
        movimentacoes.resultados(relatorio, pasta, tabela_mvt, tabela_mdl)
    except FileNotFoundError:
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_MVT_CRD.\nCertifique-se que os arquivos STG_MVT_CRD e STG_MDL foram incluídos.')
        raise
    else:
        lbldialog2.config(text='O Relatório de Resultados das Movimentações foi criado com sucesso!')

    try:
        lbldialog2.config(text='Gerando Relatório de Resultados das Operações...')
        operacoes.resultados(relatorio, pasta, tabela_opr, tabela_mdl)
    except FileNotFoundError:
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_OPR_ITT.\nCertifique-se que os arquivos STG_OPR_ITT e STG_MDL foram incluídos.')
        raise
    else:
        lbldialog2.config(text='O Relatório de Resultados das Operações foi criado com sucesso!')

    try:
        lbldialog2.config(text='Gerando Relatório de Resultados dos Pagamentos...')
        pagamentos.resultados(relatorio, pasta, tabela_pgt, tabela_mdl)
    except FileNotFoundError:
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_PGT.\nCertifique-se que os arquivos STG_PGT e STG_MDL foram incluídos.')
        raise
    else:
        lbldialog2.config(text='O Relatório de Resultados dos Pagamentos foi criado com sucesso!')

    #BLOCO INDICES
    try:
        lbldialog2.config(text='Gerando Relatório dos Índices de Pagamentos em Dia...')
        pagamentos.indice_em_dia_geral(relatorio, pasta, tabela_pgt, tabela_mdl)
    except FileNotFoundError:
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_PGT.\nCertifique-se que os arquivos STG_PGT e STG_MDL foram incluídos.')
        raise
    else:
        lbldialog2.config(text='O Relatório dos Índices de Pagamentos em Dia foi criado com sucesso!')

    try:
        lbldialog2.config(text='Gerando Relatório do Índice do Número de Pagamentos por Cliente...')
        pagamentos.indice_pgt_por_cli(relatorio, pasta, tabela_pgt, tabela_mdl)
    except FileNotFoundError:
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_PGT.\nCertifique-se que os arquivos STG_PGT e STG_MDL foram incluídos.')
        raise
    else:
        lbldialog2.config(text='O Relatório do Índice do Número de Pagamentos\npor Cliente foi criado com sucesso!')
        
    lbldialog.config(text='Análise concluída com sucesso!')

    MsgBox = messagebox.askquestion ("Aviso", "Relatórios criados com sucesso!\nDeseja abrir a primeira página do relatório?")
    if MsgBox == 'yes':
        file_name = relatorio + "/table_FNT.html"
        os.startfile (file_name)

janela = app_menu()

janela.root.mainloop()
