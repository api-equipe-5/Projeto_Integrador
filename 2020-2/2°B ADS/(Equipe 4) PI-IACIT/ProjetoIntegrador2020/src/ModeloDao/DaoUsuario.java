/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import ModeloConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.BeansFuncionario;

/**
 *
 * @author Daniel
 */
public class DaoUsuario {
    
   ConexaoBD conex = new ConexaoBD();
    BeansFuncionario mod = new BeansFuncionario();
    
    public void Salvar(BeansFuncionario mod){
        conex.conexao();
       try {
           PreparedStatement pst = conex.con.prepareStatement("insert into funcionarios(nome_funcionario,senha,cpf,cnh,tipo_funcionario) values(?,?,?,?,?)");
           pst.setString(1, mod.getNome());
           pst.setString(2, mod.getSenha());
           pst.setInt(3, mod.getCpf());
           pst.setString(4, mod.getCnh());
           pst.setString(5, mod.getTipofuncionario());
           pst.execute();
           JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");
           
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "erro ao inserir dados");
       }
        
        conex.desconecta();
}
    public BeansFuncionario buscaUsuario(BeansFuncionario mod){
          conex.conexao();
          conex.executasql("select *from funcionarios where nome_funcionario like'%"+mod.getPesquisa()+"%'");
       try {
           conex.rs.first();
           mod.setCodigo(conex.rs.getInt("cod_usuario"));
           mod.setNome(conex.rs.getString("nome_funcionario"));
           mod.setSenha(conex.rs.getString("senha"));
           mod.setCpf(conex.rs.getInt("cpf"));
           mod.setCnh(conex.rs.getString("cnh"));
           mod.setTipofuncionario(conex.rs.getString("tipo_funcionario"));
           
           
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Nome nao encontrando ou mal informado");
       }
          
          conex.desconecta();
        
    return mod;
    }
    public void Editar(BeansFuncionario mod){
        conex.conexao();
       try {
           
           PreparedStatement pst = conex.con.prepareStatement("update funcionarios set nome_funcionario=?, senha=?, cpf=?, cnh=?, tipo_funcionario=? where cod_usuario=?");
       
       pst.setString(1, mod.getNome());
       pst.setString(2, mod.getSenha());
       pst.setInt(3, mod.getCpf());
       pst.setString(4, mod.getCnh());
       pst.setString(5, mod.getTipofuncionario());
       pst.setInt(6,mod.getCodigo());
       
       pst.execute();
       
       JOptionPane.showMessageDialog(null, "Dados Alterados com sucesso");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro na alteraçao dos dados");
       }
        
        
        conex.desconecta();
        
        
    }
    public void Excluir(BeansFuncionario mod){
    conex.conexao();
       try {
           PreparedStatement pst = conex.con.prepareStatement("delete from funcionarios where cod_usuario = ?");
           pst.setInt(1,mod.getCodigo());
           pst.execute();
           JOptionPane.showMessageDialog(null, "excluido com sucesso");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao excluir dados");
       }
        
    
    
    
    conex.desconecta();
    }
}