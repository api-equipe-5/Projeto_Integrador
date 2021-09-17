package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MenuController implements Initializable {

	private BorderPane rootLayout;

	@FXML
	private Button btnCadastroUsuario;

	@FXML
	private Button btnCadastroCliente;

	@FXML
	private Button btnContaLuz;

	@FXML
	private Button btnContaAgua;

	@FXML
	private Button btnContaGas;

	@FXML
	private Button btnCadastroImovel;

	@FXML
	private Button btnBuscar;
	
	@FXML
	public HBox cabecalho;
	
	public boolean mostrarCabecalho;

	@FXML
	private void clickCadastroUsuario(ActionEvent evento) throws IOException {
		rootLayout = (BorderPane) btnCadastroCliente.getScene().getRoot();
		BorderPane menuLayout = (BorderPane) rootLayout.getCenter();
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuController.class.getResource("/application/views/CadastroUsuario.fxml"));
		AnchorPane cadastroUsuario = (AnchorPane) loader.load();

		menuLayout.setCenter(cadastroUsuario);
	}

	@FXML
	private void clickCadastroCliente(ActionEvent evento) throws IOException {
		rootLayout = (BorderPane) btnCadastroCliente.getScene().getRoot();
		BorderPane menuLayout = (BorderPane) rootLayout.getCenter();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuController.class.getResource("/application/views/CadastroCliente.fxml"));
		AnchorPane cadastroCliente = (AnchorPane) loader.load();

		menuLayout.setCenter(cadastroCliente);
	}

	@FXML
	private void clickContaLuz(ActionEvent evento) throws IOException {
		rootLayout = (BorderPane) btnCadastroCliente.getScene().getRoot();
		BorderPane menuLayout = (BorderPane) rootLayout.getCenter();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuController.class.getResource("/application/views/ContaLuz.fxml"));
		BorderPane contaLuz = loader.load();

		menuLayout.setCenter(contaLuz);
	}

	@FXML
	private void clickContaAgua(ActionEvent evento) throws IOException {
		rootLayout = (BorderPane) btnCadastroCliente.getScene().getRoot();
		BorderPane menuLayout = (BorderPane) rootLayout.getCenter();
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuController.class.getResource("/application/views/ContaAgua.fxml"));
		BorderPane contaAgua = loader.load();

		menuLayout.setCenter(contaAgua);
	}

	@FXML
	private void clickContaGas(ActionEvent evento) throws IOException {
		rootLayout = (BorderPane) btnCadastroCliente.getScene().getRoot();
		BorderPane menuLayout = (BorderPane) rootLayout.getCenter();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuController.class.getResource("/application/views/ContaGas.fxml"));
		BorderPane contaGas = loader.load();

		menuLayout.setCenter(contaGas);

	}

	@FXML
	private void clickCadastroImovel(ActionEvent evento) throws IOException {
		rootLayout = (BorderPane) btnCadastroCliente.getScene().getRoot();
		BorderPane menuLayout = (BorderPane) rootLayout.getCenter();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuController.class.getResource("/application/views/CadastroImovel.fxml"));
		BorderPane cadastroImovel = (BorderPane) loader.load();

		menuLayout.setCenter(cadastroImovel);
	}

	@FXML
	private void clickBuscar(ActionEvent evento) throws IOException {
		rootLayout = (BorderPane) btnCadastroCliente.getScene().getRoot();
		BorderPane menuLayout = (BorderPane) rootLayout.getCenter();
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuController.class.getResource("/application/views/Busca.fxml"));
        BorderPane buscar = (BorderPane) loader.load();

        menuLayout.setCenter(buscar);
        
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		btnBuscar.setDisable(true);
//		btnCadastroCliente.setDisable(true);
//		btnCadastroImovel.setDisable(true);
//		btnCadastroUsuario.setDisable(true);
//		btnContaAgua.setDisable(true);
//		btnContaGas.setDisable(true);
//		btnContaLuz.setDisable(true);
		Platform.runLater(() -> {
			cabecalho.setVisible(mostrarCabecalho);
	    });
	}

	public void setMostrarCabecalho(boolean mostrarCabecalho) {
		this.mostrarCabecalho = mostrarCabecalho;
	}
	
}
