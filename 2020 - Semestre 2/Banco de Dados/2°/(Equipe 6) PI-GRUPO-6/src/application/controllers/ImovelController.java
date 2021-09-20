package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.ResourceBundle;

import application.models.Cliente;
import application.models.Imovel;
import application.models.dao.ClienteSQL;
import application.models.dao.ImovelSQL;
import application.util.TextFieldFormatter;
import application.util.ValidationFields;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ImovelController implements Initializable {

	@FXML
	private TextField txtIdentificacao;

	@FXML
	private Button btnCadastrar;

	@FXML
	private TextField txtNumero;

	@FXML
	private TextField txtRua;

	@FXML
	private Button btnEditar;

	@FXML
	private TextField txtComplemento;

	@FXML
	private ChoiceBox<String> tiposImovel;

	@FXML
	private Button btnContinuarCadastro;

	@FXML
	private TextField txtCidade;

	@FXML
	private TextField txtUf;

	@FXML
	private TextField txtNomeCliente;

	@FXML
	private TextField txtCep;

	@FXML
	private Button btnLimpar;

	@FXML
	private TextField txtBairro;

	@FXML
	private TextField txtIdentificacaoImovel;

	@FXML
	private Button btnBuscarCliente;

	private Cliente cliente;
	private Imovel imovel;
	private BorderPane rootLayout;

	@FXML
	private void txtCepKeyReleased() {
		TextFieldFormatter tff = new TextFieldFormatter();
		tff.setMask("#####-###");
		tff.setCaracteresValidos("0123456789");
		tff.setTf(txtCep);
		tff.formatter();
	}

	@FXML
	void clickLimpar(ActionEvent event) {
		txtIdentificacao.setText("");
		txtIdentificacaoImovel.setText("");
		txtNomeCliente.setText("");
		txtUf.setText("");
		txtCidade.setText("");
		txtBairro.setText("");
		txtRua.setText("");
		txtNumero.setText("");
		txtComplemento.setText("");
		txtCep.setText("");

	}

	@FXML
	void clickEditar(ActionEvent event) {

	}

	@FXML
	void clickCadastrar(ActionEvent event) throws NoSuchAlgorithmException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Caixa de Confirmação");
//		alert.setHeaderText("Caixa de diálogo de confirmação");
		alert.setContentText("Deseja realmente cadastrar um novo Imóvel");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) { 
			
			// Verifica se há campos obrigatórios não preenchidos
			boolean camposPreenchidos = ValidationFields.checkEmptyFields(tiposImovel, txtNomeCliente, txtUf, txtCidade, txtBairro, txtRua, txtNumero, txtCep);

			if (camposPreenchidos) {
				int idCliente = this.cliente.getId_cli();
				String tipo = tiposImovel.getValue();
				int identificacao = Integer.parseInt(txtIdentificacaoImovel.getText());
				String uf = txtUf.getText();
				String cidade = txtCidade.getText();
				String bairro = txtBairro.getText();
				String rua = txtRua.getText();
				String numero = txtNumero.getText();
				String complemento = txtComplemento.getText();
				String cep = txtCep.getText();
		
				imovel = new Imovel(0, idCliente, tipo, identificacao, uf, cidade, bairro, rua, numero, complemento, cep);
				ImovelSQL imovelSQL = new ImovelSQL();
				imovelSQL.create(imovel);
			}
		} else {

		}
	}

	@FXML
	void clickBuscarCliente(ActionEvent event) {
		ClienteSQL clienteSQL = new ClienteSQL();
		this.cliente = clienteSQL.buscarClientePeloNome(txtNomeCliente.getText());
		txtNomeCliente.setText(cliente.nome_cli);
	}

	@FXML
	void clickContinuarCadastro(ActionEvent event) throws IOException {
		String tipoIdentificadorConta = tiposImovel.getValue();

		if (tipoIdentificadorConta.equals("Água: RGI")) {
			rootLayout = (BorderPane) btnContinuarCadastro.getScene().getRoot();
			BorderPane menuLayout = (BorderPane) rootLayout.getCenter();
					
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/application/views/ContaAgua.fxml"));
			BorderPane contaAgua = loader.load();

			ContaAguaController controller = loader.getController();
			String nomeTitular = txtNomeCliente.getText();
			controller.dadosIniciais(nomeTitular, imovel);

			menuLayout.setCenter(contaAgua);
		} else if (tipoIdentificadorConta.equals("Gás: Código do Usuário")) {
			rootLayout = (BorderPane) btnContinuarCadastro.getScene().getRoot();
			BorderPane menuLayout = (BorderPane) rootLayout.getCenter();
					
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/application/views/ContaGas.fxml"));
			BorderPane contaGas = loader.load();

			ContaGasController controller = loader.getController();
			String nomeTitular = txtNomeCliente.getText();
			controller.dadosIniciais(nomeTitular, imovel);

			menuLayout.setCenter(contaGas);
		} else if (tipoIdentificadorConta.equals("Luz: Número de Instalação")) {
			rootLayout = (BorderPane) btnContinuarCadastro.getScene().getRoot();
			BorderPane menuLayout = (BorderPane) rootLayout.getCenter();

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/application/views/ContaLuz.fxml"));
			BorderPane contaLuz = loader.load();

			ContaLuzController controller = loader.getController();
			String nomeTitular = txtNomeCliente.getText();
			controller.dadosIniciais(nomeTitular, imovel);

			menuLayout.setCenter(contaLuz);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tiposImovel.getItems().add("Água: RGI");
		tiposImovel.getItems().add("Gás: Código do Usuário");
		tiposImovel.getItems().add("Luz: Número de Instalação");
	}
}
