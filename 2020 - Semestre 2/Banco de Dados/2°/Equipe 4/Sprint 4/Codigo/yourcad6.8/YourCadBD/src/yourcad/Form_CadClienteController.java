package yourcad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.net.*;
import java.net.URLConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import yourcad.DBConexao.*;
import yourcad.Cliente;
import yourcad.Form_CadInstalacoesController;
import static yourcad.Form_CadInstalacoesController.instalacao_id;
import yourcad.TextFieldFormatter.*;

//import yourcad.PesqClienteController.*;

/**
 * FXML Controller class
 *
 * @author mateu
 */
public class Form_CadClienteController implements Initializable {
    String logradouro;      
    String bairro;
    String cidade;
    String uf;
    
    @FXML
    private MenuBar menuBar_TelaInicial;
    @FXML
    private MenuItem menuItem_CadCliente;
    @FXML
    private MenuItem menuItem_CadConta;
    @FXML
    private MenuItem menuItem_CadConcessionaria;
    @FXML
    private AnchorPane ancPane_TelaInicio;
    @FXML
    private TextField txtFld_NomeCliente;
    private TextField txtFld_ApelidoCliente;
    @FXML
    private TextField txtFld_DocCliente;
    private TextField txtFld_CepCliente;
    private TextField txtFld_NumEndCliente;
    private TextField txtFld_ComplEndCliente;
    private TextField txtFld_EndCliente;
    private TextField txtFld_CidadeEndCliente;
    private TextField txtFld_UfEndCliente;
    @FXML
    private Button btn_CadCliente;
    @FXML
    private Button btn_NovoInstalacao;
    @FXML
    private Button btn_LimparCliente;
    @FXML
    private MenuItem menuItem_PesqCliente;
    @FXML
    private MenuItem menuItem_PesqConta;
    @FXML
    private MenuItem menuItem_PesqConcessionaria;
    @FXML
    private BorderPane mainPane;
    @FXML
    private TextField txtFld_apelidoCliente;
    @FXML
    private TextField txtFld_numEndCliente;
    @FXML
    private TextField txtFld_ufCliente;
    @FXML
    private TextField txtFld_bairroCliente;
    @FXML
    private TextField txtFld_endcomplementoCliente;
    @FXML
    private TextField txtFld_enderecoCliente;
    @FXML
    private TextField txtFld_cepCliente;
    @FXML
    private TextField txtFld_CidadeCliente;
    @FXML
    private Button btnAlterarInstalacao;
    @FXML
    private Button btnDeletarInstalacao;
    @FXML
    private TableColumn<Instalacao, String> table_instalacao_numero;
    @FXML
    private TableColumn<Instalacao, String> table_instalacao_apelido;
    @FXML
    private TableColumn<Instalacao, String> table_instalacao_tipo;
    @FXML
    private TableView<Instalacao> table_Instalacoes;
    @FXML
    private Menu menu_Configuracao;
    @FXML
    private MenuItem menuItem_CadUsuarios;
    @FXML
    private MenuItem menuItem_PesqUsuarios;
    @FXML
    private TextField txtFld_idCliente; 
    @FXML
    private MenuItem menuItem_RelatAcessos;
    @FXML
    private MenuItem menuItem_RelatClientes;
    @FXML
    private MenuItem menuItem_RelatDigitador;
    @FXML
    private Menu menu_Cadastro;
    @FXML
    private Menu menu_Relatorios;
    @FXML
    private Menu menu_Sair;
    @FXML
    private MenuItem menuItem_SairSistema;

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

        btnAlterarInstalacao.setVisible(false);
        btnDeletarInstalacao.setVisible(false);
        btn_NovoInstalacao.setVisible(false);
        
