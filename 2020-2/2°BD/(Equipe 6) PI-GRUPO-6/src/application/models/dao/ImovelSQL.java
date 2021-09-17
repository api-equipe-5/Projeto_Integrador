package application.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.models.Imovel;

public class ImovelSQL extends ConnectionBase {
	
	public void create(Imovel imovel) {
	
		open();
		
		try {
			String sql = "INSERT INTO imovel ";
			sql += " (id_cliente_conta, tipo_imovel, identificacao_imovel, uf_imovel, cidade_imovel, bairro_imovel, rua_imovel, num_imovel, complemento_imovel, cep_imovel) ";
			sql += "VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stm = conexao.prepareStatement(sql);
			
			stm.setInt(1, imovel.getIdCliente());
			stm.setString(2, imovel.getTipoImovel());
			stm.setInt(3,  imovel.getIdentificacaoImovel());
			stm.setString(4, imovel.getUfImovel());
			stm.setString(5, imovel.getCidadeImovel());
			stm.setString(6, imovel.getBairroImovel());
			stm.setString(7, imovel.getRuaImovel());
			stm.setString(8, imovel.getNumImovel());
			stm.setString(9, imovel.getComplementoImovel());
			stm.setString(10, imovel.getCepImovel());
			
			stm.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			close();
		}
	}
	
	
	public Imovel buscarImovelPeloCodIdentificacao(int codIdentificacao) {

		open();
		
		Imovel imovel = new Imovel();
		
		try {
			String sql = "SELECT * FROM imovel WHERE identificacao_imovel='" + codIdentificacao + "'";
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			if (rs != null && rs.next()) {
				imovel = new Imovel(rs.getInt(1),
						rs.getInt(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getString(5),
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getString(9), 
						rs.getString(10), 
						rs.getString(11));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar imovel pelo codigo de identificação");
			e.printStackTrace();
		}
		
		return imovel;
	}
	
//	public Imovel buscarImovelPeloNome(String nome) {
//
//		open();
//
//		ArrayList<Imovel> result = new ArrayList<>();
//
//		try {
//			PreparedStatement stm = conexao.prepareStatement("SELECT * FROM imovel WHERE codImovel='" + codImovel + "'");
//			ResultSet rs = stm.executeQuery();
//
//			while (rs.next()) {
//
//				Imovel imovel = new Imovel(rs.getInt(1),
//						rs.getInt(2), 
//						rs.getString(3), 
//						rs.getInt(4), 
//						rs.getString(5),
//						rs.getString(6), 
//						rs.getString(7), 
//						rs.getString(8), 
//						rs.getString(9), 
//						rs.getString(10), 
//						rs.getString(11),
//						rs.getString(12)
//						
//				);
//				result.add(imovel);
//			}
//		} catch (SQLException e) {
//			System.out.println("Exception método all");
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		return result.get(0);
//	}
		

}
	