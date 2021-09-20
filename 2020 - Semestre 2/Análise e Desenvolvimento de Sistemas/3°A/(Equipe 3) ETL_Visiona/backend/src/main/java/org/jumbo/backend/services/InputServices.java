package org.jumbo.backend.services;

import java.util.List;

public class InputServices {

	public static String insertShpToDbt(List<String> dbtColNames, List<String> selectedColumns, String shpFileName,
			String shpFilePath, String host, String user, String database, String password, String table)
			throws Exception {
		System.out.println("\tInserido os dados na tabela selecionada");
		System.out.printf("\tEndereço do arquivo Shapefile: %s\n", shpFilePath);
		System.out.printf("\tNome do arquivo Shapefile: %s\n", shpFileName);
		System.out.printf("\tTabela selecionada: %s\n", table);

		String parametrizar = writeSqlInsert(dbtColNames, selectedColumns);

		String resultado = Ogr2ogrServices.shpToDbt(shpFileName, shpFilePath, parametrizar, host, user, database,
				password, table);

		System.out.println("\t" + resultado);

		return resultado;
	}

	public static String writeSqlInsert(List<String> dbtColNames, List<String> selectedColumns) {
		String sqlString = "select";

		for (int x = 0; x < selectedColumns.size(); x++) {
			if (selectedColumns.get(x) != "") {
				sqlString = sqlString + " " + selectedColumns.get(x) + " as " + dbtColNames.get(x) + ",";
			}
		}

		sqlString = sqlString.substring(0, sqlString.length() - 1);
		return sqlString;
	}

}
