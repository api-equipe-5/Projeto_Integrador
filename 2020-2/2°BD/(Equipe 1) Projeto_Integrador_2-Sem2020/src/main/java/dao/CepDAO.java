package dao;

import conexao.ConexaoBd;
import classes.Cep;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

public class CepDAO {
     //Metodo para inserir dados na tabela Cliente
    public void create(Cep c) {
        
        Connection con = ConexaoBd.getConnection();
    
        PreparedStatement stmt = null;
        //Inserindo dados na tabela atraves do metodo INSERT
        try {
            stmt = con.prepareStatement("INSERT INTO cep_cep (cep_cep,cep_rua,cep_estado,cep_cidade) VALUES(?,?,?,?)");
            stmt.setObject(1, c.getCep_cep());
            stmt.setString(2, c.getCep_rua());;
            stmt.setString(3, c.getCep_estado());
            stmt.setString(4, c.getCep_cidade());

            stmt.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }
    
    }

    public static void buscar(BigInteger c, TextField a, TextField b, ComboBox combo) {
        
        Connection con = ConexaoBd.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM cep_cep where cep_cep = ?");
            stmt.setObject(1, c);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Cep cep = new Cep();

                cep.setCep_cidade(rs.getString("cep_cidade"));
                cep.setCep_estado(rs.getString("cep_estado"));
                cep.setCep_rua(rs.getString("cep_rua"));

                a.setText(cep.getCep_cidade());
                b.setText(cep.getCep_rua());
                combo.setValue(cep.getCep_estado());
            }
        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }

    }

    public static boolean validacaoCEP(BigInteger c) {
        
        Connection con = ConexaoBd.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cep_cep where cep_cep = ?");
            stmt.setObject(1, c);

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

    public void update(Cep c) {
        
        Connection con = ConexaoBd.getConnection();
    
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE cep_cep SET cep_rua  = ?,cep_estado  = ?,cep_cidade = ? WHERE cep_cep = ?");
           
            stmt.setString(1, c.getCep_rua());
            stmt.setString(2, c.getCep_estado());
            stmt.setString(3, c.getCep_cidade());
            stmt.setObject(4, c.getCep_cep());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }
    }
}