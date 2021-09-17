package controller;

import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;
import util.TextFieldFormatter;
import application.Main;
import dao.InstalacaoDAO;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InstalacaoCadastrada implements Initializable{
    @FXML
    private TextField txtNumeroInstalacao;
    @FXML 
    private TextField txtRGI;
    @FXML
	private Button txtBotaoBuscarNumInstalacao;
	@FXML
	private Button txtBotaoBuscarRGI;
	@FXML
    private Button txtBotaoRetornar;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    }

    public void changeScreenBuscarEnergia(ActionEvent event){       
        if (InstalacaoDAO.buscarInstalacao(BigInteger.valueOf(Long.parseLong(txtNumeroInstalacao.getText())))){
            Main.salvarContaInst1(txtNumeroInstalacao.getText());
            Main.salvarEnergiaInst1(txtNumeroInstalacao.getText());
            Main.changeScreen("energiasemend");
            txtNumeroInstalacao.setText("");
        } else {
            Alert Alert = new Alert(AlertType.INFORMATION);
            Alert.setTitle("Numero de Instalacao não encontrado");
            Alert.setHeaderText(null);
            Alert.setContentText("DIGITE UM NUMERO VÁLIDO");
            Alert.showAndWait();

            txtNumeroInstalacao.setText("");
        }
    }

    public void changeScreenBuscarAgua(ActionEvent event){
        String RGI = txtRGI.getText().replace("/","");

        
        if (InstalacaoDAO.buscarInstalacao(BigInteger.valueOf(Long.parseLong(RGI)))){
            Main.salvarContaInst1(RGI);
            Main.salvarAguaInst1(RGI);
            Main.changeScreen("aguasemend");
            txtRGI.setText("");
        } else {
            Alert Alert = new Alert(AlertType.INFORMATION);
            Alert.setTitle("Numero de Instalacao não encontrado");
            Alert.setHeaderText(null);
            Alert.setContentText("DIGITE UM NUMERO VÁLIDO");
            Alert.showAndWait();

            txtRGI.setText("");
        }
    }

    public void changeScreenRetornar(ActionEvent event){
        Main.changeScreen("main");

        txtRGI.setText("");
        txtNumeroInstalacao.setText("");
    }

// Mascaras
    @FXML
    private void mascaraRGI(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("########/##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtRGI);
        tff.formatter();
    }
}