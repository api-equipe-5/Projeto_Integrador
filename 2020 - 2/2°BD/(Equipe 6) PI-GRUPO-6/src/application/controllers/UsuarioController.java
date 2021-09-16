package application.controllers;

import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.ResourceBundle;

import application.models.Usuario;
import application.models.dao.UsuarioSQL;
import application.util.Sha1;
import application.util.TextFieldFormatter;
import application.util.ValidationFields;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UsuarioController implements Initializable {

	@FXML
	private TextField txtLogin;

	@FXML
	private TextField txtNomeUsuario;

	@FXML
	private PasswordField txtSenha;

	@FXML
	private Button btnCadastrar;

	@FXML
	private TextField txtTelefone;

	@FXML
	private TextField txtCpf;

	@FXML
	private TextField txtNumMatricula;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnLimpar;

	@FXML
	private Button btnBuscar;

	@FXML
	private Label lblMensagem;

	@FXML
	private void txtTelefoneKeyReleased() {
		TextFieldFormatter tff = new TextFieldFormatter();
		tff.setMask("(##)#####-####");
		tff.setCaracteresValidos("0123456789");
		tff.setTf(txtTelefone);
		tff.formatter();
	}

	@FXML
	private void txtCpfKeyReleased() {
		TextFieldFormatter tff = new TextFieldFormatter();
		tff.setMask("###.###.###-##");
		tff.setCaracteresValidos("0123456789");
		tff.setTf(txtCpf);
		tff.formatter();
	}

	@FXML
	void executarClickCadastrar(ActionEvent event) throws NoSuchAlgorithmException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Caixa de Confirmação");
//		alert.setHeaderText("Caixa de diálogo de confirmação");
		alert.setContentText("Deseja realmente cadastrar um novo Usuário?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) { 
			
			// Verifica se há campos obrigatórios não preenchidos
			boolean camposPreenchidos = ValidationFields.checkEmptyFields(txtSenha, txtLogin, txtNomeUsuario);

			if (camposPreenchidos) {
				String nome = txtNomeUsuario.getText();
				String telefone = txtTelefone.getText();
				String login = txtLogin.getText();
				String numMatricula = txtNumMatricula.getText();
				String senha = txtSenha.getText();
				String cpf = txtCpf.getText();

				String senhaCriptografada = new Sha1().encriptarSenha(senha);

				Usuario usuario = new Usuario(0, nome, cpf, login, senhaCriptografada, numMatricula, telefone);
				UsuarioSQL usuarioSQL = new UsuarioSQL();
				usuarioSQL.create(usuario);
			}

		} else {

		}
	}

	@FXML
	void executarClickEditar(ActionEvent event) {

	}

	@FXML
	void executarClickBuscar(ActionEvent event) {

	}

	@FXML
	void executarClickLimpar(ActionEvent event) {
		txtNomeUsuario.setText("");
		txtTelefone.setText("");
		txtLogin.setText("");
		txtNumMatricula.setText("");
		txtSenha.setText("");
		txtCpf.setText("");

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		btnEditar.setDisable(true);
	}

}
