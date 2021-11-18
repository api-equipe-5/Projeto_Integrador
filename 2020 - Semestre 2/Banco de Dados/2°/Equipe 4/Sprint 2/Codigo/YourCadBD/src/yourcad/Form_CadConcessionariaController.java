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
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import yourcad.DBConexao.*;
import java.sql.*;

/**
 * FXML Controller class
 *
 * @author mateu
 */
public class Form_CadConcessionariaController implements Initializable {

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
    private TextField txtFld_NomeConcessionaria;
    @FXML
    private TextField txtFld_CnpjConcessionaria;
    @FXML
    private TextField txtFld_InscEstadualConcessionaria;
    @FXML
    private TextField txtFld_EmailConcessionaria;
    @FXML
    private TextField txtFld_SiteConcessionaria;
    @FXML
    private TextField txtFld_CepConcessionaria;
    @FXML
    private TextField txtFld_NumEndConcessionaria;
    @FXML
    private TextField txtFld_CompEndConcessionaria;
    @FXML
    private TextField txtFld_EndConcessionaria;
    @FXML
    private TextField txtFld_CidadeConcessionaria;
    @FXML
    private TextField txtFld_UfEndConcessionaria;
    @FXML
    private Button btn_CadConcessionaria;
    @FXML
    private Button btn_LimparConcessionaria;
    @FXML
    private MenuItem menuItem_PesqCliente;
    @FXML
    private MenuItem menuItem_PesqConta;
    @FXML
    private MenuItem menuItem_PesqConcessionaria;
    @FXML
    private TextField txtFld_UfEndConcessionaria1;

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
    
        @FXML
    private void btn_Limpar(ActionEvent event) {
        txtFld_NomeConcessionaria.setText("");
        txtFld_CnpjConcessionaria.setText("");
        txtFld_InscEstadualConcessionaria.setText("");
        txtFld_EmailConcessionaria.setText("");
        txtFld_SiteConcessionaria.setText("");
        txtFld_CepConcessionaria.setText("");
        txtFld_NumEndConcessionaria.setText("");
        txtFld_CompEndConcessionaria.setText("");
        txtFld_EndConcessionaria.setText("");
        txtFld_CidadeConcessionaria.setText("");
        txtFld_UfEndConcessionaria.setText("");
    }

    @FXML
    private void insert_Concessionaria(ActionEvent event) throws Exception {
                    
        //Declarando os campos de texto para variaveis
        String NomeConcessionaria;
        String CnpjConcessionaria;
        String InscEstadualConcessionaria;
        String EmailConcessionaria;
        String SiteConcessionaria;
        String CepConcessionaria;
        String NumEndConcessionariaTxt;
        String CompEndConcessionaria;
        String EndConcessionaria;
        String CidadeConcessionaria;
        String UfEndConcessionaria;
        
        NomeConcessionaria = txtFld_NomeConcessionaria.getText();
        CnpjConcessionaria = txtFld_CnpjConcessionaria.getText();
        InscEstadualConcessionaria = txtFld_InscEstadualConcessionaria.getText();
        EmailConcessionaria = txtFld_EmailConcessionaria.getText();
        SiteConcessionaria = txtFld_SiteConcessionaria.getText();
        CepConcessionaria = txtFld_CepConcessionaria.getText();
        NumEndConcessionariaTxt = txtFld_NumEndConcessionaria.getText();
        int NumEndConcessionaria = Integer.parseInt(NumEndConcessionariaTxt);
        CompEndConcessionaria = txtFld_CompEndConcessionaria.getText();
        EndConcessionaria = txtFld_EndConcessionaria.getText();
        CidadeConcessionaria = txtFld_CidadeConcessionaria.getText();
        UfEndConcessionaria = txtFld_UfEndConcessionaria.getText();
        
        Connection conn = null;
        ResultSet resultSet = null;
        DBConexao c = new DBConexao();
        conn = DBConexao.abrirConexao();
        Statement stm = conn.createStatement();
        String query;
        query = "INSERT INTO concessionaria(concessionaria_cnpj,\n" +
                "concessionaria_nome,\n" +
                "concessionaria_inscricao_estadual,\n" +
                "concessionaria_endereco,\n" +
                "concessionaria_numero_endereco,\n" +
                "concessionaria_complemento_endereco,\n" +
                "concessionaria_cep,\n" +
                "concessionaria_cidade,\n" +
                "concessionaria_uf,\n" +
                "concessionaria_email,\n" +
                "concessionaria_site) VALUES "
                + "('"+ CnpjConcessionaria +"','"
                + NomeConcessionaria +"','"
                + InscEstadualConcessionaria +"','"
                + EndConcessionaria +"','"
                + NumEndConcessionaria +"','"
                + CompEndConcessionaria +"','"
                + CepConcessionaria +"','"
                + CidadeConcessionaria +"','"
                + UfEndConcessionaria +"','"
                + EmailConcessionaria +"','"
                + SiteConcessionaria +"');";
        
//        System.out.println(query);  // TESTE DE FUNCIONAMENTO
        stm.executeUpdate(query);
        System.out.println("Dados Cadastrados com sucesso!!!");

         
    }   
}
