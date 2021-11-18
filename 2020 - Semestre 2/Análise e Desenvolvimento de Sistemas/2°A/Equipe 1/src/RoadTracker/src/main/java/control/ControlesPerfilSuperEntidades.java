package control;

import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Aviso;
import model.Filial;
import model.Funcionario;
import model.Logs;
import model.Motorista;
import model.Veiculo;
import model.Viagem;
import view.Filiais;
import view.Funcionarios;
import view.Main;
import view.Turnos;
import view.Veiculos;
import view.Viagens;

public class ControlesPerfilSuperEntidades implements Initializable{


	public static boolean atualizarTableViewEComboBox = false;
	
	@FXML
	private Pane paneMotoristaSelecionado;
	@FXML
	private VBox boxInfoExtraMotorista2;
	@FXML
	private TextField tfCargaHoraria;
	@FXML
	private CheckBox cbDom;
	@FXML
	private CheckBox cbSeg;
	@FXML
	private CheckBox cbTer;
	@FXML
	private CheckBox cbQua;
	@FXML
	private CheckBox cbQui;
	@FXML
	private CheckBox cbSex;
	@FXML
	private CheckBox cbSab;
	@FXML
	private Button btnSalvar;
	@FXML
	private Button btnDescartar;
	@FXML
	private Label lblNome;
	@FXML
	private ComboBox<?> cbCargo;
	@FXML
	private ComboBox<Filiais> cbFilial;
	@FXML
	private VBox boxInfoExtraMotorista1;
	@FXML
	private ComboBox<Turnos> cbTurno;
	@FXML
	private TextField textFieldSalarioMotorista;
	@FXML
	private TextField tfNome;
	@FXML
	private TextField tfCpf;
	@FXML
	private TextField textFieldEmail;
	@FXML
	private PasswordField pfSenha;
	@FXML
	private Label labelSituacaoMotorista;
	@FXML
	private Pane paneCadastrarMotorista;
	@FXML
	private ComboBox<Filiais> comboBoxCadastroFilial;
	@FXML
	private Pane paneInfosExtrasMotorista;
	@FXML
	private CheckBox checkBoxDomingo;
	@FXML
	private CheckBox checkBoxSegunda;
	@FXML
	private CheckBox checkBoxTerca;
	@FXML
	private CheckBox checkBoxQuarta;
	@FXML
	private CheckBox checkBoxQuinta;
	@FXML
	private CheckBox checkBoxSexta;
	@FXML
	private CheckBox checkBoxSabado;
	@FXML
	private ComboBox<Turnos> comboBoxCadastroTurno;
	@FXML
	private TextField textFieldCadastroCargaHoraria;
	@FXML
	private TextField textFieldCadastroSalario;
	@FXML
	private TextField textFieldCadastroNome;
	@FXML
	private TextField textFieldCadastroCpf;
	@FXML
	private TextField textFieldCadastroEmail;
	@FXML
	private PasswordField textFieldCadastroSenha;
	@FXML
	private PasswordField textFieldCadastroConfirmarSenha;
	@FXML
	private Pane paneMotoristas;
	@FXML
	private Button btSelecionarFuncionario;
	@FXML
	private Button botaoBuscar;
	@FXML
	private TableView<Funcionarios> tabelaFuncionarios;
	@FXML
	private TableColumn<?, ?> colunaNome;
	@FXML
	private TableColumn<?, ?> colunaCpf;
	@FXML
	private TableColumn<?, ?> colunaCargo;
	@FXML
	private TextField campoDeBuscaNome;
	@FXML
	private TextField campoDeBuscaCpf;
	@FXML
	private Pane paneSelecionarOpcao;
	@FXML
	private Label labelDicaFlutuante;
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
	private Pane paneVeiculos;
	@FXML
	private TableView<Veiculos> tabelaVeiculos;
	@FXML
	private TableColumn<?, ?> colunaPlaca;
	@FXML
	private TableColumn<?, ?> colunaIDVeiculo;
	@FXML
	private TextField campoDeBuscaVeiculo;
	@FXML
	private TextField campoDeBuscaIDVeiculo;
	@FXML
	private Pane paneVeiculoSelecionado;
	@FXML
	private TextField textFieldMarcaRastreador;
	@FXML
	private TextField textFieldModeloRastreador;
	@FXML
	private TextField textFieldIDRastreador;
	@FXML
	private TextField textFieldModeloVeiculo;
	@FXML
	private Button botaoSalvarAlteracoesVeiculo;
	@FXML
	private Button botaoDescartarAlteracoesVeiculo;
	@FXML
	private TextField textFieldPlacaVeiculo;
	@FXML
	private ComboBox<Filiais> comboBoxFilialVeiculo;
	
	private String cpfMotorista;

	private List<Turnos> turnos = new ArrayList<>();
	private ObservableList<Turnos> turnosList;
	private Turnos t = new Turnos(0, null);


	private List<Filiais> filiais = new ArrayList<>();
	private ObservableList<Filiais> filiaisList;
	private static Filial filial = new Filial();

	public List<Viagens> listaDeViagensMotorista = new ArrayList<>();

