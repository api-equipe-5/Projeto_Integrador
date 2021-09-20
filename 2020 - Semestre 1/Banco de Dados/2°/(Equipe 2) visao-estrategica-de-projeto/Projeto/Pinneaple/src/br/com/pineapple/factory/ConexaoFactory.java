package br.com.pineapple.factory;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConexaoFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "admin";
	private static final String URL = "jdbc:mysql://localhost:3306/pineapple?useTimezone=true&serverTimezone=UTC&useSSL=false";
	
	public static Connection conectar() throws SQLException { 
		DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
}
