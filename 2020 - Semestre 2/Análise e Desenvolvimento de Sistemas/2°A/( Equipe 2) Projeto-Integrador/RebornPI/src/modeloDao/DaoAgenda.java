/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import modeloConection.ConexaoBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.BeansAgenda;
import modeloBeans.BeansFuncionario;

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
        PreparedStatement pst = conex.con.prepareStatement("insert into agenda (agenda_codfuncionario, agenda_codveiculo,agenda_estado,agenda_data,agenda_endereco,agenda_carga,agenda_obs) values(?,?,?,?,?,?,?)");
        pst.setInt(1, codfuncionario);
        pst.setInt(2, codveiculo);
        pst.setString(3, agenda.getEstado());   
        pst.setDate(4, new java.sql.Date(agenda.getData().getTime()));
        pst.setString(5, agenda.getEndereço());
        pst.setString(6, agenda.getCarga());
        pst.setString(7, agenda.getObs());
        pst.execute();
        JOptionPane.showMessageDialog(null,"Entrega Agendada com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Salvar Agendamento!\n"+ex.getMessage());
        }
        
        conex.desconecta();
        
        
    }
    public void BuscarFuncionario(String nomeFuncionario){
        conexfuncionario.conexao();
        
        conexfuncionario.executaSql("select *from funcionarios where nome_funcionario='"+nomeFuncionario+"'");
        try {
            conexfuncionario.rs.first();
            codfuncionario = conexfuncionario.rs.getInt("cod_funcionario");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Funcionário não Encontrado:\n"+ex.getMessage());
        }
        
        conexfuncionario.desconecta();
        
    }
         public void BuscarVeiculo(String nomeVeiculo){
         conexVeiculo.conexao();
        
        conexVeiculo.executaSql("select *from veiculos where marca_veiculo='"+nomeVeiculo +"'");
        try {
            conexVeiculo.rs.first();
            codveiculo = conexVeiculo.rs.getInt("cod_id");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "veículo não Cadastrado:\n"+ex.getMessage());
        }
        
        conexVeiculo.desconecta();
        
    }
        
       
    }


