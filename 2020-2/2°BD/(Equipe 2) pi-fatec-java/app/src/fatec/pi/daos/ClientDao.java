package fatec.pi.daos;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import fatec.pi.entities.Client;
import fatec.pi.entities.Supplier;



public class ClientDao {
	public static Integer save(Client client) {
		Integer result = 0;
		String sql = "Insert into CLIENT_REGISTER (CLIENT_CPF, "
				+ "CLIENT_NAME, "
				+ "CLIENT_ZIP_COD, "
				+ "CLIENT_STREET_NAME, "
				+ "CLIENT_STREET_NUMBER, "
				+ "CLIENT_STREET_COMPLEMENT,"
				+ "CLIENT_CITY, "
				+ "CLIENT_STATE, "
				+ "CLIENT_METER_NUMBER, "
				+ "CLIENT_MEASUREMENT_ORDER,"
				+ "CLIENT_LIGHT_CLASS,"
				+ "CLIENT_LIGHT_SUBCLASS,"
				+ "CLIENT_NORMAL_TAX,"
				+ "CLIENT_TRIBUTE_TAX,"
				+ "CLIENT_SUPPLIER_CNPJ,"
				+ "CLIENT_USER_ID,"
				+ "CLIENT_ALTER_BY) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			BaseConnection con = new BaseConnection();
			PreparedStatement saveValues = con.connection.prepareStatement(sql); // mudança de Statement para PreparedStatement
			
			// usar o method set do preparedStatement para tratar os dados fornecidos pelo usuário antes de mandar para o SQL
			saveValues.setLong(1, client.getClientCpf());
			saveValues.setString(2, client.getClientName());
			saveValues.setString(3, client.getZipCode());
			saveValues.setString(4, client.getStreetName());
			saveValues.setInt(5, client.getStreetNumber());
			saveValues.setString(6, client.getStreetComplement());
			saveValues.setString(7, client.getCity());
			saveValues.setString(8, client.getState());
			saveValues.setInt(9, client.getMeterNumber());
			saveValues.setString(10, client.getMeasurementOrder());
			saveValues.setString(11, client.getLightClass());
			saveValues.setString(12, client.getLightSubclass());
			saveValues.setBigDecimal(13, client.getNormalTax());
			saveValues.setBigDecimal(14, client.getTributeTax());
			saveValues.setLong(15, client.getSupplierCnpj());
			saveValues.setInt(16, client.getCreatedBy());
			saveValues.setInt(17, client.getAlterBy());
			
			result = saveValues.executeUpdate();
		}
		catch(SQLException err) {
			System.out.println(err);
		}
		return result;
	}
	
	

	public static List<Client> listClients(String clientCpf){
		
		List<Client> clientList = new ArrayList<>();
		
		String sql = "";
		
		if(clientCpf.equals("")) {
			sql = "Select * from CLIENT_REGISTER";
		
		
		try {
			BaseConnection con = new BaseConnection();
			PreparedStatement st = con.connection.prepareStatement(sql);
			
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Client clt = new Client(
						rs.getInt("CLIENT_ID"),
						rs.getLong("CLIENT_SUPPLIER_CNPJ"),
						rs.getLong("CLIENT_CPF"),
						rs.getString("CLIENT_NAME"),
						rs.getString("CLIENT_ZIP_COD"),
						rs.getString("CLIENT_STREET_NAME"),
						rs.getInt("CLIENT_STREET_NUMBER"),
						rs.getString("CLIENT_STREET_COMPLEMENT"),
						rs.getString("CLIENT_CITY"),
						rs.getString("CLIENT_STATE"),
						rs.getInt("CLIENT_METER_NUMBER"),
						rs.getString("CLIENT_MEASUREMENT_ORDER"),
						rs.getString("CLIENT_LIGHT_CLASS"),
						rs.getString("CLIENT_LIGHT_SUBCLASS"),
						rs.getBigDecimal("CLIENT_NORMAL_TAX"),
						rs.getBigDecimal("CLIENT_TRIBUTE_TAX"),
						rs.getInt("CLIENT_ALTER_BY"));
				clientList.add(clt);
			}
		}
			catch(SQLException err) {
				System.out.println(err);
			}
		}
	
		else {
			sql = "Select * from CLIENT_REGISTER where CLIENT_CPF = ?";
	
	
		try {
			BaseConnection con = new BaseConnection();
			PreparedStatement st = con.connection.prepareStatement(sql);
		
			st.setString(1, clientCpf);
		
			ResultSet rs = st.executeQuery();
		
			while (rs.next()) {
				Client clt = new Client(
					rs.getInt("CLIENT_ID"),
					rs.getLong("CLIENT_SUPPLIER_CNPJ"),
					rs.getLong("CLIENT_CPF"),
					rs.getString("CLIENT_NAME"),
					rs.getString("CLIENT_ZIP_COD"),
					rs.getString("CLIENT_STREET_NAME"),
					rs.getInt("CLIENT_STREET_NUMBER"),
					rs.getString("CLIENT_STREET_COMPLEMENT"),
					rs.getString("CLIENT_CITY"),
					rs.getString("CLIENT_STATE"),
					rs.getInt("CLIENT_METER_NUMBER"),
					rs.getString("CLIENT_MEASUREMENT_ORDER"),
					rs.getString("CLIENT_LIGHT_CLASS"),
					rs.getString("CLIENT_LIGHT_SUBCLASS"),
					rs.getBigDecimal("CLIENT_NORMAL_TAX"),
					rs.getBigDecimal("CLIENT_TRIBUTE_TAX"),
					rs.getInt("CLIENT_ALTER_BY"));
			clientList.add(clt);
			}
		}
		catch(SQLException err) {
			System.out.println(err);
			}
		}
	
		return clientList;

	}


	public static Integer update(Client client) {
		int result = 0;
		
		Logger logger = Logger.getLogger(ClientDao.class.getName());
		
		String sql = "UPDATE CLIENT_REGISTER SET CLIENT_CPF = ?, "
				+ "CLIENT_NAME = ?, "
				+ "CLIENT_ZIP_COD = ?, "
				+ "CLIENT_STREET_NAME = ?, "
				+ "CLIENT_STREET_NUMBER = ?, "
				+ "CLIENT_STREET_COMPLEMENT = ?, "
				+ "CLIENT_CITY = ?, "
				+ "CLIENT_STATE = ?, "
				+ "CLIENT_METER_NUMBER = ?, "
				+ "CLIENT_MEASUREMENT_ORDER = ?,"
				+ "CLIENT_LIGHT_CLASS = ?, "
				+ "CLIENT_LIGHT_SUBCLASS = ?, "
				+ "CLIENT_NORMAL_TAX = ?,"
				+ "CLIENT_TRIBUTE_TAX = ?,"
				+ "CLIENT_SUPPLIER_CNPJ = ?, "

			

				+ "CLIENT_ALTER_BY = ? "

				+ "WHERE CLIENT_ID = ?;";
		
		try{
			
			BaseConnection con = new BaseConnection();
			PreparedStatement updateValues = con.connection.prepareStatement(sql);
			
			updateValues.setLong(1, client.getClientCpf());
			updateValues.setString(2, client.getClientName());
			updateValues.setString(3, client.getZipCode());
			updateValues.setString(4, client.getStreetName());
			updateValues.setInt(5, client.getStreetNumber());
			updateValues.setString(6, client.getStreetComplement());
			updateValues.setString(7, client.getCity());
			updateValues.setString(8, client.getState());
			updateValues.setInt(9, client.getMeterNumber());
			updateValues.setString(10, client.getMeasurementOrder());
			updateValues.setString(11, client.getLightClass());
			updateValues.setString(12, client.getLightSubclass());
			updateValues.setBigDecimal(13, client.getNormalTax());
			updateValues.setBigDecimal(14, client.getTributeTax());
			updateValues.setLong(15, client.getSupplierCnpj());
			updateValues.setInt(16, client.getAlterBy());
			updateValues.setInt(17, client.getId());
			
			result = updateValues.executeUpdate();
			con.connection.close();
			
		} catch(SQLException err) {
			
			logger.info(err.getMessage());
		}
		
		return result;
		
			
		}
	

}
