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
import dao.ClienteDAO;


public class CadastroPessoaJuridica implements Initializable {
    @FXML
    private TextField txtNomeFantasia;
    @FXML
    private TextField txtCNPJEmpresa;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnRetornarPJ;
    @FXML
    private Button btnCadastrarPJ;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
    }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("pj");
        txtNomeFantasia.setText("");
        txtCNPJEmpresa.setText("");
        txtEmail.setText("");
    }

    public void changeScreenCadastrar(ActionEvent event) {
        if(txtNomeFantasia.getText().equals("") || txtCNPJEmpresa.getText().equals("")) {
            
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
                String CNPJCliente = txtCNPJEmpresa.getText().replace("-","");
                String CNPJCliente2 = CNPJCliente.replace(".","");
                String CNPJClienteFinal = CNPJCliente2.replace("/","");
                if (ClienteDAO.validacaoCliente(BigInteger.valueOf(Long.parseLong(CNPJClienteFinal)))){

                    Alert cadastro = new Alert(Alert.AlertType.INFORMATION);
                    cadastro.setTitle("CNPJ já cadastrado");
                    cadastro.setHeaderText("CNPJ do cliente já existe!");
                    cadastro.showAndWait();

                    txtNomeFantasia.setText("");
                    txtCNPJEmpresa.setText("");
                    txtEmail.setText("");

                } else {

                    Cliente c = new Cliente();
                    ClienteDAO dao = new ClienteDAO();
                    c.setCli_documento(BigInteger.valueOf(Long.parseLong(CNPJClienteFinal)));
                    c.setCli_nome(txtNomeFantasia.getText());
                    c.setEmail(txtEmail.getText());

                    dao.create(c);

                    Alert cadastro = new Alert(Alert.AlertType.INFORMATION);
                    cadastro.setTitle("Cadastro efetuado com sucesso !");
                    cadastro.setHeaderText("Seu cliente foi cadastrado com sucesso!");
                    cadastro.showAndWait();

                    txtNomeFantasia.setText("");
                    txtCNPJEmpresa.setText("");
                    txtEmail.setText("");
                }
            } else {
                
            }    
        }
    }
  // Mascaras
    @FXML
    private void mascaraCNPJCliente(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###.###/####-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCNPJEmpresa);
        tff.formatter();
    }    
}