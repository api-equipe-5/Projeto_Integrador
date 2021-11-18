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
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import yourcad.DBConexao.*;
import java.sql.*;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import yourcad.Form_CadConcessionariaController;
import static yourcad.PesqClienteController.alterClienteId;
import static yourcad.PesqClienteController.alterClienteNome;

/**
 * FXML Controller class
 *
 * @author mateu
 */
public class PesqConcessionariaController implements Initializable {

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
    private TextField txtFld_Concessionaria;
    @FXML
    private TextField txtFld_CnpjConcessionara;
    @FXML
    private Button btn_PesquisarConcessionaria;
    @FXML
    private TableView<Concessionaria> tbview_PesqConcessionaria;
    @FXML
    private TableColumn<String, Concessionaria> table_concessionaria_id;
    @FXML
    private TableColumn<String, Concessionaria> table_nomeFantasia_concessionaria;
    @FXML
    private TableColumn<String, Concessionaria> table_Cnpj_Concessionaria;
    @FXML
    private TableColumn<String, Concessionaria> table_endereco_concessionaria;
    @FXML
    private Button btn_alterar_concessionaria;
    @FXML
    private Button btn_deletar_concessionaria;


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

    private ObservableList<Concessionaria> linhas_banco;
    @FXML
    private void pesquisar_Concessionaria(ActionEvent event) throws SQLException, Exception {
        
        String nome_concessionaria = txtFld_Concessionaria.getText();
        String doc_concessionaria = txtFld_CnpjConcessionara.getText();
        
        
        Connection conn = null;
        ResultSet resultadoBanco = null;
        
        conn = DBConexao.abrirConexao();
        Statement stm = conn.createStatement();
        
        //List<Concessionaria> concessionaria = new ArrayList<>();
        
        
        String sql;
        String sql1 = null;
        if(!"".equals(nome_concessionaria)){ sql1 = " WHERE concessionaria_nome LIKE '%"+ nome_concessionaria +"%' ";}
        else if(!"".equals(doc_concessionaria)){ sql1 = " WHERE concessionaria_cnpj LIKE '%"+ doc_concessionaria +"%' ";}
        else if(!"".equals(nome_concessionaria) && !"".equals(doc_concessionaria)){ sql1 = " WHERE concessionaria_nome LIKE '%"+nome_concessionaria+"%' && concessionaria_cnpj LIKE '%"+ doc_concessionaria +"%' ";}
        else{sql1 = "";}
        sql = "SELECT * FROM concessionaria "
                + sql1 
                + " ;";

        resultadoBanco = stm.executeQuery(sql);

       
        linhas_banco = FXCollections.observableArrayList();
        

        while(resultadoBanco.next()){
            
          linhas_banco.add(new Concessionaria(resultadoBanco.getInt(1), resultadoBanco.getString(2), resultadoBanco.getString(3),
                  resultadoBanco.getString(4), resultadoBanco.getString(5), resultadoBanco.getString(6), resultadoBanco.getString(7),
                  resultadoBanco.getString(8), resultadoBanco.getString(9), resultadoBanco.getString(10), resultadoBanco.getString(11), 
                  resultadoBanco.getString(12), resultadoBanco.getString(13)));
        }
                
        table_concessionaria_id.setCellValueFactory(new PropertyValueFactory<>("concessionaria_id"));
        table_nomeFantasia_concessionaria.setCellValueFactory(new PropertyValueFactory<>("concessionaria_nome"));
        table_Cnpj_Concessionaria.setCellValueFactory(new PropertyValueFactory<>("concessionaria_cnpj"));
        table_endereco_concessionaria.setCellValueFactory(new PropertyValueFactory<>("concessionaria_endereco"));
                
        tbview_PesqConcessionaria.setItems(null);
        tbview_PesqConcessionaria.setItems(linhas_banco);
        
    }
    
    Form_CadConcessionariaController enviaId = new Form_CadConcessionariaController();
    static int alterConcessionariaId;
    
    @FXML
    private void alterar_concessionaria(ActionEvent event) throws IOException {
        alterConcessionariaId = tbview_PesqConcessionaria.getSelectionModel().getSelectedItem().getConcessionaria_id();

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_CadConcessionaria.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void deletar_concessionaria(ActionEvent event) throws Exception {
        alterConcessionariaId = tbview_PesqConcessionaria.getSelectionModel().getSelectedItem().getConcessionaria_id();
  
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação de Exclusao");
        alert.setHeaderText("Deseja realmente excluir este cliente?");
        //alert.setContentText("Ao excluir não há como recuperar os dados");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            Connection conn = null;
            ResultSet resultadoBanco = null;
                     
            conn = DBConexao.abrirConexao();
            Statement stm = conn.createStatement();

            String sql;
            sql = "DELETE FROM concessionaria WHERE concessionaria_id = " +alterConcessionariaId+";";
            stm.executeUpdate(sql);

            pesquisar_Concessionaria(event);
        }
        else{ pesquisar_Concessionaria(event);}
        
    }
}
 