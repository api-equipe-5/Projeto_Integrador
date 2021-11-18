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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author mateu
 */
public class Form_CadConcessionariaController implements Initializable {

    @FXML
    private BorderPane mainPane;
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
    private MenuItem menuItem_PesqCliente;
    @FXML
    private MenuItem menuItem_PesqConta;
    @FXML
    private MenuItem menuItem_PesqConcessionaria;
    @FXML
    private AnchorPane ancPane_TelaInicio;
    private TextField txtFld_UfEndConcessionaria1;
    @FXML
    private Button btn_CadConcessionaria;
    @FXML
    private Button btn_LimparConcessionaria;
    @FXML
    private TextField txt_IdConcessionaria;
    @FXML
    private TextField txtFld_bairroConcessionaria;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int id = PesqConcessionariaController.alterConcessionariaId;
        
        if(id != 0)
        {        
            try {
                
                String idconcessionaria = null;
                String NomeConcessionaria = null;
                String CnpjConcessionaria = null;
                String InscEstadualConcessionaria = null;
                String EmailConcessionaria = null;
                String SiteConcessionaria = null;
                String CepConcessionaria = null;
                String NumEndConcessionariaTxt = null;
                String CompEndConcessionaria = null;
                String EndConcessionaria = null;
                String BairroConcessionaria = null;
                String CidadeConcessionaria = null;
                String UfEndConcessionaria = null;
                
                Connection conn = null;
                ResultSet resultadoBanco = null;
                
                conn = DBConexao.abrirConexao();
                Statement stm = conn.createStatement();
                
                resultadoBanco = stm.executeQuery("SELECT * FROM concessionaria WHERE concessionaria_id = "+ id +";");
                               
                while(resultadoBanco.next())
                {                    
                    idconcessionaria = resultadoBanco.getString("concessionaria_id");
                    NomeConcessionaria = resultadoBanco.getString("concessionaria_nome");
                    CnpjConcessionaria = resultadoBanco.getString("concessionaria_cnpj");
                    InscEstadualConcessionaria = resultadoBanco.getString("concessionaria_inscricao_estadual");
                    EmailConcessionaria = resultadoBanco.getString("concessionaria_email");
                    SiteConcessionaria = resultadoBanco.getString("concessionaria_site");
                    CepConcessionaria = resultadoBanco.getString("concessionaria_cep");
                    NumEndConcessionariaTxt = resultadoBanco.getString("concessionaria_numero_endereco");
                    CompEndConcessionaria = resultadoBanco.getString("concessionaria_complemento_endereco");
                    EndConcessionaria = resultadoBanco.getString("concessionaria_endereco");
                    BairroConcessionaria = resultadoBanco.getString("concessionaria_bairro");
                    CidadeConcessionaria = resultadoBanco.getString("concessionaria_cidade");
                    UfEndConcessionaria = resultadoBanco.getString("concessionaria_uf");
                            
                      
                  
                }
                txtFld_CepConcessionaria.setText(CepConcessionaria);
                txtFld_CidadeConcessionaria.setText(CidadeConcessionaria);
                txtFld_CnpjConcessionaria.setText(CnpjConcessionaria);
                txtFld_CompEndConcessionaria.setText(CompEndConcessionaria);
                txtFld_EmailConcessionaria.setText(EmailConcessionaria);
                txtFld_EndConcessionaria.setText(EndConcessionaria);
                txtFld_InscEstadualConcessionaria.setText(InscEstadualConcessionaria);
                txtFld_NomeConcessionaria.setText(NomeConcessionaria);
                txtFld_NumEndConcessionaria.setText(NumEndConcessionariaTxt);
                txtFld_SiteConcessionaria.setText(SiteConcessionaria);
                txtFld_UfEndConcessionaria.setText(UfEndConcessionaria);
                txtFld_bairroConcessionaria.setText(BairroConcessionaria);
                txt_IdConcessionaria.setText(idconcessionaria);
                
            } catch (Exception ex) {
                Logger.getLogger(Form_CadClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        }
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
    
    @FXML
    private void btn_Limpar() {
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
        txtFld_bairroConcessionaria.setText("");
        txt_IdConcessionaria.setText("");
    }

    @FXML
    private void insert_Concessionaria(ActionEvent event) throws Exception {
        
        if(PesqConcessionariaController.alterConcessionariaId != 0)
        {
            Connection conn = null;
            ResultSet resultadoBanco = null;
                     
            conn = DBConexao.abrirConexao();
            Statement stm = conn.createStatement();
           
            String idconcessionaria = txt_IdConcessionaria.getText();
            String NomeConcessionaria = txtFld_NomeConcessionaria.getText();
            String CnpjConcessionaria = txtFld_CnpjConcessionaria.getText();
            String InscEstadualConcessionaria = txtFld_InscEstadualConcessionaria.getText();
            String EmailConcessionaria = txtFld_EmailConcessionaria.getText();
            String SiteConcessionaria = txtFld_SiteConcessionaria.getText();
            String CepConcessionaria = txtFld_CepConcessionaria.getText();
            String NumEndConcessionariaTxt = txtFld_NumEndConcessionaria.getText();
            String CompEndConcessionaria = txtFld_CompEndConcessionaria.getText();
            String EndConcessionaria = txtFld_EndConcessionaria.getText();
            String BairroConcessionaria = txtFld_bairroConcessionaria.getText();
            String CidadeConcessionaria = txtFld_CidadeConcessionaria.getText();
            String UfEndConcessionaria = txtFld_UfEndConcessionaria.getText();
            
            String sql;
            sql = "UPDATE concessionaria SET "
                    + "concessionaria_cnpj = '"+ CnpjConcessionaria +"', "
                    + "concessionaria_nome = '"+ NomeConcessionaria +"', "
                    + "concessionaria_inscricao_estadual = '"+ InscEstadualConcessionaria +"', "
                    + "concessionaria_endereco = '"+ EndConcessionaria +"', "
                    + "concessionaria_bairro = '"+ BairroConcessionaria +"', "
                    + "concessionaria_numero_endereco = '"+ NumEndConcessionariaTxt +"', "
                    + "concessionaria_complemento_endereco = '"+ CompEndConcessionaria +"', "
                    + "concessionaria_cep = '"+ CepConcessionaria +"', "
                    + "concessionaria_cidade = '"+ CidadeConcessionaria +"', "
                    + "concessionaria_uf = '"+ UfEndConcessionaria +"', "
                    + "concessionaria_email = '"+ EmailConcessionaria +"', "
                    + "concessionaria_site = '"+ SiteConcessionaria +"', "
                    + "WHERE concessionaria_id = "+ idconcessionaria +";";
                       
            stm.executeUpdate(sql);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensagem");
            alert.setHeaderText("Dados alterados com sucesso !");
            alert.showAndWait();
            
        }else{
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
        String BairroConcessionaria;
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
        BairroConcessionaria = txtFld_bairroConcessionaria.getText();
        CidadeConcessionaria = txtFld_CidadeConcessionaria.getText();
        UfEndConcessionaria = txtFld_UfEndConcessionaria.getText();
        
        Connection conn = null;
        ResultSet resultSet = null;
        conn = DBConexao.abrirConexao();
        Statement stm = conn.createStatement();
        String query;
        query = "INSERT INTO concessionaria(concessionaria_cnpj,\n" +
                "concessionaria_nome,\n" +
                "concessionaria_inscricao_estadual,\n" +
                "concessionaria_endereco,\n" +
                "concessionaria_bairro,\n" +
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
                + BairroConcessionaria +"','"
                + NumEndConcessionaria +"','"
                + CompEndConcessionaria +"','"
                + CepConcessionaria +"','"
                + CidadeConcessionaria +"','"
                + UfEndConcessionaria +"','"
                + EmailConcessionaria +"','"
                + SiteConcessionaria +"');";
        
        stm.executeUpdate(query);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensagem");
            alert.setHeaderText("Dados salvos com sucesso !");
            alert.showAndWait();
            btn_Limpar();
        }
    }
                    
        

         
}   

