# -*- encoding: utf-8 -*-

# Python modules
import os, logging 

# Flask modules
from flask               import render_template, request, url_for, redirect, send_from_directory, flash
from flask_login         import login_user, logout_user, current_user, login_required
from werkzeug.exceptions import HTTPException, NotFound, abort
from werkzeug.utils      import secure_filename

# App modules
from app        import app, lm, db, bc
from app.models import User
from app.forms  import LoginForm, RegisterForm
from controller import *


# provide login manager with load_user callback
@lm.user_loader
def load_user(user_id):
    return User.query.get(int(user_id))


@app.route('/wait')
def wait():
    return "Aguarde enquanto os novos dados são processados. Assim que terminar, você será redirecionado à página inicial"


@app.route('/update')
def update():
    wait()
    return tables()


# Logout user
@app.route('/logout.html')
def logout():
    logout_user()
    return redirect(url_for('index'))


# Register a new user
@app.route('/register.html', methods=['GET', 'POST'])
def register():
    
    # cut the page for authenticated users
    if current_user.is_authenticated:
        return redirect('/tables.html')

    # declare the Registration Form
    form = RegisterForm(request.form)

    msg = None

    if request.method == 'GET': 

        return render_template( 'pages/register.html', form=form, msg=msg )

    # check if both http method is POST and form is valid on submit
    if form.validate_on_submit():

        # assign form data to variables
        username = request.form.get('username', '', type=str)
        password = request.form.get('password', '', type=str) 
        email    = request.form.get('email'   , '', type=str) 

        # filter User out of database through username
        user = User.query.filter_by(user=username).first()

        # filter User out of database through username
        user_by_email = User.query.filter_by(email=email).first()

        if user or user_by_email:
            msg = 'Usuário já existente!'
        
        else:         

            pw_hash = password #bc.generate_password_hash(password)

            user = User(username, email, pw_hash)

            user.save()

            msg = 'USUÁRIO CRIADO COM SUCESSO <a href="' + url_for('login') + '">login</a>'     

    else:
        msg = 'Erro de entrada'     

    return render_template( 'pages/register.html', form=form, msg=msg )

# Authenticate user
@app.route('/login.html', methods=['GET', 'POST'])
def login():
    
    # cut the page for authenticated users
    if current_user.is_authenticated:
        return redirect('/tables.html')
            
    # Declare the login form
    
    form = LoginForm(request.form)

    # Flask message injected into the page, in case of any errors
    msg = None

    # check if both http method is POST and form is valid on submit
    if form.validate_on_submit():

        # assign form data to variables
        username = request.form.get('username', '', type=str)
        password = request.form.get('password', '', type=str) 

        # filter User out of database through username
        user = User.query.filter_by(user=username).first()

        if user:
            
            #if bc.check_password_hash(user.password, password):
            if user.password == password:
                login_user(user)
                return redirect('/tables.html')
            else:
                msg = "Senha incorreta. Por favor, tente novamente."
        else:
            msg = "Usuário não cadastrado."

    return render_template( 'pages/login.html', form=form, msg=msg )

@app.route('/screen2.html')
def screen2():
    return render_template('pages/screen2.html')

UPLOAD_FOLDER = os.path.join(os.getcwd(), 'Dados/Importados')

@app.route('/upload', methods=['GET', 'POST'])
def upload():
    # A variável "file" recebe o arquivo vindo da requisição
    file = request.files['inputFile']
    savePath = os.path.join(UPLOAD_FOLDER, secure_filename(file.filename))
    file.save(savePath)
    flash(f'Arquivo {file.filename} enviado com sucesso', 'info')
    return redirect('/screen2.html')

@app.route('/tables.html')
def tables():
    ranking = get_ranking()
    return render_template('pages/tables.html', ranking=ranking)

# App main route + generic routing
@app.route('/', defaults={'path': 'tables.html'})
@app.route('/<path>')
def index(path):

    if not current_user.is_authenticated:
        return redirect(url_for('login'))

    content = None

    try:

        return render_template( 'pages/'+path )
    
    except:
        
        return render_template( 'pages/error-404.html' )

# Return sitemap 
@app.route('/sitemap.xml')
def sitemap():
    return send_from_directory(os.path.join(app.root_path, 'static'), 'sitemap.xml')

'''
ROTAS DA UDA
'''


# @app.route('/input')
# def screen2():
#     return render_template('screen2.html')


# @app.route('/rank')
# def rank():
#     ranking = get_ranking()
#     return render_template('ranking.html', ranking=ranking)


