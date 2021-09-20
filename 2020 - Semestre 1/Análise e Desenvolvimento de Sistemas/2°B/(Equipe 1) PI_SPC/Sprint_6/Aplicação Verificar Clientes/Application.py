from GUI import *
import Backend as core
import smtplib
from email.mime.text import MIMEText

app = None

def view_command():
    rows = core.view()
    app.listClientes.delete(0, END)
    for r in rows:
        app.listClientes.insert(END, r)

def search_command():
    app.listClientes.delete(0, END)
    rows = core.search(app.txtNome.get(), app.txtScore.get(), app.txtEmail.get(), app.txtCPF.get())
    for r in rows:
        app.listClientes.insert(END, r)
    return print(rows)

def insert_command():
    core.insert(app.txtNome.get(), app.txtScore.get(), app.txtEmail.get(), app.txtCPF.get())
    view_command()

def update_command():
    core.update(selected[0],app.txtNome.get(),app.txtScore.get(),app.txtEmail.get(), app.txtCPF.get())
    view_command()

def del_command():
    id = selected[0]
    core.delete(id)
    view_command()

import ctypes
def Mbox(title, text, style):
    return ctypes.windll.user32.MessageBoxW(0, text, title, style)

def email_command():
    app.listClientes.delete(0, END)
    rows = core.search(app.txtNome.get(), app.txtScore.get(), app.txtEmail.get(), app.txtCPF.get())
    for r in rows:
        app.listClientes.insert(END, r)

    smtp_ssl_host = 'smtp.gmail.com'
    smtp_ssl_port = 465
    username = 'spcbrasilpi@gmail.com'
    password = 'spcbrasilpi3452'

    from_addr   = 'spcbrasilpi@gmail.com'
    to_addrs    = app.txtEmail.get()
    scoreemail  = str(app.txtScore.get())
    nomecliente = str(app.txtNome.get())
    
    if int(scoreemail)<300:
        message = MIMEText('------------SPC Brasil--------------- \n'
                           'Saudações:'+ nomecliente +'\n'
                           'Informamos que seu score apresenta queda recorrente, seu score atual é de: '+ scoreemail +'\n'
                           'confira o nosso site para obter mais informações sobre o que é o seu score: https://guilherme4garcia.github.io/PI_SPC/')
        message['subject'] = app.txtNome.get()
        message['from'] = from_addr
        message['to'] = ', '.join(to_addrs)

    elif int(scoreemail)<600:
        message = MIMEText('------------SPC Brasil--------------- \n'
                           'Saudações:'+ nomecliente +'\n'
                           'Informamos que seu score está mediano, sua situação atual é de: '+ scoreemail +' pontos\n'
                           'confira o nosso site para obter mais informações sobre o que é o seu score: https://guilherme4garcia.github.io/PI_SPC/')
        message['subject'] = app.txtNome.get()
        message['from'] = from_addr
        message['to'] = ', '.join(to_addrs)

    else:
        message = MIMEText('------------SPC Brasil--------------- \n'
                           'Saudações:'+ nomecliente +'\n'
                           'Informamos que seu score está bom, sua situação atual é de: '+ scoreemail +' pontos\n'
                           'confira o nosso site para obter mais informações sobre o que é o seu score: https://guilherme4garcia.github.io/PI_SPC/')
        message['subject'] = app.txtNome.get()
        message['from'] = from_addr
        message['to'] = ', '.join(to_addrs)

    server = smtplib.SMTP_SSL(smtp_ssl_host, smtp_ssl_port)
    server.login(username, password)
    server.sendmail(from_addr, to_addrs, message.as_string())
    server.quit()
    Mbox('email enviado', 'Email enviado com sucesso', 0)
    return print(rows)

def getSelectedRow(event):
    scoredefin = int(app.txtScore.get())
    global selected
    index = app.listClientes.curselection()[0]
    selected = app.listClientes.get(index)
    app.entNome.delete(0, END)
    app.entNome.insert(END, selected[1])
    app.entScore.delete(0, END)
    app.entScore.insert(END, selected[2])
    app.entEmail.delete(0, END)
    app.entEmail.insert(END, selected[3])
    app.entCPF.delete(0, END)
    app.entCPF.insert(END, selected[4])
    if scoredefin<300:
        app.scoredefinido.set("queda")
        app.lblSituacaodef.configure(foreground ='red')
    elif scoredefin<600:
        app.scoredefinido.set("estável")
        app.lblSituacaodef.configure(foreground ='yellow')
    else:
        app.scoredefinido.set("positiva")
        app.lblSituacaodef.configure(foreground ='green')
    return selected

if __name__ == "__main__":
    app = Gui()
    app.listClientes.bind('<<ListboxSelect>>', getSelectedRow)
    app.btnViewAll.configure(command=view_command)
    app.btnBuscar.configure(command=search_command)
    app.btnInserir.configure(command=insert_command)
    app.btnUpdate.configure(command=update_command)
    app.btnDel.configure(command=del_command)
    app.btnClose.configure(command=app.window.destroy)
    app.btnEnviarEmail.configure(command=email_command)
    app.run()
