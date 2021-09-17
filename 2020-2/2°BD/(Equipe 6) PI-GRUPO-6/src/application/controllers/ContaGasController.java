package application.controllers;

import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import application.models.Cliente;
import application.models.ContaGas;
import application.models.Imovel;
import application.models.dao.ClienteSQL;
import application.models.dao.ContaGasSQL;
import application.models.dao.ImovelSQL;
import application.util.TextFieldFormatter;
import application.util.ValidationFields;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

public class ContaGasController implements Initializable {

	@FXML
	private TextField txtValorLeituraAnterior;

	@FXML
	private TextField txtNomeTitular;

	@FXML
	private TextField txtConsumo;

	@FXML
	private DatePicker txtDataLeituraAtual;

	@FXML
	private DatePicker txtDataVencimento;

	@FXML
	private TextField txtCodUsuario;

	@FXML
	private TextField txtNumero;

	@FXML
	private TextField txtRua;

	@FXML
	private TextField txtNumeroMedidor;

	@FXML
	private TextField txtValorLeituraAtual;

	@FXML
	private TextField txtDiasConsumo;

	@FXML
	private TextField txtComplemento;

	@FXML
	private TextField txtTipoMedidor;

	@FXML
	private TextField txtSegmento;

	@FXML
	private TextField txtConsumoCorrigido;

	@FXML
	private BorderPane btnContaAgua;

	@FXML
	private TextField txtCidade;

	@FXML
	private TextField txtUf;

	@FXML
	private TextField txtCep;

	@FXML
	private TextField txtTotalPagar;

	@FXML
	private DatePicker txtDataLeituraAnterior;

	@FXML
	private Button btnLimpar;

	@FXML
	private TextField txtBairro;

	private Imovel imovel;
	private Cliente cliente;

	void dadosIniciais(String nomeTitular, Imovel imovel) {
		txtNomeTitular.setText(nomeTitular);
		this.imovel = imovel;

		txtCodUsuario.setText(String.valueOf(this.imovel.getIdentificacaoImovel()));
		txtUf.setText(this.imovel.getUfImovel());
		txtCidade.setText(this.imovel.getCidadeImovel());
		txtBairro.setText(this.imovel.getBairroImovel());
		txtRua.setText(this.imovel.getRuaImovel());
		txtNumero.setText(this.imovel.getNumImovel());
		txtComplemento.setText(this.imovel.getComplementoImovel());
		txtCep.setText(this.imovel.getCepImovel());
	}

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
		txtCodUsuario.setText("");
		txtNomeTitular.setText("");
		txtUf.setText("");
		txtCidade.setText("");
		txtBairro.setText("");
		txtRua.setText("");
		txtNumero.setText("");
		txtComplemento.setText("");
		txtCep.setText("");
		txtSegmento.setText("");
		txtDiasConsumo.setText("");
		txtTipoMedidor.setText("");
		txtNumeroMedidor.setText("");
		txtConsumoCorrigido.setText("");
		txtConsumo.setText("");
		txtValorLeituraAtual.setText("");
		txtValorLeituraAnterior.setText("");
		txtDataLeituraAtual.setValue(null);
		txtDataLeituraAnterior.setValue(null);
		txtDataVencimento.setValue(null);
		txtTotalPagar.setText("");
	}

	@FXML
	void clickEditar(ActionEvent event) {

	}

	@FXML
	void clickCadastrar(ActionEvent event) throws NoSuchAlgorithmException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Caixa de Confirmação");
//		alert.setHeaderText("Caixa de diálogo de confirmação");
		alert.setContentText("Deseja realmente cadastrar uma nova conta de Gás");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {

			// Verifica se há campos obrigatórios não preenchidos
			boolean camposPreenchidos = ValidationFields.checkEmptyFields(txtCodUsuario, txtSegmento, txtDiasConsumo,
					txtTipoMedidor, txtNumeroMedidor, txtConsumoCorrigido, txtConsumo, txtValorLeituraAtual,
					txtValorLeituraAnterior, txtDataLeituraAtual, txtDataLeituraAnterior, txtDataVencimento,
					txtTotalPagar);

			if (camposPreenchidos) {
				int codUsuario = Integer.parseInt(txtCodUsuario.getText());
				String segmento = txtSegmento.getText();
				String diasConsumo = txtDiasConsumo.getText();
				String tipoMedidor = txtTipoMedidor.getText();
				String numeroMedidor = txtNumeroMedidor.getText();
				String consumoCorrigido = txtConsumoCorrigido.getText();
				String consumo = txtConsumo.getText();
				float valorLeituraAtual = Float.parseFloat(txtValorLeituraAtual.getText());
				float valorLeituraAnterior = Float.parseFloat(txtValorLeituraAnterior.getText());
				Date dataLeituraAtual = Date.valueOf(txtDataLeituraAtual.getValue());
				Date dataLeituraAnterior = Date.valueOf(txtDataLeituraAnterior.getValue());
				Date dataVencimento = Date.valueOf(txtDataVencimento.getValue());
				float totalPagar = Float.parseFloat(txtTotalPagar.getText());

				ContaGas contaGas = new ContaGas(0, cliente.getId_cli(), codUsuario, segmento, diasConsumo, tipoMedidor, numeroMedidor,
						consumoCorrigido, consumo, valorLeituraAtual, valorLeituraAnterior, dataLeituraAtual,
						dataLeituraAnterior, dataVencimento, totalPagar);
				ContaGasSQL contaGasSQL = new ContaGasSQL();
				contaGasSQL.create(contaGas);
			}
		} else {

		}
	}

	@FXML
	void clickBuscarImovel(ActionEvent event) {
		buscarImovel();
	}

	public void buscarImovel() {
		if (!"".equals(txtCodUsuario.getText())) {
			ImovelSQL imovelSQL = new ImovelSQL();
			ClienteSQL clienteSQL = new ClienteSQL();

			int codIdentificacao = Integer.parseInt(txtCodUsuario.getText());
			Imovel imovel = imovelSQL.buscarImovelPeloCodIdentificacao(codIdentificacao);
			cliente = clienteSQL.buscarClientePorId(imovel.getIdCliente());
			txtNomeTitular.setText(cliente.getNome_cli());
			txtCep.setText(imovel.getCepImovel());
			txtUf.setText(imovel.getUfImovel());
			txtCidade.setText(imovel.getCidadeImovel());
			txtComplemento.setText(imovel.getComplementoImovel());
			txtBairro.setText(imovel.getBairroImovel());
			txtRua.setText(imovel.ruaImovel);
			txtNumero.setText(String.valueOf(imovel.getNumImovel()));
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtCodUsuario.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue,
					Boolean newPropertyValue) {
				if (newPropertyValue) {
				} else {
					buscarImovel();
				}
			}
		});
	}
}
