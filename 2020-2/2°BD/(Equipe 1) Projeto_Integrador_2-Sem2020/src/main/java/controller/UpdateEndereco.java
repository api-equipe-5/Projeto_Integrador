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
import dao.CepDAO;
import classes.Cep;



public class UpdateEndereco implements Initializable {
    
    @FXML
    private TextField txtCEP;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtEndereco;
    @FXML
    private ComboBox comboUF;
    @FXML
    private Button btnEditarEndereco;
    @FXML
    private Button btnRetornarRelatorio;
    @FXML
    private Button btnBuscarCNPJ;

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
        Main.changeScreen("tiporelatorio");

        txtCEP.setText("");
        txtCidade.setText("");
        txtEndereco.setText("");
        comboUF.setValue("");        
    }
    public void buscarCNPJ(ActionEvent event) {
         String CEP = txtCEP.getText().replace("-","");
         if (CepDAO.validacaoCEP(BigInteger.valueOf(Long.parseLong(CEP)))){

            CepDAO.buscar(BigInteger.valueOf(Long.parseLong(CEP)),txtCidade,txtEndereco,comboUF);     
        } else {
            Alert cadastro = new Alert(Alert.AlertType.INFORMATION);
            cadastro.setTitle("CEP não encontrado");
            cadastro.setHeaderText("Digite um CEP válido!");
            cadastro.showAndWait();

            txtCEP.setText("");
        }
    }

    public void editarEndereco(ActionEvent event) {
            Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Informações");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("DESEJA ATUALIZAR O ENDEREÇO?");

            Optional<ButtonType> result = confirmacao.showAndWait();
            if (result.get() == ButtonType.OK){
                String CEP = txtCEP.getText().replace("-","");
                Cep c = new Cep();
                CepDAO daocep = new CepDAO();

                c.setCep_rua(txtEndereco.getText());
                c.setCep_estado(String.valueOf(comboUF.getValue()));
                c.setCep_cidade(txtCidade.getText());
                c.setCep_cep(BigInteger.valueOf(Long.parseLong(CEP)));

                daocep.update(c);
                            
                Alert cadastrado = new Alert(Alert.AlertType.INFORMATION);
                cadastrado.setTitle("Dados atualizado com sucesso");
                cadastrado.setHeaderText("Os dados foram atualizados com sucesso");
                cadastrado.showAndWait();

                txtCEP.setText("");
                txtCidade.setText("");
                txtEndereco.setText("");
                comboUF.setValue("");
               
         }else{

         }
    }   
    @FXML
    private void mascaraCEP(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("#####-###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCEP);
        tff.formatter();
    }
}