import ia_fuzzy
import os
import random
from flask import Flask, jsonify, abort, request
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate
from threading import Thread
from flask_swagger_ui import get_swaggerui_blueprint
from flask_cors import CORS

if (os.environ.get('ENV') != 'prod'):
    os.environ['DATABASE_URL'] = 'postgres://fatec:fatec@postgres:5432/pi'

app = Flask(__name__)
cors = CORS(app, resources={r"/*": {"origins": "*"}})
app.config.from_pyfile('config.py')
db = SQLAlchemy(app)
migrate = Migrate(app, db)
port = int(os.environ.get("PORT", 5000))

class Filme(db.Model):
    id = db.Column(db.Integer, db.Sequence('seq_filme'), primary_key=True)
    nome = db.Column(db.String(200))
    genero = db.Column(db.String(200))

    def __init__(self, nome, genero):
        self.nome = nome
        self.genero = genero

    def serialize(self):
        return {
            "id": self.id,
            "nome": self.nome,
            "genero": self.genero
        }

    def getNome(self):
        return self.nome

class Recommendation(db.Model):
    id = db.Column(db.Integer, db.Sequence('seq_recommendation'), primary_key=True)
    nome = db.Column(db.String(200))

    def __init__(self, nome):
        self.nome = nome

    def serialize(self):
        return {
            "id": self.id,
            "nome": self.nome
        }

    def getNome(self):
        return self.nome

@app.route('/static/<path:path>')
def send_static(path):
    return send_from_directory('static', path)

SWAGGER_URL =  '/swagger'
API_URL = '/static/swagger.json'
swaggerui_blueprint = get_swaggerui_blueprint(
    SWAGGER_URL,
    API_URL,
    config={
        'app_name': "Topicos Avançados"
    }
)
app.register_blueprint(swaggerui_blueprint, url_prefix=SWAGGER_URL)


# Rota que retorna um dos filmes cadastrados na tabela filme por genero.
@app.route('/getFilme/<genero>', methods=['GET'])
def getFilme(genero):
    filmesByGrupo = list(map(lambda filme: filme.getNome(), Filme.query.filter_by(genero=str(genero)).all()))
    return jsonify({"filme": filmesByGrupo and random.choice(filmesByGrupo) or ""})

# Rota que retorna um dos filmes cadastrados na tabela recommendation.
@app.route('/getRecommendation', methods=['GET'])
def getRecommendation():
    filmesByGrupo = list(map(lambda recommendation: recommendation.getNome(), Recommendation.query.all()))
    return jsonify({"filme": filmesByGrupo and random.choice(filmesByGrupo) or ""})


def getFilmeByGrupo():
    filmes = list(map(lambda filme: filme.getNome(), Filme.query.all()))
    recommendations = list(map(lambda recommendation: recommendation.getNome(), Recommendation.query.all()))
    if(len(recommendations) >= 15): return
    nome = ia_fuzzy.getFilmeByGrupo(filmes, recommendations)
    filmesByGrupo = list(map(lambda recommendation: recommendation.getNome(), Recommendation.query.all()))
    if(nome not in filmesByGrupo):
        filme = Recommendation(nome)
        db.session.add(filme)
        db.session.commit()
    getFilmeByGrupo()

if __name__ == '__main__':
    thread = Thread(target=getFilmeByGrupo)
    thread.start()
    app.run(debug=True, host='0.0.0.0', port=port)
