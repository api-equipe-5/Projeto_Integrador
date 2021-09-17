package source;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelas {
	
	public static void main() throws SQLException {
		cliente();
		local();
		conta_agua();
		ref_agua();
		conta_luz();
		ref_luz();
		login();
		}
	
	public static void cliente() throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS cliente ("
				+ "id_cli int PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+ "nome_cli VARCHAR(50) NOT NULL,"
				+ "cnpj_cli CHAR(18) NOT NULL,"
				+ "telefone_cli VARCHAR(20) NOT NULL"
				+ ")";
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		System.out.println("Cliente criada com sucesso!!!");
		
		PreparedStatement posted = conexao.prepareStatement("INSERT IGNORE INTO cliente (nome_cli, cnpj_cli, telefone_cli) VALUES"
				+ "('Loja Variedades', '11.222.333/0001-11', '1199123456'),"
				+ "('Livraria Papel Novo', '22.222.555/0010-10', '11997894567'),"
				+ "('Mercadinho do José', '12.099.123/0004-06', '12992428534'),"
				+ "('Utensilhos Já', '25.551.946/0880-06', '11992922277'),"
				+ "('Leve Mais Poupe Mais', '20.202.587/0590-19', '11997585090'),"
				+ "('Loucos por Tech', '12.292.525/202-20', '11998755494')");
		posted.executeUpdate();
		
		System.out.println("Cliente - dados criados com sucesso!!!");
	}
	
	public static void local() throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS local ("
				+ "id_loc int PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+ "id_cli int NOT NULL,"
				+ "endereco VARCHAR(70) NOT NULL,"
				+ "complemento VARCHAR(100),"
				+ "cep VARCHAR(20) NOT NULL,"
				+ "cidade VARCHAR(40) NOT NULL,"
				+ "uf CHAR(2) NOT NULL,"
				+ "pais CHAR (2) NOT NULL,"
				+ "FOREIGN KEY (id_cli) REFERENCES cliente(id_cli)"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		System.out.println("Local criada com sucesso!!!");
		
		PreparedStatement posted = conexao.prepareStatement("INSERT IGNORE INTO local (id_cli, endereco, complemento, cep, cidade, uf, pais) VALUES"
				+ "('1', 'Rua Para', 'Bairro Jardim Alvorada', '12289367', 'Caçapava', 'SP', 'BR'),"
				+ "('2', 'Rua Maranhao', 'Bairro Jardim Alvorada', '12289368', 'Caçapava', 'SP', 'BR'),"
				+ "('3', 'Avenida Brasil', 'Centro', '25479952', 'São Paulo', 'SP', 'BR'),"
				+ "('4', 'Avenida Paulista', 'Centro', '59621485', 'São Paulo', 'SP', 'BR'),"
				+ "('5', 'Rua São João', 'Atrás do apartamento Unity', '15948632', 'Taubate', 'SP', 'BR'),"
				+ "('6', 'Rua Coronel Manuel', '', '98745635', 'São José', 'SP', 'BR')");
		posted.executeUpdate();
		System.out.println("Local - dados criados com sucesso!!!");
	}
	

	public static void conta_agua() throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS conta_agua ("
				+ "rgi VARCHAR(15) PRIMARY KEY NOT NULL,"
				+ "id_local int NOT NULL,"
				+ "FOREIGN KEY (id_local) REFERENCES local(id_loc)"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		System.out.println("Conta_agua criada com sucesso!!!");
		
		PreparedStatement posted = conexao.prepareStatement("INSERT IGNORE INTO conta_agua(rgi, id_local) VALUES"
				+ "('05101222/72', '1'),"
				+ "('10569542/51', '2'),"
				+ "('30269194/07', '5')");
		posted.executeUpdate();
		
		System.out.println("Conta_agua - dados criados com sucesso!!!");
	}
	
	public static void ref_agua() throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS ref_agua ("
				+ "id_ref int PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+ "rgi VARCHAR(15) NOT NULL,"
				+ "nome VARCHAR(50),"
				+ "conta VARCHAR(15) NOT NULL,"
				+ "mes VARCHAR(15) NOT NULL,"
				+ "consumo VARCHAR(10) NOT NULL,"
				+ "total VARCHAR(15) NOT NULL,"
				+ "vencimento VARCHAR(15) NOT NULL,"
				+ "digitador VARCHAR(20) NOT NULL,"
				+ "FOREIGN KEY (rgi) REFERENCES conta_agua(rgi)"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		System.out.println("Ref_agua criada com sucesso!!!");
		
		PreparedStatement posted = conexao.prepareStatement("INSERT IGNORE INTO ref_agua (rgi, conta, mes, consumo, total, vencimento, digitador) VALUES"
				+ "('05101222/72', '1490051012221', 'Outubro', '19', '109.53', '02/10/2020', 'Devanir'),"
				+ "('05101222/72', '1492051012221', 'Dezembro', '18', '102.78', '06/12/2020', 'Devanir'),"
				+ "('10569542/51', '1490000832181', 'Setembro', '26', '180.78', '10/09/2020', 'Devanir'),"
				+ "('10569542/51', '149005092421', 'Outubro', '26', '185.09', '08/10/2020', 'Jonatas'),"
				+ "('10569542/51', '149015139973', 'Novembro', '25', '178.17', '08/11/2020', 'Jonatas'),"
				+ "('30269194/07', '1492101014478', 'Dezembro', '21', '129.55', '04/12/2020', 'Tairik')");
		posted.executeUpdate();
		System.out.println("Ref_agua - dados criados com sucesso!!!");
	}
	
	public static void ref_luz() throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS ref_luz ("
				+ "id_luz int PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+ "instalacao VARCHAR(15) NOT NULL,"
				+ "nome VARCHAR(50),"
				+ "vencimento CHAR(10) NOT NULL,"
				+ "mes VARCHAR(9) NOT NULL,"
				+ "consumo VARCHAR(15) NOT NULL,"
				+ "tarifa VARCHAR(15) NOT NULL,"
				+ "pis VARCHAR(15) NOT NULL,"
				+ "confins VARCHAR(15) NOT NULL,"
				+ "icms VARCHAR(15) NOT NULL,"
				+ "total_pagar VARCHAR(10) NOT NULL,"
				+ "Digitador VARCHAR(20) NOT NULL,"
				+ "FOREIGN KEY (instalacao) REFERENCES conta_luz(instalacao)"
				+ ")engine=InnoDB";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		System.out.println("Ref_luz criada com sucesso!!!");
		
		PreparedStatement posted = conexao.prepareStatement("INSERT IGNORE INTO ref_luz (instalacao, vencimento, mes, consumo, tarifa, pis, confins, icms, total_pagar, digitador) VALUES"
				+ "('8960446', '09/11/2020', 'Outubro', '258', '0.266885710', '1.30', '6.02', '47.77', '191.07', 'Devanir'),"
				+ "('8960446', '07/10/2020', 'Setembro', '266', '0.26449000', '0.63', '2.90', '47.79', '194.50', 'Devanir'),"
				+ "('8960446', '09/09/2020', 'Agosto', '231', '0.26449000', '0.36', '1.65', '41.16', '164.62', 'Devanir'),"
				+ "('9548625', '10/10/2020', 'Setembro', '255', '0.26522000', '0.60', '3.95', '44.53', '172.11', 'Jonatas'),"
				+ "('5894562', '08/11/2020', 'Outubro', '262', '0.26414000', '0.90', '4.60', '46.22', '180.34', 'Tairik')");
		posted.executeUpdate();
		System.out.println("Ref_luz - dados criados com sucesso!!!");
	}
	
	public static void conta_luz() throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS conta_luz ("
				+ "instalacao VARCHAR(15) PRIMARY KEY NOT NULL,"
				+ "id_local int NOT NULL,"
				+ "FOREIGN KEY (id_local) REFERENCES local(id_loc)"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		System.out.println("Conta_luz criada com sucesso!!!");
		
		PreparedStatement posted = conexao.prepareStatement("INSERT IGNORE INTO conta_luz (instalacao, id_local) VALUES"
				+ "('8960446', '1'),"
				+ "('9548625', '2'),"
				+ "('5894562', '3')");
		posted.executeUpdate();
		
		System.out.println("Conta_luz - dados criados com sucesso!!!");
	}
	
	public static void login() throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS login ("
				+ "nome VARCHAR(20) PRIMARY KEY NOT NULL,"
				+ "senha VARCHAR(20) NOT NULL"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela 'login' criada com sucesso!!!");
		
		//já adiciona alguns logins
		PreparedStatement posted = conexao.prepareStatement("INSERT IGNORE INTO login VALUES"
				+ "('admin', 'password'),"
				+ "('devanir', 'abcd1234')");
		posted.executeUpdate();

		System.out.println("Dados inseridos.");
		conexao.close();
		
	}
	
	public static void criarlogin(String nome, String senha) throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		PreparedStatement posted = conexao.prepareStatement("INSERT INTO login VALUES('" + nome + "', '" + senha +"')");
		posted.executeUpdate();
		
	}
	
}