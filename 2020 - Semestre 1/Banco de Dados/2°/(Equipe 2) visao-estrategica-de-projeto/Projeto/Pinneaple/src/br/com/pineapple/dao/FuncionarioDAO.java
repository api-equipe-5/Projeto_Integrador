package br.com.pineapple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.pineapple.domain.Funcionario;
import br.com.pineapple.factory.ConexaoFactory;

public class FuncionarioDAO{
	
	public void salvar(Funcionario f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO recurso ");
		sql.append("(cpf, nome_recurso, email) ");
		sql.append("VALUES(?,?,?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getCpf());
		comando.setString(2, f.getNome());
		comando.setString(3, f.getEmail());
		
		comando.executeUpdate();
		
	}
	
	public Funcionario consultarCPF(Funcionario f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT cpf, nome_recurso, email ");
		sql.append("FROM recurso ");
		sql.append("WHERE cpf = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getCpf());
		
		ResultSet resultado = comando.executeQuery();
		
		Funcionario retorno = null;
		
		if(resultado.next()) {
			retorno = new Funcionario();
			retorno.setCpf(resultado.getString("cpf"));
			retorno.setNome(resultado.getString("nome_recurso"));
			retorno.setEmail(resultado.getString("email"));
		}
		
		return retorno;
	}
	
	public void atualizar(Funcionario f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE recurso ");
		sql.append("SET nome_recurso = ? , email = ? ");
		sql.append("WHERE cpf = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getNome());
		comando.setString(2, f.getEmail());
		comando.setString(3, f.getCpf());
		comando.executeUpdate();
	}
	
	public void excluir(Funcionario f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM recurso ");
		sql.append("WHERE cpf = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getCpf());	
		comando.executeUpdate();
		
		}
	
	public ArrayList<Funcionario> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT cpf, nome_recurso, email ");
		sql.append("FROM recurso ");
		//sql.append("ORDER BY nome ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
		
		while(resultado.next()) {
			Funcionario f = new Funcionario();
			f.setCpf(resultado.getString("cpf"));
			f.setNome(resultado.getString("nome_recurso"));
			f.setEmail(resultado.getString("email"));
			
			lista.add(f);
		}
		
		return lista;
		
	}
}
