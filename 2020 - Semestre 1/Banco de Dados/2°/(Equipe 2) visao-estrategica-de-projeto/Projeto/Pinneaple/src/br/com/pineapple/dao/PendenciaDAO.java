package br.com.pineapple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.pineapple.domain.Pendencia;
import br.com.pineapple.factory.ConexaoFactory;

public class PendenciaDAO {

	public void salvar(Pendencia p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO pendencia ");
		sql.append("( tarefa_pai, tarefa_filha) ");
		sql.append("VALUES(?,?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getTarefa_pai());
		comando.setString(2, p.getTarefa_filha());
		
		comando.executeUpdate();
		
	}
	
	public Pendencia consultarPendencia(Pendencia p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT *");
		sql.append("FROM pendencia ");
		sql.append("WHERE and tarefa_pai = ? and tarefa_filha = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getTarefa_pai());
		comando.setString(2, p.getTarefa_filha());
		comando.setString(3, p.getTarefa_pai());
		comando.setString(4, p.getTarefa_filha());
		
		ResultSet resultado = comando.executeQuery();
		
		Pendencia retorno = null;
		
		if(resultado.next()) {
			retorno = new Pendencia();
			retorno.setTarefa_pai(resultado.getString("tarefa_pai"));
			retorno.setTarefa_filha(resultado.getString("tarefa_filha"));
		}
		
		return retorno;
	}
	
	public void atualizar(Pendencia p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE pendencia");
		sql.append("SET tarefa_pai = ? , tarefa_filha = ? ");
		sql.append("WHERE id = ? , tarefa_pai = ? && tarefa_filha = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getTarefa_pai());
		comando.setString(2, p.getTarefa_filha());
		comando.setString(3, p.getTarefa_pai());
		comando.setString(4, p.getTarefa_filha());
		comando.executeUpdate();
	}
	
	public void excluir(Pendencia p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM pendencia ");
		sql.append("WHERE tarefa_pai = ? && tarefa_filha = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getTarefa_pai());
		comando.setString(2, p.getTarefa_filha());
		comando.executeUpdate();
		
		}
	
	public ArrayList<Pendencia> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
		sql.append("FROM pendencia ");
		//sql.append("ORDER BY nome ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Pendencia> lista = new ArrayList<Pendencia>();
		
		while(resultado.next()) {
			Pendencia p = new Pendencia();
			p.setTarefa_pai(resultado.getString("tarefa_pai"));
			p.setTarefa_filha(resultado.getString("tarefa_filha"));
			
			lista.add(p);
		}
		
		return lista;
		
	}

}
