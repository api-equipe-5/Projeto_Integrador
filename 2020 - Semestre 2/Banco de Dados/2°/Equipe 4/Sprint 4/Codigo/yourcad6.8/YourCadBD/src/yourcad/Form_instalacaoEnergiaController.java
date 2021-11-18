/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourcad;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static yourcad.Form_CadClienteController.alterInstalacaoId;

/**
 * FXML Controller class
 *
 * @author MaXx
 */
public class Form_instalacaoEnergiaController implements Initializable {

    @FXML
    private TextField txt_codFiscalEnergia;
    @FXML
    private TextField txt_codIdentificacaoEnergia;
    @FXML
    private TextField txt_grupoEnergia;
    @FXML
    private TextField txt_subgrupoEnergia;
    @FXML
    private TextField txt_classeEnergia;
    @FXML
    private TextField txt_tipofornecimentoEnergia;
    @FXML
    private TextField txt_modalidadeEnergia;
    @FXML
    private TextField txt_roteiroEnergia;
    @FXML
    private TextField txt_tensaoEnergia;
    @FXML
    private TextField txt_medidorEnergia;
    @FXML
    private AnchorPane panelEnergia;
    @FXML
    private Button btn_salvarInstEnergia;
    @FXML
    private TextField txt_idInstalacao;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int instalacao_id = Form_CadClienteController.alterInstalacaoId;
        
