/*****************************************************************/
/* JumboETL Comments                                             */
/* The presented code is part of GeoTools Tutorial and           */
/* was changed to better fit this project.                       */
/*****************************************************************/

package org.jumbo.backend.services;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.Query;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.opengis.feature.Property;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.filter.Filter;

public class ShapefileServices {

	public static void readShpDataStore(String arquivo) throws Exception {
		File file = new File(arquivo);
		Map<String, Object> map = new HashMap<>();
		map.put("url", file.toURI().toURL());

		DataStore dataStore = DataStoreFinder.getDataStore(map);
		String typeName = dataStore.getTypeNames()[0];

		FeatureSource<SimpleFeatureType, SimpleFeature> source = dataStore.getFeatureSource(typeName);
		Filter filter = Filter.INCLUDE; // ECQL.toFilter("BBOX(THE_GEOM, 10,20,30,40)")

		FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(filter);

		try (FeatureIterator<SimpleFeature> features = collection.features()) {
			while (features.hasNext()) {
				SimpleFeature feature = features.next();
				System.out.println(feature.getID() + ": ");
				for (Property attribute : feature.getProperties()) {
					System.out.println("\t" + attribute.getName() + ": " + attribute.getValue());
				}
			}
		}
	}

//	public static void readShpDataStore(String arquivo) throws Exception {
//		File file = new File(arquivo);
//		Map<String, Object> map = new HashMap<>();
//		map.put("url", file.toURI().toURL());
//
//		DataStore dataStore = DataStoreFinder.getDataStore(map);
//		String typeName = dataStore.getTypeNames()[0];
//
//		FeatureSource<SimpleFeatureType, SimpleFeature> source = dataStore.getFeatureSource(typeName);
//		Filter filter = Filter.INCLUDE; // ECQL.toFilter("BBOX(THE_GEOM, 10,20,30,40)")
//
//		FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(filter);
//
//		try (FeatureIterator<SimpleFeature> features = collection.features()) {
//			String delimitador = ", ";
//			int tamanho = 0;
//			while (features.hasNext()) {
//				SimpleFeature feature = features.next();
//				System.out.println("");
//				System.out.print(tamanho + ": ");
//				int x = 0;
//				for (Property attribute : feature.getProperties()) {
//					System.out.print(attribute.getValue());
//					if (x < feature.getProperties().size() - 1) {
//						System.out.print(delimitador);
//					}
//					x++;
//				}
//				System.out.println("");
//				tamanho++;
//			}
//		}
//	}

	public static void readShpQuery(String arquivo, int numRequisicoes) throws Exception {
		File file = new File(arquivo);
		FileDataStore myData = FileDataStoreFinder.getDataStore(file);
		SimpleFeatureSource source = myData.getFeatureSource();
		SimpleFeatureType schema = source.getSchema();

		Query query = new Query(schema.getTypeName());
		query.setMaxFeatures(numRequisicoes);

		FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(query);
		try (FeatureIterator<SimpleFeature> features = collection.features()) {
			while (features.hasNext()) {
				SimpleFeature feature = features.next();
				System.out.println(feature.getID() + ": ");
				for (Property attribute : feature.getProperties()) {
					System.out.println("\t" + attribute.getName() + ":" + attribute.getValue());
				}
			}
		}
	}

	public static String getShpGeomType(String arquivo) throws Exception {
		File file = new File(arquivo);
		Map<String, Object> map = new HashMap<>();
		map.put("url", file.toURI().toURL());
		DataStore dataStore = DataStoreFinder.getDataStore(map);
		String t = dataStore.getTypeNames()[0];
		SimpleFeatureSource featureSource = dataStore.getFeatureSource(t);
		SimpleFeatureType schema = featureSource.getSchema();
		String geomType = schema.getGeometryDescriptor().getType().getBinding().getName();
		geomType = geomType.split("[.]")[4];
		System.out.println("\tTipo de geometria do arquivo Shapefile: " + geomType);
		return geomType;
	}

	public static List<String> getShpColNames(String arquivo, int numRequisicoes) throws Exception {
		List<String> colShp = new ArrayList<>();
		File file = new File(arquivo);
		FileDataStore myData = FileDataStoreFinder.getDataStore(file);
		SimpleFeatureSource source = myData.getFeatureSource();
		SimpleFeatureType schema = source.getSchema();

		Query query = new Query(schema.getTypeName());
		query.setMaxFeatures(numRequisicoes);

		FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(query);
		try (FeatureIterator<SimpleFeature> features = collection.features()) {
			while (features.hasNext()) {
				SimpleFeature feature = features.next();
				for (Property attribute : feature.getProperties()) {
					colShp.add(attribute.getName().toString());
				}
			}

			System.out.printf("\tColunas do arquivo Shapefile: %s\n", colShp);

			return colShp;
		}
	}
}
