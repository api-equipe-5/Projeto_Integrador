package application.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import application.models.Cliente;
import application.models.dao.ClienteSQL;
import application.util.TextFieldFormatter;
import application.util.ValidationFields;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ClienteController {

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtRua;

    @FXML
    private Button btnEditar;

    @FXML
    private TextField txtComplemento;

    @FXML
    private TextField txtCidade;

    @FXML
    private TextField txtUf;

    @FXML
    private TextField txtNomeCliente;

    @FXML
    private TextField txtCep;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnLimpar;

    @FXML
    private TextField txtBairro;
    
    @FXML
    private void txtTelefoneKeyReleased() {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("(##)#####-####");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(txtTelefone);
    	tff.formatter();
    }
    
    @FXML
    private void txtCpfKeyReleased() {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("###.###.###-##");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(txtCpf);
    	tff.formatter();
    }
    
    @FXML
    private void txtCepKeyReleased() {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("#####-###");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(txtCep);
    	tff.formatter();
    }
    

    @FXML
    void executarClickCadastrar(ActionEvent event) throws NoSuchAlgorithmException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Caixa de Confirmação");
//		alert.setHeaderText("Caixa de diálogo de confirmação");
		alert.setContentText("Deseja realmente cadastrar um novo Cliente");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) { 
			
			// Verifica se há campos obrigatórios não preenchidos
			boolean camposPreenchidos = ValidationFields.checkEmptyFields(txtNomeCliente, txtCpf, txtCep, txtRua, txtNumero, txtBairro, txtCidade, txtUf, txtCep, txtTelefone);

			if (camposPreenchidos){
		    	String nome = txtNomeCliente.getText();
		    	String cpf_cnpj = txtCpf.getText();
		    	String rua = txtRua.getText();
		    	int numero = Integer.parseInt(txtNumero.getText());
		    	String complemento = txtComplemento.getText();
		    	String bairro = txtBairro.getText();
		    	String cidade = txtCidade.getText();
		    	String estado = txtUf.getText();
		    	String cep = txtCep.getText();
		    	String telefone = txtTelefone.getText();
		    
		    	Cliente cliente = new Cliente(0, nome, cpf_cnpj, rua, numero, complemento, bairro, cidade, estado, cep, telefone);
		    	ClienteSQL clienteSQL = new ClienteSQL();
		    	clienteSQL.create(cliente);
			}
		} else {

		}

    }

    @FXML
    void executarClickBuscar(ActionEvent event) {

    }


    @FXML
    void executarClickEditar(ActionEvent event) {

    }

    @FXML
    void executarClickLimpar(ActionEvent event) {
    	txtNomeCliente.setText("");
    	txtCpf.setText("");
    	txtUf.setText("");
    	txtCidade.setText("");
    	txtBairro.setText("");
    	txtRua.setText("");
    	txtNumero.setText("");
    	txtComplemento.setText("");
    	txtCep.setText("");
    	txtTelefone.setText("");
    	
	}

}
