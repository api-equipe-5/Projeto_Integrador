from tkinter import *
from tkinter import messagebox
from tkinter import ttk
import ctypes
import pyodbc
byref = ctypes.byref
user32 = ctypes.windll.user32
import os.path
import os
from tkinter.filedialog import askopenfilename

#criar Nossa Janela
jan=Tk()
jan.title('JAVA PASTRY')
jan.geometry('370x300')
jan.configure(background = '#f0f0f0')
jan.resizable(width=False, height=False)


# FUNCOES DOS BOTOES
def ImportShapeFile():
    Tk().withdraw()  # we don't want a full GUI, so keep the root window from appearing
    sqlserver = '{SQL Server}'
    instancia_sql = input_servidor.get()
    database = input_database.get()
    tabela = 'area_imovel'
    usuario = input_usuario.get()
    senha = input_senha.get()
    print (usuario,senha,database,instancia_sql)
    shape = askopenfilename(title = "Select file",filetypes = (("SHAPEFILES","*.shp"),))
    print(instancia_sql, database, usuario, senha)
    # chama o ogr2ogr.exe e passa os parametros abaixo
    try:
        #DEFINIR VARIAVEIS DE AMBIENTE NO WINDOWDS PARA AS LIBS DO QGIS OSGEO
        command = f' setx PATH “%PATH%;C:\OSGeo4W64\\bin” '
        command = f' setx GDAL_DATA “C:\OSGeo4W64\share\gdal” '
        command = f' setx PROJ_LIB "C:\OSGeo4W64\share\proj"'
        command = f'setx PATH “%PATH%;C:\OSGeo4W\\bin”'
        command = f' setx GDAL_DATA “C:\OSGeo4W\share\gdal”'
        command = f'setx PROJ_LIB "C:\OSGeo4W\share\proj"'
        if instancia_sql == '' or database == '' or usuario == '' or senha == '':
            messagebox.showwarning(title='PREENCHA TODOS OS DADOS', message='Por favor preencha todos os dados')
        else:
            if shape != '':
                command = f'ogr2ogr -f "MSSQLSpatial" "MSSQL:server={instancia_sql};database={database};tables={tabela};UID={usuario};PWD={senha};driver={sqlserver}" "{shape}" -lco GEOMETRY_NAME=GEOM -lco GEOM_TYPE=GEOMETRY -nln "area_imovel" -a_srs "EPSG:4326" -overwrite -progress -skipfailures -lco UPLOAD_GEOM_FORMAT=wkb'
                messagebox.showwarning(title='BANCO DE DADOS', message='IMPORTANDO PARA O BANCO . CLIQUE OK')
                os.system(command)
                messagebox.showwarning(title='SUCESSO', message='Shapefile importado com sucesso para o banco de dados')
            else:
                messagebox.showwarning(title='ARQUIVO VAZIO', message='Por favor importe um arquivo valido')

        server = 'TERMINAL-19\MSSQLSERVER01'
        database = 'teste06'
        username = 'javapastry'
        password = 'javapastry'
        conn = pyodbc.connect(
            'DRIVER={ODBC Driver 17 for SQL Server};SERVER=' + server + ';DATABASE=' + database + ';UID=' + username + ';PWD=' + password)
        cursor = conn.cursor()
        conn.commit()
        cursor.execute(
            "insert into area_imovel2 select GEOM, cod_imovel,num_area,cod_estado,nom_munici,num_modulo,tipo_imove,situacao,condicao_i  from area_imovel")
        conn.commit()
    except:
        messagebox.showerror(title='ERRO', message='VERIFIQUE O ARQUIVO IMPORTADO')


def InstalarOsgeo():
    os.startfile('osgeo4w.exe')

def Mostrar_Variaveis():
    print(f'Servidor{input_servidor.get()} usuario {input_database.get()} senha {input_senha.get()}')

#LABELS

#SERVIDOR
input_servidor = Entry(width=20, bg='white', font=('Comic Sans MS', '10'))
input_servidor .place(x=130, y=120)
lb_servidor  = Label(font=('Arial', '11', 'bold'), fg='white', bg='#191970', text='SERVIDOR:')
lb_servidor.place(x=10, y=120)

#DATABASE
input_database= Entry(width=20, bg='white', font=('Comic Sans MS', '10'))
input_database.place(x=130, y=150)
lb_database = Label(font=('Arial', '11', 'bold'), fg='white', bg='#191970', text='DATABASE:')
lb_database.place(x=10, y=150)

#USUARIO
input_usuario = Entry(width=20, bg='white', font=('Comic Sans MS', '10'))
input_usuario.place(x=130, y=180)
lb_usuario = Label(font=('Arial', '11', 'bold'), fg='white', bg='#191970', text='USUARIO:')
lb_usuario.place(x=10, y=180)

#SENHA
input_senha = Entry(width=20, bg='white', font=('Comic Sans MS', '10'))
input_senha.place(x=130, y=210)
lb_senha = Label(font=('Arial', '11', 'bold'), fg='white', bg='#191970', text='SENHA:')
lb_senha.place(x=10, y=210)

BeaktButton = ttk.Button( text='SELECIONE SHAPEFILE',width=24,command= ImportShapeFile)
BeaktButton.place(x=25, y=10)

BeaktButton = ttk.Button(text='INSTALAR OSGEO4W',width=24,command= InstalarOsgeo)
BeaktButton.place(x=25, y=60)



jan.mainloop()