package br.com.fatec.model.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.fatec.banco.Conexao;
import br.com.fatec.model.Estado;
import br.com.fatec.utils.Utils;

public class EstadoDaoImpl implements EstadoDao{
	
	private Conexao conexao;
	
	private PreparedStatement pstmt;
	
	private ResultSet rs;
	
	private final String FINDBYCODIGOESTADO = "SELECT estado_codigo, estado_sigla, estado_descricao nome FROM estado WHERE estado_codigo = ?";

	@Override
	public Boolean save(Estado estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Estado estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Estado estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estado> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estado findByCodigoEstado(String codigoEstado) {
		
		Estado estado = new Estado();
		conexao = new Conexao();
		try {
			
			conexao.Conectar();
			
			pstmt = conexao.getCon().prepareStatement(FINDBYCODIGOESTADO);
			pstmt.setString(1, codigoEstado);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				estado = new Estado(rs.getString(1), rs.getString(2), rs.getString(3));
			}
			
			return estado;
			
		}catch (Exception e) {
			Utils.escreverLog("Erro banco de dados Estado " + e.getMessage());
			
		}finally {
			conexao.Desconectar();
		}
		return estado;
	}

}
