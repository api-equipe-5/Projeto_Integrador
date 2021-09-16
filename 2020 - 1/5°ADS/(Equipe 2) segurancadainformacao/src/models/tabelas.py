from src import db

class Usuario(db.Model):

    __bind_key__ = 'banco_principal'
    __tablename__ = 'usuarios'

    id_usuario = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.LargeBinary(length=None), nullable=False)
    email = db.Column(db.LargeBinary(length=None), nullable=False)
    password = db.Column(db.LargeBinary(length=None), nullable=False)
    data_nascimento = db.Column(db.LargeBinary(length=None), nullable=False)
    cpf = db.Column(db.LargeBinary(length=None), nullable=False)
    funcionario = db.Column(db.LargeBinary(length=None), nullable=False)

    agendamentos = db.relationship('Agendamento', backref='usuario')
    endereco = db.relationship('Endereco', backref='usuario', uselist=False)
    telefone = db.relationship('Telefone', backref='usuario', uselist=False)

    @property
    def is_authenticated(self):
        return True

    @property
    def is_active(self):
        return True

    @property
    def is_anonymous(self):
        return True

    def get_id(self):
        return f'{self.id_usuario}'

    def __repr__(self):
        return f'<Usuario {self.id_usuario}>'


class Endereco(db.Model):

    __bind_key__ = 'banco_principal'
    __tablename__ = 'enderecos'

    id_endereco = db.Column(db.Integer, primary_key=True)
    numero = db.Column(db.Integer, nullable=False)
    cep = db.Column(db.String(8), nullable=False)
    complemento = db.Column(db.String(25), nullable=False)

    id_usuario = db.Column(db.Integer, db.ForeignKey('usuarios.id_usuario'), nullable=False)

    def __repr__(self):
        return f'<Endereco {self.cep}>'


class Telefone(db.Model):
    __bind_key__ = 'banco_principal'
    __tablename__ = 'telefones'

    id_telefone = db.Column(db.Integer, primary_key=True)
    numero = db.Column(db.String(11), nullable=False)

    id_usuario = db.Column(db.Integer, db.ForeignKey('usuarios.id_usuario'), nullable=False)

    def __repr__(self):
        return f'<Telefone {self.numero}>'


class Servicos(db.Model):
    __bind_key__ = 'banco_principal'
    __tablename__ = 'servicos'

    id_servico = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(60), nullable=False)
    descricao = db.Column(db.String(60), nullable=False)
    preco = db.Column(db.String(60), nullable=False)
    duracao = db.Column(db.String(60), nullable=False)
    disponibilidade = db.Column(db.Boolean, nullable=False)
    agendamentos = db.relationship('Agendamento', backref='servico')

    def __repr__(self):
        return f'<Servico {self.id_servico}>'


class Agendamento(db.Model):
    __bind_key__ = 'banco_principal'
    __tablename__ = 'agendamento'

    id_agendamento = db.Column(db.Integer, primary_key=True)
    data_agendada = db.Column(db.DateTime, nullable=False)

    usuario_id = db.Column(db.Integer, db.ForeignKey('usuarios.id_usuario'))
    servico_id = db.Column(db.Integer, db.ForeignKey('servicos.id_servico'))

    def __repr__(self):
        return f'<Agendamento {self.id_agendamento}>'

class Tabela_chaves(db.Model):
    __bind_key__ = 'chaves_privadas'
    __tablename__ = 'tabela_chaves'

    id = db.Column(db.Integer, primary_key=True)
    chave_privada = db.Column(db.LargeBinary(length=None), nullable=False)
    id_usuario = db.Column(db.Integer, nullable=False)
    email = db.Column(db.String(60), nullable=False)

    def __repr__(self):
        return f'<Tabela_chaves {self.id}>'