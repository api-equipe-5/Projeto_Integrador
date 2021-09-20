package br.com.pineapple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.pineapple.domain.TarProj;

import br.com.pineapple.factory.ConexaoFactory;

public class TarProjDAO {
	
	public void salvar(TarProj tp) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO rel_tarefa_projeto ");
		sql.append("(nome_tarefa, nome_projeto) ");
		sql.append("VALUES(?,?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, tp.getNome_tarefa());
		comando.setString(2, tp.getNome_projeto());
		
		comando.executeUpdate();
		
	}
	
	public TarProj consultarTarProj(TarProj tp) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT *");
		sql.append("FROM rel_tarefa_projeto ");
		sql.append("WHERE nome_tarefa = ? && nome_projeto = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, tp.getNome_tarefa());
		comando.setString(2, tp.getNome_projeto());
		comando.setString(3, tp.getNome_tarefa());
		comando.setString(4, tp.getNome_projeto());
		
		ResultSet resultado = comando.executeQuery();
		
		TarProj retorno = null;
		
		if(resultado.next()) {
			retorno = new TarProj();
			retorno.setNome_tarefa(resultado.getString("nome_tarefa"));
			retorno.setNome_projeto(resultado.getString("nome_projeto"));
		}
		
		return retorno;
	}
	
	public void atualizar(TarProj tp) throws SQLException{
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE rel_tarefa_projeto");
		sql.append("SET nome_tarefa = ? , nome_projeto = ? ");
		sql.append("WHERE nome_tarefa = ? && nome_projeto = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, tp.getNome_tarefa());
		comando.setString(2, tp.getNome_projeto());
		comando.setString(3, tp.getNome_tarefa());
		comando.setString(4, tp.getNome_projeto());
		comando.executeUpdate();
	}
	
	public void excluir(TarProj tp) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM rel_tarefa_projeto ");
		sql.append("WHERE nome_tarefa = ? && nome_projeto = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, tp.getNome_tarefa());
		comando.setString(2, tp.getNome_projeto());
		comando.executeUpdate();
		
		}
	
	public ArrayList<TarProj> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
		sql.append("FROM rel_tarefa_projeto ");
		//sql.append("ORDER BY nome ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<TarProj> lista = new ArrayList<TarProj>();
		
		while(resultado.next()) {
			TarProj tp = new TarProj();
			tp.setNome_tarefa(resultado.getString("nome_tarefa"));
			tp.setNome_projeto(resultado.getString("nome_projeto"));
			
			lista.add(tp);
		}
		
		return lista;
		
	}
	
	public ArrayList<TarProj> listarEdit(TarProj t) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
		sql.append("FROM rel_tarefa_projeto ");
		sql.append("WHERE nome_projeto = ?");
		//sql.append("ORDER BY nome ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, t.getNome_projeto());
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<TarProj> lista = new ArrayList<TarProj>();
		
		while(resultado.next()) {
			TarProj tp = new TarProj();
			tp.setNome_tarefa(resultado.getString("nome_tarefa"));
			tp.setNome_projeto(resultado.getString("nome_projeto"));
			
			lista.add(tp);
		}
		
		return lista;
		
	}


}
