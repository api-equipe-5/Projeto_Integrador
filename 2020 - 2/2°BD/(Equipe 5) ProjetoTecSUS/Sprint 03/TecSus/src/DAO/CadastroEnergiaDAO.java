package DAO;


import DigiCont.CadastroEnegia;
import java.sql.*;

public class CadastroEnergiaDAO {
	
	 private Connection connection;
	 	public String ContaLuzID;
		public String ContaLuzValorTotal;
		public String ContaLuzDataVencimento; 
		public String ContaLuzMes;
		public String ContaLuzEmissao;
		public String ContaLuzAnterior; 
		public String ContaLuzAtual;
		public String ContaLuzDiasFaturamento;
		public String ContaLuzPrevisaoProximaLuz;
		public String ContaLuzAviso; 
	 
		public CadastroEnergiaDAO(){ 
	    	
	        this.connection = new Conexao().getConnection();
	        
	    } 
	 
	 public void adiciona(CadastroEnegia cadenergiadao){ 
	        String sql = "INSERT INTO contaluz(ContaLuzID, ContaLuzValorTotal, ContaLuzDataVencimento, ContaLuzMes, ContaLuzEmissao, ContaLuzAnterior, ContaLuzAtual, ContaLuzDiasFaturamento, ContaLuzPrevisaoProximaLuz, ContaLuzAviso) VALUES(?,?,?,?,?,?,?,?,?,?)";
	        try { 
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setString(1, cadenergiadao.getContaLuzID());
	            stmt.setString(2, cadenergiadao.getContaLuzValorTotal());
	            stmt.setString(3, cadenergiadao.getContaLuzDataVencimento());
	            stmt.setString(4, cadenergiadao.getContaLuzMes());
	            stmt.setString(5, cadenergiadao.getContaLuzEmissao());
	            stmt.setString(6, cadenergiadao.getContaLuzAnterior());
	            stmt.setString(7, cadenergiadao.getContaLuzAtual());
	            stmt.setString(8, cadenergiadao.getContaLuzDiasFaturamento());
	            stmt.setString(9, cadenergiadao.getContaLuzPrevisaoProximaLuz());
	            stmt.setString(10, cadenergiadao.getContaLuzAviso());


	            stmt.execute();
	            stmt.close();
	        } 
	        catch (SQLException u) { 
	            throw new RuntimeException(u);
	        } 

	        
	    } 
	    
	}