	private boolean confirmado = false;
	private String funcao;

	private List<Funcionarios> listaDeMotoristas = new ArrayList<>();
	private ObservableList<Funcionarios> obsListMotoristas;

	private List<Funcionarios> listaDeFuncionariosPesquisa = new ArrayList<>();
	private ObservableList<Funcionarios> obsListFuncionariosPesquisa;

	private List<TextField> textfieldsDeCpf = new ArrayList<TextField>();
	
	private String placaVeiculo;
	
	private List<Veiculos> listaDeVeiculos = new ArrayList<>();
	private ObservableList<Veiculos> obsListVeiculos;
	
	private List<Veiculos> listaDeVeiculosPesquisa = new ArrayList<>();
	private ObservableList<Veiculos> obsListVeiculosPesquisa;
	
	private List<TextField> textfieldsDePlacas = new ArrayList<TextField>();
	
	String caracteresValidos = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvXxWwYyZz-0123456789";
	String caracteresMaiusculosValidos = "ABCDEFGHIJKLMNOPQRSTUVXWYZ";
	String numerosValidos = "0123456789";
	char listaCaracteresValidos[] = caracteresValidos.toCharArray();
	char listaCaracteresMaiusculosValidos[] = caracteresMaiusculosValidos.toCharArray();
	

	public void carregarComboBoxTurnos() {
		turnos = t.listarTurnos();
		turnosList = FXCollections.observableArrayList(turnos);
		cbTurno.setItems(turnosList);
		comboBoxCadastroTurno.setItems(turnosList);
	}

	public void carregarComboBoxFiliais() {
		filiais = filial.listarFiliais();
		filiaisList = FXCollections.observableArrayList(filiais);
		cbFilial.setItems(filiaisList);
		comboBoxCadastroFilial.setItems(filiaisList);

	}

	public void carregarComboBox() {
		filiais = filial.listarFiliais();
		filiaisList = FXCollections.observableArrayList(filiais);
		cbFilial.setItems(filiaisList);
		comboBoxFilialVeiculo.setItems(filiaisList);
	}

	@FXML
	void descartarAlteracoes(ActionEvent event) {
		carregarInfosMotorista();
		desabilitarEdicao();
	}

	@FXML
	void esconderDicaFlutuante(MouseEvent event) {
		labelDicaFlutuante.setVisible(false);

	}

	@FXML
	void exibirDicaFlutuante(MouseEvent event) {
		if(event.getTarget().toString().contains("tfNome")) {
			labelDicaFlutuante.setText("Nome");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("tfCpf")) {
			labelDicaFlutuante.setText("CPF");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldEmail")) {
			labelDicaFlutuante.setText("Email");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("pfSenha")) {
			labelDicaFlutuante.setText("Senha");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("cbCargo")) {
			labelDicaFlutuante.setText("Cargo");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("cbFilial")) {
			labelDicaFlutuante.setText("Filial");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("cbTurno")) {
			labelDicaFlutuante.setText("Turno");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldSalarioMotorista")) {
			labelDicaFlutuante.setText("Motorista");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("tfCargaHoraria")) {
			labelDicaFlutuante.setText("Carga horária");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldCadastroNome")) {
			labelDicaFlutuante.setText("Nome");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldCadastroCpf")) {
			labelDicaFlutuante.setText("CPF");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldCadastroEmail")) {
			labelDicaFlutuante.setText("Email");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldCadastroSenha")) {
			labelDicaFlutuante.setText("Senha");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldCadastroConfirmarSenha")) {
			labelDicaFlutuante.setText("Confirmar senha");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("comboBoxCadastroFilial")) {
			labelDicaFlutuante.setText("Filial");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("comboBoxCadastroTurno")) {
			labelDicaFlutuante.setText("Turno");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldCadastroCargaHoraria")) {
			labelDicaFlutuante.setText("Carga horária");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldCadastroSalario")) {
			labelDicaFlutuante.setText("Salário");
			labelDicaFlutuante.setVisible(true);
		}

		labelDicaFlutuante.setLayoutX(event.getSceneX());
		labelDicaFlutuante.setLayoutY(event.getSceneY());

	}



	@FXML
	void selecionarFuncionario(ActionEvent event) {
		Funcionarios selecionado = tabelaFuncionarios.getSelectionModel().getSelectedItem();

		cpfMotorista = selecionado.getCpf();

		paneMotoristas.setVisible(false);
		paneMotoristas.setDisable(true);
		paneMotoristaSelecionado.setVisible(true);
		paneMotoristaSelecionado.setDisable(false);


		desabilitarEdicao();
		carregarComboBoxTurnos();
		carregarComboBoxFiliais();
		carregarInfosMotorista();
	}

