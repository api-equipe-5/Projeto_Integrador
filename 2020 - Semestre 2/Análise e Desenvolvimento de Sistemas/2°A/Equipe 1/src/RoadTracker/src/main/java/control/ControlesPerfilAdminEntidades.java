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
import model.*;
import view.*;

public class ControlesPerfilAdminEntidades implements Initializable {

	private static Funcionario funcionario = new Funcionario();
	private static Motorista motorista = new Motorista();
	private static Filial filial = new Filial();
	private static Turnos t = new Turnos(0, null);
	private String funcao;
	public static boolean atualizarInfos = false;
	public List<Veiculo> listaDePlacaVeiculos = new ArrayList<>();
	
	// Elementos das panes de avisos
	private boolean confirmado = false;
	@FXML
	private Pane paneAvisosPrincipal;
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
	private Pane paneAvisosSombra;
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
	// ----------------------------------

	// Elemento da pane de selecionar entidade
	@FXML
	private Pane paneSelecionarEntidade;
	// -------------------------------------

	// Elementos das panes de funcionários
	@FXML
	private Pane paneFuncionarioSelecionado;
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
	private Label lblNome;
	@FXML
	private Button btnSalvar;
	@FXML
	private Button btnDescartar;
	@FXML
	private TextField tfNome;
	@FXML
	private TextField tfCpf;
	@FXML
	private PasswordField pfSenha;
	@FXML
	private TextField tfCargaHoraria;
	@FXML
	private ComboBox<Filiais> cbFilial;
	@FXML
	private ComboBox<Cargos> cbCargo;
	@FXML
	private Pane paneFuncionarios;
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
	private ComboBox<Turnos> cbTurno;
	@FXML
	private VBox boxInfoExtraMotorista1;
	@FXML
	private VBox boxInfoExtraMotorista2;
	@FXML
	private TextField textFieldEmail;
	@FXML
	private TextField textFieldSalarioMotorista;
	@FXML
	private Label labelSituacaoMotorista;

	private List<Cargos> cargos = new ArrayList<>();
	private ObservableList<Cargos> cargosList;

	private List<Filiais> filiais = new ArrayList<>();
	private ObservableList<Filiais> filiaisList;

	private List<Turnos> turnos = new ArrayList<>();
	private ObservableList<Turnos> turnosList;

	private String cpfFuncionario;
	private String cargoFuncionario;

	private List<Funcionarios> listaDeFuncionarios = new ArrayList<>();
	private ObservableList<Funcionarios> obsListFuncionarios;
	
	private List<Funcionarios> listaDeMotoristas = new ArrayList<>();
	private ObservableList<Funcionarios> obsListMotoristas;
	
	private List<Funcionarios> listaDeFuncionariosPesquisa = new ArrayList<>();
	private ObservableList<Funcionarios> obsListFuncionariosPesquisa;
	
	private List<Funcionarios> listaTodosFuncionarios = new ArrayList<>();
	
	
    private List<Viagens> listaDeViagensMotorista = new ArrayList<>();
    
    private boolean funcionarioEncontrado = false;
    
	private List<TextField> textfieldsDeCpf = new ArrayList<TextField>();
    
	// ---------------------------------

	// Elementos das panes de filiais
	@FXML
	private Pane paneFiliais;
	@FXML
	private TableView<Filiais> tabelaFiliais;
	@FXML
	private TableColumn<?, ?> colunaFilial;
	@FXML
	private TableColumn<?, ?> colunaEstado;
	@FXML
	private TableColumn<?, ?> colunaIDFilial;
	@FXML
	private TextField campoDeBuscaFilial;
	@FXML
	private TextField campoDeBuscaEstado;

	private List<Filiais> listaDeFiliais = new ArrayList<>();
	private ObservableList<Filiais> obsListFiliais;
	
	private List<Filiais> listaDeFiliaisPesquisa = new ArrayList<>();
	private ObservableList<Filiais> obsListFiliaisPesquisa;

	@FXML
	private Pane paneFilialSelecionada;
	@FXML
	private TextField textFieldNomeFilial;
	@FXML
	private TextField textFieldCidadeFilial;
	@FXML
	private TextField textFieldCnpj;
	@FXML
	private TextField textFieldRntrc;
	@FXML
	private TextField textFieldIdFilial;
	@FXML
	private Button botaoSalvarAlteracoesFilial;
	@FXML
	private Button botaoDescartarAlteracoesFilial;
	
    @FXML
    private ComboBox<Estados> comboBoxEstados;
    
    private List<Estados> estados = new ArrayList<>();
    private ObservableList<Estados> obsListEstados;
    
    private String listaDeEstados[] = {"AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MG", "PA", "PB", "PR",
    								   "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF"};
	
	private int idFilial;

	// ------------------------------

	// Elementos das panes de veiculos
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
	
	private List<Veiculos> listaDeVeiculos = new ArrayList<>();
	private ObservableList<Veiculos> obsListVeiculos;
	
	private List<Veiculos> listaDeVeiculosPesquisa = new ArrayList<>();
	private ObservableList<Veiculos> obsListVeiculosPesquisa;
	
	private String placaVeiculo;

	@FXML
	private Pane paneVeiculoSelecionado;
	@FXML
	private TextField textFieldMarcaRastreador;
	@FXML
	private TextField textFieldModeloVeiculo;
	@FXML
	private TextField textFieldIDRastreador;
	@FXML
	private TextField textFieldPlacaVeiculo;
	@FXML
	private Button botaoSalvarAlteracoesVeiculo;
	@FXML
	private TextField textFieldModeloRastreador;
	@FXML
	private Button botaoDescartarAlteracoesVeiculo;
	@FXML
	private ComboBox<Filiais> comboBoxFilialVeiculo;
	
