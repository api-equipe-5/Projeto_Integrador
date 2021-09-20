package org.jumbo.backend.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostgresqlServices {

	public static Connection getConnection(String host, String port, String database, String user, String password)
			throws SQLException {
		System.out.println("\tIniciando a conexão");
		System.out.printf("\tParâmetros recebidos: %s, %s, %s, %s, %s\n", user, password, host, port, database);

		String url = String.format("jdbc:postgresql://%s:%s/%s", host, port, database);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}

	public static List<String> getTables(String host, String port, String database, String user, String password)
			throws Exception {
		List<String> tabelas = new ArrayList<>();
		Connection con = getConnection(host, port, database, user, password);

		System.out.println("\tLendo nomes das tabelas do banco");

		Statement stmt = con.createStatement();
		ResultSet rs = stmt
				.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'");
		while (rs.next()) {
			tabelas.add(rs.getString(1));
		}
		stmt.close();
		con.close();
		tabelas = tabelas.subList(3, tabelas.size());
		tabelas = tabelas.stream().sorted().collect(Collectors.toList());

		System.out.println("\tTabelas existentes: " + tabelas);

		return tabelas;

	}

	public static List<String> getDbtColNames(String table, String host, String port, String database, String user,
			String password) throws SQLException {

		List<String> colunasDb = new ArrayList<>();
		List<String> chaves = new ArrayList<>();

		Connection con = getConnection(host, port, database, user, password);
		Statement stmt = con.createStatement();

		System.out.println("\tLendo nomes das colunas da tabela selecionada");
		System.out.println("\tTabela selecionada: " + table);

		String colNamesStr = String
				.format("SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = '%s';", table);
		String chvsPrimStr = String.format(
				"SELECT column_name" + " FROM information_schema.table_constraints"
						+ " JOIN information_schema.key_column_usage"
						+ " USING (constraint_catalog, constraint_schema, constraint_name, table_catalog, table_name)"
						+ " WHERE constraint_type = 'PRIMARY KEY' AND (table_name) = ('%s') ORDER BY ordinal_position;",
				table);

		ResultSet rsColNames = stmt.executeQuery(colNamesStr);
		ResultSet rsChvsPrim = stmt.executeQuery(chvsPrimStr);

		while (rsChvsPrim.next()) {

			chaves.add(rsChvsPrim.getString(1));
		}

		while (rsColNames.next()) {

			colunasDb.add(rsColNames.getString(1));
		}

		colunasDb.remove("geom");

		colunasDb.removeAll(chaves);

		stmt.close();
		con.close();

		System.out.println("\t" + colunasDb);

		return colunasDb;
	}

	public static List<String> getDbtGeomType(String host, String port, String database, String user, String password)
			throws Exception {

		List<String> tabelas = new ArrayList<>();

		List<String> tables = new ArrayList<>();
		tables = getTables(host, port, database, user, password);

		Connection con = getConnection(host, port, database, user, password);

		Statement stmt = con.createStatement();

		System.out.println("\tLendo geomtype das tabelas do banco");

		for (String table : tables) {
			String querystring = String.format(
					"SELECT type FROM geometry_columns WHERE f_table_schema = 'public' AND f_table_name = '%s' and f_geometry_column = 'geom';",
					table);
			ResultSet rs = stmt.executeQuery(querystring);
			if (rs.next()) {
				tabelas.add(rs.getString(1));
			} else {
				tabelas.add("NOGEOM");
			}
		}
		stmt.close();
		con.close();

		System.out.println("\tGeomType: " + tabelas);
		return tabelas;

	}

	public static List<String> getMultipointTables(String host, String port, String database, String user,
			String password) throws Exception {

		List<String> tabelas = new ArrayList<>();

		List<String> tables = new ArrayList<>();
		tables = getTables(host, port, database, user, password);

		Connection con = getConnection(host, port, database, user, password);

		Statement stmt = con.createStatement();

		System.out.println("\tFiltrando tabelas do tipo MULTIPOINT");

		for (String table : tables) {
			String querystring = String.format(
					"SELECT type FROM geometry_columns WHERE f_table_schema = 'public' AND f_table_name = '%s' and f_geometry_column = 'geom';",
					table);
			ResultSet rs = stmt.executeQuery(querystring);
			while (rs.next()) {
				if (rs.getString(1).contains("MULTIPOINT")) {
					tabelas.add(table);
				}
			}
		}
		stmt.close();
		con.close();

		System.out.println("\tTabelas Encontradas: " + tabelas);
		return tabelas;

	}

	public static List<String> getMultilinestringTables(String host, String port, String database, String user,
			String password) throws Exception {

		List<String> tabelas = new ArrayList<>();

		List<String> tables = new ArrayList<>();
		tables = getTables(host, port, database, user, password);

		Connection con = getConnection(host, port, database, user, password);

		Statement stmt = con.createStatement();

		System.out.println("\tFiltrando tabelas do tipo MULTILINESTRING");

		for (String table : tables) {
			String querystring = String.format(
					"SELECT type FROM geometry_columns WHERE f_table_schema = 'public' AND f_table_name = '%s' and f_geometry_column = 'geom';",
					table);
			ResultSet rs = stmt.executeQuery(querystring);
			while (rs.next()) {
				if (rs.getString(1).contains("MULTILINESTRING")) {
					tabelas.add(table);
				}
			}
		}
		stmt.close();
		con.close();

		System.out.println("\tTabelas Encontradas: " + tabelas);
		return tabelas;

	}

	public static List<String> getMultipolygonTables(String host, String port, String database, String user,
			String password) throws Exception {

		List<String> tabelas = new ArrayList<>();

		List<String> tables = new ArrayList<>();
		tables = getTables(host, port, database, user, password);

		Connection con = getConnection(host, port, database, user, password);

		Statement stmt = con.createStatement();

		System.out.println("\tFiltrando tabelas do tipo MULTIPOLYGON");

		for (String table : tables) {
			String querystring = String.format(
					"SELECT type FROM geometry_columns WHERE f_table_schema = 'public' AND f_table_name = '%s' and f_geometry_column = 'geom';",
					table);
			ResultSet rs = stmt.executeQuery(querystring);
			while (rs.next()) {
				if (rs.getString(1).contains("MULTIPOLYGON")) {
					tabelas.add(table);
				}
			}
		}
		stmt.close();
		con.close();

		System.out.println("\tTabelas Encontradas: " + tabelas);
		return tabelas;

	}

	public static List<String> searchTable(String host, String port, String database, String user, String password,
			String table) throws Exception {
		List<String> tabelas = new ArrayList<>();
		Connection con = getConnection(host, port, database, user, password);

		System.out.println("\tProcurando tabela...");

		Statement stmt = con.createStatement();

		String sqlQuery = "select table_schema," + " table_name" + " from information_schema.tables"
				+ " where table_name like '%" + table + "%'"
				+ " and table_schema not in ('information_schema', 'pg_catalog')" + " and table_type = 'BASE TABLE'"
				+ " order by table_name," + " table_schema;";

		System.out.println("\t" + sqlQuery);

		ResultSet rs = stmt.executeQuery(sqlQuery);
		while (rs.next()) {
			tabelas.add(rs.getString(2));
		}
		stmt.close();
		con.close();

		System.out.println("\tTabelas Encontradas: " + tabelas);
		return tabelas;
	}

	public static List<String> getSearchTableGeomType(String host, String port, String database, String user,
			String password, String table) throws Exception {

		List<String> tabelas = new ArrayList<>();

		List<String> tables = new ArrayList<>();
		tables = searchTable(host, port, database, user, password, table);

		Connection con = getConnection(host, port, database, user, password);

		Statement stmt = con.createStatement();

		System.out.println("\tLendo geomtype das tabelas do banco");

		for (String tab : tables) {
			String querystring = String.format(
					"SELECT type FROM geometry_columns WHERE f_table_schema = 'public' AND f_table_name = '%s' and f_geometry_column = 'geom';",
					tab);
			ResultSet rs = stmt.executeQuery(querystring);
			if (rs.next()) {
				tabelas.add(rs.getString(1));
			} else {
				tabelas.add("NOGEOM");
			}
		}
		stmt.close();
		con.close();

		System.out.println("\tGeomType: " + tabelas);
		return tabelas;

	}

}
