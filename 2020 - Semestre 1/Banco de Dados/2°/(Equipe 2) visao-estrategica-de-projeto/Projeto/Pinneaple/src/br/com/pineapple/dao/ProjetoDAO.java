package br.com.pineapple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.pineapple.domain.Funcionario;
import br.com.pineapple.domain.Projeto;
import br.com.pineapple.factory.ConexaoFactory;

public class ProjetoDAO {
	public void salvar(Projeto p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO projeto ");
		sql.append("(nome_projeto, data_inicio, data_termino) ");
		sql.append("VALUES(? ,? ,?);");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, p.getNome());
		comando.setString(2, p.getInicio());
		comando.setString(3, p.getEntrega());

		comando.executeUpdate();
		
	}
	public void atualizar(Projeto p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE projeto ");
		sql.append("SET data_termino = ?, data_inicio = ? ");
		sql.append("WHERE nome_projeto = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(3, p.getNome());
		comando.setString(2, p.getInicio());
		comando.setString(1, p.getEntrega());
		
		comando.executeUpdate();
		
		conexao.close();
	}
	
	public void excluir(Projeto p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM projeto ");
		sql.append("WHERE nome_projeto = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getNome());	
		comando.executeUpdate();
		
		}
	
	public ArrayList<Projeto> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
		sql.append("FROM projeto");
		//sql.append("ORDER BY nome ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Projeto> lista = new ArrayList<Projeto>();
		
		while(resultado.next()) {
			Projeto p = new Projeto();
			p.setNome(resultado.getString("nome_projeto"));
			p.setInicio(resultado.getString("data_inicio"));	
			p.setEntrega(resultado.getString("data_termino"));
			lista.add(p);
		}
		
		return lista;
		
	}
	public Projeto consultarNome(Projeto p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
		sql.append("FROM projeto ");
		sql.append("WHERE nome_projeto = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getNome());
		
		ResultSet resultado = comando.executeQuery();
		
		Projeto retorno = null;
		
		if(resultado.next()) {
			retorno = new Projeto();		
			retorno.setNome(resultado.getString("nome_projeto"));
			retorno.setInicio(resultado.getString("data_inicio"));
			retorno.setEntrega(resultado.getString("data_termino"));
		}
		
		return retorno;
	}

}
