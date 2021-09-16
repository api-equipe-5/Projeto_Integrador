package dao;

import conexao.ConexaoBd;
import classes.Cliente;

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

import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;

public class ClienteDAO {
    //Metodo para inserir dados na tabela Cliente
    public void create(Cliente c) {
        
        Connection con = ConexaoBd.getConnection();
    
        PreparedStatement stmt = null;
        //Inserindo dados na tabela atraves do metodo INSERT
        try {
            stmt = con.prepareStatement("INSERT INTO cli_cliente (cli_documento,cli_nome,cli_email) VALUES(?,?,?)");
            stmt.setObject(1, c.getCli_documento());
            stmt.setString(2, c.getCli_nome());
            stmt.setString(3, c.getCli_email());
            stmt.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }

    }

    public static void buscar(BigInteger c, TextField a, TextField b) {
        
        Connection con = ConexaoBd.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM cli_cliente where cli_documento = ?");
            stmt.setObject(1, c);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setCli_nome(rs.getString("cli_nome"));
                cliente.setEmail(rs.getString("cli_email"));

                a.setText(cliente.getCli_nome());
                b.setText(cliente.getCli_email());
            }
        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }

    }

    public static boolean validacaoCliente(BigInteger c) {
        
        Connection con = ConexaoBd.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cli_cliente where cli_documento = ?");
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
    public void update(Cliente c) {
        
        Connection con = ConexaoBd.getConnection();
    
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE cli_cliente SET cli_nome  = ?,cli_email  = ? WHERE cli_documento = ?");
           
            stmt.setString(1, c.getCli_nome());
            stmt.setString(2, c.getCli_email());
            stmt.setObject(3, c.getCli_documento());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

        // Finally usado para fechar a conexao e statement se der ou não erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }
    }
}