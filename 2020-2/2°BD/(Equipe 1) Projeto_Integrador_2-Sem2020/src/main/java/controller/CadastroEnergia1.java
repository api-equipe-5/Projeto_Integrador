package controller;

import java.math.BigInteger;
import java.net.URL;
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
import classes.Cep;
import classes.Endereco;
import dao.CepDAO;
import dao.EnderecoDAO;

public class CadastroEnergia1 implements Initializable {
    @FXML
    private TextField txtCEPEnergia;
    @FXML
    private ComboBox comboUF;
    @FXML
    private TextField txtComplemento;
    @FXML
    private TextField txtCidadeEnergia;
    @FXML
    private TextField txtCodigoFiscalEnergia;
    @FXML
    private TextField txtEnderecoEnergia;
    @FXML
    private TextField txtNumeroEnergia;
    @FXML
    private TextField txtGrupoSubgrupoEnergia;
    @FXML
    private TextField txtClasseSubclasseEnergia;
    @FXML
    private TextField txtFornecimentoEnergia;
    @FXML
    private TextField txtMTarifaEnergia;
    @FXML
    private TextField txtRoteiroLeituraEnergia;
    @FXML
    private TextField txtTensaoNominalEnergia;
    @FXML
    private Button btnVoltarTelaIncial;
    @FXML
    private Button btnRetornarEnergia;
    @FXML
    private Button btnBuscarCEP;
    @FXML
    private Button btnCadastrarEndereco;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        comboUF.getItems().add("AC");
        comboUF.getItems().add("AL");
        comboUF.getItems().add("AP");
        comboUF.getItems().add("AM");
        comboUF.getItems().add("BA");
        comboUF.getItems().add("CE");
        comboUF.getItems().add("ES");
        comboUF.getItems().add("GO");
        comboUF.getItems().add("MA");
        comboUF.getItems().add("MT");
        comboUF.getItems().add("MS");
        comboUF.getItems().add("MG");
        comboUF.getItems().add("PA");
        comboUF.getItems().add("PB");
        comboUF.getItems().add("PR");
        comboUF.getItems().add("PE");
        comboUF.getItems().add("PI");
        comboUF.getItems().add("RJ");
        comboUF.getItems().add("RN");
        comboUF.getItems().add("RS");
        comboUF.getItems().add("RO");
        comboUF.getItems().add("RR");
        comboUF.getItems().add("SC");
        comboUF.getItems().add("SP");
        comboUF.getItems().add("SE");
        comboUF.getItems().add("TO");
        comboUF.getItems().add("DF");
    }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("tipoconta");

        txtCEPEnergia.setText("");
        txtComplemento.setText("");
        txtCidadeEnergia.setText("");
        txtCodigoFiscalEnergia.setText("");
        txtEnderecoEnergia.setText("");
        txtNumeroEnergia.setText("");
        txtGrupoSubgrupoEnergia.setText("");
        txtClasseSubclasseEnergia.setText("");
        txtFornecimentoEnergia.setText("");
        txtMTarifaEnergia.setText("");
        txtRoteiroLeituraEnergia.setText("");
        txtTensaoNominalEnergia.setText("");
        comboUF.setValue("");
    }

    public void cadastrarNovoEndereco(ActionEvent event){
        Main.changeScreen("cadastrarenderecoenergia");
    }

    public void buscarCEP(ActionEvent event){
        String CEP = txtCEPEnergia.getText().replace("-","");
        if (CepDAO.validacaoCEP(BigInteger.valueOf(Long.parseLong(CEP)))){
            
            CepDAO.buscar(BigInteger.valueOf(Long.parseLong(CEP)), txtCidadeEnergia, txtEnderecoEnergia, comboUF);
        } else {
            Alert Alert = new Alert(AlertType.INFORMATION);
            Alert.setTitle("CEP não encontrado");
            Alert.setHeaderText(null);
            Alert.setContentText("Digite um CEP válido!");
            Alert.showAndWait();

            txtCEPEnergia.setText("");
        }
    }

    public void changeScreenVoltarTelaInicial(ActionEvent event) {
        Alert confirmacao = new Alert(AlertType.CONFIRMATION);
        confirmacao.setTitle("Confirmação de Cadastro");
        confirmacao.setHeaderText(null);
        confirmacao.setContentText("DESEJA ADICIONAR UM CADASTRO?");

        Optional<ButtonType> result = confirmacao.showAndWait();
        if(comboUF.getValue().equals("") || txtNumeroEnergia.getText().equals("") || txtMTarifaEnergia.getText().equals("") || txtClasseSubclasseEnergia.getText().equals("") || txtGrupoSubgrupoEnergia.getText().equals("") || txtCodigoFiscalEnergia.getText().equals("") || txtCidadeEnergia.getText().equals("") || txtCEPEnergia.getText().equals("") || txtEnderecoEnergia.getText().equals("")) {
            
            Alert Alert = new Alert(AlertType.INFORMATION);
            Alert.setTitle("Campos Obrigatórios Vazios");
            Alert.setHeaderText(null);
            Alert.setContentText("PREENCHA OS CAMPOS COM *");
            Alert.showAndWait(); 
        }
        else {
            if (result.get() == ButtonType.OK){
                String CEP = txtCEPEnergia.getText().replace("-","");

                Endereco e = new Endereco();
                EnderecoDAO daoend = new EnderecoDAO();
                e.setCep_cep(BigInteger.valueOf(Long.parseLong(CEP)));
                e.setEnd_numero(BigInteger.valueOf(Long.parseLong(txtNumeroEnergia.getText())));
                e.setEnd_complemento(txtComplemento.getText());

                daoend.create(e);

                Main.salvarEnergia1(txtCodigoFiscalEnergia, txtGrupoSubgrupoEnergia, txtClasseSubclasseEnergia, txtFornecimentoEnergia, txtMTarifaEnergia, txtRoteiroLeituraEnergia, txtTensaoNominalEnergia);

                Main.salvarIntalacaoEndereco(CEP, txtNumeroEnergia);

                txtCEPEnergia.setText("");
                txtComplemento.setText("");
                txtCidadeEnergia.setText("");
                txtCodigoFiscalEnergia.setText("");
                txtEnderecoEnergia.setText("");
                txtNumeroEnergia.setText("");
                txtGrupoSubgrupoEnergia.setText("");
                txtClasseSubclasseEnergia.setText("");
                txtFornecimentoEnergia.setText("");
                txtMTarifaEnergia.setText("");
                txtRoteiroLeituraEnergia.setText("");
                txtTensaoNominalEnergia.setText("");
                comboUF.setValue("");

                Main.changeScreen("energia2Scene");
            } else {
            }    
        }
    }
 //Mascaras
    @FXML
    private void mascaraCEP(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("#####-###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCEPEnergia);
        tff.formatter();
        }
    }