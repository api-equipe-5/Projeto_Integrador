package control;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.ConnectionFactory;
import model.Filial;
import model.Funcionario;
import model.Motorista;
import model.Viagem;
import view.Cargos;
import view.Main;


public class ControlesLogin implements Initializable{
	
	public static String senha;
	public static String cpfLogado;
	public static String nomeLogado;
	
    @FXML
    private TextField inputUsuario;
    @FXML
    private PasswordField inputSenha;
    @FXML
    private Button botaoEntrar;
    @FXML
    private AnchorPane janela;
    @FXML
    private Label labelDicaFlutuante;
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
    private Pane trocaSenha;
    @FXML
    private Pane paneLogin;
    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfCpf;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private PasswordField pfSenha1;
    @FXML
    private PasswordField pfSenha2;
    @FXML
    private ComboBox<Cargos> cbCargos;
    @FXML
    private Pane paneAvisosSucesso;
    @FXML
    private Label labelAvisosTextoSucesso;
    @FXML 
    private Label labelAvisosTituloSucesso;
    
	private String cargoFuncionario;
    
	private static Funcionario funcionario = new Funcionario();
	private List<Cargos> cargos = new ArrayList<>();
	private ObservableList<Cargos> cargosList;
	
    
    @FXML
    void verificarLogin(ActionEvent event) {
    	Funcionario funcionario = new Funcionario();
    	Motorista motorista = new Motorista();
    	
    	String loginDado = inputUsuario.getText();
    	String senhaDada = inputSenha.getText();
    	
    	String cpfFunc = funcionario.verificarLogin(loginDado);
    	String cpfMot = motorista.verificarLogin(loginDado);
    	
    	
    	funcionario = funcionario.encontrarFuncionario(cpfFunc);
    	motorista = motorista.encontrarMotorista(cpfMot);
    	
    	
    	// A sequência de ifs abaixo pode ser um pouco confusa, mas, resumindo, ela verifica se foi encontrado pelo menos 1 dos cpfs,
    	// se for, então verifica qual tipo de cpf foi logado
    	if(cpfFunc.equals("Não encontrado") && cpfMot.equals("Não encontrado")){
    		notificar("Falha", "Usuário não encontrado", "Nenhum usuário foi encontrado. Verifique os dados.");
    	}
    	else {
    		if(cpfMot.equals("Não encontrado")) {
    			if(funcionario.getSenha().equals(senhaDada)) {
    				senha = senhaDada;
    				cpfLogado = funcionario.getCpf();
    				nomeLogado = funcionario.getNome();
    				
    				if (funcionario.getCargo().equals("Supervisor")) {
    					Main.trocarTela("Tela Inicial Supervisor");
    					ControlesPerfilSuperEntregas.atualizarTableViewEComboBox = true;
    					ControlesPerfilSuperEntidades.atualizarTableViewEComboBox = true;
    					ControlesPerfilSuperAvisos.atualizarInfos = true;
    				}
    				else {
    					Main.trocarTela("Tela Boas Vindas");
    				}
    				
                	inputUsuario.setText("");
                	inputSenha.setText("");
                	ControlesPerfilAdminEntidades.atualizarInfos = true;
                	ControlesPerfilAdminHistEntregas.atualizarInfos = true;
                	ControlesPerfilAdminAvisos.carregarInfos = true;
    			}
    			else {
    				notificar("Falha", "Senha incorreta.", "A senha está incorreta. Tente novamente.");
    			}
    		}
    		else if (cpfFunc.equals("Não encontrado")) {
	    		if(motorista.getSenha().equals(senhaDada)) {
	    			senha = senhaDada;
	    			cpfLogado = motorista.getCpf();
	    			nomeLogado = motorista.getNome();
		        	Main.trocarTela("Viagem Selecionada");
		        	inputUsuario.setText("");
		        	inputSenha.setText("");
		        	motorista.resetarDiaDeTrabalho();
		        	ControlesPerfilMotViagemAtual.carregarViagem = true;
		        	ControlesPerfilMotViagens.carregarTableView = true;
	    		}
	    		else {
    				notificar("Falha", "Senha incorreta.", "A senha está incorreta. Tente novamente.");
    			}
    		}
    	}
    }

