package controller;

import java.net.URL;
import javafx.scene.control.ComboBox;
import java.util.Optional;
import java.util.ResourceBundle;
import util.TextFieldFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import application.Main;
import controller.InstalacaoCadastrada;

public class CadastroEnergiaSemEnd extends InstalacaoCadastrada implements Initializable {
    @FXML
    private TextField txtMesReferenciaEnergia;
    @FXML
    private TextField txtContaKwH;
    @FXML
    private TextField txtDataVencimento;
    @FXML
    private TextField txtDataLeituraAnterior;
    @FXML
    private TextField txtDataLeituraAtual;
    @FXML
    private TextField txtNRdoMedidor;
    @FXML
    private TextField txtConstMulti;
    @FXML
    private TextField txtValorTotalAPagar;
    @FXML
    private TextField txtLeituraAnterior; 
    @FXML 
    private TextField txtLeituraAtual;
    @FXML
    private TextField txtCodigoFiscal;
    @FXML
    private TextField txtGrupoSubgrupo;
    @FXML
    private TextField txtFornecimento;
    @FXML
    private TextField txtClasseSubclasse;
    @FXML
    private TextField txtTensaoNominal;
    @FXML
    private TextField txtMTarifaria;
    @FXML 
    private TextField txtRoteiroLeitura;
    @FXML
    private TextField txtUsuario;
    @FXML
    private ComboBox comboBandeirasTarifarias;
    @FXML
    private Button btnRetornarEnergia;
    @FXML
    private Button btnVoltarTelaInicial;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        comboBandeirasTarifarias.getItems().add("Verde");
        comboBandeirasTarifarias.getItems().add("Amarela");
        comboBandeirasTarifarias.getItems().add("Vermelha");
    }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("instalacaoCadastradaScene");

        txtMesReferenciaEnergia.setText("");
        txtContaKwH.setText("");
        txtDataVencimento.setText("");
        txtDataLeituraAnterior.setText("");
        txtDataLeituraAtual.setText("");
        txtNRdoMedidor.setText("");
        txtConstMulti.setText("");
        txtValorTotalAPagar.setText("");
        txtLeituraAnterior.setText("");
        txtLeituraAtual.setText("");
        txtCodigoFiscal.setText("");
        txtGrupoSubgrupo.setText("");
        txtFornecimento.setText("");
        txtClasseSubclasse.setText("");
        txtTensaoNominal.setText("");
        txtMTarifaria.setText("");
        txtRoteiroLeitura.setText("");
        txtUsuario.setText("");
    }

    public void changeScreenVoltarTelaInicial(ActionEvent event) {
        if (txtMesReferenciaEnergia.getText().equals("") || txtContaKwH.getText().equals("") || 
        txtDataVencimento.getText().equals("") || txtValorTotalAPagar.getText().equals("") || 
        txtNRdoMedidor.getText().equals("") || txtLeituraAnterior.getText().equals("") || 
        txtLeituraAtual.getText().equals("") || txtDataLeituraAnterior.getText().equals("") || 
        txtDataLeituraAtual.getText().equals("") || txtCodigoFiscal.getText().equals("") || 
        txtGrupoSubgrupo.getText().equals("") || txtClasseSubclasse.getText().equals("") || 
        txtMTarifaria.getText().equals("") || comboBandeirasTarifarias.getValue().equals("") || txtUsuario.getText().equals("")){
            Alert Alert = new Alert(AlertType.INFORMATION);
            Alert.setTitle("Campos Obrigatórios Vazios");
            Alert.setHeaderText(null);
            Alert.setContentText("PREENCHA OS CAMPOS COM *");
            Alert.showAndWait(); 
        } else{

            Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Informações");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("CONFIRMA ESSAS INFORMAÇÕES?");

            Optional<ButtonType> result = confirmacao.showAndWait();
            if (result.get() == ButtonType.OK){
                Main.salvarContaInst2(txtMesReferenciaEnergia);
                Main.salvarContaInst3(txtDataVencimento, txtUsuario);
                Main.salvarEnergiaInst2(txtMesReferenciaEnergia, txtContaKwH, 
                txtValorTotalAPagar, txtConstMulti, txtNRdoMedidor, txtLeituraAnterior, 
                txtLeituraAtual , txtDataLeituraAnterior, txtDataLeituraAtual, comboBandeirasTarifarias, 
                txtCodigoFiscal, txtGrupoSubgrupo, txtClasseSubclasse, txtFornecimento, txtMTarifaria,
                txtRoteiroLeitura, txtTensaoNominal);
                
                Alert Alert = new Alert(AlertType.INFORMATION);
                Alert.setTitle("Confirmação de Cadastro");
                Alert.setHeaderText(null);
                Alert.setContentText("CADASTRO EFETUADO COM SUCESSO!");
                Alert.showAndWait();

                txtMesReferenciaEnergia.setText("");
                txtContaKwH.setText("");
                txtDataVencimento.setText("");
                txtDataLeituraAnterior.setText("");
                txtDataLeituraAtual.setText("");
                txtNRdoMedidor.setText("");
                txtConstMulti.setText("");
                txtValorTotalAPagar.setText("");
                txtLeituraAnterior.setText("");
                txtLeituraAtual.setText("");
                txtCodigoFiscal.setText("");
                txtGrupoSubgrupo.setText("");
                txtFornecimento.setText("");
                txtClasseSubclasse.setText("");
                txtTensaoNominal.setText("");
                txtMTarifaria.setText("");
                txtRoteiroLeitura.setText("");
                txtUsuario.setText("");
                
                Main.changeScreen("main");
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

