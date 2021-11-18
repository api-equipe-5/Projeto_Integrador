package control;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.Aviso;
import view.Avisos;
import view.Main;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;



public class ControlesPerfilSuperAvisos implements Initializable{
	
	public static boolean atualizarInfos = false;

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
    private Pane paneAvisoSelecionado;
    @FXML
    private TextField campoIDAviso;
    @FXML
    private TextArea msg;
    @FXML
    private DatePicker dataDoAviso;
    @FXML
    private TextField remetente;
    @FXML
    private CheckBox visualizado;
    
	private List<Avisos> listaAvisos = new ArrayList<>();
	private ObservableList<Avisos> obsListAvisos;
	
	private int idAviso;
    
    
    
    
    
    
    
    @FXML
    void abrirTelaAvisos(MouseEvent event) {
		paneAvisoSelecionado.setDisable(true);
		paneAvisoSelecionado.setVisible(false);
		
		paneVisualizarAvisos.setDisable(false);
		paneVisualizarAvisos.setVisible(true);
		
		atualizarInfos = true;
		
    }

    @FXML
    void abrirTelaMotoristas(MouseEvent event) {
		paneAvisoSelecionado.setDisable(true);
		paneAvisoSelecionado.setVisible(false);
		
		paneVisualizarAvisos.setDisable(false);
		paneVisualizarAvisos.setVisible(true);
		
    	Main.trocarTela("Tela Inicial Supervisor");
    }
    
    @FXML
    void abrirTelaEntregas(MouseEvent event) {
		paneAvisoSelecionado.setDisable(true);
		paneAvisoSelecionado.setVisible(false);
		
		paneVisualizarAvisos.setDisable(false);
		paneVisualizarAvisos.setVisible(true);
    	
    	Main.trocarTela("Tela Supervisor Entregas");
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
    void selecionarAviso(ActionEvent event) {
		Avisos selecionado = tabelaAvisos.getSelectionModel().getSelectedItem();
		idAviso = selecionado.getId();
		carregarInfoAviso();
		paneAvisoSelecionado.setDisable(false);
		paneAvisoSelecionado.setVisible(true);
		paneVisualizarAvisos.setDisable(true);
		paneVisualizarAvisos.setVisible(false);
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

    @FXML
    void voltar(ActionEvent event) {
    	ControlesPerfilSuperAvisos.atualizarInfos = true;
    	
    	if(paneAvisoSelecionado.isVisible()) {
    		paneAvisoSelecionado.setDisable(true);
    		paneAvisoSelecionado.setVisible(false);
    		
    		paneVisualizarAvisos.setDisable(false);
    		paneVisualizarAvisos.setVisible(true);
    		
    	}
    	else {
        	Main.trocarTela("Tela Inicial Supervisor");
    	}
    	

    }
    
    
	public void carregarTableViews() {
		Aviso aviso = new Aviso();
		
		listaAvisos = aviso.listarAvisos();
		
		obsListAvisos = FXCollections.observableArrayList(listaAvisos);
		
		colunaTituloAviso.setCellValueFactory(new PropertyValueFactory<>("tituloAviso"));
		colunaDataAviso.setCellValueFactory(new PropertyValueFactory<>("dataAviso"));
		colunaRemetente.setCellValueFactory(new PropertyValueFactory<>("motorista"));
		
		tabelaAvisos.setItems(obsListAvisos);
	}
    
    
    public void tarefasEmLoop() {
    	if(atualizarInfos) {
    		carregarTableViews();
    		atualizarInfos = false;
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