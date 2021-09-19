from app import app, ia, db, lm, LoginForm, Createuserform, FileUpload
from app.ia import costumer, pd, encode_transform, untransform_product, model
from flask import Flask, jsonify, request,render_template,url_for,redirect,abort,flash, session
from sklearn import preprocessing
from sklearn.preprocessing import MinMaxScaler
from flask_cors import CORS, cross_origin
from sqlalchemy import select
from app.models.models_spc import Csvdata, Spc_Raw_Data, Users, Save_data, Customers, Customers_Products, Kaggle_Raw_Data, Transactions, Products, Schema_Migrations
from datetime import timedelta
import secrets
import os
from flask_login import login_user, logout_user, current_user, login_required
from werkzeug.datastructures import CombinedMultiDict, FileStorage
import csv

ttl= 7626.014464
# função para deslogar o user em determinado momento
app.permanent_session_lifetime = timedelta(seconds=30000)

# função login
@lm.user_loader
def load_user(user_id):
    return Users.query.get(int(user_id))

# rota de login
@app.route("/login", methods=["GET","POST"])
def login():
    form = LoginForm()
    if form.validate_on_submit():
        user = Users.query.filter_by(username=form.username.data).first()
        if user and user.password == form.password.data:
            if user.id == 0:
                login_user(user)
                session.permanent = True
                return redirect(url_for("showdata"))
            login_user(user)
            session.permanent = True
            return redirect(url_for("showdata"))
        else:
            flash("login invalido")
    return render_template('login.html', form=form)

#rota mostrar dados
@app.route("/dados")
@login_required
def dados():
    data = Save_data.query.all()
    return render_template('dados.html', data=data)


def savecsv(file):
    random_hex = secrets.token_hex(8)
    _, f_ext = os.path.splitext(file.filename)
    picture_fn = random_hex + f_ext
    csv_path = os.path.join(app.root_path, 'static/storage', picture_fn )
    file.save(csv_path)
    csvdata = Csvdata(name=file.filename, path=picture_fn)
    db.session.add(csvdata)
    db.session.commit()
    csvdata2 = Csvdata.query.filter_by(name=file.filename).first()
    return csvdata2.id

#rota escolher arquivo
@app.route('/select')
@login_required
def select():
    return render_template('select.html')
    
#rota mostrar dados csv
@app.route('/uploadcsv', methods=['GET','POST'])
@login_required
def csv2():
    file =request.files['inputFile']
    t =savecsv(file)
   
    return redirect(url_for("csv1", t=t))


    
#rota mostrar dados csv
@app.route('/csv/<t>', methods=['GET','POST'])
@login_required
def csv1(t):
    n = Csvdata.query.get_or_404(t)
    csv_path = os.path.join(app.root_path, 'static/storage', n.path )
    f = open(csv_path, encoding="utf8")
    csv_reader = csv.reader(f, delimiter=',')
    csv_reader.__next__()
    return render_template('csv.html',csv_reader=csv_reader, n=n)

#rota da alegria
@app.route("/apicsv/<string:id>/<csvid>", methods=["GET","POST"])
@login_required
def apicsv(id, csvid):
    n = Csvdata.query.get_or_404(csvid)
    csv_path = os.path.join(app.root_path, 'static/storage', n.path )
    f = open(csv_path, encoding="utf8")
    csv_reader = csv.reader(f, delimiter=',')
    csv_reader.__next__()
    for t in csv_reader:
        if t[0] == id:
            cv= False
            if t[14] == 'TRUE':
                cv=True
            teste=encode_transform({
                "customer_state":t[7],
                "customer_city": t[8],
                "customer_age": t[10],
                "customer_avg_income": t[11],
                "customer_products_active": cv ,
                "transactions_total_limit": ttl,
                "transactions_category": 'Não Especificado'
            })
            teste2 = teste.reshape(1,-1)
            teste3 =model.predict(teste2)
            teste4= untransform_product(teste3)
            teste5= Products.query.get_or_404(teste4)
            a = ['Estado: '+t[7],'Cidade: ' +t[8],'idade: ' +t[10],'customer_avg_income: ' +t[11]]
            a = ' '.join(a)
            return render_template('recomendacaocsv.html',n=n.id, a=a, csv_reader=csv_reader,teste4=teste4, teste5=teste5)
    return render_template('recomendacaocsv.html', n=n.id, a=a, csv_reader=csv_reader,teste4=teste4, teste5=teste5)   



