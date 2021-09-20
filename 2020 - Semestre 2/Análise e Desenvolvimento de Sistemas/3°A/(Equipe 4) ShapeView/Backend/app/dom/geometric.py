import matplotlib.pyplot as plt
import matplotlib
matplotlib.use('TkAgg')
import numpy as np
import geopandas as gpd

def geometricForm(Adress): ## DISPLAY OF GEOMETRIC SHAPES FOR THE USER
    form = gpd.read_file(f'/home/mateus/Desktop/AGENCIA_NACIONAL_AGUAS/{Adress}')
    form.plot(color = 'blue', edgecolor = 'white', figsize=(30,30))
    plt.title(f'{Adress}')
    plt.show()
    return 

