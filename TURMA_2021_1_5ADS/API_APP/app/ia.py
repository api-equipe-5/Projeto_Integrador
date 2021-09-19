from joblib import load
import numpy as np
import pandas as pd

model = load('app/model.dump')
product_encoder = load('app/product_encoder.dump')
category_encoder = load('app/category_encoder.dump')
city_encoder = load('app/city_encoder.dump')
scaler = load('app/scaler.dump')
state_encoder = load('app/state_encoder.dump')

costumer = [[0.88461538, 0.48190167, 0.46078431, 0.15852831, 0., 0.44142633, 0.64705882]]
print(model.predict(costumer))

def encode_transform(data):
    customer_state = data["customer_state"]
    customer_city = data["customer_city"]
    customer_age = data["customer_age"]
    customer_avg_income = data["customer_avg_income"]
    customer_products_active = data["customer_products_active"]
    transactions_total_limit = data["transactions_total_limit"]
    transactions_category = data["transactions_category"]
    customer_state, = state_encoder.transform([customer_state])
    customer_city, = city_encoder.transform([customer_city])
    transactions_category, = category_encoder.transform([transactions_category])
    scaled_data, = scaler.transform([[
                                     customer_state,
                                     customer_city,
                                     customer_age,
                                     customer_avg_income,
                                     customer_products_active,
                                     transactions_total_limit,
                                     transactions_category
                                    ]])
    return scaled_data

def untransform_product(product):
  product_id, = product_encoder.inverse_transform([product])
  return product_id


