package br.com.pineapple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.pineapple.domain.Tarefa;
import br.com.pineapple.factory.ConexaoFactory;

public class TarefaDAO {
	
	public void salvar(Tarefa t) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tarefa ");
		sql.append("(nome_tarefa, data_inicio, data_termino) ");
		sql.append("VALUES(?,?,?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, t.getNome_tarefa());
		comando.setString(2, t.getData_inicio());
		comando.setString(3, t.getData_termino());
		
		comando.executeUpdate();
		
	}

	public Tarefa consultarTarefa(Tarefa t) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
		sql.append("FROM tarefa ");
		sql.append("WHERE nome_tarefa = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, t.getNome_tarefa());
		
		ResultSet resultado = comando.executeQuery();
		
		Tarefa retorno = null;
		
		if(resultado.next()) {
			retorno = new Tarefa();
			retorno.setNome_tarefa(resultado.getString("nome_tarefa"));
			retorno.setData_inicio(resultado.getString("data_inicio"));
			retorno.setData_termino(resultado.getString("data_termino"));
		}
		
		return retorno;
	}
	
	public void atualizar(Tarefa t) throws SQLException{
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE tarefa ");
		sql.append("SET data_inicio = ? , data_termino = ? ");
		sql.append("WHERE nome_tarefa = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, t.getData_inicio());
		comando.setString(2, t.getData_termino());
		comando.setString(3, t.getNome_tarefa());
		comando.executeUpdate();
		conexao.close();
	}
	
	public void excluir(Tarefa t) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tarefa ");
		sql.append("WHERE nome_tarefa = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, t.getNome_tarefa());	
		comando.executeUpdate();
		
		}
	
	public ArrayList<Tarefa> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
		sql.append("FROM tarefa ");
		//sql.append("ORDER BY nome_tarefa ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Tarefa> lista = new ArrayList<Tarefa>();
		
		while(resultado.next()) {
			Tarefa t = new Tarefa();
			t.setNome_tarefa(resultado.getString("nome_tarefa"));
			t.setData_inicio(resultado.getString("data_inicio"));
			t.setData_termino(resultado.getString("data_termino"));
			
			lista.add(t);
		}
		
		return lista;
	}
	
}
