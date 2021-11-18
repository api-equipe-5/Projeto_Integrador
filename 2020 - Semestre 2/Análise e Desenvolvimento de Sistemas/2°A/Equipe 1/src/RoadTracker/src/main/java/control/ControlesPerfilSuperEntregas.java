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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Logs;
import model.Motorista;
import model.Veiculo;
import model.Viagem;
import view.Funcionarios;
import view.Main;
import view.Veiculos;
import view.Viagens;

public class ControlesPerfilSuperEntregas implements Initializable {

	Motorista motorista = new Motorista();
	Veiculo veiculo = new Veiculo();
	
	private String funcao = "";
	private boolean confirmado = false;
	
	public static boolean atualizarTableViewEComboBox = false;
	
    @FXML
    private Pane paneSelecionarViagem;
    @FXML
    private TextField campoDeBuscaEmpresaDestino;
    @FXML
    private TextField campoDeBuscaCpf;
    @FXML
    private Button botaoBuscar;
    @FXML
    private TextField campoDeBuscaMotorista;
    @FXML
    private TableView<Viagens> tabela;
    @FXML
    private TableColumn<?, ?> colunaId;
    @FXML
    private TableColumn<?, ?> colunaEmpresaDestino;
    @FXML
    private TableColumn<?, ?> colunaMotorista;
    @FXML
    private Pane paneViagemSelecionada;
    @FXML
    private Button botaoSalvar;
    @FXML
    private Button botaoDescartar;
    @FXML
    private TextField textFieldId;
    @FXML
    private TextField textFieldInicio;
    @FXML
    private TextField textFieldTotal;
    @FXML
    private DatePicker datePickerPrazo;
    @FXML
    private TextField textFieldDestino;
    @FXML
    private TextField textFieldCarga;
    @FXML
    private TextField textFieldSituacao;
    @FXML
    private ComboBox<Funcionarios> comboBoxMotorista;
    @FXML
    private ComboBox<Veiculos> comboBoxVeiculo;
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
    private Pane paneAvisosConfirmar;
    @FXML
    private Label labelAvisosTituloConfirmar;
    @FXML
    private Label labelAvisosTextoConfirmar;
    @FXML
    private PasswordField passwordFieldConfirmarSenha;
    @FXML
    private Label labelDicaFlutuante;
    private List<Viagens> listaDeViagens;
    private ObservableList<Viagens> obsListViagens;
    
    private int idViagem;
    
	private List<Funcionarios> listaDeMotoristas = new ArrayList<>();
	private ObservableList<Funcionarios> obsListMotorista;
	
	private List<Veiculos> listaDeVeiculos = new ArrayList<>();
	private ObservableList<Veiculos> obsListVeiculo;
	
	private List<Viagens> listaDeViagensPesquisa = new ArrayList<>();
	private ObservableList<Viagens> obsListViagensPesquisa;
    
    
    
    // Só estão os métodos das ações dos botões aqui, os outros como carregar tableview devem ser criados




    @FXML
    void esconderDicaFlutuante(MouseEvent event) {

    }

    @FXML
    void exibirDicaFlutuante(MouseEvent event) {

    }
    
	@FXML
	void requisitarAlteracao(ActionEvent event) {
		if(!comboBoxVeiculo.getSelectionModel().getSelectedItem().getPlaca().equals("Selecione um veículo...")) {
			funcao = "Veiculo";
			notificar("Confirmar", "Confirmar senha do usuário", "Por favor, confirme sua senha no campo abaixo para confirmar as alterações nos dados");	
		}else {
			System.out.println("Selecione um veículo!");
		}
	}
	
    
    @FXML
    private void salvarAlteracoes(ActionEvent event) {
    	if(confirmado) {
    	   	Viagem viagem = new Viagem().encontrarViagem(idViagem);
    	   	
    	   	Map<String, String> dicionarioViagem = viagem.dadosViagem();
        	
        	int dia = datePickerPrazo.getValue().getDayOfMonth();
        	int mes = datePickerPrazo.getValue().getMonthValue();
        	int ano = datePickerPrazo.getValue().getYear();
        	
        	String prazo;
        	
        	if(dia < 10) {
            	prazo = ("0" + String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano));
        	}else {
            	prazo = (String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano));
        	}
        	
