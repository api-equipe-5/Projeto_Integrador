package controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import javafx.scene.control.ComboBox;
import java.util.Optional;
import java.util.ResourceBundle;
import util.TextFieldFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import application.Main;
import classes.Agua;
import classes.Conta;
import dao.AguaDAO;
import dao.ContaDAO;

public class UpdateAgua1 implements Initializable {
    @FXML
    private TextField txtRGI;
    @FXML
    private TextField txtGR;
    @FXML
    private TextField txtCodigoCliente;
    @FXML
    private TextField txtNumeroConta;
    @FXML
    private TextField txtMesReferencia;
    @FXML
    private TextField txtTipoLigacao;
    @FXML
    private TextField txtHidrometro;
    @FXML
    private TextField txtLeituraAntData;
    @FXML
    private TextField txtLeituraAntNumero;
    @FXML
    private TextField txtLeituraAtualData;
    @FXML
    private TextField txtLeituraAtualNumero;
    @FXML
    private TextField txtConsumo;
    @FXML
    private TextField txtVencimento;
    @FXML
    private Button btnRetornarRelatorio;
    @FXML
    private Button btnSalvarContinuar;
    @FXML
    private Button btnBuscar;

    @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
            // TODO Auto-generated method stub
        }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("relatorioagua");

        txtVencimento.setText("");
        txtRGI.setText("");
        txtMesReferencia.setText("");
        txtConsumo.setText("");
        txtGR.setText("");
        txtCodigoCliente.setText("");
        txtNumeroConta.setText("");
        txtTipoLigacao.setText("");
        txtHidrometro.setText("");
        txtLeituraAntData.setText("");
        txtLeituraAtualData.setText("");
        txtLeituraAntNumero.setText("");
        txtLeituraAtualNumero.setText("");
    }
    public void buscarNumeroInstalacao(ActionEvent event) {
        String RGI = txtRGI.getText().replaceAll("/", "");
        if (AguaDAO.validacaoConta(BigInteger.valueOf(Long.parseLong(RGI)), txtMesReferencia.getText())){

            AguaDAO.buscar1(BigInteger.valueOf(Long.parseLong(RGI)), txtMesReferencia.getText(),txtGR, txtCodigoCliente,
            txtNumeroConta,txtTipoLigacao, txtHidrometro, txtLeituraAntData,
            txtLeituraAntNumero,txtLeituraAtualData, txtLeituraAtualNumero,txtConsumo);
            ContaDAO.buscarconta(BigInteger.valueOf(Long.parseLong(RGI)), txtMesReferencia.getText(),txtVencimento); 
        } else {
            Alert cadastro = new Alert(Alert.AlertType.INFORMATION);
            cadastro.setTitle("Numero de instalação e/ou mês de referência não encontrado");
            cadastro.setHeaderText("Digite um numero de instalação e/ou mês de referência válido!");
            cadastro.showAndWait();

            txtRGI.setText("");
            txtMesReferencia.setText("");
        }
    }

    public void changeScreenContinuar(ActionEvent event) {
            Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Informações");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("DESEJA ATUALIZAR O CADASTRO?");

            Optional<ButtonType> result = confirmacao.showAndWait();
            if (result.get() == ButtonType.OK){
                String RGI = txtRGI.getText().replaceAll("/", "");
                Agua agu = new Agua();
                AguaDAO aguadao = new AguaDAO();

                agu.setAgu_gr(BigInteger.valueOf(Long.parseLong(txtGR.getText())));
                agu.setAgu_codigo_cliente(BigInteger.valueOf(Long.parseLong(txtCodigoCliente.getText())));
                agu.setAgu_numero_conta(BigInteger.valueOf(Long.parseLong(txtNumeroConta.getText())));
                agu.setAgu_tipo_ligacao(txtTipoLigacao.getText());
                agu.setAgu_hidrometro(txtHidrometro.getText());
                agu.setAgu_data_leitura_anterior(txtLeituraAntData.getText());
                agu.setAgu_data_leitura_atual(txtLeituraAtualData.getText());
                agu.setAgu_leitura_anterior(BigInteger.valueOf(Long.parseLong(txtLeituraAntNumero.getText())));
                agu.setAgu_leitura_atual(BigInteger.valueOf(Long.parseLong(txtLeituraAtualNumero.getText())));
                agu.setAgu_consumo(BigInteger.valueOf(Long.parseLong(txtConsumo.getText())));
                agu.setInt_numero_instalacao(BigInteger.valueOf(Long.parseLong(RGI)));
                agu.setCta_mes_referencia(txtMesReferencia.getText());

                aguadao.update1(agu);
                
                Alert cadastrado = new Alert(Alert.AlertType.INFORMATION);
                cadastrado.setTitle("Dados atualizado com sucesso");
                cadastrado.setHeaderText("Os dados foram atualizados com sucesso");
                cadastrado.showAndWait();

                Main.changeScreen("updateagua2");

                txtRGI.setText("");
                txtMesReferencia.setText("");
                txtConsumo.setText("");
                txtGR.setText("");
                txtCodigoCliente.setText("");
                txtNumeroConta.setText("");
                txtTipoLigacao.setText("");
                txtHidrometro.setText("");
                txtLeituraAntData.setText("");
                txtLeituraAtualData.setText("");
                txtLeituraAntNumero.setText("");
                txtLeituraAtualNumero.setText("");
                txtVencimento.setText("");
         }else{

         }
    }   

    @FXML
    private void mascaraDataAnt(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtLeituraAntData);
        tff.formatter();
    }
    @FXML
    private void mascaraDataAtual(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtLeituraAtualData);
        tff.formatter();
    }
    @FXML
    private void mascaraMesReferencia(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtMesReferencia);
        tff.formatter();
    }

    @FXML
    private void mascaraRGI(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("########/##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtRGI);
        tff.formatter();
    }
    @FXML
    private void mascaraVencimento(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/##/##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtVencimento);
        tff.formatter();
    }
}