    @FXML
    void exibirDicaFlutuante(MouseEvent event) {
    	if(event.getTarget().toString().contains("inputUsuario")) {
        	labelDicaFlutuante.setText("E-mail");
        	labelDicaFlutuante.setVisible(true);
    	}
    	else if (event.getTarget().toString().contains("inputSenha")) {
        	labelDicaFlutuante.setText("Senha");
        	labelDicaFlutuante.setVisible(true);
    	}
    	else if (event.getTarget().toString().contains("tfCpf")) {
        	labelDicaFlutuante.setText("CPF");
        	labelDicaFlutuante.setVisible(true);
    	}
    	else if (event.getTarget().toString().contains("tfNome")) {
        	labelDicaFlutuante.setText("Nome");
        	labelDicaFlutuante.setVisible(true);
    	}
    	else if (event.getTarget().toString().contains("pfSenha1")) {
        	labelDicaFlutuante.setText("Nova senha");
        	labelDicaFlutuante.setVisible(true);
    	}
    	else if (event.getTarget().toString().contains("pfSenha2")) {
        	labelDicaFlutuante.setText("Confirmar nova senha");
        	labelDicaFlutuante.setVisible(true);
    	}
    	else if (event.getTarget().toString().contains("textFieldEmail")) {
        	labelDicaFlutuante.setText("E-mail");
        	labelDicaFlutuante.setVisible(true);
    	}
    	else if (event.getTarget().toString().contains("cbCargos")) {
        	labelDicaFlutuante.setText("Cargo");
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
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }
    
    // Função para fechar a janela ao clicar no " x "
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }
    
    @FXML //muda para pane de trocar senha
    void esqueceuSenha(MouseEvent event) {
    	trocaSenha.setVisible(true);
    	trocaSenha.setDisable(false);
    	paneLogin.setVisible(false);
    	paneLogin.setDisable(true);
    	inputSenha.setText("");
    	inputUsuario.setText("");
    	tfCpf.setText("");
    	tfNome.setText("");
    	pfSenha1.setText("");
    	pfSenha2.setText("");
    	textFieldEmail.setText("");
    	cbCargos.getSelectionModel().selectFirst();
    }
    
    @FXML
    void confirmarTroca(ActionEvent event) {
    	Funcionario funcionario = new Funcionario();
    	Motorista motorista = new Motorista();
    	
    	String email = textFieldEmail.getText();
    	String senha1 = pfSenha1.getText();
    	String senha2 = pfSenha2.getText();
    	String cpf = tfCpf.getText();
    	String nome = tfNome.getText().toLowerCase();
    	cargoFuncionario = cbCargos.getSelectionModel().getSelectedItem().getCargo();

    	if(cargoFuncionario.equals("Motorista")) {
    		motorista = motorista.encontrarMotorista(cpf);
    		if(motorista != null) {
    			if (senha1.equals(senha2)) {
	    			if(motorista.getEmail().equals(email) && motorista.getNome().toLowerCase().equals(nome) && senha1.equals(senha2) && motorista.getCpf().equals(cpf)) {
	    				motorista.alterarSenhaMot(senha2);
	    				notificar("Sucesso", "Senha alterada", "Sua senha foi alterada com sucesso! Você já pode realizar seu login.");
	    				limparCampos();
	    			}
	    			else {
	        			notificar("Falha", "Informação incorreta", "As informações de confirmação exigidas estão incorretas");
	    			}
    			}
    			else {
    				notificar("Falha", "Senhas não correspondem", "As senhas digitadas não estão iguais. Digite novamente.");
    			}
    		}
    		else {
    			notificar("Falha", "Informação incorreta", "Não foi possível encontrar nenhum funcionário com o CPF informado, por "
    					+ "favor verifique o campo e tente novamente");
    		}
    	}
    	else if(cargoFuncionario.equals("Administrador") || cargoFuncionario.equals("Supervisor")){
    		funcionario = funcionario.encontrarFuncionario(cpf);
    		if(funcionario != null) {
    			if (senha1.equals(senha2)) {
	    			if(funcionario.getEmail().equals(email) && funcionario.getNome().toLowerCase().equals(nome) && senha1.equals(senha2) && funcionario.getCpf().equals(cpf)) {
	    				funcionario.alterarSenhaFunc(senha2);
	    				notificar("Sucesso", "Senha alterada", "Sua senha foi alterada com sucesso! Você já pode realizar seu login.");
	    				limparCampos();
	    			}
	    			else {
	        			notificar("Falha", "Informação incorreta", "As informações de confirmação exigidas estão incorretas");
	    			}
    			}
    			else {
    				notificar("Falha", "Senhas não correspondem", "As senhas digitadas não estão iguais. Digite novamente.");
    			}
    		}
    		else {
    			notificar("Falha", "Informação incorreta", "Não foi possível encontrar nenhum funcionário com o CPF informado, por "
    					+ "favor verifique o campo e tente novamente");
    		}
    	}
    	else {
			notificar("Falha", "Informação incorreta", "As informações de confirmação exigidas estão incorretas");
    	}
    }
    
