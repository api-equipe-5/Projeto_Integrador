package br.com.fatec.model.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fatec.banco.Conexao;
import br.com.fatec.model.Parametro;

public class ParametroDaoImpl implements ParametroDao{

	Conexao conexao;
	
	PreparedStatement pstmt;
	
	ResultSet rs;
	
	private final String LISTALL = "SELECT extensao, habilitado FROM parametro WHERE habilitado = true";
	
	public ParametroDaoImpl() {
		conexao = new Conexao();
	}
	
	@Override
	public Boolean save(Parametro parametro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Parametro parametro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Parametro parametro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parametro> listAll() {
		
		Parametro parametro;
		List<Parametro> parametros = new ArrayList<Parametro>();
		
		try {
		
			conexao.Conectar();
			
			pstmt = conexao.getCon().prepareStatement(LISTALL);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			
				parametro = new Parametro(rs.getString(1), rs.getBoolean(2));
				
				parametros.add(parametro);
				
			}
			return parametros;
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			conexao.Desconectar();
		}
		
		
		return parametros;
	}

	@Override
	public Parametro findByExtesao(String extensao) {
		// TODO Auto-generated method stub
		return null;
	}

}
