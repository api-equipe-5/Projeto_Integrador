package dao;

import conexao.ConexaoBd;
import classes.Energia;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnergiaDAO {
    // Metodo para inserir dados na tabela Cliente
    public void create(Energia n) {
        
        Connection con = ConexaoBd.getConnection();
    
        PreparedStatement stmt = null;
        //Inserindo dados na tabela atraves do metodo INSERT
        try {
            stmt = con.prepareStatement("INSERT INTO ene_energia (int_numero_instalacao,cta_mes_referencia," +
            "ene_consumo_conta_mes,ene_codigo_fiscal,ene_grupo_subgrupo,ene_tipo_fornecimento,ene_classe_subclasse,ene_roteiro_leitura," +
            "ene_modalidade_tarifaria,ene_tensao_nominal,ene_numero_medidor,ene_const_multi,ene_leitura_anterior_cod,ene_leitura_atual_cod," +
            "ene_data_leitura_anterior,ene_data_leitura_atual,ene_tipo_bandeira,ene_valor_total) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setObject(1, n.getInt_numero_instalacao());
            stmt.setObject(2, n.getCta_mes_referencia());
            stmt.setObject(3, n.getEne_consumo_conta_mes());
            stmt.setObject(4, n.getEne_codigo_fiscal());
            stmt.setString(5, n.getEne_grupo_subgrupo());
            stmt.setString(6, n.getEne_tipo_fornecimento());
            stmt.setString(7, n.getEne_classe_subclasse());
            stmt.setString(8, n.getEne_roteiro_leitura());
            stmt.setString(9, n.getEne_modalidade_tarifaria());
            stmt.setString(10, n.getEne_tensao_nominal());
            stmt.setObject(11, n.getEne_numero_medidor());
            stmt.setObject(12, n.getEne_const_multi());
            stmt.setObject(13, n.getEne_leitura_anterior_cod());
            stmt.setObject(14, n.getEne_leitura_atual_cod());
            stmt.setString(15, n.getEne_data_leitura_anterior());
            stmt.setString(16, n.getEne_data_leitura_atual());
            stmt.setString(17, n.getEne_tipo_bandeira());
            stmt.setObject(18, n.getEne_valor_total());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }
    }

    public static List<Energia> read() {

        Connection con = ConexaoBd.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Energia> contas_energia = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT int_numero_instalacao,cta_mes_referencia,ene_consumo_conta_mes,ene_tensao_nominal,ene_numero_medidor,ene_tipo_bandeira,ene_valor_total FROM ene_energia");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Energia energia = new Energia();

                energia.setInt_numero_instalacao(BigInteger.valueOf(rs.getLong("int_numero_instalacao")));
                energia.setCta_mes_referencia(rs.getString("cta_mes_referencia"));
                energia.setEne_consumo_conta_mes(BigInteger.valueOf(rs.getLong("ene_consumo_conta_mes")));
                energia.setEne_tensao_nominal(rs.getString("ene_tensao_nominal")); 
                energia.setEne_numero_medidor(BigInteger.valueOf(rs.getLong("ene_numero_medidor")));
                energia.setEne_tipo_bandeira(rs.getString("ene_tipo_bandeira"));   
                energia.setEne_valor_total(BigDecimal.valueOf(rs.getDouble("ene_valor_total")));

                contas_energia.add(energia);
            }

        } catch (SQLException ex) {
            Logger.getLogger(InstalacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBd.closeConnection(con, stmt, rs);
        }
    
        return contas_energia;

    }

     public static void buscar(BigInteger n, String m, TextField txtContaKwH,TextField txtValorTotalAPagar,TextField txtDataLeituraAnterior,TextField txtDataLeituraAtual,ComboBox comboBandeirasTarifarias,TextField txtConstMulti,TextField txtNRdoMedidor,TextField txtLeituraAnterior,TextField txtLeituraAtual,TextField txtCodigoFiscal,TextField txtGrupoSubgrupo,TextField txtClasseSubclasse,TextField txtRoteiroLeitura,TextField txtMTarifaria,TextField txtTensaoNominal,TextField txtFornecimento) {
        
        Connection con = ConexaoBd.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("SELECT * FROM ene_energia where int_numero_instalacao = ? and cta_mes_referencia = ?");
            stmt.setObject(1, n);
            stmt.setObject(2, m);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Energia ene = new Energia();
                ene.setEne_consumo_conta_mes(BigInteger.valueOf(Long.parseLong(rs.getString("ene_consumo_conta_mes"))));
                ene.setEne_valor_total(BigDecimal.valueOf(Double.parseDouble(rs.getString("ene_valor_total"))));
                ene.setEne_data_leitura_anterior(rs.getString("ene_data_leitura_anterior"));
                ene.setEne_data_leitura_atual(rs.getString("ene_data_leitura_atual"));
                ene.setEne_tipo_bandeira(rs.getString("ene_tipo_bandeira"));
                ene.setEne_const_multi(BigDecimal.valueOf(Double.parseDouble(rs.getString("ene_const_multi"))));
                ene.setEne_numero_medidor(BigInteger.valueOf(Long.parseLong(rs.getString("ene_numero_medidor"))));
                ene.setEne_leitura_anterior_cod(BigInteger.valueOf(Long.parseLong(rs.getString("ene_leitura_anterior_cod"))));
                ene.setEne_leitura_atual_cod(BigInteger.valueOf(Long.parseLong(rs.getString("ene_leitura_atual_cod"))));
                ene.setEne_codigo_fiscal(BigInteger.valueOf(Long.parseLong(rs.getString("ene_codigo_fiscal"))));
                ene.setEne_grupo_subgrupo(rs.getString("ene_grupo_subgrupo"));
                ene.setEne_classe_subclasse(rs.getString("ene_classe_subclasse"));
                ene.setEne_roteiro_leitura(rs.getString("ene_roteiro_leitura"));
                ene.setEne_modalidade_tarifaria(rs.getString("ene_modalidade_tarifaria"));
                ene.setEne_tensao_nominal(rs.getString("ene_tensao_nominal"));
                ene.setEne_tipo_fornecimento(rs.getString("ene_tipo_fornecimento"));

                txtContaKwH.setText(String.valueOf(ene.getEne_consumo_conta_mes()));
                txtValorTotalAPagar.setText(String.valueOf(ene.getEne_valor_total()));
                txtDataLeituraAnterior.setText(ene.getEne_data_leitura_anterior());
                txtDataLeituraAtual.setText(ene.getEne_data_leitura_atual());
                comboBandeirasTarifarias.setValue(ene.getEne_tipo_bandeira());
                txtConstMulti.setText(String.valueOf(ene.getEne_const_multi()));
                txtNRdoMedidor.setText(String.valueOf(ene.getEne_numero_medidor()));
                txtLeituraAnterior.setText(String.valueOf(ene.getEne_leitura_anterior_cod()));
                txtLeituraAtual.setText(String.valueOf(ene.getEne_leitura_atual_cod()));
                txtCodigoFiscal.setText(String.valueOf(ene.getEne_codigo_fiscal()));
                txtGrupoSubgrupo.setText(ene.getEne_grupo_subgrupo());
                txtClasseSubclasse.setText(ene.getEne_classe_subclasse());
                txtRoteiroLeitura.setText(ene.getEne_roteiro_leitura());
                txtMTarifaria.setText(ene.getEne_modalidade_tarifaria());
                txtTensaoNominal.setText(ene.getEne_tensao_nominal());
                txtFornecimento.setText(ene.getEne_tipo_fornecimento());
            }
        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }

    }

    public static boolean validacaoConta(BigInteger n, String d) {
        
        Connection con = ConexaoBd.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM ene_energia where int_numero_instalacao = ? and cta_mes_referencia = ?");
            stmt.setObject(1, n);
            stmt.setString(2, d);

            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }
        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }

        return check;
    }
    
    public void update(Energia n) {
        
        Connection con = ConexaoBd.getConnection();
    
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE ene_energia SET ene_consumo_conta_mes = ? ,ene_codigo_fiscal  = ?,ene_grupo_subgrupo  = ?,ene_tipo_fornecimento  = ?,ene_classe_subclasse  = ?,ene_roteiro_leitura  = ?," +
            "ene_modalidade_tarifaria  = ?,ene_tensao_nominal  = ?,ene_numero_medidor  = ?,ene_const_multi  = ?,ene_leitura_anterior_cod = ?,ene_leitura_atual_cod = ?," +
            "ene_data_leitura_anterior = ?,ene_data_leitura_atual = ?,ene_tipo_bandeira = ? ,ene_valor_total  = ? WHERE int_numero_instalacao = ? and cta_mes_referencia = ?");
           
            stmt.setObject(1, n.getEne_consumo_conta_mes());
            stmt.setObject(2, n.getEne_codigo_fiscal());
            stmt.setString(3, n.getEne_grupo_subgrupo());
            stmt.setString(4, n.getEne_tipo_fornecimento());
            stmt.setString(5, n.getEne_classe_subclasse());
            stmt.setString(6, n.getEne_roteiro_leitura());
            stmt.setString(7, n.getEne_modalidade_tarifaria());
            stmt.setString(8, n.getEne_tensao_nominal());
            stmt.setObject(9, n.getEne_numero_medidor());
            stmt.setObject(10, n.getEne_const_multi());
            stmt.setObject(11, n.getEne_leitura_anterior_cod());
            stmt.setObject(12, n.getEne_leitura_atual_cod());
            stmt.setString(13, n.getEne_data_leitura_anterior());
            stmt.setString(14, n.getEne_data_leitura_atual());
            stmt.setString(15, n.getEne_tipo_bandeira());
            stmt.setObject(16, n.getEne_valor_total());
            stmt.setObject(17, n.getInt_numero_instalacao());
            stmt.setString(18, n.getCta_mes_referencia());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }
    }
    public void delete(Energia n) {
        
        Connection con = ConexaoBd.getConnection();
    
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM ene_energia WHERE int_numero_instalacao = ? and cta_mes_referencia = ?");
        
            stmt.setObject(1, n.getInt_numero_instalacao());
            stmt.setString(2, n.getCta_mes_referencia());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }
    }

}