package br.com.fatec.model.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import br.com.fatec.banco.Conexao;
import br.com.fatec.model.TipoArea;
import br.com.fatec.utils.Utils;

public class TipoAreaDaoImpl implements TipoAreaDao{

	private final String FINDBYTIPODESCRICAO = "SELECT * FROM tipo_area WHERE tipo_descricao = ?";
	
	private Conexao conexao;
	
	private PreparedStatement pstmt;
	
	private ResultSet rs;
	
	public TipoAreaDaoImpl() {
		
	}

	@Override
	public Boolean save(TipoArea tipoArea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(TipoArea tipoArea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(TipoArea tipoArea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoArea> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoArea findByTipoDescricao(String tipoDescricao) {
		
		
		TipoArea tipoArea = new TipoArea();
		conexao = new Conexao();
		
		conexao.Conectar();
		
		try {
			pstmt = conexao.getCon().prepareStatement(FINDBYTIPODESCRICAO);
			
			pstmt.setString(1, tipoDescricao.toUpperCase());
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				tipoArea.setTipoId(rs.getLong(1));
				tipoArea.setTipoDescricao(rs.getString(2));
			}
			
		} catch (SQLException e) {
			Utils.escreverLog("Erro ao buscar Tipo de área : " + e.getMessage());
		}
		
		return tipoArea;
	
	}

}
