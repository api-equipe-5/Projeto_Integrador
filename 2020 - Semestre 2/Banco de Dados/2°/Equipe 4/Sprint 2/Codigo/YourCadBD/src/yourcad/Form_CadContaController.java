/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourcad;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
/*import javafx.scene.control.TextField;*/
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mateu
 */
public class Form_CadContaController implements Initializable {

    @FXML
    private BorderPane mainPane;
    @FXML
    private AnchorPane ancPane_TelaInicio;
    @FXML
    private MenuBar menuBar_TelaInicial;
    @FXML
    private MenuItem menuItem_CadCliente;
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
    private TextField txtPesqNInstalacao;
    @FXML
    private TextField txt_EnergiaDescricao;
    @FXML
    private TextField txt_EnergiaConsumoLeituraAtual;
    @FXML
    private TextField txt_EnergiaNMedidor;
    @FXML
    private TextField txt_EnergiaConstMult;
    @FXML
    private TextField txt_EnergiaConsumoLeituraAnterior;
    @FXML
    private TextField txt_EnergiaKwhMes;
    @FXML
    private TextField txt_EnergiaCci;
    @FXML
    private TextField txt_EnergiaTarifaAplicada;
    @FXML
    private TextField txt_EnergiaBaseICMS;
    @FXML
    private TextField txt_EnergiaBasePisCofins;
    @FXML
    private TextField txt_EnergiaDescricaoProduto;
    @FXML
    private TextField txt_EnergiaValorFornecedor;
    @FXML
    private TextField txt_EnergiaAliquotaIcms;
    @FXML
    private TextField txt_EnergiaAliquotaPis;
    @FXML
    private TextField txt_EnergiaValorPis;
    @FXML
    private TextField txt_EnergiaValorIcms;
    @FXML
    private TextField txt_EnergiaTarifaImposto;
    @FXML
    private TextField txt_EnergiaQuantidade;
    @FXML
    private TextField txt_EnergiaNConta;
    @FXML
    private TextField txt_EnergiaValor;
    @FXML
    private TextField txt_EnergiaCompetencia;
    @FXML
    private TextField txt_EnergiaConsumoMes;
    @FXML
    private TextField txt_EnergiaVencimento;
    @FXML
    private TextField txt_EnergiaPeriodo2;
    @FXML
    private TextField txt_EnergiaPeriodo;
    @FXML
    private TextField txt_EnergiaCor;
    @FXML
    private TextField txt_EnergiaDiasFaturamento;
    @FXML
    private TextField txt_EnergiaPrevisãoLeitura;
    @FXML
    private TextField txt_EnergiaLeituraAtual;
    @FXML
    private TextField txt_EnergiaLeituraAnterior;
    @FXML
    private TextField txt_EnergiaEmissao;

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
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_CadCliente.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoConta(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_CadConta.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoConcessionaria(ActionEvent event) throws IOException {
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

   
    
}
