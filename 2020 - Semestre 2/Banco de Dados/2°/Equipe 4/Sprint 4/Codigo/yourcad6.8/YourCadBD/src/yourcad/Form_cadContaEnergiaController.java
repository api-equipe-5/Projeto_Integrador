/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourcad;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
            if("Digitador".equals(Form_LoginController.usuario_Nivel_Acesso))
            {
                btn_limparContaEnergia.setVisible(false);
                btn_salvarContaEnergia.setVisible(false);
                txt_contaId.setEditable(false);
                txt_EnergiaAliquotaIcms.setEditable(false);
                txt_EnergiaAliquotaPis.setEditable(false);
                txt_EnergiaBaseICMS.setEditable(false);
                txt_EnergiaBasePisCofins.setEditable(false);
                txt_EnergiaCci.setEditable(false);
                txt_EnergiaCompetencia.setEditable(false);
                txt_EnergiaConstMult.setEditable(false);
                txt_EnergiaConsumoLeituraAtual.setEditable(false);
                txt_EnergiaConsumoMes.setEditable(false);
                txt_EnergiaCor.setEditable(false);
                txt_EnergiaDescricao.setEditable(false);
                txt_EnergiaDescricaoProduto.setEditable(false);
                txt_EnergiaDiasFaturamento.setEditable(false);
                txt_EnergiaEmissao.setEditable(false);
                txt_EnergiaKwhMes.setEditable(false);
                txt_EnergiaLeituraAtual.setEditable(false);
                txt_EnergiaNMedidor.setEditable(false);
                txt_EnergiaPeriodo.setEditable(false);
                txt_EnergiaPeriodo2.setEditable(false);
                txt_EnergiaQuantidade.setEditable(false);
                txt_EnergiaTarifaAplicada.setEditable(false);
                txt_EnergiaTarifaImposto.setEditable(false);
                txt_EnergiaValor.setEditable(false);
                txt_EnergiaValorFornecedor.setEditable(false);
                txt_EnergiaValorIcms.setEditable(false);
                txt_EnergiaValorPis.setEditable(false);
                txt_EnergiaVencimento.setEditable(false);
            }
           
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
        boolean validar =  validacao();
            
        if (validar == true){
            if (validacaoCompetencia(txt_EnergiaCompetencia.getText()) == false) { txt_EnergiaCompetencia.requestFocus(); }
            else if (validacaoData(txt_EnergiaVencimento.getText()) == false) { txt_EnergiaVencimento.requestFocus(); }
            else if (validacaoData(txt_EnergiaPeriodo.getText()) == false) { txt_EnergiaPeriodo.requestFocus(); } 
            else if (validacaoData(txt_EnergiaPeriodo2.getText()) == false) { txt_EnergiaPeriodo2.requestFocus(); }
            else if (validacaoData(txt_EnergiaEmissao.getText()) == false) { txt_EnergiaEmissao.requestFocus(); }
            else {
        if(Integer.parseInt(conta_Id) != 0)
        {
            
            Connection conn = null;
            ResultSet resultadoBanco = null;
            conn = DBConexao.abrirConexao();
            
            String sql;
            sql = "UPDATE conta_energia SET "
                    + "conta_energia_valor = ?, "
                    + "conta_energia_competencia = ?, "
                    + "conta_energia_consumo_mes = ?, "
                    + "conta_energia_vencimento = ?, "
                    + "conta_energia_bandeira_cor = ?, "
                    + "conta_energia_bandeira_periodoini = ?, "
                    + "conta_energia_bandeira_periodo_fim = ?, "
                    + "conta_energia_faturamento_emissao = ?, "
                    + "conta_energia_faturamento_leitatual = ?, "
                    + "conta_energia_faturamento_dias = ?, "
                    + "conta_energia_faturamento_cci = ?, "
                    + "conta_energia_faturamento_produto = ?, "
                    + "conta_energia_faturamento_qtd = ?, "
                    + "conta_energia_faturamento_tarifa = ?, "
                    + "conta_energia_faturamento_valorfornecido = ?, "
                    + "conta_energia_faturamento_tarifaimposto = ?, "
                    + "conta_energia_faturamento_baseicms = ?, "
                    + "conta_energia_faturamento_aliqicms = ?, "
                    + "conta_energia_faturamento_valoricms = ?, "
                    + "conta_energia_faturamento_basepis = ?, "
                    + "conta_energia_faturamento_aliqpis = ?, "
                    + "conta_energia_faturamento_valorpis = ?, "
                    + "conta_energia_consumo_descricao = ?, "
                    + "conta_energia_consumo_medidor = ?, "
                    + "conta_energia_consumo_leitatual = ?, "
                    + "conta_energia_consumo_constmult = ?, "
                    + "conta_energia_consumo_kwh = ? "                  
                    + "WHERE conta_id = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, conta_valor);
            pstm.setString(2, conta_competencia);
            pstm.setString(3, conta_consMes);
            pstm.setString(4, conta_Vencimento);
            pstm.setString(5, conta_bandCor);
            pstm.setString(6, conta_bandInicio);
            pstm.setString(7, conta_bandFim);
            pstm.setString(8, conta_fatEmissao);
            pstm.setString(9, conta_fatLeitAtual);
            pstm.setString(10, conta_fatDias);
            pstm.setString(11, conta_cci);
            pstm.setString(12, conta_fatDescProduto);
            pstm.setString(13, conta_fatQtd);
            pstm.setString(14, conta_fatTariAplicada);
            pstm.setString(15, conta_valorFornecido);
            pstm.setString(16, conta_fatTariImposto);
            pstm.setString(17, conta_baseIcms);
            pstm.setString(18, conta_aliqIcms);
            pstm.setString(19, conta_valorIcms);
            pstm.setString(20, conta_basePis);
            pstm.setString(21, conta_aliqPis);
            pstm.setString(22, conta_valorPis);
            pstm.setString(23, conta_consDescricao);
            pstm.setString(24, conta_consMedidor);
            pstm.setString(25, conta_consLeitAtual);
            pstm.setString(26, conta_constMult);
            pstm.setString(27, conta_consKwh);
            pstm.setString(28, conta_Id);
            pstm.executeUpdate();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensagem");
            alert.setHeaderText("Dados alterados com sucesso !");
            alert.showAndWait();

            
        }else{
        
        int conta_id = 0;
        
        
        Connection conn = null;
        conn = DBConexao.abrirConexao();
        
        String query0;
        query0 = "INSERT INTO conta(instalacao_id, cliente_id, conta_numero_instalacao, conta_tipo) VALUES "+
                "(?, ?, ?, Energia')";
        
        PreparedStatement pstm0 = conn.prepareStatement(query0);
        pstm0.setString(1, instalacao_id);
        pstm0.setString(2, cliente_id);
        pstm0.setString(3, instalacao_numero);
       
        pstm0.executeUpdate();

        Statement stm1 = conn.createStatement();
        String query1;
        query1 = "SELECT LAST_INSERT_ID();";
        ResultSet resultado = stm1.executeQuery(query1);
        while(resultado.next()){ conta_id = resultado.getInt("LAST_INSERT_ID()"); }
        
         // Dados para relatório de digitador **************
        String usuario_id = Form_LoginController.usuario_Id;
        Date data1 = new Date();
        SimpleDateFormat format_data = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat format_hora = new SimpleDateFormat("HH:mm:ss");
        String data = format_data.format(data1); // 14/03/2016
        String hora = format_hora.format(data1);

        String query3;
        query3 = "INSERT INTO relatorio_digitador( usuario_id, conta_id, relat_data, relat_hora) VALUES"
                  +  "(?, ?, ?, ?)";
        
        PreparedStatement pstm3 = conn.prepareStatement(query3);      
        pstm3.setString(1, usuario_id);
        pstm3.setInt(2, conta_id);
        pstm3.setString(3, data);
        pstm3.setString(4, hora);
        
        pstm3.executeUpdate();
        //*****************************************
  
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
                      +  "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, conta_valor);
            pstm.setString(2, conta_competencia);
            pstm.setString(3, conta_consMes);
            pstm.setString(4, conta_Vencimento);
            pstm.setString(5, conta_bandCor);
            pstm.setString(6, conta_bandInicio);
            pstm.setString(7, conta_bandFim);
            pstm.setString(8, conta_fatEmissao);
            pstm.setString(9, conta_fatLeitAtual);
            pstm.setString(10, conta_fatDias);
            pstm.setString(11, conta_cci);
            pstm.setString(12, conta_fatDescProduto);
            pstm.setString(13, conta_fatQtd);
            pstm.setString(14, conta_fatTariAplicada);
            pstm.setString(15, conta_valorFornecido);
            pstm.setString(16, conta_fatTariImposto);
            pstm.setString(17, conta_baseIcms);
            pstm.setString(18, conta_aliqIcms);
            pstm.setString(19, conta_valorIcms);
            pstm.setString(20, conta_basePis);
            pstm.setString(21, conta_aliqPis);
            pstm.setString(22, conta_valorPis);
            pstm.setString(23, conta_consDescricao);
            pstm.setString(24, conta_consMedidor);
            pstm.setString(25, conta_consLeitAtual);
            pstm.setString(26, conta_constMult);
            pstm.setString(27, conta_consKwh);
        
            pstm.executeUpdate();  
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensagem");
            alert.setHeaderText("Dados salvos com sucesso !");
            alert.showAndWait();
            limparContaEnergia();
              
        }
        }
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
    
    private boolean validacao (){

        
        if ("".equals(txt_EnergiaValor.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Valor não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaValor.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaCompetencia.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Competencia não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaCompetencia.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaConsumoMes.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Consumo Mês não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaConsumoMes.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaVencimento.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Vencimento não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaVencimento.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaCor.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Cor não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaCor.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaPeriodo.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Periodo (início) não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaPeriodo.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaPeriodo2.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Periodo (final) não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaPeriodo2.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaEmissao.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Emissão não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaEmissao.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaLeituraAtual.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Leitura Atual não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaLeituraAtual.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaDiasFaturamento.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Nº Dias Faturamento não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaDiasFaturamento.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaDescricao.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Descrição não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaDescricao.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaNMedidor.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Nº Medidor não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaNMedidor.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaConsumoLeituraAtual.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Leitura Atual não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaConsumoLeituraAtual.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaConstMult.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Const. Mult. não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaConstMult.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaKwhMes.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Qtd kWh/Mês não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaKwhMes.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaCci.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo CCI não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaCci.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaDescricaoProduto.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Descrição Produto não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaDescricaoProduto.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaQuantidade.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Quantidade não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaQuantidade.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaTarifaAplicada.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Tarifa Aplicada não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaTarifaAplicada.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaValorFornecedor.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Valor Fornec. não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaValorFornecedor.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaTarifaImposto.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Tarifa c/ Imposto não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaTarifaImposto.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaBaseICMS.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo B. Calc. ICMS não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaBaseICMS.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaAliquotaIcms.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Aliq. ICMS não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaAliquotaIcms.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaValorIcms.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Valor ICMS não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaValorIcms.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaBasePisCofins.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo B. Calc. PIS/COFINS não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaBasePisCofins.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaAliquotaPis.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Aliq. PIS não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaAliquotaPis.requestFocus();
            return false;
        }
        else if ("".equals(txt_EnergiaValorPis.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Valor PIS não pode ser vazio");
            alert.showAndWait();
            txt_EnergiaValorPis.requestFocus();
            return false;
        } else {return true;} 
    }
    
    @FXML
    private void mascaraCompetencia(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        if (txt_EnergiaCompetencia.getText().length() == 6){
        tff.setMask("##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txt_EnergiaCompetencia);
        tff.formatter();        
        }
    }

    @FXML
    private void mascaraData(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setCaracteresValidos("0123456789");
        
        if (txt_EnergiaVencimento.getText().length() == 8){
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txt_EnergiaVencimento);
        tff.formatter();        
        }
        
        if (txt_EnergiaPeriodo.getText().length() == 8){
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txt_EnergiaPeriodo);
        tff.formatter();        
        }
        
        if (txt_EnergiaPeriodo2.getText().length() == 8){
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txt_EnergiaPeriodo2);
        tff.formatter();        
        }
        
        if (txt_EnergiaEmissao.getText().length() == 8){
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txt_EnergiaEmissao);
        tff.formatter();        
        }
    }
    
    
    
    
    private boolean validacaoData(String data){ 
    String separado[] = data.split("/");
    if (Integer.parseInt(separado[0]) > 31){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("O dia informado é inválido");
        alert.showAndWait();
        return false;
    }
    
    else if (Integer.parseInt(separado[1]) > 12){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("O mês informado é inválido");
        alert.showAndWait();
        return false;
        }  else { return true; } 
    }

    private boolean validacaoCompetencia(String data){
    String separado[] = data.split("/");
    if (Integer.parseInt(separado[0]) > 12){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("O mês informado é inválido");
        alert.showAndWait();
        return false;
    } else { return true;}     
     
    }
    
}
