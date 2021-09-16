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


public class UpdatePessoaJuridica implements Initializable {
    
    @FXML
    private TextField txtCNPJEmpresa;
    @FXML
    private TextField txtNomeFantasia;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnRetornarPJ;
    @FXML
    private Button btnBuscarCNPJ;
 

    @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
            
        }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("relatoriocliente");

        txtCNPJEmpresa.setText("");
        txtNomeFantasia.setText("");
        txtEmail.setText("");
        
    }
    public void buscarCNPJ(ActionEvent event) {
        String CNPJCliente = txtCNPJEmpresa.getText().replace("-","");
        String CNPJCliente2 = CNPJCliente.replace(".","");
        String CNPJClienteFinal = CNPJCliente2.replace("/","");
         if (ClienteDAO.validacaoCliente(BigInteger.valueOf(Long.parseLong(CNPJClienteFinal)))){

            ClienteDAO.buscar(BigInteger.valueOf(Long.parseLong(CNPJClienteFinal)),txtNomeFantasia,txtEmail);     

        } else {
            Alert cadastro = new Alert(Alert.AlertType.INFORMATION);
            cadastro.setTitle("CNPJ não encontrado");
            cadastro.setHeaderText("Digite um numero de CNPJ válido!");
            cadastro.showAndWait();

            txtCNPJEmpresa.setText("");

        }
    }

    public void editarCNPJCliente(ActionEvent event) {
            Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Informações");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("DESEJA ATUALIZAR O CADASTRO?");

            Optional<ButtonType> result = confirmacao.showAndWait();
            if (result.get() == ButtonType.OK){
                String CNPJCliente = txtCNPJEmpresa.getText().replace("-","");
                String CNPJCliente2 = CNPJCliente.replace(".","");
                String CNPJClienteFinal = CNPJCliente2.replace("/",""); 
                Cliente c = new Cliente();
                ClienteDAO daocli = new ClienteDAO();

                c.setCli_nome(txtNomeFantasia.getText());
                c.setEmail(txtEmail.getText());
                c.setCli_documento(BigInteger.valueOf(Long.parseLong(CNPJClienteFinal)));
               
                daocli.update(c);
                
                Alert cadastrado = new Alert(Alert.AlertType.INFORMATION);
                cadastrado.setTitle("Dados atualizado com sucesso");
                cadastrado.setHeaderText("Os dados foram atualizados com sucesso");
                cadastrado.showAndWait();

                txtCNPJEmpresa.setText("");
                txtNomeFantasia.setText("");
                txtEmail.setText("");
                
         }else{

         }
    }   
    @FXML
    private void mascaraCNPJCliente(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###.###/####-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCNPJEmpresa);
        tff.formatter();
    }
}