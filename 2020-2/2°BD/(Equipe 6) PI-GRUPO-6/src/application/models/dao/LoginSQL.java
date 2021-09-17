package application.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginSQL extends ConnectionBase {

	public void buscarUsuario(String nomeUsuarioLogin, String senhaLogin){
		try {
			PreparedStatement stm = conexao.prepareStatement(String.format
					("SELECT * FROM usuario WHERE nome_user = {0} and senha_user = {1}", nomeUsuarioLogin, senhaLogin));

			ResultSet rs = stm.executeQuery();
			
			System.out.println(rs);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
}
