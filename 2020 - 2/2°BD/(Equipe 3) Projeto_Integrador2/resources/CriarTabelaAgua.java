package source;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;


import source.FabricaConexao;

public class CriarTabelaAgua {
	
	public static void main(String[] args) throws SQLException {
			
			Connection conexao = FabricaConexao.getConexao();
			
			String sql = "CREATE TABLE IF NOT EXISTS conta_agua ("
					+ "rgi VARCHAR(15) PRIMARY KEY NOT NULL,"
					+ "nome VARCHAR(80) NOT NULL,"
					+ "conta VARCHAR(15) NOT NULL,"
					+ "mes VARCHAR(15) NOT NULL,"
					+ "consumo VARCHAR(10) NOT NULL,"
					+ "total VARCHAR(15) NOT NULL,"
					+ "vencimento VARCHAR(15) NOT NULL"
					+ ")";
			
			Statement stmt = conexao.createStatement();
			stmt.execute(sql);
			
			System.out.println("Tabela criada com sucesso!!!");
			conexao.close();
		}

}
