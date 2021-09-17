package dao;

import conexao.ConexaoBd;
import classes.Conta;
import classes.Instalacao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javafx.scene.control.TextField;
import java.util.logging.Logger;

public class ContaDAO {

    private static Conta c = new Conta();
    //Metodo para inserir dados na tabela Cliente
    public void create(Conta cta) {
        
        Connection con = ConexaoBd.getConnection();
    
        PreparedStatement stmt = null;
        //Inserindo dados na tabela atraves do metodo INSERT
        try {
            stmt = con.prepareStatement("INSERT INTO cta_conta (int_numero_instalacao, cta_mes_referencia, cta_vencimento, cta_usuario) VALUES(?,?,?,?)");
            stmt.setObject(1, cta.getInt_numero_instalacao());
            stmt.setString(2, cta.getCta_mes_referencia());
            stmt.setString(3, cta.getCta_vencimento());
            stmt.setString(4, cta.getCta_usuario());
            stmt.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }

    }
       public static void buscarconta(BigInteger n, String m, TextField txtDataVencimento) {
        
        Connection con = ConexaoBd.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("SELECT * FROM cta_conta where int_numero_instalacao = ? and cta_mes_referencia = ?");
            stmt.setObject(1, n);
            stmt.setObject(2, m);

            rs = stmt.executeQuery();

            while (rs.next()) {
                c = new Conta();

                c.setInt_numero_instalacao(BigInteger.valueOf(Long.parseLong(rs.getString("int_numero_instalacao"))));
                c.setCta_mes_referencia(rs.getString("cta_mes_referencia"));

                Conta cta = new Conta();
                cta.setCta_vencimento(rs.getString("cta_vencimento"));
                txtDataVencimento.setText(cta.getCta_vencimento());
            }
        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }

    }

    public static void buscarUsuario(TextField txtUsuario) {
        
        Connection con = ConexaoBd.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("SELECT cta_usuario FROM cta_conta where int_numero_instalacao = ? and cta_mes_referencia = ?");
            stmt.setObject(1, c.getInt_numero_instalacao());
            stmt.setObject(2, c.getCta_mes_referencia());

            rs = stmt.executeQuery();

            while (rs.next()) {

                Conta cta = new Conta();
                cta.setCta_usuario(rs.getString("cta_usuario"));
                txtUsuario.setText(cta.getCta_usuario());
            }
        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }

    }

    public static void buscarContador(TextField txtNCadastros) {
        
        Integer contador;
        Connection con = ConexaoBd.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("SELECT count(cta_usuario) FROM cta_conta where int_numero_instalacao = ? and cta_mes_referencia = ?");
            stmt.setObject(1, c.getInt_numero_instalacao());
            stmt.setObject(2, c.getCta_mes_referencia());

            rs = stmt.executeQuery();

            while (rs.next()) {

                contador = rs.getInt("count(cta_usuario)");

                txtNCadastros.setText(String.valueOf(contador));

            }
        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }

    }
    
    public void updateconta(Conta d) {
        
        Connection con = ConexaoBd.getConnection();
    
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE cta_conta SET cta_vencimento = ? WHERE int_numero_instalacao = ? and cta_mes_referencia = ?");
           
            stmt.setString(1, d.getCta_vencimento());
            stmt.setObject(2, d.getInt_numero_instalacao());
            stmt.setString(3, d.getCta_mes_referencia());
            
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
            stmt = con.prepareStatement("DELETE FROM cta_conta WHERE int_numero_instalacao = ? and cta_mes_referencia = ?");
        
            stmt.setObject(1, c.getInt_numero_instalacao());
            stmt.setString(2, c.getCta_mes_referencia());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }
    }
}