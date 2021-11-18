package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import view.*;

public class ControlesPerfilAdminBoasVindas {

    @FXML
    void abrirTelaCadFunc(MouseEvent event) {
    	Main.trocarTela("Tela Cadastrar Funcionarios");
    }

    @FXML
    void abrirTelaFuncionarios(MouseEvent event) {
    	Main.trocarTela("Tela Funcionarios");
    }
    
	@FXML
	void abrirTelaAvisos(MouseEvent event) {
		Main.trocarTela("Tela Avisos");
	}

    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {
    	Main.trocarTela("Tela Historico de Entregas");
    }
    
    @FXML
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }

    @FXML
    void fecharJanela(ActionEvent event) {
    	Main.trocarTela("Tela Login");
    }

    @FXML
    void voltar(ActionEvent event) {
    	Main.trocarTela("Tela Login");
    }

}

