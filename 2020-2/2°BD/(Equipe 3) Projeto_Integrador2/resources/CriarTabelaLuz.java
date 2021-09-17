package source;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaLuz {
	
	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS conta_luz ("
				+ "instalacao VARCHAR(15) PRIMARY KEY NOT NULL,"
				+ "nomeCliente VARCHAR(80) NOT NULL,"
				+ "vencimento VARCHAR(15) NULL,"
				+ "contaMes VARCHAR(15) NOT NULL,"
				+ "consumo VARCHAR(15) NOT NULL,"
				+ "tarifa VARCHAR(15) NOT NULL,"
				+ "pis VARCHAR(15) NOT NULL,"
				+ "confins VARCHAR(15) NOT NULL,"
				+ "icms VARCHAR(15) NOT NULL,"
				+ "totalPagar VARCHAR(15) NOT NULL"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela criada com sucesso!!!");
		conexao.close();
	}

}
