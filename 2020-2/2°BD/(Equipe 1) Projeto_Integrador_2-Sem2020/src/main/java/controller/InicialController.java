package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import application.Main;

public class InicialController implements Initializable {
	   @FXML
	   private Button btnNovaInst;
	   @FXML
	   private Button btnInstalacaoCadastrada;
	   @FXML
	   private Button btnRelatorios;
	   
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	public void changeScreenNovaInst(ActionEvent event){
        Main.changeScreen("tipocliente");
    }
    
    public void changeScreenInstalacaoCadastrada(ActionEvent event){
        Main.changeScreen("instalacaoCadastradaScene");
    }
    
    public void changeScreenTipoRelatorio(ActionEvent event){
        Main.changeScreen("tiporelatorio");
	}

}