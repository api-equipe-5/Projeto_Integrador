package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
        }
        catch(SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
    
}
