/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourcad;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import yourcad.DBConexao.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MaXx
 */
public class Form_LoginController implements Initializable {

    @FXML
    private Button btn_Logar;
    @FXML
    private TextField txt_Login;
    @FXML
    private PasswordField txt_Senha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    
    static String usuario_Id;
    static String usuario_Nome;
    static String usuario_Login;
    static String usuario_Nivel_Acesso;
    static String usuario_Email;

    @FXML
    public void logar_Sistema(ActionEvent event) throws Exception {
        
        String usuario = txt_Login.getText();
        String senha = txt_Senha.getText();
        boolean autenticado = false;
        
        Date data1 = new Date();
        SimpleDateFormat format_data = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat format_hora = new SimpleDateFormat("HH:mm:ss");
        String data = format_data.format(data1); // 14/03/2016
        String hora = format_hora.format(data1);
        
        Connection conn = null;
        ResultSet resultadoBanco = null;
        conn = DBConexao.abrirConexao();
        
        String sql;
        String sql1 = null;
        if(!"".equals(usuario) && !"".equals(senha)){ sql1 = " WHERE usuario_login = ? && usuario_senha = ? ";}
        else{sql1 = "";}
        sql = "SELECT * FROM usuarios " + sql1;
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, usuario);
        pstm.setString(2, senha);
        
        resultadoBanco = pstm.executeQuery();       
        
        if (resultadoBanco.next()) 
        {
            usuario_Id = resultadoBanco.getString("usuario_id");
            usuario_Nome = resultadoBanco.getString("usuario_nome");
            usuario_Login = resultadoBanco.getString("usuario_login");
            usuario_Nivel_Acesso = resultadoBanco.getString("usuario_nivel_acesso");
            usuario_Email = resultadoBanco.getString("usuario_email");
            String usuario_Status = resultadoBanco.getString("usuario_status");
            
            if("Inativo".equals(usuario_Status))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Usuario desativado, não é possivel fazer login");
                alert.setContentText("Contate o administrador do sistema");
                alert.showAndWait();
                txt_Login.requestFocus();
                
                autenticado = false;
            }
            else
            { 
                autenticado = true; 
                
                Connection con = null;
                con = DBConexao.abrirConexao();
                Statement stm1 = con.createStatement();
                String query;
                query = "INSERT INTO acessos(acesso_usuario_id, acesso_data, acesso_hora) VALUES "
                    + "('"+ usuario_Id +"','"
                        + data +"','"
                        + hora +"');";
                stm1.executeUpdate(query);
                
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show();
            }   
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Dados Invalidos");
            alert.showAndWait();
            txt_Login.requestFocus();
        }      
    }

}


