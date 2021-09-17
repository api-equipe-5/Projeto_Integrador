package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
			
			// String que ira informar o local de acesso do BD
			final String url = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true";
			final String usuario = "root";
			final String senha = "123456789";
			
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			
			System.out.println("Conexão efetuada com sucesso!!!");
			
			conexao.close();
			
		}

}
