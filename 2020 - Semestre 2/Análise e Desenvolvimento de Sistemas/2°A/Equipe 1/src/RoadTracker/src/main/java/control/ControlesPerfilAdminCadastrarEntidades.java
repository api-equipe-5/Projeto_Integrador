package control;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.*;
import view.*;

public class ControlesPerfilAdminCadastrarEntidades implements Initializable {
	
	@FXML
	private Label labelTipoDeCadastro;
	
	//Elementos da pane de avisos
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
    private Label labelDicaFlutuante;
    // ---------------------------
    
    
    //Elementos da pane de cadastro de funcionários
    @FXML
    private Pane paneCadastrarFuncionarios;
	@FXML
	private ComboBox<Cargos> cbCargo;
	@FXML
	private TextField tfNome;
	@FXML
	private TextField tfCpf;
	@FXML
	private PasswordField pfSenha1;
	@FXML
	private PasswordField pfSenha2;
	@FXML
	private ComboBox<Filiais> cbFilial;
	@FXML
	private TextField tfCargaHoraria;
	@FXML
	private CheckBox cbDomingo;
	@FXML
	private CheckBox cbSegunda;
	@FXML
	private CheckBox cbTerca;
	@FXML
	private CheckBox cbQuarta;
	@FXML
	private CheckBox cbQuinta;
	@FXML
	private CheckBox cbSexta;
	@FXML
	private CheckBox cbSabado;
    @FXML
    private ComboBox<Turnos> cbTurno;
    @FXML
    private TextField textFieldSalario;
    @FXML
    private Pane paneInfosExtrasMotorista;
    @FXML
    private TextField textFieldEmail;
	
    private List<Cargos> cargos = new ArrayList<>();
    private ObservableList<Cargos> cargosList;
    
    private List<Filiais> filiais = new ArrayList<>();
    private ObservableList<Filiais> filiaisList;
    
    private List<Turnos> turnos = new ArrayList<>();
    private ObservableList<Turnos> turnosList;
    
	private List<Funcionarios> listaTodosFuncionarios = new ArrayList<>();
	
	private boolean emailValido = true;
	
    // --------------------------------------------
    
	
    //Elementos da pane de cadastro de filiais
    @FXML
    private Pane paneCadastrarFiliais;
    @FXML
    private Button botaoCadastrarFilial;
    @FXML
    private TextField tfNomeFilial;
    @FXML
    private TextField tfCidadeFilial;
    @FXML
    private TextField tfCnpj;
    @FXML
    private TextField tfRntrc;
    @FXML
    private ComboBox<Estados> comboBoxEstados;
    
    private List<Estados> estados = new ArrayList<>();
    private ObservableList<Estados> obsListEstados;
    
    private String listaDeEstados[] = {"AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MG", "PA", "PB", "PR",
    								   "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF"};
    
    // ---------------------------------------
    
    
    //Elementos da pane de cadastro de veículos
    @FXML
    private Pane paneCadastrarVeiculos;
    @FXML
    private TextField textFieldMarcaRastreador;
    @FXML
    private TextField textFieldModeloRastreador;
    @FXML
    private TextField textFieldIDRastreador;
    @FXML
    private TextField textFieldPlacaVeiculo;
    @FXML
    private TextField textFieldModeloVeiculo;
    @FXML
    private ComboBox<Filiais> comboBoxEscolherFilialVeiculos;
    
	String caracteresValidos = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvXxWwYyZz-0123456789";
	String caracteresMaiusculosValidos = "ABCDEFGHIJKLMNOPQRSTUVXWYZ";
	String numerosValidos = "0123456789";
	char listaCaracteresValidos[] = caracteresValidos.toCharArray();
	char listaCaracteresMaiusculosValidos[] = caracteresMaiusculosValidos.toCharArray();
	
	private boolean placaValida = true;
	private boolean rastreadorValido = true;
    // ----------------------------------------
    
    
    //Elementos da pane de cadastro de viagens
    @FXML
    private Pane paneCadastrarViagens;
    @FXML
    private TextField tfEmpresaDestino;
    @FXML
    private TextField textFieldCarga;
    @FXML
    private DatePicker datePickerPrazoEntrega;
    @FXML
    private ComboBox<Veiculos> comboBoxVeiculoViagem;
    @FXML
    private ComboBox<Funcionarios> comboBoxMotoristaViagem;
    
    private List<Funcionarios> motoristas = new ArrayList<>();
    private ObservableList<Funcionarios> obsListMotoristas;
    
