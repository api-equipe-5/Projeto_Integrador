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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static yourcad.PesqContaEnergiaController.contaAlterId;

/**
 * FXML Controller class
 *
 * @author info-chefe
 */
public class PesqContaAguaController implements Initializable {

    @FXML
    private TableView<ContaAgua> tbview_Contas;
    @FXML
    private TableColumn<ContaAgua, String> col_NInstalacao;
    @FXML
    private TableColumn<ContaAgua, String> col_ApelidoInstalacao;
    @FXML
    private TableColumn<ContaAgua, String> col_cliente;
    @FXML
    private TableColumn<ContaAgua, String> col_ValorConta;
    @FXML
    private TableColumn<ContaAgua, String> col_CompetenciaConta;
    @FXML
    private Button btn_Alterar;
    @FXML
    private Button btn_Deletar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            popular_tbView();
        } catch (Exception ex) {
            Logger.getLogger(PesqContaAguaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
    
    private ObservableList<ContaAgua> linhas_banco;
    public void popular_tbView() throws Exception
    {
        //String contaId = PesqContaController.contaId;
        
        Connection conn = null;
        ResultSet resultadoBanco0 = null;
        ResultSet resultadoBanco = null;
        conn = DBConexao.abrirConexao();
        Statement stm = conn.createStatement();
        
         //List<ContaEnergia> linhas_banco = new ArrayList<>();
            linhas_banco = FXCollections.observableArrayList();
              
            String sql1;
            sql1 = "SELECT conta_agua.conta_id, instalacao_numero, instalacao_apelido, cliente_nome, "
                  + " conta_agua_valor_atual_leitura, conta_agua_mes FROM conta " 
                  + " INNER JOIN conta_agua ON conta.conta_id = conta_agua.conta_id "
                  + " INNER JOIN instalacao ON conta.instalacao_id = instalacao.instalacao_id "
                  + " INNER JOIN cliente ON conta.cliente_id = cliente.cliente_id "
                  + " WHERE conta.conta_numero_instalacao = " + PesqContaController.numInstalacao +";";
            
            System.out.println(sql1);
            resultadoBanco = stm.executeQuery(sql1);
                       
            while(resultadoBanco.next())
            {
                linhas_banco.add(new ContaAgua(resultadoBanco.getInt(1),resultadoBanco.getString(2),resultadoBanco.getString(3),resultadoBanco.getString(4),
                resultadoBanco.getString(5),resultadoBanco.getString(6)));
            }
  
            col_NInstalacao.setCellValueFactory(new PropertyValueFactory<>("instalacao_numero"));;
            col_ApelidoInstalacao.setCellValueFactory(new PropertyValueFactory<>("instalacaoApelido"));
            col_cliente.setCellValueFactory(new PropertyValueFactory<>("cliente_id"));
            col_ValorConta.setCellValueFactory(new PropertyValueFactory<>("conta_valorAtual"));
            col_CompetenciaConta.setCellValueFactory(new PropertyValueFactory<>("conta_competencia"));

            tbview_Contas.setItems(null);
            tbview_Contas.setItems(linhas_banco);
    }
    static int contaAlterId;
    @FXML
    private void alterarContaAgua(ActionEvent event) throws IOException {
        contaAlterId = tbview_Contas.getSelectionModel().getSelectedItem().getConta_aguaId();
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_CadConta.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void deletarContaAgua(ActionEvent event) throws SQLException, Exception {
        
      contaAlterId = tbview_Contas.getSelectionModel().getSelectedItem().getConta_aguaId();
        
        Connection conn = null;
        ResultSet resultadoBanco = null;           
        conn = DBConexao.abrirConexao();
        
        String conta_id = null;
        String conta_tipo = null;
        Statement stm0 = conn.createStatement();
        String sql0;
        sql0 = "SELECT * FROM conta WHERE conta_id = "+contaAlterId+";";
        resultadoBanco = stm0.executeQuery(sql0);
        while(resultadoBanco.next())
        {
            conta_id = resultadoBanco.getString("conta_id");
            conta_tipo = resultadoBanco.getString("conta_tipo");
        }
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação de Exclusao");
        alert.setHeaderText("Deseja realmente excluir este cliente?");
        //alert.setContentText("Ao excluir não há como recuperar os dados");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            if("Energia".equals(conta_tipo))
            {
                Statement stm1 = conn.createStatement();
                String sql1;
                sql1 = "DELETE FROM conta WHERE conta_id = " +contaAlterId+";";
                stm1.executeUpdate(sql1);

                Statement stm2 = conn.createStatement();
                String sql2;
                sql2 = "DELETE FROM conta_energia WHERE conta_id = "+contaAlterId+";";
                stm2.executeUpdate(sql2);
            }
            if("Agua e Esgoto".equals(conta_tipo))
            {
                Statement stm1 = conn.createStatement();
                String sql1;
                sql1 = "DELETE FROM conta WHERE conta_id = " +contaAlterId+";";
                stm1.executeUpdate(sql1);

                Statement stm2 = conn.createStatement();
                String sql2;
                sql2 = "DELETE FROM conta_agua WHERE conta_id = "+contaAlterId+";";
                stm2.executeUpdate(sql2);
            }     
            popular_tbView();
        }
        else{ popular_tbView();}      
    }
    
}
