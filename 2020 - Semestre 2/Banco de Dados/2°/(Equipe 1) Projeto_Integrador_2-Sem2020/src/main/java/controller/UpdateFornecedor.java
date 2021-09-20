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
import javafx.scene.control.ComboBox;
import application.Main;
import classes.Fornecedor;
import dao.FornecedorDAO;

public class UpdateFornecedor implements Initializable {
    
    @FXML
    private TextField txtCNPJFornecedor;
    @FXML
    private TextField txtNomeFornecedor;
    @FXML
    private ComboBox comboTipo;
    @FXML
    private Button btnEditarFornecedor;
    @FXML
    private Button btnRetornar;
    @FXML
    private Button btnBuscarCNPJ;
    

    @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
              comboTipo.getItems().add("Água");
              comboTipo.getItems().add("Energia");
        }

    public void changeScreenRetornar(ActionEvent event) {
        Main.changeScreen("relatoriocliente");

        txtCNPJFornecedor.setText("");
        txtNomeFornecedor.setText("");
        comboTipo.setValue("");
        
    }
    public void buscarCNPJ(ActionEvent event) {
         String CNPJCliente = txtCNPJFornecedor.getText().replace("-","");
         String CNPJCliente2 = CNPJCliente.replace(".","");
         String CNPJFornecedorFinal = CNPJCliente2.replace("/",""); 
         if (FornecedorDAO.validacaoFornecedor(BigInteger.valueOf(Long.parseLong(CNPJFornecedorFinal)))){

            FornecedorDAO.buscar(BigInteger.valueOf(Long.parseLong(CNPJFornecedorFinal)),txtNomeFornecedor,comboTipo);     

        } else {
            Alert cadastro = new Alert(Alert.AlertType.INFORMATION);
            cadastro.setTitle("CNPJ não encontrado");
            cadastro.setHeaderText("Digite um numero de CNPJ válido!");
            cadastro.showAndWait();

            txtCNPJFornecedor.setText("");
        }
    }

    public void editarFornecedor(ActionEvent event) {
            Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Informações");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("DESEJA ATUALIZAR O CADASTRO?");

            Optional<ButtonType> result = confirmacao.showAndWait();
            if (result.get() == ButtonType.OK){
                String CNPJCliente = txtCNPJFornecedor.getText().replace("-","");
                String CNPJCliente2 = CNPJCliente.replace(".","");
                String CNPJFornecedorFinal = CNPJCliente2.replace("/",""); 
                
                Fornecedor f = new Fornecedor();
                FornecedorDAO daofor = new FornecedorDAO();

                f.setFor_nome(txtNomeFornecedor.getText());
                f.setFor_tipo(String.valueOf(comboTipo.getValue()));
                f.setFor_cnpj(BigInteger.valueOf(Long.parseLong(CNPJFornecedorFinal)));
               
                daofor.update(f);
                
                Alert cadastrado = new Alert(Alert.AlertType.INFORMATION);
                cadastrado.setTitle("Dados atualizado com sucesso");
                cadastrado.setHeaderText("Os dados foram atualizados com sucesso");
                cadastrado.showAndWait();

                txtCNPJFornecedor.setText("");
                txtNomeFornecedor.setText("");
                comboTipo.setValue("");
                
         }else{

         }
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