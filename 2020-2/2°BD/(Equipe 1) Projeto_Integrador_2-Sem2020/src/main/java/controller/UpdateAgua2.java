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

public class UpdateAgua2 implements Initializable {
    @FXML
    private TextField txtValorTotal;
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
    private TextField txtNCadastros;
    @FXML
    private Button btnEditarVoltarTelaInicial;
    @FXML
    private Button btnDeletar;
    @FXML
    private Button btnRetornarAgua2;
    @FXML
    private Button btnBuscar;

    @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
            // TODO Auto-generated method stub
            
        }

    public void buscarCampos(ActionEvent event) {
        AguaDAO.buscar2(txtTarifaAguaAte10,txtTarifaAgua11a20,
            txtTarifaAgua21a31,txtTarifaAgua31a50,txtTarifaAcima50, txtValorAguaAte10,
            txtValorAgua11a20, txtTarifaEsgotoAte10, txtTarifaEsgoto11a20,
            txtTarifaEsgoto21a30,txtTarifaEsgoto31a50,txtTarifaEsgotoAcima50,
            txtValorEsgotoAte10,txtValorEsgoto11a20, txtVIAgua,
            txtVIEsgoto, txtTaxaRegulacao, txtMulta);
        ContaDAO.buscarUsuario(txtUsuario);
        ContaDAO.buscarContador(txtNCadastros);

        txtValorTotal.setText(String.valueOf(Double.parseDouble(txtTaxaRegulacao.getText()) + 
        Double.parseDouble(txtMulta.getText()) + Double.parseDouble(txtVIEsgoto.getText()) + 
        Double.parseDouble(txtVIAgua.getText())));
    }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("updateagua1");

        txtTarifaAguaAte10.setText("");
        txtTarifaAgua11a20.setText("");
        txtTarifaAgua21a31.setText("");
        txtTarifaAgua31a50.setText("");
        txtTarifaAcima50.setText("");
        txtValorAguaAte10.setText("");
        txtValorAgua11a20.setText("");
        txtTarifaEsgotoAte10.setText("");
        txtTarifaEsgoto11a20.setText("");
        txtTarifaEsgoto21a30.setText("");
        txtTarifaEsgoto31a50.setText("");
        txtTarifaEsgotoAcima50.setText("");
        txtValorEsgotoAte10.setText("");
        txtValorEsgoto11a20.setText("");
        txtVIAgua.setText("");
        txtVIEsgoto.setText("");
        txtTaxaRegulacao.setText("");
        txtMulta.setText("");
        txtValorTotal.setText("");
        txtUsuario.setText("");
        txtNCadastros.setText("");
    }
    public void deletarConta(ActionEvent event) {
        Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Informações");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("DESEJA DELETAR ESSA CONTA DE ÁGUA?");

        Optional<ButtonType> result = confirmacao.showAndWait();
         if (result.get() == ButtonType.OK){
            AguaDAO daoagu = new AguaDAO();
            ContaDAO daoconta = new ContaDAO();
            
            daoagu.delete();
            daoconta.delete();

            Alert cadastrado = new Alert(Alert.AlertType.INFORMATION);
                cadastrado.setTitle("Dados deletados com sucesso");
                cadastrado.setHeaderText("Os dados foram deletados com sucesso.");
                cadastrado.showAndWait();

                txtTarifaAguaAte10.setText("");
                txtTarifaAgua11a20.setText("");
                txtTarifaAgua21a31.setText("");
                txtTarifaAgua31a50.setText("");
                txtTarifaAcima50.setText("");
                txtValorAguaAte10.setText("");
                txtValorAgua11a20.setText("");
                txtTarifaEsgotoAte10.setText("");
                txtTarifaEsgoto11a20.setText("");
                txtTarifaEsgoto21a30.setText("");
                txtTarifaEsgoto31a50.setText("");
                txtTarifaEsgotoAcima50.setText("");
                txtValorEsgotoAte10.setText("");
                txtValorEsgoto11a20.setText("");
                txtVIAgua.setText("");
                txtVIEsgoto.setText("");
                txtTaxaRegulacao.setText("");
                txtMulta.setText("");
                txtValorTotal.setText("");
                txtUsuario.setText("");
                txtNCadastros.setText("");
        }else{

        }

    }

    public void changeEditar(ActionEvent event) {
            Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Informações");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("DESEJA ATUALIZAR O CADASTRO?");

            Optional<ButtonType> result = confirmacao.showAndWait();
            if (result.get() == ButtonType.OK){
                Agua agu = new Agua();
                AguaDAO aguadao = new AguaDAO();

                agu.setAgu_valor_agua(BigDecimal.valueOf(Double.parseDouble(txtVIAgua.getText())));
                agu.setAgu_valor_esgoto(BigDecimal.valueOf(Double.parseDouble(txtVIEsgoto.getText())));
                agu.setAgu_taxa_regulamentacao(BigDecimal.valueOf(Double.parseDouble(txtTaxaRegulacao.getText())));
                agu.setAgu_multa(BigDecimal.valueOf(Double.parseDouble(txtMulta.getText())));
                agu.setAgu_tarifa_ate10_agua(BigDecimal.valueOf(Double.parseDouble(txtTarifaAguaAte10.getText())));
                agu.setAgu_tarifa_ate20_agua(BigDecimal.valueOf(Double.parseDouble(txtTarifaAgua11a20.getText())));
                agu.setAgu_tarifa_ate30_agua(BigDecimal.valueOf(Double.parseDouble(txtTarifaAgua21a31.getText())));
                agu.setAgu_tarifa_ate50_agua(BigDecimal.valueOf(Double.parseDouble(txtTarifaAgua31a50.getText())));
                agu.setAgu_tarifa_acima50_agua(BigDecimal.valueOf(Double.parseDouble(txtTarifaAcima50.getText())));
                agu.setAgu_tarifa_ate10_esgoto(BigDecimal.valueOf(Double.parseDouble(txtTarifaEsgotoAte10.getText())));
                agu.setAgu_tarifa_ate20_esgoto(BigDecimal.valueOf(Double.parseDouble(txtTarifaEsgoto11a20.getText())));
                agu.setAgu_tarifa_ate30_esgoto(BigDecimal.valueOf(Double.parseDouble(txtTarifaEsgoto21a30.getText())));
                agu.setAgu_tarifa_ate50_esgoto(BigDecimal.valueOf(Double.parseDouble(txtTarifaEsgoto31a50.getText())));
                agu.setAgu_tarifa_acima50_esgoto(BigDecimal.valueOf(Double.parseDouble(txtTarifaEsgotoAcima50.getText())));
                agu.setAgu_valor_agua1(BigDecimal.valueOf(Double.parseDouble(txtValorAguaAte10.getText())));
                agu.setAgu_valor_agua2(BigDecimal.valueOf(Double.parseDouble(txtValorAgua11a20.getText())));
                agu.setAgu_valor_esgoto1(BigDecimal.valueOf(Double.parseDouble(txtValorEsgotoAte10.getText())));
                agu.setAgu_valor_esgoto2(BigDecimal.valueOf(Double.parseDouble(txtValorEsgoto11a20.getText())));

                aguadao.update2(agu);

                Main.changeScreen("relatorioagua");
                
                Alert cadastrado = new Alert(Alert.AlertType.INFORMATION);
                cadastrado.setTitle("Dados atualizado com sucesso");
                cadastrado.setHeaderText("Os dados foram atualizados com sucesso");
                cadastrado.showAndWait();

                txtTarifaAguaAte10.setText("");
                txtTarifaAgua11a20.setText("");
                txtTarifaAgua21a31.setText("");
                txtTarifaAgua31a50.setText("");
                txtTarifaAcima50.setText("");
                txtValorAguaAte10.setText("");
                txtValorAgua11a20.setText("");
                txtTarifaEsgotoAte10.setText("");
                txtTarifaEsgoto11a20.setText("");
                txtTarifaEsgoto21a30.setText("");
                txtTarifaEsgoto31a50.setText("");
                txtTarifaEsgotoAcima50.setText("");
                txtValorEsgotoAte10.setText("");
                txtValorEsgoto11a20.setText("");
                txtVIAgua.setText("");
                txtVIEsgoto.setText("");
                txtTaxaRegulacao.setText("");
                txtMulta.setText("");
                txtValorTotal.setText("");
                txtUsuario.setText("");
                txtNCadastros.setText("");
         }else{

         }
    }   
}