from geojson import FeatureCollection, Feature, Polygon, dumps
from shapely.geometry import shape
from service import uploadToAws
import geopandas as gpd
import json
import string
import random


def randomString(stringLength=8):
    letters = string.ascii_lowercase
    return ''.join(random.choice(letters) for i in range(stringLength))


def coords_to_geojson(coords):
    features = []
    for c in coords:
        features.append(Feature(geometry=Polygon([c])))
    return FeatureCollection(features)


def geojson_to_geopandas(geojson):
    geojson_str = dumps(geojson)
    json_geojson = json.loads(geojson_str)
    geom = [shape(i["geometry"]) for i in json_geojson["features"]]
    return gpd.GeoDataFrame({'geometry': geom}, crs={'init': 'epsg:4326'})


def mask(request):
    content = request.json
    geojson = coords_to_geojson(content["coordinates"])
    gdf = geojson_to_geopandas(geojson)
    key = randomString()
    filename = f'tmp/{key}'
    gdf.to_file(driver='ESRI Shapefile', filename=filename)
    print(uploadToAws.upload_folder_to_aws(
        filename, 'visionabucket', f'shp/{key}'))
    return {"key": key}
