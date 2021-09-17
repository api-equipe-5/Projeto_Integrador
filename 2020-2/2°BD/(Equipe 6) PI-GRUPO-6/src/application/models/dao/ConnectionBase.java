package application.models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBase {
	
	protected Connection conexao;
	
	public Connection open() {
		
		//"jdbc:mysql://localhost:3306/pi_grupo6", "root", "admin"
		//"jdbc:mysql://localhost:3306/pi_grupo6", "root", "root"
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Ok");
			
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi_grupo6", "root", "root");
			
			System.out.println("conexão ok");
			return conexao;
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void close() {
		try {
				if(conexao != null)
					conexao.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


}