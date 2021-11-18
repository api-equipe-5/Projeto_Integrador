  
package control;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Aviso;
import model.GeradorDePDF;
import model.Logs;
import view.Avisos;
import view.Main;
import view.Registros;

public class ControlesPerfilAdminAvisos implements Initializable{

	public static boolean carregarInfos = false;
	
	@FXML
    private Label labelAvisos;
    @FXML
    private Pane paneVisualizarAvisos;
    @FXML
    private TableView<Avisos> tabelaAvisos;
    @FXML
    private TableColumn<?, ?> colunaTituloAviso;
    @FXML
    private TableColumn<?, ?> colunaRemetente;
    @FXML
    private TableColumn<?, ?> colunaDataAviso;
    @FXML
    private Button btSelecionarAviso;
    @FXML
    private TextField campoIDAviso;
    @FXML
    private TextField remetente;
    @FXML
    private CheckBox visualizado;
    @FXML
    private TextArea msg;
    @FXML
    private DatePicker dataDoAviso;
    @FXML
    private Pane paneAvisoSelecionado;
    @FXML
    private Pane paneSelecionarOpcao;
    @FXML
    private Pane paneVisualizarLogs;
    @FXML
    private TableView<Registros> tabelaLogs;
    @FXML
    private TableColumn<?, ?> colunaRegistroLog;
    @FXML
    private TableColumn<?, ?> colunaFuncionarioLog;
    @FXML
    private TableColumn<?, ?> colunaDataLog;
    @FXML
    private Button btSelecionarLog;
    @FXML
    private Pane paneLogSelecionado;
    @FXML
    private TextField campoIDlog;
    @FXML
    private TextArea msgLog;
    @FXML
    private DatePicker dataDoLog;
    @FXML
    private TextField responsavel;
    @FXML
    private TextField horario;
    @FXML
    private Label labelDicaFlutuante;
    @FXML
    private Pane paneGerarRelatorio;
    @FXML
    private TextField textFieldEscolherCaminho;
    @FXML
    private CheckBox checkBoxMotoristas;
    @FXML
    private CheckBox checkBoxSupervisores;
    @FXML
    private CheckBox checkBoxAdministradores;
    @FXML
    private CheckBox checkBoxFiliais;
    @FXML
    private CheckBox checkBoxVeiculos;
    @FXML
    private CheckBox checkBoxViagens;
    @FXML
    private RadioButton radioButton20;
    @FXML
    private ToggleGroup tempoDeRegistro;
    @FXML
    private RadioButton radioButton40;
    @FXML
    private RadioButton radioButton100;
    @FXML
    private RadioButton radioButtonDia;
    @FXML
    private RadioButton radioButtonSemana;
    @FXML
    private RadioButton radioButtonMes;
    @FXML
    private RadioButton radioButtonTudo;
    @FXML
    private RadioButton radioButtonNenhum;
    @FXML
    private Pane paneAvisosPrincipal;
    @FXML
    private Pane paneAvisosSombra;
    @FXML
    private Pane paneAvisosFalha;
    @FXML
    private Label labelAvisosTituloFalha;
    @FXML
    private Label labelAvisosTextoFalha;
    @FXML
    private Pane paneAvisosSucesso;
    @FXML
    private Label labelAvisosTituloSucesso;
    @FXML
    private Label labelAvisosTextoSucesso;
    @FXML
    private TextField textFieldNomeDoArquivo;

    

	private List<Avisos> listaAvisos = new ArrayList<>();
	private ObservableList<Avisos> obsListAvisos;
	
	private List<Registros> listaLogs = new ArrayList<>();
	private ObservableList<Registros> obsListLogs;
	
	private int idAviso;
	
	private int idLog;

	
	
	
	@FXML
	void escolherDiretorio(ActionEvent event) {
		String path = "";
		
		path = Main.escolherCaminho();
		
		if(path.equals("")) {
			notificar("Falha", "Falha ao escolher caminho", "Ocorreu um problema ao selecionar o caminho onde o arquivo será gerado, tente novamente");
		}else {
			textFieldEscolherCaminho.setText(path);
		}
	}
	
	@FXML
	void pedirConfirmacaoRelatorio(ActionEvent event) {
		if(!textFieldEscolherCaminho.getText().equals("") && !textFieldNomeDoArquivo.getText().equals("")) {
			
			notificar("Sucesso", "Criação de relatório: " + '"' + textFieldNomeDoArquivo.getText() + ".pdf" + '"', 
					  "Verifique as informações requisitadas e confirme a criação do relatório\n"
					+ "\nNome do arquivo: " + textFieldNomeDoArquivo.getText() + ".pdf"
					+ "\nEntidades requisitadas: " + entidadesRequisitadas()
					+ "\nPeríodo de registro de logs: " + periodoDeLog()
					+ "\n\nAo clicar em confirmar, o sistema irá gerar o relatório no local especifícado");
		}
	}
	
