package fatec.pi.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fatec.pi.entities.Supplier;

public class SupplierDao {
	public static Integer save(Supplier supplier) {
		Integer result = 0;
		String sql = "Insert into SUPPLIER (SUPPLIER_CNPJ, SUPPLIER_NAME, SUPPLIER_SITE, SUPPLIER_TYPE, SUPPLIER_USER_ID, SUPPLIER_ALTER_BY) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			BaseConnection con = new BaseConnection();
			PreparedStatement saveValues = con.connection.prepareStatement(sql);
			

			saveValues.setLong(1, supplier.getCnpj());
			saveValues.setString(2, supplier.getName());
			saveValues.setString(3, supplier.getSite());
			saveValues.setInt(4, supplier.getType());
			saveValues.setInt(5, supplier.getCreatedBy());
			saveValues.setInt(6, supplier.getAlterBy());
			
			result = saveValues.executeUpdate();
			con.connection.close();

		}
		catch(SQLException err) {
			System.out.println(err);
		}
		return result;
	}
	

	public static List<Supplier> listSuppliers(String cnpj) {
		
		List<Supplier> supplierList = new ArrayList<>();
		String sql = "";
		
		if(cnpj.equals("")) {
			sql = "Select * from SUPPLIER";
			
			try {
				BaseConnection con = new BaseConnection();
				PreparedStatement st = con.connection.prepareStatement(sql);
				
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()) {
					Supplier sup = new Supplier(
							rs.getInt("SUPPLIER_ID"),
							rs.getLong("SUPPLIER_CNPJ"), 
							rs.getString("SUPPLIER_NAME"), 
							rs.getString("SUPPLIER_SITE"),
							rs.getInt("SUPPLIER_TYPE"),
							rs.getInt("SUPPLIER_ALTER_BY"));
					supplierList.add(sup);
				}
			}
			catch(SQLException err) {
				System.out.println(err);
			}
			
		}
		else {
			sql = "Select * from SUPPLIER where SUPPLIER_CNPJ = ?";
			
			try {
				BaseConnection con = new BaseConnection();
				PreparedStatement st = con.connection.prepareStatement(sql);
				
				st.setString(1, cnpj);
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()) {
					Supplier sup = new Supplier(
							rs.getInt("SUPPLIER_ID"),

							rs.getLong("SUPPLIER_CNPJ"), 
							rs.getString("SUPPLIER_NAME"), 
							rs.getString("SUPPLIER_SITE"),
							rs.getInt("SUPPLIER_TYPE"),
							rs.getInt("SUPPLIER_ALTER_BY"));
					supplierList.add(sup);
				}
			}
			catch(SQLException err) {
				System.out.println(err);
			}
		}
		return supplierList;
	}
	
	public static Integer update(Supplier supplier) {
		
		Integer result = 0;
		
		Logger logger = Logger.getLogger(SupplierDao.class.getName());
		
		
		String sql = "UPDATE SUPPLIER SET SUPPLIER_CNPJ = ?, "
				+ "SUPPLIER_NAME = ?, "
				+ "SUPPLIER_SITE = ?, "
				+ "SUPPLIER_TYPE = ?,"
				+ "SUPPLIER_ALTER_BY = ? "
				+ "WHERE SUPPLIER_ID = ?;";
		
		try {
			
			BaseConnection con = new BaseConnection();
			PreparedStatement updateValues = con.connection.prepareStatement(sql);
			

			updateValues.setLong(1, supplier.getCnpj());
			updateValues.setString(2, supplier.getName());
			updateValues.setString(3, supplier.getSite());
			updateValues.setInt(4, supplier.getType());
			updateValues.setInt(5, supplier.getAlterBy());
			updateValues.setInt(6, supplier.getId());
			
			result = updateValues.executeUpdate();
			con.connection.close();
			
		} catch(SQLException err) {
			
			logger.info(err.getMessage());
		}
		return result;
	}
	
	
	
}
