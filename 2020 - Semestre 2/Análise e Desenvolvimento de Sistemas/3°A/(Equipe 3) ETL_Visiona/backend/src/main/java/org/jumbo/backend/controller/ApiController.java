package org.jumbo.backend.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.jumbo.backend.model.Parameters;
import org.jumbo.backend.services.InputServices;
import org.jumbo.backend.services.OutputServices;
import org.jumbo.backend.services.PostgresqlServices;
import org.jumbo.backend.services.ShapefileServices;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/jumbo")
@CrossOrigin
public class ApiController {

	@PostMapping(path = "/login")
	public Map<String, String> login(@RequestBody Parameters parametros) {
		System.out.println("\nRecebendo acesso na rota 'login'\n");
		Map<String, String> map = new HashMap<>();
		String resultado = null;

		try (Connection con = PostgresqlServices.getConnection(parametros.getHost(), parametros.getPort(),
				parametros.getDatabase(), parametros.getUser(), parametros.getPassword())) {
			con.close();
			resultado = "Conectado";
			map.put("isConnected", resultado);
			System.out.println("\t" + resultado);
			return map;
		} catch (SQLException e) {
			resultado = "Erro " + e.getMessage();
			map.put("isConnected", resultado);
			System.out.println("\t" + resultado);
			return map;
		}
	}

	@PostMapping(path = "/get_tables")
	public Map<String, List<String>> getTables(@RequestBody Parameters parametros) throws Exception {
		System.out.println("\nRecebendo acesso na rota 'get_tables'\n");

		List<String> tabelas = new ArrayList<>();
		tabelas = PostgresqlServices.getTables(parametros.getHost(), parametros.getPort(), parametros.getDatabase(),
				parametros.getUser(), parametros.getPassword());

		Map<String, List<String>> map = new HashMap<>();
		map.put("tables", tabelas);

		return map;
	}

	@PostMapping(path = "/insert_shp_to_dbt")
	public Map<String, String> insertShpToDbt(@RequestBody Parameters parametros) throws Exception {
		System.out.println("\nRecebendo acesso na rota 'insert_shp_to_dbt'\n");

		String resultado = InputServices.insertShpToDbt(parametros.getDbtColNames(), parametros.getSelectedColumns(),
				parametros.getShpFileName(), parametros.getShpFilePath(), parametros.getHost(), parametros.getUser(),
				parametros.getDatabase(), parametros.getPassword(), parametros.getTable());

		Map<String, String> map = new HashMap<>();
		map.put("result", resultado);
		return map;
	}

	@PostMapping(path = "/extract_dbt_to_shp")
	public void extractDbtToShp(HttpServletResponse response, @RequestBody Parameters parametros) throws Exception {
		System.out.println("\nRecebendo acesso na rota 'extract_dbt_to_shp'\n");

		String saida = OutputServices.extractDbtToShp(parametros.getChoicedColumns(), parametros.getTable(),
				parametros.getHost(), parametros.getUser(), parametros.getDatabase(), parametros.getPassword());

		File file = new File(saida);

		response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
		response.setContentType("application/zip");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());

		OutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(file);

		IOUtils.copy(in, out);

