from flask import Blueprint, render_template, redirect, url_for, request, flash
from flask_login import login_user, logout_user, login_required, current_user

from src import db
from src.models.tabelas import *
from src.packages import CriptografiaAES
from src.utils.usuario_utils import user_is_funcionario

from datetime import datetime

cripto = CriptografiaAES()

usuario_module = Blueprint('usuario', __name__, url_prefix="/usuario",
                           template_folder='../templates')


@usuario_module.route("/historico", methods=["GET","POST"])
@login_required
def get_historico():
    chave_usuario = Tabela_chaves.query.filter_by(id_usuario=current_user.get_id()).first()
    is_funcionario = user_is_funcionario(chave_usuario, current_user)

    historico = None

    if request.method == "GET":
        if is_funcionario:
            agendamentos = Agendamento.query.all()

            historico = list()
            for agendamento in agendamentos:
                chave_usuario = Tabela_chaves.query.filter_by(id_usuario=agendamento.usuario_id).first()
                historico.append((agendamento, chave_usuario))
        else:
            historico = {
                'agendamentos': Agendamento.query.filter_by(usuario_id=current_user.get_id()).all(),
                'chave_usuario': chave_usuario
            }

    elif request.method == "POST":
        if is_funcionario:
            usuario = Usuario.query.filter_by(usuario_id=request.form.get('id_usuario')).first()
            historico = Agendamento.query.filter_by(usuario=usuario).all()

    return render_template('historico.html', historico=historico, historico_is_list=type(historico) is list,
                           fn_decript=cripto.descriptografar, user_is_funcionario=is_funcionario)


@usuario_module.route('/perfil', methods=['GET'])
@login_required
def perfil():
    chave_usuario = Tabela_chaves.query.filter_by(id_usuario=current_user.get_id()).first()
    is_funcionario = user_is_funcionario(chave_usuario, current_user)

    nome = cripto.descriptografar(chave_usuario.chave_privada, current_user.nome)
    email = cripto.descriptografar(chave_usuario.chave_privada, current_user.email)
    cpf = cripto.descriptografar(chave_usuario.chave_privada, current_user.cpf)
    data_nascimento = cripto.descriptografar(chave_usuario.chave_privada, current_user.data_nascimento)
    telefone = Telefone.query.filter_by(id_usuario=current_user.get_id()).first()
    endereco = Endereco.query.filter_by(id_usuario=current_user.get_id()).first()

    try:
        data_nascimento = datetime.strptime(data_nascimento, '%Y-%m-%d')
    except ValueError as e:
        data_nascimento = datetime.strptime(data_nascimento, '%Y-%d-%m')

    return render_template('perfil.html', nome=nome, email=email, cpf=cpf, data_nascimento=datetime.strftime(data_nascimento, '%d/%m/%Y'),
                           telefone=telefone, endereco=endereco, user_is_funcionario=is_funcionario)


@usuario_module.route('/editar', methods=['GET','POST'])
@login_required
def editar():
    chave_usuario = Tabela_chaves.query.filter_by(id_usuario=current_user.get_id()).first()

    if request.method == "GET":
        is_funcionario = user_is_funcionario(chave_usuario, current_user)
        nome = cripto.descriptografar(chave_usuario.chave_privada, current_user.nome)
        email = cripto.descriptografar(chave_usuario.chave_privada, current_user.email)
        senha = cripto.descriptografar(chave_usuario.chave_privada, current_user.password)
        cpf = cripto.descriptografar(chave_usuario.chave_privada, current_user.cpf)
        data_nascimento = cripto.descriptografar(chave_usuario.chave_privada, current_user.data_nascimento)
        telefone = Telefone.query.filter_by(id_usuario=current_user.get_id()).first()
        endereco = Endereco.query.filter_by(id_usuario=current_user.get_id()).first()

        return render_template('perfil_editar.html', nome=nome, email=email, senha=senha, cpf=cpf, data_nascimento=data_nascimento,
                                telefone=telefone, endereco=endereco, user_is_funcionario=is_funcionario )

    if request.method == "POST":
        nome = request.form.get('nome')
        email = request.form.get('email')
        senha = request.form.get('senha')
        cpf = request.form.get('cpf')
        data_nascimento = request.form.get('data')

        try:
            data_nascimento = datetime.strptime(data_nascimento,'%Y-%m-%d').date()
        except ValueError as e:
            data_nascimento = datetime.strptime(data_nascimento,'%Y-%d-%m').date()

        current_user.nome = cripto.criptografar(chave_usuario.chave_privada, nome)
        current_user.cpf = cripto.criptografar(chave_usuario.chave_privada, cpf)
        current_user.data_nascimento = cripto.criptografar(chave_usuario.chave_privada, data_nascimento)
        current_user.password = cripto.criptografar(chave_usuario.chave_privada, senha)

        if email != chave_usuario.email:
            current_user.email = cripto.criptografar(chave_usuario.chave_privada, email)
            chave_usuario.email = email

        db.session.commit()

        flash('Dados pessoais alterados com sucesso', category='success')

        return redirect(url_for('usuario.perfil'))


@usuario_module.route('/telefone', methods=['POST'])
@login_required
def telefone():
    numero = request.form.get('numero')
    novo_telefone = Telefone(numero=numero, id_usuario=current_user.get_id())

    db.session.add(novo_telefone)
    db.session.commit()

    flash('Telefone alterado com sucesso', category='success')

    return redirect(url_for('usuario.perfil'))


@usuario_module.route('/endereco', methods=['POST'])
@login_required
def endereco():
    numero = request.form.get('numero')
    cep = request.form.get('cep')
    complemento = request.form.get('complemento')
    novo_endereco = Endereco(numero=numero,cep=cep, complemento=complemento, id_usuario=current_user.get_id())

    db.session.add(novo_endereco)
    db.session.commit()

    flash('Endereço atualizado com sucesso', category='success')

    return redirect(url_for('usuario.perfil'))


@usuario_module.route('/deletar', methods=['POST','GET'])
@login_required
def deletar():
    chave_usuario = Tabela_chaves.query.filter_by(id_usuario=current_user.get_id()).first()
    is_funcionario = user_is_funcionario(chave_usuario, current_user)

    if not is_funcionario:
        db.session.delete(chave_usuario)
        db.session.commit()

        flash('Perfil deletado com sucesso', category='success')

        return redirect(url_for('auth.logout'))