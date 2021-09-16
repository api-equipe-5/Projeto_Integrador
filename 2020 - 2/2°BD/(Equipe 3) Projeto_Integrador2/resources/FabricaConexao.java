package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class FabricaConexao {
	private static String user;
	private static String password;
	
	public static Connection getConexao() {
			
			try {
				String url = "jdbc:mysql://localhost/projeto_integrador?verifyServerCertificate=false&useSSL=true&useTimezone=true&serverTimezone=UTC";
				String usuario = user;
				String senha = password;
				
				// CRIANDO CONEXAO
				return DriverManager.getConnection(url, usuario, senha);
			} catch(SQLException e) {	
				JOptionPane.showConfirmDialog(null, "Oh não!\n\n"
						+ "Infelizmente ocorreu algum erro\n"
						+ "conectando ao Banco de Dados.\n\n"
						+ "Tente novamente.\n"
						+ "Revise os campos!", "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		}

	public static String getUser() {
		return user;
	}

	public static String getPassword() {
		return password;
	}

	public static void setUser(String user) {
		FabricaConexao.user = user;
	}

	public static void setPassword(String password) {
		FabricaConexao.password = password;
	}

}