	@FXML
	void gerarRelatorio(ActionEvent event) {
		String path = textFieldEscolherCaminho.getText() + '\\' + textFieldNomeDoArquivo.getText() + ".pdf";
		
		String titulo = "RoadTracker\n"
				+ "Relatório de análise das informações do sistema\n\n\n";
		
		String especificacao = "Conteúdo solicitado\n"
						     + "    - Entidades: " + entidadesRequisitadas()
						     + "\n    - Período de registro de logs: " + periodoDeLog();
		
		GeradorDePDF pdf = new GeradorDePDF();
		pdf.gerarRelatorio(path, titulo, especificacao, entidadesRequisitadas(), periodoDeLog());
		
		
		fecharAviso(event);
	}
	
	private String periodoDeLog() {
		String periodo = "";
		
		if(radioButton20.isSelected()) {
			periodo = "Últimos 20";
		}else if(radioButton40.isSelected()) {
			periodo = "Últimos 40";
		}else if(radioButton100.isSelected()) {
			periodo = "Últimos 100";
		}else if(radioButtonDia.isSelected()) {
			periodo = "Último dia";
		}else if(radioButtonSemana.isSelected()) {
			periodo = "Última semana";
		}else if(radioButtonMes.isSelected()) {
			periodo = "Último mês";
		}else if(radioButtonTudo.isSelected()) {
			periodo = "Todos os registros";
		}else if(radioButtonNenhum.isSelected()) {
			periodo = "Não incluir registros";
		}
		
		return periodo;
		
	}
	
	private String entidadesRequisitadas() {
		String entidades = "";
		
		if(checkBoxAdministradores.isSelected()) {
			entidades += "Administradores, ";
		}
		if(checkBoxMotoristas.isSelected()) {
			entidades += "Motoristas, ";
		}
		if(checkBoxSupervisores.isSelected()) {
			entidades += "Supervisores, ";
		}
		if(checkBoxFiliais.isSelected()) {
			entidades += "Filiais, ";
		}
		if(checkBoxVeiculos.isSelected()) {
			entidades += "Veículos, ";
		}
		if(checkBoxViagens.isSelected()) {
			entidades += "Viagens, ";
		}
		
		if(!entidades.equals("")) {
			entidades = entidades.substring(0, entidades.length() - 2);
			return entidades;
		}else {
			return "Nenhuma";
		}
		

	}
	
	@FXML
	void abrirConfigurarRelatorio(MouseEvent event) {
		paneSelecionarOpcao.setVisible(false);
		paneSelecionarOpcao.setDisable(true);
		
		paneGerarRelatorio.setVisible(true);
		paneGerarRelatorio.setDisable(false);
		
	}
	
    @FXML
    void abrirTelaCadEnt(MouseEvent event) {
    	carregarInfos = true;
    	voltarAvisos();
    	
    	paneGerarRelatorio.setVisible(false);
    	paneGerarRelatorio.setDisable(true);
    	paneSelecionarOpcao.setDisable(false);
    	paneSelecionarOpcao.setVisible(true);
    	
    	Main.trocarTela("Tela Cadastrar Funcionarios");

    }
    
    @FXML
    void abrirTelaFunc(MouseEvent event) {
    	carregarInfos = true;
    	voltarAvisos();
    	
    	paneGerarRelatorio.setVisible(false);
    	paneGerarRelatorio.setDisable(true);
    	paneSelecionarOpcao.setDisable(false);
    	paneSelecionarOpcao.setVisible(true);
    	
    	Main.trocarTela("Tela Funcionarios");

    }
    
    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {
    	carregarInfos = true;
    	voltarAvisos();
    	
    	paneGerarRelatorio.setVisible(false);
    	paneGerarRelatorio.setDisable(true);
    	paneSelecionarOpcao.setDisable(false);
    	paneSelecionarOpcao.setVisible(true);
    	
    	Main.trocarTela("Tela Historico de Entregas");

    }
    
    @FXML
    void abrirTelaAvisos(MouseEvent event) {
   		paneAvisoSelecionado.setVisible(false);
   		paneAvisoSelecionado.setDisable(true);
		paneVisualizarAvisos.setDisable(true);
		paneVisualizarAvisos.setVisible(false);
		paneGerarRelatorio.setVisible(false);
		paneGerarRelatorio.setDisable(true);
		paneVisualizarLogs.setVisible(false);
		paneVisualizarLogs.setDisable(true);
		paneLogSelecionado.setVisible(false);
		paneLogSelecionado.setDisable(true);
		
		paneSelecionarOpcao.setDisable(false);
		paneSelecionarOpcao.setVisible(true);
		
    	carregarInfos = true;
    }
    
