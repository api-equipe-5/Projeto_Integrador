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

public class CadastrarEnderecoEnergia implements Initializable {
    @FXML
    private TextField txtEndereco;
    @FXML
    private TextField txtCEP;
    @FXML
    private ComboBox comboUF;
    @FXML
    private TextField txtCidade;
    @FXML
    private Button btnRetornarEndereco;
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

    public void changeScreenRetornar(ActionEvent event){
        Main.changeScreen("energia1Scene");

        txtEndereco.setText("");
        txtCEP.setText("");
        txtCidade.setText("");
        comboUF.setValue("");
    }

    public void changeScreenCadastrar(ActionEvent event) {
        if(comboUF.getValue().equals("") || txtCidade.getText().equals("") || txtCEP.getText().equals("") || txtEndereco.getText().equals("")) {
            
            Alert Alert = new Alert(AlertType.INFORMATION);
            Alert.setTitle("Campos Obrigatórios Vazios");
            Alert.setHeaderText(null);
            Alert.setContentText("PREENCHA OS CAMPOS COM *");
            Alert.showAndWait(); 
        }
        else {
            Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Informações");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("CONFIRMA ESSAS INFORMAÇÕES?");

            Optional<ButtonType> result = confirmacao.showAndWait();
            if (result.get() == ButtonType.OK){
                String CEP = txtCEP.getText().replace("-","");
                if (CepDAO.validacaoCEP(BigInteger.valueOf(Long.parseLong(CEP)))){

                    Alert Alert = new Alert(AlertType.INFORMATION);
                    Alert.setTitle("CEP já cadastrado");
                    Alert.setHeaderText(null);
                    Alert.setContentText("Digite um CEP válido!");
                    Alert.showAndWait();

                    txtEndereco.setText("");
                    txtCEP.setText("");
                    txtCidade.setText("");
                    comboUF.setValue("");
                } else {

                Cep c = new Cep();
                CepDAO daocep = new CepDAO();
                c.setCep_cep(BigInteger.valueOf(Long.parseLong(CEP)));
                c.setCep_rua(txtEndereco.getText());
                c.setCep_estado(String.valueOf(comboUF.getValue()));
                c.setCep_cidade(txtCidade.getText());

                daocep.create(c);

                Alert cadastro1 = new Alert(Alert.AlertType.INFORMATION);
                cadastro1.setTitle("Cadastro efetuado com sucesso !");
                cadastro1.setHeaderText("Seu endereço foi cadastrado com sucesso!");
                cadastro1.showAndWait();
                
                txtEndereco.setText("");
                txtCEP.setText("");
                txtCidade.setText("");
                comboUF.setValue("");
                }
            } else {
            }    
        }
    }

// Mascaras
    @FXML
    private void mascaraCEP(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("#####-###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCEP);
        tff.formatter();
    }
}