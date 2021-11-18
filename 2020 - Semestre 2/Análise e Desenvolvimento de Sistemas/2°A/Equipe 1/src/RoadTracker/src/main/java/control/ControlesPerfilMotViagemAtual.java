package control;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Logs;
import model.Motorista;
import model.Viagem;
import view.Main;
import view.Viagens;

public class ControlesPerfilMotViagemAtual implements Initializable {
	 
	 Viagem viagemAtual = null;
	
	 public static boolean cronometrarTempoTotal = false;
	 public static boolean cronometrarExpDiario = false;
	 public static boolean cronometrarDescDiario = false;
	 public static boolean cronometrarAlimDiaria = false;
	 public static boolean carregarViagem = false;
	 public static boolean pausarViagem = false;
	 public static boolean descansoObrigatorio = false;
	 private boolean alimMaxAtingido = false;
	 private boolean descMaxAtingido = false;
	 public int tempototal = 0;
    
	 @FXML
	 private Label labelDestino;
	 @FXML
	 private Label labelPlaca;
	 @FXML
	 private Label labelPrazo;
	 @FXML
	 private Label labelHorasTotais;
	 @FXML
	 private Label labelCarga;
	 @FXML
	 private Label labelSituacao;
	 @FXML
	 private Label labelAtencao;
	 @FXML
	 private Button botaoExpediente;
	 @FXML
	 private Label labelExpMax;
	 @FXML
	 private Label labelExpHoje;
	 @FXML
	 private Button botaoAlimentacao;
	 @FXML
	 private Label labelAlimMax;
	 @FXML
	 private Label labelAlimHoje;
	 @FXML
	 private Button botaoDescanso;
	 @FXML
	 private Label labelDescMax;
	 @FXML
	 private Label labelDescHoje;
	 @FXML
	 private Button botaoFinalizarViagem;
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
	 
	 
	void notificar(String tipoDeAviso, String titulo, String texto) {
			paneAvisosPrincipal.setDisable(false);
			paneAvisosPrincipal.setVisible(true);
			paneAvisosSombra.setVisible(true);
			paneAvisosSombra.setDisable(false);
			
			switch (tipoDeAviso) {
			case "Pausa":
				paneAvisosFalha.setDisable(false);
				paneAvisosFalha.setVisible(true);
				labelAvisosTextoFalha.setText(texto);
				labelAvisosTituloFalha.setText(titulo);
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
    public void iniciarExpediente(ActionEvent event) {	
    	cronometrarTempoTotal = true;
    	cronometrarExpDiario = true;
    	botaoExpediente.setText("Pausar expediente");
    	botaoExpediente.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
    			finalizarExpediente(event);
    		}
    	});
    	
