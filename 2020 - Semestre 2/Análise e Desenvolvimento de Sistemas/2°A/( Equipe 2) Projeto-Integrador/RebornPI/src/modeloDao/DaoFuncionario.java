/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import modeloConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.BeansFuncionario;


public class DaoFuncionario { 
    ConexaoBD conex = new ConexaoBD();
    BeansFuncionario mod = new BeansFuncionario();
    
    public void Salvar(BeansFuncionario mod){
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into funcionarios(nome_funcionario, senha_funcionario, cpf_funcionario, rg_funcionario, cnh_funcionario) values(?,?,?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getSenha());
            pst.setInt(3, mod.getCpf());
            pst.setInt(4, mod.getRg());
            pst.setString(5, mod.getCnh());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Salvos com Sucesso!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao salvar Dados!:\n"+ex.getMessage());
        }
        
        
        
        conex.desconecta();
    }
    
    public void Editar(BeansFuncionario mod){
        conex.conexao();
      
        try {
           PreparedStatement pst = conex.con.prepareStatement("update funcionarios set nome_funcionario = ?, senha_funcionario=?,cpf_funcionario=?,rg_funcionario=?,cnh_funcionario=? where cod_funcionario=?");
           pst.setString(1, mod.getNome());
           pst.setString(2, mod.getSenha());
           pst.setInt(3, mod.getCpf());
           pst.setInt(4, mod.getRg());
           pst.setString(5, mod.getCnh());
           pst.setInt(6, mod.getCodigo());
           pst.execute();
           JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!");
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar Dados!:\n"+ex.getMessage());
        }
        
        
        
        
        conex.desconecta();
    }
    
    public void Excluir(BeansFuncionario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from funcionarios where cod_funcionario=?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados excluidos com Sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Dados!:\n"+ex.getMessage());
        }
        
        
        
        
        
        
        
        conex.desconecta();
    }
    
    
    
    public BeansFuncionario buscaFuncionario(BeansFuncionario mod){
        
        conex.conexao();
        conex.executaSql("select *from funcionarios where nome_funcionario like'%"+mod.getPesquisa()+"%'");
        try {
            conex.rs.first();
            mod.setNome(conex.rs.getString("nome_funcionario"));
            mod.setSenha(conex.rs.getString("senha_funcionario"));
            mod.setCpf(conex.rs.getInt("cpf_funcionario"));
            mod.setRg(conex.rs.getInt("rg_funcionario"));
            mod.setCnh(conex.rs.getString("cnh_funcionario"));
            mod.setCodigo(conex.rs.getInt("cod_funcionario"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Funcionário não cadastrado");
        }
        
        
        conex.desconecta();
        return mod;
        
    }
}
