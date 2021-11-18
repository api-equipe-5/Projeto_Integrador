/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloConection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBD {
    
   public Statement stm; // Responsável pela pesquisa das informações no BD
   public ResultSet rs; // Responsável pela guarda das informações no BD
   private String driver = "org.postgresql.Driver";
   private String caminho = "jdbc:postgresql://localhost:5432/rebornPI";
   private String usuario = "postgres";
   private String senha = "jkez010os";
   public Connection con; // Responsável pela conexão com o BD
    
   
   public void conexao(){  // método responsável por realizar conexão com o BD
       System.setProperty("jdbc.Drivers", driver);
       try {
           System.setProperty("jdbc.Drivers", driver);
           con = DriverManager.getConnection(caminho, usuario, senha);
           //JOptionPane.showMessageDialog(null,"Conexão Efetuada com Sucesso!");
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao conectar com o BD:\n"+ex.getMessage());
       }
       
   }
   
   public void executaSql(String sql){
    
       try {
           stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
           rs = stm.executeQuery(sql);
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao ExecutaSQL:\n"+ex.getMessage());
       }
    
    
    
}
   
   
    public void desconecta(){
       try {
           con.close();
          // JOptionPane.showMessageDialog(null,"BD Desconectado com Sucesso!");
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao se desconectar ao BD:\n"+ex.getMessage());
       }
        
    }
   
   
}
