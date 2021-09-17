package fatec.pi.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import fatec.pi.entities.User;

public class UserDao {
	public static Integer save(User user) {
		Integer result = 0;
		String sql = "Insert into PIUSER(USER_NAME, USER_EMAIL, USER_PASSWORD, USER_ADMIN) VALUES (?, ?, ?, ?)";
		
		try {
			BaseConnection con = new BaseConnection();
			PreparedStatement saveValues = con.connection.prepareStatement(sql);
			
			saveValues.setString(1, user.getName());
			saveValues.setString(2, user.getEmail());
			saveValues.setString(3, user.getPassword());
			saveValues.setBoolean(4, user.getAdmin());
			
			result = saveValues.executeUpdate();
			con.connection.close();
		}
		catch(SQLException err) {
			System.out.println(err);
		}
		return result;
	}
	
	public static User login(String email, String password) {

		String sql = "Select * from PIUSER WHERE USER_EMAIL = ? AND USER_PASSWORD = ?";
		User user = new User();
		
		try {
			BaseConnection con = new BaseConnection();
			PreparedStatement listUser = con.connection.prepareStatement(sql);
			
			listUser.setString(1, email);
			listUser.setString(2, password);
			
			ResultSet result = listUser.executeQuery();
			
			if (result.next()) {
				Integer userId = result.getInt("USER_ID");
				String name = result.getString("USER_NAME");
				String userEmail = result.getString("USER_EMAIL");
				String pass = result.getString("USER_PASSWORD");
				Boolean adm = result.getBoolean("USER_ADMIN");
				user = new User(userId,name, userEmail, pass, adm);
			}
			
		}
		catch(SQLException err) {
			System.out.println(err);
		}
		return user;
	}
}