    	botaoAlimentacao.setDisable(true);
    	botaoDescanso.setDisable(true);
    }
    @FXML
    public void finalizarExpediente(ActionEvent event) {	
    	cronometrarTempoTotal = false;
    	cronometrarExpDiario = false;
    	botaoExpediente.setText("Iniciar expediente");
    	botaoExpediente.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
    			iniciarExpediente(event);
    		}
    	});
    	
    	botaoAlimentacao.setDisable(false);
    	botaoDescanso.setDisable(false);
    	
    	atualizarTempos();
    }
    
    
    @FXML
    public void pausaDescanso(ActionEvent event) {	
    	cronometrarDescDiario = true;
    	
    	botaoDescanso.setText("Pausar descanso");
    	botaoDescanso.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
    			voltaDescanso(event);
    		}
    	});
    	
    	botaoExpediente.setDisable(true);
    	botaoAlimentacao.setDisable(true);
    	
    }
    @FXML
    public void voltaDescanso(ActionEvent event) {	
    	cronometrarDescDiario = false;
    	
    	botaoDescanso.setText("Pausa para descanso");
    	botaoDescanso.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
    			pausaDescanso(event);
    		}
    	});
    	
    	botaoExpediente.setDisable(false);
    	botaoAlimentacao.setDisable(false);
    	
    	atualizarTempos();
    	
    }
    
    
    @FXML
    public void pausaAlimentacao(ActionEvent event) {	
    	cronometrarAlimDiaria = true;
    	
    	botaoAlimentacao.setText("Pausar alimentação");
    	botaoAlimentacao.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
    			voltaAlimentacao(event);
    		}
    	});
    	
    	botaoExpediente.setDisable(true);
    	botaoDescanso.setDisable(true);
    	
    }
    @FXML
    public void voltaAlimentacao(ActionEvent event) {	
    	cronometrarAlimDiaria = false;
    	
    	botaoAlimentacao.setText("Pausa para alimentação");
    	botaoAlimentacao.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
    			pausaAlimentacao(event);
    		}
    	});
    	
    	botaoExpediente.setDisable(false);
    	botaoDescanso.setDisable(false);
    	
    	atualizarTempos();
    	
    }
    
    void atualizarTempos() {
    	if (viagemAtual != null) {
	    	Viagem viagem = new Viagem();
	    	Motorista motorista = new Motorista();
	    	
	    	viagem = viagem.encontrarViagem(viagemAtual.getId());
	    	motorista = motorista.encontrarMotorista(ControlesLogin.cpfLogado);
			
	    	
	  	  	String tempoAtual[] = labelHorasTotais.getText().split(":");
	  	  	String segundos = tempoAtual[3];
	  	  	String minutos = tempoAtual[2];
	  	  	String horas = tempoAtual[1].substring(1);
	  	  	String tempoTotal = horas + ":" + minutos + ":" + segundos;
	  	  	
	
	  	  	String segundosExpHoje =  "00";
	  	  	String minutosExpHoje = "00";
	  	  	String horasExpHoje = "00";
	  	  	String tempoTotalExpHoje = horasExpHoje + ":" + minutosExpHoje + ":" + segundosExpHoje;
	  	  	if(!labelExpHoje.getText().contains("0h")) {
	  	  	  	String expHojeAtual[] = labelExpHoje.getText().split(":");
	  	  	  	segundosExpHoje = expHojeAtual[3];
	  	  	  	minutosExpHoje = expHojeAtual[2];
	  	  	  	horasExpHoje = expHojeAtual[1].substring(1);
	  	  	  	tempoTotalExpHoje = horasExpHoje + ":" + minutosExpHoje + ":" + segundosExpHoje;
	  	  	}
	
	  	  	String segundosAlimHoje = "00";
	  	  	String minutosAlimHoje = "00";
	  	  	String horasAlimHoje = "00";
	  	  	String tempoTotalAlimHoje = horasAlimHoje + ":" + minutosAlimHoje + ":" + segundosAlimHoje;
	  	  	if(!labelAlimHoje.getText().contains("0h")) {
	  	  	  	String alimHojeAtual[] = labelAlimHoje.getText().split(":");
	  	  	  	segundosAlimHoje = alimHojeAtual[3];
	  	  	  	minutosAlimHoje = alimHojeAtual[2];
	  	  	  	horasAlimHoje = alimHojeAtual[1].substring(1);
	  	  	  	tempoTotalAlimHoje = horasAlimHoje + ":" + minutosAlimHoje + ":" + segundosAlimHoje;
	  	  	}
	  	  
	  	  	String segundosDescHoje = "00";
	  	  	String minutosDescHoje = "00";
	  	  	String horasDescHoje = "00";
	  	  	String tempoTotalDescHoje = horasDescHoje + ":" + minutosDescHoje + ":" + segundosDescHoje;
	  	  	if(!labelDescHoje.getText().contains("0h")) {
	  	  	  	String descHojeAtual[] = labelDescHoje.getText().split(":");
	  	  	  	segundosDescHoje = descHojeAtual[3];
	  	  	  	minutosDescHoje = descHojeAtual[2];
	  	  	  	horasDescHoje = descHojeAtual[1].substring(1);
	  	  	  	tempoTotalDescHoje = horasDescHoje + ":" + minutosDescHoje + ":" + segundosDescHoje;
	  	  	}
	
			viagem.atualizarHorasTotais(tempoTotal);
			motorista.atualizarTempos(tempoTotalExpHoje, tempoTotalAlimHoje, tempoTotalDescHoje);
    	}
    }
    
    @FXML
    public void finalizarViagem(ActionEvent event) {	
    	Viagem viagem = new Viagem();
    	Motorista motorista = new Motorista();
    	
    	viagem = viagem.encontrarViagem(viagemAtual.getId());
    	motorista = motorista.encontrarMotorista(ControlesLogin.cpfLogado);
    	
    	botaoAlimentacao.setDisable(true);
    	botaoDescanso.setDisable(true);
    	botaoExpediente.setDisable(true);
		botaoFinalizarViagem.setDisable(true);
		
		labelSituacao.setText("Situação: Finalizado");
		labelAtencao.setText("Viagem finalizada! Você pode selecionar uma nova para começar o monitoramento em " + '"' + "Minhas Viagens" + '"');
		labelAtencao.setVisible(true);
		
		cronometrarExpDiario = false;
		cronometrarTempoTotal = false;
		cronometrarAlimDiaria = false;
		cronometrarDescDiario = false;
		
  	  	String tempoAtual[] = labelHorasTotais.getText().split(":");
  	  	String segundos = tempoAtual[3];
  	  	String minutos = tempoAtual[2];
  	  	String horas = tempoAtual[1].substring(1);
  	  	String tempoTotal = horas + ":" + minutos + ":" + segundos;
		
		atualizarTempos();
		viagem.finalizarViagem(tempoTotal);
		
		Logs log = new Logs();
		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Término de viagem:"
				+ "\nDestino: " + labelDestino.getText()
				+ "\nCarga: " + labelCarga.getText()
				+ "\nExpediente total: " + tempoTotal);
		
		new Motorista().encontrarMotorista(ControlesLogin.cpfLogado).incrementarMetadados("VgmFin");
		
		ControlesPerfilMotViagens.carregarTableView = true;
    }
    
    public void carregarViagem() {
    	Viagem viagem = new Viagem();
    	viagemAtual = null;
    	Motorista motorista = new Motorista().encontrarMotorista(ControlesLogin.cpfLogado);

    	List<Viagens> listaDeViagens = new ArrayList<>();
    	
    	listaDeViagens = viagem.listarViagens();
    	
    	listaDeViagens.forEach(item -> {
    		if(item.getMotorista().getCpf().equals(ControlesLogin.cpfLogado)) {
    			if(item.getSituacao().equals("Em andamento")) {
    				viagemAtual = viagem.encontrarViagem(item.getId());
    				
    			}
    		}
    	});
    	
    	if(viagemAtual != null) { 
    		labelDestino.setText("Destino: " + viagemAtual.getDestino());
    		labelPlaca.setText("Placa do veículo: " + viagemAtual.getVeiculo().getPlaca());
    		labelPrazo.setText("Prazo de entrega: " + viagemAtual.getFim());
    		labelHorasTotais.setText("Horas totais dirigidas: " + viagemAtual.getTotal());
    		labelCarga.setText("Carga: " + viagemAtual.getCarga());
    		labelSituacao.setText("Situação: " + viagemAtual.getSituacao());
    		
    		labelAtencao.setVisible(false);
    		
    		labelExpMax.setText("Expediente máximo diário: " + motorista.getCargaHoraria() + 'h');
       		if(motorista.getTrabalhado_hoje().equals("0")){
       			labelExpHoje.setText("Total de hoje: " + motorista.getTrabalhado_hoje() + 'h');
       		}else {
       			labelExpHoje.setText("Total de hoje: " + motorista.getTrabalhado_hoje());
       		}
    		
       		labelAlimMax.setText("Tempo máximo de alimentação: " + "1h");
       		if(motorista.getAlimentacao_hoje().equals("0")){
        		labelAlimHoje.setText("Total de hoje: " + motorista.getAlimentacao_hoje() + 'h');
       		}else {
       			labelAlimHoje.setText("Total de hoje: " + motorista.getAlimentacao_hoje());
       		}
       		
       		labelDescMax.setText("Tempo máximo de descanso: " + "1h");
       		if(motorista.getDescansado_hoje().equals("0")){
        		labelDescHoje.setText("Total de hoje: " + motorista.getDescansado_hoje() + 'h');
       		}else {
       			labelDescHoje.setText("Total de hoje: " + motorista.getDescansado_hoje());
       		}
    		
    		// Essa parte logo abaixo talvez esteja confusa, mas resumindo, ela verifica se a entrega está atrasada ou não, e avisa o motorista caso esteja
        	String prazo = viagemAtual.getFim();
        	
        	int ano = LocalDate.now().getYear();
        	int dia = LocalDate.now().getDayOfMonth();
        	int mes = LocalDate.now().getMonthValue();
        	
        	String desmontado[] = prazo.split("/");
        	
        	if(Integer.parseInt(desmontado[2]) < ano) {
        		labelAtencao.setVisible(true);
        		labelAtencao.setText("Sua entrega está atrasada! Verifique junto a filial para mais informações.");
        	}else if(Integer.parseInt(desmontado[1]) < mes) {
        		labelAtencao.setVisible(true);
        		labelAtencao.setText("Sua entrega está atrasada! Verifique junto a filial para mais informações.");
        	}else if(Integer.parseInt(desmontado[0]) < dia && Integer.parseInt(desmontado[1]) <= mes) {
        		labelAtencao.setVisible(true);
        		labelAtencao.setText("Sua entrega está atrasada! Verifique junto a filial para mais informações.");
        	}
        	

        	// Ativa os botões
        	botaoAlimentacao.setDisable(false);
        	botaoDescanso.setDisable(false);
        	botaoExpediente.setDisable(false);
    		botaoFinalizarViagem.setDisable(false);
        	
        	
        	carregarViagem = false;
    	}else {
    		labelDestino.setText("Destino: ");
    		labelPlaca.setText("Placa do veículo: ");
    		labelPrazo.setText("Prazo de entrega: ");
    		labelHorasTotais.setText("Horas totais dirigidas: ");
    		labelCarga.setText("Carga: ");
    		labelSituacao.setText("Situação: ");
    		
    		labelAtencao.setVisible(true);
    		String aviso = "Nenhuma viagem selecionada no momento, por favor selecione na seção " + '"' + "Minhas viagens" + '"';
    		labelAtencao.setText(aviso);
    		
    		labelExpMax.setText("Expediente máximo diário: ");
    		labelExpHoje.setText("Total de hoje: ");
    		
       		labelAlimMax.setText("Tempo máximo de alimentação: ");
       		labelAlimHoje.setText("Total de hoje: ");
       		
       		labelDescMax.setText("Tempo máximo de descanso: ");
    		labelDescHoje.setText("Total de hoje: ");
    		
    		
        	// Desativa os botões
        	botaoAlimentacao.setDisable(true);
        	botaoDescanso.setDisable(true);
        	botaoExpediente.setDisable(true);
    		botaoFinalizarViagem.setDisable(true);
    		
    		carregarViagem = false;
    	}
    	
    }
    
    
    @FXML
    void abrirCriarAviso(MouseEvent event) {
    	Main.trocarTela("Criar Aviso");
    }

    @FXML
    void abrirMinhasViagens(MouseEvent event) {
    	Main.trocarTela("Mot Viagens");
    }
    
    @FXML
    void voltar(ActionEvent event) {
    	atualizarTempos();
    	
		cronometrarExpDiario = false;
		cronometrarTempoTotal = false;
		cronometrarAlimDiaria = false;
		cronometrarDescDiario = false;
		
    	Main.trocarTela("Tela Login");
    }
	@FXML
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }
    @FXML
    void fecharJanela(ActionEvent event) {
    	atualizarTempos();
    	
		cronometrarExpDiario = false;
		cronometrarTempoTotal = false;
		cronometrarAlimDiaria = false;
		cronometrarDescDiario = false;
		
		Main.trocarTela("Tela Login");
    }

    void tarefasEmLoop() {
    	// Considere que cada if aqui dentro é uma "função"
    	
  	  	if(pausarViagem) {
  	  		atualizarTempos();
  	  		
  	  	}

  	  	// "Função" para cronometrar o tempo
  	  	if(cronometrarTempoTotal) {
	  	  	String texto = "Horas totais dirigidas: ";
	  	  	
	  	  	String tempoAtual[] = labelHorasTotais.getText().split(":");
	  	  	
	  	  	String segundos = tempoAtual[3];
	  	  	String minutos = tempoAtual[2];
	  	  	String horas = tempoAtual[1].substring(1);  // Nessa linha, horas inicialmente vem como " 00", então essas operações retiram o " "
	  	  	
	  	  	// Incrementa o tempo
	  	  	segundos = String.valueOf(Integer.parseInt(segundos) + 1);
	  	  	if(Integer.parseInt(segundos) >= 60) {
	  	  		segundos = "00";
	  	  	  	minutos = String.valueOf(Integer.parseInt(minutos) + 1);
	  	  	}
	  	  	if(Integer.parseInt(minutos) >= 60) {
	  	  		minutos = "00";
	  	  		horas = String.valueOf(Integer.parseInt(horas) + 1);
	  	  	}
	  	  	
	  	  	// Formata o tempo
	  	  	if(Integer.parseInt(segundos) < 10 && segundos.length() < 2) {
	  	  		segundos = "0" + segundos;
	  	  	}
	  	  	if(Integer.parseInt(minutos) < 10 && minutos.length() < 2) {
	  	  		minutos = "0" + minutos;
	  	  	}
	  	  	if(Integer.parseInt(horas) < 10 && horas.length() < 2) {
	  	  		horas = "0" + horas;
	  	  	}
	  	  	
	  	  	// Formata o texto e coloca na label
	  	  	texto = texto + horas + ":" + minutos + ":" + segundos;	
	  	  	labelHorasTotais.setText(texto);
	  	  	
	  	  	tempototal = tempototal + 1;
	  	  	
	  	  	// verificando se o tempototal (que é em segundos) é divisível por 18000 segundos (que equivalem a 5 horas)
	  	  	if (tempototal % 18000 == 0) {
	  	  		tempototal = 0; // cuidado com o tamanho da variável
	  	  		
	  	  		notificar("Tempo", "Descanso", "Sua pausa de 30 minutos chegou! Aproveite!");
	  	  	}
	  	  	
  	  	}
  	  	
  	  	if(cronometrarExpDiario) {
  	  		String texto = "Total de hoje: ";
  	  		String totalDiario = labelExpHoje.getText();
  	  		
  	  		if(!totalDiario.contains("0h")) {
  		  	  	String tempoAtual[] = labelExpHoje.getText().split(":");
  		  	  	
  		  	  	String segundos = tempoAtual[3];
  		  	  	String minutos = tempoAtual[2];
  		  	  	String horas = tempoAtual[1].substring(1);
  		  	  	
  		  	  	// Incrementa o tempo
  		  	  	segundos = String.valueOf(Integer.parseInt(segundos) + 1);
  		  	  	if(Integer.parseInt(segundos) >= 60) {
  		  	  		segundos = "00";
  		  	  	  	minutos = String.valueOf(Integer.parseInt(minutos) + 1);
  		  	  	}
  		  	  	if(Integer.parseInt(minutos) >= 60) {
  		  	  		minutos = "00";
  		  	  		horas = String.valueOf(Integer.parseInt(horas) + 1);
  		  	  	}
  		  	  	
  		  	  	// Formata o tempo
  		  	  	if(Integer.parseInt(segundos) < 10 && segundos.length() < 2) {
  		  	  		segundos = "0" + segundos;
  		  	  	}
  		  	  	if(Integer.parseInt(minutos) < 10 && minutos.length() < 2) {
  		  	  		minutos = "0" + minutos;
  		  	  	}
  		  	  	if(Integer.parseInt(horas) < 10 && horas.length() < 2) {
  		  	  		horas = "0" + horas;
  		  	  	}
  		  	  	
  		  	  	// Formata o texto e coloca na label
  		  	  	texto = texto + horas + ":" + minutos + ":" + segundos;	
  		  	  	labelExpHoje.setText(texto);
  		  	  	
  	  		}else {
  		  	  	// Formata o texto e coloca na label
  		  	  	texto = texto + "00:00:01";	//Aqui precisa iniciar em 1s para não ficar atrasado o tempo
  		  	  	labelExpHoje.setText(texto);
  		  	  	
  	  		}
  	  		
  	  	}
  	  	
  	  	if(cronometrarAlimDiaria) {
  	  		String texto = "Total de hoje: ";
  	  		String totalDiario = labelAlimHoje.getText();
  	  		
  	  		if(!totalDiario.contains("0h")) {
  		  	  	String tempoAtual[] = labelAlimHoje.getText().split(":");
  		  	  	
  		  	  	String segundos = tempoAtual[3];
  		  	  	String minutos = tempoAtual[2];
  		  	  	String horas = tempoAtual[1].substring(1);
  		  	  	
  		  	  	// Incrementa o tempo
  		  	  	segundos = String.valueOf(Integer.parseInt(segundos) + 1);
  		  	  	if(Integer.parseInt(segundos) >= 60) {
  		  	  		segundos = "00";
  		  	  	  	minutos = String.valueOf(Integer.parseInt(minutos) + 1);
  		  	  	}
  		  	  	if(Integer.parseInt(minutos) >= 60) {
  		  	  		minutos = "00";
  		  	  		horas = String.valueOf(Integer.parseInt(horas) + 1);
  		  	  	}
  		  	  	
  		  	  	// Formata o tempo
  		  	  	if(Integer.parseInt(segundos) < 10 && segundos.length() < 2) {
  		  	  		segundos = "0" + segundos;
  		  	  	}
  		  	  	if(Integer.parseInt(minutos) < 10 && minutos.length() < 2) {
  		  	  		minutos = "0" + minutos;
  		  	  	}
  		  	  	if(Integer.parseInt(horas) < 10 && horas.length() < 2) {
  		  	  		horas = "0" + horas;
  		  	  	}
  		  	  	
  		  	  	// Formata o texto e coloca na label
  		  	  	texto = texto + horas + ":" + minutos + ":" + segundos;	
  		  	  	labelAlimHoje.setText(texto);
  		  	  	
  		  	  	if(Integer.parseInt(horas) > 1) {
  		  	  		alimMaxAtingido = true;
  		  	  	}else {
  		  	  		alimMaxAtingido = false;
  		  	  	}
  		  	  	
  	  		}else {
  		  	  	// Formata o texto e coloca na label
  		  	  	texto = texto + "00:00:01";	//Aqui precisa iniciar em 1s para não ficar atrasado o tempo
  		  	  	labelAlimHoje.setText(texto);
  		  	  	
  	  		}
  	  		
  	  	}
  	  	
  	  	if(cronometrarDescDiario) {
  	  		String texto = "Total de hoje: ";
  	  		String totalDiario = labelDescHoje.getText();
  	  		
  	  		if(!totalDiario.contains("0h")) {
  		  	  	String tempoAtual[] = labelDescHoje.getText().split(":");
  		  	  	
  		  	  	String segundos = tempoAtual[3];
  		  	  	String minutos = tempoAtual[2];
  		  	  	String horas = tempoAtual[1].substring(1);
  		  	  	
  		  	  	// Incrementa o tempo
  		  	  	segundos = String.valueOf(Integer.parseInt(segundos) + 1);
  		  	  	if(Integer.parseInt(segundos) >= 60) {
  		  	  		segundos = "00";
  		  	  	  	minutos = String.valueOf(Integer.parseInt(minutos) + 1);
  		  	  	}
  		  	  	if(Integer.parseInt(minutos) >= 60) {
  		  	  		minutos = "00";
  		  	  		horas = String.valueOf(Integer.parseInt(horas) + 1);
  		  	  	}
  		  	  	
  		  	  	// Formata o tempo
  		  	  	if(Integer.parseInt(segundos) < 10 && segundos.length() < 2) {
  		  	  		segundos = "0" + segundos;
  		  	  	}
  		  	  	if(Integer.parseInt(minutos) < 10 && minutos.length() < 2) {
  		  	  		minutos = "0" + minutos;
  		  	  	}
  		  	  	if(Integer.parseInt(horas) < 10 && horas.length() < 2) {
  		  	  		horas = "0" + horas;
  		  	  	}
  		  	  	
  		  	  	// Formata o texto e coloca na label
  		  	  	texto = texto + horas + ":" + minutos + ":" + segundos;	
  		  	  	labelDescHoje.setText(texto);
  		  	  	
  		  	  	if(Integer.parseInt(horas) > 1) {
  		  	  		descMaxAtingido = true;
  		  	  	}else {
  		  	  		descMaxAtingido = false;
  		  	  	}
  		  	  	
  	  		}else {
  		  	  	// Formata o texto e coloca na label
  		  	  	texto = texto + "00:00:01";	//Aqui precisa iniciar em 1s para não ficar atrasado o tempo
  		  	  	labelDescHoje.setText(texto);
  		  	  	
  	  		}
  	  		
  	  	}
  	  	
  	  	// Carrega a viagem do motorista
  	  	if(carregarViagem) {
  	  		carregarViagem();
  	  	}
  	  	
  	  	if(alimMaxAtingido) {
  	  		labelAtencao.setVisible(true);
  	  		labelAtencao.setText("Seu período de alimentação diária já foi atingido!");
  	  	}else if(labelAtencao.getText().equals("Seu período de alimentação diária já foi atingido!")){
  	  		labelAtencao.setVisible(false);
  	  	}
  	  	
  	  	if(descMaxAtingido) {
  	  		labelAtencao.setVisible(true);
  	  		labelAtencao.setText("Seu período de descanso diário já foi atingido!");
  	  	}else if(labelAtencao.getText().equals("Seu período de descanso diário já foi atingido!")){
  	  		labelAtencao.setVisible(false);
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