        try {
            // TODO
            // Pega id co cliente vindo da pagina de pesquisa clientes
            int id = PesqClienteController.alterClienteId;
            
            // verifica se existe id do cliente se sim ele popula os textfields da pagina para fazer aletração dos dados senão ele traz vazio para uma nova inserção.
            if(id != 0)
            {
                if("Digitador".equals(Form_LoginController.usuario_Nivel_Acesso))
                {
                    btn_NovoInstalacao.setVisible(true);
                    btn_CadCliente.setVisible(false);
                    btn_LimparCliente.setVisible(false);
                    txtFld_idCliente.setEditable(false);
                    txtFld_NomeCliente.setEditable(false);
                    txtFld_DocCliente.setEditable(false);
                    txtFld_apelidoCliente.setEditable(false);
                    txtFld_enderecoCliente.setEditable(false);
                    txtFld_endcomplementoCliente.setEditable(false);
                    txtFld_numEndCliente.setEditable(false);
                    txtFld_ufCliente.setEditable(false);
                    txtFld_CidadeCliente.setEditable(false);
                    txtFld_bairroCliente.setEditable(false);
                    txtFld_cepCliente.setEditable(false);
                }
                else
                {
                    btnAlterarInstalacao.setVisible(true);
                    btnDeletarInstalacao.setVisible(true);
                    btn_NovoInstalacao.setVisible(true);
                }
                try {
                    
                    String cliente_id = null;
                    String cliente_nome = null;
                    String cliente_documento = null;
                    String cliente_apelido = null;
                    String cliente_endereco = null;
                    String cliente_complementoEndereco = null;
                    String cliente_numeroEndereco = null;
                    String cliente_cep = null;
                    String cliente_cidade = null;
                    String cliente_uf = null;
                    String cliente_bairro = null;
                    
                    Connection conn = null;
                    ResultSet resultadoBanco = null;
                    
                    conn = DBConexao.abrirConexao();
                    Statement stm = conn.createStatement();
                    
                    String sql = "SELECT cliente_id, cliente_nome, cliente_documento, cliente_apelido,"
                            + " cliente_endereco, cliente_complemento_endereco, cliente_numero_endereco, cliente_bairro,"
                            + " cliente_cep, cliente_cidade, cliente_uf FROM cliente WHERE cliente_id = "+ id +";";
                    resultadoBanco = stm.executeQuery(sql);
                    
                    while(resultadoBanco.next())
                    {
                        //System.out.printf(resultadoBanco.getString("cliente_nome"));
                        cliente_id = resultadoBanco.getString("cliente_id");
                        cliente_nome = resultadoBanco.getString("cliente_nome");
                        cliente_documento = resultadoBanco.getString("cliente_documento");
                        cliente_apelido = resultadoBanco.getString("cliente_apelido");
                        cliente_endereco = resultadoBanco.getString("cliente_endereco");
                        cliente_complementoEndereco = resultadoBanco.getString("cliente_complemento_endereco");
                        cliente_numeroEndereco = resultadoBanco.getString("cliente_numero_endereco");
                        cliente_bairro = resultadoBanco.getString("cliente_bairro");
                        cliente_cep = resultadoBanco.getString("cliente_cep");
                        cliente_cidade = resultadoBanco.getString("cliente_cidade");
                        cliente_uf = resultadoBanco.getString("cliente_uf");
                        
                    }
                    txtFld_idCliente.setText(cliente_id);
                    txtFld_NomeCliente.setText(cliente_nome);
                    txtFld_DocCliente.setText(cliente_documento);
                    txtFld_apelidoCliente.setText(cliente_apelido);
                    txtFld_enderecoCliente.setText(cliente_endereco);
                    txtFld_endcomplementoCliente.setText(cliente_complementoEndereco);
                    txtFld_numEndCliente.setText(cliente_numeroEndereco);
                    txtFld_ufCliente.setText(cliente_uf);
                    txtFld_CidadeCliente.setText(cliente_cidade);
                    txtFld_bairroCliente.setText(cliente_bairro);
                    txtFld_cepCliente.setText(cliente_cep);
                    
                } catch (Exception ex) {
                    Logger.getLogger(Form_CadClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                tableView_Instalacoes(id);
                //private ObservableList<Instalacao> linhas_banco;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Form_CadClienteController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private void tableView_Instalacoes(int id) throws SQLException, Exception
    {
        // INICIO POPULAR TABLEVIEW INSTALAÇÕES //
            
            Connection conn = null;
            ResultSet resultadoBanco = null;
            conn = DBConexao.abrirConexao();
            Statement stm = conn.createStatement();
            
            List<Instalacao> instalacoes = new ArrayList<>();
            
            resultadoBanco = stm.executeQuery("SELECT instalacao_id, instalacao_numero, instalacao_apelido,"
                    + " instalacao_tipo, concessionaria_id, cliente_id FROM instalacao WHERE cliente_id = " + id + ";" );
            
            ObservableList<Instalacao> linhas_banco = FXCollections.observableArrayList();
            while(resultadoBanco.next()){
                linhas_banco.add(new Instalacao(resultadoBanco.getInt(1), resultadoBanco.getString(2), resultadoBanco.getString(3), resultadoBanco.getString(4), resultadoBanco.getString(5), resultadoBanco.getString(6)));
            }
            
            table_instalacao_apelido.setCellValueFactory(new PropertyValueFactory<>("instalacao_apelido"));
            table_instalacao_numero.setCellValueFactory(new PropertyValueFactory<>("instalacao_numero"));
            table_instalacao_tipo.setCellValueFactory(new PropertyValueFactory<>("instalacao_tipo"));
            
            table_Instalacoes.setItems(null);
            table_Instalacoes.setItems(linhas_banco);       
            
            
            //FIM POPULAR TABLE VIEW INSTALAÇÕES //
    }
    
    @FXML
    private void insertCliente(ActionEvent event) throws Exception {
       
            String cliente_nome = txtFld_NomeCliente.getText();
            String cliente_doc = txtFld_DocCliente.getText();
            String cliente_apelido = txtFld_apelidoCliente.getText();
            String cliente_endereco = txtFld_enderecoCliente.getText();
            String cliente_complemento = txtFld_endcomplementoCliente.getText();
            String cliente_numero = txtFld_numEndCliente.getText();
            String cliente_uf = txtFld_ufCliente.getText();
            String cliente_cidade = txtFld_CidadeCliente.getText();
            String cliente_bairro = txtFld_bairroCliente.getText();
            String cliente_cep = txtFld_cepCliente.getText();
            String cliente_id = txtFld_idCliente.getText();
        
        boolean validar =  validacao();
            
        if (validar == true){
            
        if(Integer.parseInt(cliente_id) != 0)
        {
            
            
            Connection conn = null;
            ResultSet resultadoBanco = null;
                     
            conn = DBConexao.abrirConexao();
            
            String sql;
            sql = "UPDATE cliente SET "
                    + "cliente_nome = ?, "
                    + "cliente_documento = ?, "
                    + "cliente_apelido = ?, "
                    + "cliente_endereco = ?, "
                    + "cliente_complemento_endereco = ?, "
                    + "cliente_numero_endereco = ?, "
                    + "cliente_bairro = ?, "
                    + "cliente_cep = ?, "
                    + "cliente_cidade = ?, "
                    + "cliente_uf = ? "                  
                    + "WHERE cliente_id = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, cliente_nome);
            pstm.setString(2, cliente_doc);
            pstm.setString(3, cliente_apelido);
            pstm.setString(4, cliente_endereco);
            pstm.setString(5, cliente_complemento);
            pstm.setString(6, cliente_numero);
            pstm.setString(7, cliente_bairro);
            pstm.setString(8, cliente_cep);
            pstm.setString(9, cliente_cidade);
            pstm.setString(10, cliente_uf);
            pstm.setString(11, cliente_id);
            
                       
            pstm.executeUpdate();
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Mensagem");
            alert.setHeaderText("Dados alterados com sucesso !");
            alert.showAndWait();
            
        }
        if (Integer.parseInt(cliente_id) == 0){           
       
            Connection conn = null;
            conn = DBConexao.abrirConexao();
            
            String query;
            query = "INSERT INTO cliente(cliente_nome,\n" +
                    "cliente_documento, cliente_apelido, cliente_endereco, cliente_complemento_endereco,"
                    + " cliente_numero_endereco, cliente_uf, cliente_cidade, cliente_bairro, cliente_cep) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pstm = conn.prepareStatement(query);
         
            pstm.setString(1, cliente_nome);
            pstm.setString(2, cliente_doc);
            pstm.setString(3, cliente_apelido);
            pstm.setString(4, cliente_endereco);
            pstm.setString(5, cliente_complemento);
            pstm.setString(6, cliente_numero);
            pstm.setString(7, cliente_bairro);
            pstm.setString(8, cliente_cep);
            pstm.setString(9, cliente_cidade);
            pstm.setString(10, cliente_uf);
            
            pstm.executeUpdate();
            
            Statement stm0 = conn.createStatement();
            String query0;
            query0 = "SELECT LAST_INSERT_ID();";
            ResultSet resultado = stm0.executeQuery(query0);
            int cliente = 0;
            while(resultado.next())
            {
                cliente = resultado.getInt("LAST_INSERT_ID()"); 
            }
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Mensagem");
            alert.setHeaderText("Dados salvos com sucesso !");
            alert.showAndWait();
            
            
            if("Digitador".equals(Form_LoginController.usuario_Nivel_Acesso))
            {
                //Funções não habilitadas para digitador: ******
                btn_NovoInstalacao.setVisible(true);
                btnAlterarInstalacao.setVisible(false);
                btnDeletarInstalacao.setVisible(false);
                //***********************************************
            }
            else
            {
            btnAlterarInstalacao.setVisible(true);
            btnDeletarInstalacao.setVisible(true);
            btn_NovoInstalacao.setVisible(true);
            txtFld_idCliente.setText(Integer.toString(cliente));
            }
        }
        }
   }

    @FXML
    private void limparCliente(ActionEvent event) {
        
        txtFld_NomeCliente.setText("");
        txtFld_idCliente.setText("0");
        txtFld_DocCliente.setText("");
        txtFld_apelidoCliente.setText("");
        txtFld_enderecoCliente.setText("");
        txtFld_endcomplementoCliente.setText("");
        txtFld_numEndCliente.setText("");
        txtFld_ufCliente.setText("");
        txtFld_CidadeCliente.setText("");
        txtFld_bairroCliente.setText("");
        txtFld_cepCliente.setText("");
        
    }
    
    //Variavel para levar o id do cliente para pagina de cadastro de instalacao
    static String clienteInstalacao;
    @FXML
    private void cadInstalacao(ActionEvent event) throws IOException 
    {
        clienteInstalacao = txtFld_idCliente.getText();
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_CadInstalacoes.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    static int alterInstalacaoId;
    static int alterInstalacaoNome;
    
    @FXML
    private void alterarInstalacao(ActionEvent event) throws Exception {
        alterInstalacaoId = table_Instalacoes.getSelectionModel().getSelectedItem().getInstalacao_id();
      
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_CadInstalacoes.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }


    @FXML
    private void deletarInstalacao(ActionEvent event) throws SQLException, Exception { 
        
        alterInstalacaoId = table_Instalacoes.getSelectionModel().getSelectedItem().getInstalacao_id();
        
        Connection conn = null;
        ResultSet resultadoBanco = null;
                     
        conn = DBConexao.abrirConexao();
        Statement stm = conn.createStatement();
        
        //****** Selecionando tipo de instalação
        String sql0;
        sql0 = "SELECT * FROM instalacao WHERE instalacao_id = " + alterInstalacaoId +";";
        resultadoBanco = stm.executeQuery(sql0);
        String instalacao_tipo = null;
       
        while(resultadoBanco.next()){         
            instalacao_tipo = resultadoBanco.getString("instalacao_tipo");
        }
        
        // ***** Se for de agua deleta instalacao de agua
        if("Agua e Esgoto".equals(instalacao_tipo))
        {
            String sql1;
            sql1 = "DELETE FROM instalacao_agua WHERE instalacao_id = " + alterInstalacaoId +";";
            stm.executeUpdate(sql1);    
        }
        // ***** Se for de energia deleta instalacao de energia
        if("Energia".equals(instalacao_tipo))
        {
            String sql2;
            sql2 = "DELETE FROM instalacao_energia WHERE instalacao_id = " + alterInstalacaoId +";";
            stm.executeUpdate(sql2);
        }
        
        // ***** Apaga a instalacao
        String sql3;
        sql3 = "DELETE FROM instalacao WHERE instalacao_id = " + alterInstalacaoId +";";
        stm.executeUpdate(sql3);
        
        // ***** Chama a função de listagem de instalações novamente
        int id = Integer.parseInt(txtFld_idCliente.getText());
        tableView_Instalacoes(id);
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
    
    @FXML
    private void mascaraCEP(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        if (txtFld_cepCliente.getText().length() == 8){
        tff.setMask("#####-###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtFld_cepCliente);
        tff.formatter();        
        }
    }

    private boolean validacao (){

        
        if ("".equals(txtFld_NomeCliente.getText()))
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Nome do Cliente não pode ser vazio");
            alert.showAndWait();
            txtFld_NomeCliente.requestFocus();
            return false;
        }
        else if ("".equals(txtFld_apelidoCliente.getText()))
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Apelido do Cliente não pode ser vazio");
            alert.showAndWait();
            txtFld_apelidoCliente.requestFocus();
            return false;
        }
        else if ("".equals(txtFld_DocCliente.getText()))
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Documento do Cliente não pode ser vazio");
            alert.showAndWait();
            txtFld_DocCliente.requestFocus();
            return false;
        }else {return true;} 
    }
    
}
