package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Motorista;
import model.Viagem;
import view.Main;
import view.Viagens;

public class ControlesPerfilMotViagens implements Initializable {
	
	public static boolean carregarTableView = false;
	public static boolean viagemEmAndamentoJaExistente = false;
    public List<Viagens> listaDeViagensMotorista = new ArrayList<>();

    @FXML
    private Pane paneMinhasViagens;
    @FXML
    private TableView<Viagens> tabelaViagens;
    @FXML
    private TableColumn<?, ?> colunaDestino;
    @FXML
    private TableColumn<?, ?> colunaCarga;
    @FXML
    private TableColumn<?, ?> colunaPrazo;
    @FXML
    private TableColumn<?, ?> colunaSituacao;
    @FXML
    private Pane paneViagemSelecionada;
    @FXML
    private Pane paneAvisosPrincipal;
    @FXML
    private Pane paneAvisosSombra;
    @FXML
    private Pane paneAvisosSucesso;
    @FXML
    private Pane paneAvisosFalha;
    @FXML
    private Label labelAvisosTextoSucesso;
    @FXML
    private Label labelAvisosTituloSucesso;
    @FXML
    private Label labelAvisosTextoFalha;
    @FXML
    private Label labelAvisosTituloFalha;
    @FXML
    void iniciaViagem(ActionEvent event) {
    	//Ao clicar em um botão com este evento, abre a tela da viagem atual.
    	Viagens selecionado = tabelaViagens.getSelectionModel().getSelectedItem();
    	Viagem viagem = new Viagem();
    	
    	viagem = viagem.encontrarViagem(selecionado.getId());
    	
    	listaDeViagensMotorista.forEach(item -> {
    		if(item.getSituacao().equals("Em andamento")) {
    			viagemEmAndamentoJaExistente = true;
    		}
    	});
    	if(!viagemEmAndamentoJaExistente) {
        	if(!viagem.getSituacao().equals("Finalizado")) {
            	viagem.atualizarSituacao("Em andamento");
            	viagem.iniciarViagem();
            	
            	carregarTableView = true;
            	ControlesPerfilMotViagemAtual.carregarViagem = true;
            	
            	notificar("Sucesso", "Atualização da situação da viagem", "A viagem foi iniciada com sucesso, verifique mais informações no menu de 'Jornada atual'");
        	}else {
        		notificar("Falha", "Falha na situação da viagem", "Essa viagem já foi finalizada");
        	}
    	}else {
    		notificar("Falha", "Falha na situação da viagem", "Já existe uma viagem em andamento");	
    	}

    	

    	
    }

    @FXML
    void pausaViagem(ActionEvent event) {
    	//Ao clicar em um botão com este evento, finaliza a viagem atual.
    	Viagens selecionado = tabelaViagens.getSelectionModel().getSelectedItem();
    	Viagem viagem = new Viagem();
    	
    	viagem = viagem.encontrarViagem(selecionado.getId());
    	
    	if(!(viagem.getSituacao().equals("Pausado") || viagem.getSituacao().equals("Finalizado"))) {
        	viagem.atualizarSituacao("Pausado");
        	
        	carregarTableView = true;
        	viagemEmAndamentoJaExistente = false;
        	ControlesPerfilMotViagemAtual.pausarViagem = true;
        	ControlesPerfilMotViagemAtual.carregarViagem = true;
        	
        	
        	notificar("Sucesso", "Atualização da situação da viagem", "A viagem foi pausada com sucesso");
    	}else {
    		notificar("Falha", "Falha na situação da viagem", "Essa viagem já foi finalizada/pausada");	
    	}

    }
    
    @FXML
    void abrirCriarAviso(MouseEvent event) {
    	Main.trocarTela("Criar Aviso");
    	//Ao clicar em um elemento com este evento, redireciona para a tela de criar aviso.
    }

    @FXML
    void abrirMinhasViagens(MouseEvent event) {
    	carregarTableView = true; //atualiza lista
    	//Ao clicar em um elemento com este evento, redireciona para a tela de minhas viagens.
    }

    @FXML
    void abrirRealizarViagem(MouseEvent event) {
    	Main.trocarTela("Viagem Selecionada");
    	//Ao clicar em um elemento com este evento, redireciona para a tela de realizar viagem.
    }
    @FXML
    void voltar(ActionEvent event) {
    	Main.trocarTela("Viagem Selecionada"); 
    }
    
	@FXML
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }
	
    @FXML
    void fecharJanela(ActionEvent event) {
    	Main.trocarTela("Tela Login");
    }
    
    

    void carregarInfoViagens () {
        List<Viagens> listaDeViagens = new ArrayList<>();
        ObservableList<Viagens> obsListViagens;
        listaDeViagensMotorista.clear();
        
    	Viagem viagem = new Viagem();
    	
    	listaDeViagens = viagem.listarViagens();
    	
    	
    	//Essa "coisa" abaixo é um 'for coisa in lista' embelezado do java
    	listaDeViagens.forEach(item -> {
    		if(item.getMotorista().getCpf().equals(ControlesLogin.cpfLogado)) {
    			listaDeViagensMotorista.add(item);
    			
    			if(item.getSituacao().equals("Atrasado")) {
    				new Motorista().encontrarMotorista(ControlesLogin.cpfLogado).incrementarMetadados("VgmAtr");
    			}
    		}
    	});
    		
    	
    	obsListViagens = FXCollections.observableArrayList(listaDeViagensMotorista);
    	
    	colunaCarga.setCellValueFactory(new PropertyValueFactory<>("carga"));
    	colunaDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
    	colunaSituacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));
    	colunaPrazo.setCellValueFactory(new PropertyValueFactory<>("prazo"));
    	
    	tabelaViagens.setItems(obsListViagens);
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

    
    void tarefasEmLoop() {
    	// Considere que cada if aqui dentro é uma "função"
    	
    	if(carregarTableView) {
    		carregarInfoViagens();
    		carregarTableView = false;
    	}
    	
    }
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Timer myTimer = new Timer();
		myTimer.schedule(new TimerTask(){


			@Override
			public void run() {
				Platform.runLater(() -> tarefasEmLoop());
			}
		}, 0, 1000);

	} 
}
