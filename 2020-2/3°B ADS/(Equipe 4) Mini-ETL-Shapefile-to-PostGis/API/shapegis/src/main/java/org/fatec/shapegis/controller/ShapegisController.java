package org.fatec.shapegis.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.fatec.shapegis.dao.PostgisConnection;
import org.fatec.shapegis.model.FormConexao;
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.Query;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.opengis.feature.Property;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController // Declara que a classe controla requisições em Rest
public class ShapegisController {

	@GetMapping("/bomdia")
	public String bomdia() {
		return "bomdia";
	}

	@PostMapping(path = "/connect", consumes = "application/json")
	public String getConexao(@RequestBody FormConexao form) throws ClassNotFoundException, SQLException {
		// Abre conexao
		PostgisConnection conn = new PostgisConnection(form);
		// Testa o status da conexao
		String status = conn.status();
		// Fecha conexao
		conn.close();
		// Retorna o status da conexao
		return status;
	}

	@PostMapping(path = "/tables", consumes = "application/json")
	public ArrayList<String> tables(@RequestBody FormConexao form) throws ClassNotFoundException, SQLException {
		ArrayList<String> tables = new ArrayList<String>();
		// Abre conexao
		PostgisConnection conn = new PostgisConnection(form);
		// Cria JsonArray para o retorno
		// Resgata os nomes das tabelas disponíveis no banco
		tables = conn.tables();
		// Fecha conexao
		conn.close();
		return tables;
	}

	@PostMapping(path = "/fields/{name}", consumes = "application/json")
	public ArrayList<String> fields(@RequestBody FormConexao form, @PathVariable("name") String name)
			throws ClassNotFoundException, SQLException {
		ArrayList<String> fields = new ArrayList<String>();
		// Abre conexao
		PostgisConnection conn = new PostgisConnection(form);
		// Cria JsonArray para o retorno
		// Resgata os nomes das tabelas disponíveis no banco
		fields = conn.fields(name);
		// Fecha conexao
		conn.close();
		return fields;
	}

	@PostMapping(path = "/upload", consumes = "multipart/form-data", produces = "application/json")
	public ArrayList<String> upload(@RequestParam(value = "file") MultipartFile[] files) throws IOException {

		File shp = null;

		File d = new File(System.getProperty("user.home") + "\\ShapeGIS\\tmp");
		d.mkdirs();

		// Salvando arquivos
		for (MultipartFile file : files) {
			File f = new File(d.toString(), file.getOriginalFilename());
			System.out.println(f);
			try {
				file.transferTo(f);
				// Transfer or Saving in local memory
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			String fileName = f.toString();
			int index = fileName.lastIndexOf('.');
			String extension = fileName.substring(index + 1);
			if (extension.equals("shp")) {
				shp = new File(d.toString(), file.getOriginalFilename());
			}
		}

		// Leitura dos arquivos
		ArrayList<String> fields = new ArrayList<String>();
		FileDataStore myData = FileDataStoreFinder.getDataStore(shp);
		SimpleFeatureSource source = myData.getFeatureSource();
		SimpleFeatureType schema = source.getSchema();

		Query query = new Query(schema.getTypeName());
		query.setMaxFeatures(1);

		FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(query);
		try (FeatureIterator<SimpleFeature> features = collection.features()) {
			while (features.hasNext()) {
				SimpleFeature feature = features.next();

				for (Property attribute : feature.getProperties()) {
					fields.add(attribute.getName().toString());
				}
			}
		}

		for (MultipartFile file : files) {
			try {
				((File) file).delete();
				// deletando os arquivos
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
		return fields;
	}
}
	

/*
 * @RequestMapping("/database") public List<String> getDataBase(@RequestParam
 * String usuario, @RequestParam String senha, @RequestParam String endereco,
 * 
 * @RequestParam int porta) { ShapegisConnection conn = new
 * ShapegisConnection(usuario, senha, "jdbc:postgresql://" + endereco + ":" +
 * porta + "/" + usuario); conn.resultadosBanco(
 * "SELECT datname FROM pg_database WHERE datname NOT LIKE 'postgres' \r\n" +
 * "AND datname NOT LIKE 'template%';"); conn.FecharConexao(); return
 * conn.getResult(); }
 * 
 * //URL:
 * http://localhost:8080/param/tabela?usuario=postgres&senha=postgres&endereco=
 * localhost&porta=5432&database=db-pi
 * 
 * @RequestMapping("/tabela") public List<String> getTabela(@RequestParam String
 * usuario, @RequestParam String senha, @RequestParam String endereco,
 * 
 * @RequestParam int porta, @RequestParam String database) { ShapegisConnection
 * conn = new ShapegisConnection(usuario, senha, "jdbc:postgresql://" + endereco
 * + ":" + porta + "/" + database); conn.resultadosBanco(
 * "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public' and table_name like 'ft%'"
 * ); conn.FecharConexao(); return conn.getResult(); }
 * 
 * //URL:
 * http://localhost:8080/param/atributo?usuario=postgres&senha=postgres&endereco
 * =localhost&porta=5432&database=db-pi&tabela=ft_bacia_hidrografica_n1
 * 
 * @RequestMapping("/atributo") public List<String> getAtributo(@RequestParam
 * String usuario, @RequestParam String senha, @RequestParam String endereco,
 * 
 * @RequestParam int porta, @RequestParam String database, @RequestParam String
 * tabela) { ShapegisConnection conn = new ShapegisConnection(usuario, senha,
 * "jdbc:postgresql://" + endereco + ":" + porta + "/" + database);
 * conn.resultadosBanco(
 * "SELECT column_name FROM information_schema.columns WHERE table_name = '"+
 * tabela +"'"); conn.FecharConexao(); return conn.getResult(); }
 */
