from flask import Blueprint, render_template, request, redirect, url_for
from flask_login import login_required, current_user

from src import db
from src.models.tabelas import *
from src.utils.usuario_utils import user_is_funcionario

servicos_module = Blueprint('servicos', __name__, url_prefix="/servicos",
                    template_folder='../templates')

@servicos_module.route("/create", methods=["GET","POST"])
@login_required
def servico():
    chave_usuario = Tabela_chaves.query.filter_by(id_usuario=current_user.get_id()).first()
    is_funcionario = user_is_funcionario(chave_usuario, current_user)

    if request.method == 'GET':
        servicos = Servicos.query.all()

    if request.method == 'POST':
        nome = request.form.get('nomeServico')
        descricao = request.form.get('descricao')
        preco = request.form.get('preco')
        duracao = request.form.get('duracao')

        novo_servico = Servicos(
            nome=nome,
            descricao=descricao,
            preco=preco,
            duracao=duracao,
            disponibilidade=True
        )

        db.session.add(novo_servico)
        db.session.commit()

        servicos = Servicos.query.all()

    return render_template('servico.html', servicos=servicos, user_is_funcionario=is_funcionario)
