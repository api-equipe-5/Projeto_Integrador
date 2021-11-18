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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import yourcad.DBConexao.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import yourcad.Form_CadClienteController;


/**
 * FXML Controller class
 *
 * @author mateu
 */
public class PesqClienteController implements Initializable {

    
    @FXML
    private MenuItem menuItem_CadCliente;
    @FXML
    private BorderPane mainPane;
    @FXML
    private MenuBar menuBar_TelaInicial;
    @FXML
    private TextField txtFld_NomeCliente;
    @FXML
    private TextField txtFld_DocCliente;
    @FXML
    private Menu menu_Configuracao;
    @FXML
    private MenuItem menuItem_CadUsuarios;
    @FXML
    private MenuItem menuItem_PesqUsuarios;
    @FXML
    private Button btn_PesquisarCliente;
    @FXML
    private Button btn_alterarCliente;
    @FXML
    private Button btn_ExcluirCliente;
    @FXML
    private TableColumn<?, ?> table_cliente_acao;

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
    private TableColumn<Cliente, String> table_cliente_cod;
    @FXML
    private TableColumn<Cliente, String> table_cliente_nome;
    @FXML
    private TableColumn<Cliente, String> table_cliente_doc;
    @FXML
    private TableView<Cliente> table_lista_clientes;
    @FXML
    private MenuItem menuItem_RelatAcessos;
    @FXML
    private MenuItem menuItem_RelatClientes;
    @FXML
    private MenuItem menuItem_RelatDigitador;
    @FXML
    private Menu menu_Sair;
    @FXML
    private MenuItem menuItem_SairSistema;
    @FXML
    private Menu menu_Cadastro;
    @FXML
    private Menu menu_Relatorios;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //Definindo que somente Administradores podem vizualizar meno de Configuração
        if("Administrador".equals(Form_LoginController.usuario_Nivel_Acesso))
        { 
            //Menus para administrador:****************
            menu_Configuracao.setVisible(true);
            menu_Relatorios.setVisible(true);
            menuItem_RelatAcessos.setVisible(true);
            menu_Cadastro.setVisible(false);
            //******************************************
        }
        if("Supervisor".equals(Form_LoginController.usuario_Nivel_Acesso))
        {
            //Menus para Supervisor:****************
            menu_Relatorios.setVisible(true);
            menuItem_RelatClientes.setVisible(true);
            menuItem_RelatDigitador.setVisible(true);
            //******************************************
        }
        if("Digitador".equals(Form_LoginController.usuario_Nivel_Acesso))
        {
            //Funções não habilitadas para digitador: ******
            btn_ExcluirCliente.setVisible(false);
            btn_alterarCliente.setText("Visualizar");
            //***********************************************
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
    

     @FXML
    private void gotoUsuarios(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_Usuarios.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoPesqUsuarios(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("PesqUsuarios.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoRelatAcessos(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("RelatAcessos.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoRelatClientes(ActionEvent event) throws IOException 
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("RelatContas.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoRelatDigitador(ActionEvent event) throws IOException 
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("RelatDigitador.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoSair(ActionEvent event) throws IOException 
    {
        Form_LoginController.usuario_Id = "";
        Form_LoginController.usuario_Nome = "";
        Form_LoginController.usuario_Login = "";
        Form_LoginController.usuario_Nivel_Acesso = "";
        Form_LoginController.usuario_Email = "";
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_Login.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show(); 
    }
    // FIM MENU BAR //

    private ObservableList<Cliente> linhas_banco;
    
    @FXML
    private void PesqCliente(ActionEvent event) throws Exception {

        String nome_cliente = txtFld_NomeCliente.getText();
        String doc_cliente = txtFld_DocCliente.getText();
        
        Connection conn = null;
        ResultSet resultadoBanco = null;
        conn = DBConexao.abrirConexao();
        
        List<Cliente> clientes = new ArrayList<>();
        
        String sql;
        String sql1 = null;
        sql1 = " WHERE cliente_nome LIKE ? AND cliente_documento LIKE ? ";
 
        sql = "SELECT cliente_id, cliente_nome, cliente_documento, cliente_apelido,"
                + " cliente_endereco, cliente_complemento_endereco, cliente_numero_endereco, cliente_bairro,"
                + " cliente_cep, cliente_cidade, cliente_uf FROM cliente "
                + sql1;
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, "%" + nome_cliente + "%");
        pstm.setString(2, "%" + doc_cliente + "%");
        
        resultadoBanco = pstm.executeQuery(sql);
       
        linhas_banco = FXCollections.observableArrayList();
        

        while(resultadoBanco.next()){
            
          linhas_banco.add(new Cliente(resultadoBanco.getInt(1), resultadoBanco.getString(2), resultadoBanco.getString(3),
           resultadoBanco.getString(4), resultadoBanco.getString(5), resultadoBanco.getString(6), resultadoBanco.getString(7),
           resultadoBanco.getString(8), resultadoBanco.getString(9), resultadoBanco.getString(10), resultadoBanco.getString(11)));
        }
        //System.out.println(linhas_banco);
             
        //EventHandler<ActionEvent> btnacao = btn_alterarCliente.getOnAction();
        
        table_cliente_cod.setCellValueFactory(new PropertyValueFactory<>("cliente_id"));
        table_cliente_nome.setCellValueFactory(new PropertyValueFactory<>("cliente_nome"));
        table_cliente_doc.setCellValueFactory(new PropertyValueFactory<>("cliente_documento"));
                
        table_lista_clientes.setItems(null);
        table_lista_clientes.setItems(linhas_banco);  
       
    }    
   
    Form_CadClienteController enviaId = new Form_CadClienteController();
    static String alterClienteNome;
    static int alterClienteId;
    
    @FXML
    public void AlterCliente(ActionEvent event) throws IOException {

        alterClienteNome = table_lista_clientes.getSelectionModel().getSelectedItem().getCliente_nome();
        alterClienteId = table_lista_clientes.getSelectionModel().getSelectedItem().getCliente_id();

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_CadCliente.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }
    
    @FXML
    public void DeletarCliente(ActionEvent event)throws IOException, SQLException, Exception{
        alterClienteId = table_lista_clientes.getSelectionModel().getSelectedItem().getCliente_id();

        Alert alert = new Alert(AlertType.CONFIRMATION);
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
            sql = "DELETE FROM cliente WHERE cliente_id = " +alterClienteId+";";
            stm.executeUpdate(sql);

            PesqCliente(event);
        } 
        else{ PesqCliente(event);}
  
    }
    
            @FXML
    private void mascaraDocumento(javafx.scene.input.KeyEvent event) {
    TextFieldFormatter tff = new TextFieldFormatter();
        if (txtFld_DocCliente.getText().length() == 16)
        {
        tff.setMask("##.###.###/####-#");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtFld_DocCliente);
        tff.formatter();        
        } 
        if (txtFld_DocCliente.getText().length() == 11 ) 
        {
        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtFld_DocCliente);
        tff.formatter();        
        }
    }
    
    
}
 