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
import javafx.scene.layout.Pane;
import static yourcad.Form_CadInstalacoesController.instalacao_id;



/**
 * FXML Controller class
 *
 * @author MaXx
 */
public class Form_cadContaEnergiaController implements Initializable {

    @FXML
    private Pane panel_contaEnergia;
    @FXML
    private TextField txt_EnergiaEmissao;
    @FXML
    private TextField txt_EnergiaLeituraAtual;
    @FXML
    private TextField txt_EnergiaDiasFaturamento;
    @FXML
    private TextField txt_EnergiaCor;
    @FXML
    private TextField txt_EnergiaPeriodo;
    @FXML
    private TextField txt_EnergiaPeriodo2;
    @FXML
    private TextField txt_EnergiaVencimento;
    @FXML
    private TextField txt_EnergiaConsumoMes;
    @FXML
    private TextField txt_EnergiaCompetencia;
    @FXML
    private TextField txt_EnergiaValor;
    @FXML
    private TextField txt_EnergiaQuantidade;
    @FXML
    private TextField txt_EnergiaTarifaImposto;
    @FXML
    private TextField txt_EnergiaValorIcms;
    @FXML
    private TextField txt_EnergiaValorPis;
    @FXML
    private TextField txt_EnergiaAliquotaPis;
    @FXML
    private TextField txt_EnergiaAliquotaIcms;
    @FXML
    private TextField txt_EnergiaValorFornecedor;
    @FXML
    private TextField txt_EnergiaDescricaoProduto;
    @FXML
    private TextField txt_EnergiaBasePisCofins;
    @FXML
    private TextField txt_EnergiaBaseICMS;
    @FXML
    private TextField txt_EnergiaTarifaAplicada;
    @FXML
    private TextField txt_EnergiaCci;
    @FXML
    private TextField txt_EnergiaKwhMes;
    @FXML
    private TextField txt_EnergiaConstMult;
    @FXML
    private TextField txt_EnergiaNMedidor;
    @FXML
    private TextField txt_EnergiaConsumoLeituraAtual;
    @FXML
    private TextField txt_EnergiaDescricao;
    @FXML
    private Button btn_salvarContaEnergia;
    @FXML
    private Button btn_limparContaEnergia;
    @FXML
    private TextField txt_contaId;

    /**
     * Initializes the controller class.
     */
    int contaID = 0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
                    sql0 = "SELECT * FROM conta_energia WHERE conta_id = " + contaID +";";
                    resultadoBanco = stm.executeQuery(sql0);

                    String conta_id = null;
                    String conta_aliqIcms = null;
                    String conta_aliqPis = null;
                    String conta_baseIcms = null;
                    String conta_basePis = null;
                    String conta_cci = null;
                    String conta_competencia = null;
                    String conta_constMult = null;
                    String conta_consLeitAtual = null;
                    String conta_consMes = null;
                    String conta_bandCor = null;
                    String conta_consDescricao = null;
                    String conta_fatDescProduto = null;
                    String conta_fatDias = null;
                    String conta_fatEmissao = null;
                    String conta_consKwh = null;
                    String conta_fatLeitAtual = null;
                    String conta_consMedidor = null;
                    String conta_bandInicio = null;
                    String conta_bandFim  = null;
                    String conta_fatQtd  = null;
                    String conta_fatTariAplicada  = null;
                    String conta_fatTariImposto = null;
                    String conta_valor = null;
                    String conta_valorFornecido = null;
                    String conta_valorIcms = null;
                    String conta_valorPis = null;
                    String conta_Vencimento = null;

