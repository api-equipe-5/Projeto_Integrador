package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import util.TextFieldFormatter;
import application.Main;

public class CadastroAgua2 implements Initializable {
    @FXML
    private TextField txtTarifaAguaAte10;
    @FXML 
    private TextField txtTarifaAgua11a20;
    @FXML
    private TextField txtTarifaAgua21a31;
    @FXML
    private TextField txtTarifaAgua31a50;
    @FXML
    private TextField txtTarifaAcima50;
    @FXML
    private TextField txtValorAguaAte10;
    @FXML
    private TextField txtValorAgua11a20;
    @FXML
    private TextField txtTarifaEsgotoAte10;
    @FXML
    private TextField txtTarifaEsgoto11a20;
    @FXML
    private TextField txtTarifaEsgoto21a30;
    @FXML
    private TextField txtTarifaEsgoto31a50;
    @FXML
    private TextField txtTarifaEsgotoAcima50;
    @FXML
    private TextField txtValorEsgotoAte10;
    @FXML
    private TextField txtValorEsgoto11a20;
    @FXML
    private TextField txtVencimento;
    @FXML
    private TextField txtVIAgua;
    @FXML
    private TextField txtVIEsgoto;
    @FXML
    private TextField txtTaxaRegulacao;
    @FXML
    private TextField txtMulta;
    @FXML
    private TextField txtUsuario;
    @FXML
    private Button btnSalvarVoltarTelaInicial;
    @FXML
    private Button btnRetornarAgua2;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
    }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("agua1");
    }

    public void changeScreenVoltarTelaInicial(ActionEvent event) {
        if(txtVencimento.getText().equals("") || txtUsuario.getText().equals("")) {
            Alert Alert = new Alert(AlertType.INFORMATION);
            Alert.setTitle("Campos Obrigatórios Vazios");
            Alert.setHeaderText(null);
            Alert.setContentText("PREENCHA OS CAMPOS COM *");
            Alert.showAndWait(); 

        } else {
            Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Cadastro");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("DESEJA ADICIONAR UM CADASTRO?");

            Optional<ButtonType> result = confirmacao.showAndWait();
            if (result.get() == ButtonType.OK){   

                Main.salvarConta2(txtVencimento, txtUsuario);
                Main.salvarAgua2(txtTarifaAguaAte10, txtTarifaAgua11a20, txtTarifaAgua21a31, txtTarifaAgua31a50, txtTarifaAcima50, 
                txtValorAguaAte10, txtValorAgua11a20, txtTarifaEsgotoAte10, txtTarifaEsgoto11a20, txtTarifaEsgoto21a30, txtTarifaEsgoto31a50, 
                txtTarifaEsgotoAcima50, txtValorEsgotoAte10, txtValorEsgoto11a20, txtVIAgua, txtVIEsgoto, txtTaxaRegulacao, 
                txtMulta);
                
                Main.changeScreen("main");
                
                Alert Alert = new Alert(AlertType.INFORMATION);
                Alert.setTitle("Confirmação de Cadastro");
                Alert.setHeaderText(null);
                Alert.setContentText("CADASTRO EFETUADO COM SUCESSO!");
                Alert.showAndWait();

                txtVencimento.setText("");
                txtTarifaAguaAte10.setText("0");
                txtTarifaAgua11a20.setText("0");
                txtTarifaAgua21a31.setText("0");
                txtTarifaAgua31a50.setText("0");
                txtTarifaAcima50.setText("0");
                txtValorAguaAte10.setText("0");
                txtValorAgua11a20.setText("0");
                txtTarifaEsgotoAte10.setText("0");
                txtTarifaEsgoto11a20.setText("0");
                txtTarifaEsgoto21a30.setText("0");
                txtTarifaEsgoto31a50.setText("0");
                txtTarifaEsgotoAcima50.setText("0");
                txtValorEsgotoAte10.setText("0");
                txtValorEsgoto11a20.setText("0");
                txtVIAgua.setText("0");
                txtVIEsgoto.setText("0");
                txtTaxaRegulacao.setText("0");
                txtMulta.setText("0");
                txtUsuario.setText("");
            } else {
            }    
        }
    }

 // Mascaras
    @FXML
    private void mascaraVencimento(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/##/##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtVencimento);
        tff.formatter();
    }
}