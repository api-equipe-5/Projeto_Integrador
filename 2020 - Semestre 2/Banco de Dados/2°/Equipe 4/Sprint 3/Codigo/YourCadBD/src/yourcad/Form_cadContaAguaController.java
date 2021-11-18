/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourcad;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mateu
 */
public class Form_cadContaAguaController implements Initializable {

    @FXML
    private Button btn_SalvarAgua;
    @FXML
    private Button btn_LimparAgua;
    @FXML
    private TextField txt_AguaCompetencia;
    @FXML
    private TextField txt_AguaVencimento;
    private TextField txt_AguaDataLeituraAnt;
    @FXML
    private TextField txt_AguaDataLeituraAtual;
    @FXML
    private TextField txt_AguaPrevProxLeitura;
    @FXML
    private TextField txt_AguaValorAtual;
    @FXML
    private TextField txt_AguaValorAgua;
    @FXML
    private TextField txt_AguaValorEsgoto;
    @FXML
    private TextField txt_AguaMulta;
    @FXML
    private TextField txt_AguaTrcf;
    @FXML
    private TextField txt_AguaBaseCofins;
    @FXML
    private TextField txt_AguaAliquotaCofins;

    /**
     * Initializes the controller class.
     */
    int contaID = 0;
    @FXML
    private TextField txt_ContaId;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        contaID = Form_CadContaController.conta_Id;
        