	String caracteresValidos = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvXxWwYyZz-0123456789";
	String caracteresMaiusculosValidos = "ABCDEFGHIJKLMNOPQRSTUVXWYZ";
	String numerosValidos = "0123456789";
	char listaCaracteresValidos[] = caracteresValidos.toCharArray();
	char listaCaracteresMaiusculosValidos[] = caracteresMaiusculosValidos.toCharArray();
	
	private List<TextField> textfieldsDePlacas = new ArrayList<TextField>();
	
	// ------------------------------

	// Métodos funcionários
	public void carregarComboBoxCargos() {
		cargos.add(new Cargos(0, "Selecione um cargo..."));
		cargos = funcionario.listarCargos();
		cargosList = FXCollections.observableArrayList(cargos);
		cbCargo.setItems(cargosList);
	}

	public void carregarComboBoxTurnos() {
		turnos = t.listarTurnos();
		turnosList = FXCollections.observableArrayList(turnos);
		cbTurno.setItems(turnosList);
	}

	@FXML
	void requisitarExclusaoFuncionario(ActionEvent event) {
		confirmado = false;
		funcao = "ExcluirFuncionario";
		notificar("Confirmar", "Confirmar senha do usuário", "Por favor, confirme sua senha no campo abaixo para confirmar a exclusão.");
	}
	@FXML
	void excluirFuncionario(ActionEvent event) {
		
		Motorista motoristaExcluido = null;
		Funcionario funcionarioExcluido = null;
		
		if (confirmado) {
			if(cargoFuncionario.equals("Motorista")) {
				Map<String, String> dicionarioMotorista = motorista.dadosMotorista();
				
				motoristaExcluido = motorista.excluirMotorista(cpfFuncionario);
				if (motoristaExcluido != null) {
					notificar("Sucesso", "Funcionário excluído",
							"O funcionário foi excluído dos registros do banco de dados com sucesso");
					
					new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("MotExc");
					
		    		Logs log = new Logs();
	        		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Exclusão de motorista:"
	        				+ "\nNome: " + dicionarioMotorista.get("Nome")
	        				+ "\nCPF: " + dicionarioMotorista.get("CPF")
	        				+ "\nE-mail: " + dicionarioMotorista.get("E-mail")
	        				+ "\nFilial: " + dicionarioMotorista.get("Filial")
	        				+ "\nSalário: R$ " + dicionarioMotorista.get("Salario")
	        				+ "\nCarga Horária: " + dicionarioMotorista.get("Carga Horaria")
	        				+ "\nDias de trabalho: " + dicionarioMotorista.get("Dias de trabalho"));
					
					atualizarInfos = true;
					
					paneFuncionarioSelecionado.setVisible(false);
					paneFuncionarios.setVisible(true);
					paneFuncionarios.setDisable(false);
				}
				else {
					notificar("Falha", "Falha",
							"O funcionário não foi excluído. Verifique se não há nenhum registro ligado a ele e tente novamente.");
				}
			}
			else {
				Map<String, String> dicionarioFuncionario = funcionario.dadosFuncionario();
				
				funcionarioExcluido = funcionario.removerFuncionario(funcionario.getCpf());
				if (funcionarioExcluido != null) {
					notificar("Sucesso", "Funcionário excluído",
							"O funcionário foi excluído dos registros do banco de dados com sucesso");
					
		    		Logs log = new Logs();
	        		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Exclusão de funcionário:"
	        				+ "\nNome: " + dicionarioFuncionario.get("Nome")
	        				+ "\nCPF: " + dicionarioFuncionario.get("CPF")
	        				+ "\nE-mail: " + dicionarioFuncionario.get("E-mail")
	        				+ "\nFilial: " + dicionarioFuncionario.get("Filial")
	        				+ "\nCargo: " + dicionarioFuncionario.get("Cargo"));
	        		
	        		if(dicionarioFuncionario.get("Cargo").equals("Administrador")) {
		        		new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("AdmExc");
	        		}else {
		        		new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("SupExc");
	        		}

					
					atualizarInfos = true;
					
					paneFuncionarioSelecionado.setVisible(false);
					paneFuncionarios.setVisible(true);
					paneFuncionarios.setDisable(false);
				}
				else {
					notificar("Falha", "Falha",
							"O funcionário não foi excluído. Verifique se não há nenhum registro ligado a ele e tente novamente.");
				}
			}
		}
		else {
			notificar("Falha", "Senha de confirmação incorreta", "A senha de verificação estava incorreta, tente novamente");
		}
		confirmado = false;
		funcao = "";
	}
	
	@FXML
	void selecionarFuncionario(ActionEvent event) {
		try{
			Funcionarios selecionado = tabelaFuncionarios.getSelectionModel().getSelectedItem();
			funcionarioEncontrado = true;
		}catch (NullPointerException falha) {
			notificar("Falha", "Entidade não selecionada", "Nenhum funcionário foi selecionado na lista, por favor selecione um e tente novamente");
		}
		
		if(funcionarioEncontrado) {
			Funcionarios selecionado = tabelaFuncionarios.getSelectionModel().getSelectedItem();
			
			cpfFuncionario = selecionado.getCpf();
			cargoFuncionario = selecionado.getCargo();

			paneFuncionarios.setVisible(false);
			paneFuncionarios.setDisable(true);
			paneFuncionarioSelecionado.setVisible(true);
			paneFuncionarioSelecionado.setDisable(false);

			carregarComboBoxCargos();
			carregarComboBox();
			carregarComboBoxTurnos();
			carregarInfoFuncionario();
		}

		funcionarioEncontrado = false;

	}

	void carregarInfoFuncionario() {
		if(cargoFuncionario.equals("Motorista")) {
			boxInfoExtraMotorista1.setVisible(true);
			boxInfoExtraMotorista1.setDisable(true);
			boxInfoExtraMotorista2.setVisible(true);
			boxInfoExtraMotorista2.setDisable(true);
			
			motorista = motorista.encontrarMotorista(cpfFuncionario);
			
			lblNome.setText(motorista.getNome());
			tfNome.setText(motorista.getNome());
			tfCpf.setText(motorista.getCpf());
			pfSenha.setText(motorista.getSenha());
			tfCargaHoraria.setText(motorista.getCargaHoraria());
			
			cbDom.setSelected(motorista.getDom());
			cbSeg.setSelected(motorista.getSeg());
			cbTer.setSelected(motorista.getTer());
			cbQua.setSelected(motorista.getQua());
			cbQui.setSelected(motorista.getQui());
			cbSex.setSelected(motorista.getSex());
			cbSab.setSelected(motorista.getSab());
			
			textFieldEmail.setText(motorista.getEmail());
			textFieldSalarioMotorista.setText(motorista.getSalario());
			cbCargo.getSelectionModel().select(0);
			
		   	int seguranca = 0;
	    	// O while abaixo pode ser um pouco confuso, mas basicamente ele verifica se o que está selecionado na combobox é igual ao funcionário da viagem
		   	cbFilial.getSelectionModel().selectFirst();
	    	while(!motorista.getFilial().getNome().equals(cbFilial.getSelectionModel().getSelectedItem().getNome())) {
	    		cbFilial.getSelectionModel().selectNext();
	    		seguranca++;
	    		if(seguranca > 100) {
	    			break;
	    		}
	    	}
			
			if (motorista.getTurno().equals("Matutino")) {
				cbTurno.getSelectionModel().select(0);
			}
			else if (motorista.getTurno().equals("Vespertino")) {
				cbTurno.getSelectionModel().select(1);
			}
			else {
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
		else {
			labelSituacaoMotorista.setVisible(false);
			boxInfoExtraMotorista1.setVisible(false);
			boxInfoExtraMotorista1.setDisable(true);
			boxInfoExtraMotorista2.setVisible(false);
			boxInfoExtraMotorista2.setDisable(true);
			
			funcionario = funcionario.encontrarFuncionario(cpfFuncionario);
	
			lblNome.setText(funcionario.getNome());
			tfNome.setText(funcionario.getNome());
			tfCpf.setText(funcionario.getCpf());
			pfSenha.setText(funcionario.getSenha());
			textFieldEmail.setText(funcionario.getEmail());
			
			// Cargo
			if (funcionario.getCargo().equals("Motorista")) {
				cbCargo.getSelectionModel().select(0);
			} else if (funcionario.getCargo().equals("Supervisor")) {
				cbCargo.getSelectionModel().select(1);
			} else {
				cbCargo.getSelectionModel().select(2);
			}
	
			// Filial		
		   	int seguranca = 0;
		   	cbFilial.getSelectionModel().selectFirst();	   	
	    	// O while abaixo pode ser um pouco confuso, mas basicamente ele verifica se o que está selecionado na combobox é igual ao funcionário da viagem
	    	while(!funcionario.getFilial().getNome().equals(cbFilial.getSelectionModel().getSelectedItem().getNome())) {
	    		cbFilial.getSelectionModel().selectNext();
	    		seguranca++;
	    		if(seguranca > 100) {
	    			break;
	    		}
	    	}
	
		}
	}

	@FXML
	void descartarAlteracoes(ActionEvent event) {
		carregarInfoFuncionario();
		desabilitarEdicao();
	}

	@FXML
	void requisitarAlteracaoFuncionario(ActionEvent event) {
		funcao = "Funcionario";
		notificar("Confirmar", "Confirmar senha do usuário", "Por favor, confirme sua senha no campo abaixo para confirmar as alterações nos dados");
	}
	@FXML
	void alterarDados(ActionEvent event) {
			if(confirmado) {
				
				Funcionario funcs = new Funcionario();
				Motorista mots = new Motorista();
				
				List<Funcionario> fs = new ArrayList<>();
				List<Motorista> ms = new ArrayList<>();
				
				Map<String, String> dadosMotorista = new Motorista().encontrarMotorista(tfCpf.getText()).dadosMotorista();
				Map<String, String> dadosFuncionario = new Funcionario().encontrarFuncionario(tfCpf.getText()).dadosFuncionario();
				
				boolean emailRepetido = false;
		       	
				if(cargoFuncionario.equals("Motorista")) {
					
					String salario = textFieldSalarioMotorista.getText();
	        		// verificando se o usuário digitou um salário float com vírgula ou com ponto
	        		for (int i = 0; i < salario.length(); i++) {
	        			char caracter = salario.charAt(i);
	        			if (caracter == ',') { // se for vírgula troca, pois o java só entende ponto
	        				salario = salario.replace(',', '.');
	        			}
	        		}
	        		
	        		ms = mots.consultarTodosMotoristas();
	        		
	        		for (Motorista m : ms) {
			       		if (m.getEmail().equals(textFieldEmail.getText()) && 
			       				(!textFieldEmail.getText().equals(dadosMotorista.get("E-mail")) ||
			       						!textFieldEmail.getText().equals(dadosFuncionario.get("E-mail")))) {
			       			emailRepetido = true;
							break;
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
						if (!emailRepetido) {
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
							atualizarInfos = true;
						}
						else {
							notificar("Falha", "E-mail já cadastrado.", "Já existe um motorista com o e-mail digitado.");
						}
					}
				}
				else {
			       	fs = funcs.consultarTodosFuncionarios();
			       	
			       	for (Funcionario f : fs) {
						if (f.getEmail().equals(textFieldEmail.getText())) {
							emailRepetido = true;
							break;
						}
					}
					
					if (pfSenha.getText().isEmpty() || textFieldEmail.getText().isBlank()) {
						notificar("Falha", "Campo vazio", "A senha e o e-mail não podem ficar vazios. Preencha os campos.");
					}
					else {
						if (!emailRepetido) {
							Map<String, String> dicionarioFuncionario = funcionario.dadosFuncionario();
							
							funcionario.alterarDadosFuncionario(tfNome.getText(), funcionario.getCpf(), pfSenha.getText(),
									cbCargo.getValue().getCargo(), cbFilial.getValue().getId(),
									textFieldEmail.getText());
							notificar("Sucesso", "Alteração de dados",
									"Os dados do funcionário " + tfNome.getText() + " foram alterados no banco de dados com sucesso");
							
				    		Logs log = new Logs();
			        		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Alteração de dados de funcionário:"
			        				+ "\nNome: " + dicionarioFuncionario.get("Nome") + " -> " + tfNome.getText()
			        				+ "\nCPF: " + dicionarioFuncionario.get("CPF") + " -> " + funcionario.getCpf()
			        				+ "\nE-mail: " + dicionarioFuncionario.get("E-mail") + " -> " + textFieldEmail.getText()
			        				+ "\nFilial: " + dicionarioFuncionario.get("Filial") + " -> " + cbFilial.getSelectionModel().getSelectedItem().getNome()
			        				+ "\nCargo: " + dicionarioFuncionario.get("Cargo") + " -> " + cbCargo.getValue().getCargo());
			        		
			        		if(dicionarioFuncionario.get("Cargo").equals("Administrador")) {
				        		new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("AdmAlt");
			        		}
			        		else {
				        		new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("SupAlt");
			        		}
							atualizarInfos = true;
						}
						else {
							notificar("Falha", "E-mail já existente", "O e-mail inserido já está cadastrado no sistema.");
						}
					}
				}
			}
			else {
				notificar("Falha", "Senha de confirmação incorreta", "A senha de verificação estava incorreta, tente novamente");
			}
			confirmado = false;
			funcao = "";
	}
	
	@FXML
	void pesquisarFuncionarios(ActionEvent event) {
		if(!campoDeBuscaCpf.getText().isEmpty() || !campoDeBuscaNome.getText().isEmpty()){
			
			String nomeRequisitado = campoDeBuscaNome.getText().toLowerCase();
			String cpfRequisitado = campoDeBuscaCpf.getText();
 
			// Caso não existe nada no campo pesquisado, ele retorna "", uma string vazia, porém "" existe em todas as strings
			//então é necessário criar um pequeno filtro para ele não retornar pesquisas incorretas e pesquisar de acordo com os campos preenchidos
			listaTodosFuncionarios.forEach(funcionario -> {
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
			tabelaFuncionarios.setItems(obsListFuncionarios);
		}
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
	// -------------------------------

	// Métodos filial
	@FXML
	void habilitarEdicaoFilial(ActionEvent event) {
		textFieldNomeFilial.setDisable(false);
		textFieldCidadeFilial.setDisable(false);
		comboBoxEstados.setDisable(false);
		textFieldCnpj.setDisable(false);
		textFieldRntrc.setDisable(false);

		botaoSalvarAlteracoesFilial.setDisable(false);
		botaoDescartarAlteracoesFilial.setDisable(false);
	}
	
	@FXML
	void requisitarExclusaoFilial(ActionEvent event) {
		confirmado = false;
		funcao = "ExcluirFilial";
		notificar("Confirmar", "Confirmar senha do usuário", "Por favor, confirme sua senha no campo abaixo para confirmar a exclusão.");
	}
	@FXML
	void excluirFilial(ActionEvent event) {
		if (confirmado) {
			Filial filial = new Filial().encontrarFilial(idFilial);
			
			Map<String, String> dicionarioFilial = filial.dadosFilial();
			
			boolean filialExcluida = filial.excluirFilial(idFilial);
			
			if (filialExcluida) {
				notificar("Sucesso", "Filial excluída", "A filial foi excluída dos registros do banco de dados com sucesso!");
				
	    		Logs log = new Logs();
	    		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Exclusão de filial:"
	    				+ "\nNome: " + dicionarioFilial.get("Nome")
	    				+ "\nCNPJ: " + dicionarioFilial.get("CNPJ")
	    				+ "\nRNTRC: " + dicionarioFilial.get("RNTRC")
	    				+ "\nEstado: " + dicionarioFilial.get("Estado")
	    				+ "\nCidade: " + dicionarioFilial.get("Cidade"));
				
        		new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("FilExc");
	    		
				atualizarInfos = true;
				
				paneFilialSelecionada.setVisible(false);
				paneFiliais.setVisible(true);
				paneFiliais.setDisable(false);
			}
			else {
				notificar("Falha", "Falha",
						"A filial não foi excluída. Verifique se não há nenhum registo ligado a ela e tente novamente.");
			}
		}
		else {
			notificar("Falha", "Senha de confirmação incorreta", "A senha de verificação estava incorreta, tente novamente");
		}
		confirmado = false;
		funcao = "";
	}

	
	@FXML
	void requisitarAlteracaoFilial(ActionEvent event) {
		funcao = "Filial";
		notificar("Confirmar", "Confirmar senha do usuário", "Por favor, confirme sua senha no campo abaixo para confirmar as alterações nos dados");
	}
	@FXML
	void salvarDadosAlteradosFilial(ActionEvent event) {
		Filial filial = new Filial().encontrarFilial(idFilial);
		
		
		if(confirmado) {
			String estado = comboBoxEstados.getSelectionModel().getSelectedItem().getEstado();
			
			Map<String, String> dicionarioFilial = filial.dadosFilial();
			
			filial.alterarDadosFilial(textFieldNomeFilial.getText(), textFieldCidadeFilial.getText(),
									  estado, textFieldCnpj.getText(), textFieldRntrc.getText(), 
									  Integer.parseInt(textFieldIdFilial.getText()));
			desabilitarEdicao();
			notificar("Sucesso", "Filial atualizada",
					"Os dados da filial " + textFieldNomeFilial.getText() + " foram alterados com sucesso!");
			
    		Logs log = new Logs();
    		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Alteração de dados de filial:"
    				+ "\nNome: " + dicionarioFilial.get("Nome") + " -> " + textFieldNomeFilial.getText()
    				+ "\nCNPJ: " + dicionarioFilial.get("CNPJ") + " -> " + textFieldCnpj.getText()
    				+ "\nRNTRC: " + dicionarioFilial.get("RNTRC") + " -> " + textFieldRntrc.getText()
    				+ "\nEstado: " + dicionarioFilial.get("Estado") + " -> " + estado
    				+ "\nCidade: " + dicionarioFilial.get("Cidade") + " -> " + textFieldCidadeFilial.getText());
    		
    		new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("FilAlt");
			
			atualizarInfos = true;
		}
		else {
			notificar("Falha", "Senha de confirmação incorreta", "A senha de verificação estava incorreta, tente novamente");
		}
		
		confirmado = false;
		funcao = "";
		
	}

	@FXML
	void descartarAlteracoesFilial(ActionEvent event) {
		Filial filial = new Filial();
		filial = filial.encontrarFilial(idFilial);

		textFieldNomeFilial.setText(filial.getNome());
		textFieldCidadeFilial.setText(filial.getCidade());
		textFieldCnpj.setText(filial.getCnpj());
		textFieldRntrc.setText(filial.getRntrc());
		
	   	int seguranca = 0;
    	// O while abaixo pode ser um pouco confuso, mas basicamente ele verifica se o que está selecionado na combobox é igual ao funcionário da viagem
	   	comboBoxEstados.getSelectionModel().selectFirst();
	   	while(!filial.getEstado().equals(comboBoxEstados.getSelectionModel().getSelectedItem().getEstado())) {
	   		comboBoxEstados.getSelectionModel().selectNext();
    		seguranca++;
    		if(seguranca > 100) {
    			break;
    		}
    	}


	}

	@FXML
	void selecionarFilial(ActionEvent event) {
		try {
			Filiais selecionada = tabelaFiliais.getSelectionModel().getSelectedItem();
			idFilial = selecionada.getId();
			abrirTelaFilialSelecionada(event);
			carregarInfoFilial();
		}
		catch (NullPointerException falha) {
			notificar("Falha", "Entidade não selecionada", "Nenhuma filial foi selecionada na lista, por favor selecione uma e tente novamente");
		}

	}

	void carregarInfoFilial() {
		Filial filial = new Filial();
		filial = filial.encontrarFilial(idFilial);
		textFieldCidadeFilial.setText(filial.getCidade());
		textFieldNomeFilial.setText(filial.getNome());
		textFieldCnpj.setText(filial.getCnpj());
		textFieldRntrc.setText(filial.getRntrc());
		textFieldIdFilial.setText(String.valueOf(filial.getId()));
		
	   	int seguranca = 0;
    	// O while abaixo pode ser um pouco confuso, mas basicamente ele verifica se o que está selecionado na combobox é igual ao funcionário da viagem
	   	comboBoxEstados.getSelectionModel().selectFirst();
	   	while(!filial.getEstado().equals(comboBoxEstados.getSelectionModel().getSelectedItem().getEstado())) {
	   		comboBoxEstados.getSelectionModel().selectNext();
    		seguranca++;
    		if(seguranca > 100) {
    			break;
    		}
    	}

	}
	
	@FXML 
	void pesquisarFilial(ActionEvent event){
		if(!campoDeBuscaEstado.getText().isEmpty() || !campoDeBuscaFilial.getText().isEmpty()){
			
			String estadoRequisitado = campoDeBuscaEstado.getText().toLowerCase();
			String filialRequisitada = campoDeBuscaFilial.getText().toLowerCase();
 
			// Caso não existe nada no campo pesquisado, ele retorna "", uma string vazia, porém "" existe em todas as strings
			//então é necessário criar um pequeno filtro para ele não retornar pesquisas incorretas e pesquisar de acordo com os campos preenchidos
			listaDeFiliais.forEach(filial -> {
				boolean estado = false;
				boolean nome = false;
				boolean tudo = false;
				
				// Nessa parte ele checa se está utilizando todos os campos de pesquisa ou somente alguns
				if(!campoDeBuscaEstado.getText().isEmpty() && !campoDeBuscaFilial.getText().isEmpty()) {
					tudo = true;
				}else {
					if(!campoDeBuscaEstado.getText().isEmpty()) {
						estado = true;
					}
					if(!campoDeBuscaFilial.getText().isEmpty()) {
						nome = true;
					}
				}

				// Aqui ele faz definitivamente a pesquisa, de acordo com estar utilizando todos os campos ou não
				if(tudo && filial.getEstado().toLowerCase().contains(estadoRequisitado) && filial.getNome().toLowerCase().contains(filialRequisitada)) {
					listaDeFiliaisPesquisa.add(filial);
				}else if(estado && filial.getEstado().toLowerCase().contains(estadoRequisitado)) {
					listaDeFiliaisPesquisa.add(filial);
				}else if(nome && filial.getNome().toLowerCase().contains(filialRequisitada)) {
					listaDeFiliaisPesquisa.add(filial);
				}
			});
 
			obsListFiliaisPesquisa = FXCollections.observableArrayList(listaDeFiliaisPesquisa);

			tabelaFiliais.setItems(obsListFiliaisPesquisa);

			// Limpa as listas para não acumular com a próxima pesquisa
			listaDeFiliaisPesquisa.clear();
		}else {
			// Se não houver nada escrito nos campos, reseta a tabela mostrando todo o conteúdo
			tabelaFiliais.setItems(obsListFiliais);
		}

		
	}
	
    void carregarComboBoxEstados() {
    	estados.add(new Estados("Selecione um estado..."));
    	
    	for(int i = 0; i < listaDeEstados.length; i++) {
    		estados.add(new Estados(listaDeEstados[i]));
    	}
    	
    	obsListEstados = FXCollections.observableArrayList(estados);
    	
    	comboBoxEstados.setItems(obsListEstados);
    	
    }
	
	@FXML
	public void mascararCnpj(KeyEvent event) {
		String texto = textFieldCnpj.getText();
		String caracter = event.getCharacter();

		
		// Verifica se é um número e se for, aplica a máscara de CNPJ, porém, caso não seja, não permite a adição do caracter
		if(caracter.equals("1") || caracter.equals("2") || caracter.equals("3") || caracter.equals("4") ||
		   caracter.equals("5") || caracter.equals("6") || caracter.equals("7") || caracter.equals("8") ||
		   caracter.equals("9") || caracter.equals("0")){

			if(texto.length() == 2 || texto.length() == 6) {
				texto = texto + ".";
			}else if(texto.length() == 10) {
				texto = texto + "/";
			}else if(texto.length() == 16) {
				texto = texto + "-";
			}

		}else if(texto.length() > 1){
			texto = texto.substring(0, texto.length() - 1);
		}
		
		if(texto.length() > 19) {
			texto = texto.substring(0, 19);
		}

		textFieldCnpj.setText(texto);
		textFieldCnpj.end();
		
		
	}
	
	
    @FXML
    public void mascararRntrc(KeyEvent event) {
    	String texto = textFieldRntrc.getText();
    	
    	if(texto.length() > 8) {
    		texto = texto.substring(0, 8);
    	}
    	
    	textFieldRntrc.setText(texto);
    	textFieldRntrc.end();
    }
	// -------------------------------------

	// Métodos veiculo
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
	void requisitarExclusaoVeiculo(ActionEvent event) {
		confirmado = false;
		funcao = "ExcluirVeiculo";
		notificar("Confirmar", "Confirmar senha do usuário", "Por favor, confirme sua senha no campo abaixo para confirmar a exclusão.");
	}
	@FXML
	void excluirVeiculo(ActionEvent event) {
		if (confirmado) {
			Veiculo veiculo = new Veiculo().encontrarVeiculo(placaVeiculo);
			
			Map<String, String> dicionarioVeiculo = veiculo.dadosVeiculo();
			
			boolean veiculoExcluido = veiculo.excluirVeiculo(placaVeiculo);
			desabilitarEdicao();
			
			if (veiculoExcluido) {
				notificar("Sucesso", "Veículo excluído", "O veículo foi excluído com sucesso do banco de dados!");
				
        		Logs log = new Logs();
        		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Exclusão de veículo:"
        				+ "\nPlaca: " + dicionarioVeiculo.get("Placa")
        				+ "\nFilial: " + dicionarioVeiculo.get("Filial")
        				+ "\nModelo do veículo: " + dicionarioVeiculo.get("Modelo do veículo")
        				+ "\nMarca do rastreador: " + dicionarioVeiculo.get("Marca do rastreador")
        				+ "\nModelo do rastreador: " + dicionarioVeiculo.get("Modelo do rastreador")
        				+ "\nID do rastreador: " + dicionarioVeiculo.get("ID do rastreador"));
        		
        		new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("VeiExc");
				
				atualizarInfos = true;
				
				paneVeiculos.setVisible(true);
				paneVeiculos.setDisable(false);
				paneVeiculoSelecionado.setVisible(false);
			}
			else {
				notificar("Falha", "Falha",
						"O veículo não foi excluído. Verifique se não há nenhum registro ligado a ele e tente novamente.");
			}
		}
		else {
			notificar("Falha", "Senha de confirmação incorreta", "A senha de verificação estava incorreta, tente novamente");
		}
		confirmado = false;
		funcao = "";
	}

	@FXML
	void requisitarAlteracaoVeiculo(ActionEvent event) {
		funcao = "Veiculo";
		notificar("Confirmar", "Confirmar senha do usuário", "Por favor, confirme sua senha no campo abaixo para confirmar as alterações nos dados");
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
			atualizarInfos = true;
			
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
		try {
			Veiculos selecionado = tabelaVeiculos.getSelectionModel().getSelectedItem();
			placaVeiculo = selecionado.getPlaca();
			abrirTelaVeiculoSelecionado(event);

			carregarInfoVeiculo();
		}catch (Exception falha) {
			System.out.println(falha);
			notificar("Falha", "Entidade não selecionada", "Nenhum veículo foi selecionado na lista, por favor selecione um e tente novamente");
		}
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
	void pesquisarVeiculo(ActionEvent event){
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
	// -------------------------------------
	
	

	// Métodos gerais
    @FXML
    void exibirDicaFlutuante(MouseEvent event) {
    	if (event.getTarget().toString().contains("textFieldMarcaRastreador")) {
        	labelDicaFlutuante.setText("Marca do Rastreador");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldModeloRastreador")) {
        	labelDicaFlutuante.setText("Versão do Rastreador");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldIDRastreador")) {
        	labelDicaFlutuante.setText("ID do Rastreador");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldModeloVeiculo")) {
        	labelDicaFlutuante.setText("Modelo do Veículo");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldPlacaVeiculo")) {
        	labelDicaFlutuante.setText("Placa do Veículo");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("comboBoxFilialVeiculo")) {
        	labelDicaFlutuante.setText("Filial do Veículo");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldNomeFilial")) {
        	labelDicaFlutuante.setText("Nome");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldCidadeFilial")) {
        	labelDicaFlutuante.setText("Cidade");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("comboBoxEstados")) {
        	labelDicaFlutuante.setText("Estado");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldCnpj")) {
        	labelDicaFlutuante.setText("CNPJ");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldRntrc")) {
        	labelDicaFlutuante.setText("RNTRC");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldIdFilial")) {
        	labelDicaFlutuante.setText("ID");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("tfNome")) {
        	labelDicaFlutuante.setText("Nome");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("tfCpf")) {
        	labelDicaFlutuante.setText("CPF");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldEmail")) {
        	labelDicaFlutuante.setText("E-mail");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("pfSenha")) {
        	labelDicaFlutuante.setText("Senha");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("cbCargo")) {
        	labelDicaFlutuante.setText("Cargo");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("cbFilial")) {
        	labelDicaFlutuante.setText("Filial");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("cbTurno")) {
        	labelDicaFlutuante.setText("Turno");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldSalarioMotorista")) {
        	labelDicaFlutuante.setText("Salário");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("tfCargaHoraria")) {
        	labelDicaFlutuante.setText("Carga Horária");
        	labelDicaFlutuante.setVisible(true);
    	}
    	
    	labelDicaFlutuante.setLayoutX(event.getSceneX());
    	labelDicaFlutuante.setLayoutY(event.getSceneY());
    }
    @FXML
    void esconderDicaFlutuante(MouseEvent event) {
    	labelDicaFlutuante.setVisible(false);
    	
    }
    
	@FXML
	void abrirTelaFuncionarios(MouseEvent event) {
		paneFuncionarios.setVisible(true);
		paneFuncionarioSelecionado.setVisible(false);
		paneFiliais.setVisible(false);
		paneFilialSelecionada.setVisible(false);
		paneVeiculos.setVisible(false);
		paneVeiculoSelecionado.setVisible(false);
		paneSelecionarEntidade.setVisible(false);

		paneFuncionarios.setDisable(false);
		paneFuncionarioSelecionado.setDisable(true);
		paneFiliais.setDisable(true);
		paneFilialSelecionada.setDisable(true);
		paneVeiculos.setDisable(true);
		paneVeiculoSelecionado.setDisable(true);
		paneSelecionarEntidade.setDisable(true);

		desabilitarEdicao();
	}

	@FXML
	void abrirTelaFuncionarioSelecionado(ActionEvent event) {
		paneFuncionarios.setVisible(false);
		paneFuncionarioSelecionado.setVisible(true);

		paneFuncionarios.setDisable(true);
		paneFuncionarioSelecionado.setDisable(false);
	}

	@FXML
	void abrirTelaFiliais(MouseEvent event) {
		paneFuncionarios.setVisible(false);
		paneFuncionarioSelecionado.setVisible(false);
		paneFiliais.setVisible(true);
		paneFilialSelecionada.setVisible(false);
		paneVeiculos.setVisible(false);
		paneVeiculoSelecionado.setVisible(false);
		paneSelecionarEntidade.setVisible(false);

		paneFuncionarios.setDisable(true);
		paneFuncionarioSelecionado.setDisable(true);
		paneFiliais.setDisable(false);
		paneFilialSelecionada.setDisable(true);
		paneVeiculos.setDisable(true);
		paneVeiculoSelecionado.setDisable(true);
		paneSelecionarEntidade.setDisable(true);

		desabilitarEdicao();
	}

	@FXML
	void abrirTelaFilialSelecionada(ActionEvent event) {
		paneFiliais.setVisible(false);
		paneFilialSelecionada.setVisible(true);

		paneFiliais.setDisable(true);
		paneFilialSelecionada.setDisable(false);
	}

	@FXML
	void abrirTelaVeiculos(MouseEvent event) {
		paneFuncionarios.setVisible(false);
		paneFuncionarioSelecionado.setVisible(false);
		paneFiliais.setVisible(false);
		paneFilialSelecionada.setVisible(false);
		paneVeiculos.setVisible(true);
		paneVeiculoSelecionado.setVisible(false);
		paneSelecionarEntidade.setVisible(false);

		paneFuncionarios.setDisable(true);
		paneFuncionarioSelecionado.setDisable(true);
		paneFiliais.setDisable(true);
		paneFilialSelecionada.setDisable(true);
		paneVeiculos.setDisable(false);
		paneVeiculoSelecionado.setDisable(true);
		paneSelecionarEntidade.setDisable(true);

		desabilitarEdicao();
	}

	@FXML
	void abrirTelaVeiculoSelecionado(ActionEvent event) {
		paneVeiculos.setVisible(false);
		paneVeiculoSelecionado.setVisible(true);

		paneVeiculos.setDisable(true);
		paneVeiculoSelecionado.setDisable(false);
	}

	void abrirTelaSelecionarEntidade() {
		paneFuncionarios.setVisible(false);
		paneFuncionarioSelecionado.setVisible(false);
		paneFiliais.setVisible(false);
		paneFilialSelecionada.setVisible(false);
		paneVeiculos.setVisible(false);
		paneVeiculoSelecionado.setVisible(false);
		paneSelecionarEntidade.setVisible(true);

		paneFuncionarios.setDisable(true);
		paneFuncionarioSelecionado.setDisable(true);
		paneFiliais.setDisable(true);
		paneFilialSelecionada.setDisable(true);
		paneVeiculos.setDisable(true);
		paneVeiculoSelecionado.setDisable(true);
		paneSelecionarEntidade.setDisable(false);
	}

	@FXML
	void habilitarEdicao(ActionEvent event) {
		tfNome.setDisable(false);
		tfCpf.setDisable(true);
		pfSenha.setDisable(false);
		cbCargo.setDisable(false);
		cbFilial.setDisable(false);
		cbTurno.setDisable(false);
		tfCargaHoraria.setDisable(false);
		btnSalvar.setDisable(false);
		btnDescartar.setDisable(false);
		textFieldEmail.setDisable(false);
		boxInfoExtraMotorista1.setDisable(false);
		textFieldSalarioMotorista.setDisable(false);
		boxInfoExtraMotorista2.setDisable(false);
	}

	void desabilitarEdicao() {
		tfNome.setDisable(true);
		tfCpf.setDisable(true);
		pfSenha.setDisable(true);
		cbCargo.setDisable(true);
		cbTurno.setDisable(true);
		cbFilial.setDisable(true);
		tfCargaHoraria.setDisable(true);
		btnSalvar.setDisable(true);
		btnDescartar.setDisable(true);
		textFieldEmail.setDisable(true);
		textFieldSalarioMotorista.setDisable(true);
		boxInfoExtraMotorista2.setDisable(true);
		boxInfoExtraMotorista1.setDisable(true);

		textFieldNomeFilial.setDisable(true);
		textFieldCidadeFilial.setDisable(true);
		comboBoxEstados.setDisable(true);
		textFieldCnpj.setDisable(true);
		textFieldRntrc.setDisable(true);
		botaoSalvarAlteracoesFilial.setDisable(true);
		botaoDescartarAlteracoesFilial.setDisable(true);

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
			case "Filial":
				salvarDadosAlteradosFilial(event);
				break;
			case "ExcluirFuncionario":
				excluirFuncionario(event);
				break;
			case "ExcluirFilial":
				excluirFilial(event);
				break;
			case "ExcluirVeiculo":
				excluirVeiculo(event);
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

	public void carregarTableViews() {
		Funcionario funcionario = new Funcionario();
		Filial filial = new Filial();
		Veiculo veiculo = new Veiculo();
		Motorista motorista = new Motorista();

		listaDeFuncionarios = funcionario.listarFuncionarios();
		listaDeFiliais = filial.listarFiliais();
		listaDeVeiculos = veiculo.listarVeiculos();
		listaDeMotoristas = motorista.listarMotoristas();
		
		listaTodosFuncionarios.addAll(listaDeFuncionarios);
		listaTodosFuncionarios.addAll(listaDeMotoristas);

		// Transforma a array primitiva em Observable Array
		obsListFuncionarios = FXCollections.observableArrayList(listaDeFuncionarios);
		obsListFiliais = FXCollections.observableArrayList(listaDeFiliais);
		obsListVeiculos = FXCollections.observableArrayList(listaDeVeiculos);
		obsListMotoristas = FXCollections.observableArrayList(listaDeMotoristas);

		// "Habilita" as colunas da tableView para receber o valor retornado da classe
		// Listas, nos seus métodos get
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		colunaCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));

		colunaIDFilial.setCellValueFactory(new PropertyValueFactory<>("id"));
		colunaFilial.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colunaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

		colunaIDVeiculo.setCellValueFactory(new PropertyValueFactory<>("id_rastreador"));
		colunaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));

		
		obsListFuncionarios.addAll(obsListMotoristas);
		// Adiciona a Observable Array na TableView
		tabelaFuncionarios.setItems(obsListFuncionarios);
		tabelaFiliais.setItems(obsListFiliais);
		tabelaVeiculos.setItems(obsListVeiculos);
	}

	public void carregarComboBox() {
		filiais = filial.listarFiliais();
		filiaisList = FXCollections.observableArrayList(filiais);
		cbFilial.setItems(filiaisList);
		comboBoxFilialVeiculo.setItems(filiaisList);
	}

	@FXML
	void atualizarLista(ActionEvent event) {
		atualizarInfos = true;
	}

	@FXML
	void abrirTelaCadFunc(MouseEvent event) {
		carregarComboBoxCargos();
		Main.trocarTela("Tela Cadastrar Funcionarios");
		abrirTelaSelecionarEntidade();
	}

	@FXML
	void abrirTelaHistEntregas(MouseEvent event) {
		Main.trocarTela("Tela Historico de Entregas");
		abrirTelaSelecionarEntidade();
	}
	
	@FXML
	void abrirTelaAvisos(MouseEvent event) {
		Main.trocarTela("Tela Avisos");
		abrirTelaSelecionarEntidade();
	}

	@FXML
	void abrirTelaEnt(MouseEvent event) {
		abrirTelaSelecionarEntidade();
	}

	@FXML
	void voltar(MouseEvent event) {
		if (paneSelecionarEntidade.isVisible()) {
			Main.trocarTela("Tela Boas Vindas");
		} else {
			if (paneFuncionarioSelecionado.isVisible()) {
				carregarComboBoxCargos();
				abrirTelaFuncionarios(event);
			} else if (paneFilialSelecionada.isVisible()) {
				abrirTelaFiliais(event);
			} else if (paneVeiculoSelecionado.isVisible()) {
				abrirTelaVeiculos(event);
			} else {
				abrirTelaSelecionarEntidade();
			}
		}
		desabilitarEdicao();
	}

	@FXML
	void minimizarJanela(ActionEvent event) {
		Main.minimizar();
	}

	@FXML
	void fecharJanela(ActionEvent event) {
		Main.trocarTela("Tela Login");
	}

	// --------------

    public void tarefasEmLoop() {
    	if(atualizarInfos) {
    		carregarTableViews();
    		carregarComboBox();
    		atualizarInfos = false;
    	}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		abrirTelaSelecionarEntidade();
		desabilitarEdicao();
		carregarComboBoxEstados();
		
		textfieldsDeCpf.add(campoDeBuscaCpf);
		textfieldsDeCpf.add(tfCpf);
		
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