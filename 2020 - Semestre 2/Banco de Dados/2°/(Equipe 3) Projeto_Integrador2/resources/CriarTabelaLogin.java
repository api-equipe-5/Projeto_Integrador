package source;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaLogin {
	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS login ("
				+ "nome VARCHAR(30) PRIMARY KEY NOT NULL,"
				+ "senha VARCHAR(30) NOT NULL"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela 'login' criada com sucesso!!!");
		
		//já adiciona alguns logins
		PreparedStatement posted = conexao.prepareStatement("INSERT INTO login VALUES("
				+ "'admin', 'password'),"
				+ "('devanir', 'abcd1234')");
		posted.executeUpdate();

		System.out.println("Dados inseridos.");
		conexao.close();
		
	}
}
