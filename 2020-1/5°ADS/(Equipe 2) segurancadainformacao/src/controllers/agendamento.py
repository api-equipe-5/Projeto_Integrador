from flask import Blueprint, render_template, redirect, url_for, request, flash
from flask_login import login_user, logout_user, login_required, current_user

from datetime import datetime

from src import db
from src.models.tabelas import *
from src.packages import CriptografiaAES
from src.utils.usuario_utils import user_is_funcionario

cripto = CriptografiaAES()

agendamento_module = Blueprint('agendamento', __name__, url_prefix="/agendamento",
                               template_folder='../templates')


@agendamento_module.route("/create", methods=["GET"])
@login_required
def agendamento():
    chave_usuario = Tabela_chaves.query.filter_by(id_usuario=current_user.get_id()).first()
    is_funcionario = user_is_funcionario(chave_usuario, current_user)

    if is_funcionario:
        servicos = Servicos.query.all()
        usuarios = Usuario.query.all()
        clientes = list()

        for usuario in usuarios:
            chave = Tabela_chaves.query.filter_by(id_usuario=usuario.id_usuario).first()

            if chave:
                if not user_is_funcionario(chave, usuario):
                    clientes.append((usuario, chave))
            else:
                clientes.append((usuario, None))

        return render_template('agendamento.html', servicos=servicos,
                               clientes=clientes,
                               fn_decript=cripto.descriptografar,
                               user_is_funcionario=is_funcionario)


@agendamento_module.route("/create", methods=["POST"])
@login_required
def criar_agendamento():
    id_usuario = request.form.get('id_usuario')
    id_servico = request.form.get('id_servico')
    data_agendada = request.form.get('dataAgenda')
    hora_agendada = request.form.get('horarioAgenda')

    data_hora = None
    try:
        data_hora = datetime.strptime(f'{data_agendada} {hora_agendada}', '%Y-%m-%d %H:%M')
    except ValueError as e:
        data_hora = datetime.strptime(f'{data_agendada} {hora_agendada}', '%Y-%d-%m %H:%M')

    novo_agendamento = Agendamento(
        usuario_id = id_usuario,
        servico_id = id_servico,
        data_agendada = data_hora
    )

    db.session.add(novo_agendamento)
    db.session.commit()

    flash('Agendamento criado com sucesso', category='success')

    return redirect(url_for('.agendamento'))