		out.close();
		in.close();
		file.delete();
		System.out.println("\tExtração concluída com sucesso");
	}

	@PostMapping(path = "/upload_shp")
	public Map<String, String> uploadShp(@RequestParam MultipartFile shpFile) throws Exception {
		System.out.println("\nRecebendo acesso na rota 'upload_shp'\n");

		String caminho = shpFile.getOriginalFilename();

		System.out.printf("\tArquivo recebido: %s\n", caminho);

		String caminho2 = System.getProperty("user.dir") + "\\jumbo_recebe";

		Files.createDirectories(Paths.get(caminho2));

		caminho2 = caminho2 + "\\" + shpFile.getOriginalFilename();

		Files.copy(shpFile.getInputStream(), Paths.get(caminho2), StandardCopyOption.REPLACE_EXISTING);

		caminho = caminho.substring(0, caminho.length() - 4) + ".shp";
		caminho2 = caminho2.substring(0, caminho2.length() - 4) + ".shp";

		Map<String, String> map = new HashMap<>();
		map.put("shpFileName", caminho);
		map.put("shpFilePath", caminho2);

		return map;
	}

	@PostMapping(path = "/get_dbt_col_names")
	public Map<String, List<String>> getDbtColNames(@RequestBody Parameters parametros) throws Exception {
		System.out.println("\nRecebendo acesso na rota 'get_dbt_col_names'\n");

		List<String> colunasDBT = new ArrayList<>();
		colunasDBT = PostgresqlServices.getDbtColNames(parametros.getTable(), parametros.getHost(),
				parametros.getPort(), parametros.getDatabase(), parametros.getUser(), parametros.getPassword());

		Map<String, List<String>> map = new HashMap<>();
		map.put("dbtColNames", colunasDBT);

		return map;
	}

	@PostMapping(path = "/get_shp_col_names")
	public Map<String, List<String>> getShpColNames(@RequestBody Parameters parametros) throws Exception {
		System.out.println("\nRecebendo acesso na rota 'get_shp_col_names'\n");

		List<String> colShp = new ArrayList<>();
		colShp = ShapefileServices.getShpColNames(parametros.getShpFilePath(), 1);

		colShp.removeIf(col -> col.toString() == "the_geom");

		Map<String, List<String>> map = new HashMap<>();
		map.put("shpColNames", colShp);

		return map;
	}

	@PostMapping(path = "/get_dbt_geom_type")
	public Map<String, List<String>> getDbtGeomType(@RequestBody Parameters parametros) throws Exception {
		System.out.println("\nRecebendo acesso na rota 'get_dbt_geom_type'\n");

		List<String> dbtGeomTypes = new ArrayList<>();
		dbtGeomTypes = PostgresqlServices.getDbtGeomType(parametros.getHost(), parametros.getPort(),
				parametros.getDatabase(), parametros.getUser(), parametros.getPassword());

		Map<String, List<String>> map = new HashMap<>();
		map.put("dbtGeomTypes", dbtGeomTypes);

		return map;
	}

	@PostMapping(path = "/get_multipoint_tables")
	public Map<String, List<String>> getMultipointTables(@RequestBody Parameters parametros) throws Exception {
		System.out.println("\nRecebendo acesso na rota 'get_multipoint_tables'\n");

		List<String> tabelas = new ArrayList<>();
		tabelas = PostgresqlServices.getMultipointTables(parametros.getHost(), parametros.getPort(),
				parametros.getDatabase(), parametros.getUser(), parametros.getPassword());

		Map<String, List<String>> map = new HashMap<>();
		map.put("tables", tabelas);

		return map;
	}

	@PostMapping(path = "/get_multilinestring_tables")
	public Map<String, List<String>> getMultilinestringTables(@RequestBody Parameters parametros) throws Exception {
		System.out.println("\nRecebendo acesso na rota 'get_multilinestring_tables'\n");

		List<String> tabelas = new ArrayList<>();
		tabelas = PostgresqlServices.getMultilinestringTables(parametros.getHost(), parametros.getPort(),
				parametros.getDatabase(), parametros.getUser(), parametros.getPassword());

		Map<String, List<String>> map = new HashMap<>();
		map.put("tables", tabelas);

		return map;
	}

	@PostMapping(path = "/get_multipolygon_tables")
	public Map<String, List<String>> getMultipolygonTables(@RequestBody Parameters parametros) throws Exception {
		System.out.println("\nRecebendo acesso na rota 'get_multipolygon_tables'\n");

		List<String> tabelas = new ArrayList<>();
		tabelas = PostgresqlServices.getMultipolygonTables(parametros.getHost(), parametros.getPort(),
				parametros.getDatabase(), parametros.getUser(), parametros.getPassword());

		Map<String, List<String>> map = new HashMap<>();
		map.put("tables", tabelas);

		return map;
	}

	@PostMapping(path = "/get_geojson")
	public void getGeojson(HttpServletResponse response, @RequestBody Parameters parametros) throws Exception {
		System.out.println("\nRecebendo acesso na rota 'get_geojson'\n");

		String address = OutputServices.getGeojson(parametros.getHost(), parametros.getUser(), parametros.getDatabase(),
				parametros.getPassword(), parametros.getTable());

		File file = new File(address);

		response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
		response.setContentType("application/json");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());

		OutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(file);

		IOUtils.copy(in, out);

		out.close();
		in.close();
		file.delete();
		System.out.println("\tDados enviados com sucesso");
	}

	@PostMapping(path = "/search_table")
	public Map<String, List<String>> searchTable(@RequestBody Parameters parametros) throws Exception {
		System.out.println("\nRecebendo acesso na rota 'search_tables'\n");

		List<String> tabelasprocuradas = new ArrayList<>();
		tabelasprocuradas = PostgresqlServices.searchTable(parametros.getHost(), parametros.getPort(),
				parametros.getDatabase(), parametros.getUser(), parametros.getPassword(), parametros.getTable());

		Map<String, List<String>> map = new HashMap<>();
		map.put("tables", tabelasprocuradas);

		return map;
	}

	@PostMapping(path = "/get_search_table_geom_type")
	public Map<String, List<String>> getSearchTableGeomType(@RequestBody Parameters parametros) throws Exception {
		System.out.println("\nRecebendo acesso na rota 'get_dbt_geom_type'\n");

		List<String> dbtGeomTypes = new ArrayList<>();
		dbtGeomTypes = PostgresqlServices.getSearchTableGeomType(parametros.getHost(), parametros.getPort(),
				parametros.getDatabase(), parametros.getUser(), parametros.getPassword(), parametros.getTable());

		Map<String, List<String>> map = new HashMap<>();
		map.put("dbtGeomTypes", dbtGeomTypes);

		return map;
	}

}
