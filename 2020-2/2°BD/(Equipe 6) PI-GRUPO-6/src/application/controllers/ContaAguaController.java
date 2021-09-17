package application.controllers;

import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import application.models.Cliente;
import application.models.ContaAgua;
import application.models.Imovel;
import application.models.dao.ClienteSQL;
import application.models.dao.ContaAguaSQL;
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

public class ContaAguaController implements Initializable {

	@FXML
	private TextField txtEsgoto;

	@FXML
	private TextField txtNomeTitular;

	@FXML
	private TextField txtTipoFaturamento;

	@FXML
	private TextField txtRgi;

	@FXML
	private DatePicker txtDataVencimento;

	@FXML
	private TextField txtNumero;

	@FXML
	private TextField txtValorLeituraAtual;

	@FXML
	private TextField txtComplemento;

	@FXML
	private BorderPane btnContaAgua;

	@FXML
	private TextField txtAgua;

	@FXML
	private TextField txtCidade;

	@FXML
	private TextField txtTotalPagar;

	@FXML
	private Button btnLimpar;

	@FXML
	private TextField txtValorLeituraAnterior;

	@FXML
	private TextField txtConsumo;

	@FXML
	private DatePicker txtDataLeituraAtual;

	@FXML
	private TextField txtRua;

	@FXML
	private TextField txtTipoLigacao;

	@FXML
	private TextField txtCodigoCliente;

	@FXML
	private TextField txtUf;

	@FXML
	private TextField txtPeriodoConsumo;

	@FXML
	private TextField txtCep;

	@FXML
	private TextField txtHidrometro;

	@FXML
	private DatePicker txtDataLeituraAnterior;

	@FXML
	private TextField txtBairro;

	private Imovel imovel;
	private Cliente cliente;

	void dadosIniciais(String nomeTitular, Imovel imovel) {
		txtNomeTitular.setText(nomeTitular);
		this.imovel = imovel;

		txtRgi.setText(String.valueOf(this.imovel.getIdentificacaoImovel()));
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
		txtRgi.setText("");
		txtNomeTitular.setText("");
		txtUf.setText("");
		txtCidade.setText("");
		txtBairro.setText("");
		txtRua.setText("");
		txtNumero.setText("");
		txtComplemento.setText("");
		txtCep.setText("");
		txtCodigoCliente.setText("");
		txtTipoLigacao.setText("");
		txtHidrometro.setText("");
		txtTipoFaturamento.setText("");
		txtPeriodoConsumo.setText("");
		txtAgua.setText("");
		txtEsgoto.setText("");
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
		alert.setContentText("Deseja realmente cadastrar uma nova conta de Água");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {

			// Verifica se há campos obrigatórios não preenchidos
			boolean camposPreenchidos = ValidationFields.checkEmptyFields(txtRgi, txtCodigoCliente, txtTipoLigacao,
					txtHidrometro, txtTipoFaturamento, txtPeriodoConsumo, txtAgua, txtEsgoto, txtConsumo,
					txtValorLeituraAtual, txtValorLeituraAnterior, txtDataLeituraAtual, txtDataLeituraAnterior,
					txtDataVencimento, txtTotalPagar);

			if (camposPreenchidos) {
				int rgi = Integer.parseInt(txtRgi.getText());
				int codigoCliente = Integer.parseInt(txtCodigoCliente.getText());
				String tipoLigacao = txtTipoLigacao.getText();
				String hidrometro = txtHidrometro.getText();
				String tipoFaturamento = txtTipoFaturamento.getText();
				String periodoConsumo = txtPeriodoConsumo.getText();
				String agua = txtAgua.getText();
				String esgoto = txtEsgoto.getText();
				String consumo = txtConsumo.getText();
				float valorLeituraAtual = Float.parseFloat(txtValorLeituraAtual.getText());
				float valorLeituraAnterior = Float.parseFloat(txtValorLeituraAnterior.getText());
				Date dataLeituraAtual = Date.valueOf(txtDataLeituraAtual.getValue());
				Date dataLeituraAnterior = Date.valueOf(txtDataLeituraAnterior.getValue());
				Date dataVencimento = Date.valueOf(txtDataVencimento.getValue());
				float totalPagar = Float.parseFloat(txtTotalPagar.getText());

				ContaAgua contaAgua = new ContaAgua(0, cliente.getId_cli(), rgi, codigoCliente, tipoLigacao, hidrometro, tipoFaturamento,
						periodoConsumo, agua, esgoto, consumo, valorLeituraAtual, valorLeituraAnterior,
						dataLeituraAtual, dataLeituraAnterior, dataVencimento, totalPagar);
				ContaAguaSQL contaAguaSQL = new ContaAguaSQL();
				contaAguaSQL.create(contaAgua);
			}
		} else {

		}
	}

	@FXML
	void clickBuscarImovel(ActionEvent event) {
		buscarImovel();
	}

	public void buscarImovel() {
		System.out.println("nr de identificação: " + txtRgi.getText() + "\n");
		if (!"".equals(txtRgi.getText())) {
			ImovelSQL imovelSQL = new ImovelSQL();
			ClienteSQL clienteSQL = new ClienteSQL();

			int codIdentificacao = Integer.parseInt(txtRgi.getText());
			imovel = imovelSQL.buscarImovelPeloCodIdentificacao(codIdentificacao);
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
		txtRgi.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue,
					Boolean newPropertyValue) {
				if (newPropertyValue) {
					System.out.println("clicou no campo");
				} else {
					buscarImovel();
				}
			}
		});
	}
}
