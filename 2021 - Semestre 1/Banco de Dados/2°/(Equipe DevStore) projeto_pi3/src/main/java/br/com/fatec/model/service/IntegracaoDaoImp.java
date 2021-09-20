package br.com.fatec.model.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.fatec.banco.Conexao;
import br.com.fatec.model.Integracao;
import br.com.fatec.utils.Utils;

public class IntegracaoDaoImp implements IntegracaoDao{

	private Conexao conexao;
	
	private PreparedStatement pstmt = null;
	
	private final String INSERT = "insert into integracao (area_arquivo, integrado, data_hora_integracao, extensao_dbf, "
			                     + "extensao_shp, extensao_shx, extensao_prj, shape_arquivo, municipio_codigo) "
		                         + "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		

	public IntegracaoDaoImp() {
		this.conexao = new Conexao();
	}

	@Override
	public Boolean save(Integracao integracao) {
		
		if(conexao.Conectar()) {
			try {
				
				pstmt = conexao.getCon().prepareStatement(this.INSERT);
				
				pstmt.setString(1, integracao.getAreaArquivo());
				pstmt.setBoolean(2, integracao.getIntegrado());
				pstmt.setTimestamp(3, (Timestamp) integracao.getDataHoraIntegracao());
				pstmt.setBoolean(4, integracao.getExtensaoDBF());
				pstmt.setBoolean(5, integracao.getExtensaoSHP());
				pstmt.setBoolean(6, integracao.getExtensaoSHX());
				pstmt.setBoolean(7, integracao.getExtensaoPRJ());
				pstmt.setString(8, integracao.getShapeArquivo());
				pstmt.setString(9, integracao.getMunicipioCodigo());
				
				pstmt.executeUpdate();
				pstmt.close();
				
				conexao.Desconectar();
				return true;
			} catch (SQLException e) {
				Utils.escreverLog("Erro banco de dados Integracao " + e.getMessage());
				return false;
			}
		}
		
		return false;
	}

	@Override
	public Boolean update(Integracao integracao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Integracao integracao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integracao> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integracao findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