#rota salvar dados
@app.route("/dados/<user_id>/<costumer_id>/<product_id>/save")
@login_required
def dadosave(user_id, costumer_id, product_id ):
    i = Save_data(user_id=user_id, product_id=product_id, costumer_id=costumer_id)
    db.session.add(i)
    db.session.commit()
    flash("Dados salvos")
    return redirect(url_for("dados"))

#rota deletar dados
@app.route("/dados/<int:user_id>/<save_data>/delete")
@login_required
def deldadosave(save_data, user_id):
    if current_user.id == user_id:
        post = Save_data.query.get_or_404(save_data)
        db.session.delete(post)
        db.session.commit()
        flash('O dado escolhido foi deletado', 'success')
        return redirect(url_for('dados'))
    else:
        abort(403)
    

#rota para deslogar
@app.route("/logout")
@login_required
def logout():
    logout_user()
    return redirect(url_for("index"))

#rota adm user
@app.route("/adm/manager", methods=['GET','POST'])
@login_required
def manager():
    users = Users.query.all()
    if current_user.id == 0:
        return render_template("manager.html", users=users)
    else:
         abort(403)
    return render_template("manager.html", users=users)

# tela inicial
@app.route("/")
def index():
    customer = Customers.query.all()
    transactions= Transactions.query.all()
    customers_products = Customers_Products.query.all()
    products = Products.query.all()
    kaggle_raw_data = Kaggle_Raw_Data.query.all()
    return render_template('home.html', kaggle_raw_data=kaggle_raw_data, products=products, customers_products=customers_products, customer=customer, transactions=transactions)


#rota criar usuario
@app.route("/adm/manager/new", methods=['GET','POST'])
@login_required
def new_monitor():
    users = Users.query.all()
    form =Createuserform()
    if current_user.id == 0:
        if form.validate_on_submit():
            for o in users:
                if o.username == form.username.data:
                    flash('Já existe um usuário com este username tente um valor diferente')
                    return  render_template('create_user.html', 
                            form=form, legend='Novo Usuario' )
            i = Users(username=form.username.data, password=form.password.data)
            db.session.add(i)
            db.session.commit()
            flash('Um novo usuario foi adicionado', 'success')
            return redirect(url_for('manager'))
    else:
        abort(403)
    return render_template('create_user.html', form=form, legend='Novo usuário')
    

#rota delete user
@app.route("/adm/manager/<int:post_id>/delete", methods=['GET','POST'])
@login_required
def delete_monitor(post_id):
    if current_user.id == 0:
        post = Users.query.get_or_404(post_id)
        if post.id == 0:
            abort(403)
        else:
            db.session.delete(post)
            db.session.commit()
            flash('O usuario escolhido foi deletado', 'success')
            return redirect(url_for('manager'))
    else:
        abort(403)


#rota de consultas
@app.route("/api")
@login_required
def showdata():
    customer = Customers.query.all()
    page = request.args.get('page', 1, type=int)
    posts = Customers.query.order_by(Customers.id.desc()).paginate(page=page, per_page=5)
    transactions= Transactions.query.all()
    customers_products = Customers_Products.query.all()
    products = Products.query.all()
    spc_raw_data=Spc_Raw_Data.query.all()
    posts2 = Kaggle_Raw_Data.query.all()
   
    posts3 = Customers.query.all()
   
    return render_template('api.html', posts3=posts3, page=page, posts=posts,customer=customer)

@app.route("/api/<id>", methods=["GET","POST"])
@login_required
def api(id):
    # breakpoint()
    customers = Customers.query.get_or_404(id)
    cp = Customers_Products.query.filter_by(customer_id=customers.id).all()
    if len(cp) > 0:
        ct = cp[0].active
    else:
        ct = False

    teste=encode_transform({
        "customer_state":customers.state,
        "customer_city": customers.city,
        "customer_age": customers.age,
        "customer_avg_income": customers.avg_income,
        "customer_products_active": ct ,
        "transactions_total_limit": ttl,
        "transactions_category": 'Não Especificado'
    })
    teste2 = teste.reshape(1,-1)
    teste3 =model.predict(teste2)
    teste4= untransform_product(teste3)


        
    products= Products.query.filter_by(id=teste4).first()
    return render_template('recomendacao.html', products=products,teste4=teste4, customers=customers)