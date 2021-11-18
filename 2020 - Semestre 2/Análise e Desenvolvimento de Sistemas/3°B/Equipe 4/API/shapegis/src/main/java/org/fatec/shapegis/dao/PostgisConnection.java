package org.fatec.shapegis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.fatec.shapegis.model.FormConexao;

import lombok.*;

@Data // Adiciona os métodos get e set, com a biblioteca lombok
public class PostgisConnection {
	private String driverName = "org.postgresql.Driver";
	private String host;
	private String porta;
	private String bd;
	private String usuario;
	private String senha;
	// Formato -> jdbc:postgresql://host:port/database
	private String url;
	// Referência Global do tipo Connection
	Connection connection;
	
	
	//private List<String> result = new ArrayList<>();
	
	/* Old constructor
	 public ShapegisConnection(String usuario, String senha, String url) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.url = url;
	}*/
	public PostgisConnection(FormConexao form) throws SQLException, ClassNotFoundException {
		this.host = form.host;
		this.porta = form.porta;
		this.bd = form.bd;
		this.usuario = form.usuario;
		this.senha = form.senha;
		// Formato -> jdbc:postgresql://host:port/database
		this.url = "jdbc:postgresql://" + this.host + ":" + this.porta + "/" + this.bd;
				
		// Carregando o JDBC Driver padrão
		Class.forName(this.driverName);
		
		//Iniciar conexao
		connection = DriverManager.getConnection(this.url, this.usuario, this.senha);	
	}
	
	//Retorma o status da conexao
	public String status() {
		//Testar conexao
		if (connection != null) {
			return "STATUS--->Conectado com sucesso!";
		} else {
			return "STATUS--->Não foi possivel realizar conexão";
		}
	}
	//Recupera os nomes das tabelas disponíveis ao atual usuário.
	public ArrayList<String> tables() throws SQLException {
		
		ArrayList<String> list = new ArrayList<String>();
		String query = "SELECT table_name\n"
				+ "  FROM information_schema.tables\n"
				+ " WHERE table_schema='public'\n"
				//+ "  AND table_type='BASE TABLE\n' "
				+ ";";
		java.sql.Statement stmt = connection.createStatement();
		java.sql.ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			//System.out.println(rs.getString(1));
			list.add(rs.getString(1));
		}
		return list;
	}
	
	public ArrayList<String> fields(String name) throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		String query = "SELECT column_name "
				+ "FROM INFORMATION_SCHEMA.COLUMNS "
				+ "WHERE TABLE_NAME =" + "'" + name + "'" 
				//+ "AND table_schema = 'public'"
				+ ";";
		java.sql.Statement stmt = connection.createStatement();
		java.sql.ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			//System.out.println(rs.getString(1));
			list.add(rs.getString(1));
		}
		return list;
	} 
	
	//Fecha a conexao
	public void close() throws SQLException {
		connection.close();
	}
	
	

	// Método de Conexão//
	/*public java.sql.Connection getConexao() {

		Connection connection = null; // Variável de referência do tipo Connection

		try {

			// Carregando o JDBC Driver padrão
			Class.forName(this.driverName);

			
			connection = DriverManager.getConnection(this.url, this.usuario, this.senha);

			// Testa sua conexão//
			if (connection != null) {
				System.out.println("STATUS--->Conectado com sucesso!");
				this.status = "STATUS--->Conectado com sucesso!";
			} else {
				System.out.println("STATUS--->Não foi possivel realizar conexão.");
				this.status = "STATUS--->Não foi possivel realizar conexão";
			}
			return connection;
		} catch (ClassNotFoundException e) { // Driver não encontrado
			e.printStackTrace(System.err);
			return null;
		} catch (SQLException e) { // Não conseguindo se conectar ao banco
			e.printStackTrace(System.err);
			return null;
		}
	}

	// Método que retorna o status da sua conexão//
	public String statusConection() {

		return status;

	}

	// Método que fecha sua conexão//
	public boolean FecharConexao() {
		try {
			getConexao().close();
			System.out.println("Fechado...");
			return true;

		} catch (SQLException e) {
			return false;

		}

	}

	// Método que reinicia sua conexão//
	public java.sql.Connection ReiniciarConexaoComDB() {
		FecharConexao();
		System.out.println("Reiniciando conexão...");
		return getConexao();

	}
	
	
	public void resultadosBanco(String query) {
		try {

			// Perguntar ao professor, prq usar <java.sql.Statement> em vez de só
			// <Statement>
			java.sql.Statement stmt = getConexao().createStatement();
			java.sql.ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				this.result.add(rs.getString(1));
			}
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace(System.err);
		}
	}
	*/
}
