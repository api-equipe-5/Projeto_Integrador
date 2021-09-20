package br.com.fatec.model.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.Normalizer;

import br.com.fatec.banco.Conexao;
import br.com.fatec.model.TipoArea;
import br.com.fatec.utils.Utils;

public class UtilsDaoImpl {
	
	private final String UPDATEIDAREACODIGOMUNICIPIO = "UPDATE area SET tipo_id = ?, municipio_codigo = ? WHERE municipio_codigo IS NULL AND tipo_id IS NULL";
	
	private final String UPDATEAREAIMOVELMUCINIPIO = "UPDATE area_imovel SET municipio_codigo = ? WHERE municipio_codigo IS NULL";
	
	private final String UPDATENASCENTEMUCINIPIO = "UPDATE nascente_olho_dagua SET municipio_codigo = ? WHERE municipio_codigo IS NULL";
	
	private final String CREATEVIEWAREA = "CREATE OR REPLACE VIEW ?" + 
			" AS" + 
			" SELECT area.gid," +
			" area.idf," + 
			" area.nom_tema," + 
			" area.num_area," +  
			" area.geom"  + 
			" FROM area" + 
			" JOIN tipo_area ON area.tipo_id = tipo_area.tipo_id"  + 
			" WHERE tipo_area.tipo_descricao::text = ?::text AND" + 
			" area.municipio_codigo::text = ?::text;"; 
	
	private final String CREATEVIEWAREAIMOVEL = "CREATE OR REPLACE VIEW ?" +
			" AS" + 
			" SELECT area_imovel.cod_imovel," +
			" area_imovel.num_area," +
			" area_imovel.cod_estado," +
			" area_imovel.nom_munici," +
			" area_imovel.num_modulo," +
			" area_imovel.tipo_imove," +
			" area_imovel.situacao," +
			" area_imovel.condicao_i," +
			" area_imovel.geom" +
			" FROM area_imovel" +
			" WHERE area_imovel.municipio_codigo = ?";
	
	private final String CREATEVIEWNASCENTE = "CREATE OR REPLACE VIEW ?" +
			" AS" +
			" SELECT nascente_olho_dagua.gid," +
		    " nascente_olho_dagua.idf," +
			" nascente_olho_dagua.tema," +
		    " nascente_olho_dagua.geom" +
		    " FROM nascente_olho_dagua" +
			" WHERE nascente_olho_dagua.municipio_codigo = ?;";
	
	private final String DELETEPORMUNICIPIO = "DELETE FROM ? WHERE ?.municipio_codigo = ?;";
	
	private final String DELETEPORMUNICIPIOAREA = "DELETE FROM ? WHERE ?.municipio_codigo = ? AND ?.tipo_id = ?;";
	
	private PreparedStatement pstmt;
	
	public void insert(String comandoSQL, Conexao conexao) {
		
		try {
			pstmt = conexao.getCon().prepareStatement(comandoSQL);
			pstmt.executeUpdate();
			pstmt.close();	
				
				
		} catch (SQLException e) {
			Utils.escreverLog("Erro banco de dados insert de areas " + e.getMessage());
				
		}
	}
	
	public void updateIdAreaCodigoMunicipio(Long IdArea, String codigoMunicipio, Conexao conexao) {
		try {
			pstmt = conexao.getCon().prepareStatement(UPDATEIDAREACODIGOMUNICIPIO);
			
			pstmt.setLong(1, IdArea);
			pstmt.setString(2, codigoMunicipio);
			
			pstmt.executeUpdate();
			pstmt.close();	
						
		} catch (SQLException e) {
			Utils.escreverLog("Erro banco de dados update da tabela AREA " + e.getMessage());
				
		}
	}
	
