package br.com.pineapple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.pineapple.domain.TarFunc;
import br.com.pineapple.domain.TarProj;
import br.com.pineapple.factory.ConexaoFactory;

public class TarFuncDAO {
	public void salvar(TarFunc tf) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO rel_tarefa_recurso ");
		sql.append("(nome_tarefa, cpf_recurso) ");
		sql.append("VALUES(?,?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, tf.getNome_tarefa());
		comando.setString(2, tf.getCpf());
		
		comando.executeUpdate();
		
	}

	public TarFunc consultarTarefa(TarFunc tf) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
		sql.append("FROM rel_tarefa_recurso ");
		sql.append("WHERE nome_tarefa = ? && cpf_recurso = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, tf.getNome_tarefa());
		comando.setString(2, tf.getCpf());
		
		ResultSet resultado = comando.executeQuery();
		
		TarFunc retorno = null;
		
		if(resultado.next()) {
			retorno = new TarFunc();
			retorno.setNome_tarefa(resultado.getString("nome_tarefa"));
			retorno.setCpf(resultado.getString("cpf_recurso"));
		}
		
		return retorno;
	}
	
	public void atualizar(TarFunc tf) throws SQLException{
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE rel_tarefa_recurso ");
		sql.append("SET nome_tarefa = ? , cpf_recurso = ? ");
		sql.append("WHERE nome_tarefa = ? AND cpf_recurso = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, tf.getNome_tarefa());
		comando.setString(2, tf.getCpf());
		comando.setString(3, tf.getNome_tarefa());
		comando.setString(4, tf.getCpf());
		comando.executeUpdate();
	}
	
	public void excluir(TarFunc tf) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM rel_tarefa_recurso ");
		sql.append("WHERE nome_tarefa = ? AND cpf_recurso = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, tf.getNome_tarefa());
		comando.setString(2, tf.getCpf());
		comando.executeUpdate();
		
		}
	
	public ArrayList<TarFunc> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
		sql.append("FROM rel_tarefa_recurso ");
		//sql.append("ORDER BY nome_tarefa ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<TarFunc> lista = new ArrayList<TarFunc>();
		
		while(resultado.next()) {
			TarFunc tf = new TarFunc();
			tf.setNome_tarefa(resultado.getString("nome_tarefa"));
			tf.setCpf(resultado.getString("cpf_recurso"));
			
			lista.add(tf);
		}
		
		return lista;
	}
	
}
