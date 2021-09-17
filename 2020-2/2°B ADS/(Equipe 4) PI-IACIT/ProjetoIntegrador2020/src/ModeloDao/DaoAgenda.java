/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import ModeloConection.ConexaoBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.BeansAgenda;

/**
 *
 * @author Daniel
 */
public class DaoAgenda {
    BeansAgenda agenda = new BeansAgenda();
    ConexaoBD conex = new ConexaoBD();
    
    ConexaoBD conexfuncionario = new ConexaoBD();
    ConexaoBD conexVeiculo = new ConexaoBD();
    
    int codfuncionario;
    int codveiculo;
    
    public void Salvar(BeansAgenda agenda){
        BuscarFuncionario(agenda.getNomeFuncionario());
        BuscarVeiculo(agenda.getNomeVeiculo());
        
        conex.conexao();
        try {
           PreparedStatement pst = conex.con.prepareStatement("insert into agenda2 (agenda_codfuncionario, agenda_veiculo,agenda_data,agenda_estado,agenda_local,agenda_carga,agenda_status) values(?,?,?,?,?,?,?)");
        pst.setInt(1, codfuncionario);
        pst.setInt(2, codveiculo);
        pst.setString(3, agenda.getData());
        pst.setString(4, agenda.getEstado());
        pst.setString(5, agenda.getLocalobservacao());
        pst.setString(6, agenda.getCarga());
        pst.setString(7, agenda.getStatus());
        
        
        pst.execute();
        
        
        JOptionPane.showMessageDialog(null, "Trajeto salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro ao salvar agendamento");
        }
        
        conex.desconecta();
        
        
    }
    public void BuscarFuncionario(String nomeFuncionario){
        conexfuncionario.conexao();
        
        conexfuncionario.executasql("select *from funcionarios where nome_funcionario='" +nomeFuncionario +"'");
        try {
            conexfuncionario.rs.first();
            codfuncionario = conexfuncionario.rs.getInt("cod_usuario");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "funcionario nao encontrado");
        }
        
        conexfuncionario.desconecta();
        
    }
    public void BuscarVeiculo(String nomeVeiculo){
         conexVeiculo.conexao();
        
        conexVeiculo.executasql("select *from base_veiculo where modelo='" +nomeVeiculo +"'");
        try {
            conexVeiculo.rs.first();
            codveiculo = conexVeiculo.rs.getInt("codigo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Veiculo nao encontrado");
        }
        
        conexVeiculo.desconecta();
        
    }
    public void Alterar(BeansAgenda agenda){
        conex.conexao();
        
        PreparedStatement pst;
        try {
            pst = conex.con.prepareStatement("update agenda2 set agenda_status=? where agenda_cod=?");
             
       pst.setString(1, agenda.getStatus());
       pst.setInt(2,agenda.getAgendaCod());
       
       pst.execute();
       
        
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        conex.desconecta();
   
    
    }
        
    }