	public void carregarComboBoxCargos() {
		cargos = funcionario.listarCargos();
		cargos.add(0, new Cargos(0, "Selecione um cargo..."));
		cargosList = FXCollections.observableArrayList(cargos);
		cbCargos.setItems(cargosList);
    	cbCargos.getSelectionModel().selectFirst();
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
    
	@FXML
	void voltar(ActionEvent event) {
    	trocaSenha.setVisible(false);
    	trocaSenha.setDisable(true);
    	paneLogin.setVisible(true);
    	paneLogin.setDisable(false);
	}
	
	public void verificarViagensAtrasadas() {
		
		// data de hoje
		Date diaHoje = new Date();
		int anoH = diaHoje.getYear() + 1900;
		int mesH = diaHoje.getMonth() + 1;
		int diaH = diaHoje.getDate();
		LocalDate dtHojeV = LocalDate.of(anoH, mesH, diaH);
		LocalDate dtViagem = null;
		
		// fazendo a verificação de cada viagem a partir de uma consulta no banco
		Viagem v = new Viagem();
		
		List<Viagem> viagens = null;
		viagens = v.consultarTodasViagens(); // todas as viagens vão para uma lista
		
		for (Viagem viagem: viagens) {
			// fazendo a comparação da data da viagem com o dia atual
			
			int anoV = Integer.parseInt(viagem.getFim().substring(6, 10)); // pegando a String do banco e dividindo
			int mesV = Integer.parseInt(viagem.getFim().substring(3, 5));
			int diaV = Integer.parseInt(viagem.getFim().substring(0, 2));
			
			dtViagem = LocalDate.of(anoV, mesV, diaV);
			boolean atrasada = dtViagem.isBefore(dtHojeV);
			
			if (atrasada && viagem.getSituacao().equals("Não iniciado")) {
				EntityManager con = new ConnectionFactory().getConnection();	
				try {
					con.getTransaction().begin();
					Query query = con.createNativeQuery("update viagens set situacao = :situacao where id = :idViagem");
					query.setParameter("situacao", "Atrasado");
					query.setParameter("idViagem", viagem.getId());
					query.executeUpdate();
					con.getTransaction().commit();
				}
				catch (Exception e) {
					System.err.println(e);
					con.getTransaction().rollback();
				}
				finally {
					con.close();
				}
			}
		}
	}
	
	void limparCampos () {
		textFieldEmail.setText("");
		pfSenha1.setText("");
		pfSenha2.setText("");
		tfCpf.setText("");
		tfNome.setText("");
		cbCargos.getSelectionModel().selectLast();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Funcionario func = new Funcionario();
		Filial filial = new Filial();
		
		// Verifica se já existe uma Filial no banco de dados para cadastrar o admin root
		if(!(filial.encontrarFilial(1) != null)) {
			filial.cadastrarFilial("Filial Central", "São José dos Campos", "SP", "00.000.000/0000-00", "00000000");
		}
		
		// Verifica se já existe a conta do admin root, se não, a cria
		if(!(func.encontrarFuncionario("000.000.000-00") != null)) {
			func.cadastrarFuncionario("Admin User", "000.000.000-00", "root", "Administrador", 1, "adminuser@root.com");
		}
		carregarComboBoxCargos();
		verificarViagensAtrasadas();
	}

}