                    while(resultadoBanco.next())
                    { 
                        conta_id = resultadoBanco.getString("conta_id"); 
                        conta_aliqIcms = resultadoBanco.getString("conta_energia_faturamento_aliqicms"); 
                        conta_aliqPis = resultadoBanco.getString("conta_energia_faturamento_aliqpis"); 
                        conta_baseIcms = resultadoBanco.getString("conta_energia_faturamento_baseicms"); 
                        conta_basePis = resultadoBanco.getString("conta_energia_faturamento_basepis"); 
                        conta_cci = resultadoBanco.getString("conta_energia_faturamento_cci"); 
                        conta_competencia = resultadoBanco.getString("conta_energia_competencia"); 
                        conta_constMult = resultadoBanco.getString("conta_energia_consumo_constmult"); 
                        conta_consLeitAtual = resultadoBanco.getString("conta_energia_consumo_leitatual"); 
                        conta_consMes = resultadoBanco.getString("conta_energia_consumo_mes"); 
                        conta_bandCor = resultadoBanco.getString("conta_energia_bandeira_cor"); 
                        conta_consDescricao = resultadoBanco.getString("conta_energia_consumo_descricao"); 
                        conta_fatDescProduto = resultadoBanco.getString("conta_energia_faturamento_produto"); 
                        conta_fatDias = resultadoBanco.getString("conta_energia_faturamento_dias"); 
                        conta_fatEmissao = resultadoBanco.getString("conta_energia_faturamento_emissao"); 
                        conta_consKwh = resultadoBanco.getString("conta_energia_consumo_kwh"); 
                        conta_fatLeitAtual = resultadoBanco.getString("conta_energia_faturamento_leitatual"); 
                        conta_consMedidor = resultadoBanco.getString("conta_energia_consumo_medidor"); 
                        conta_bandInicio = resultadoBanco.getString("conta_energia_bandeira_periodoini"); 
                        conta_bandFim = resultadoBanco.getString("conta_energia_bandeira_periodo_fim"); 
                        conta_fatQtd = resultadoBanco.getString("conta_energia_faturamento_qtd"); 
                        conta_fatTariAplicada = resultadoBanco.getString("conta_energia_faturamento_tarifa"); 
                        conta_fatTariImposto = resultadoBanco.getString("conta_energia_faturamento_tarifaimposto"); 
                        conta_valor = resultadoBanco.getString("conta_energia_valor"); 
                        conta_valorFornecido = resultadoBanco.getString("conta_energia_faturamento_valorfornecido"); 
                        conta_valorIcms = resultadoBanco.getString("conta_energia_faturamento_valoricms"); 
                        conta_valorPis = resultadoBanco.getString("conta_energia_faturamento_valorpis"); 
                        conta_Vencimento = resultadoBanco.getString("conta_energia_vencimento"); 
                    }
                    txt_contaId.setText(conta_id);
                    txt_EnergiaAliquotaIcms.setText(conta_aliqIcms);
                    txt_EnergiaAliquotaPis.setText(conta_aliqPis);
                    txt_EnergiaBaseICMS.setText(conta_baseIcms);
                    txt_EnergiaBasePisCofins.setText(conta_basePis);
                    txt_EnergiaCci.setText(conta_cci);
                    txt_EnergiaCompetencia.setText(conta_competencia);
                    txt_EnergiaConstMult.setText(conta_constMult);
                    txt_EnergiaConsumoLeituraAtual.setText(conta_consLeitAtual);
                    txt_EnergiaConsumoMes.setText(conta_consMes);
                    txt_EnergiaCor.setText(conta_bandCor);
                    txt_EnergiaDescricao.setText(conta_consDescricao);
                    txt_EnergiaDescricaoProduto.setText(conta_fatDescProduto);
                    txt_EnergiaDiasFaturamento.setText(conta_fatDias);
                    txt_EnergiaEmissao.setText(conta_fatEmissao);
                    txt_EnergiaKwhMes.setText(conta_consKwh);
                    txt_EnergiaLeituraAtual.setText(conta_fatLeitAtual);
                    txt_EnergiaNMedidor.setText(conta_consMedidor);
                    txt_EnergiaPeriodo.setText(conta_bandInicio);
                    txt_EnergiaPeriodo2.setText(conta_bandFim);
                    txt_EnergiaQuantidade.setText(conta_fatQtd);
                    txt_EnergiaTarifaAplicada.setText(conta_fatTariAplicada);
                    txt_EnergiaTarifaImposto.setText(conta_fatTariImposto);
                    txt_EnergiaValor.setText(conta_valor);
                    txt_EnergiaValorFornecedor.setText(conta_valorFornecido);
                    txt_EnergiaValorIcms.setText(conta_valorIcms);
                    txt_EnergiaValorPis.setText(conta_valorPis);
                    txt_EnergiaVencimento.setText(conta_Vencimento);
            
            }catch(Exception ex) { Logger.getLogger(Form_CadClienteController.class.getName()).log(Level.SEVERE, null, ex);}
            
        }else{ limparContaEnergia();}
        
    }    

    @FXML
    private void salvarEnergia(ActionEvent event) throws Exception {

        String instalacao_id = Form_CadContaController.contaInstalacaoId;
        String instalacao_numero = Form_CadContaController.contaInstalacaoNum;
        String cliente_id = Form_CadContaController.clienteId;
        String conta_Id = txt_contaId.getText();
        String conta_aliqIcms = txt_EnergiaAliquotaIcms.getText();
        String conta_aliqPis = txt_EnergiaAliquotaPis.getText();
        String conta_baseIcms = txt_EnergiaBaseICMS.getText();
        String conta_basePis = txt_EnergiaBasePisCofins.getText();
        String conta_cci = txt_EnergiaCci.getText();
        String conta_competencia = txt_EnergiaCompetencia.getText();
        String conta_constMult = txt_EnergiaConstMult.getText();
        String conta_consLeitAtual = txt_EnergiaConsumoLeituraAtual.getText();
        String conta_consMes = txt_EnergiaConsumoMes.getText();
        String conta_bandCor = txt_EnergiaCor.getText();
        String conta_consDescricao = txt_EnergiaDescricao.getText();
        String conta_fatDescProduto = txt_EnergiaDescricaoProduto.getText();
        String conta_fatDias = txt_EnergiaDiasFaturamento.getText();
        String conta_fatEmissao = txt_EnergiaEmissao.getText();
        String conta_consKwh = txt_EnergiaKwhMes.getText();
        String conta_fatLeitAtual = txt_EnergiaLeituraAtual.getText();
        String conta_consMedidor = txt_EnergiaNMedidor.getText();
        String conta_bandInicio = txt_EnergiaPeriodo.getText();
        String conta_bandFim = txt_EnergiaPeriodo2.getText();
        String conta_fatQtd = txt_EnergiaQuantidade.getText();
        String conta_fatTariAplicada = txt_EnergiaTarifaAplicada.getText();
        String conta_fatTariImposto = txt_EnergiaTarifaImposto.getText();
        String conta_valor = txt_EnergiaValor.getText();
        String conta_valorFornecido = txt_EnergiaValorFornecedor.getText();
        String conta_valorIcms = txt_EnergiaValorIcms.getText();
        String conta_valorPis = txt_EnergiaValorPis.getText();
        String conta_Vencimento = txt_EnergiaVencimento.getText();
        
        if(Integer.parseInt(conta_Id) != 0)
        {
            
            Connection conn = null;
            ResultSet resultadoBanco = null;
            conn = DBConexao.abrirConexao();
            Statement stm = conn.createStatement();
                        
            String sql;
            sql = "UPDATE conta_energia SET "
                    + "conta_energia_valor = '"+ conta_valor +"', "
                    + "conta_energia_competencia = '"+ conta_competencia +"', "
                    + "conta_energia_consumo_mes = '"+ conta_consMes +"', "
                    + "conta_energia_vencimento = '"+ conta_Vencimento +"', "
                    + "conta_energia_bandeira_cor = '"+ conta_bandCor +"', "
                    + "conta_energia_bandeira_periodoini = '"+ conta_bandInicio +"', "
                    + "conta_energia_bandeira_periodo_fim = '"+ conta_bandFim +"', "
                    + "conta_energia_faturamento_emissao = '"+ conta_fatEmissao +"', "
                    + "conta_energia_faturamento_leitatual = '"+ conta_fatLeitAtual +"', "
                    + "conta_energia_faturamento_dias = '"+ conta_fatDias +"', "
                    + "conta_energia_faturamento_cci = '"+ conta_cci +"', "
                    + "conta_energia_faturamento_produto = '"+ conta_fatDescProduto +"', "
                    + "conta_energia_faturamento_qtd = '"+ conta_fatQtd +"', "
                    + "conta_energia_faturamento_tarifa = '"+ conta_fatTariAplicada +"', "
                    + "conta_energia_faturamento_valorfornecido = '"+ conta_valorFornecido +"', "
                    + "conta_energia_faturamento_tarifaimposto = '"+ conta_fatTariImposto +"', "
                    + "conta_energia_faturamento_baseicms = '"+ conta_baseIcms +"', "
                    + "conta_energia_faturamento_aliqicms = '"+ conta_aliqIcms +"', "
                    + "conta_energia_faturamento_valoricms = '"+ conta_valorIcms +"', "
                    + "conta_energia_faturamento_basepis = '"+ conta_basePis +"', "
                    + "conta_energia_faturamento_aliqpis = '"+ conta_aliqPis +"', "
                    + "conta_energia_faturamento_valorpis = '"+ conta_valorPis +"', "
                    + "conta_energia_consumo_descricao = '"+ conta_consDescricao +"', "
                    + "conta_energia_consumo_medidor = '"+ conta_consMedidor +"', "
                    + "conta_energia_consumo_leitatual = '"+ conta_consLeitAtual +"', "
                    + "conta_energia_consumo_constmult = '"+ conta_constMult +"', "
                    + "conta_energia_consumo_kwh = '"+ conta_consKwh +"' "                  
                    + "WHERE conta_id = "+ conta_Id +";";        
            stm.executeUpdate(sql);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensagem");
            alert.setHeaderText("Dados alterados com sucesso !");
            alert.showAndWait();

            
        }else{
        
        int conta_id = 0;
        
        
        Connection conn = null;
        conn = DBConexao.abrirConexao();
        
        Statement stm0 = conn.createStatement(); 
        String query0;
        query0 = "INSERT INTO conta(instalacao_id, cliente_id, conta_numero_instalacao, conta_tipo) VALUES "+
                "("+ instalacao_id +", "
                   + cliente_id +", '"
                   + instalacao_numero +"', '"
                + "Energia');";
        stm0.executeUpdate(query0);

        Statement stm1 = conn.createStatement();
        String query1;
        query1 = "SELECT LAST_INSERT_ID();";
        ResultSet resultado = stm1.executeQuery(query1);
        while(resultado.next()){ conta_id = resultado.getInt("LAST_INSERT_ID()"); }
  
        Statement stm = conn.createStatement();      
        String query;
        query = "INSERT INTO conta_energia(conta_id, conta_energia_valor, conta_energia_competencia, conta_energia_consumo_mes, " +
                    "conta_energia_vencimento, conta_energia_bandeira_cor, conta_energia_bandeira_periodoini, " +
                    "conta_energia_bandeira_periodo_fim, conta_energia_faturamento_emissao, conta_energia_faturamento_leitatual," +
                    "conta_energia_faturamento_dias, conta_energia_faturamento_cci, conta_energia_faturamento_produto, " +
                    "conta_energia_faturamento_qtd, conta_energia_faturamento_tarifa, conta_energia_faturamento_valorfornecido, " +
                    "conta_energia_faturamento_tarifaimposto, conta_energia_faturamento_baseicms, conta_energia_faturamento_aliqicms, " +
                    "conta_energia_faturamento_valoricms, conta_energia_faturamento_basepis, conta_energia_faturamento_aliqpis, " +
                    "conta_energia_faturamento_valorpis, conta_energia_consumo_descricao, conta_energia_consumo_medidor, " +
                    "conta_energia_consumo_leitatual, conta_energia_consumo_constmult, conta_energia_consumo_kwh) VALUES"
                  +  "("+ conta_id +",'"
                        + conta_valor +"','"
                        + conta_competencia +"','"
                        + conta_consMes +"','"
                        + conta_Vencimento +"','"
                        + conta_bandCor +"','"
                        + conta_bandInicio +"','"
                        + conta_bandFim +"','"
                        + conta_fatEmissao +"','"
                        + conta_fatLeitAtual +"','"
                        + conta_fatDias +"','"
                        + conta_cci +"','"
                        + conta_fatDescProduto +"','"
                        + conta_fatQtd +"','"
                        + conta_fatTariAplicada +"','"
                        + conta_valorFornecido +"','"
                        + conta_fatTariImposto +"','"
                        + conta_baseIcms +"','"
                        + conta_aliqIcms +"','"
                        + conta_valorIcms +"','"
                        + conta_basePis +"','"
                        + conta_aliqPis +"','"
                        + conta_valorPis +"','"
                        + conta_consDescricao +"','"
                        + conta_consMedidor +"','"
                        + conta_consLeitAtual +"','"
                        + conta_constMult +"','"
                        + conta_consKwh +"');";
        
            stm.executeUpdate(query);
            
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensagem");
            alert.setHeaderText("Dados salvos com sucesso !");
            alert.showAndWait();
            limparContaEnergia();
              
        }
    }

    @FXML
    public void limparContaEnergia()
    {
            txt_contaId.setText("0");
            txt_EnergiaAliquotaIcms.setText("");
            txt_EnergiaAliquotaPis.setText("");
            txt_EnergiaBaseICMS.setText("");
            txt_EnergiaBasePisCofins.setText("");
            txt_EnergiaCci.setText("");
            txt_EnergiaCompetencia.setText("");
            txt_EnergiaConstMult.setText("");
            txt_EnergiaConsumoLeituraAtual.setText("");
            txt_EnergiaConsumoMes.setText("");
            txt_EnergiaCor.setText("");
            txt_EnergiaDescricao.setText("");
            txt_EnergiaDescricaoProduto.setText("");
            txt_EnergiaDiasFaturamento.setText("");
            txt_EnergiaEmissao.setText("");
            txt_EnergiaKwhMes.setText("");
            txt_EnergiaLeituraAtual.setText("");
            txt_EnergiaNMedidor.setText("");
            txt_EnergiaPeriodo.setText("");
            txt_EnergiaPeriodo2.setText("");
            txt_EnergiaQuantidade.setText("");
            txt_EnergiaTarifaAplicada.setText("");
            txt_EnergiaTarifaImposto.setText("");
            txt_EnergiaValor.setText("");
            txt_EnergiaValorFornecedor.setText("");
            txt_EnergiaValorIcms.setText("");
            txt_EnergiaValorPis.setText("");
            txt_EnergiaVencimento.setText("");
    }
    
}
