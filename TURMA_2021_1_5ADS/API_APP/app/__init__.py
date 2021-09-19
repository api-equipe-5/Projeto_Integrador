from flask import Flask
from flask_script import Manager
from flask_cors import CORS, cross_origin
from flask_migrate import Migrate, MigrateCommand
from flaskext.mysql import MySQL
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy import Column, String, Integer
from flask_wtf  import  FlaskForm 
from  wtforms  import  FileField, StringField, PasswordField, TextAreaField, SubmitField, IntegerField, SelectField, FloatField, DecimalField
from wtforms.validators import InputRequired, Length, AnyOf, DataRequired
from flask_login import LoginManager
from sqlalchemy.sql import select
from decimal import ROUND_UP
from flask_login import LoginManager
from flask_wtf.file import FileField, FileRequired, FileAllowed

app = Flask(__name__)
app.config.from_object('config')
cors = CORS(app)
manager = Manager(app)
db = SQLAlchemy(app)
migrate = Migrate(app, db)
manager.add_command('db', MigrateCommand)
lm = LoginManager(app)
lm.init_app(app)

class LoginForm(FlaskForm):
    username = StringField("username", validators=[DataRequired(message='deu ruim')])
    password = PasswordField("password", validators=[DataRequired(message='deu ruim')])
    submit= SubmitField('Realizar login')
    
class Createuserform(FlaskForm):
    username = StringField('Nome de usuário', validators=[InputRequired(message='Um usuário é exigido'), Length(min=1, max=30, message= 'Máximo de 30 caracteres.')])
    password = PasswordField('Senha', validators=[InputRequired(message='Um usuário é exigido'), Length(min=1, max=30, message= 'Máximo de 30 caracteres.')])
    submit= SubmitField('Finalizar')
class FileUpload(FlaskForm):
    csv =  FileField('Csv', validators=[FileRequired(), FileAllowed(['xls', 'xlsx'], 'Excel Document only!')])
    submit= SubmitField('Finalizar')


from .models import models_spc

from app.controllers import index