    @FXML
    void voltar(ActionEvent event) {
    	carregarInfos = true;
    	paneSelecionarOpcao.setVisible(true);
    	
    	if (paneAvisoSelecionado.isVisible()) {
			paneVisualizarAvisos.setDisable(false);
			paneAvisoSelecionado.setVisible(false);
			paneAvisoSelecionado.setDisable(true);
    	}
    	else if (paneLogSelecionado.isVisible()) {
    		paneLogSelecionado.setVisible(false);
    		paneLogSelecionado.setDisable(true);
			paneVisualizarLogs.setVisible(true);
			paneVisualizarLogs.setDisable(false);
    	}
    	else if (paneVisualizarAvisos.isVisible() || paneVisualizarLogs.isVisible()) {
        	paneSelecionarOpcao.setVisible(true);
        	paneSelecionarOpcao.setDisable(false);
        	paneVisualizarAvisos.setVisible(false);
        	paneVisualizarLogs.setVisible(false);
        	paneVisualizarLogs.setDisable(true);
        	paneVisualizarAvisos.setDisable(true);
    	}
    	else if(paneGerarRelatorio.isVisible()) {
    		paneSelecionarOpcao.setVisible(true);
    		paneSelecionarOpcao.setDisable(false);
    		paneGerarRelatorio.setVisible(false);
    		paneGerarRelatorio.setDisable(true);
    	}
    	else if (paneSelecionarOpcao.isVisible()) {
    		Main.trocarTela("Tela Boas Vindas");
    	}
    }
    
    @FXML
    void excluir(ActionEvent event) {
    	Aviso aviso = new Aviso().encontrarAviso(idAviso);
    	
    	Map<String, String> dicionarioAviso = aviso.dadosAviso();
    	
    	Logs log = new Logs();
    	log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Exclusão de aviso:"
    					+ "\nID: " + dicionarioAviso.get("ID")
    					+ "\nCódigo: " + dicionarioAviso.get("Código")
    					+ "\nData: " + dicionarioAviso.get("Data")
    					+ "\nAviso emitido pelo colaborador de CPF: " + dicionarioAviso.get("Emissor")
    					+ "\n\nMensagem do aviso:"
    					+ "\n" + '"' + dicionarioAviso.get("Mensagem") + '"');
    	
    	aviso.excluirAviso(Integer.parseInt(campoIDAviso.getText()));
    	
    	voltar(event);
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
    public void selecionarAviso(ActionEvent event) {
		Avisos selecionado = tabelaAvisos.getSelectionModel().getSelectedItem();
		idAviso = selecionado.getId();
		carregarInfoAviso();
		paneAvisoSelecionado.setDisable(false);
		paneAvisoSelecionado.setVisible(true);
		paneVisualizarAvisos.setDisable(true);
		paneVisualizarAvisos.setVisible(false);
		paneSelecionarOpcao.setVisible(false);
		paneSelecionarOpcao.setDisable(true);
		
    }
    
    @FXML
    void abrirTelaLogs(MouseEvent event) {
    	carregarTableViewsLogs();
    	paneSelecionarOpcao.setVisible(false);
    	paneSelecionarOpcao.setDisable(true);
    	paneVisualizarLogs.setVisible(true);
    	paneVisualizarLogs.setDisable(false);
    	
    }
    
    @FXML
    void abrirAvisos(MouseEvent event) {
		carregarInfos = true;
    	paneSelecionarOpcao.setVisible(false);
    	paneVisualizarAvisos.setVisible(true);
    	paneVisualizarAvisos.setDisable(false);
    	
    }
    @FXML
    void selecionarLog(ActionEvent event) {
		Registros logSelecionado = tabelaLogs.getSelectionModel().getSelectedItem();
		idLog = logSelecionado.getId();
		carregarInfoLog();
		paneLogSelecionado.setDisable(false);
		paneLogSelecionado.setVisible(true);
		paneVisualizarLogs.setDisable(true);
		paneVisualizarLogs.setVisible(false);
    }
    
    public void carregarInfoLog() {
    	Logs log = new Logs();
    	log = log.encontrarLog(idLog);
		
		campoIDlog.setText(String.valueOf(log.getId()));
		msgLog.setText(log.getRegistro());
		responsavel.setText(log.getCpfEmissor());
		horario.setText(log.getHorario());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate localDate = LocalDate.parse(log.getData(), formatter);
    	dataDoLog.setValue(localDate);
    }
    
