package application.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.models.Usuario;

public class UsuarioSQL extends ConnectionBase {

	public UsuarioSQL() {

//		open();
//
//		try {
//			PreparedStatement stm = conexao.prepareStatement(
//					"CREATE TABLE IF NOT EXISTS usuario (" + "id_user int PRIMARY KEY NOT NULL AUTO_INCREMENT,"
//							+ "nome_user VARCHAR(40)," + "cpf_user VARCHAR(11)," + "login_user VARCHAR(20),"
//							+ "senha_user VARCHAR(20)," + "tipo_user VARCHAR(20));");
//			stm.executeUpdate();
//
//			stm.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
	}

	public void create(Usuario user) {

		open();

		try {
			PreparedStatement stm = conexao.prepareStatement(
					"INSERT INTO usuario( nome_user, cpf_user, login_user, senha_user, tipo_user, telefone_user) VALUES(?,?,?,?,?,?);");

			stm.setString(1, user.getNome_user());
			stm.setString(2, user.getCpf_user());
			stm.setString(3, user.getLogin_user());
			stm.setString(4, user.getSenha_user());
			stm.setString(5, user.getTipo_user());
			stm.setString(6, user.getTelefone_user());

			stm.executeUpdate();

			System.out.println("Dados inseridos");

		} catch (SQLException e) {
			System.out.println("Exception método create");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public Usuario buscarUsuarioPorLogin(String login) {
		open();

		Usuario usuario = null;

		try {
			PreparedStatement stm = conexao.prepareStatement("SELECT * FROM usuario WHERE login_user='" + login + "'");

			ResultSet rs = stm.executeQuery();

			if (rs != null && rs.next()) {
				usuario = new Usuario(rs.getInt(1), // id
						rs.getString(2), // nome
						rs.getString(3), // cpf
						rs.getString(4), // login
						rs.getString(5), // senha_user
						rs.getString(6), // tipo_user
						rs.getString(7) // telefone_user
				);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com o banco");
			e.printStackTrace();
		} finally {
			close();
		}
		return usuario;
	}

	public List<Usuario> all() {

		open();

		ArrayList<Usuario> result = new ArrayList<>();

		try {
			PreparedStatement stm = conexao.prepareStatement("SELECT * FROM usuario  ORDER BY id_user");

			ResultSet rs = stm.executeQuery();

			while (rs.next()) {

				Usuario user = new Usuario(rs.getInt(1), // id
						rs.getString(2), // nome
						rs.getString(3), // cpf
						rs.getString(4), // login
						rs.getString(5), // senha_user
						rs.getString(6), // tipo_user
						rs.getString(7) // telefone_user
				);
				result.add(user);
			}
		} catch (SQLException e) {
			System.out.println("Exception método all");
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}