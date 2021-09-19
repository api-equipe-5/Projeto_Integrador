# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey and OneToOneField has `on_delete` set to the desired behavior
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from app import db
from flask_login import UserMixin
from datetime import datetime
from sqlalchemy.dialects.postgresql import UUID
import uuid
from sqlalchemy.orm import backref

class Spc_Raw_Data(db.Model):
    __tablename__ = "spc_raw_data"

    id = db.Column(UUID(as_uuid=True), primary_key=True, default=uuid.uuid4)
    birthday = db.Column(db.String(255), nullable=True)
    avg_income = db.Column(db.String(255), nullable=True)
    latitude = db.Column(db.String(255), nullable=True)
    longitude = db.Column(db.String(255),  nullable=True)
    
class Save_data(db.Model):
    __tablename__ = "save_data"

    id = db.Column(db.Integer, primary_key=True)
    user_id = db.Column(db.Integer , db.ForeignKey('users.id'),  nullable=False)
    product_id = db.Column(UUID(as_uuid=True), db.ForeignKey('products.id'),  nullable=True)
    costumer_id = db.Column(UUID(as_uuid=True), db.ForeignKey('customers.id'),  nullable=True)


class Customers(db.Model):
    __tablename__ = "customers"

    id = db.Column(UUID(as_uuid=True), primary_key=True, default=uuid.uuid4)
    country = db.Column(db.String(255), nullable=True)
    state = db.Column(db.String(255), nullable=True)
    city = db.Column(db.String(255), nullable=True)
    district = db.Column(db.String(255), nullable=True)
    age = db.Column(db.Integer,  nullable=True)
    avg_income = db.Column(db.Numeric, nullable=True)
    spc_raw_data_id = db.Column(UUID(as_uuid=True), db.ForeignKey('spc_raw_data.id'),  nullable=True)
    relation = db.relationship(Spc_Raw_Data, backref=backref("customers", uselist=False))
    relation2 = db.relationship(Save_data, backref=backref("customers", uselist=False))

class Products(db.Model):
    __tablename__ = "products"

    id = db.Column(UUID(as_uuid=True), primary_key=True, default=uuid.uuid4)
    name = db.Column(db.String(255))
    category = db.Column(db.String(255))
    relation2 = db.relationship(Save_data, backref=backref("products", uselist=False))

class Customers_Products(db.Model):
    __tablename__ = "customers_products"

    id = db.Column(UUID(as_uuid=True), primary_key=True, default=uuid.uuid4)
    active = db.Column(db.Boolean)
    customer_id = db.Column(UUID(as_uuid=True), db.ForeignKey('customers.id'), nullable=True)
    product_id = db.Column(UUID(as_uuid=True), db.ForeignKey('products.id'),  nullable=True)
    inserted_at = db.Column(db.DateTime)
    updated_at = db.Column(db.DateTime)
    relation = db.relationship(Customers, backref=backref("customers_products", uselist=False))
   



class Kaggle_Raw_Data(db.Model):
    __tablename__ = "kaggle_raw_data"

    id = db.Column(UUID(as_uuid=True), primary_key=True, default=uuid.uuid4)
    customer_id = db.Column(UUID(as_uuid=True), db.ForeignKey('customers.id') , nullable=True)
    reference_id = db.Column(db.String(255), nullable=True)
    branch = db.Column(db.String(255), nullable=True)
    city = db.Column(db.String(255), nullable=True)
    state = db.Column(db.String(255), nullable=True)
    age = db.Column(db.String(255), nullable=True)
    gender = db.Column(db.String(255), nullable=True)
    total_limit = db.Column(db.String(255), nullable=True)
    available_limit = db.Column(db.String(255), nullable=True)
    date = db.Column(db.String(255), nullable=True)
    value = db.Column(db.String(255), nullable=True)
    group = db.Column(db.String(255),  nullable=True)
    purchase_city = db.Column(db.String(255), nullable=True)
    purchase_country = db.Column(db.String(255),  nullable=True)
    relation = db.relationship(Customers, backref=backref("kaggle_raw_data", uselist=False))

class Transactions(db.Model):
    __tablename__ = "transactions"

    id = db.Column(UUID(as_uuid=True), primary_key=True, default=uuid.uuid4)
    customer_id = db.Column(UUID(as_uuid=True), db.ForeignKey('customers.id') ,nullable=True)
    kaggle_raw_data_id = db.Column(UUID(as_uuid=True), db.ForeignKey('kaggle_raw_data.id'), nullable=True)
    date = db.Column(db.Date, nullable=True)
    value = db.Column(db.Numeric, nullable=True)
    total_limit = db.Column(db.Numeric, nullable=True)
    available_limit = db.Column(db.Numeric, nullable=True)
    category = db.Column(db.String(255), nullable=True)
    city = db.Column(db.String(255), nullable=True)
    country = db.Column(db.String(255),  nullable=True)
    relation = db.relationship(Customers, backref=backref("transactions", uselist=False))





class Schema_Migrations(db.Model):
    __tablename__ = "schema_migrations"

    version = db.Column(db.BigInteger, primary_key=True)
    inserted_at = db.Column(db.String(255),  nullable=True)




class Users(db.Model, UserMixin):
    __tablename__ = "users"

    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(60), unique=True)
    password = db.Column(db.String(60))




    @property
    def is_authenticated(self):
        return True
    @property
    def is_active(self):
        return True
    @property
    def is_anonymous(self):
        return False
    def get_id(self):
        return str(self.id)

class Csvdata(db.Model):
    __tablename__ = "csvdata"

    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(100))
    path = db.Column(db.String(200))

