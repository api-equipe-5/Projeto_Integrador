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
import classes.Cliente;
import classes.Fornecedor;
import dao.ClienteDAO;
import dao.FornecedorDAO;

public class CadastroFornecedorPF implements Initializable {
    @FXML
    private TextField txtCNPJFornecedor;
    @FXML
    private TextField txtNomeFornecedor;
    @FXML
    private ComboBox comboTipo;
    @FXML
    private Button btnRetornar;
    @FXML
    private Button btnCadastrarFornecedor;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        comboTipo.getItems().add("Água");
        comboTipo.getItems().add("Energia");
    }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("pf");

        txtNomeFornecedor.setText("");
        txtCNPJFornecedor.setText("");
        comboTipo.setValue("");
    }

    public void changeScreenCadastrar(ActionEvent event) {
        if(txtNomeFornecedor.getText().equals("") || txtCNPJFornecedor.getText().equals("") || comboTipo.getValue().equals("")) {
            
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
            confirmacao.setContentText("DESEJA ADICIONAR UM CADASTRO?");
            
            Optional<ButtonType> result = confirmacao.showAndWait();
            if (result.get() == ButtonType.OK){
                String CNPJFornecedor = txtCNPJFornecedor.getText().replace("-","");
                String CNPJFornecedor2 = CNPJFornecedor.replace(".","");
                String CNPJFornecedorFinal = CNPJFornecedor2.replace("/","");
                if (FornecedorDAO.validacaoFornecedor(BigInteger.valueOf(Long.parseLong(CNPJFornecedorFinal)))){
                    
                    Alert cadastro = new Alert(Alert.AlertType.INFORMATION);
                    cadastro.setTitle("CNPJ já cadastrado");
                    cadastro.setHeaderText("CNPJ do fornecedor já existe!");
                    cadastro.showAndWait();

                    txtNomeFornecedor.setText("");
                    txtCNPJFornecedor.setText("");
                    comboTipo.setValue("");

                } else {

                    Fornecedor f = new Fornecedor();
                    FornecedorDAO daofor = new FornecedorDAO();
                    f.setFor_cnpj(BigInteger.valueOf(Long.parseLong(CNPJFornecedorFinal)));
                    f.setFor_nome(txtNomeFornecedor.getText());
                    f.setFor_tipo(String.valueOf(comboTipo.getValue()));

                    daofor.create(f);

                    Alert cadastro1 = new Alert(Alert.AlertType.INFORMATION);
                    cadastro1.setTitle("Cadastro efetuado com sucesso !");
                    cadastro1.setHeaderText("Seu fornecedor foi cadastrado com sucesso!");
                    cadastro1.showAndWait();

                    txtNomeFornecedor.setText("");
                    txtCNPJFornecedor.setText("");
                    comboTipo.setValue("");
                }
            } else {
            }    
        }
    }

// Mascaras
    @FXML
    private void mascaraCNPJ(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###.###/####-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCNPJFornecedor);
        tff.formatter();
    }
}