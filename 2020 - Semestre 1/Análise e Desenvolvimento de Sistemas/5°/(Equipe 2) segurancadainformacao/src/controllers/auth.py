from flask import Blueprint, render_template, redirect, url_for, request, flash
from flask_login import login_user, logout_user, login_required, current_user

from datetime import datetime

from src import db
from src.models.tabelas import *
from src.packages import CriptografiaAES
from src.utils.usuario_utils import user_is_funcionario

cripto = CriptografiaAES()

auth_module = Blueprint('auth', __name__, url_prefix="/auth",
                    template_folder='../templates')


@auth_module.route("/login", methods=["GET","POST"])
def login():
    if current_user.is_authenticated:
        return redirect(url_for('usuario.get_historico'))

    if request.method == 'GET':
        return render_template('login.html')

    if request.method == 'POST':
        email = request.form.get('email')
        senha = request.form.get('senha')

        chave_usuario = Tabela_chaves.query.filter_by(email=email).first()

        if not chave_usuario:
            flash('Por favor, verifique suas informações e tente novamente!', category='danger')
            return redirect(url_for('auth.login'))
        else:
            usuario = Usuario.query.filter_by(id_usuario=chave_usuario.id_usuario).first()
            senha_usuario = cripto.descriptografar(chave_usuario.chave_privada, usuario.password)

            if senha == senha_usuario:
                login_user(usuario)

                if user_is_funcionario(chave_usuario, current_user):
                    return redirect(url_for('agendamento.agendamento'))

                return redirect(url_for('usuario.perfil'))
            else:
                flash('Por favor, verifique suas informações e tente novamente!', category='danger')
                return redirect(url_for('auth.login'))


@auth_module.route('/registrar', methods=["GET","POST"])
def registrar():
    if request.method == 'GET':
        return render_template('registrar.html')

    if request.method == 'POST':
        email = request.form.get('email')
        nome = request.form.get('nome')
        cpf = request.form.get('cpf')
        senha = request.form.get('senha')
        data_nascimento = request.form.get('data')

        chave_usuario = Tabela_chaves.query.filter_by(email=email).first()

        if chave_usuario:
            flash('E-mail de usuário já existe!', category='danger')
            return redirect(url_for('auth.registrar'))

        chave = cripto.criaChave()

        try:
            data_nascimento = datetime.strptime(data_nascimento,'%Y-%m-%d').date()
        except ValueError as e:
            data_nascimento = datetime.strptime(data_nascimento,'%Y-%d-%m').date()

        is_func = False
        novo_usuario = Usuario(
            nome=cripto.criptografar(chave["chave"], nome),
            email=cripto.criptografar(chave["chave"], email),
            password=cripto.criptografar(chave["chave"], senha),
            cpf=cripto.criptografar(chave["chave"], cpf),
            data_nascimento=cripto.criptografar(chave["chave"], data_nascimento),
            funcionario=cripto.criptografar(chave["chave"], is_func)
        )

        db.session.add(novo_usuario)
        db.session.commit()

        nova_chave = Tabela_chaves(
            id_usuario=novo_usuario.id_usuario,
            chave_privada=chave["chave"],
            email=email
        )

        db.session.add(nova_chave)
        db.session.commit()

        flash(f'Usuário {nome} cadastrado com sucesso', category='success')

        return redirect(url_for('auth.login'))


@auth_module.route('/logout')
@login_required
def logout():
    logout_user()
    return redirect(url_for('.login'))