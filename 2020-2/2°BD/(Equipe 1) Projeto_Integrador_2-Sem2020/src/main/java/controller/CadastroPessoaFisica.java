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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import util.TextFieldFormatter;
import application.Main;
import classes.Cliente;
import dao.ClienteDAO;


public class CadastroPessoaFisica implements Initializable {
    @FXML
    private TextField txtCPF;
    @FXML
    private TextField txtNomeCompleto;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnCadastrarPF;
    @FXML
    private Button btnRetornarPF;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
    }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("pf");

        txtNomeCompleto.setText("");
        txtCPF.setText("");
        txtEmail.setText("");
    }


    public void changeScreenCadastrar(ActionEvent event) {
        if(txtCPF.getText().equals("") || txtNomeCompleto.getText().equals("")) {
            
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
                String CPF0 = txtCPF.getText().replace("-","");
                String CPF1 = CPF0.replace(".","");
                if (ClienteDAO.validacaoCliente(BigInteger.valueOf(Long.parseLong(CPF1)))){

                    Alert cadastro = new Alert(Alert.AlertType.INFORMATION);
                    cadastro.setTitle("CPF já cadastrado");
                    cadastro.setHeaderText("CPF do cliente já existe!");
                    cadastro.showAndWait();

                    txtNomeCompleto.setText("");
                    txtCPF.setText("");
                    txtEmail.setText("");

                } else {
                    Cliente c = new Cliente();
                    ClienteDAO dao = new ClienteDAO();
                    c.setCli_documento(BigInteger.valueOf(Long.parseLong(CPF1)));
                    c.setCli_nome(txtNomeCompleto.getText());
                    c.setEmail(txtEmail.getText());

                    dao.create(c);

                    Alert cadastro = new Alert(Alert.AlertType.INFORMATION);
                    cadastro.setTitle("Cadastro efetuado com sucesso !");
                    cadastro.setHeaderText("Seu cliente foi cadastrado com sucesso!");
                    cadastro.showAndWait();

                    txtNomeCompleto.setText("");
                    txtCPF.setText("");
                    txtEmail.setText("");
                }

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
}