    private List<Veiculos> veiculos = new ArrayList<>();
    private ObservableList<Veiculos> obsListVeiculos;
    // ----------------------------------------
    
    
    //Elementos da pane para escolher tipo de cadastro
    @FXML
    private Pane paneEscolherTipoDeCadastro;
    // ----------------------------------------
    

    
    //Métodos da pane de cadastrar funcionário
    public void carregarComboBoxCargos() {
    	Funcionario funcionario = new Funcionario();
    	cargos = funcionario.listarCargos();
    	cargosList = FXCollections.observableArrayList(cargos);
    	cbCargo.setItems(cargosList);
    } 

    public void carregarComboBoxFiliais() {
    	Filial filial = new Filial();
    	filiais = filial.listarFiliais();
    	filiaisList = FXCollections.observableArrayList(filiais);
    	cbFilial.setItems(filiaisList);
    	comboBoxEscolherFilialVeiculos.setItems(filiaisList);
    }
    public void carregarComboBoxTurnos() {
    	Turnos t = new Turnos(0, null);
    	turnos = t.listarTurnos();
    	turnosList = FXCollections.observableArrayList(turnos);
    	cbTurno.setItems(turnosList);
    } 
    public void carregarComboBoxMotoristas() {
    	Motorista motorista = new Motorista();
    	motoristas = motorista.listarMotoristas();
    	obsListMotoristas = FXCollections.observableArrayList(motoristas);
    	comboBoxMotoristaViagem.setItems(obsListMotoristas);
    }
    public void carregarComboBoxVeiculos() {
    	Veiculo veiculo = new Veiculo();
    	veiculos = veiculo.listarVeiculos();
    	obsListVeiculos = FXCollections.observableArrayList(veiculos);
    	comboBoxVeiculoViagem.setItems(obsListVeiculos);
    }
    
	@FXML
	public void mascararCpf(KeyEvent event) {
		String texto = tfCpf.getText();
		String caracter = event.getCharacter();

		
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
			texto = texto.substring(0, texto.length());
		}
		
		if(texto.length() > 14) {
			texto = texto.substring(0, 14);
		}