	void carregarInfosMotorista() {
		Motorista motorista = new Motorista().encontrarMotorista(cpfMotorista);

		tfNome.setText(motorista.getNome());
		tfCpf.setText(motorista.getCpf());
		textFieldEmail.setText(motorista.getEmail());
		pfSenha.setText(motorista.getSenha());
		textFieldSalarioMotorista.setText(motorista.getSalario());
		tfCargaHoraria.setText(motorista.getCargaHoraria());

		cbDom.setSelected(motorista.getDom());
		cbSeg.setSelected(motorista.getSeg());
		cbTer.setSelected(motorista.getTer());
		cbQua.setSelected(motorista.getQua());
		cbQui.setSelected(motorista.getQui());
		cbSex.setSelected(motorista.getSex());
		cbSab.setSelected(motorista.getSab());

	   	int seguranca = 0;
	   	cbFilial.getSelectionModel().selectFirst();
    	// O while abaixo pode ser um pouco confuso, mas basicamente ele verifica se o que está selecionado na combobox é igual ao funcionário da viagem
    	while(!motorista.getFilial().getNome().equals(cbFilial.getSelectionModel().getSelectedItem().getNome())) {
    		cbFilial.getSelectionModel().selectNext();
    		seguranca++;
    		if(seguranca > 100) {
    			break;
    		}
    	}
		
		if (motorista.getTurno().equals("Matutino")) {
			cbTurno.getSelectionModel().select(0);
		} else if (motorista.getTurno().equals("Vespertino")) {
			cbTurno.getSelectionModel().select(1);
		} else {
			cbTurno.getSelectionModel().select(2);
		}


		List<Viagens> listaDeViagens = new ArrayList<>();
		listaDeViagensMotorista.clear();

		Viagem viagem = new Viagem();

		listaDeViagens = viagem.listarViagens();


		labelSituacaoMotorista.setText("Situação: Parado");
		//Essa "coisa" abaixo é um 'for coisa in lista' embelezado do java
		listaDeViagens.forEach(item -> {
			if(item.getMotorista().getCpf().equals(ControlesLogin.cpfLogado)) {
				if(item.getSituacao().equals("Em andamento")) {
					labelSituacaoMotorista.setText("Situação: Em viagem");
				}
			}
		});

	}

	@FXML
	void solicitarCadastro(ActionEvent event) {
		Aviso aviso = new Aviso();

		String solicitacao = "";

		String nome = textFieldCadastroNome.getText();
		String cpf = textFieldCadastroCpf.getText();
		String email = textFieldCadastroEmail.getText();
		String senha = textFieldCadastroSenha.getText();
		String cargaHoraria = textFieldCadastroCargaHoraria.getText();
		String salario = textFieldCadastroSalario.getText();

		int idFilial = comboBoxCadastroFilial.getValue().getId();
		String nomeFilial = new Filial().encontrarFilial(idFilial).getNome();
		String turno = comboBoxCadastroTurno.getValue().getTurno();

		boolean dom = checkBoxDomingo.isSelected();
		boolean seg = checkBoxSegunda.isSelected();
		boolean ter = checkBoxTerca.isSelected();
		boolean qua = checkBoxQuarta.isSelected();
		boolean qui = checkBoxQuinta.isSelected();
		boolean sex = checkBoxSexta.isSelected();
		boolean sab = checkBoxSabado.isSelected();
		String diasDeTrabalho = "";

		if(dom) {
			diasDeTrabalho += "Domingo";
		}
		if(seg) {
			diasDeTrabalho += ", Segunda-Feira";
		}
		if(ter) {
			diasDeTrabalho += ", Terça-Feira";
		}
		if(qua) {
			diasDeTrabalho += ", Quarta-Feira";
		}
		if(qui) {
			diasDeTrabalho += ", Quinta-Feira";
		}
		if(sex) {
			diasDeTrabalho += ", Sexta-Feira";
		}
		if(sab) {
			diasDeTrabalho += " e Sábado";
		}
		if(!dom) {
			diasDeTrabalho = diasDeTrabalho.substring(2); // Tira ", " caso não trabalhe domingo
		}

		solicitacao = "Solicito o cadastro do motorista com as seguintes informações:\n"
				+ "Nome: " + nome + "\n"
				+ "CPF: " + cpf + "\n"
				+ "E-mail: " + email + "\n"
				+ "Senha: " + senha + "\n"
				+ "Carga Horária: " + cargaHoraria + "\n"
				+ "Salário: " + salario + "\n"
				+ "Turno: " + turno + "\n"
				+ "Dias de trabalho: " + diasDeTrabalho + "\n"
				+ "Pertencendo a Filial " + nomeFilial + ", de ID igual a: " + String.valueOf(idFilial);
		
		new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("MotCad");
		
		boolean retorno = aviso.solicitarCadastro(ControlesLogin.cpfLogado, solicitacao);
		if (retorno) {
			notificar("Sucesso", "Sucesso!", "O cadastro foi solicitado com sucesso.");
			limparCampos();
		}
		else {
			notificar("Falha", "Falha", "O cadastro não pôde ser solicitado. Tente novamente.");
		}
	}

