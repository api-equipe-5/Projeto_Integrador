package application.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import application.models.DadosListaConta;
import application.models.dao.DadosListaContaSQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;

public class BuscaController implements Initializable {

	@FXML
	private Button btnEditar;

	@FXML
	private RadioButton rbAgua;

	@FXML
	private RadioButton rbGas;

	@FXML
	private RadioButton rbLuz;

	private ToggleGroup tipoConta;

	@FXML
	private TableView<DadosListaConta> listaContas;

	@FXML
	private TableColumn<DadosListaConta, String> colNomeCli;

	@FXML
	private TableColumn<DadosListaConta, Date> colDataVencimento;

	@FXML
	private TableColumn<DadosListaConta, Float> colValorTotal;

	@FXML
	private TextField txtCodIdentificacao;

	@FXML
	protected TableView<DadosListaConta> tableConta;

	@FXML
	void clickPesquisar() {
		int codIdentificacaoConta = Integer.parseInt(txtCodIdentificacao.getText());
		ArrayList<DadosListaConta> listaContas = new DadosListaContaSQL().all(codIdentificacaoConta);
		System.out.println(listaContas);

		tableConta.getItems().clear();

		for (DadosListaConta conta : listaContas) {
			tableConta.getItems().add(conta);
		}
//		
//		if(this.tipoConta.getSelectedToggle().equals(this.rbAgua)) {
//				
//		}
//		else if(this.tipoConta.getSelectedToggle().equals(this.rbLuz)) {
//			
//		}
//		else if(this.tipoConta.getSelectedToggle().equals(this.rbGas)) {
//			
//		}	
	}

	@FXML
	void clickEditar(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		colNomeCli.setCellValueFactory(new PropertyValueFactory<>("nome_cli"));
		colDataVencimento.setCellValueFactory(new PropertyValueFactory<>("dataVencimento"));
		colValorTotal.setCellValueFactory(new PropertyValueFactory<>("totalPagar"));
//		codId.setCellValueFactory(new PropertyValueFactory<>("codId"));

//		tipoConta = new ToggleGroup();
//		this.rbAgua.setToggleGroup(tipoConta);
//		this.rbLuz.setToggleGroup(tipoConta);
//		this.rbGas.setToggleGroup(tipoConta);
		
	      Tooltip toolTip3 = new Tooltip("Número de Instalação");
	      rbLuz.setTooltip(toolTip3);

	      Tooltip toolTip4 = new Tooltip("Código do Usuário");
	      rbGas.setTooltip(toolTip4);

	      Tooltip toolTip5 = new Tooltip("RGI");
	      rbAgua.setTooltip(toolTip5);


	}
	

}


