package dao;

import conexao.ConexaoBd;
import classes.Agua;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.TextField;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AguaDAO {

    private static Agua a = new Agua();

    //Metodo para inserir dados na tabela Cliente
    public void create(Agua a) {
        
        Connection con = ConexaoBd.getConnection();
    
        PreparedStatement stmt = null;
        //Inserindo dados na tabela atraves do metodo INSERT
        try {
            stmt = con.prepareStatement("INSERT INTO agu_agua (int_numero_instalacao,cta_mes_referencia," +
            "agu_gr,agu_codigo_cliente,agu_numero_conta,agu_tipo_ligacao,agu_hidrometro,agu_data_leitura_anterior," +
            "agu_data_leitura_atual,agu_leitura_anterior,agu_leitura_atual,agu_consumo,agu_valor_agua,agu_valor_esgoto," +
            "agu_taxa_regulamentacao,agu_multa,agu_tarifa_ate10_agua,agu_tarifa_ate20_agua,agu_tarifa_ate30_agua," +
            "agu_tarifa_ate50_agua,agu_tarifa_acima50_agua,agu_tarifa_ate10_esgoto,agu_tarifa_ate20_esgoto," +
            "agu_tarifa_ate30_esgoto,agu_tarifa_ate50_esgoto,agu_tarifa_acima50_esgoto,agu_valor_agua1,agu_valor_agua2," +
            "agu_valor_esgoto1,agu_valor_esgoto2) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setObject(1, a.getInt_numero_instalacao());
            stmt.setString(2, a.getCta_mes_referencia());
            stmt.setObject(3, a.getAgu_gr());
            stmt.setObject(4, a.getAgu_codigo_cliente());
            stmt.setObject(5, a.getAgu_numero_conta());
            stmt.setObject(6, a.getAgu_tipo_ligacao());
            stmt.setObject(7, a.getAgu_hidrometro());
            stmt.setString(8, a.getAgu_data_leitura_anterior());
            stmt.setString(9, a.getAgu_data_leitura_atual());
            stmt.setObject(10, a.getAgu_leitura_anterior());
            stmt.setObject(11, a.getAgu_leitura_atual());
            stmt.setObject(12, a.getAgu_consumo());
            stmt.setObject(13, a.getAgu_valor_agua());
            stmt.setObject(14, a.getAgu_valor_esgoto());
            stmt.setObject(15, a.getAgu_taxa_regulamentacao());
            stmt.setObject(16, a.getAgu_multa());
            stmt.setObject(17, a.getAgu_tarifa_ate10_agua());
            stmt.setObject(18, a.getAgu_tarifa_ate20_agua());
            stmt.setObject(19, a.getAgu_tarifa_ate30_agua());
            stmt.setObject(20, a.getAgu_tarifa_ate50_agua());
            stmt.setObject(21, a.getAgu_tarifa_acima50_agua());
            stmt.setObject(22, a.getAgu_tarifa_ate10_esgoto());
            stmt.setObject(23, a.getAgu_tarifa_ate20_esgoto());
            stmt.setObject(24, a.getAgu_tarifa_ate30_esgoto());
            stmt.setObject(25, a.getAgu_tarifa_ate50_esgoto());
            stmt.setObject(26, a.getAgu_tarifa_acima50_esgoto());
            stmt.setObject(27, a.getAgu_valor_agua1());
            stmt.setObject(28, a.getAgu_valor_agua2());
            stmt.setObject(29, a.getAgu_valor_esgoto1());
            stmt.setObject(30, a.getAgu_valor_esgoto2());
            stmt.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }
    }

        public static List<Agua> read() {

        Connection con = ConexaoBd.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Agua> contas_agua = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT int_numero_instalacao,cta_mes_referencia,agu_tipo_ligacao,agu_hidrometro,agu_consumo,agu_valor_agua,agu_valor_esgoto,agu_taxa_regulamentacao,agu_multa FROM agu_agua");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Agua agua = new Agua();

                agua.setInt_numero_instalacao(BigInteger.valueOf(rs.getLong("int_numero_instalacao")));
                agua.setCta_mes_referencia(rs.getString("cta_mes_referencia"));
                agua.setAgu_tipo_ligacao(rs.getString("agu_tipo_ligacao"));
                agua.setAgu_hidrometro(rs.getString("agu_hidrometro"));
                agua.setAgu_consumo(BigInteger.valueOf(rs.getLong("agu_consumo")));
                agua.setAgu_valor_agua(BigDecimal.valueOf(rs.getDouble("agu_valor_agua")));
                agua.setAgu_valor_esgoto(BigDecimal.valueOf(rs.getDouble("agu_valor_esgoto")));
                agua.setAgu_taxa_regulamentacao(BigDecimal.valueOf(rs.getDouble("agu_taxa_regulamentacao")));
                agua.setAgu_multa(BigDecimal.valueOf(rs.getDouble("agu_multa")));
                
                contas_agua.add(agua);
            }

        } catch (SQLException ex) {
            Logger.getLogger(InstalacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBd.closeConnection(con, stmt, rs);
        }
        return contas_agua;

    }

    public static boolean validacaoConta(BigInteger n, String d) {
        
        Connection con = ConexaoBd.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM agu_agua where int_numero_instalacao = ? and cta_mes_referencia = ?");
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

    public static void buscar1(BigInteger n, String m,TextField txtGR, TextField txtCodigoCliente,
    TextField txtNumeroConta,TextField txtTipoLigacao, TextField txtHidrometro, TextField txtLeituraAntData,
    TextField txtLeituraAntNumero,TextField txtLeituraAtualData, TextField txtLeituraAtualNumero, TextField txtConsumo) {
        
        Connection con = ConexaoBd.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("SELECT * FROM agu_agua where int_numero_instalacao = ? and cta_mes_referencia = ?");
            stmt.setObject(1, n);
            stmt.setObject(2, m);

            rs = stmt.executeQuery();

            while (rs.next()) {
                a = new Agua();

                a.setInt_numero_instalacao(BigInteger.valueOf(Long.parseLong(rs.getString("int_numero_instalacao"))));
                a.setCta_mes_referencia(rs.getString("cta_mes_referencia"));

                Agua agu = new Agua();
                agu.setAgu_gr(BigInteger.valueOf(Long.parseLong(rs.getString("agu_gr"))));
                agu.setAgu_codigo_cliente(BigInteger.valueOf(Long.parseLong(rs.getString("agu_codigo_cliente"))));
                agu.setAgu_numero_conta(BigInteger.valueOf(Long.parseLong(rs.getString("agu_numero_conta"))));
                agu.setAgu_tipo_ligacao(rs.getString("agu_tipo_ligacao"));
                agu.setAgu_hidrometro(rs.getString("agu_hidrometro"));
                agu.setAgu_data_leitura_anterior(rs.getString("agu_data_leitura_anterior"));
                agu.setAgu_data_leitura_atual(rs.getString("agu_data_leitura_atual"));
                agu.setAgu_leitura_anterior(BigInteger.valueOf(Long.parseLong(rs.getString("agu_leitura_anterior"))));
                agu.setAgu_leitura_atual(BigInteger.valueOf(Long.parseLong(rs.getString("agu_leitura_atual"))));
                agu.setAgu_consumo(BigInteger.valueOf(Long.parseLong(rs.getString("agu_consumo"))));

                txtGR.setText(String.valueOf(agu.getAgu_gr()));
                txtCodigoCliente.setText(String.valueOf(agu.getAgu_codigo_cliente()));
                txtNumeroConta.setText(String.valueOf(agu.getAgu_numero_conta()));
                txtTipoLigacao.setText(agu.getAgu_tipo_ligacao());
                txtHidrometro.setText(agu.getAgu_hidrometro());
                txtLeituraAntData.setText(agu.getAgu_data_leitura_anterior());
                txtLeituraAntNumero.setText(String.valueOf(agu.getAgu_leitura_anterior()));
                txtLeituraAtualData.setText(agu.getAgu_data_leitura_atual());
                txtLeituraAtualNumero.setText(String.valueOf(agu.getAgu_leitura_atual()));
                txtConsumo.setText(String.valueOf(agu.getAgu_consumo()));
            }
        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }

    }

    public static void buscar2(TextField txtTarifaAguaAte10,TextField txtTarifaAgua11a20,
    TextField txtTarifaAgua21a31,TextField txtTarifaAgua31a50,TextField txtTarifaAcima50,TextField txtValorAguaAte10,
    TextField txtValorAgua11a20,TextField txtTarifaEsgotoAte10,TextField txtTarifaEsgoto11a20,
    TextField txtTarifaEsgoto21a30,TextField txtTarifaEsgoto31a50,TextField txtTarifaEsgotoAcima50,
    TextField txtValorEsgotoAte10,TextField txtValorEsgoto11a20,TextField txtVIAgua,
    TextField txtVIEsgoto,TextField txtTaxaRegulacao,TextField txtMulta) {
        
        Connection con = ConexaoBd.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("SELECT * FROM agu_agua where int_numero_instalacao = ? and cta_mes_referencia = ?");
            stmt.setObject(1, a.getInt_numero_instalacao());
            stmt.setObject(2, a.getCta_mes_referencia());

            rs = stmt.executeQuery();

            while (rs.next()) {

                Agua agu = new Agua();
                agu.setAgu_valor_agua(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_valor_agua"))));
                agu.setAgu_valor_esgoto(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_valor_esgoto"))));
                agu.setAgu_taxa_regulamentacao(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_taxa_regulamentacao"))));
                agu.setAgu_multa(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_multa"))));
                agu.setAgu_tarifa_ate10_agua(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_tarifa_ate10_agua"))));
                agu.setAgu_tarifa_ate20_agua(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_tarifa_ate20_agua"))));
                agu.setAgu_tarifa_ate30_agua(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_tarifa_ate30_agua"))));
                agu.setAgu_tarifa_ate50_agua(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_tarifa_ate50_agua"))));
                agu.setAgu_tarifa_acima50_agua(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_tarifa_acima50_agua"))));
                agu.setAgu_tarifa_ate10_esgoto(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_tarifa_ate10_esgoto"))));
                agu.setAgu_tarifa_ate20_esgoto(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_tarifa_ate20_esgoto"))));
                agu.setAgu_tarifa_ate30_esgoto(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_tarifa_ate30_esgoto"))));
                agu.setAgu_tarifa_ate50_esgoto(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_tarifa_ate50_esgoto"))));
                agu.setAgu_tarifa_acima50_esgoto(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_tarifa_acima50_esgoto"))));
                agu.setAgu_valor_agua1(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_valor_agua1"))));
                agu.setAgu_valor_agua2(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_valor_agua2"))));
                agu.setAgu_valor_esgoto1(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_valor_esgoto1"))));
                agu.setAgu_valor_esgoto2(BigDecimal.valueOf(Double.parseDouble(rs.getString("agu_valor_esgoto2"))));
    
                txtTarifaAguaAte10.setText(String.valueOf(agu.getAgu_tarifa_ate10_agua()));
                txtTarifaAgua11a20.setText(String.valueOf(agu.getAgu_tarifa_ate20_agua()));
                txtTarifaAgua21a31.setText(String.valueOf(agu.getAgu_tarifa_ate30_agua()));
                txtTarifaAgua31a50.setText(String.valueOf(agu.getAgu_tarifa_ate50_agua()));
                txtTarifaAcima50.setText(String.valueOf(agu.getAgu_tarifa_acima50_agua()));
                txtValorAguaAte10.setText(String.valueOf(agu.getAgu_valor_agua1()));
                txtValorAgua11a20.setText(String.valueOf(agu.getAgu_valor_agua2()));
                txtTarifaEsgotoAte10.setText(String.valueOf(agu.getAgu_tarifa_ate10_esgoto()));
                txtTarifaEsgoto11a20.setText(String.valueOf(agu.getAgu_tarifa_ate20_esgoto()));
                txtTarifaEsgoto21a30.setText(String.valueOf(agu.getAgu_tarifa_ate30_esgoto()));
                txtTarifaEsgoto31a50.setText(String.valueOf(agu.getAgu_tarifa_ate50_esgoto()));
                txtTarifaEsgotoAcima50.setText(String.valueOf(agu.getAgu_tarifa_acima50_esgoto()));
                txtValorEsgotoAte10.setText(String.valueOf(agu.getAgu_valor_esgoto1()));
                txtValorEsgoto11a20.setText(String.valueOf(agu.getAgu_valor_esgoto2()));
                txtVIAgua.setText(String.valueOf(agu.getAgu_valor_agua()));
                txtVIEsgoto.setText(String.valueOf(agu.getAgu_valor_esgoto()));
                txtTaxaRegulacao.setText(String.valueOf(agu.getAgu_taxa_regulamentacao()));
                txtMulta.setText(String.valueOf(agu.getAgu_multa()));
            }
        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }

    }

    public void update1(Agua agu) {
        
        Connection con = ConexaoBd.getConnection();
    
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE agu_agua SET agu_gr = ? ,agu_codigo_cliente  = ?,agu_numero_conta  = ?,agu_tipo_ligacao  = ?,agu_hidrometro  = ?,agu_data_leitura_anterior  = ?," +
            "agu_data_leitura_atual  = ?,agu_leitura_anterior  = ?,agu_leitura_atual  = ?,agu_consumo  = ? WHERE int_numero_instalacao = ? and cta_mes_referencia = ?");
           
            stmt.setObject(1, agu.getAgu_gr());
            stmt.setObject(2, agu.getAgu_codigo_cliente());
            stmt.setObject(3, agu.getAgu_numero_conta());
            stmt.setObject(4, agu.getAgu_tipo_ligacao());
            stmt.setObject(5, agu.getAgu_hidrometro());
            stmt.setObject(6, agu.getAgu_data_leitura_anterior());
            stmt.setObject(7, agu.getAgu_data_leitura_atual());
            stmt.setObject(8, agu.getAgu_leitura_anterior());
            stmt.setObject(9, agu.getAgu_leitura_atual());
            stmt.setObject(10, agu.getAgu_consumo());
            stmt.setObject(11, agu.getInt_numero_instalacao());
            stmt.setObject(12, agu.getCta_mes_referencia());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }
    }

    public void update2(Agua agu) {
        
        Connection con = ConexaoBd.getConnection();
    
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE agu_agua SET agu_valor_agua = ? ,agu_valor_esgoto  = ?,agu_taxa_regulamentacao  = ?,agu_multa  = ?,agu_tarifa_ate10_agua  = ?,agu_tarifa_ate20_agua  = ?," +
            "agu_tarifa_ate30_agua  = ?,agu_tarifa_ate50_agua  = ?,agu_tarifa_acima50_agua  = ?,agu_tarifa_ate10_esgoto  = ?,agu_tarifa_ate20_esgoto = ?,agu_tarifa_ate30_esgoto = ?," +
            "agu_tarifa_ate50_esgoto = ?,agu_tarifa_acima50_esgoto = ?,agu_valor_agua1 = ? ,agu_valor_agua2  = ?,agu_valor_esgoto1  = ?,agu_valor_esgoto2  = ? WHERE int_numero_instalacao = ? and cta_mes_referencia = ?");
           
            stmt.setObject(1, agu.getAgu_valor_agua());
            stmt.setObject(2, agu.getAgu_valor_esgoto());
            stmt.setObject(3, agu.getAgu_taxa_regulamentacao());
            stmt.setObject(4, agu.getAgu_multa());
            stmt.setObject(5, agu.getAgu_tarifa_ate10_agua());
            stmt.setObject(6, agu.getAgu_tarifa_ate20_agua());
            stmt.setObject(7, agu.getAgu_tarifa_ate30_agua());
            stmt.setObject(8, agu.getAgu_tarifa_ate50_agua());
            stmt.setObject(9, agu.getAgu_tarifa_acima50_agua());
            stmt.setObject(10, agu.getAgu_tarifa_ate10_esgoto());
            stmt.setObject(11, agu.getAgu_tarifa_ate20_esgoto());
            stmt.setObject(12, agu.getAgu_tarifa_ate30_esgoto());
            stmt.setObject(13, agu.getAgu_tarifa_ate50_esgoto());
            stmt.setObject(14, agu.getAgu_tarifa_acima50_esgoto());
            stmt.setObject(15, agu.getAgu_valor_agua1());
            stmt.setObject(16, agu.getAgu_valor_agua2());
            stmt.setObject(17, agu.getAgu_valor_esgoto1());
            stmt.setObject(18, agu.getAgu_valor_esgoto2());
            stmt.setObject(19, a.getInt_numero_instalacao());
            stmt.setObject(20, a.getCta_mes_referencia());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }
    }
     public void delete() {
        
        Connection con = ConexaoBd.getConnection();
    
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM agu_agua WHERE int_numero_instalacao = ? and cta_mes_referencia = ?");
        
            stmt.setObject(1, a.getInt_numero_instalacao());
            stmt.setString(2, a.getCta_mes_referencia());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }
    }
}