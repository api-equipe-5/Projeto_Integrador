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
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MaXx
 */
public class Form_UsuariosController implements Initializable {

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
    private MenuItem menuItem_CadUsuarios;
    @FXML
    private MenuItem menuItem_PesqUsuarios;
    @FXML
    private Menu menu_Configuracao;
    @FXML
    private TextField txt_usuario_Id;
    @FXML
    private TextField txt_usuario_Nome;
    @FXML
    private TextField txt_usuario_Login;
    @FXML
    private TextField txt_usuario_Email;
    @FXML
    private PasswordField txt_usuario_Senha;
    @FXML
    private PasswordField txt_usuario_Senha2;
    @FXML
    private ComboBox<String> cbox_nivel_Acesso;
    @FXML
    private Button btn_usuario_Limpar;
    @FXML
    private Button btn_usuario_Salvar;
    @FXML
    private ComboBox<String> cbox_usuario_status;
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
        if("Administrador".equals(Form_LoginController.usuario_Nivel_Acesso)){ menu_Configuracao.setVisible(true);}

        // TODO
            // Pega id co cliente vindo da pagina de pesquisa clientes
            int id = PesqUsuariosController.alter_UsuarioId;
            
            // verifica se existe id do cliente se sim ele popula os textfields da pagina para fazer aletração dos dados senão ele traz vazio para uma nova inserção.
            if(id != 0)
            {
                try {
                    
                    String usuario_id = null;
                    String usuario_nome = null;
                    String usuario_login = null;
                    String usuario_senha = null;
                    String usuario_email = null;
                    String usuario_nivel_acesso = null;
                    String usuario_status = null;
                    
                    
                    Connection conn = null;
                    ResultSet resultadoBanco = null;
                    conn = DBConexao.abrirConexao();
                    Statement stm = conn.createStatement();
                    
                    String sql = "SELECT usuario_id, usuario_nome, usuario_login, usuario_senha, usuario_email, usuario_nivel_acesso, usuario_status FROM usuarios WHERE usuario_id = "+ id +";";
                    resultadoBanco = stm.executeQuery(sql);
                    
                    while(resultadoBanco.next())
                    {
                        //System.out.printf(resultadoBanco.getString("cliente_nome"));
                        usuario_id  = resultadoBanco.getString("usuario_id");
                        usuario_nome = resultadoBanco.getString("usuario_nome");
                        usuario_login = resultadoBanco.getString("usuario_login");
                        usuario_senha = resultadoBanco.getString("usuario_senha");
                        usuario_email = resultadoBanco.getString("usuario_email");
                        usuario_nivel_acesso = resultadoBanco.getString("usuario_nivel_acesso"); 
                        usuario_status = resultadoBanco.getString("usuario_status"); 
                    }
                    txt_usuario_Id.setText(usuario_id);
                    txt_usuario_Nome.setText(usuario_nome);
                    txt_usuario_Senha.setText(usuario_senha);
                    txt_usuario_Email.setText(usuario_email);
                    txt_usuario_Login.setText(usuario_login);
                    cbox_nivel_Acesso.setValue(usuario_nivel_acesso);
                    cbox_usuario_status.setValue(usuario_status);
                    
                    
                    
                } 
                catch (Exception ex) {Logger.getLogger(Form_CadClienteController.class.getName()).log(Level.SEVERE, null, ex);}
                
                //private ObservableList<Instalacao> linhas_banco;
            } 
            popular_cbox_Nivel_Acesso();
            popular_cbox_Status();
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

