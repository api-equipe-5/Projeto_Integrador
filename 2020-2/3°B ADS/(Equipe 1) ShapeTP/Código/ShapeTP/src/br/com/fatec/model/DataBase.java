package br.com.fatec.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

public class DataBase {
    private final String url;
    private final String user;
    private final String pass;
    private Connection conn;
    private final Statement stmt;
    
    public DataBase() throws ClassNotFoundException, SQLException {
        this.user = "postgres";
        this.pass = "postgres";
        this.url = "jdbc:postgresql://localhost:5432/postgis";
        Class.forName("org.postgresql.Driver");
        this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
        this.stmt = this.conn.createStatement();
    }
    
    public void connect() throws SQLException {
        if (this.conn == null) {
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
        }
    }
    
    public void disconnect() throws SQLException {
        if (this.conn != null) {
            this.conn.close();
            this.conn = null;
        }
    }
    
    public void insertInto(final String t, final String tCol, final String sCol, final String s) throws SQLException {
        this.stmt.executeUpdate(String.format("INSERT INTO fatecsjc.\"%s\" (%s) SELECT %s FROM fatecsjc.\"%s\"", t, tCol, sCol, s));
        this.stmt.executeUpdate(String.format("DROP TABLE fatecsjc.\"%s\"", s));
    }
    
    public ArrayList<String> getTables() throws SQLException {
        final ResultSet rst = this.stmt.executeQuery("SELECT tablename FROM pg_catalog.pg_tables WHERE schemaname = 'fatecsjc'");
        final ArrayList<String> list = new ArrayList<String>();
        while (rst.next()) {
            list.add(rst.getString("tablename"));
        }
        return list;
    }
    
    @SuppressWarnings("rawtypes")
	public ArrayList<ArrayList> getColumns(final String tableName) throws SQLException {
        final ResultSet rst = this.stmt.executeQuery(
        		String.format(
        				"(SELECT f_geometry_column AS column, type AS type FROM geometry_columns " +
        				"WHERE f_table_schema = 'fatecsjc' AND f_table_name = '%s' AND " +
        				"f_geometry_column = 'geom') UNION ALL (SELECT column_name, data_type " +
        				"FROM information_schema.columns WHERE table_name = '%s' AND " +
        				"table_schema = 'fatecsjc' AND data_type <> 'USER-DEFINED' AND " +
        				"column_name <> 'gid');", tableName, tableName));
        final ArrayList<ArrayList> result = new ArrayList<ArrayList>();
        final ArrayList<String> column = new ArrayList<String>();
        final ArrayList<String> type = new ArrayList<String>();
        while (rst.next()) {
            column.add(rst.getString("column"));
            switch (rst.getString("type")) {
                case "bigint": {
                    type.add("numeric");
                    continue;
                }
                case "character varying": {
                    type.add("varchar");
                    continue;
                }
                default:
                    break;
            }
            type.add(rst.getString("type"));
        }
        result.add(column);
        result.add(type);
        return result;
    }
}