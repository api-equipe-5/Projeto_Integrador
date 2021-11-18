import tkinter as tk
import tkinter.ttk as ttk
from tkinter import filedialog, messagebox
import threading
import os
import shutil
from PIL import ImageTk, Image
import fontes
import movimentacoes
import operacoes
import pagamentos

class app_menu(object):
    
    def __init__(self):
        
        self.root = tk.Tk()
        
        self.root.iconphoto(False, tk.PhotoImage(file='./imgs/icon.png'))

        window_height = 635
        window_width = 900

        screen_width = self.root.winfo_screenwidth()
        screen_height = self.root.winfo_screenheight()

        x_cordinate = int((screen_width/2) - (window_width/2))
        y_cordinate = int((screen_height/2) - (window_height/2))

        self.root.geometry("{}x{}+{}+{}".format(window_width, window_height, x_cordinate, y_cordinate))
        self.root.resizable(0, 0)
        self.root.title("METAapp")

        #IMAGEM LATERAL
        img_1 = './imgs/back.png'
        pil_img = Image.open(img_1)
        self.img = ImageTk.PhotoImage(pil_img.resize((450, 480), Image.ANTIALIAS))
        self.canvas = tk.Canvas(self.root, width=450, height=480, bd=0, highlightthickness=0, relief='ridge')
        self.canvas.place(relx=0.0, rely=0.0, height=480, width=450)
        self.bg = self.canvas.create_image(0, 0, anchor=tk.NW, image=self.img)

        #FRAMES
        self.frame_progresso = tk.Frame(self.root)
        self.frame_progresso.place(relx=0.0, rely=0.756, relheight=0.244, relwidth=1.024)
        self.frame_progresso.configure(relief='flat')
        self.frame_progresso.configure(borderwidth="2")
        self.frame_progresso.configure(background="#14141c")

        self.frame_menu = tk.Frame(self.root)
        self.frame_menu.place(relx=0.5, rely=0.0, relheight=0.756, relwidth=0.5)
        self.frame_menu.configure(relief='flat')
        self.frame_menu.configure(borderwidth="2")
        self.frame_menu.configure(background="#ffffff")

        #ROTULOS
        self.lbl_titulo_menu = tk.Label(self.frame_menu, font=('Segoe UI', 13, 'bold'))
        self.lbl_titulo_menu.place(x=225, rely=0.083, anchor="center")
        self.lbl_titulo_menu.configure(background="#ffffff")
        self.lbl_titulo_menu.configure(foreground="#000000")
        self.lbl_titulo_menu.configure(text='''Selecione os arquivos para análise:''')

        self.lbl_FNT = tk.Label(self.frame_menu, font=('Segoe UI', 9, 'bold'))
        self.lbl_FNT.place(relx=0.056, rely=0.177, height=21)
        self.lbl_FNT.configure(background="#ffffff")
        self.lbl_FNT.configure(foreground="#000000")
        self.lbl_FNT.configure(text='''STG_FNT_ITT''')

        self.lbl_MDL = tk.Label(self.frame_menu, font=('Segoe UI', 9, 'bold'))
        self.lbl_MDL.place(relx=0.056, rely=0.302, height=21)
        self.lbl_MDL.configure(background="#ffffff")
        self.lbl_MDL.configure(foreground="#000000")
        self.lbl_MDL.configure(text='''STG_MDL''')

        self.lbl_MVT = tk.Label(self.frame_menu, font=('Segoe UI', 9, 'bold'))
        self.lbl_MVT.place(relx=0.056, rely=0.427, height=21)
        self.lbl_MVT.configure(background="#ffffff")
        self.lbl_MVT.configure(foreground="#000000")
        self.lbl_MVT.configure(text='''STG_MVT_CRD''')

        self.lbl_OPR = tk.Label(self.frame_menu, font=('Segoe UI', 9, 'bold'))
        self.lbl_OPR.place(relx=0.056, rely=0.552, height=21)
        self.lbl_OPR.configure(background="#ffffff")
        self.lbl_OPR.configure(foreground="#000000")
        self.lbl_OPR.configure(text='''STG_OPR_ITT''')

        self.lbl_PGT = tk.Label(self.frame_menu, font=('Segoe UI', 9, 'bold'))
        self.lbl_PGT.place(relx=0.056, rely=0.677, height=21)
        self.lbl_PGT.configure(background="#ffffff")
        self.lbl_PGT.configure(foreground="#000000")
        self.lbl_PGT.configure(text='''STG_PGT''')

        global lbldialog        
        lbldialog = self.lbldialog = tk.Label(self.frame_progresso, font=('Segoe UI', 9, 'bold'))
        self.lbldialog.configure(background="#14141c")
        self.lbldialog.configure(foreground="white")
        self.lbldialog.configure(text='''''')
        self.lbldialog.place(x=450, rely=0.219, anchor="center")
        
        global lbldialog2
        lbldialog2 = self.lbldialog2 = tk.Label(self.frame_progresso, font=('Segoe UI', 9, 'bold'))
        self.lbldialog2.configure(background="#14141c")
        self.lbldialog2.configure(foreground="white")
        self.lbldialog2.configure(text='''''')
        self.lbldialog2.place(x=450, rely=0.645, anchor="center")

        #BARRA DE PROGRESSO
        style = ttk.Style()
        style.theme_use('alt')
        style.configure("bar.Horizontal.TProgressbar", foreground='white', background='#0051ff',
                        troughcolor='#0051ff', troughrelief = 'flat')
        self.progbar = ttk.Progressbar(self.frame_progresso, length=800, style='bar.Horizontal.TProgressbar')
        self.progbar.config(maximum=4, mode='indeterminate')
        self.progbar.place(x=450, rely=0.419, width=900, height=25, anchor="center")

        #ENTRADAS DE DADOS
        global entrada1    
        entrada1 = self.entrada1 = tk.Entry(self.frame_menu, relief="solid")
        self.entrada1.place(relx=0.056, rely=0.229,height=25, relwidth=0.667)
        self.entrada1.configure(background="white")
        self.entrada1.configure(foreground="#000000")

        global entrada2
        entrada2 = self.entrada2 = tk.Entry(self.frame_menu, relief="solid")
        self.entrada2.place(relx=0.056, rely=0.354,height=25, relwidth=0.667)
        self.entrada2.configure(background="white")
        self.entrada2.configure(foreground="#000000")

        global entrada3
        entrada3 = self.entrada3 = tk.Entry(self.frame_menu, relief="solid")
        self.entrada3.place(relx=0.056, rely=0.479,height=25, relwidth=0.667)
        self.entrada3.configure(background="white")
        self.entrada3.configure(foreground="#000000")

        global entrada4
        entrada4 = self.entrada4 = tk.Entry(self.frame_menu, relief="solid")
        self.entrada4.place(relx=0.056, rely=0.604,height=25, relwidth=0.667)
        self.entrada4.configure(background="white")
        self.entrada4.configure(foreground="#000000")

        global entrada5
        entrada5 = self.entrada5 = tk.Entry(self.frame_menu, relief="solid")
        self.entrada5.place(relx=0.056, rely=0.729,height=25, relwidth=0.667)
        self.entrada5.configure(background="white")
        self.entrada5.configure(foreground="#000000")

        #BOTOES
        self.btn_FNT = tk.Button(self.frame_menu, font=('Segoe UI', 9, 'bold'), bd=0, command=lambda:self.SelecionarArquivo(self.entrada1))
        self.btn_FNT.place(relx=0.744, rely=0.229, height=25, width=90)
        self.btn_FNT.configure(activebackground="#ececec")
        self.btn_FNT.configure(activeforeground="#000000")
        self.btn_FNT.configure(background="#14141c")
        self.btn_FNT.configure(disabledforeground="#a3a3a3")
        self.btn_FNT.configure(foreground="white")
        self.btn_FNT.configure(pady="0")
        self.btn_FNT.configure(relief="flat")
        self.btn_FNT.configure(text='''SELECIONAR''')
        
        self.btn_MDL = tk.Button(self.frame_menu, font=('Segoe UI', 9, 'bold'), bd=0, command=lambda:self.SelecionarArquivo(self.entrada2))
        self.btn_MDL.place(relx=0.744, rely=0.354, height=25, width=90)
        self.btn_MDL.configure(activebackground="#ececec")
        self.btn_MDL.configure(activeforeground="#000000")
        self.btn_MDL.configure(background="#14141c")
        self.btn_MDL.configure(disabledforeground="#a3a3a3")
        self.btn_MDL.configure(foreground="white")
        self.btn_MDL.configure(pady="0")
        self.btn_MDL.configure(relief="flat")
        self.btn_MDL.configure(text='''SELECIONAR''')

        self.btn_MVT = tk.Button(self.frame_menu, font=('Segoe UI', 9, 'bold'), bd=0, command=lambda:self.SelecionarArquivo(self.entrada3))
        self.btn_MVT.place(relx=0.744, rely=0.479, height=25, width=90)
        self.btn_MVT.configure(activebackground="#ececec")
        self.btn_MVT.configure(activeforeground="#000000")
        self.btn_MVT.configure(background="#14141c")
        self.btn_MVT.configure(disabledforeground="#a3a3a3")
        self.btn_MVT.configure(foreground="white")
        self.btn_MVT.configure(pady="0")
        self.btn_MVT.configure(relief="flat")
        self.btn_MVT.configure(text='''SELECIONAR''')

        self.btn_OPR = tk.Button(self.frame_menu, font=('Segoe UI', 9, 'bold'), bd=0, command=lambda:self.SelecionarArquivo(self.entrada4))
        self.btn_OPR.place(relx=0.744, rely=0.604, height=24, width=90)
        self.btn_OPR.configure(activebackground="#ececec")
        self.btn_OPR.configure(activeforeground="#000000")
        self.btn_OPR.configure(background="#14141c")
        self.btn_OPR.configure(disabledforeground="#a3a3a3")
        self.btn_OPR.configure(foreground="white")
        self.btn_OPR.configure(pady="0")
        self.btn_OPR.configure(relief="flat")
        self.btn_OPR.configure(text='''SELECIONAR''')

        self.btn_PGT = tk.Button(self.frame_menu, font=('Segoe UI', 9, 'bold'), bd=0, command=lambda:self.SelecionarArquivo(self.entrada5))
        self.btn_PGT.place(relx=0.744, rely=0.729, height=25, width=90)
        self.btn_PGT.configure(activebackground="#ececec")
        self.btn_PGT.configure(activeforeground="#000000")
        self.btn_PGT.configure(background="#14141c")
        self.btn_PGT.configure(disabledforeground="#a3a3a3")
        self.btn_PGT.configure(foreground="white")
        self.btn_PGT.configure(pady="0")
        self.btn_PGT.configure(relief="flat")
        self.btn_PGT.configure(text='''SELECIONAR''')

        self.btnGenerate = tk.Button(self.frame_menu, font=('Segoe UI', 13, 'bold'), bd=0, command=self.inicia_thread)
        self.btnGenerate.place(relx=0.567, rely=0.833, height=35, width=170)
        self.btnGenerate.configure(activebackground="#ececec")
        self.btnGenerate.configure(activeforeground="#000000")
        self.btnGenerate.configure(background="#0051ff")
        self.btnGenerate.configure(disabledforeground="#a3a3a3")
        self.btnGenerate.configure(foreground="white")
        self.btnGenerate.configure(pady="0")
        self.btnGenerate.configure(relief="flat")
        self.btnGenerate.configure(text='''Gerar Relatórios''')

    def inicia_thread(self):
        self.btn_FNT['state'] = 'disable'
        self.btn_MDL['state'] = 'disable'
        self.btn_MVT['state'] = 'disable'
        self.btn_OPR['state'] = 'disable'
        self.btn_PGT['state'] = 'disable'
        self.btnGenerate['state'] = 'disable'
        
        style = ttk.Style()
        style.theme_use('alt')
        style.configure("bar.Horizontal.TProgressbar", foreground='white', background='#0051ff',
                        troughcolor='white', troughrelief = 'flat')
        self.progbar = ttk.Progressbar(self.frame_progresso, length=800, style='bar.Horizontal.TProgressbar')
        self.progbar.config(maximum=4, mode='indeterminate')
        self.progbar.place(x=450, rely=0.419, width=900, height=25, anchor="center")
        
        self.progbar.start()
        self.thread_secundario = threading.Thread(target=GerarRelatorio)
        self.thread_secundario.start()
        self.root.after(50, self.checa_thread)

    def checa_thread(self):
        if self.thread_secundario.is_alive():
            self.root.after(50, self.checa_thread)
        else:
            self.progbar.stop()

            style = ttk.Style()
            style.theme_use('alt')
            style.configure("bar.Horizontal.TProgressbar", foreground='#0051ff', background='#0051ff',
                            troughcolor='#0051ff', troughrelief = 'flat')
            self.progbar = ttk.Progressbar(self.frame_progresso, length=800, style='bar.Horizontal.TProgressbar')
            self.progbar.config(maximum=4, mode='indeterminate')
            self.progbar.place(x=450, rely=0.419, width=900, height=25, anchor="center")
        
            self.btn_FNT['state'] = 'normal'
            self.btn_MDL['state'] = 'normal'
            self.btn_MVT['state'] = 'normal'
            self.btn_OPR['state'] = 'normal'
            self.btn_PGT['state'] = 'normal'
            self.btnGenerate['state'] = 'normal'

    def SelecionarArquivo(self, entrada):
        entrada.delete(0, 'end')
        filename = filedialog.askopenfilename(filetypes=(("Arquivos XLSX",".xlsx"),("Todos os Arquivos",".*")))
        entrada.insert(0, filename)

