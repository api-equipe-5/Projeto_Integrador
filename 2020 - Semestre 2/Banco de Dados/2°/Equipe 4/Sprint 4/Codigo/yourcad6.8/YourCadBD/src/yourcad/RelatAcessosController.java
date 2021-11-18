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
 * @author MaXx
 */
public class RelatAcessosController implements Initializable {

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
    private TextField txt_relatUsuario;
    @FXML
    private TextField txt_relatData1;
    @FXML
    private TextField txt_relatData2;
    @FXML
    private Button btn_relatGerar;
    @FXML
    private Button btn_relatImprimir;
    @FXML
    private TableView<RelatAcesso> tbview_relatAcesso;
    @FXML
    private TableColumn<RelatAcesso, String> table_relatUsuarioNome;
    @FXML
    private TableColumn<RelatAcesso, String> table_relatfuncao;
    @FXML
    private TableColumn<RelatAcesso, String> table_relatStatus;
    @FXML
    private TableColumn<RelatAcesso, String> table_relatData;
    @FXML
    private TableColumn<RelatAcesso, String> table_relatHora;
    @FXML
    private TextField txt_relatSql;
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
     * @param url
     * @param rb
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
    
    private ObservableList<RelatAcesso> linhas_banco;
    @FXML
    private void gerarRelatorio(ActionEvent event) throws Exception 
    {
        String usuario_nome = txt_relatUsuario.getText();
        String acesso_data1 = txt_relatData1.getText();
        String acesso_data2 = txt_relatData2.getText();
        
        Connection conn = null;
        ResultSet resultadoBanco = null;
        conn = DBConexao.abrirConexao();
        
        List<RelatAcesso> acessos = new ArrayList<>();
        
        String sql;
        String sql1;
        sql1 = " WHERE usuario_nome LIKE ? AND acesso_data BETWEEN ? AND ? ";
        sql = "SELECT acesso_id, usuario_nome, usuario_nivel_acesso, acesso_data, acesso_hora, usuario_status "
                + " FROM usuarios "
                + " INNER JOIN acessos ON usuarios.usuario_id = acessos.acesso_usuario_id "
                + sql1;
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, "%" + usuario_nome + "%");
        pstm.setDate(2, java.sql.Date.valueOf(acesso_data1));
        pstm.setDate(3, java.sql.Date.valueOf(acesso_data2));
        
        resultadoBanco = pstm.executeQuery();
        
        txt_relatSql.setText(sql);
        
        linhas_banco = FXCollections.observableArrayList();

        while(resultadoBanco.next())
        {   
          linhas_banco.add(new RelatAcesso(resultadoBanco.getInt(1), resultadoBanco.getString(2), resultadoBanco.getString(3), resultadoBanco.getString(4), resultadoBanco.getString(5), resultadoBanco.getString(6)));
        }
        
        table_relatUsuarioNome.setCellValueFactory(new PropertyValueFactory<>("usuario_nome"));
        table_relatfuncao.setCellValueFactory(new PropertyValueFactory<>("usuario_funcao"));
        table_relatStatus.setCellValueFactory(new PropertyValueFactory<>("usuario_status"));
        table_relatData.setCellValueFactory(new PropertyValueFactory<>("acesso_data"));
        table_relatHora.setCellValueFactory(new PropertyValueFactory<>("acesso_hora"));             
                
        tbview_relatAcesso.setItems(null);
        tbview_relatAcesso.setItems(linhas_banco);
    }

    @FXML
    private void imprimirRelatorio(ActionEvent event) throws JRException, Exception 
    {
        String usuario_nome = txt_relatUsuario.getText();
        String data1 = txt_relatData1.getText();
        String data2 = txt_relatData2.getText();
        String sql = txt_relatSql.getText();
        
        HashMap filtro = new HashMap();
        filtro.put("USUARIO", sql);
        Connection conn = null;
        conn = DBConexao.abrirConexao();

        URL url = getClass().getResource("RelatAcessos.jasper");
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(url);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, filtro, conn);/*null: caso não existam filtros*/ 
        JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);//false: não deixa fechar a aplicação principal
        jasperViewer.setVisible(true);

    }
    
}
