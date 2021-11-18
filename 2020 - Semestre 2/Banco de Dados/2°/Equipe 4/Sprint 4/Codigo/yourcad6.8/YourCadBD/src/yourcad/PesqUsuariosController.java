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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import static yourcad.PesqClienteController.alterClienteNome;

/**
 * FXML Controller class
 *
 * @author info-chefe
 */
public class PesqUsuariosController implements Initializable {

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
    private MenuItem menuItem_PesqCliente;
    @FXML
    private MenuItem menuItem_PesqConta;
    @FXML
    private MenuItem menuItem_PesqConcessionaria;
    @FXML
    private Menu menu_Configuracao;
    @FXML
    private MenuItem menuItem_CadUsuarios;
    @FXML
    private MenuItem menuItem_PesqUsuarios;
    @FXML
    private TextField txt_UsuarioNome;
    @FXML
    private Button btn_PesquisarUsuario;
    @FXML
    private ComboBox<String> cbox_UsuarioNivelAcesso;
    @FXML
    private Button btn_alterarUsuario;
    @FXML
    private Button btn_ExcluirUsuario;
    @FXML
    private TableView<Usuario> table_lista_Usuarios;
    @FXML
    private TableColumn<Usuario, String> table_Usuarios_Cod;
    @FXML
    private TableColumn<Usuario, String> table_Usuarios_Nome;
    @FXML
    private TableColumn<Usuario, String> table_Usuarios_Email;
    @FXML
    private TableColumn<Usuario, String> table_Usuarios_NivelAcesso;
    @FXML
    private ComboBox<String> cbox_usuarioStatus;
    @FXML
    private TableColumn<?, ?> table_Usuarios_Status;
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
       
    static int alter_UsuarioId;
    
    @FXML
    private void AlterUsuarios(ActionEvent event) throws IOException
    {
        alter_UsuarioId = table_lista_Usuarios.getSelectionModel().getSelectedItem().getUsuario_Id();
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_Usuarios.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void DeletarUsuarios(ActionEvent event) throws Exception
    {
        int usuario_LogadoId = PesqUsuariosController.alter_UsuarioId;
        int usuario_id = table_lista_Usuarios.getSelectionModel().getSelectedItem().getUsuario_Id();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText("Deseja mesmo desativar este usuario?");
        //alert.setContentText("Ao excluir não há como recuperar os dados");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            Connection conn = null;
            ResultSet resultadoBanco = null;       
            conn = DBConexao.abrirConexao();
            Statement stm = conn.createStatement();
            
            if(usuario_LogadoId == usuario_id)
            {
               Alert alerta = new Alert(Alert.AlertType.ERROR);
               alerta.setTitle("ERRO");
               alerta.setHeaderText("Não é possivel excluir usuario Logado"); 
            }
            else
            {
                Connection con = null;
                ResultSet resultBanco = null;
                conn = DBConexao.abrirConexao();

                Statement stm1 = conn.createStatement();
                String query;
                
                String sql;
                sql = "UPDATE usuarios SET "
                    + "usuario_status = 'Inativo' "    
                    + "WHERE usuario_id = "+ usuario_id +";";
                stm.executeUpdate(sql);

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Usuario desativado com sucesso !");
                alerta.showAndWait();

                PesqUsuarios(event);
            }
        } 
        else{ PesqUsuarios(event);}
    }
    
    private ObservableList<Usuario> linhas_banco;
    @FXML
    private void PesqUsuarios(ActionEvent event) throws Exception
    {
        String usuario_nome = txt_UsuarioNome.getText();
        String usuario_status = cbox_usuarioStatus.getValue();
        if(usuario_status == null){ usuario_status = "";}
        String usuario_NivelAcesso = (String) cbox_UsuarioNivelAcesso.getValue();
        if(usuario_NivelAcesso == null){ usuario_NivelAcesso = "";}
        
        Connection conn = null;
        ResultSet resultadoBanco = null;
        conn = DBConexao.abrirConexao();
        
        List<Usuario> usuarios = new ArrayList<>();
        
        String sql;
        String sql1 = " WHERE usuario_nome LIKE ? AND usuario_nivel_acesso LIKE ? AND usuario_status LIKE ? ";
        sql = "SELECT usuario_id, usuario_nome, usuario_login, usuario_senha, usuario_email, usuario_nivel_acesso, usuario_status FROM usuarios "
                + sql1;
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, "%" + usuario_nome + "%");
        pstm.setString(2, "%" + usuario_NivelAcesso + "%");
        pstm.setString(3, "%" + usuario_status + "%");
        
        resultadoBanco = pstm.executeQuery();

        linhas_banco = FXCollections.observableArrayList();

        while(resultadoBanco.next())
        {
          linhas_banco.add(new Usuario(resultadoBanco.getInt(1), resultadoBanco.getString(2), resultadoBanco.getString(3), resultadoBanco.getString(4), resultadoBanco.getString(5), resultadoBanco.getString(6), resultadoBanco.getString(7)));
        }

        table_Usuarios_Cod.setCellValueFactory(new PropertyValueFactory<>("usuario_Id"));
        table_Usuarios_Nome.setCellValueFactory(new PropertyValueFactory<>("usuario_Nome"));
        table_Usuarios_Email.setCellValueFactory(new PropertyValueFactory<>("usuario_Email"));
        table_Usuarios_NivelAcesso.setCellValueFactory(new PropertyValueFactory<>("usuario_Nivel_Acesso"));
        table_Usuarios_Status.setCellValueFactory(new PropertyValueFactory<>("usuario_status"));
                
        table_lista_Usuarios.setItems(null);
        table_lista_Usuarios.setItems(linhas_banco);  
    }
    
    private void popular_cbox_Nivel_Acesso()
    {
        // ComboBox Tipo de Instalação
        ObservableList<String> lista = FXCollections.observableArrayList("", "Administrador","Supervisor", "Digitador");
        cbox_UsuarioNivelAcesso.setItems(lista);
    }
    
    private void popular_cbox_Status()
    {
        // ComboBox Tipo de Instalação
        ObservableList<String> lista = FXCollections.observableArrayList("", "Ativo", "Inativo");
        cbox_usuarioStatus.setItems(lista);
    }
    
}
