package controller;
import dao.AguaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import javafx.scene.control.TextField;
import java.net.URL;
import javafx.scene.control.Button;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import classes.Agua;

public class RelatorioAgua implements Initializable {
    @FXML
    private TableView <Agua> TableAgua;
    @FXML
    private TableColumn <Agua, BigInteger> ClnNInstalacao;
    @FXML
    private TableColumn <Agua, String> ClnMesReferencia;
    @FXML
    private TableColumn <Agua, String> ClnTipoLigacao;
    @FXML
    private TableColumn <Agua, String> ClnHidrometro;
    @FXML
    private TableColumn <Agua, BigInteger> ClnConsumo;
    @FXML
    private TableColumn <Agua, BigDecimal> ClnValorAgua;
    @FXML
    private TableColumn <Agua, BigDecimal> ClnValorEsgoto;
    @FXML
    private TableColumn <Agua, BigDecimal> ClnTaxaRegulamentacao;
    @FXML
    private TableColumn <Agua, BigDecimal> ClnMulta;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnEditar;
  
    private List<Agua> listAgua;
    private ObservableList<Agua> observableListAgua;
       
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        
        carregarTableViewAgua();
    }
    public void changeScreenRetornar() {
        
        Main.changeScreen("main");
    }
    public void changeScreenEditar() {
        Main.changeScreen("updateagua1");
    }

    public void carregarTableViewAgua(){
        ClnNInstalacao.setCellValueFactory(new PropertyValueFactory<>("int_numero_instalacao"));
        ClnMesReferencia.setCellValueFactory(new PropertyValueFactory<>("cta_mes_referencia"));
        ClnTipoLigacao.setCellValueFactory(new PropertyValueFactory<>("agu_tipo_ligacao"));
        ClnHidrometro.setCellValueFactory(new PropertyValueFactory<>("agu_hidrometro"));
        ClnConsumo.setCellValueFactory(new PropertyValueFactory<>("agu_consumo"));
        ClnValorAgua.setCellValueFactory(new PropertyValueFactory<>("agu_valor_agua"));
        ClnValorEsgoto.setCellValueFactory(new PropertyValueFactory<>("agu_valor_esgoto"));
        ClnTaxaRegulamentacao.setCellValueFactory(new PropertyValueFactory<>("agu_taxa_regulamentacao"));
        ClnMulta.setCellValueFactory(new PropertyValueFactory<>("agu_multa"));

        listAgua =  AguaDAO.read();
        observableListAgua = FXCollections.observableArrayList(listAgua);
        TableAgua.setItems(observableListAgua);
    }
}