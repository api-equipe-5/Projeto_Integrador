package DAO;

import DigiCont.CadastroAgua;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import com.mysql.cj.protocol.Resultset;
	
	public class CadastroAguaDAO {
		
		    private Connection connection;
		    public String contaAguaConsumoM;
		    public String contaAguaValorTotal;	    
		    public String contaAguaMesConta;
		    public String contaAguaValorAgua;
		    public String contaAguaValorEsgoto;

		    
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
		    
		    public void modifica(CadastroAgua cadaguadao){ 
		        String sql = "SELECT * INTO contaagua(contaAguaConsumoM,contaAguaValorTotal,contaAguaMesConta,contaAguaValorAgua,contaAguaValorEsgoto) VALUES(?,?,?,?,?)"; 
	
		    
		    }
		    
		    public void update(CadastroAgua cadaguadao) {

		    	this.connection = new Conexao().getConnection();
		        
		    	 String sql = "UPDATE contagua SET contaAguaConsumoM = ? ,contaAguaValorTotal = ?,contaAguaMesConta = ?, contaAguaValorAgua = ?, contaAguaValorEsgoto = ?)";
		        try {
			    	PreparedStatement stmt = connection.prepareStatement(sql);
		            stmt.setString(1, cadaguadao.getConsumo());
		            stmt.setString(2, cadaguadao.getValorTotal());
		            stmt.setString(3, cadaguadao.getMesConta());
		            stmt.setString(4, cadaguadao.getValorAgua());
		            stmt.setString(5, cadaguadao.getValorEsgoto());

		            stmt.executeUpdate();
		            stmt.close();
		        } 
		        catch (SQLException u) { 
		            throw new RuntimeException(u);
		        }    
		    }

		    
	}
		    