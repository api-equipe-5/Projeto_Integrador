/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import modelo.Regiao;
import java.sql.*;
import java.sql.PreparedStatement;

/**
 *
 * @author Leandro
 */
public class RegiaoDAO {
    
    private Connection connection;
    
    String estado;
    String sigla;
    String regiao;
    String valorHoraExtra;
    
    public RegiaoDAO(){
            this.connection = new ConnectionFactory().getConnection();
    }
    
    public void insere(Regiao regiao){
            String querry = "insert into regiao (estado, sigla, reg, valor_hora_extra)"
                    + "values (?,?,?,?)";
            
            try{
                PreparedStatement statement = connection.prepareStatement(querry);
                
                statement.setString(1, regiao.getEstado());
                statement.setString(2, regiao.getSigla());
                statement.setString(3, regiao.getRegiao());
                statement.setString(4, regiao.getValorHoraExtra());
                
                statement.execute();
                statement.close();
                connection.close();
            }
            catch(SQLException u){
                throw new RuntimeException(u);                
            }
    }
}
