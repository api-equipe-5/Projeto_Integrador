package shape;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.Query;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.locationtech.jts.geom.Geometry;
import org.opengis.feature.Property;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import tools.FilterFile;


public class ShapeService {
	
	ShapeItem shape = new ShapeItem();
	
	ShapeItemDAO con = new ShapeItemDAO();
	
	
	List<ShapeItem> shapeList = new ArrayList<>();
	
	
	
	
	
	public void shapeItem(File file) throws IOException, ClassNotFoundException, SQLException {
		  
	        FileDataStore myData = FileDataStoreFinder.getDataStore(file);
	        SimpleFeatureSource source = myData.getFeatureSource();
	        SimpleFeatureType schema = source.getSchema();
	        
	        Query query = new Query(schema.getTypeName());
	        //query.setMaxFeatures(1);
	        
	       

	        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(query);
	        try (FeatureIterator<SimpleFeature> features = collection.features()) {
	            while (features.hasNext()) {
	            	
	                SimpleFeature feature = features.next();
	              
	                Collection<Property> att = feature.getProperties();
	                for (Property pro : att) {
	                	
	              
	                	Geometry the_geom = (Geometry) feature.getAttribute(0);
	                	String COD_IMOVEL = feature.getAttribute(1).toString();
	                	String NUM_AREA = feature.getAttribute(2).toString();
	                	String COD_ESTADO = feature.getAttribute(3).toString();
	                	String NOME_MUNICIPIO = feature.getAttribute(4).toString();
	                	String NUM_MODULO = feature.getAttribute(5).toString();
	                	String TIPO_IMOVEL = feature.getAttribute(6).toString();
	                	String SITUACAO = feature.getAttribute(7).toString();
	                	String CONDICAO_I = feature.getAttribute(8).toString();
	                	
	                	NOME_MUNICIPIO.replaceAll("Ã©", "ão");
	                	
	                	shape.setGeom(the_geom);
	                	shape.setCod_imovel(COD_IMOVEL);
	                	shape.setNum_area(Double.parseDouble(NUM_AREA));
	                	shape.setCod_estado(COD_ESTADO);
	                	shape.setNome_municipio(NOME_MUNICIPIO);
	                	shape.setNum_modulo(Double.parseDouble(NUM_MODULO));
	                	shape.setTipo_imovel(TIPO_IMOVEL);
	                	shape.setSituacao(SITUACAO);
	                	shape.setCondicao_imovel(CONDICAO_I);
	                	
	                	
	                	con.save(shape);
	             
	                 }
	                
	                
	               
	                 //shapeList.add(shape);
	                 
	                 //System.out.println(shapeList);
	                 
	                }
	            }
	        
	        }

	}