        if(contaID != 0)
        {
            try{
                Connection conn = null;
                ResultSet resultadoBanco = null;
                conn = DBConexao.abrirConexao();
                Statement stm = conn.createStatement();

                    //****** Selecionando tipo de instalação
                    String sql0;
                    sql0 = "SELECT * FROM conta_agua WHERE conta_id = " + contaID +";";
                    resultadoBanco = stm.executeQuery(sql0);

                    String conta_id = null;
                    String conta_agua_mes = null;
                    String conta_agua_vencimento = null;
                    String conta_agua_data_atual_leitura = null;
                    String conta_agua_data_previsao_proxima_leitura = null;
                    String conta_agua_valor_atual_leitura = null;
                    String conta_agua_valor_agua = null;
                    String conta_agua_valor_esgoto = null;
                    String conta_agua_multa = null;
                    String conta_agua_trcf = null;
                    String conta_agua_base_pis_cofins = null;
                    String conta_agua_aliquota_pis_cofins = null;
                    

                    while(resultadoBanco.next())
                    { 
                        conta_id = resultadoBanco.getString("conta_id"); 
                        conta_agua_mes = resultadoBanco.getString("conta_agua_mes"); 
                        conta_agua_vencimento = resultadoBanco.getString("conta_agua_vencimento"); 
                        conta_agua_data_atual_leitura = resultadoBanco.getString("conta_agua_data_atual_leitura"); 
                        conta_agua_data_previsao_proxima_leitura = resultadoBanco.getString("conta_agua_data_previsao_proxima_leitura"); 
                        conta_agua_valor_atual_leitura = resultadoBanco.getString("conta_agua_valor_atual_leitura"); 
                        conta_agua_valor_agua = resultadoBanco.getString("conta_agua_valor_agua"); 
                        conta_agua_valor_esgoto = resultadoBanco.getString("conta_agua_valor_esgoto"); 
                        conta_agua_multa = resultadoBanco.getString("conta_agua_multa"); 
                        conta_agua_trcf = resultadoBanco.getString("conta_agua_trcf"); 
                        conta_agua_base_pis_cofins = resultadoBanco.getString("conta_agua_base_pis_cofins"); 
                        conta_agua_aliquota_pis_cofins = resultadoBanco.getString("conta_agua_aliquota_pis_cofins"); 
                        
                    }
                    txt_ContaId.setText(conta_id);
                    txt_AguaCompetencia.setText(conta_agua_mes);
                    txt_AguaVencimento.setText(conta_agua_vencimento);
                    txt_AguaPrevProxLeitura.setText(conta_agua_data_previsao_proxima_leitura);
                    txt_AguaDataLeituraAtual.setText(conta_agua_data_atual_leitura);
                    txt_AguaValorAtual.setText(conta_agua_valor_atual_leitura);
                    txt_AguaValorAgua.setText(conta_agua_valor_agua);
                    txt_AguaValorEsgoto.setText(conta_agua_valor_esgoto);
                    txt_AguaTrcf.setText(conta_agua_trcf);
                    txt_AguaMulta.setText(conta_agua_multa);
                    txt_AguaBaseCofins.setText(conta_agua_base_pis_cofins);
                    txt_AguaAliquotaCofins.setText(conta_agua_aliquota_pis_cofins);
            
            }catch(Exception ex) { Logger.getLogger(Form_CadClienteController.class.getName()).log(Level.SEVERE, null, ex);}
            
        }else{ LimparAgua();}
    }    

    @FXML
    private void SalvarAgua(ActionEvent event) throws Exception {
    
        String instalacao_id = Form_CadContaController.contaInstalacaoId;
        String instalacao_numero = Form_CadContaController.contaInstalacaoNum;
        String cliente_id = Form_CadContaController.clienteId;
        String conta_competencia = txt_AguaCompetencia.getText();
        String conta_vencimento = txt_AguaVencimento.getText();
        String conta_dataProximaLeitura = txt_AguaPrevProxLeitura.getText();
        String conta_dataLeituraAtual = txt_AguaDataLeituraAtual.getText();
        String conta_valorAtual = txt_AguaValorAtual.getText();
        String conta_valorAgua = txt_AguaValorAgua.getText();
        String conta_valorEsgoto = txt_AguaValorEsgoto.getText();
        String conta_trcf = txt_AguaTrcf.getText();
        String conta_multa = txt_AguaMulta.getText();
        String conta_basePis = txt_AguaBaseCofins.getText();
        String conta_aliquota = txt_AguaAliquotaCofins.getText();
        String conta_Id = txt_ContaId.getText();
    
        if(Integer.parseInt(conta_Id) != 0)
        {
            
            Connection conn = null;
            ResultSet resultadoBanco = null;
            conn = DBConexao.abrirConexao();
            Statement stm = conn.createStatement();
                        
            String sql;
            sql = "UPDATE conta_agua SET "
                    + "conta_agua_mes = '"+ conta_competencia +"', "
                    + "conta_agua_vencimento = '"+ conta_vencimento +"', "
                    + "conta_agua_data_atual_leitura = '"+ conta_dataLeituraAtual +"', "
                    + "conta_agua_data_previsao_proxima_leitura = '"+ conta_dataProximaLeitura +"', "
                    + "conta_agua_valor_atual_leitura = '"+ conta_valorAtual +"', "
                    + "conta_agua_valor_agua = '"+ conta_valorAgua +"', "
                    + "conta_agua_valor_esgoto = '"+ conta_valorEsgoto +"', "
                    + "conta_agua_multa = '"+ conta_multa +"', "
                    + "conta_agua_trcf = '"+ conta_trcf +"', "
                    + "conta_agua_base_pis_cofins = '"+ conta_basePis +"', " 
                    + "conta_agua_aliquota_pis_cofins = '"+ conta_aliquota +"' " 
                    + "WHERE conta_id = "+ conta_Id +";";        
            stm.executeUpdate(sql);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensagem");
            alert.setHeaderText("Dados alterados com sucesso !");
            alert.showAndWait();
            
        } else{
        
        
            int conta_id = 0;

            Connection conn = null;
            conn = DBConexao.abrirConexao();

            Statement stm0 = conn.createStatement(); 
            String query0;
            query0 = "INSERT INTO conta(instalacao_id, cliente_id, conta_numero_instalacao, conta_tipo) VALUES "+
                    "("+ instalacao_id +", "
                       + cliente_id +", '"
                       + instalacao_numero +"', '"
                    + "Agua e Esgoto');";
            stm0.executeUpdate(query0);

            Statement stm1 = conn.createStatement();
            String query1;
            query1 = "SELECT LAST_INSERT_ID();";
            ResultSet resultado = stm1.executeQuery(query1);
            while(resultado.next()){ conta_id = resultado.getInt("LAST_INSERT_ID()"); }

            Statement stm = conn.createStatement();      
            String query;
            query = "INSERT INTO conta_agua(conta_id, conta_agua_mes, conta_agua_vencimento, conta_agua_data_atual_leitura, conta_agua_data_previsao_proxima_leitura, " +
                    "conta_agua_valor_atual_leitura, conta_agua_valor_agua, conta_agua_valor_esgoto, conta_agua_multa, conta_agua_trcf, conta_agua_base_pis_cofins, "
                    + "conta_agua_aliquota_pis_cofins ) VALUES"
                      +  "("+ conta_id +",'"
                            + conta_competencia +"','"
                            + conta_vencimento +"','"
                            + conta_dataLeituraAtual +"','"
                            + conta_dataProximaLeitura +"','"
                            + conta_valorAtual +"','"
                            + conta_valorAgua +"','"
                            + conta_valorEsgoto +"','"
                            + conta_multa +"','"
                            + conta_trcf +"','"
                            + conta_basePis +"','"
                            + conta_aliquota +"');";

                stm.executeUpdate(query);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensagem");
                alert.setHeaderText("Dados salvos com sucesso !");
                alert.showAndWait();
                LimparAgua();
        
        }
        
    }

    @FXML
    public void LimparAgua() {
        txt_ContaId.setText("0");
        txt_AguaAliquotaCofins.setText("");
        txt_AguaBaseCofins.setText("");
        txt_AguaCompetencia.setText("");
        txt_AguaDataLeituraAtual.setText("");
        txt_AguaMulta.setText("");
        txt_AguaPrevProxLeitura.setText("");
        txt_AguaTrcf.setText("");
        txt_AguaValorAgua.setText("");
        txt_AguaValorAtual.setText("");
        txt_AguaValorEsgoto.setText("");
        txt_AguaVencimento.setText("");
    }
    
}
