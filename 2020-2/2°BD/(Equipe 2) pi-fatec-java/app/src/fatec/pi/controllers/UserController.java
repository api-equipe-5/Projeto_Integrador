package fatec.pi.controllers;

import static javax.swing.JOptionPane.showMessageDialog;

import fatec.pi.daos.UserDao;
import fatec.pi.entities.User;

public class UserController {
	public static void saveValues(String name, String email, String password, Boolean admin) {
		User user = new User(name, email, password, admin);
		if(UserDao.save(user) == 1) {
			showMessageDialog(null, "Dados cadastrados com Sucesso!");
		}
	}
	
	public static User checkLogin (String email, String password) {
		User login = UserDao.login(email, password);
		if(login.getAdmin().equals(true) || login.getAdmin().equals(false)) {
			showMessageDialog(null, "Login realizado com sucesso!");
		}
		else {
			showMessageDialog(null, "Email ou senha inválidos!");
		}
		System.setProperty("userId", login.getId().toString());
		return login;
		
	}

}
