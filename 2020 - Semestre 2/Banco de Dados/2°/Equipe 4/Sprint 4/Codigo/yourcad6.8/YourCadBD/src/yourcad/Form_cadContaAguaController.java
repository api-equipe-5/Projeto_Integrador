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
            if("Digitador".equals(Form_LoginController.usuario_Nivel_Acesso))
            {
                btn_LimparAgua.setVisible(false);
                btn_SalvarAgua.setVisible(false);
                txt_ContaId.setEditable(false);
                txt_AguaCompetencia.setEditable(false);
                txt_AguaVencimento.setEditable(false);
                txt_AguaPrevProxLeitura.setEditable(false);
                txt_AguaDataLeituraAtual.setEditable(false);
                txt_AguaValorAtual.setEditable(false);
                txt_AguaValorAgua.setEditable(false);
                txt_AguaValorEsgoto.setEditable(false);
                txt_AguaTrcf.setEditable(false);
                txt_AguaMulta.setEditable(false);
                txt_AguaBaseCofins.setEditable(false);
                txt_AguaAliquotaCofins.setEditable(false);
            }
           
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
        
        boolean validar =  validacao();
            
        if (validar == true){
            if (validacaoCompetencia(txt_AguaCompetencia.getText()) == false) { txt_AguaCompetencia.requestFocus(); }
            else if (validacaoData(txt_AguaVencimento.getText()) == false) { txt_AguaVencimento.requestFocus(); }
            else if (validacaoData(txt_AguaPrevProxLeitura.getText()) == false) { txt_AguaPrevProxLeitura.requestFocus(); } 
            else if (validacaoData(txt_AguaDataLeituraAtual.getText()) == false) { txt_AguaDataLeituraAtual.requestFocus(); }
            else {
                    if(Integer.parseInt(conta_Id) != 0)
                    {

                        Connection conn = null;
                        ResultSet resultadoBanco = null;
                        conn = DBConexao.abrirConexao();
                        
                        String sql;
                        sql = "UPDATE conta_agua SET "
                                + "conta_agua_mes = ?, "
                                + "conta_agua_vencimento = ?, "
                                + "conta_agua_data_atual_leitura = ?, "
                                + "conta_agua_data_previsao_proxima_leitura = ?, "
                                + "conta_agua_valor_atual_leitura = ?, "
                                + "conta_agua_valor_agua = ?, "
                                + "conta_agua_valor_esgoto = ?, "
                                + "conta_agua_multa = ?, "
                                + "conta_agua_trcf = ?, "
                                + "conta_agua_base_pis_cofins = ?, " 
                                + "conta_agua_aliquota_pis_cofins = ? " 
                                + "WHERE conta_id = ?";       
                        
                        PreparedStatement pstm = conn.prepareStatement(sql);
                        pstm.setString(1, conta_competencia);
                        pstm.setString(2, conta_vencimento);
                        pstm.setString(3, conta_dataLeituraAtual);
                        pstm.setString(4, conta_valorAtual);
                        pstm.setString(5, conta_valorAgua);
                        pstm.setString(6, conta_valorEsgoto);
                        pstm.setString(7, conta_multa);
                        pstm.setString(8, conta_trcf);
                        pstm.setString(9, conta_basePis);
                        pstm.setString(10, conta_aliquota);
                        pstm.setString(11, conta_Id);
                        
                        pstm.executeUpdate();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Mensagem");
                        alert.setHeaderText("Dados alterados com sucesso !");
                        alert.showAndWait();

                    } else{

                        int conta_id = 0;

                        Connection conn = null;
                        conn = DBConexao.abrirConexao();
                        
                        String query0;
                        query0 = "INSERT INTO conta(instalacao_id, cliente_id, conta_numero_instalacao, conta_tipo) VALUES "+
                                "(?, ?, ?, 'Agua e Esgoto');";
                        
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
                        query = "INSERT INTO conta_agua(conta_id, conta_agua_mes, conta_agua_vencimento, conta_agua_data_atual_leitura, conta_agua_data_previsao_proxima_leitura, " +
                                "conta_agua_valor_atual_leitura, conta_agua_valor_agua, conta_agua_valor_esgoto, conta_agua_multa, conta_agua_trcf, conta_agua_base_pis_cofins, "
                                + "conta_agua_aliquota_pis_cofins ) VALUES"
                                  +  "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        
                        PreparedStatement pstm = conn.prepareStatement(query); 
                        pstm.setString(1, conta_competencia);
                        pstm.setString(2, conta_vencimento);
                        pstm.setString(3, conta_dataLeituraAtual);
                        pstm.setString(4, conta_valorAtual);
                        pstm.setString(5, conta_valorAgua);
                        pstm.setString(6, conta_valorEsgoto);
                        pstm.setString(7, conta_multa);
                        pstm.setString(8, conta_trcf);
                        pstm.setString(9, conta_basePis);
                        pstm.setString(10, conta_aliquota);
                        
                        pstm.executeUpdate();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Mensagem");
                        alert.setHeaderText("Dados salvos com sucesso !");
                        alert.showAndWait();
                        LimparAgua();

                    }
        }
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
    
    private boolean validacao (){

        
        if ("".equals(txt_AguaCompetencia.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Competencia não pode ser vazio");
            alert.showAndWait();
            txt_AguaCompetencia.requestFocus();
            return false;
        }
        else if ("".equals(txt_AguaVencimento.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Vencimento não pode ser vazio");
            alert.showAndWait();
            txt_AguaVencimento.requestFocus();
            return false;
        }
        else if ("".equals(txt_AguaPrevProxLeitura.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Data Previsão de Prox Leitura não pode ser vazio");
            alert.showAndWait();
            txt_AguaPrevProxLeitura.requestFocus();
            return false;
        }
        else if ("".equals(txt_AguaDataLeituraAtual.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Data Leitura Atual não pode ser vazio");
            alert.showAndWait();
            txt_AguaDataLeituraAtual.requestFocus();
            return false;
        }
        else if ("".equals(txt_AguaValorAtual.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Valor Atual não pode ser vazio");
            alert.showAndWait();
            txt_AguaValorAtual.requestFocus();
            return false;
        }
        else if ("".equals(txt_AguaValorAgua.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Valor Agua não pode ser vazio");
            alert.showAndWait();
            txt_AguaValorAgua.requestFocus();
            return false;
        }
        else if ("".equals(txt_AguaValorEsgoto.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Valor Esgoto não pode ser vazio");
            alert.showAndWait();
            txt_AguaValorEsgoto.requestFocus();
            return false;
        }
        else if ("".equals(txt_AguaTrcf.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo TRCF não pode ser vazio");
            alert.showAndWait();
            txt_AguaTrcf.requestFocus();
            return false;
        }
        else if ("".equals(txt_AguaMulta.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Multa não pode ser vazio");
            alert.showAndWait();
            txt_AguaMulta.requestFocus();
            return false;
        }
        else if ("".equals(txt_AguaBaseCofins.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Base PIS COFINS não pode ser vazio");
            alert.showAndWait();
            txt_AguaBaseCofins.requestFocus();
            return false;
        }
        else if ("".equals(txt_AguaAliquotaCofins.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo Aliquota PIS COFINS não pode ser vazio");
            alert.showAndWait();
            txt_AguaAliquotaCofins.requestFocus();
            return false;
        }else {return true;} 
    }

    
    
    @FXML
    private void mascaraCompetencia(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        if (txt_AguaCompetencia.getText().length() == 6){
        tff.setMask("##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txt_AguaCompetencia);
        tff.formatter();        
        }
    }

    @FXML
    private void mascaraData(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setCaracteresValidos("0123456789");
        
        if (txt_AguaVencimento.getText().length() == 8){
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txt_AguaVencimento);
        tff.formatter();        
        }
        
        if (txt_AguaPrevProxLeitura.getText().length() == 8){
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txt_AguaPrevProxLeitura);
        tff.formatter();        
        }
        
        if (txt_AguaDataLeituraAtual.getText().length() == 8){
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txt_AguaDataLeituraAtual);
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
