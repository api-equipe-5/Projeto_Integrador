package org.jumbo.backend.model;

import java.util.List;

public class Parameters {

	private String user;
	private String password;
	private String host;
	private String port;
	private String database;
	private String table;
	private List<String> dbtColNames;
	private String shpFileName;
	private String shpFilePath;
	private List<String> selectedColumns;
	private List<String> choicedColumns;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public List<String> getDbtColNames() {
		return dbtColNames;
	}

	public void setDbtColNames(List<String> dbtColNames) {
		this.dbtColNames = dbtColNames;
	}

	public String getShpFileName() {
		return shpFileName;
	}

	public void setShpFileName(String shpFileName) {
		this.shpFileName = shpFileName;
	}

	public String getShpFilePath() {
		return shpFilePath;
	}

	public void setShpFilePath(String shpFilePath) {
		this.shpFilePath = shpFilePath;
	}

	public List<String> getSelectedColumns() {
		return selectedColumns;
	}

	public void setSelectedColumns(List<String> selectedColumns) {
		this.selectedColumns = selectedColumns;
	}

	public List<String> getChoicedColumns() {
		return choicedColumns;
	}

	public void setChoicedColumns(List<String> choicedColumns) {
		this.choicedColumns = choicedColumns;
	}

}
