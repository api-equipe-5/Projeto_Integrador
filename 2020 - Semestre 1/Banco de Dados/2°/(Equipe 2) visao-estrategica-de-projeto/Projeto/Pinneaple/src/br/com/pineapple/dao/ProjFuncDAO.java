package br.com.pineapple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.pineapple.domain.ProjFunc;
import br.com.pineapple.domain.Projeto;
import br.com.pineapple.factory.ConexaoFactory;

public class ProjFuncDAO {
	public void salvar(ProjFunc r) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO rel_projeto_recurso ");
		sql.append("(nome_projeto, cpf_recurso) ");
		sql.append("VALUES(?,?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, r.getNome());
		comando.setString(2, r.getCpf());
				
		comando.executeUpdate();
		
	}
	
	public void excluir(ProjFunc r) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM rel_projeto_recurso ");
		sql.append("WHERE nome_projeto = ? AND cpf_recurso = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, r.getNome());	
		comando.setString(2, r.getCpf());
		comando.executeUpdate();
		
		}
	
	public ArrayList<ProjFunc> listar(ProjFunc r) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
		sql.append("FROM rel_projeto_recurso ");
		sql.append("WHERE nome_projeto = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, r.getNome());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<ProjFunc> lista = new ArrayList<ProjFunc>();
		
		while(resultado.next()) {
			ProjFunc r1 = new ProjFunc();
			r1.setCpf(resultado.getString("cpf_recurso"));	
			lista.add(r1);
		}
		
		return lista;
		
	}
	
	public ProjFunc consultarNome(ProjFunc r) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT cpf_recurso ");
		sql.append("FROM rel_projeto_recurso ");
		sql.append("WHERE nome_projeto = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, r.getNome());
		
		ResultSet resultado = comando.executeQuery();
		
		ProjFunc retorno = null;
		
		if(resultado.next()) {
			retorno = new ProjFunc();		
			retorno.setCpf(resultado.getString("cpf_recurso"));
		}
		
		return retorno;
	}

}