	@FXML
	void requisitarAlteracaoFuncionario(ActionEvent event) {
		funcao = "Funcionario";
		notificar("Confirmar", "Confirmar senha do usuário", "Por favor, confirme sua senha no campo abaixo para confirmar as alterações nos dados");
	}
	@FXML
	void alterarDados(ActionEvent event) {
		Motorista motorista = new Motorista().encontrarMotorista(cpfMotorista);
		if(confirmado) {
			
			String salario = textFieldSalarioMotorista.getText();
    		// verificando se o usuário digitou um salário float com vírgula ou com ponto
    		for (int i = 0; i < salario.length(); i++) {
    			char caracter = salario.charAt(i);
    			if (caracter == ',') { // se for vírgula troca, pois o java só entende ponto
    				salario = salario.replace(',', '.');
    			}
    		}
    		
			if (Float.parseFloat(salario) < 1701.38) {
				notificar("Falha", "Salário baixo", "O salário digitado é muito baixo. Escreva um salário válido.");
			}
			else if (Integer.parseInt(tfCargaHoraria.getText()) > 12) {
				notificar("Falha", "Carga horária", "A carga horária diária previamente acordada pode ser no máximo de 12 horas. Verifique o valor e tente novamente.");
			}
			else if (pfSenha.getText().isEmpty() || textFieldEmail.getText().isBlank()) {
				notificar("Falha", "Campo vazio", "A senha e o e-mail não podem ficar vazios. Preencha os campos.");
			}
			else {
				Map<String, String> dicionarioMotorista = motorista.dadosMotorista();
				
				motorista.alterarDadosMotorista(motorista.getCpf(), tfNome.getText(), 
						textFieldEmail.getText(), pfSenha.getText(), 
						textFieldSalarioMotorista.getText(), tfCargaHoraria.getText(), 
						cbFilial.getValue().getId(), cbTurno.getValue().getTurno(),
						cbSeg.isSelected(), cbTer.isSelected(), cbQua.isSelected(), cbQui.isSelected(), cbSex.isSelected(), cbSab.isSelected(), cbDom.isSelected());

				
				String diasDeTrabalho = "";

				if(cbDom.isSelected()) {
					diasDeTrabalho += "Domingo";
				}
				if(cbSeg.isSelected()) {
					diasDeTrabalho += ", Segunda-Feira";
				}
				if(cbTer.isSelected()) {
					diasDeTrabalho += ", Terça-Feira";
				}
				if(cbQua.isSelected()) {
					diasDeTrabalho += ", Quarta-Feira";
				}
				if(cbQui.isSelected()) {
					diasDeTrabalho += ", Quinta-Feira";
				}
				if(cbSex.isSelected()) {
					diasDeTrabalho += ", Sexta-Feira";
				}
				if(cbSab.isSelected()) {
					diasDeTrabalho += " e Sábado";
				}
				if(!cbDom.isSelected()) {
					diasDeTrabalho = diasDeTrabalho.substring(2); // Tira ", " caso não trabalhe domingo
				}
				
				
	    		Logs log = new Logs();
	    		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Alteração de dados de motorista:" 
	    				+ "\nNome: " + dicionarioMotorista.get("Nome") + " -> " + tfNome.getText()
	    				+ "\nCPF: " + dicionarioMotorista.get("CPF") + " -> " +  motorista.getCpf()
	    				+ "\nE-mail: " + dicionarioMotorista.get("E-mail") + " -> " +  textFieldEmail.getText()
	    				+ "\nFilial: " + dicionarioMotorista.get("Filial") + " -> " +  cbFilial.getSelectionModel().getSelectedItem().getNome()
	    				+ "\nSalário: R$ " + dicionarioMotorista.get("Salario") + " -> " + "R$ " + textFieldSalarioMotorista.getText()
	    				+ "\nCarga Horária: " +  dicionarioMotorista.get("Carga Horaria") + " -> " + tfCargaHoraria.getText()
	    				+ "\nDias de trabalho: " + dicionarioMotorista.get("Dias de trabalho") + " -> " +  diasDeTrabalho);
				
	    		new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("MotAlt");
				
				
				notificar("Sucesso", "Alteração de dados",
						"Os dados do funcionário " + tfNome.getText() + " foram alterados no banco de dados com sucesso");
				atualizarTableViewEComboBox = true;
			}
		}
		else {
			notificar("Falha", "Senha de confirmação incorreta", "A senha de verificação estava incorreta, tente novamente");
		}
		confirmado = false;
		funcao = "";
	}
	
	
	@FXML
	public void mascararCpf(KeyEvent event) {
		String caracter = event.getCharacter();
		
		textfieldsDeCpf.forEach(textfield -> {
			if(event.getSource().equals(textfield)) {
				String texto = textfield.getText();

				// Verifica se é um número e se for, aplica a máscara de CPF, porém, caso não seja, não permite a adição do caracter
				if(caracter.equals("1") || caracter.equals("2") || caracter.equals("3") || caracter.equals("4") ||
						caracter.equals("5") || caracter.equals("6") || caracter.equals("7") || caracter.equals("8") ||
						caracter.equals("9") || caracter.equals("0")){

					if(texto.length() == 3 || texto.length() == 7) {
						texto = texto + ".";
					}else if(texto.length() == 11) {
						texto = texto + "-";
					}

				}else if(texto.length() > 1){
					texto = texto.substring(0, texto.length() - 1);
				}
				
				if(texto.length() > 14) {
					texto = texto.substring(0, 14);
				}

				textfield.setText(texto);
				textfield.end();
			}
		});
		
	}
	
	
	@FXML
	void pesquisarFuncionarios(ActionEvent event) {
		if(!campoDeBuscaCpf.getText().isEmpty() || !campoDeBuscaNome.getText().isEmpty()){
			
			String nomeRequisitado = campoDeBuscaNome.getText().toLowerCase();
			String cpfRequisitado = campoDeBuscaCpf.getText();
 
			// Caso não existe nada no campo pesquisado, ele retorna "", uma string vazia, porém "" existe em todas as strings
			//então é necessário criar um pequeno filtro para ele não retornar pesquisas incorretas e pesquisar de acordo com os campos preenchidos
			listaDeMotoristas.forEach(funcionario -> {
				boolean cpf = false;
				boolean nome = false;
				boolean tudo = false;

				// Nessa parte ele checa se está utilizando todos os campos de pesquisa ou somente alguns
				if(!campoDeBuscaCpf.getText().isEmpty() && !campoDeBuscaNome.getText().isEmpty()) {
					tudo = true;
				}else {
					if(!campoDeBuscaCpf.getText().isEmpty()) {
						cpf = true;
					}
					if(!campoDeBuscaNome.getText().isEmpty()) {
						nome = true;
					}
				}

				// Aqui ele faz definitivamente a pesquisa, de acordo com estar utilizando todos os campos ou não
				if(tudo && funcionario.getNome().toLowerCase().contains(nomeRequisitado) && funcionario.getCpf().contains(cpfRequisitado)) {
					listaDeFuncionariosPesquisa.add(funcionario);
				}else if(cpf && funcionario.getCpf().contains(cpfRequisitado)) {
					listaDeFuncionariosPesquisa.add(funcionario);
				}else if(nome && funcionario.getNome().toLowerCase().contains(nomeRequisitado)) {
					listaDeFuncionariosPesquisa.add(funcionario);
				}
			});

			obsListFuncionariosPesquisa = FXCollections.observableArrayList(listaDeFuncionariosPesquisa);

			tabelaFuncionarios.setItems(obsListFuncionariosPesquisa);

			// Limpa as listas para não acumular com a próxima pesquisa
			listaDeFuncionariosPesquisa.clear();
		}else {
			// Se não houver nada escrito nos campos, reseta a tabela mostrando todo o conteúdo
			tabelaFuncionarios.setItems(obsListMotoristas);
		}
	}
	
	@FXML
	void requisitarAlteracaoVeiculo(ActionEvent event) {
		funcao = "Veiculo";
		notificar("Confirmar", "Confirmar senha do usuário", "Por favor, confirme sua senha no campo abaixo para confirmar as alterações nos dados");
	}
	
	@FXML
	void habilitarEdicaoVeiculo(ActionEvent event) {
		textFieldMarcaRastreador.setDisable(false);
		textFieldModeloVeiculo.setDisable(false);
		textFieldIDRastreador.setDisable(false);
		textFieldModeloRastreador.setDisable(false);
		comboBoxFilialVeiculo.setDisable(false);
		botaoSalvarAlteracoesVeiculo.setDisable(false);
		botaoDescartarAlteracoesVeiculo.setDisable(false);
	}
	
	@FXML
    public void mascararPlaca(KeyEvent event){
		String caracter = event.getCharacter();
		
		textfieldsDePlacas.forEach(textfield -> {
			if(event.getSource().equals(textfield)) {
				String texto = textfield.getText();

				boolean validado = false;

				for(int i = 0; i < listaCaracteresValidos.length; i++) {
					if(listaCaracteresValidos[i] == caracter.charAt(0)) {
						validado = true;
						break;
					}
				}

				if(validado) {
					if(texto.length() == 3) {
						texto = texto + "-";
					}

					if(texto.length() > 1){
						texto = texto.substring(0, texto.length());
					}

					if(texto.length() > 8) {
						texto = texto.substring(0, 8);
					}

					textfield.setText(texto.toUpperCase());
					textfield.end();
				}

			}	
		});

    }
	
	@FXML
	void pesquisarVeiculo(ActionEvent event) {
		if(!campoDeBuscaVeiculo.getText().isEmpty() || !campoDeBuscaIDVeiculo.getText().isEmpty()){
			String placaRequisitado = campoDeBuscaVeiculo.getText().toUpperCase();
			String rastreadorRequisitado = campoDeBuscaIDVeiculo.getText().toUpperCase();
			
			// Caso não existe nada no campo pesquisado, ele retorna "", uma string vazia, porém "" existe em todas as strings
			//então é necessário criar um pequeno filtro para ele não retornar pesquisas incorretas e pesquisar de acordo com os campos preenchidos
			listaDeVeiculos.forEach(veiculo -> {
				boolean placa = false;
				boolean rastreador = false;
				boolean tudo = false;
				
				// Nessa parte ele checa se está utilizando todos os campos de pesquisa ou somente alguns
				if(!campoDeBuscaVeiculo.getText().isEmpty() && !campoDeBuscaIDVeiculo.getText().isEmpty()) {
					tudo = true;
				}else {
					if(!campoDeBuscaVeiculo.getText().isEmpty()) {
						placa = true;
					}
					if(!campoDeBuscaIDVeiculo.getText().isEmpty()) {
						rastreador = true;
					}
				}

				// Aqui ele faz definitivamente a pesquisa, de acordo com estar utilizando todos os campos ou não
				if(tudo && veiculo.getPlaca().toUpperCase().contains(placaRequisitado) && String.valueOf(veiculo.getId_rastreador()).contains(rastreadorRequisitado)) {
					listaDeVeiculosPesquisa.add(veiculo);
				}else if(placa && veiculo.getPlaca().toUpperCase().contains(placaRequisitado)) {
					listaDeVeiculosPesquisa.add(veiculo);
				}else if(rastreador && String.valueOf(veiculo.getId_rastreador()).contains(rastreadorRequisitado)) {
					listaDeVeiculosPesquisa.add(veiculo);
				}
			});

			obsListVeiculosPesquisa = FXCollections.observableArrayList(listaDeVeiculosPesquisa);

			tabelaVeiculos.setItems(obsListVeiculosPesquisa);

			// Limpa as listas para não acumular com a próxima pesquisa
			listaDeVeiculosPesquisa.clear();
		}else {
			// Se não houver nada escrito nos campos, reseta a tabela mostrando todo o conteúdo
			tabelaVeiculos.setItems(obsListVeiculos);
		}
	}
	@FXML
	void salvarDadosAlteradosVeiculo(ActionEvent event) {
		Veiculo veiculo = new Veiculo().encontrarVeiculo(placaVeiculo);
		
		Map<String, String> dicionarioVeiculo = veiculo.dadosVeiculo();
		
		if(confirmado) {
			veiculo.alterarDadosVeiculo(textFieldPlacaVeiculo.getText(), textFieldModeloVeiculo.getText(),
					textFieldIDRastreador.getText(), textFieldMarcaRastreador.getText(),
					textFieldModeloRastreador.getText(), comboBoxFilialVeiculo.getValue().getId());

			notificar("Sucesso", "Dados alterados",
					"Os dados do veículo de placa " + textFieldPlacaVeiculo.getText() + " foram alterados com sucesso!");
			
	 		Logs log = new Logs();
    		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Alteração de dados de veículo:"
    				+ "\nPlaca: " + dicionarioVeiculo.get("Placa") + " -> " + textFieldPlacaVeiculo.getText()
    				+ "\nFilial: " + dicionarioVeiculo.get("Filial") + " -> " + comboBoxFilialVeiculo.getSelectionModel().getSelectedItem().getNome()
    				+ "\nModelo do veículo: " + dicionarioVeiculo.get("Modelo do veículo") + " -> " + textFieldModeloVeiculo.getText()
    				+ "\nMarca do rastreador: " + dicionarioVeiculo.get("Marca do rastreador") + " -> " + textFieldMarcaRastreador.getText()
    				+ "\nModelo do rastreador: " + dicionarioVeiculo.get("Modelo do rastreador") + " -> " + textFieldModeloRastreador.getText()
    				+ "\nID do rastreador: " + dicionarioVeiculo.get("ID do rastreador") + " -> " + textFieldIDRastreador.getText());

    		new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("VeiAlt");
    		
			desabilitarEdicao();
			atualizarTableViewEComboBox = true;
			
		}
		else {
			notificar("Falha", "Senha de confirmação incorreta", "A senha de verificação estava incorreta, tente novamente");
		}
		
		confirmado = false;
		funcao = "";
	}
	
	@FXML
	void descartarAlteracoesVeiculo(ActionEvent event) {
		Veiculo veiculo = new Veiculo();
		veiculo = veiculo.encontrarVeiculo(placaVeiculo);

		textFieldMarcaRastreador.setText(veiculo.getMarca_rastreador());
		textFieldModeloVeiculo.setText(veiculo.getModelo_veiculo());
		textFieldIDRastreador.setText(String.valueOf(veiculo.getId_rastreador()));
		textFieldPlacaVeiculo.setText(veiculo.getPlaca());
		textFieldModeloRastreador.setText(veiculo.getModelo_rastreador());

		desabilitarEdicao();
	}
	
	@FXML
	void selecionarVeiculo(ActionEvent event) {
//		try {
			Veiculos selecionado = tabelaVeiculos.getSelectionModel().getSelectedItem();
			placaVeiculo = selecionado.getPlaca();
			abrirTelaVeiculoSelecionado(event);

			carregarInfoVeiculo();
//		}catch (Exception falha) {
//			System.out.println(falha);
//			notificar("Falha", "Entidade não selecionada", "Nenhum veículo foi selecionado na lista, por favor selecione um e tente novamente");
//		}
	}
	
	void carregarInfoVeiculo() {
		Veiculo veiculo = new Veiculo().encontrarVeiculo(placaVeiculo);
		Filial filial = new Filial().encontrarFilial(veiculo.getFilial().getId());


		textFieldMarcaRastreador.setText(veiculo.getMarca_rastreador());
		textFieldModeloVeiculo.setText(veiculo.getModelo_veiculo());
		textFieldIDRastreador.setText(String.valueOf(veiculo.getId_rastreador()));
		textFieldPlacaVeiculo.setText(veiculo.getPlaca());
		textFieldModeloRastreador.setText(veiculo.getModelo_rastreador());
	   	int seguranca = 0;
    	// O while abaixo pode ser um pouco confuso, mas basicamente ele verifica se o que está selecionado na combobox é igual ao funcionário da viagem
	   	comboBoxFilialVeiculo.getSelectionModel().selectFirst();
	   	while(!filial.getNome().equals(comboBoxFilialVeiculo.getSelectionModel().getSelectedItem().getNome())) {
    		comboBoxFilialVeiculo.getSelectionModel().selectNext();
    		seguranca++;
    		if(seguranca > 100) {
    			break;
    		}
    	}
	}
	
	@FXML
	void abrirTelaVeiculoSelecionado(ActionEvent event) {
		paneVeiculos.setVisible(false);
		paneVeiculoSelecionado.setVisible(true);

		paneVeiculos.setDisable(true);
		paneVeiculoSelecionado.setDisable(false);
	}

	@FXML
	void abrirTelaSolicitarCadastro(MouseEvent event) {
		paneSelecionarOpcao.setVisible(false);
		paneSelecionarOpcao.setDisable(true);

		paneCadastrarMotorista.setVisible(true);
		paneCadastrarMotorista.setDisable(false);

	}


	@FXML
	void abrirTelaSelecionarMotorista(MouseEvent event) {
		paneSelecionarOpcao.setVisible(false);
		paneSelecionarOpcao.setDisable(true);

		paneMotoristas.setVisible(true);
		paneMotoristas.setDisable(false);

	}


	@FXML
	void abrirTelaMotoristas(MouseEvent event) {
		paneCadastrarMotorista.setVisible(false);
		paneCadastrarMotorista.setDisable(true);

		paneSelecionarOpcao.setVisible(true);
		paneSelecionarOpcao.setDisable(false);

		paneMotoristas.setVisible(false);
		paneMotoristas.setDisable(true);

		paneMotoristaSelecionado.setVisible(false);
		paneMotoristaSelecionado.setDisable(true);
	}
	
	@FXML
	void abrirTelaVeiculos(MouseEvent event) {
		paneSelecionarOpcao.setVisible(false);
		paneSelecionarOpcao.setDisable(true);
		
		paneVeiculos.setVisible(true);
		paneVeiculos.setDisable(false);
	}

	@FXML
	void abrirTelaAvisos(MouseEvent event) {
		paneCadastrarMotorista.setVisible(false);
		paneCadastrarMotorista.setDisable(true);

		paneSelecionarOpcao.setVisible(true);
		paneSelecionarOpcao.setDisable(false);

		paneMotoristas.setVisible(false);
		paneMotoristas.setDisable(true);

		paneMotoristaSelecionado.setVisible(false);
		paneMotoristaSelecionado.setDisable(true);

		ControlesPerfilSuperAvisos.atualizarInfos = true;
		Main.trocarTela("Tela Supervisor Avisos");
	}

	@FXML
	void abrirTelaHistEntregas(MouseEvent event) {
		paneCadastrarMotorista.setVisible(false);
		paneCadastrarMotorista.setDisable(true);

		paneSelecionarOpcao.setVisible(true);
		paneSelecionarOpcao.setDisable(false);

		paneMotoristas.setVisible(false);
		paneMotoristas.setDisable(true);

		paneMotoristaSelecionado.setVisible(false);
		paneMotoristaSelecionado.setDisable(true);

		Main.trocarTela("Tela Supervisor Entregas");
	}


	// Essas 3 funções a baixo você pode copiar das outras telas
	@FXML
	void minimizarJanela(ActionEvent event) {
		Main.minimizar();
	}

	@FXML
	void fecharJanela(ActionEvent event) {
		Main.trocarTela("Tela Login");
	}

	@FXML
	void voltar(MouseEvent event) {
		if(paneMotoristaSelecionado.isVisible()) {
			paneMotoristaSelecionado.setVisible(false);
			paneMotoristaSelecionado.setDisable(true);

			paneMotoristas.setVisible(true);
			paneMotoristas.setDisable(false);

		}else if(paneMotoristas.isVisible()) {
			paneMotoristas.setVisible(false);
			paneMotoristas.setDisable(true);

			paneSelecionarOpcao.setVisible(true);
			paneSelecionarOpcao.setDisable(false);

		}else if(paneCadastrarMotorista.isVisible()) {
			paneCadastrarMotorista.setVisible(false);
			paneCadastrarMotorista.setDisable(true);

			paneSelecionarOpcao.setVisible(true);
			paneSelecionarOpcao.setDisable(false);
		}else if(paneVeiculoSelecionado.isVisible()){
			paneVeiculoSelecionado.setVisible(false);
			paneVeiculoSelecionado.setDisable(true);
			
			paneVeiculos.setVisible(true);
			paneVeiculos.setDisable(false);
		}else if(paneVeiculos.isVisible()) {
			paneVeiculos.setVisible(false);
			paneVeiculos.setDisable(true);
			
			paneSelecionarOpcao.setVisible(true);
			paneSelecionarOpcao.setDisable(false);
			
		}
		else {
			Main.trocarTela("Tela Login");
		}
	}


	@FXML
	void habilitarEdicao(ActionEvent event) {
		tfNome.setDisable(false);
		tfCpf.setDisable(false);
		textFieldEmail.setDisable(false);
		pfSenha.setDisable(false);
		textFieldSalarioMotorista.setDisable(false);

		boxInfoExtraMotorista2.setDisable(false);

		cbFilial.setDisable(false);
		cbTurno.setDisable(false);

		btnSalvar.setDisable(false);
		btnDescartar.setDisable(false);
	}


	void desabilitarEdicao() {
		tfNome.setDisable(true);
		tfCpf.setDisable(true);
		textFieldEmail.setDisable(true);
		pfSenha.setDisable(true);
		textFieldSalarioMotorista.setDisable(true);

		boxInfoExtraMotorista2.setDisable(true);

		cbFilial.setDisable(true);
		cbTurno.setDisable(true);

		btnSalvar.setDisable(true);
		btnDescartar.setDisable(true);
		
		textFieldMarcaRastreador.setDisable(true);
		textFieldModeloVeiculo.setDisable(true);
		textFieldIDRastreador.setDisable(true);
		textFieldPlacaVeiculo.setDisable(true);
		botaoSalvarAlteracoesVeiculo.setDisable(true);
		botaoDescartarAlteracoesVeiculo.setDisable(true);
		comboBoxFilialVeiculo.setDisable(true);
		textFieldModeloRastreador.setDisable(true);
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
	void confirmarAlteracao(ActionEvent event) {
		if(paneAvisosConfirmar.isVisible()) {
			if(passwordFieldConfirmarSenha.getText().equals(ControlesLogin.senha)) {
				confirmado = true;
			}else {
				confirmado = false;
			}
		}

		fecharAviso(event);

		switch(funcao){
		case "Funcionario":
			alterarDados(event);
			break;
		case "Veiculo":
			salvarDadosAlteradosVeiculo(event);
			break;
		}

	}
	@FXML
	void fecharAviso(ActionEvent event) {		
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

		desabilitarEdicao();

	}

	void carregarTableView() {
		Motorista motorista = new Motorista();
		Veiculo veiculo = new Veiculo();

		listaDeMotoristas = motorista.listarMotoristas();
		listaDeVeiculos = veiculo.listarVeiculos();

		// Transforma a array primitiva em Observable Array
		obsListMotoristas = FXCollections.observableArrayList(listaDeMotoristas);
		obsListVeiculos = FXCollections.observableArrayList(listaDeVeiculos);

		// "Habilita" as colunas da tableView para receber o valor retornado da classe
		// Listas, nos seus métodos get
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		colunaCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		
		colunaIDVeiculo.setCellValueFactory(new PropertyValueFactory<>("id_rastreador"));
		colunaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));

		// Adiciona a Observable Array na TableView
		tabelaFuncionarios.setItems(obsListMotoristas);
		tabelaVeiculos.setItems(obsListVeiculos);

	}

	void limparCampos() {
		textFieldCadastroNome.setText("");
		textFieldCadastroCpf.setText("");
		textFieldCadastroEmail.setText("");
		textFieldCadastroSenha.setText("");
		textFieldCadastroConfirmarSenha.setText("");
		textFieldCadastroCargaHoraria.setText("");
		textFieldCadastroSalario.setText("");
		comboBoxCadastroFilial.getSelectionModel().select(0);
		comboBoxCadastroTurno.getSelectionModel().select(0);
		checkBoxDomingo.setSelected(false);
		checkBoxSegunda.setSelected(false);
		checkBoxTerca.setSelected(false);
		checkBoxQuarta.setSelected(false);
		checkBoxQuinta.setSelected(false);
		checkBoxSexta.setSelected(false);
		checkBoxSabado.setSelected(false);
	}
	
	void tarefasEmLoop() {
		// Considere que cada if aqui dentro é uma "função"

		if(atualizarTableViewEComboBox) {
			carregarTableView();
			carregarComboBoxFiliais();
			carregarComboBox();
			atualizarTableViewEComboBox = false;
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarComboBoxTurnos();
		
		textfieldsDeCpf.add(campoDeBuscaCpf);
		textfieldsDeCpf.add(tfCpf);
		textfieldsDeCpf.add(textFieldCadastroCpf);
		
		textfieldsDePlacas.add(textFieldPlacaVeiculo);
		textfieldsDePlacas.add(campoDeBuscaVeiculo);
		
		Timer myTimer = new Timer();
		myTimer.schedule(new TimerTask(){


			@Override
			public void run() {
				Platform.runLater(() -> tarefasEmLoop());
			}
		}, 0, 1000);
	}

}
