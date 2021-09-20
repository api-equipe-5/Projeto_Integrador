package controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import util.TextFieldFormatter;
import application.Main;
import classes.Energia;
import dao.EnergiaDAO;
import dao.InstalacaoDAO;

public class CadastroEnergia2 implements Initializable {
    @FXML
    private TextField txtMesReferenciaEnergia;
    @FXML 
    private TextField txtNumeroInstalacao;
    @FXML
    private TextField txtConsumodoMesKWH;
    @FXML
    private TextField txtDataVencimento;
    @FXML
    private TextField txtValorTotal;
    @FXML
    private TextField txtConstMulti;
    @FXML
    private TextField txtNRdoMedidor;
    @FXML
    private TextField txtLeituraAnteriorEnergia;
    @FXML 
    private TextField txtLeituraAtualEnergia;
    @FXML 
    private TextField txtDataLeituraAnterior;
    @FXML
    private TextField txtDataLeituraAtual;
    @FXML
    private TextField txtUsuario;
    @FXML
    private ComboBox comboBandeirasTarifarias;
    @FXML
    private Button btnVoltarTelaInical;
    @FXML
    private Button btnRetornarEnergia;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

        comboBandeirasTarifarias.getItems().add("Verde");
        comboBandeirasTarifarias.getItems().add("Amarela");
        comboBandeirasTarifarias.getItems().add("Vermelha");
    }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("energia1Scene");
    }

    public void changeScreenVoltarTelaInicial(ActionEvent event) {
        if(txtConsumodoMesKWH.getText().equals("") || txtNumeroInstalacao.getText().equals("") || txtMesReferenciaEnergia.getText().equals("") || txtDataVencimento.getText().equals("") || txtValorTotal.getText().equals("") || txtNRdoMedidor.getText().equals("") || txtLeituraAnteriorEnergia.getText().equals("") || txtLeituraAtualEnergia.getText().equals("") || txtDataLeituraAnterior.getText().equals("") || txtDataLeituraAtual.getText().equals("") || comboBandeirasTarifarias.getValue().equals("") || txtUsuario.getText().equals("")) {
            
            Alert Alert = new Alert(AlertType.INFORMATION);
            Alert.setTitle("Campos Obrigatórios Vazios");
            Alert.setHeaderText(null);
            Alert.setContentText("PREENCHA OS CAMPOS COM *");
            Alert.showAndWait(); 
        }
        else {
            Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Cadastro");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("DESEJA ADICIONAR UM CADASTRO?");

            Optional<ButtonType> result = confirmacao.showAndWait();
            if (result.get() == ButtonType.OK){
                if (InstalacaoDAO.buscarInstalacao(BigInteger.valueOf(Long.parseLong(txtNumeroInstalacao.getText())))){
                    Alert Alert = new Alert(AlertType.INFORMATION);
                    Alert.setTitle("Número de Instalação já Existente");
                    Alert.setHeaderText(null);
                    Alert.setContentText("Digite um Número de Instalação válido!");
                    Alert.showAndWait();
                } else {
                    String NumeroInstalacao = txtNumeroInstalacao.getText();        

                    Main.salvarIntalacaoNumero(NumeroInstalacao);
                    Main.salvarConta1(NumeroInstalacao, txtMesReferenciaEnergia);
                    Main.salvarConta2(txtDataVencimento, txtUsuario);
                    Main.salvarEnergia2(txtMesReferenciaEnergia, txtNumeroInstalacao.getText(), txtConsumodoMesKWH, txtValorTotal, txtConstMulti, txtNRdoMedidor, txtLeituraAnteriorEnergia, txtLeituraAtualEnergia, txtDataLeituraAnterior, txtDataLeituraAtual, comboBandeirasTarifarias);
                    
                    Main.changeScreen("main");
                    
                    txtMesReferenciaEnergia.setText("");
                    txtNumeroInstalacao.setText("");
                    txtConsumodoMesKWH.setText("");
                    txtDataVencimento.setText("");
                    txtValorTotal.setText("");
                    txtConstMulti.setText("");
                    txtNRdoMedidor.setText("");
                    txtLeituraAnteriorEnergia.setText("");
                    txtLeituraAtualEnergia.setText("");
                    txtDataLeituraAnterior.setText("");
                    txtDataLeituraAtual.setText("");
                    comboBandeirasTarifarias.setValue("");
                    txtUsuario.setText("");
                    
                    Alert Alert = new Alert(AlertType.INFORMATION);
                    Alert.setTitle("Confirmação de Cadastro");
                    Alert.setHeaderText(null);
                    Alert.setContentText("CADASTRO EFETUADO COM SUCESSO!");
                    Alert.showAndWait();
                }
            } else {
            }    
        }
    }

// Mascaras
    @FXML
    private void mascaraVencimento(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtDataVencimento);
        tff.formatter();
    }
    @FXML
    private void mascaraDataAnt(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtDataLeituraAnterior);
        tff.formatter();
    }
    @FXML
    private void mascaraDataAtual(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtDataLeituraAtual);
        tff.formatter();
    }
    @FXML
    private void mascaraMesReferencia(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtMesReferenciaEnergia);
        tff.formatter();
        }
    }