        if(instalacao_id != 0)
        {
            try{
                Connection conn = null;
                ResultSet resultadoBanco = null;
                conn = DBConexao.abrirConexao();
                Statement stm = conn.createStatement();

                //****** Selecionando tipo de instalação
                String sql0;
                sql0 = "SELECT * FROM instalacao_energia WHERE instalacao_id = " + alterInstalacaoId +";";
                resultadoBanco = stm.executeQuery(sql0);
                
                String inst_id = null;
                String inst_codIdentificacao = null;
                String inst_codFiscal = null;
                String inst_grupo = null;
                String inst_subGrupo = null;
                String inst_classe = null;
                String inst_tpFornecimento = null;
                String inst_modalidadeTarifa = null;
                String inst_tensao = null;
                String inst_roteiroLeitura = null;
                String inst_medidor = null;

                while(resultadoBanco.next())
                { 
                    inst_id = resultadoBanco.getString("instalacao_id"); 
                    inst_codIdentificacao = resultadoBanco.getString("instalacao_energia_codigo_identificacao"); 
                    inst_codFiscal = resultadoBanco.getString("instalacao_energia_codigo_fiscal"); 
                    inst_grupo = resultadoBanco.getString("instalacao_energia_grupo"); 
                    inst_subGrupo = resultadoBanco.getString("instalacao_energia_subgrupo"); 
                    inst_classe = resultadoBanco.getString("instalacao_energia_classe"); 
                    inst_tpFornecimento = resultadoBanco.getString("instalacao_energia_tipo_fornecimento"); 
                    inst_modalidadeTarifa = resultadoBanco.getString("instalacao_energia_modalidade_tarifaria"); 
                    inst_tensao = resultadoBanco.getString("instalacao_energia_tensao"); 
                    inst_roteiroLeitura = resultadoBanco.getString("instalacao_energia_roteiro_leitura"); 
                    inst_medidor = resultadoBanco.getString("instalacao_energia_medidor");
                }
                txt_classeEnergia.setText(inst_classe);
                txt_codFiscalEnergia.setText(inst_codFiscal);
                txt_codIdentificacaoEnergia.setText(inst_codIdentificacao);
                txt_grupoEnergia.setText(inst_grupo);
                txt_idInstalacao.setText(inst_id);
                txt_medidorEnergia.setText(inst_medidor);
                txt_modalidadeEnergia.setText(inst_modalidadeTarifa);
                txt_roteiroEnergia.setText(inst_roteiroLeitura);
                txt_subgrupoEnergia.setText(inst_subGrupo);
                txt_tensaoEnergia.setText(inst_tensao);
                txt_tipofornecimentoEnergia.setText(inst_tpFornecimento);
                                
            }catch (Exception ex) { Logger.getLogger(Form_CadClienteController.class.getName()).log(Level.SEVERE, null, ex);}
        }
        
    }    

    @FXML
    private void salvarInstEnergia(ActionEvent event) throws SQLException, Exception {
        
        int inst_id = Form_CadClienteController.alterInstalacaoId;
        
        String codigoIdentificacao = txt_codIdentificacaoEnergia.getText();
        String codigoFiscal = txt_codFiscalEnergia.getText();
        String grupo = txt_codIdentificacaoEnergia.getText();
        String subgrupo = txt_subgrupoEnergia.getText();
        String classe = txt_classeEnergia.getText();
        String tipoFornecimento = txt_tipofornecimentoEnergia.getText();
        String modalidade = txt_modalidadeEnergia.getText();
        String tensao = txt_tensaoEnergia.getText();
        String roteiro = txt_roteiroEnergia.getText();
        String medidor = txt_medidorEnergia.getText();
        String id_inst = txt_idInstalacao.getText();
       
        if(inst_id == 0)
        {
            Connection conn = null;
            conn = DBConexao.abrirConexao();
            Statement stm = conn.createStatement();
            String query1;
            query1 = "INSERT INTO instalacao_energia(instalacao_id," +
                         "instalacao_energia_codigo_identificacao,\n" +
                         "instalacao_energia_codigo_fiscal,\n" +
                         "instalacao_energia_grupo,\n" +
                         "instalacao_energia_subgrupo,\n" +
                         "instalacao_energia_classe,\n" +
                         "instalacao_energia_tipo_fornecimento,\n" +
                         "instalacao_energia_modalidade_tarifaria,\n" +
                         "instalacao_energia_tensao,\n" +
                         "instalacao_energia_roteiro_leitura,\n" +
                         "instalacao_energia_medidor) VALUES "
                        + "('"+ Form_CadInstalacoesController.instalacao_id +"','"
                        + codigoIdentificacao +"','"
                        + codigoFiscal +"','"
                        + grupo +"','"
                        + subgrupo +"','"
                        + classe +"','"
                        + tipoFornecimento +"','"
                        + modalidade +"','"
                        + tensao +"','"
                        + roteiro +"','"
                        + medidor +"');";
                stm.executeUpdate(query1);
                
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensagem");
            alert.setHeaderText("Dados salvos com sucesso !");
            alert.showAndWait();
            
            Form_CadClienteController.alterInstalacaoId = 0;
        
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_CadInstalacoes.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
            
        }else
        {
            Connection conn = null;
            ResultSet resultadoBanco = null;
                     
            conn = DBConexao.abrirConexao();
            Statement stm = conn.createStatement();

            String sql;
            sql = "UPDATE instalacao_energia SET "
                    + "instalacao_energia_codigo_identificacao = '"+ codigoIdentificacao +"', "
                    + "instalacao_energia_codigo_fiscal = '"+ codigoFiscal +"', "
                    + "instalacao_energia_grupo = '"+ grupo +"', "
                    + "instalacao_energia_subgrupo = '"+ subgrupo +"', "
                    + "instalacao_energia_classe = '"+ classe +"', "
                    + "instalacao_energia_tipo_fornecimento = '"+ tipoFornecimento +"', "
                    + "instalacao_energia_modalidade_tarifaria = '"+ modalidade +"', "
                    + "instalacao_energia_tensao = '"+ tensao +"', "
                    + "instalacao_energia_roteiro_leitura = '"+ roteiro +"', "
                    + "instalacao_energia_medidor = '"+ medidor +"' "            
                    + "WHERE instalacao_id = "+ id_inst +";";

            stm.executeUpdate(sql);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensagem");
            alert.setHeaderText("Dados alterados com sucesso !");
            alert.showAndWait();
        }
    }
    
}
