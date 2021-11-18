/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourcad;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author info-chefe
 */
public class RelatContasController implements Initializable
{

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
    private MenuItem menuItem_RelatAcessos;
    @FXML
    private MenuItem menuItem_RelatClientes;
    @FXML
    private MenuItem menuItem_RelatDigitador;
    @FXML
    private Menu menu_Configuracao;
    @FXML
    private MenuItem menuItem_CadUsuarios;
    @FXML
    private MenuItem menuItem_PesqUsuarios;
    @FXML
    private TextField txt_relatCliente;
    @FXML
    private TextField txt_relatCnpj;
    @FXML
    private TextField txt_relatSql;
    @FXML
    private Button btn_relatImprimir;
    @FXML
    private Button btn_Pesquisar;
    @FXML
    private TableView<Cliente> table_lista_clientes;
    @FXML
    private TableColumn<Cliente, String> table_cliente_cod;
    @FXML
    private TableColumn<Cliente, String> table_cliente_nome;
    @FXML
    private TableColumn<Cliente, String> table_cliente_doc;
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
    private void pesquisarCliente(ActionEvent event) throws Exception 
    {
        String nome_cliente = txt_relatCliente.getText();
        String doc_cliente = txt_relatCnpj.getText();
        
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
        
        resultadoBanco = pstm.executeQuery();
       
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
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensagem");
        alert.setHeaderText("Selecione um cliente para gerar o relatório");
        alert.showAndWait();
    }

    @FXML
    private void imprimirRelatorio(ActionEvent event) throws JRException, Exception 
    {
        
        int cliente_id = table_lista_clientes.getSelectionModel().getSelectedItem().getCliente_id();

        if(cliente_id != 0 )
        {
            
            String sql1;
            sql1 = "SELECT conta_numero_instalacao, conta_tipo, cliente_nome, instalacao_apelido, conta_agua_mes, conta_agua_valor_agua, "
                  + " conta_energia_valor, conta_energia_competencia FROM conta " 
                  + " LEFT JOIN conta_energia ON conta.conta_id = conta_energia.conta_id "
                  + " LEFT JOIN conta_agua ON conta.conta_id = conta_agua.conta_id "
                  + " LEFT JOIN instalacao ON conta.instalacao_id = instalacao.instalacao_id "
                  + " INNER JOIN cliente ON conta.cliente_id = cliente.cliente_id "
                  + " WHERE conta.cliente_id = " + cliente_id +";";
            
            HashMap filtro = new HashMap();
            filtro.put("SQL", sql1);
            Connection conn = null;
            conn = DBConexao.abrirConexao();

            URL url = getClass().getResource("RelatContas.jasper");
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(url);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, filtro, conn);/*null: caso não existam filtros*/ 
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);//false: não deixa fechar a aplicação principal
            jasperViewer.setVisible(true);
        }
       
    }
        @FXML
    private void mascaraDocumento(javafx.scene.input.KeyEvent event) {
    TextFieldFormatter tff = new TextFieldFormatter();
        if (txt_relatCnpj.getText().length() == 16)
        {
        tff.setMask("##.###.###/####-#");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txt_relatCnpj);
        tff.formatter();        
        } 
        if (txt_relatCnpj.getText().length() == 11 ) 
        {
        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txt_relatCnpj);
        tff.formatter();        
        }
    }
    
}
