package dao;

import conexao.ConexaoBd;
import classes.Fornecedor;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class FornecedorDAO {
    //Metodo para inserir dados na tabela Cliente
    public void create(Fornecedor f) {
        
        Connection con = ConexaoBd.getConnection();
    
        PreparedStatement stmt = null;
        //Inserindo dados na tabela atraves do metodo INSERT
        try {
            stmt = con.prepareStatement("INSERT INTO for_fornecedor (for_cnpj,for_nome,for_tipo) VALUES(?,?,?)");
            stmt.setObject(1, f.getFor_cnpj());
            stmt.setString(2, f.getFor_nome());
            stmt.setObject(3, f.getFor_tipo());
            stmt.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }

    }

    public static void buscar(BigInteger f, TextField a, ComboBox b) {
        
        Connection con = ConexaoBd.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        //Inserindo dados na tabela atraves do metodo INSERT
        try {
            stmt = con.prepareStatement("SELECT * FROM for_fornecedor where for_cnpj = ?");
            stmt.setObject(1, f);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setFor_nome(rs.getString("for_nome"));
                fornecedor.setFor_tipo(rs.getString("for_tipo"));

                a.setText(fornecedor.getFor_nome());
                b.setValue(fornecedor.getFor_tipo());
            }
        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }

    }

    public static boolean validacaoFornecedor(BigInteger f) {
        
        Connection con = ConexaoBd.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM for_fornecedor where for_cnpj = ?");
            stmt.setObject(1, f);

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
    public void update(Fornecedor f) {
        
        Connection con = ConexaoBd.getConnection();
    
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE for_fornecedor SET for_nome  = ?,for_tipo  = ? WHERE for_cnpj = ?");
           
            stmt.setString(1, f.getFor_nome());
            stmt.setString(2, f.getFor_tipo());
            stmt.setObject(3, f.getFor_cnpj());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }
    }
}