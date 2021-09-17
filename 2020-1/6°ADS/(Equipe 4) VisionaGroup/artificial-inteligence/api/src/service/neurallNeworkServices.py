from tensorflow import keras
from keras.models import Sequential
from keras.layers import Dense
import numpy as np
# model = load_model("model/model.h5")
model = Sequential()
model.add(Dense(5, activation='relu', input_shape=(5,)))
model.add(Dense(1, activation='sigmoid'))
model.compile(optimizer="adam", loss="binary_crossentropy", metrics=["acc"])
model.load_weights("model/model.h5")


def predict(np_array):
    return model.predict(np_array)
