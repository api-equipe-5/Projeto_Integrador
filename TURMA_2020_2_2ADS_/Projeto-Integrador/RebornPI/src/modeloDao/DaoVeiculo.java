/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import modeloConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansFuncionario;
import modeloBeans.BeansVeiculo;

public class DaoVeiculo {
    ConexaoBD conex = new ConexaoBD();
    BeansVeiculo mod = new BeansVeiculo();
    
    public void Salvar(BeansVeiculo mod){
        conex.conexao();
       try {
           PreparedStatement pst = conex.con.prepareStatement("insert into veiculos(marca_veiculo,placa,ano_veiculo,numero_chassi) values(?,?,?,?)");
           pst.setString(1, mod.getMarca_veiculo());
           pst.setString(2, mod.getPlaca_veiculo());
           pst.setString(3, mod.getAno_veiculo());
           pst.setString(4, mod.getChassi());
           pst.execute();
           JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");
           
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "erro ao inserir dados\n:"+ex.getMessage());
       }
        
        conex.desconecta();
}
    public BeansVeiculo buscaVeiculo(BeansVeiculo mod){
          conex.conexao();
          conex.executaSql("select *from veiculos where marca_veiculo like'%"+mod.getveiculopesquisa()+"%'");
       try {
           conex.rs.first();
           mod.setCod(conex.rs.getInt("cod_id"));
           mod.setMarca_veiculo(conex.rs.getString("marca_veiculo"));
           mod.setPlaca_veiculo(conex.rs.getString("placa"));
           mod.setAno_veiculo(conex.rs.getString("ano_veiculo"));
           mod.setChassi(conex.rs.getString("numero_chassi"));
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Dados não Encontrado!");
       }
          
          conex.desconecta();
        
    return mod;
    }
    public void Editar(BeansVeiculo mod){
        conex.conexao();
       try {
           
           PreparedStatement pst = conex.con.prepareStatement("update veiculos set marca_veiculo=?, placa=?, ano_veiculo=?, numero_chassi=? where cod_id=?");
       
       pst.setString(1, mod.getMarca_veiculo());
       pst.setString(2, mod.getPlaca_veiculo());
       pst.setString(3, mod.getAno_veiculo());
       pst.setString(4, mod.getChassi());
       pst.setInt(5,mod.getCod());
       pst.execute();
       
       JOptionPane.showMessageDialog(null, "Dados Alterados com sucesso!");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro na alteraçao dos dados\n"+ex.getMessage());
       }
        
        
        conex.desconecta();
        
        
    }
    public void Excluir(BeansVeiculo mod){
    conex.conexao();
       try {
           PreparedStatement pst = conex.con.prepareStatement("delete from veiculos where cod_id=?");
           pst.setInt(1,mod.getCod());
           pst.execute();
           JOptionPane.showMessageDialog(null, "Dados Excluido com Sucesso!");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao excluir dados\n:"+ex.getMessage());
       }
        
    
    
    
    conex.desconecta();
    }
}
