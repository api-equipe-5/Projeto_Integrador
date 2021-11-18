//package com.tecsus.ddc.app;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.TextField;
//import javafx.scene.input.KeyEvent;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class Controller implements Initializable {
//
//    @FXML
//    private TextField txtLeituraAtual;
//    @FXML
//    private TextField txtLeituraAnterior;
//    @FXML
//    private TextField txtProximaLeitura;
//    @FXML
//    private TextField txtMesRef;
//
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//    }
//    @FXML
//    public void abrirAgua(ActionEvent event) {
//
//        Login.changeScreen("water");
//    }
//    @FXML
//    public void abrirLuz(ActionEvent event) {
//        Login.changeScreen("energy");
//    }
//
//    public void voltarHome(ActionEvent event) {
//
//        Login.changeScreen("home");
//    }
//    @FXML
//    public void mascData(KeyEvent keyEvent) {
//        TextFieldFormatter dataMasc = new TextFieldFormatter();
//        dataMasc.setMask("##/##/####");
//        dataMasc.setCaracteresValidos("0123456789");
//        dataMasc.setTf(txtLeituraAtual);
//        dataMasc.formatter();
//        dataMasc.setTf(txtLeituraAnterior);
//        dataMasc.formatter();
//        dataMasc.setTf(txtProximaLeitura);
//        dataMasc.formatter();
//    }
//    @FXML
//    public void mascRef(KeyEvent keyEvent) {
//        TextFieldFormatter refMasc = new TextFieldFormatter();
//        refMasc.setMask("##/####");
//        refMasc.setCaracteresValidos("0123456789");
//        refMasc.setTf(txtMesRef);
//        refMasc.formatter();
//    }
//}
