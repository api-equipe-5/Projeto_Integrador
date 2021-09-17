package dao;

import factory.ConnectionFactory;
import modelo.motorista;
import java.sql.*;
import java.sql.PreparedStatement;

public class motoristaDAO {
    
    private Connection connection;
    
    String id_mot;   
    String nome_mot;
    String cpf_mot;
    String rg_mot;
    String cep_mot;
    String num_mot;
    String endereco_mot;
    String cidade_mot;
    String estado_mot;
    String tel_mot;
    String cel_mot;
    String email_mot; 
    String login_mot; 
    String senha_mot; 
    
    public motoristaDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(motorista motorista){
        String sql = "insert into motorista(nome_mot, cpf_mot, rg_mot, cep_mot, num_mot, endereco_mot,"
                + "cidade_mot, estado_mot, tel_mot, cel_mot, email_mot, login_mot, senha_mot"
                + ") values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, motorista.getNome_mot());
            stmt.setString(2, motorista.getCpf_mot());            
            stmt.setString(3, motorista.getRg_mot());
            stmt.setString(4, motorista.getCep_mot());            
            stmt.setString(5, motorista.getNum_mot());
            stmt.setString(6, motorista.getEndereco_mot());
            stmt.setString(7, motorista.getCidade_mot());
            stmt.setString(8, motorista.getEstado_mot());
            stmt.setString(9, motorista.getTel_mot());
            stmt.setString(10, motorista.getCel_mot());
            stmt.setString(11, motorista.getEmail_mot());
            stmt.setString(12, motorista.getLogin_mot());
            stmt.setString(13, motorista.getSenha_mot());
            
            stmt.execute();
            stmt.close();  
        }
        catch(SQLException u){
            throw new RuntimeException(u);            
        }
    }
    
}
