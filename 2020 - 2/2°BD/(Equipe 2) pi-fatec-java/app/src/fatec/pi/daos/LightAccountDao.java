package fatec.pi.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fatec.pi.entities.LightAccount;

public class LightAccountDao {
	
	public static Integer save(LightAccount light) {
		
		Integer result = 0;
		String sql = "Insert into LIGHT_ACCOUNT (LIGHT_IDENT_COD, "
				+ "LIGHT_METER_NUMBER, "
				+ "LIGHT_INVOICE, "
				+ "LIGHT_CURRENT_DATE, "
				+ "LIGHT_DUE_DATE, "
				+ "LIGHT_CONSUMPTION_DAYS, "
				+ "LIGHT_FLAG_TYPE, "
				+ "LIGHT_CONSUMPTION_VALUE, "
				+ "LIGHT_PIS_PERCENTAGE, "
				+ "LIGHT_COFINS_PERCENTAGE, "
				+ "LIGHT_ICMS_BASIS, "
				+ "LIGHT_ICMS_PERCENTAGE, "
				+ "LIGHT_ICMS_VALUE, "
				+ "LIGHT_PIS_COFINS_BASIS, "
				+ "LIGHT_PIS_VALUE, "
				+ "LIGHT_COFINS_VALUE, "
				+ "LIGHT_FORFEIT_VALUE, "
				+ "LIGHT_INTEREST_VALUE, "
				+ "LIGHT_OTHER_VALUES, "
				+ "LIGHT_SUPPLY_VALUES, "
				+ "LIGHT_FINANCIAL_ITEMS, "
				+ "LIGHT_AMOUNT, "
				+ "LIGHT_SUPPLIER_CNPJ,"
				+ "LIGHT_USER_ID,"
				+ "LIGHT_ALTER_BY) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			BaseConnection con = new BaseConnection();
			PreparedStatement saveValues = con.connection.prepareStatement(sql);
			
			saveValues.setInt(1, light.getIdentCod());
			saveValues.setInt(2, light.getMeterNumber());
			saveValues.setString(3, light.getInvoice());
			saveValues.setString(4, light.getCurrentDate());
			saveValues.setString(5, light.getDueDate());
			saveValues.setInt(6, light.getConsumptionDays());
			saveValues.setString(7, light.getFlagType());
			saveValues.setBigDecimal(8, light.getConsumptionValue());
			saveValues.setBigDecimal(9, light.getPisPercentage());
			saveValues.setBigDecimal(10, light.getCofinsPercentage());
			saveValues.setBigDecimal(11, light.getIcmsBasis());
			saveValues.setBigDecimal(12, light.getIcmsPercentage());
			saveValues.setBigDecimal(13, light.getIcmsValue());
			saveValues.setBigDecimal(14, light.getPisCofinsBasis());
			saveValues.setBigDecimal(15, light.getPisValue());
			saveValues.setBigDecimal(16, light.getCofinsValue());
			saveValues.setBigDecimal(17, light.getForfeitValue());
			saveValues.setBigDecimal(18, light.getInterestValue());
			saveValues.setBigDecimal(19, light.getOtherValues());
			saveValues.setBigDecimal(20, light.getSupplyValue());
			saveValues.setBigDecimal(21, light.getFinancialItems());
			saveValues.setBigDecimal(22, light.getAmount());
			saveValues.setLong(23, light.getSupplierCnpj());
			saveValues.setInt(24, light.getCreatedBy());
			saveValues.setInt(25, light.getAlterBy());
			
			result = saveValues.executeUpdate();
		}
		catch(SQLException err) {
			System.out.println(err);
		}
		