		tfCpf.setText(texto);
		tfCpf.end();
		
		
	}

    @FXML
    void cadastrarFuncionario(MouseEvent event) {
    	int filial;
    	String nomeFilial;
    	// Todos os funcionários
    	String nome = tfNome.getText();
    	String cpf = tfCpf.getText();
    	String senha = pfSenha1.getText();
    	String senha2 = pfSenha2.getText();
    	String cargo = cbCargo.getValue().getCargo();
    	try {
        	filial = cbFilial.getValue().getId();
        	nomeFilial = cbFilial.getValue().getNome();
    	}
    	catch (Exception e) {
    		filial = 0;
    		nomeFilial = "Nulo";
    	}
    	String email = textFieldEmail.getText();
    	
    	// Verifica se o CPF é válido
    	boolean cpfValido = false;
    	if(!(cpf.length() < 14)) {
    		if(cpf.charAt(3) == '.' && cpf.charAt(7) == '.' && cpf.charAt(11) == '-') {
        		cpfValido = true;
    		}
    	}
    	
    	emailValido = true; // Reseta a váriavel para o valor padrão inicial
    	// boolean emailValido = false; (o comentário é só para ilustrar, pois como o forEach abaixo é algo local, é necessário
    	//declarar a váriavel emailValid globalmente, lá no início da classe
    	
    	// Verifica se o email está no formato de email
    	if(!email.contains("@") || !email.contains(".com")) {
    		emailValido = false;
    	}
    	
    	// Inicilamente o emailValido é true, e ao percorrer a lista, caso encontre um email igual, emailValido torna-se false
    	listaTodosFuncionarios.addAll(new Funcionario().listarFuncionarios());
    	listaTodosFuncionarios.addAll(new Motorista().listarMotoristas());
    	listaTodosFuncionarios.forEach(pessoa -> {
    		if(pessoa.getEmail().equals(email)) {
    			emailValido = false;
    		}
    	});
    	
    	
    	if(cpfValido && emailValido) {
        	Funcionario funcionario = new Funcionario();

    		// Primeiro verifica se o cpf não está sendo usado, depois verifica se o email não está sendo usado
        	if (cargo.equals("Administrador") || cargo.equals("Supervisor")) {
        		if (!nome.isBlank() && !cpf.isBlank() && !senha.isBlank() && !senha2.isBlank() && !cargo.isBlank() && !email.isBlank()  && filial != 0) {
	            	if(funcionario.encontrarFuncionario(cpf) == null) {
						if (senha.equals(senha2)) {
							boolean cadastro = funcionario.cadastrarFuncionario(nome, cpf, senha, cargo, filial, email);
	
							if (cadastro) {
								notificar("Sucesso de cadastro", "Funcionário cadastrado",
										"O " + cargo + " " + nome + " foi cadastrado com sucesso!");
								
								if(cargo.equals("Administrador")) {
									new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("AdmCad");
								}else {
									new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("SupCad");
								}
						
				        		new Filial().encontrarFilial(filial).incrementarMetadados("FncAss");
								
					    		Logs log = new Logs();
				        		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Cadastro de funcionário:"
				        				+ "\nNome: " + nome
				        				+ "\nCPF: " + cpf
				        				+ "\nE-mail: " + email
				        				+ "\nFilial: " + nomeFilial
				        				+ "\nCargo: " + cargo);
				        		
								limparCamposCadastrarFuncionariosFiliais();
								ControlesPerfilAdminEntidades.atualizarInfos = true;
							}
							else {
								notificar("Falha de cadastro", "Falha ao cadastrar funcionário",
										"Não foi possível realizar a ação de cadastro, confira os campos e tente novamente.");
							}
	
						}
						else {
							notificar("Falha de cadastro", "Falha ao cadastrar funcionário",
									"Não foi possível realizar a ação de cadastro, os campos da senha estão incorretos.");
						}
					}
	            	else {
						notificar("Falha de cadastro", "Falha ao cadastrar funcionário",
								"O CPF informado já está sendo utilizado por outro funcionário, "
										+ "por favor verifique o campo ou exclua o funcionário com o CPF em questão");
					}
        		}
        		else {
					notificar("Falha de cadastro", "Falha ao cadastrar funcionário",
							"Preencha todos os campos para cadastrar o funcionário.");
        		}
        	}
        	else {
        		String salario = textFieldSalario.getText();
        		String cargaHoraria = tfCargaHoraria.getText();
        		String turno = cbTurno.getValue().getTurno();
        		boolean dom = cbDomingo.isSelected();
        		boolean seg = cbSegunda.isSelected();
        		boolean ter = cbTerca.isSelected();
        		boolean qua = cbQuarta.isSelected();
        		boolean qui = cbQuinta.isSelected();
        		boolean sex = cbSexta.isSelected();
        		boolean sab = cbSabado.isSelected();
        		
        		Motorista motorista = new Motorista();
        		
        		// verificando se o usuário digitou um salário float com vírgula ou com ponto
        		for (int i = 0; i < salario.length(); i++) {
        			char caracter = salario.charAt(i);
        			if (caracter == ',') { // se for vírgula troca, pois o java só entende ponto
        				salario = salario.replace(',', '.');
        			}
        		}
        		
        		if (!nome.isBlank() && !cpf.isBlank() && !senha.isBlank() && !senha2.isBlank() && !cargo.isBlank() && !email.isBlank() && !salario.isBlank() && !cargaHoraria.isBlank() && filial != 0) {
	        		if (Float.parseFloat(salario) < 1701.38) {
	        			//verifica se o salário é menor que o piso
	        			notificar("Falha de cadastro", "Salário baixo", "O salário informado é inválido, "
	            				+ "por favor confira o campo e insira um salário maior");
	        		}
	        		else if (Integer.parseInt(cargaHoraria) > 8) {
	        			notificar("Falha de cadastro", "Carga horária", "A carga horária diária é 8 horas (sem aviso prévio). Verifique o valor e tente novamente.");
	        		}
	        		else {
	        			// Primeiro verifica se o cpf não está sendo usado, depois verifica se o email não está sendo usado
		        		if(motorista.encontrarMotorista(cpf) == null) {
							if (senha.equals(senha2)) {
								
								if (seg || ter || qua || qui || sex || sab || dom) {
									boolean cadastro = motorista.cadastrarMotorista(cpf, nome, email, senha, salario, cargaHoraria,
											filial, turno, seg, ter, qua, qui, sex, sab, dom, cargo);
									
									if (cadastro) {
										notificar("Sucesso de cadastro", "Funcionário cadastrado",
												"O " + cargo + " " + nome + " foi cadastrado com sucesso!");
										
										
										
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
										
										new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("MotCad");
										new Filial().encontrarFilial(filial).incrementarMetadados("FncAss");
										
							    		Logs log = new Logs();
						        		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Cadastro de motorista:"
						        				+ "\nNome: " + nome
						        				+ "\nCPF: " + cpf
						        				+ "\nE-mail: " + email
						        				+ "\nFilial: " + nomeFilial
						        				+ "\nSalário: R$ " + salario
						        				+ "\nCarga Horária: " + cargaHoraria
						        				+ "\nDias de trabalho: " + diasDeTrabalho);
										
										limparCamposCadastrarFuncionarios();
										ControlesPerfilAdminEntidades.atualizarInfos = true;
									}
									else {
										notificar("Falha de cadastro", "Falha ao cadastrar funcionário",
												"Não foi possível realizar a ação de cadastro, confira os campos e tente novamente.");
									}
								}
								else {
									notificar("Falha de cadastro", "Nenhum dia da semana selecionado",
											"O motorista, para ser cadastrado, precisa trabalhar ao menos um dia. Tente novamente.");
								}
							}
							else {
								notificar("Falha de cadastro", "Falha ao cadastrar",
										"As senhas estão incorretas, tente novamente");
							}
		            		
		        		}
		        		else {
		            		notificar("Falha de cadastro", "Falha ao cadastrar funcionário", 
		            				"O CPF informado já está sendo utilizado por outro motorista, "
		            				+ "por favor verifique o campo ou exclua o motorista com o CPF em questão");
		        		}
	        		}
        		}
        		else {
					notificar("Falha de cadastro", "Falha ao cadastrar funcionário",
							"Preencha todos os campos para cadastrar o funcionário.");
        		}
        	}
    	}
    	else {
    		if(!cpfValido) {
        		notificar("Falha de cadastro", "CPF inválido", "O CPF informado é inválido, "
        				+ "por favor confira o campo");
    		}
    		else if (!emailValido) {
        		notificar("Falha de cadastro", "E-mail inválido", "O e-mail informado é inválido ou já está sendo utilizado "
        				+ "por outro usuário");
    		}

    	}

    }
    // -----------------------------------
    
    // Métodos da pane para cadastro da filial 
	@FXML
	public void mascararCnpj(KeyEvent event) {
		String texto = tfCnpj.getText();
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
			texto = texto.substring(0, texto.length());
		}
		
		if(texto.length() > 19) {
			texto = texto.substring(0, 19);
		}

		tfCnpj.setText(texto);
		tfCnpj.end();
		
		
	}
    @FXML
    void cadastrarFilial(ActionEvent event) {
    	Filial f = new Filial();
    	List<Filial> fils = new ArrayList<>();
    	
    	String nome = tfNomeFilial.getText();
    	String cidade = tfCidadeFilial.getText();
    	String estado = comboBoxEstados.getSelectionModel().getSelectedItem().getEstado();
    	String cnpj = tfCnpj.getText();
    	String rntrc = tfRntrc.getText();
    	
    	boolean cnpjValido = false;
       	if(!(cnpj.length() < 19)) {
    		if(cnpj.charAt(2) == '.' && cnpj.charAt(6) == '.' && cnpj.charAt(10) == '/' && cnpj.charAt(16) == '-') {
    			cnpjValido = true;
    		}
    	}
       	
       	boolean cnpjRntrcRepetido = false;
       	fils = f.consultarTodasFiliais();
       	for (Filial fi : fils) {
			if (fi.getCnpj().equals(cnpj) || fi.getRntrc().equals(rntrc)) {
				cnpjRntrcRepetido = true;
				break;
			}
		}
       	
    	
    	//primeiro verifica se nenhum campo está nulo
    	if(nome.length() > 1 && cidade.length() > 1 && estado.length() > 1 && cnpjValido && rntrc.length() > 1) {
    		if (!cnpjRntrcRepetido) {
        		f.cadastrarFilial(nome, cidade, estado, cnpj, rntrc);
        		notificar("Sucesso de cadastro", "Filial cadastrada", "A filial " + nome + " foi cadastrada com sucesso!");
        		
        		new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("FilCad");
        		
        		Logs log = new Logs();
        		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Cadastro de filial:"
        				+ "\nNome: " + nome
        				+ "\nCNPJ: " + cnpj
        				+ "\nRNTRC: " + rntrc
        				+ "\nEstado: " + estado
        				+ "\nCidade: " + cidade);
        		
        		limparCamposCadastrarFiliais();
        		ControlesPerfilAdminEntidades.atualizarInfos = true;
        		ControlesPerfilAdminHistEntregas.atualizarInfos = true;
    		}
    		else {
    			notificar("Falha de cadastro", "Falha ao cadastrar a filial", "O RNTRC ou o CNPJ já pertencem a uma filial. Confira os campos.");
    		}
    	}
    	else{
    		notificar("Falha de cadastro", "Falha ao cadastrar a filial", "Verifique os campos");	
    	}
    	
    	
    	
    }
    
    @FXML
    public void mascararRntrc(KeyEvent event) {
    	String texto = tfRntrc.getText();
    	
    	if(texto.length() > 8) {
    		texto = texto.substring(0, 8);
    	}
    	
    	tfRntrc.setText(texto);
    	tfRntrc.end();
    }
    
    // ----------------------------------------
    
    
    
    // Métodos para cadastro de veículos
    @FXML
    public void mascararPlaca(KeyEvent event){
		String texto = textFieldPlacaVeiculo.getText();
		String caracter = event.getCharacter();
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
			
			textFieldPlacaVeiculo.setText(texto.toUpperCase());
			textFieldPlacaVeiculo.end();
		}

    }
    
    @FXML
    void cadastrarVeiculo(ActionEvent event) {
        	
        Veiculo veic = new Veiculo();
        
        try {
            String placa = textFieldPlacaVeiculo.getText();
            String modelo_veiculo = textFieldModeloVeiculo.getText();
            String id_rastreador = textFieldIDRastreador.getText();
            String marca_rastreador = textFieldMarcaRastreador.getText();
            String modelo_rastreador = textFieldModeloRastreador.getText();
        	int filial = comboBoxEscolherFilialVeiculos.getValue().getId();
        	String nomeFilial = comboBoxEscolherFilialVeiculos.getValue().getNome(); 
        	
        	placaValida = true;
        	rastreadorValido = true;
        	if(placa.length() == 8) {
        		if(caracteresMaiusculosValidos.contains(String.valueOf(placa.charAt(0))) && 
        				caracteresMaiusculosValidos.contains(String.valueOf(placa.charAt(1))) &&
        				caracteresMaiusculosValidos.contains(String.valueOf(placa.charAt(2))) &&
        				(placa.charAt(3) == '-') &&
        				numerosValidos.contains(String.valueOf(placa.charAt(4))) &&
        				numerosValidos.contains(String.valueOf(placa.charAt(5))) &&
        				numerosValidos.contains(String.valueOf(placa.charAt(6))) &&
        				numerosValidos.contains(String.valueOf(placa.charAt(7)))){

        			placaValida = true;
        		}
        	}
        	veiculos.forEach(veiculo -> {
        		if(veiculo.getPlaca().equals(placa)) {
        			placaValida = false;
        		}
        		if(String.valueOf(veiculo.getId_rastreador()).equals(id_rastreador)) {
        			rastreadorValido = false;
        		}
        	});
        	
        	if (placaValida) {
        		if (rastreadorValido) {
                	//primeiro verifica se nenhum campo está nulo (NÃO VERIFICA SE FOI SELECIONADO UMA FILIAL)
                	if(modelo_veiculo.length() >= 1 && marca_rastreador.length() >= 1 && modelo_rastreador.length() >= 1) {
                		veic.cadastrarVeiculo(placa, modelo_veiculo, id_rastreador, marca_rastreador, modelo_rastreador, filial);
                		
                		Logs log = new Logs();
                		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Cadastro de veículo:"
                				+ "\nPlaca: " + placa
                				+ "\nFilial: " + nomeFilial
                				+ "\nModelo do veículo: " + modelo_veiculo
                				+ "\nMarca do rastreador: " + marca_rastreador
                				+ "\nModelo do rastreador: " + modelo_rastreador
                				+ "\nID do rastreador: " + id_rastreador);
                		
                		new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("VeiCad");
                		new Filial().encontrarFilial(filial).incrementarMetadados("VeiAss");
                		
                		notificar("Sucesso de cadastro", "Veículo cadastrado", "O veículo com a placa " + placa + " foi cadastrado com sucesso!");
                		limparCamposCadastrarVeículos();
                		ControlesPerfilAdminEntidades.atualizarInfos = true;
                	}
                	else {
                		notificar("Falha de cadastro", "Veículo não foi cadastrado", "O veículo com a placa " + placa + " não pôde ser cadastrado. Verifique se todos os campos estão completos.");
                	}
        		}
        		else {
            		notificar("Falha de cadastro", "Veículo não foi cadastrado", "O rastreador informado já está em uso por outro veículo.");
        		}
        	}
        	else {
        		notificar("Falha de cadastro", "Veículo não foi cadastrado", "A placa inserida já existe no sistema.");
        	}
        }
        catch (NullPointerException falha) {
        	notificar("Falha de cadastro", "Falha ao cadastrar o veículo", "Preencha todos os campos.");	
        }
        	
    }
    // --------------------------------------------
    
    
    // Métodos da pane de cadastro de viagem
    @FXML
    void cadastrarViagem(ActionEvent event) {
    	Viagem viagem = new Viagem();
    	
    	String placaVeiculo = comboBoxVeiculoViagem.getSelectionModel().getSelectedItem().getPlaca();
    	
    	try {
        	int ano = datePickerPrazoEntrega.getValue().getYear();
        	int dia = datePickerPrazoEntrega.getValue().getDayOfMonth();
        	int mes = datePickerPrazoEntrega.getValue().getMonthValue();
        	
        	String prazo;
        	if(dia < 10) {
            	prazo = ("0" + String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano));
        	}
        	else {
            	prazo = (String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano));
        	}
        	
    		Date diaHoje = new Date();
    		int anoH = diaHoje.getYear() + 1900;
    		int mesH = diaHoje.getMonth() + 1;
    		int diaH = diaHoje.getDate();
        	
        	LocalDate dtHoje = LocalDate.of(anoH, mesH, diaH); 
        	LocalDate dtPicker = LocalDate.of(ano, mes, dia);
        	boolean prazoValido = dtPicker.isAfter(dtHoje) || dtPicker.isEqual(dtHoje);
        	
        	List<Viagem> viagens = new ArrayList<>();
        	viagens = viagem.consultarTodasViagens();
        	
        	boolean viagemRepetida = false;
        	for (Viagem v : viagens) {
				if (v.getFim().equals(prazo) && v.getVeiculo().getPlaca().equals(placaVeiculo) && !v.getSituacao().equals("Finalizado")) {
					viagemRepetida = true;
					break;
				}
			}
        	
        	
        	String cpfFuncionario = comboBoxMotoristaViagem.getSelectionModel().getSelectedItem().getCpf();
        	
	        	if (!viagemRepetida) {
	        		if(!prazoValido) {
	            		notificar("Falha de cadastro", "Prazo incorreto", "Você escolheu uma data de entrega que é anterior a data de hoje");	
	            	}
	        		else {
			        	if(prazoValido && prazo.length() > 1 && placaVeiculo.length() > 1 && tfEmpresaDestino.getText().length() > 1 && textFieldCarga.getText().length() > 1) {
			        		viagem.cadastrarViagem(prazo, tfEmpresaDestino.getText(), 
			    					   cpfFuncionario, placaVeiculo, 
			    					   textFieldCarga.getText());
			        		notificar("Sucesso de cadastro", "Viagem cadastrada", "A viagem foi cadastrada no sistema com sucesso!");
			        		
				    		Logs log = new Logs();
			        		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Cadastro de viagem:"
			        				+ "\nDestino: " + tfEmpresaDestino.getText()
			        				+ "\nCarga: " + textFieldCarga.getText()
			        				+ "\nPrazo: " + prazo
			        				+ "\nMotorista responsável: " + cpfFuncionario
			        				+ "\nPlaca do veículo atribuído: " + placaVeiculo);
			        		
			        		new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("VgmCad");
			        		new Motorista().encontrarMotorista(cpfFuncionario).incrementarMetadados("VgmAtt");
			        		
			        		limparCamposCadastrarViagens();
			        		ControlesPerfilAdminHistEntregas.atualizarInfos = true;
			        	}
			        	else {
			        		notificar("Falha de cadastro", "Campo incorreto", "Algum campo está incompleto. Tente novamente.");	
			        	}
	        		}
	        	}
	        	else {
					notificar("Falha de cadastro", "Viagem no mesmo dia", "Já existe uma viagem para esse dia que ainda não está terminada com esse mesmo veículo.");
	        	}
    	}
    	catch (NullPointerException falha) {
    		notificar("Falha de cadastro", "Falha ao cadastrar a viagem", "Preencha todos os campos.");	
    	}

    	

    	
    	
    }
    // ---------------------------------------
    


    
    // Métodos gerais
    @FXML
    void exibirDicaFlutuante(MouseEvent event) {
    	if(event.getTarget().toString().contains("tfEmpresaDestino")) {
        	labelDicaFlutuante.setText("Empresa de Destino");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldCarga")) {
        	labelDicaFlutuante.setText("Carga da Entrega");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("comboBoxMotoristaViagem")) {
        	labelDicaFlutuante.setText("Motorista");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("comboBoxVeiculoViagem")) {
        	labelDicaFlutuante.setText("Veículo");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("datePickerPrazoEntrega")) {
        	labelDicaFlutuante.setText("Prazo");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldMarcaRastreador")) {
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
    	}else if (event.getTarget().toString().contains("comboBoxEscolherFilialVeiculos")) {
        	labelDicaFlutuante.setText("Filial");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("tfNomeFilial")) {
        	labelDicaFlutuante.setText("Nome da Filial");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("tfCidadeFilial")) {
        	labelDicaFlutuante.setText("Cidade da Filial");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("comboBoxEstados")) {
        	labelDicaFlutuante.setText("Estado da Filial (Sigla)");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("tfCnpj")) {
        	labelDicaFlutuante.setText("CNPJ");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("cbCargo")) {
        	labelDicaFlutuante.setText("Cargo");
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
    	}else if (event.getTarget().toString().contains("pfSenha1")) {
        	labelDicaFlutuante.setText("Senha");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("pfSenha2")) {
        	labelDicaFlutuante.setText("Confirme a senha");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("cbFilial")) {
        	labelDicaFlutuante.setText("Filial");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("cbTurno")) {
        	labelDicaFlutuante.setText("Turno");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("tfCargaHoraria")) {
        	labelDicaFlutuante.setText("Carga Horária");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldSalario")) {
        	labelDicaFlutuante.setText("Salário");
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
    void abrirTelaFunc(MouseEvent event) {
    	labelTipoDeCadastro.setText("Cadastrar Entidades");
    	Main.trocarTela("Tela Funcionarios");
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	voltarTelaEscolhas();
    }
    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {
    	labelTipoDeCadastro.setText("Cadastrar Entidades");
    	Main.trocarTela("Tela Historico de Entregas");
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	voltarTelaEscolhas();
    }
	@FXML
	void abrirTelaAvisos(MouseEvent event) {
		Main.trocarTela("Tela Avisos");
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	voltarTelaEscolhas();
	}
    @FXML
    void voltar(ActionEvent event) {   	
    	labelTipoDeCadastro.setText("Cadastrar Entidades");
    	if(paneEscolherTipoDeCadastro.isVisible()) {
    		Main.trocarTela("Tela Boas Vindas");
    	}
    	else {  	
    		voltarTelaEscolhas();
    	}
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
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
    void abrirTelaCadastrarFuncionarios(MouseEvent event){
    	paneCadastrarVeiculos.setVisible(false);
    	paneCadastrarFiliais.setVisible(false);
    	paneCadastrarViagens.setVisible(false);
    	paneCadastrarFuncionarios.setVisible(true);
    	paneEscolherTipoDeCadastro.setVisible(false);
    	
    	paneCadastrarVeiculos.setDisable(true);
    	paneCadastrarFiliais.setDisable(true);
    	paneCadastrarViagens.setDisable(true);
    	paneCadastrarFuncionarios.setDisable(false);
    	paneEscolherTipoDeCadastro.setDisable(true);
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	
    	paneInfosExtrasMotorista.setDisable(true);
    	paneInfosExtrasMotorista.setVisible(false);
    	
    	carregarComboBoxFiliais();
    	
    	labelTipoDeCadastro.setText("Cadastro de Funcionários");
    }
    @FXML
    void abrirTelaCadastrarFiliais(MouseEvent event){
    	paneCadastrarVeiculos.setVisible(false);
    	paneCadastrarFiliais.setVisible(true);
    	paneCadastrarViagens.setVisible(false);
    	paneCadastrarFuncionarios.setVisible(false);
    	paneEscolherTipoDeCadastro.setVisible(false);
    	
    	paneCadastrarVeiculos.setDisable(true);
    	paneCadastrarFiliais.setDisable(false);
    	paneCadastrarViagens.setDisable(true);
    	paneCadastrarFuncionarios.setDisable(true);
    	paneEscolherTipoDeCadastro.setDisable(true);
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	
    	labelTipoDeCadastro.setText("Cadastro de Filiais");
    }
    @FXML
    void abrirTelaCadastrarVeiculos(MouseEvent event){
    	paneCadastrarVeiculos.setVisible(true);
    	paneCadastrarFiliais.setVisible(false);
    	paneCadastrarViagens.setVisible(false);
    	paneCadastrarFuncionarios.setVisible(false);
    	paneEscolherTipoDeCadastro.setVisible(false);
    	
    	paneCadastrarVeiculos.setDisable(false);
    	paneCadastrarFiliais.setDisable(true);
    	paneCadastrarViagens.setDisable(true);
    	paneCadastrarFuncionarios.setDisable(true);
    	paneEscolherTipoDeCadastro.setDisable(true);
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	
    	carregarComboBoxFiliais();
    	
    	labelTipoDeCadastro.setText("Cadastro de Veículos");
    }
    @FXML
    void abrirTelaCadastrarViagens(MouseEvent event){
    	paneCadastrarVeiculos.setVisible(false);
    	paneCadastrarFiliais.setVisible(false);
    	paneCadastrarViagens.setVisible(true);
    	paneCadastrarFuncionarios.setVisible(false);
    	paneEscolherTipoDeCadastro.setVisible(false);
    	
    	paneCadastrarVeiculos.setDisable(true);
    	paneCadastrarFiliais.setDisable(true);
    	paneCadastrarViagens.setDisable(false);
    	paneCadastrarFuncionarios.setDisable(true);
    	paneEscolherTipoDeCadastro.setDisable(true);
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	
    	carregarComboBoxVeiculos();
    	carregarComboBoxMotoristas();
    	
    	labelTipoDeCadastro.setText("Cadastro de Viagens");
    }
    @FXML
    void voltarParaTelaDeEscolhas(MouseEvent event) {
    	paneCadastrarVeiculos.setVisible(false);
    	paneCadastrarFiliais.setVisible(false);
    	paneCadastrarViagens.setVisible(false);
    	paneCadastrarFuncionarios.setVisible(false);
    	paneEscolherTipoDeCadastro.setVisible(true);
    	
    	paneCadastrarVeiculos.setDisable(true);
    	paneCadastrarFiliais.setDisable(true);
    	paneCadastrarViagens.setDisable(true);
    	paneCadastrarFuncionarios.setDisable(true);
    	paneEscolherTipoDeCadastro.setDisable(false);
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	
    	labelTipoDeCadastro.setText("Cadastrar Entidades");
    }
    
    public void voltarTelaEscolhas() {
    	paneCadastrarVeiculos.setVisible(false);
    	paneCadastrarFiliais.setVisible(false);
    	paneCadastrarViagens.setVisible(false);
    	paneCadastrarFuncionarios.setVisible(false);
    	paneEscolherTipoDeCadastro.setVisible(true);
    	
    	paneCadastrarVeiculos.setDisable(true);
    	paneCadastrarFiliais.setDisable(true);
    	paneCadastrarViagens.setDisable(true);
    	paneCadastrarFuncionarios.setDisable(true);
    	paneEscolherTipoDeCadastro.setDisable(false);
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	
    	labelTipoDeCadastro.setText("Cadastrar Entidades");
    }
    
    
    void notificar(String tipoDeAviso, String titulo, String texto) {
    	paneAvisosPrincipal.setDisable(false);
    	paneAvisosPrincipal.setVisible(true);
    	paneAvisosSombra.setVisible(true);
    	paneAvisosSombra.setDisable(false);
    	switch(tipoDeAviso){
    		case "Sucesso de cadastro":
    			paneAvisosSucesso.setDisable(false);
    			paneAvisosSucesso.setVisible(true);
    			labelAvisosTextoSucesso.setText(texto);
    			labelAvisosTituloSucesso.setText(titulo);
    			break;
    		case "Falha de cadastro":
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
    
    @FXML
    public void ajustarEscolhaDoCargo(ActionEvent event) {
    	String escolha = cbCargo.getValue().getCargo();
    	
    	if(escolha.equals("Motorista")) {
    		paneInfosExtrasMotorista.setDisable(false);
    		paneInfosExtrasMotorista.setVisible(true);
    	}
    	else {
    		paneInfosExtrasMotorista.setDisable(true);
    		paneInfosExtrasMotorista.setVisible(false);
    	}
    }
    
    public void limparCamposCadastrarFiliais() {
    	tfNomeFilial.setText("");
    	tfCidadeFilial.setText("");
    	comboBoxEstados.getSelectionModel().selectFirst();
    	tfCnpj.setText("");
    	tfRntrc.setText("");
    }
    public void limparCamposCadastrarFuncionarios() {
     	tfNome.setText("");
    	tfCpf.setText("");
    	tfCargaHoraria.setText("");
    	pfSenha1.setText("");
    	pfSenha2.setText("");
    	cbDomingo.setSelected(false);
    	cbSegunda.setSelected(false);
    	cbTerca.setSelected(false);
    	cbQuarta.setSelected(false);
    	cbQuinta.setSelected(false);
    	cbSexta.setSelected(false);
    	cbSabado.setSelected(false);
    	textFieldSalario.setText("");
    	cbTurno.getSelectionModel().clearSelection();
    	cbFilial.getSelectionModel().clearSelection();
    	cbCargo.getSelectionModel().selectLast();
    	textFieldEmail.setText("");
    }
    public void limparCamposCadastrarFuncionariosFiliais() {
     	tfNome.setText("");
    	tfCpf.setText("");
    	pfSenha1.setText("");
    	pfSenha2.setText("");
    	cbFilial.getSelectionModel().clearSelection();
    	cbCargo.getSelectionModel().selectLast();
    	textFieldEmail.setText("");
    }
    public void limparCamposCadastrarVeículos() {
    	textFieldMarcaRastreador.setText("");
    	textFieldModeloRastreador.setText("");
    	textFieldIDRastreador.setText("");
        textFieldPlacaVeiculo.setText("");
        textFieldModeloVeiculo.setText("");
    	
    }
    public void limparCamposCadastrarViagens() {
    	tfEmpresaDestino.setText("");
    	textFieldCarga.setText("");
    	datePickerPrazoEntrega.setValue(LocalDate.now());
    }
    
    
    void carregarComboBoxEstados() {
    	estados.add(new Estados("Selecione um estado..."));
    	
    	for(int i = 0; i < listaDeEstados.length; i++) {
    		estados.add(new Estados(listaDeEstados[i]));
    	}
    	
    	obsListEstados = FXCollections.observableArrayList(estados);
    	
    	comboBoxEstados.setItems(obsListEstados);
    	
    }
    
//    @FXML
//    void tamanhoRntrc(KeyEvent event) {
//
//    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarComboBoxCargos();
		carregarComboBoxFiliais();
		carregarComboBoxTurnos();
		carregarComboBoxMotoristas();
		carregarComboBoxVeiculos();
		carregarComboBoxEstados();
	}
}
