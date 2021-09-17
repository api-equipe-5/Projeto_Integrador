/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import ModeloConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansFuncionario;
import modeloBeans.BeansVeiculo;

/**
 *
 * @author Daniel
 */
public class DaoVeiculo {
     ConexaoBD conex = new ConexaoBD();
    BeansVeiculo mod = new BeansVeiculo();
    
    public void Salvara(BeansVeiculo mod){
        conex.conexao();
       try {
           PreparedStatement pst = conex.con.prepareStatement("insert into base_veiculo(cor,modelo,placa,ano) values(?,?,?,?)");
           pst.setString(1, mod.getCor());
           pst.setString(2, mod.getModelo());
           pst.setString(3, mod.getPlaca());
           pst.setString(4, mod.getAno());
           pst.execute();
           JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");
           
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "erro ao inserir dados");
       }
        
        conex.desconecta();
}
    public BeansVeiculo buscaUsuario(BeansVeiculo mod){
          conex.conexao();
          conex.executasql("select *from base_veiculo where modelo like'%"+mod.getVpesquisa()+"%'");
       try {
           conex.rs.first();
           mod.setCod(conex.rs.getInt("codigo"));
           mod.setCor(conex.rs.getString("cor"));
           mod.setModelo(conex.rs.getString("modelo"));
           mod.setPlaca(conex.rs.getString("placa"));
           mod.setAno(conex.rs.getString("ano"));
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Nome nao encontrando ou mal informado");
       }
          
          conex.desconecta();
        
    return mod;
    }
    public void Editar(BeansVeiculo mod){
        conex.conexao();
       try {
           
           PreparedStatement pst = conex.con.prepareStatement("update base_veiculo set modelo=?, cor=?, placa=?, ano=? where codigo=?");
       
       pst.setString(1, mod.getModelo());
       pst.setString(2, mod.getCor());
       pst.setString(3, mod.getPlaca());
       pst.setString(4, mod.getAno());
       pst.setInt(5,mod.getCod());
       
       pst.execute();
       
       JOptionPane.showMessageDialog(null, "Dados Alterados com sucesso");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro na alteraçao dos dados");
       }
        
        
        conex.desconecta();
        
        
    }
    public void Excluir(BeansVeiculo mod){
    conex.conexao();
       try {
           PreparedStatement pst = conex.con.prepareStatement("delete from base_veiculo where codigo = ?");
           pst.setInt(1,mod.getCod());
           pst.execute();
           JOptionPane.showMessageDialog(null, "excluido com sucesso");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao excluir dados");
       }
        
    
    
    
    conex.desconecta();
    }
}

