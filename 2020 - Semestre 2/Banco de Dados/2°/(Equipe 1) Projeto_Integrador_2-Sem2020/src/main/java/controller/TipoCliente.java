package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import application.Main;

public class TipoCliente implements Initializable {
	   @FXML
	   private Button btn_PF;
	   @FXML
	   private Button btn_PJ;
	   
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	public void changeScreenPF(ActionEvent event){
        Main.changeScreen("pf");
    }
    
    public void changeScreenPJ(ActionEvent event){
        Main.changeScreen("pj");
	}

}