		return result;
	}		
	
	public static List <LightAccount> listLightAccounts(String identCod){
		
		List<LightAccount> lightList = new ArrayList<>();
		
		String sql = "";
		
		if(identCod.equals("")) {
			
			sql = "Select * from LIGHT_ACCOUNT";
		
		try {
			BaseConnection con = new BaseConnection();
			PreparedStatement st = con.connection.prepareStatement(sql);

			


			st.executeQuery();
			ResultSet rs = st.getResultSet();

			
			while (rs.next()) {
				LightAccount light = new LightAccount(
						rs.getInt("LIGHT_ID"),
						rs.getInt("LIGHT_IDENT_COD"),
						rs.getInt("LIGHT_METER_NUMBER"),
						rs.getString("LIGHT_INVOICE"),
						rs.getString("LIGHT_CURRENT_DATE"),
						rs.getString("LIGHT_DUE_DATE"),
						rs.getInt("LIGHT_CONSUMPTION_DAYS"),
						rs.getString("LIGHT_FLAG_TYPE"),
						rs.getBigDecimal("LIGHT_CONSUMPTION_VALUE"),
						rs.getBigDecimal("LIGHT_PIS_PERCENTAGE"),
						rs.getBigDecimal("LIGHT_COFINS_PERCENTAGE"),
						rs.getBigDecimal("LIGHT_ICMS_BASIS"),
						rs.getBigDecimal("LIGHT_ICMS_PERCENTAGE"),
						rs.getBigDecimal("LIGHT_ICMS_VALUE"),
						rs.getBigDecimal("LIGHT_PIS_COFINS_BASIS"),
						rs.getBigDecimal("LIGHT_PIS_VALUE"),
						rs.getBigDecimal("LIGHT_COFINS_VALUE"),
						rs.getBigDecimal("LIGHT_FORFEIT_VALUE"),
						rs.getBigDecimal("LIGHT_INTEREST_VALUE"),
						rs.getBigDecimal("LIGHT_OTHER_VALUES"),
						rs.getBigDecimal("LIGHT_SUPPLY_VALUES"),
						rs.getBigDecimal("LIGHT_FINANCIAL_ITEMS"),
						rs.getBigDecimal("LIGHT_AMOUNT"),
						rs.getLong("LIGHT_SUPPLIER_CNPJ"),
						rs.getInt("LIGHT_ALTER_BY"));
				lightList.add(light);
				
			}
		}
		catch(SQLException err) {
			System.out.println(err);
			}
		}
		else {
			sql = "Select * from LIGHT_ACCOUNT where LIGHT_IDENT_COD = ?";
		try {
			BaseConnection con = new BaseConnection();
			PreparedStatement st = con.connection.prepareStatement(sql);
			
			st.setString(1, identCod);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				LightAccount light = new LightAccount(
						rs.getInt("LIGHT_ID"),
						rs.getInt("LIGHT_IDENT_COD"),
						rs.getInt("LIGHT_METER_NUMBER"),
						rs.getString("LIGHT_INVOICE"),
						rs.getString("LIGHT_CURRENT_DATE"),
						rs.getString("LIGHT_DUE_DATE"),
						rs.getInt("LIGHT_CONSUMPTION_DAYS"),
						rs.getString("LIGHT_FLAG_TYPE"),
						rs.getBigDecimal("LIGHT_CONSUMPTION_VALUE"),
						rs.getBigDecimal("LIGHT_PIS_PERCENTAGE"),
						rs.getBigDecimal("LIGHT_COFINS_PERCENTAGE"),
						rs.getBigDecimal("LIGHT_ICMS_BASIS"),
						rs.getBigDecimal("LIGHT_ICMS_PERCENTAGE"),
						rs.getBigDecimal("LIGHT_ICMS_VALUE"),
						rs.getBigDecimal("LIGHT_PIS_COFINS_BASIS"),
						rs.getBigDecimal("LIGHT_PIS_VALUE"),
						rs.getBigDecimal("LIGHT_COFINS_VALUE"),
						rs.getBigDecimal("LIGHT_FORFEIT_VALUE"),
						rs.getBigDecimal("LIGHT_INTEREST_VALUE"),
						rs.getBigDecimal("LIGHT_OTHER_VALUES"),
						rs.getBigDecimal("LIGHT_SUPPLY_VALUES"),
						rs.getBigDecimal("LIGHT_FINANCIAL_ITEMS"),
						rs.getBigDecimal("LIGHT_AMOUNT"),
						rs.getLong("LIGHT_SUPPLIER_CNPJ"),
						rs.getInt("LIGHT_ALTER_BY"));
				lightList.add(light);
			}
			
		}	catch(SQLException err) {
			System.out.println(err);
			}
		
	}
		return lightList;
		
	}
	
	
		public static Integer update(LightAccount light) {

				Integer result = 0;
				Logger logger = Logger.getLogger(SupplierDao.class.getName());
				


				String sql = "UPDATE LIGHT_ACCOUNT SET LIGHT_IDENT_COD = ?,"
				+ "LIGHT_METER_NUMBER = ?,"
				+ "LIGHT_INVOICE = ?,"
				+ "LIGHT_CURRENT_DATE = ?,"
				+ "LIGHT_DUE_DATE = ?,"
				+ "LIGHT_CONSUMPTION_DAYS= ?,"
				+ "LIGHT_FLAG_TYPE = ?,"
				+ "LIGHT_CONSUMPTION_VALUE = ?,"
				+ "LIGHT_PIS_PERCENTAGE = ?,"
				+ "LIGHT_COFINS_PERCENTAGE = ?,"
				+ "LIGHT_ICMS_BASIS = ?,"
				+ "LIGHT_ICMS_PERCENTAGE = ?,"
				+ "LIGHT_ICMS_VALUE = ?,"
				+ "LIGHT_PIS_COFINS_BASIS = ?,"
				+ "LIGHT_PIS_VALUE = ?,"
				+ "LIGHT_COFINS_VALUE = ?,"
				+ "LIGHT_FORFEIT_VALUE = ?,"
				+ "LIGHT_INTEREST_VALUE = ?,"
				+ "LIGHT_OTHER_VALUES = ?,"
				+ "LIGHT_SUPPLY_VALUES = ?,"
				+ "LIGHT_FINANCIAL_ITEMS = ?,"
				+ "LIGHT_AMOUNT = ?,"
				+ "LIGHT_SUPPLIER_CNPJ = ?,"
				+ "LIGHT_ALTER_BY = ? "
				+ "WHERE LIGHT_ID = ?;";
		
		try {
			
			BaseConnection con = new BaseConnection();
			PreparedStatement updateValues = con.connection.prepareStatement(sql);
			
			
			updateValues.setInt(1, light.getIdentCod());
			updateValues.setInt(2, light.getMeterNumber());
			updateValues.setString(3, light.getInvoice());
			updateValues.setString(4, light.getCurrentDate());
			updateValues.setString(5, light.getDueDate());
			updateValues.setInt(6, light.getConsumptionDays());
			updateValues.setString(7, light.getFlagType());
			updateValues.setBigDecimal(8, light.getConsumptionValue());
			updateValues.setBigDecimal(9, light.getPisPercentage());
			updateValues.setBigDecimal(10, light.getCofinsPercentage());
			updateValues.setBigDecimal(11, light.getIcmsBasis());
			updateValues.setBigDecimal(12, light.getIcmsPercentage());
			updateValues.setBigDecimal(13, light.getIcmsValue());
			updateValues.setBigDecimal(14, light.getPisCofinsBasis());
			updateValues.setBigDecimal(15, light.getPisValue());
			updateValues.setBigDecimal(16, light.getCofinsValue());
			updateValues.setBigDecimal(17, light.getForfeitValue());
			updateValues.setBigDecimal(18, light.getInterestValue());
			updateValues.setBigDecimal(19, light.getOtherValues());
			updateValues.setBigDecimal(20, light.getSupplyValue());
			updateValues.setBigDecimal(21, light.getFinancialItems());
			updateValues.setBigDecimal(22, light.getAmount());
			updateValues.setLong(23, light.getSupplierCnpj());
			updateValues.setInt(24, light.getAlterBy());
			updateValues.setInt(25, light.getId());
			
			
			result = updateValues.executeUpdate();
			con.connection.close();
			
		} catch(SQLException err) {
			
			logger.info(err.getMessage());
			
		}
		
		return result;
	}

		public static Integer delete(Integer id) {
		
			int result = 0;
		
			Logger logger = Logger.getLogger(LightAccountDao.class.getName());
		
			String sql = "DELETE FROM LIGHT_ACCOUNT WHERE ACCOUNT_ID = ?;";
		
			try {
			
				BaseConnection con = new BaseConnection();
				PreparedStatement updateValues = con.connection.prepareStatement(sql);
			
				updateValues.setInt(1, id);
				
				result = updateValues.executeUpdate();
				con.connection.close();
			
			} catch(SQLException err) {
			
				logger.info(err.getMessage());
			}
		
			return result;
		}

}