        	viagem.alterarDadosViagem(prazo, textFieldDestino.getText(),
        							  comboBoxMotorista.getSelectionModel().getSelectedItem().getCpf(), 
        							  comboBoxVeiculo.getSelectionModel().getSelectedItem().getPlaca(), 
        							  textFieldCarga.getText(), Integer.parseInt(textFieldId.getText()));
        	
    		Logs log = new Logs();
    		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Alteração de dados de viagem:"
    				+ "\nDestino: " + dicionarioViagem.get("Destino") +" -> " + textFieldDestino.getText()
    				+ "\nCarga: " + dicionarioViagem.get("Carga") +" -> " + textFieldCarga.getText()
    				+ "\nPrazo: " + dicionarioViagem.get("Prazo") +" -> " + prazo
    				+ "\nMotorista responsável: " + dicionarioViagem.get("Motorista responsável") +" -> " + comboBoxMotorista.getSelectionModel().getSelectedItem().getNome()
    				+ "\nPlaca do veículo atribuído: " + dicionarioViagem.get("Placa do veículo atribuído") +" -> " + comboBoxVeiculo.getSelectionModel().getSelectedItem().getPlaca());
        	
        	
        	textFieldDestino.setDisable(false);
        	textFieldCarga.setDisable(false);
        	comboBoxMotorista.setDisable(false);
        	comboBoxVeiculo.setDisable(false);
        	datePickerPrazo.setDisable(false);
        	
        	notificar("Sucesso", "Dados alterados", "Os dados da viagem foram alterados com sucesso");
        	
        	desabilitarEdicao();
        	
    		atualizarTableViewEComboBox = false;
    	}
    	else {
    		notificar("Falha", "Senha de confirmação incorreta", "A senha de verificação estava incorreta, tente novamente");
    	}
 
    	confirmado = false;
    	funcao = "";
    }
    
    @FXML
    void descartarAlteracoes(ActionEvent event) {
    	carregarInfoViagem();
    	desabilitarEdicao();
    }

    @FXML
    void selecionarViagem(ActionEvent event) {
    	 carregarComboBoxs();
    	 
		Viagens selecionada = tabela.getSelectionModel().getSelectedItem();
		idViagem = selecionada.getId();

		carregarInfoViagem();
    }
    
    @SuppressWarnings("unlikely-arg-type")
	void carregarInfoViagem() {
       	paneSelecionarViagem.setVisible(false);
    	paneSelecionarViagem.setDisable(true);
    	paneViagemSelecionada.setVisible(true);
    	paneViagemSelecionada.setDisable(false);
    	
    	Viagem viagem = new Viagem();
    	viagem = viagem.encontrarViagem(idViagem);
    	
    	textFieldCarga.setText(viagem.getCarga());
    	textFieldDestino.setText(viagem.getDestino());
    	textFieldId.setText(String.valueOf(viagem.getId()));
    	textFieldInicio.setText(viagem.getInicio());
    	textFieldSituacao.setText(viagem.getSituacao());
    	textFieldTotal.setText(viagem.getSituacao());
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate localDate = LocalDate.parse(viagem.getFim(), formatter);
    	datePickerPrazo.setValue(localDate);
    	
    	comboBoxMotorista.getSelectionModel().selectFirst();
    	
    	int seguranca = 0;
    	// O while abaixo pode ser um pouco confuso, mas basicamente ele verifica se o que está selecionado na combobox é igual ao funcionário da viagem
    	while(!viagem.getMotorista().getNome().equals(comboBoxMotorista.getSelectionModel().getSelectedItem().getNome())) {
    		comboBoxMotorista.getSelectionModel().selectNext();
    		seguranca++;
    		if(seguranca > 100) {
    			break;
    		}
    	}
    	
    	
    	
    	//Esse aqui ta meio bugado, esse não é a forma correta de fazer, mas da forma correta não funciona :/
    	String placa = viagem.getVeiculo().getPlaca();
    	Veiculos placaSelecionada = comboBoxVeiculo.getSelectionModel().getSelectedItem();
    	
    	int seguranca1 = 0;
    	// O while abaixo pode ser um pouco confuso, mas basicamente ele verifica se o que está selecionado na combobox é igual ao veiculo da viagem  	
    	while(!placa.equals(placaSelecionada)) {
    		comboBoxVeiculo.getSelectionModel().selectNext();
    		seguranca1++;
    		if(seguranca1 > 100) {
    			break;
    		}
    	}
    }
    
    
    
	@FXML
	void pesquisarViagens(ActionEvent event) {
		if(!campoDeBuscaMotorista.getText().isEmpty() || !campoDeBuscaEmpresaDestino.getText().isEmpty()){
			
			String empresaRequisitado = campoDeBuscaEmpresaDestino.getText().toLowerCase();
			String motoristaRequisitado = campoDeBuscaMotorista.getText().toLowerCase();
 
			// Caso não existe nada no campo pesquisado, ele retorna "", uma string vazia, porém "" existe em todas as strings
			//então é necessário criar um pequeno filtro para ele não retornar pesquisas incorretas e pesquisar de acordo com os campos preenchidos
			listaDeViagens.forEach(viagem -> {
				boolean empresa = false;
				boolean motorista = false;
				boolean tudo = false;

				// Nessa parte ele checa se está utilizando todos os campos de pesquisa ou somente alguns
				if(!campoDeBuscaEmpresaDestino.getText().isEmpty() && !campoDeBuscaMotorista.getText().isEmpty()) {
					tudo = true;
				}else {
					if(!campoDeBuscaEmpresaDestino.getText().isEmpty()) {
						empresa = true;
					}
					if(!campoDeBuscaMotorista.getText().isEmpty()) {
						motorista = true;
					}
				}

				// Aqui ele faz definitivamente a pesquisa, de acordo com estar utilizando todos os campos ou não
				if(tudo && viagem.getDestino().toLowerCase().contains(empresaRequisitado) && viagem.getNomeMotorista().contains(motoristaRequisitado)) {
					listaDeViagensPesquisa.add(viagem);
				}else if(empresa && viagem.getDestino().toLowerCase().contains(empresaRequisitado)) {
					listaDeViagensPesquisa.add(viagem);
				}else if(motorista && viagem.getNomeMotorista().toLowerCase().contains(motoristaRequisitado)) {
					listaDeViagensPesquisa.add(viagem);
				}
			});

			obsListViagensPesquisa = FXCollections.observableArrayList(listaDeViagensPesquisa);

			tabela.setItems(obsListViagensPesquisa);

			// Limpa as listas para não acumular com a próxima pesquisa
			listaDeViagensPesquisa.clear();
		}else {
			// Se não houver nada escrito nos campos, reseta a tabela mostrando todo o conteúdo
			tabela.setItems(obsListViagens);
		}
	}
    
    
    
    @FXML
    void abrirTelaAvisos(MouseEvent event) {
    	carregarTableView();
    	
		paneViagemSelecionada.setVisible(false);
		paneViagemSelecionada.setDisable(true);
		
		paneSelecionarViagem.setVisible(true);
		paneSelecionarViagem.setDisable(false);
		
		ControlesPerfilSuperAvisos.atualizarInfos = true;
		Main.trocarTela("Tela Supervisor Avisos");
		
    }

    @FXML
    void abrirTelaMotoristas(MouseEvent event) {
    	carregarTableView();
    	
		paneViagemSelecionada.setVisible(false);
		paneViagemSelecionada.setDisable(true);
		
		paneSelecionarViagem.setVisible(true);
		paneSelecionarViagem.setDisable(false);
		
    	Main.trocarTela("Tela Inicial Supervisor");
    	
    }

    void desabilitarEdicao() {
    	datePickerPrazo.setDisable(true);
    	textFieldDestino.setDisable(true);
    	textFieldCarga.setDisable(true);
    	comboBoxMotorista.setDisable(true);
    	comboBoxVeiculo.setDisable(true);
    	botaoSalvar.setDisable(true);
    	botaoDescartar.setDisable(true);
    	
    }
    
    @FXML
    void habilitarEdicao(ActionEvent event) {
    	datePickerPrazo.setDisable(false);
    	textFieldDestino.setDisable(false);
    	textFieldCarga.setDisable(false);
    	comboBoxMotorista.setDisable(false);
    	comboBoxVeiculo.setDisable(false);
    	botaoSalvar.setDisable(false);
    	botaoDescartar.setDisable(false);
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
    	carregarTableView();
    	carregarComboBoxs();
    	desabilitarEdicao();
    	if(paneViagemSelecionada.isVisible()) {
    		paneViagemSelecionada.setVisible(false);
    		paneViagemSelecionada.setDisable(true);
    		
    		paneSelecionarViagem.setVisible(true);
    		paneSelecionarViagem.setDisable(false);
    	}else {
    		Main.trocarTela("Tela Inicial Supervisor");
    	}
    	
    }

    private void carregarTableView(){
    	Viagem viagem = new Viagem();
    	
    	listaDeViagens = viagem.listarViagens();
    	
    	obsListViagens = FXCollections.observableArrayList(listaDeViagens);
    	
    	
    	colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	colunaEmpresaDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
    	colunaMotorista.setCellValueFactory(new PropertyValueFactory<>("nomeMotorista"));
    	
    	tabela.setItems(obsListViagens);
    }
    private void carregarComboBoxs() {
    	listaDeMotoristas = motorista.listarMotoristas();
    	obsListMotorista = FXCollections.observableArrayList(listaDeMotoristas);
		comboBoxMotorista.setItems(obsListMotorista);

    	listaDeVeiculos = veiculo.listarVeiculos();
    	listaDeVeiculos.add(0, new Veiculos(0, "Selecione um veículo..."));
    	obsListVeiculo = FXCollections.observableArrayList(listaDeVeiculos);
		comboBoxVeiculo.setItems(obsListVeiculo);

    }
    
    
    
	@FXML
	void confirmarAlteracao(ActionEvent event) {
		if(paneAvisosConfirmar.isVisible()) {
			if(passwordFieldConfirmarSenha.getText().equals(ControlesLogin.senha)) {
				confirmado = true;
			}else {
				confirmado = false;
			}
		}		
		
		fecharAviso(event);	
		switch(funcao) {
			case "Veiculo":
				salvarAlteracoes(event);
				break;
		}
			
	}
    
	void notificar(String tipoDeAviso, String titulo, String texto) {
		paneAvisosPrincipal.setDisable(false);
		paneAvisosPrincipal.setVisible(true);
		paneAvisosSombra.setVisible(true);
		paneAvisosSombra.setDisable(false);
		switch (tipoDeAviso) {
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
		case "Confirmar":
			paneAvisosConfirmar.setDisable(false);
			paneAvisosConfirmar.setVisible(true);
			labelAvisosTextoConfirmar.setText(texto);
			labelAvisosTituloConfirmar.setText(titulo);
			passwordFieldConfirmarSenha.setText("");
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
		paneAvisosConfirmar.setDisable(true);
		paneAvisosConfirmar.setVisible(false);
    }
    
    void tarefasEmLoop() {
    	// Considere que cada if aqui dentro é uma "função"
    	
    	if(atualizarTableViewEComboBox) {
    		carregarTableView();
    		carregarComboBoxs();
    		atualizarTableViewEComboBox = false;
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
