package fatec.pi.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fatec.pi.entities.Supplier;
import fatec.pi.entities.WaterAccount;


public class WaterAccountDao {
	public static Integer save(WaterAccount water) {
		Integer result = 0;
		String sql = "Insert into WATER_ACCOUNT (ACCOUNT_NUMBER, "
				+ "ACCOUNT_DUE_DATE, "
				+ "ACCOUNT_PENALTY, "
				+ "ACCOUNT_CONSUMPTION, "
				+ "ACCOUNT_POLLUTION, "
				+ "ACCOUNT_SEWER, "
				+ "ACCOUNT_WATER, "
				+ "ACCOUNT_PIS, "
				+ "ACCOUNT_OTHERS, "
				+ "ACCOUNT_SUPPLIER_CNPJ,"
				+ "ACCOUNT_USER_ID,"
				+ "ACCOUNT_ALTER_BY) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 

		try {
			BaseConnection con = new BaseConnection();
			PreparedStatement saveValues = con.connection.prepareStatement(sql);
			
			saveValues.setInt(1, water.getNumber());
			saveValues.setString(2, water.getDueDate());
			saveValues.setBigDecimal(3, water.getPenalty());
			saveValues.setBigDecimal(4, water.getConsumptionValue());
			saveValues.setBigDecimal(5, water.getPollutionValue());
			saveValues.setBigDecimal(6, water.getSewerValue());
			saveValues.setBigDecimal(7, water.getWaterValue());
			saveValues.setInt(8, water.getPisPercentage());
			saveValues.setBigDecimal(9, water.getOtherValues());
			saveValues.setLong(10, water.getSupplierCnpj());
			saveValues.setInt(11, water.getCreatedBy());
			saveValues.setInt(12, water.getAlterBy());
			
			result = saveValues.executeUpdate();
			con.connection.close();

		}
		catch(SQLException err) {
			System.out.println(err);
		}
		return result;
	}	
	
	public static List<WaterAccount> listWaterAccounts(String installation) {
		
		List<WaterAccount> WaterAccountList = new ArrayList<>();
		String sql = "";
		

		if(installation.equals("")) {

			sql = "Select * from WATER_ACCOUNT;";
			
			try {
				BaseConnection con = new BaseConnection();
				PreparedStatement st = con.connection.prepareStatement(sql);
				
				ResultSet result = st.executeQuery();
				
				
				while(result.next()) {
				
					Integer id           = result.getInt("ACCOUNT_ID");
					Integer accountNumber = result.getInt("ACCOUNT_NUMBER");
					String      dueDate  = result.getString("ACCOUNT_DUE_DATE");
					BigDecimal	penalty  = result.getBigDecimal("ACCOUNT_PENALTY");
					BigDecimal  consumpition = result.getBigDecimal("ACCOUNT_CONSUMPTION");
					BigDecimal	polluition  = result.getBigDecimal("ACCOUNT_POLLUTION");
					BigDecimal  sewer = result.getBigDecimal("ACCOUNT_SEWER");
					BigDecimal	water = result.getBigDecimal("ACCOUNT_WATER");
					Integer     pis      = result.getInt("ACCOUNT_PIS");
					BigDecimal	other = result.getBigDecimal("ACCOUNT_OTHERS");
					Long      sup  = result.getLong("ACCOUNT_SUPPLIER_CNPJ");
					Integer alterBy = result.getInt("ACCOUNT_ALTER_BY");
				
				WaterAccount wat = new WaterAccount(id,accountNumber, dueDate, penalty,consumpition,polluition,sewer,water,pis,other,sup, alterBy);
				WaterAccountList.add(wat);
				System.out.println(wat.toString());
				con.connection.close();

				}
			}
			
			catch(SQLException err) {
				System.out.println(err);
			}	
		
		}
		else {
			sql = "Select * from WATER_ACCOUNT where ACCOUNT_NUMBER = ?;" ;
		
			try {
				BaseConnection con = new BaseConnection();
				PreparedStatement st = con.connection.prepareStatement(sql);
				
				st.setString(1, installation);
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()) {
					WaterAccount wat = new WaterAccount(
							rs.getInt("ACCOUNT_ID"),
							rs.getInt("ACCOUNT_NUMBER"),
							rs.getString("ACCOUNT_DUE_DATE"),
							rs.getBigDecimal("ACCOUNT_PENALTY"),
							rs.getBigDecimal("ACCOUNT_CONSUMPTION"),
							rs.getBigDecimal("ACCOUNT_POLLUTION"),
							rs.getBigDecimal("ACCOUNT_SEWER"),					
							rs.getBigDecimal("ACCOUNT_WATER"),
							rs.getInt("ACCOUNT_PIS"),
							rs.getBigDecimal("ACCOUNT_OTHERS"),
							rs.getLong("ACCOUNT_SUPPLIER_CNPJ"),
							rs.getInt("ACCOUNT_ALTER_BY"));
												
					WaterAccountList.add(wat);
				}
			}
			catch(SQLException err) {
				System.out.println(err);
			}
		}
				
		return WaterAccountList;
	}
	
	public static Integer update(WaterAccount water) {
		
		int result = 0;
		
		Logger logger = Logger.getLogger(WaterAccountDao.class.getName());
		
		
		String sql = "UPDATE WATER_ACCOUNT SET ACCOUNT_NUMBER = ?, "
				+ "ACCOUNT_DUE_DATE = ?, "
				+ "ACCOUNT_PENALTY = ?, "
				+ "ACCOUNT_CONSUMPTION = ?, "
				+ "ACCOUNT_POLLUTION = ?, "
				+ "ACCOUNT_SEWER = ?, "
				+ "ACCOUNT_WATER = ?, "
				+ "ACCOUNT_PIS = ?, "
				+ "ACCOUNT_OTHERS = ?, "
				+ "ACCOUNT_SUPPLIER_CNPJ = ?,"
				+ "ACCOUNT_ALTER_BY = ? "
				+ "WHERE ACCOUNT_ID = ?;";
		
		try {
			
			BaseConnection con = new BaseConnection();
			PreparedStatement updateValues = con.connection.prepareStatement(sql);
			
			updateValues.setInt(1, water.getNumber());
			updateValues.setString(2, water.getDueDate());
			updateValues.setBigDecimal(3, water.getPenalty());
			updateValues.setBigDecimal(4, water.getConsumptionValue());
			updateValues.setBigDecimal(5, water.getPollutionValue());
			updateValues.setBigDecimal(6, water.getSewerValue());
			updateValues.setBigDecimal(7, water.getWaterValue());
			updateValues.setInt(8, water.getPisPercentage());
			updateValues.setBigDecimal(9, water.getOtherValues());
			updateValues.setLong(10, water.getSupplierCnpj());
			updateValues.setInt(11, water.getAlterBy());
			updateValues.setInt(12, water.getId());
			
			result = updateValues.executeUpdate();
			con.connection.close();
			
		} catch(SQLException err) {
			
			logger.info(err.getMessage());
		}
		
		return result;
	}
	
	public static Integer delete(WaterAccount water) {
		
		int result = 0;
		
		Logger logger = Logger.getLogger(WaterAccountDao.class.getName());
		
		String sql = "DELETE FROM WATER_ACCOUNT "
				+ "WHERE ID = ?;";
		
		try {
			
			BaseConnection con = new BaseConnection();
			PreparedStatement updateValues = con.connection.prepareStatement(sql);
			
			updateValues.setInt(1, water.getId());
			
			result = updateValues.executeUpdate();
			con.connection.close();
			
		} catch(SQLException err) {
			
			logger.info(err.getMessage());
		}
		
		return result;
	}
}
