/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourcad;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mateu
 */
public class PesqContaController implements Initializable {

    @FXML
    private MenuItem menuItem_CadCliente;
    @FXML
    private BorderPane mainPane;
    @FXML
    private MenuBar menuBar_TelaInicial;
    @FXML
    private MenuItem menuItem_CadConta;
    @FXML
    private MenuItem menuItem_CadConcessionaria;
    @FXML
    private MenuItem menuItem_PesqCliente;
    @FXML
    private MenuItem menuItem_PesqConta;
    @FXML
    private MenuItem menuItem_PesqConcessionaria;
    @FXML
    private Button btn_PesquisarCliente;
    private TableColumn<ContaEnergia, String> col_NInstalacao;
    private TableColumn<ContaEnergia,String> col_ApelidoInstalacao;
    private TableColumn<ContaEnergia,String> col_cliente;
    private TableColumn<ContaEnergia,String> col_ValorConta;
    private TableColumn<ContaEnergia,String> col_CompetenciaConta;
    @FXML
    private TextField txt_NumInstalacao;
    private TableView<ContaEnergia> tbview_Contas;
    private ScrollPane sPane_01;
    @FXML
    private ScrollPane tbview_PesqContas;
    @FXML
    private Pane pane01;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }     
    
    
    // INICIO MENU BAR //
    // FUNÇÃO PARA ABRIR TELA A PARTIR DE MENU BAR 
    @FXML
    public void gotoCliente(ActionEvent event) throws IOException{
        PesqClienteController.alterClienteId = 0;
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_CadCliente.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoConta(ActionEvent event) throws IOException {
        PesqContaEnergiaController.contaAlterId = 0;
        PesqContaAguaController.contaAlterId = 0;
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_CadConta.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoConcessionaria(ActionEvent event) throws IOException {
        PesqConcessionariaController.alterConcessionariaId = 0;
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_CadConcessionaria.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoPesqCliente(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("PesqCliente.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML
    private void gotoPesqConta(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("PesqConta.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML
    private void gotoPesqConcessionaria(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("PesqConcessionaria.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    // FIM MENU BAR //
    
    static String numInstalacao = "0";
    private ObservableList<ContaEnergia> linhas_banco;
    @FXML
    public void pesquisarConta(ActionEvent event) throws Exception {

        numInstalacao = txt_NumInstalacao.getText();
        String tipoConta = null;
        //String contaId = null;
            
        if("".equals(numInstalacao))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Digite uma Instalação para pesquisa !");
            alert.showAndWait();
            
            txt_NumInstalacao.requestFocus();
        }
        else{
            Connection conn = null;
            ResultSet resultadoBanco0 = null;
            ResultSet resultadoBanco = null;
            conn = DBConexao.abrirConexao();
            Statement stm = conn.createStatement();

            String sql0;
            sql0 = "SELECT * FROM conta WHERE conta_numero_instalacao = " + numInstalacao +";";
            resultadoBanco0 = stm.executeQuery(sql0);
            while(resultadoBanco0.next())
            { 
                //contaId = resultadoBanco0.getString("conta_id"); 
                tipoConta = resultadoBanco0.getString("conta_tipo"); 
            }

            if("Energia".equals(tipoConta))
            {
                pane01.getChildren().clear();
                Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("PesqContaEnergia.fxml"));
                pane01.getChildren().add(newLoadedPane);          
            }
            if("Agua e Esgoto".equals(tipoConta))
            {
                pane01.getChildren().clear();
                Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("PesqContaAgua.fxml"));
                pane01.getChildren().add(newLoadedPane);          
            }
        }
    }
}
 