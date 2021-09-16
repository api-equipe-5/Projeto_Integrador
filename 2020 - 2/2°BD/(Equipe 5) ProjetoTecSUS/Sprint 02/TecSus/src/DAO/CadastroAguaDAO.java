package DAO;

import DigiCont.CadastroAgua;
import java.sql.*;
import java.sql.PreparedStatement;
	
	public class CadastroAguaDAO {
		
		    private Connection connection;
		    String contaAguaConsumoM;
		    String contaAguaValorTotal;	    
		    String contaAguaMesConta;
		    String contaAguaValorAgua;
		    String contaAguaValorEsgoto;

		    
		    public CadastroAguaDAO(){ 
		    	
		        this.connection = new Conexao().getConnection();
		        
		    } 
		    
		    
		    public void adiciona(CadastroAgua cadaguadao){ 
		        String sql = "INSERT INTO contaagua(contaAguaConsumoM,contaAguaValorTotal,contaAguaMesConta,contaAguaValorAgua,contaAguaValorEsgoto) VALUES(?,?,?,?,?)";
		        try { 
		            PreparedStatement stmt = connection.prepareStatement(sql);
		            stmt.setString(1, cadaguadao.getConsumo());
		            stmt.setString(2, cadaguadao.getValorTotal());
		            stmt.setString(3, cadaguadao.getMesConta());
		            stmt.setString(4, cadaguadao.getValorAgua());
		            stmt.setString(5, cadaguadao.getValorEsgoto());

		            stmt.execute();
		            stmt.close();
		        } 
		        catch (SQLException u) { 
		            throw new RuntimeException(u);
		        } 

		        
		    } 
		    
		}