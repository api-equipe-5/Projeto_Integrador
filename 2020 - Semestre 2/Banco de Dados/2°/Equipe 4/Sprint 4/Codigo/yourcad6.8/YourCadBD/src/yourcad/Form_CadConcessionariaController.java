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
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

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
    @FXML
    private Menu menu_Configuracao;
    @FXML
    private MenuItem menuItem_CadUsuarios;
    @FXML
    private MenuItem menuItem_PesqUsuarios;
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
        
        int id = PesqConcessionariaController.alterConcessionariaId;
        
        if(id != 0)
        {        
            if("Digitador".equals(Form_LoginController.usuario_Nivel_Acesso))
            {
                btn_CadConcessionaria.setVisible(false);
                btn_LimparConcessionaria.setVisible(false);
                txtFld_CepConcessionaria.setEditable(false);
                txtFld_CidadeConcessionaria.setEditable(false);
                txtFld_CnpjConcessionaria.setEditable(false);
                txtFld_CompEndConcessionaria.setEditable(false);
                txtFld_EmailConcessionaria.setEditable(false);
                txtFld_EndConcessionaria.setEditable(false);
                txtFld_InscEstadualConcessionaria.setEditable(false);
                txtFld_NomeConcessionaria.setEditable(false);
                txtFld_NumEndConcessionaria.setEditable(false);
                txtFld_SiteConcessionaria.setEditable(false);
                txtFld_UfEndConcessionaria.setEditable(false);
                txtFld_bairroConcessionaria.setEditable(false);
                txt_IdConcessionaria.setEditable(false);
            }
            else
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
        boolean validar =  validacao();
            
        if (validar == true){
        
        if(PesqConcessionariaController.alterConcessionariaId != 0)
        {
            Connection conn = null;
            ResultSet resultadoBanco = null;
                     
            conn = DBConexao.abrirConexao();
            
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
                    + "concessionaria_cnpj = ?, "
                    + "concessionaria_nome = ?, "
                    + "concessionaria_inscricao_estadual = ?, "
                    + "concessionaria_endereco = ?, "
                    + "concessionaria_bairro = ?, "
                    + "concessionaria_numero_endereco = ?, "
                    + "concessionaria_complemento_endereco = ?, "
                    + "concessionaria_cep = ?, "
                    + "concessionaria_cidade = ?, "
                    + "concessionaria_uf = ?, "
                    + "concessionaria_email = ?, "
                    + "concessionaria_site = ? "
                    + "WHERE concessionaria_id = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, CnpjConcessionaria);
            pstm.setString(2, NomeConcessionaria);
            pstm.setString(3, InscEstadualConcessionaria);
            pstm.setString(4, EndConcessionaria);
            pstm.setString(5, BairroConcessionaria);
            pstm.setString(6, NumEndConcessionariaTxt);
            pstm.setString(7, CompEndConcessionaria);
            pstm.setString(8, CepConcessionaria);
            pstm.setString(9, CidadeConcessionaria);
            pstm.setString(10, UfEndConcessionaria);
            pstm.setString(11, EmailConcessionaria);
            pstm.setString(12, SiteConcessionaria);
            pstm.setString(13, idconcessionaria);
                       
            pstm.executeUpdate();
            
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
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pstm = conn.prepareStatement(query);
        pstm.setString(1, CnpjConcessionaria);
            pstm.setString(2, NomeConcessionaria);
            pstm.setString(3, InscEstadualConcessionaria);
            pstm.setString(4, EndConcessionaria);
            pstm.setString(5, BairroConcessionaria);
            pstm.setString(6, NumEndConcessionariaTxt);
            pstm.setString(7, CompEndConcessionaria);
            pstm.setString(8, CepConcessionaria);
            pstm.setString(9, CidadeConcessionaria);
            pstm.setString(10, UfEndConcessionaria);
            pstm.setString(11, EmailConcessionaria);
            pstm.setString(12, SiteConcessionaria);
        
        pstm.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensagem");
            alert.setHeaderText("Dados salvos com sucesso !");
            alert.showAndWait();
            btn_Limpar();
        }
        }
        
    }
    
    @FXML
    private void mascaraDocumento(javafx.scene.input.KeyEvent event) {
    TextFieldFormatter tff = new TextFieldFormatter();
        if (txtFld_CnpjConcessionaria.getText().length() == 13)
        {
        tff.setMask("##.###.###/####-#");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtFld_CnpjConcessionaria);
        tff.formatter();        
        } 
    }
    
    @FXML
    private void mascaraCEP(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        if (txtFld_CepConcessionaria.getText().length() == 8){
        tff.setMask("#####-###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtFld_CepConcessionaria);
        tff.formatter();        
        }
    }
    
    
        private boolean validacao (){

        
        if ("".equals(txtFld_NomeConcessionaria.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Nome da Concessionaria não pode ser vazio");
            alert.showAndWait();
            txtFld_NomeConcessionaria.requestFocus();
            return false;
        }
        else if ("".equals(txtFld_CnpjConcessionaria.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo CNPJ da Concessionaria não pode ser vazio");
            alert.showAndWait();
            txtFld_CnpjConcessionaria.requestFocus();
            return false;
        }
        else if ("".equals(txtFld_EmailConcessionaria.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Email da Concessinaria não pode ser vazio");
            alert.showAndWait();
            txtFld_EmailConcessionaria.requestFocus();
            return false;
        }
        else if ("".equals(txtFld_SiteConcessionaria.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Site da Concessionaria não pode ser vazio");
            alert.showAndWait();
            txtFld_SiteConcessionaria.requestFocus();
            return false;
        } else {return true;} 
    }
        

         
}   

