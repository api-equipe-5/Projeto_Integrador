/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloConection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class ConexaoBD {
   public  Statement stm;
   public ResultSet rs;
  private  String driver ="org.postgresql.Driver";
  private  String caminho="jdbc:postgresql://localhost:5432/bancodedados";
  private  String usuario = "postgres";
  private  String senha= "01020300";
   public Connection con;
   
   public void conexao(){
       System.setProperty("jdbc.Drivers", driver);
       try {
           con=DriverManager.getConnection(caminho,usuario,senha);
      //     JOptionPane.showMessageDialog(null,"conexao efetuada");
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,"erro ao se conectar: "+ex.getMessage());
       }
       
   }
   public void executasql(String sql){
       try {
           stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
           rs = stm.executeQuery(sql);
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "erro ao executar sql");
       }
   
   }
   
   
   
   public void desconecta(){
       try {
           con.close();
        //   JOptionPane.showMessageDialog(null,"desconectado com sucesso");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"nao foi feita a desconexao");
       }
       
   }
}
