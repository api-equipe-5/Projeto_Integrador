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
import classes.Cliente;
import dao.ClienteDAO;


public class UpdatePessoaFisica implements Initializable {
    
    @FXML
    private TextField txtCPF;
    @FXML
    private TextField txtNomeCompleto;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnRetornarPF;
    @FXML
    private Button btnBuscarCPF;
    

    @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
            
        }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("relatoriocliente");

        txtCPF.setText("");
        txtNomeCompleto.setText("");
        txtEmail.setText("");
        
    }
    public void buscarCPF(ActionEvent event) {
            String CPF0 = txtCPF.getText().replace("-","");
            String CPF1 = CPF0.replace(".","");
         if (ClienteDAO.validacaoCliente(BigInteger.valueOf(Long.parseLong(CPF1)))){

            ClienteDAO.buscar(BigInteger.valueOf(Long.parseLong(CPF1)),txtNomeCompleto,txtEmail);     

        } else {
            Alert cadastro = new Alert(Alert.AlertType.INFORMATION);
            cadastro.setTitle("CPF não encontrado");
            cadastro.setHeaderText("Digite um numero de CPF válido!");
            cadastro.showAndWait();

            txtCPF.setText("");

        }
    }

    public void editarCliente(ActionEvent event) {
            Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Informações");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("DESEJA ATUALIZAR O CADASTRO?");

            Optional<ButtonType> result = confirmacao.showAndWait();
            if (result.get() == ButtonType.OK){
                String CPF0 = txtCPF.getText().replace("-","");
                String CPF1 = CPF0.replace(".","");
                Cliente c = new Cliente();
                ClienteDAO daocli = new ClienteDAO();

                c.setCli_nome(txtNomeCompleto.getText());
                c.setEmail(txtEmail.getText());
                c.setCli_documento(BigInteger.valueOf(Long.parseLong(CPF1)));
               
                daocli.update(c);
                
                Alert cadastrado = new Alert(Alert.AlertType.INFORMATION);
                cadastrado.setTitle("Dados atualizado com sucesso");
                cadastrado.setHeaderText("Os dados foram atualizados com sucesso");
                cadastrado.showAndWait();

                txtCPF.setText("");
                txtNomeCompleto.setText("");
                txtEmail.setText("");
                
         }else{

         }
    }   
    @FXML
    private void mascaraCPF(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCPF);
        tff.formatter();
    }
}