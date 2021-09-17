package DAO;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class Conexao {
  public Connection getConnection() {
		 try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/digicont?useTimezone=true&serverTimezone=UTC","root","Amor041612#");
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
  }
}


