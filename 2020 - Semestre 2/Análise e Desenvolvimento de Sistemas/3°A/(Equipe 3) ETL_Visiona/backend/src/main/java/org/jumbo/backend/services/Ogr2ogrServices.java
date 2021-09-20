package org.jumbo.backend.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ogr2ogrServices {

	public static void dbtToShp(String host, String user, String database, String password, String endDespacho,
			String deParaSaida, String table) throws Exception {

		System.out.println("\tExtraindo os arquivos da tabela selecionada para o diretório");
		System.out.println("\tTabela Selecionada: " + table);

		deParaSaida = deParaSaida + " from " + table;

		String programa = "\"C:\\Program Files\\QGIS 3.10\\bin\\ogr2ogr.exe\"";
		String conexao = String.format("PG:\"host=%s user=%s dbname=%s password=%s\" ", host, user, database, password);
		endDespacho = String.format("\"%s\" ", endDespacho);
		deParaSaida = String.format("\"%s\"", deParaSaida);
		String executa = programa + " -f " + "\"ESRI Shapefile\" -a_srs \"EPSG:4674\" " + endDespacho + conexao
				+ "-sql " + deParaSaida + " -lco ENCODING=UTF-8";

		System.out.println("\t" + executa);

		try {
			Process process = Runtime.getRuntime().exec(executa);

			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("\tProcesso concluído com sucesso");
			} else {
				System.out.printf("\tErro: %s\n", output);
				throw new Exception();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static String shpToDbt(String shpFileName, String shpFilePath, String parametrizar, String host, String user,
			String database, String password, String table) throws Exception {
		String typeShp, conexao;
		conexao = String.format("PG:\"host=%s user=%s dbname=%s password=%s\"", host, user, database, password);
		typeShp = ShapefileServices.getShpGeomType(shpFilePath);
		parametrizar = parametrizar + " from " + shpFileName.substring(0, shpFileName.length() - 4);
		;
		switch (typeShp) {
		case "MultiLineString":
			lineType(parametrizar, conexao, shpFilePath, table);
			return "Dados inseridos com sucesso";
		case "MultiPoint":
			pointType(parametrizar, conexao, shpFilePath, table);
			return "Dados inseridos com sucesso";
		case "MultiPolygon":
			polygonType(parametrizar, conexao, shpFilePath, table);
			return "Dados inseridos com sucesso";
		default:
			String resultado = "Tipo Incompatível " + typeShp;
			return resultado;
		}

	}

	public static void lineType(String parametrizar, String conexao, String shpFilePath, String table)
			throws Exception {
		String programa = "\"C:\\Program Files\\QGIS 3.10\\bin\\ogr2ogr.exe\"";
		String executa = programa + " -f \"PostgreSQL\" -nlt MULTILINESTRING -sql \"" + parametrizar + "\" " + conexao
				+ " \"" + shpFilePath + "\" -nln \"" + table + "\"";

		System.out.println("\t" + executa);

		try {
			Process process = Runtime.getRuntime().exec(executa);

			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("\tProcesso concluído com sucesso");
			} else {
				System.out.printf("\tErro: %s\n", output);
				throw new Exception();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void pointType(String parametrizar, String conexao, String shpFilePath, String table)
			throws Exception {
		String programa = "\"C:\\Program Files\\QGIS 3.10\\bin\\ogr2ogr.exe\"";
		String executa = programa + " -f \"PostgreSQL\" -nlt MULTIPOINT -sql \"" + parametrizar + "\" " + conexao
				+ " \"" + shpFilePath + "\" -nln \"" + table + "\"";

		System.out.println("\t" + executa);

		try {
			Process process = Runtime.getRuntime().exec(executa);

			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("\tProcesso concluído com sucesso");
			} else {
				System.out.printf("\tErro: %s\n", output);
				throw new Exception();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void polygonType(String parametrizar, String conexao, String shpFilePath, String table)
			throws Exception {
		String programa = "\"C:\\Program Files\\QGIS 3.10\\bin\\ogr2ogr.exe\"";
		String executa = programa + " -f \"PostgreSQL\" -nlt MULTIPOLYGON -sql \"" + parametrizar + "\" " + conexao
				+ " \"" + shpFilePath + "\" -nln \"" + table + "\"";

		System.out.println("\t" + executa);
		try {
			Process process = Runtime.getRuntime().exec(executa);

			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("\tProcesso concluído com sucesso");
			} else {
				System.out.printf("\tErro: %s\n", output);
				throw new Exception();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void dbtToGeojson(String host, String user, String database, String password, String table,
			String endDespacho) throws Exception {

		System.out.println("\tConvertendo dados da tabela selecionada para o GeoJSON");
		System.out.println("\tTabela Selecionada: " + table);

		endDespacho = String.format("\"%s\" ", endDespacho);
		String programa = "\"C:\\Program Files\\QGIS 3.10\\bin\\ogr2ogr.exe\"";

		String conexao = String.format("PG:\"host=%s user=%s dbname=%s password=%s\" ", host, user, database, password);

		String executa = programa + " -f " + "\"GeoJSON\" -a_srs \"crs:84\" " + endDespacho + conexao + table;

		System.out.println("\t" + executa);

		try {
			Process process = Runtime.getRuntime().exec(executa);

			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("\tProcesso concluído com sucesso");
			} else {
				System.out.printf("\tErro: %s\n", output);
				throw new Exception();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