    public void carregarInfoAviso() {
    	Aviso aviso = new Aviso();
    	aviso = aviso.encontrarAviso(idAviso);
		
		campoIDAviso.setText(String.valueOf(aviso.getId()));
		visualizado.setSelected(aviso.isResolvido());
		msg.setText(aviso.getMensagem());
		
		// Esse try é um remendo no código pois corrigir isso envolveria mudar muitas classes
		try {
			remetente.setText(aviso.getMotorista().getCpf());
		}
		catch(Exception erro) {
			remetente.setText(aviso.getEmissor());
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate localDate = LocalDate.parse(aviso.getData(), formatter);
    	dataDoAviso.setValue(localDate);
    }
    
    public void voltarAvisos() {
		paneAvisoSelecionado.setVisible(false);
		paneAvisoSelecionado.setDisable(true);
		paneVisualizarAvisos.setVisible(false);
		paneVisualizarAvisos.setDisable(true);
    	paneSelecionarOpcao.setVisible(true);
    	paneSelecionarOpcao.setDisable(false);
    	paneVisualizarLogs.setVisible(false);
    	paneVisualizarLogs.setDisable(true);
    	paneLogSelecionado.setDisable(true);
    	paneLogSelecionado.setVisible(false);
    	paneGerarRelatorio.setVisible(false);
    	paneGerarRelatorio.setDisable(true);
    }
    
	public void carregarTableViewsAvisos() {
		Aviso aviso = new Aviso();
		
		listaAvisos = aviso.listarAvisos();
		
		obsListAvisos = FXCollections.observableArrayList(listaAvisos);
		
		colunaTituloAviso.setCellValueFactory(new PropertyValueFactory<>("tituloAviso"));
		colunaDataAviso.setCellValueFactory(new PropertyValueFactory<>("dataAviso"));
		colunaRemetente.setCellValueFactory(new PropertyValueFactory<>("motorista"));
		
		tabelaAvisos.setItems(obsListAvisos);
	}
	
	public void carregarTableViewsLogs() {
		Logs logs = new Logs();
		
		listaLogs = logs.listarLogs();
		
		obsListLogs = FXCollections.observableArrayList(listaLogs);
		
		colunaRegistroLog.setCellValueFactory(new PropertyValueFactory<>("mensagem"));
		colunaDataLog.setCellValueFactory(new PropertyValueFactory<>("dia"));
		colunaFuncionarioLog.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		
		tabelaLogs.setItems(obsListLogs);
	}
    
	
	
	@FXML
	void esconderDicaFlutuante(MouseEvent event) {
		labelDicaFlutuante.setVisible(false);

	}

	@FXML
	void exibirDicaFlutuante(MouseEvent event) {
		if(event.getTarget().toString().contains("horario")) {
			labelDicaFlutuante.setText("Horário");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("responsavel")) {
			labelDicaFlutuante.setText("Emissor");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("campoIDlog")) {
			labelDicaFlutuante.setText("ID do registro");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("campoIDAviso")) {
			labelDicaFlutuante.setText("ID do registro");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("remetente")) {
			labelDicaFlutuante.setText("Emissor");
			labelDicaFlutuante.setVisible(true);
		}

		labelDicaFlutuante.setLayoutX(event.getSceneX());
		labelDicaFlutuante.setLayoutY(event.getSceneY());

	}
	
	void notificar(String tipoDeAviso, String titulo, String texto) {
		paneAvisosPrincipal.setDisable(false);
		paneAvisosPrincipal.setVisible(true);
		paneAvisosSombra.setVisible(true);
		paneAvisosSombra.setDisable(false);
		
		switch (tipoDeAviso) {
		case "Falha":
			paneAvisosFalha.setDisable(false);
			paneAvisosFalha.setVisible(true);
			labelAvisosTextoFalha.setText(texto);
			labelAvisosTituloFalha.setText(titulo);
			break;
		case "Sucesso":
			paneAvisosSucesso.setDisable(false);
			paneAvisosSucesso.setVisible(true);
			labelAvisosTextoSucesso.setText(texto);
			labelAvisosTituloSucesso.setText(titulo);
			break;
		}
	}
	
    @FXML
    void fecharAviso(ActionEvent event) {
		paneAvisosPrincipal.setDisable(true);
		paneAvisosPrincipal.setVisible(false);
		paneAvisosSombra.setVisible(false);
		paneAvisosSombra.setDisable(true);
		paneAvisosFalha.setDisable(true);
		paneAvisosFalha.setVisible(false);
    }
	
	
    void tarefasEmLoop() {
    	// Considere que cada if aqui dentro é uma "função"
    	
    	if(carregarInfos) {
    		carregarTableViewsAvisos();
    		carregarTableViewsLogs();
    		carregarInfos = false;
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
