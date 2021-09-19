package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Aviso;
import view.Main;

public class ControlesPerfilMotAvisos implements Initializable {

    @FXML
    private Label labelAvisos;

    @FXML
    private Pane paneCadastrarAviso;
    
    @FXML
    private Pane paneVisualizarAvisos;

    @FXML
    private TextArea addMsg;

    @FXML
    private CheckBox pneufurado;

    @FXML
    private CheckBox envTerceiros;

    @FXML
    private CheckBox resol;

    @FXML
    private CheckBox fProx;

    @FXML
    private TableView<?> tabelaAvisos;

    @FXML
    private TableColumn<?, ?> colunaTituloAviso;

    @FXML
    private TableColumn<?, ?> colunaFuncDestino;

    @FXML
    private TableColumn<?, ?> colunaDataAviso;

    @FXML
    private Button btSelecionarAviso;

    @FXML
    private TextField campoIDAviso;

    @FXML
    private TextArea msg;

    @FXML
    private DatePicker dataDoAviso;

    @FXML
    private TextField remetente;
    
    @FXML
    private Pane paneAvisosPrincipal;

    @FXML
    private Pane paneAvisosSombra;

    @FXML
    private Pane paneAvisosSucesso;

    @FXML
    private Label labelAvisosTituloSucesso;

    @FXML
    private Label labelAvisosTextoSucesso;

    @FXML
    private Pane paneAvisosFalha;

    @FXML
    private Label labelAvisosTituloFalha;

    @FXML
    private Label labelAvisosTextoFalha;


    @FXML
    void abrirCriarAviso(MouseEvent event) {
    	limparCampos();
    }

    @FXML
    void abrirMinhasViagens(MouseEvent event) {
    	Main.trocarTela("Mot Viagens");
    	limparCampos();
    }

    @FXML
    void abrirRealizarViagem(MouseEvent event) {
    	Main.trocarTela("Viagem Selecionada");
    	limparCampos();
    }

    @FXML
    public void confirmarAviso(ActionEvent event) {
    	Aviso aviso = new Aviso();
    	
    	String fil;
    	String re;
    	String pn;
    	String te;
    	
    	if (envTerceiros.isSelected()) {  te = "ECT"; }
    	else { te = "EST"; }
    	if (pneufurado.isSelected()) { pn = "PF"; }
    	else { pn = ""; }
    	if (resol.isSelected()) { re = "01"; }
    	else { re = "00"; }
    	if (fProx.isSelected()) { fil = "01"; }
    	else { fil = "00"; }
    	
    	String mensagem = addMsg.getText();
    	String motorista = ControlesLogin.cpfLogado;
    	boolean resolvido = resol.isSelected();
    	String nomenclatura = (String.valueOf(te) + String.valueOf(pn) + String.valueOf(fil) + String.valueOf(re));
    	boolean retorno = aviso.cadastrarAviso("todos", motorista, mensagem + "\n\n" + nomenclatura, nomenclatura, resolvido);
    	
    	if (retorno && !mensagem.isEmpty()) {
    		notificar("Sucesso", "Aviso enviado com sucesso!", "O aviso foi enviado a um dos funcionários da empresa.");
    		limparCampos();
    	}
    	else {
    		if(retorno) {
        		notificar("Falha", "Falha no envio do aviso.", "O aviso não pôde ser enviado. Tente novamente.");
    		}else if(mensagem.isEmpty()) {
        		notificar("Falha", "Falha no envio do aviso.", "Não é possível enviar sem uma mensagem, por favor descreva a situação e tente novamente");
    		}

    	}
    }

    @FXML
    void apagar(ActionEvent event) {
		limparCampos();
    }

    @FXML
    void fecharJanela(ActionEvent event) {
    	Main.trocarTela("Tela Login");
    } 


    @FXML
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }

    @FXML
    void voltar(ActionEvent event) {
    	Main.trocarTela("Viagem Selecionada");
    }
    
    @FXML
    void selecionarAviso(ActionEvent event) {

    }
	
	public void limparCampos() {
		addMsg.setText("");
		pneufurado.setSelected(false);
		envTerceiros.setSelected(false);
		fProx.setSelected(false);
		resol.setSelected(false);
	}
	
    void notificar(String tipoDeAviso, String titulo, String texto) {
    	paneAvisosPrincipal.setDisable(false);
    	paneAvisosPrincipal.setVisible(true);
    	paneAvisosSombra.setVisible(true);
    	paneAvisosSombra.setDisable(false);
    	switch(tipoDeAviso){
    		case "Sucesso":
    			paneAvisosSucesso.setDisable(false);
    			paneAvisosSucesso.setVisible(true);
    			labelAvisosTextoSucesso.setText(texto);
    			labelAvisosTituloSucesso.setText(titulo);
    			break;
    		case "Falha":
    			paneAvisosFalha.setDisable(false);
    			paneAvisosFalha.setVisible(true);
    			labelAvisosTextoFalha.setText(texto);
    			labelAvisosTituloFalha.setText(titulo);
    			break;
    	}
    }
    @FXML
    void fecharAviso(ActionEvent event){
    	paneAvisosPrincipal.setDisable(true);
    	paneAvisosPrincipal.setVisible(false);
    	paneAvisosSombra.setVisible(false);
    	paneAvisosSombra.setDisable(true);
		paneAvisosSucesso.setDisable(true);
		paneAvisosSucesso.setVisible(false);
		paneAvisosFalha.setDisable(true);
		paneAvisosFalha.setVisible(false);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
}