	public void updateAreaImovelMunicipio(String codigoMunicipio, Conexao conexao) {
		try {
			pstmt = conexao.getCon().prepareStatement(UPDATEAREAIMOVELMUCINIPIO);
			
			pstmt.setString(1, codigoMunicipio);
			
			pstmt.executeUpdate();
			pstmt.close();	
						
		} catch (SQLException e) {
			Utils.escreverLog("Erro banco de dados update da tabela AREA " + e.getMessage());
				
		}
	}
	
	public void updateNascentelMunicipio(String codigoMunicipio, Conexao conexao) {
		try {
			
			pstmt = conexao.getCon().prepareStatement(UPDATENASCENTEMUCINIPIO);
			
			pstmt.setString(1, codigoMunicipio);
			
			pstmt.executeUpdate();
			pstmt.close();	
						
		} catch (SQLException e) {
			Utils.escreverLog("Erro banco de dados update da tabela AREA " + e.getMessage());
				
		}
	}
	
	public void criarViewMunicipio(String view, String estado, String municipio, String codigoMunicipio) {
		
		Conexao conexao = new Conexao();
		String nomeView = "";
		
		try {
			conexao.Conectar();
			nomeView = estado + "_" + Utils.removerEspaco(Utils.removerAcentos(municipio.trim())) +"_"+ 
					view;
			
			
			if(view.toUpperCase().equals("AREA_IMOVEL")){
				
				pstmt = conexao.getCon().prepareStatement(CREATEVIEWAREAIMOVEL);
				pstmt.setString(1, nomeView);
				pstmt.setString(2, codigoMunicipio);
				
			}else if(view.toUpperCase().equals("NASCENTE_OLHO_DAGUA")) {
				
				pstmt = conexao.getCon().prepareStatement(CREATEVIEWNASCENTE);
				pstmt.setString(1, nomeView);
				pstmt.setString(2, codigoMunicipio);
			}else {
				pstmt = conexao.getCon().prepareStatement(CREATEVIEWAREA);
				pstmt.setString(1, nomeView);
				pstmt.setString(2, view.toUpperCase());
				pstmt.setString(3, codigoMunicipio);
			}
						
			pstmt = conexao.getCon().prepareStatement(pstmt.toString().replace("'" + nomeView +"'", nomeView));
			pstmt.execute();
			pstmt.close();	
			
			conexao.Desconectar();				
		} catch (SQLException e) {
			Utils.escreverLog("Erro ao criar a view " + nomeView + " " + e.getMessage());
				
		}
	}
	
	public void deletePorMunicipio(String view, String codigoMunicipio) {
		
		Conexao conexao = new Conexao();
		TipoArea tipoArea =  new TipoArea();
		TipoAreaDaoImpl tipoAreaDaoImpl = new TipoAreaDaoImpl();
		
		
		try {
			conexao.Conectar();
			
			if(!view.toUpperCase().equals("AREA_IMOVEL") && !view.toUpperCase().equals("NASCENTE_OLHO_DAGUA")) {
				
				tipoArea = tipoAreaDaoImpl.findByTipoDescricao(view);
				
				view = "area";
				pstmt = conexao.getCon().prepareStatement(DELETEPORMUNICIPIOAREA);
				pstmt.setString(1, view);
				pstmt.setString(2, view);
				pstmt.setString(3, codigoMunicipio);
				pstmt.setString(4, view);
				pstmt.setLong(5, tipoArea.getTipoId());
			}else {
				pstmt = conexao.getCon().prepareStatement(DELETEPORMUNICIPIO);
				pstmt.setString(1, view);
				pstmt.setString(2, view);
				pstmt.setString(3, codigoMunicipio);
			}
			
			Utils.escreverLog(pstmt.toString().replaceAll("'" + view + "'", view));
			
			pstmt = conexao.getCon().prepareStatement(pstmt.toString().replace("'" + view +"'", view));
			pstmt.execute();
			
			pstmt.close();	
			conexao.Desconectar();				
		} catch (SQLException e) {
			Utils.escreverLog("Erro ao deletar dados do banco " + view + " " + e.getMessage());
				
		}
	}
	
}
