package br.com.fatec.model.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.fatec.banco.Conexao;
import br.com.fatec.model.Municipio;
import br.com.fatec.utils.Utils;

public class MunicipioDaoImpl implements MunicipioDao{
	
	private Conexao conexao;
	
	private PreparedStatement pstmt;
	
	private ResultSet rs;
	
	private final String FINDBYCODIGOMUNICIPIO = "SELECT municipio_codigo, municipio_descricao, estado_codigo FROM municipio WHERE municipio_codigo = ?";

	@Override
	public Boolean save(Municipio municipio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Municipio municipio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Municipio municipio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Municipio> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Municipio findByCodigoMunicipio(String codigoMunicipio) {
		
		Municipio municipio = new Municipio();
		conexao =  new Conexao();
		try {
			
			conexao.Conectar();
			
			pstmt = conexao.getCon().prepareStatement(FINDBYCODIGOMUNICIPIO);
			pstmt.setString(1, codigoMunicipio);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				municipio = new Municipio(rs.getString(1), rs.getString(2));
				municipio.setCodigoEstado(rs.getString(3));
			}
			
			return municipio;
			
		}catch (Exception e) {
			Utils.escreverLog("Erro banco de dados Município " + e.getMessage());
			
		}finally {
			conexao.Desconectar();
		}
		
		return municipio;
		
	}

}
