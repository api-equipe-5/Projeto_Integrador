/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourcad;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mateu
 */
public class TelaInicialController implements Initializable {

    @FXML
    private AnchorPane ancPane_TelaInicio;
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
    private MenuItem menuItem_CadUsuarios;
    @FXML
    private MenuItem menuItem_PesqUsuarios;
    @FXML
    private Menu menu_Configuracao;
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
    private Menu menu_Relatorios;
    @FXML
    private Menu menu_Cadastro;


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
}
 