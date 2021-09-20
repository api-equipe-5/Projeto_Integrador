package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "postgres";
	private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/consultcar";
	
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = createConnection();
		
		if(con != null) {
			System.out.println("Conexão realizada com sucesso!");
		}
	}
}
