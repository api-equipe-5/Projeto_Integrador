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

public class PessoaFisica implements Initializable {
    @FXML
    private TextField txtNomeCompleto;
    @FXML
    private TextField txtCPF;
    @FXML
    private TextField txtNomeFornecedor;
    @FXML
    private TextField txtCNPJFornecedor;
    @FXML
    private TextField txtEmail;
    @FXML
    private ComboBox comboTipo;
    @FXML
    private Button btnBuscarCPF;
    @FXML
    private Button btnBuscarCNPJ;
    @FXML
    private Button btnProsseguirPF;
    @FXML
    private Button btnRetornarPF;
    @FXML
    private Button btnFornecedor;
    @FXML
    private Button btnPessoaFisica;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        comboTipo.getItems().add("Água");
        comboTipo.getItems().add("Energia");
    }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("main");

        txtNomeCompleto.setText("");
        txtCPF.setText("");
        txtNomeFornecedor.setText("");
        txtCNPJFornecedor.setText("");
        txtEmail.setText("");
        comboTipo.setValue("");
    }
    public void changeScreenCadastrarPessoaFisica(ActionEvent event) {
        Main.changeScreen("cadastrarpessoafisica");
    }

    public void changeScreenCadastrarFornecedor(ActionEvent event) {
        Main.changeScreen("cadastrarfornecedorpf");
    }

    public void changeScreenBuscarCPF(ActionEvent event) {
        String CPF0 = txtCPF.getText().replace("-","");
        String CPF1 = CPF0.replace(".","");
        if (ClienteDAO.validacaoCliente(BigInteger.valueOf(Long.parseLong(CPF1)))){

            ClienteDAO.buscar(BigInteger.valueOf(Long.parseLong(CPF1)), txtNomeCompleto, txtEmail);
        } else {
            Alert cadastro = new Alert(Alert.AlertType.INFORMATION);
            cadastro.setTitle("CPF não encontrado");
            cadastro.setHeaderText("Digite um CPF válido!");
            cadastro.showAndWait();

            txtCPF.setText("");
        }
    }
    public void changeScreenBuscarCNPJ(ActionEvent event) {
        String CNPJFornecedor = txtCNPJFornecedor.getText().replace("-","");
        String CNPJFornecedor2 = CNPJFornecedor.replace("/","");
        String CNPJFornecedorFinal = CNPJFornecedor2.replace(".","");
        if (FornecedorDAO.validacaoFornecedor(BigInteger.valueOf(Long.parseLong(CNPJFornecedorFinal)))){

            FornecedorDAO.buscar(BigInteger.valueOf(Long.parseLong(CNPJFornecedorFinal)), txtNomeFornecedor, comboTipo);
        } else {
            Alert cadastro = new Alert(Alert.AlertType.INFORMATION);
            cadastro.setTitle("CNPJ não encontrado");
            cadastro.setHeaderText("Digite um CNPJ válido!");
            cadastro.showAndWait();
            
            txtCNPJFornecedor.setText("");
        }
    }

    public void changeScreenProsseguir(ActionEvent event) {
        if(txtNomeCompleto.getText().equals("") || txtNomeFornecedor.getText().equals("") || txtCNPJFornecedor.getText().equals("") || txtCPF.getText().equals("") || comboTipo.getValue().equals("")) {
            
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
                String CPF1 = txtCPF.getText().replace("-","");
                String CPF = CPF1.replace(".","");
                String CNPJFornecedor = txtCNPJFornecedor.getText().replace("-","");
                String CNPJFornecedor2 = CNPJFornecedor.replace("/","");
                String CNPJFornecedorFinal = CNPJFornecedor2.replace(".","");

                Main.salvarIntalacaoCliente(CPF, CNPJFornecedorFinal);

                Main.changeScreen("tipoconta");

                txtNomeCompleto.setText("");
                txtCPF.setText("");
                txtNomeFornecedor.setText("");
                txtCNPJFornecedor.setText("");
                txtEmail.setText("");
                comboTipo.setValue("");
            } else {
            }    
        }
    }

// Mascaras
    @FXML
    private void mascaraCPF(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCPF);
        tff.formatter();
    }

    @FXML
    private void mascaraCNPJ(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###.###/####-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCNPJFornecedor);
        tff.formatter();
    }
}