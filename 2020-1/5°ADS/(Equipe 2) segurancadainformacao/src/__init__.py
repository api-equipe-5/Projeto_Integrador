from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_script import Manager
from flask_migrate import Migrate, MigrateCommand
from flask_login import LoginManager

import os

db = SQLAlchemy()
migrate = Migrate()

project_dir = os.path.dirname(os.path.abspath(__file__))

app = Flask(__name__)
# app.config["SQLALCHEMY_DATABASE_URI"] = "mysql+mysqldb://root:admin@localhost/lgpd"
app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///../salao.db"
app.config["SQLALCHEMY_BINDS"] = {
    "banco_principal" : "sqlite:///../salao.db",
    "chaves_privadas" : "sqlite:///../chaves_privadas.db"
}
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = True
app.config['SECRET_KEY'] = '9OLWxND4o83j4K4iuopO'

db.init_app(app)

login_manager = LoginManager()
login_manager.login_view = 'auth.login'
login_manager.init_app(app)

migrate.init_app(app, db)

with app.app_context():

    from src.controllers import principal
    app.register_blueprint(principal)

    from src.controllers import auth
    app.register_blueprint(auth)

    from src.controllers import agendamento
    app.register_blueprint(agendamento)

    from src.controllers import servicos
    app.register_blueprint(servicos)

    from src.controllers import usuario
    app.register_blueprint(usuario)

    manager = Manager(app)
    manager.add_command('db', MigrateCommand)

    db.create_all(app=app)

@login_manager.user_loader
def load_user(user_id):
    from src.models.tabelas import Usuario
    return Usuario.query.get(int(user_id))

if __name__ == '__main__':
    app.run(debug=True,host='0.0.0.0', port='3000')