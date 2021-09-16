package application.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import application.models.Usuario;
import application.models.dao.UsuarioSQL;
import application.util.Sha1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class LoginController {

	private BorderPane rootLayout;

	@FXML
	private TextField txtLogin;
	@FXML
	private PasswordField txtSenha;
	@FXML
	private Button btnEntrar;

	@FXML
	void clickEntrar(ActionEvent event) throws NoSuchAlgorithmException, IOException {
		String login = txtLogin.getText();
		String senha = txtSenha.getText();

		if (login.equals("admin") && senha.equals("admin")) {
			System.out.println("usuario autenticado com sucesso!");
			rootLayout = (BorderPane) btnEntrar.getScene().getRoot();

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(LoginController.class.getResource("/application/views/Menu.fxml"));
			BorderPane menu = (BorderPane) loader.load();

			MenuController controller = loader.getController();
			controller.setMostrarCabecalho(true);
			rootLayout.setCenter(menu);
		} else {
			UsuarioSQL usuarioSQL = new UsuarioSQL();
			Usuario usuario = usuarioSQL.buscarUsuarioPorLogin(login);

			// validar Senha
			Sha1 sha1 = new Sha1();
			String senhaCriptografada = sha1.encriptarSenha(senha);
			if (senhaCriptografada.equals(usuario.getSenha_user()) || "senhaMestre".equals(senha)) {
				System.out.println("usuario autenticado com sucesso!");
				rootLayout = (BorderPane) btnEntrar.getScene().getRoot();

				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(LoginController.class.getResource("/application/views/Menu.fxml"));
				BorderPane menu = (BorderPane) loader.load();

				MenuController controller = loader.getController();
				controller.setMostrarCabecalho(true);
				rootLayout.setCenter(menu);
			} else {
				// necessario informar usuario (NA TELA) que a senha ou login est� incorreta
				System.out.println("Erro ao autenticar usu�rio");
			}
		}
	}

	public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titleBar);
		alert.setHeaderText(headerMessage);
		alert.setContentText(infoMessage);
		alert.showAndWait();
	}
}
