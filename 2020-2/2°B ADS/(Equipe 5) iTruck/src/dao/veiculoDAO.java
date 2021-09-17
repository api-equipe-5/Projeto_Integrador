package dao;

import factory.ConnectionFactory;
import modelo.veiculo;
import java.sql.*;
import java.sql.PreparedStatement;

public class veiculoDAO {
    
    private Connection connection;
    
    String id_vei;
    String marca_vei;
    String modelo_vei;
    String ano_vei;
    String cor_vei;
    String placa_vei;
    String estado_vei;
    
    public veiculoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(veiculo veiculo){
        String sql = "insert into veiculo(marca_vei, modelo_vei, ano_vei, cor_vei, placa_vei, estado_vei) values (?,?,?,?,?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, veiculo.getMarca_vei());
            stmt.setString(2, veiculo.getModelo_vei());
            stmt.setString(3, veiculo.getAno_vei());
            stmt.setString(4, veiculo.getCor_vei());
            stmt.setString(5, veiculo.getPlaca_vei());
            stmt.setString(6, veiculo.getEstado_vei());
            
            stmt.execute();
            stmt.close();  
        }
        catch(SQLException u){
            throw new RuntimeException(u);            
        }
    }
    
}