def GerarRelatorio():
    relatorio=filedialog.askdirectory()
    print (f"Pasta selecionada: {relatorio}")
    lbldialog.config(text=f"Pasta selecionada: {relatorio}")

    print ('Gerando relatórios, aguarde...')
    lbldialog.config(text='Gerando relatórios, aguarde...')   
    
    content = "/content"
    fonts = relatorio + "/fonts"
    pasta = relatorio + content
    access_rights = 0o777
    try:
        os.mkdir(pasta, access_rights)
    except OSError:
        print (f"AVISO: Algo inesperado aconteceu ao criar a subpasta content.")
        lbldialog2.config(text=f"AVISO: Algo inesperado aconteceu ao criar a subpasta content.")
    else:
        print (f"A subpasta content foi criada com sucesso!")
        lbldialog2.config(text=f"A subpasta content foi criada com sucesso!")
    try:
        os.mkdir(fonts, access_rights)
    except OSError:
        print (f"AVISO: Algo inesperado aconteceu ao criar a subpasta fonts.")
        lbldialog2.config(text=f"AVISO: Algo inesperado aconteceu ao criar a subpasta fonts.")
    else:
        print (f"A subpasta fonts foi criada com sucesso!")
        lbldialog2.config(text=f"A subpasta fonts foi criada com sucesso!")

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

    original = './imgs/favicon.png'
    alvo = pasta + '/favicon.png'
    try:
        shutil.copyfile(original, alvo)
    except OSError:
        print (f"AVISO: Algo inesperado aconteceu ao criar o arquivo favicon.png.")
        lbldialog2.config(text=f"AVISO: Algo inesperado aconteceu ao criar o arquivo favicon.png.")
    else:
        print (f"O arquivo favicon.png foi criado com sucesso!")
        lbldialog2.config(text=f"O arquivo favicon.png foi criado com sucesso!")

    f = open(pasta + '/style.css','w', encoding='utf-8')
    f.write(css_string)
    f.close()
    print ('O arquivo style.css foi criado com sucesso!')
    lbldialog2.config(text='O arquivo style.css foi criado com sucesso!')

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
        lbldialog.config(text='A geração de relatórios foi interrompida.')
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_FNT_ITT.\nO usuário não selecionou o arquivo.')
        raise 
    else:
        lbldialog2.config(text='O Relatório de Validação da Tabela STG_FNT_ITT foi criado com sucesso!')

    try:
        lbldialog2.config(text='Gerando Relatório de Validação da Tabela STG_MVT_CRD...')
        movimentacoes.validacao(relatorio, pasta, tabela_mvt, tabela_mdl, tabela_fnt)
    except FileNotFoundError:
        lbldialog.config(text='A geração de relatórios foi interrompida.')
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_MVT_CRD.\nCertifique-se que os arquivos STG_MVT_CRD, STG_FNT_ITT e STG_MDL foram incluídos.')
        raise
    else:
        lbldialog2.config(text='O Relatório de Validação da Tabela STG_MVT_CRD foi criado com sucesso!')

    try:
        lbldialog2.config(text='Gerando Relatório de Validação da Tabela STG_OPR_ITT...')
        operacoes.validacao(relatorio, pasta, tabela_opr, tabela_mdl, tabela_fnt)    
    except FileNotFoundError:
        lbldialog.config(text='A geração de relatórios foi interrompida.')
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_OPR_ITT.\nCertifique-se que os arquivos STG_OPR_ITT, STG_FNT_ITT e STG_MDL foram incluídos.')
        raise
    else:
        lbldialog2.config(text='O Relatório de Validação da Tabela STG_OPR_ITT foi criado com sucesso!')

    try:
        lbldialog2.config(text='Gerando Relatório de Validação da Tabela STG_PGT...')
        pagamentos.validacao(relatorio, pasta, tabela_pgt, tabela_mdl, tabela_fnt)  
    except FileNotFoundError:
        lbldialog.config(text='A geração de relatórios foi interrompida.')
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_PGT.\nCertifique-se que os arquivos STG_PGT, STG_FNT_ITT e STG_MDL foram incluídos.')
        raise
    else:
        lbldialog2.config(text='O Relatório de Validação da Tabela STG_PGT foi criado com sucesso!')

    #BLOCO RESULTADOS
    try:
        lbldialog2.config(text='Gerando Relatório de Resultados das Movimentações...')
        movimentacoes.resultados(relatorio, pasta, tabela_mvt, tabela_mdl)
    except FileNotFoundError:
        lbldialog.config(text='A geração de relatórios foi interrompida.')
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_MVT_CRD.\nCertifique-se que os arquivos STG_MVT_CRD e STG_MDL foram incluídos.')
        raise
    else:
        lbldialog2.config(text='O Relatório de Resultados das Movimentações foi criado com sucesso!')

    try:
        lbldialog2.config(text='Gerando Relatório de Resultados das Operações...')
        operacoes.resultados(relatorio, pasta, tabela_opr, tabela_mdl)
    except FileNotFoundError:
        lbldialog.config(text='A geração de relatórios foi interrompida.')
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_OPR_ITT.\nCertifique-se que os arquivos STG_OPR_ITT e STG_MDL foram incluídos.')
        raise
    else:
        lbldialog2.config(text='O Relatório de Resultados das Operações foi criado com sucesso!')

    try:
        lbldialog2.config(text='Gerando Relatório de Resultados dos Pagamentos...')
        pagamentos.resultados(relatorio, pasta, tabela_pgt, tabela_mdl)
    except FileNotFoundError:
        lbldialog.config(text='A geração de relatórios foi interrompida.')
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_PGT.\nCertifique-se que os arquivos STG_PGT e STG_MDL foram incluídos.')
        raise
    else:
        lbldialog2.config(text='O Relatório de Resultados dos Pagamentos foi criado com sucesso!')

    #BLOCO INDICES
    try:
        lbldialog2.config(text='Gerando Relatório dos Índices de Pagamentos em Dia...')
        pagamentos.indice_em_dia_geral(relatorio, pasta, tabela_pgt, tabela_mdl)
    except FileNotFoundError:
        lbldialog.config(text='A geração de relatórios foi interrompida.')
        lbldialog2.config(text='Erro: Falha ao analisar o arquivo STG_PGT.\nCertifique-se que os arquivos STG_PGT e STG_MDL foram incluídos.')
        raise
    else:
        lbldialog2.config(text='O Relatório dos Índices de Pagamentos em Dia foi criado com sucesso!')

    try:
        lbldialog2.config(text='Gerando Relatório do Índice do Número de Pagamentos por Cliente...')
        pagamentos.indice_pgt_por_cli(relatorio, pasta, tabela_pgt, tabela_mdl)
    except FileNotFoundError:
        lbldialog.config(text='A geração de relatórios foi interrompida.')
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