    @FXML
    private void salvar_Usuario(ActionEvent event) throws Exception 
    {
        String usuario_Id = txt_usuario_Id.getText();
        String usuario_Nome = txt_usuario_Nome.getText();
        String usuario_Login = txt_usuario_Login.getText();
        String usuario_Senha = txt_usuario_Senha.getText();
        String usuario_Senha2 = txt_usuario_Senha2.getText();
        String usuario_Email = txt_usuario_Email.getText();
        String usuario_Nivel_Acesso = cbox_nivel_Acesso.getValue();
        String usuario_status = cbox_usuario_status.getValue();
        boolean validar =  validacao();
            
        if (validar == true){
        //Conferindo se Senha e confimação de senha correspondem
        if(!usuario_Senha.equals(usuario_Senha2))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Senhas não correspondem");
            alert.showAndWait();
            
            txt_usuario_Senha.requestFocus();
        }
        else
        {
            if("0".equals(usuario_Id))
            {
                Connection conn = null;
                ResultSet resultadoBanco = null;
                conn = DBConexao.abrirConexao();

                String query;
                query = "INSERT INTO usuarios(usuario_nome, usuario_login, usuario_senha, usuario_email, usuario_nivel_acesso, usuario_status) VALUES "
                       + "(?, ?, ?, ?, ?, ?)";
                
                PreparedStatement pstm = conn.prepareStatement(query);
                pstm.setString(1, usuario_Nome);
                pstm.setString(2, usuario_Login);
                pstm.setString(3, usuario_Senha);
                pstm.setString(4, usuario_Email);
                pstm.setString(5, usuario_Nivel_Acesso);
                pstm.setString(6, usuario_status);
                
                pstm.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensagem");
                alert.setHeaderText("Dados inseridos com sucesso");
                alert.showAndWait();    
            }
            else
            {
                Connection conn = null;
                ResultSet resultadoBanco = null;
                conn = DBConexao.abrirConexao();

                String sql;
                sql = "UPDATE usuarios SET "
                    + "usuario_nivel_acesso = ?, "
                    + "usuario_nome = ?, "
                    + "usuario_login = ?, "
                    + "usuario_senha = ?, "
                    + "usuario_email = ?, "
                    + "usuario_status = ? "    
                    + "WHERE usuario_id = ?";
                
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setString(1, usuario_Nome);
                pstm.setString(2, usuario_Login);
                pstm.setString(3, usuario_Senha);
                pstm.setString(4, usuario_Email);
                pstm.setString(5, usuario_Nivel_Acesso);
                pstm.setString(6, usuario_status);
                pstm.setString(7, usuario_Id);
                
                pstm.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensagem");
                alert.setHeaderText("Dados alterados com sucesso !");
                alert.showAndWait();
            }
        }
       }
    }
    
    private void popular_cbox_Nivel_Acesso()
    {
        // ComboBox Tipo de Instalação
        ObservableList<String> lista = FXCollections.observableArrayList("Administrador","Supervisor", "Digitador");
        cbox_nivel_Acesso.setItems(lista);
    }
    
    private void popular_cbox_Status()
    {
        // ComboBox Tipo de Instalação
        ObservableList<String> lista = FXCollections.observableArrayList("Ativo", "Inativo");
        cbox_usuario_status.setItems(lista);
    }
    
    
    private boolean validacao (){

        
        if ("".equals(txt_usuario_Nome.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Nome não pode ser vazio");
            alert.showAndWait();
            txt_usuario_Nome.requestFocus();
            return false;
        }
        else if ("".equals(txt_usuario_Login.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Login não pode ser vazio");
            alert.showAndWait();
            txt_usuario_Login.requestFocus();
            return false;
        }
        else if ("".equals(txt_usuario_Senha.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Senha não pode ser vazio");
            alert.showAndWait();
            txt_usuario_Senha.requestFocus();
            return false;
        }
        else if ("".equals(txt_usuario_Senha2.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Confirmar Senha não pode ser vazio");
            alert.showAndWait();
            txt_usuario_Senha2.requestFocus();
            return false;
        }
        else if ("".equals(txt_usuario_Email.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Email não pode ser vazio");
            alert.showAndWait();
            txt_usuario_Email.requestFocus();
            return false;
            
        }
        else if (cbox_nivel_Acesso.getValue() == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Nivel de Acesso não pode ser vazio");
            alert.showAndWait();
            cbox_nivel_Acesso.requestFocus();
            return false;
        }
        else if (cbox_usuario_status.getValue() == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Nivel de Acesso não pode ser vazio");
            alert.showAndWait();
            cbox_usuario_status.requestFocus();
            return false;
        }
        else {return true;} 
    }
}
