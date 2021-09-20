package br.com.fatec.banco;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.postgresql.core.v3.ConnectionFactoryImpl;

import br.com.fatec.utils.Utils;

public class Conexao extends ConnectionFactoryImpl{
	
    private Connection con = null;
    
    private ResultSet rs = null;

    private final String ENDERECO = "jdbc:postgresql://localhost:5432/";
    
    private final String USUARIO = "postgres";
    
    private final String SENHA = "root"; 
    
    private final String DRIVER = "org.postgresql.Driver";
    
    private final String DATABASE = "CAR";

    public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
        
    public Boolean Conectar() {

        try {
        	
            Class.forName(DRIVER);
            
            con = DriverManager.getConnection(ENDERECO + DATABASE, USUARIO, SENHA);
            
            return true;
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar o driver");
            Utils.escreverLog("Erro no driver do banco de dados " + cnfe.getMessage());
            return false;
 
        } catch (SQLException sqlex) {
        	
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados");
            Utils.escreverLog("Erro ao conectar no banco de dados " + sqlex.getMessage());
            return false;

        }
    }

    public void Desconectar() {
    	
        try {
        	if (!con.isClosed()) {
            con.close();
        	}
             
        } catch (SQLException onConClose) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar o banco");
            Utils.escreverLog("Erro ao desconectar bancos de dados " + onConClose.getMessage());
        }
    }
    
   
    
    public Boolean vericarTabelasBanco() {
    	
    	PreparedStatement pstmt;
    	DatabaseMetaData dbmd;
    	ResultSet rs;
    	String line = "";
    	Boolean existeEstado = false;
    	Boolean existeMunicipio = false;
    	Boolean existeAreaImovel = false;
    	Boolean existeArea = false;
    	Boolean existeTipo = false;
    	Boolean existeIntegracao = false;
    	
    	try {
    		
    		Conectar();
    		
    		dbmd = con.getMetaData();
    		
    		rs = dbmd.getTables(null, null, "estado", null);
    		
    		if(rs.next()) {
    			existeEstado = true;
    		}
    		
    		rs = dbmd.getTables(null, null, "municipio", null);
    		
    		if(rs.next()) {
    			existeMunicipio = true;
    		}
    		
    		rs = dbmd.getTables(null, null, "area_imovel", null);
    		
    		if(rs.next()) {
    			existeAreaImovel = true;
    		}
    		
    		rs = dbmd.getTables(null, null, "area", null);
    		
    		if(rs.next()) {
    			existeArea = true;
    		}
    		
    		rs = dbmd.getTables(null, null, "tipo", null);
    		
    		if(rs.next()) {
    			existeTipo = true;
    		}
    		
    		
    		rs = dbmd.getTables(null, null, "integrecao", null);
    		
    		if(rs.next()) {
    			existeIntegracao = true;
    		}
    		
    		if (!existeEstado && !existeMunicipio && !existeAreaImovel && !existeArea && !existeTipo && !existeIntegracao) {
    			Scanner in = new Scanner(new FileReader(".\\sql\\tabelas.sql"));
    			while (in.hasNextLine()) {
    				line = line + in.nextLine();   
    			}
    		
    			pstmt = con.prepareStatement(line);
    		
    			pstmt.executeUpdate();
    			pstmt.close();
    			Utils.escreverLog("Tabelas criadas no banco de dados.");
    			
    		}
    		
    		
    		return true;
			
		} catch (IOException | SQLException e) {
			Utils.escreverLog("Erro ao criar tabelas no banco - " + e.getMessage());
			return false;
		}
    }
    
    public void testeInsert() {
        
    	PreparedStatement pstmt;
    	Conectar();
    	String line = "";
		Scanner in;
		try {
			in = new Scanner(new FileReader(".\\sql\\APP.sql"));
			while (in.hasNextLine()) {
				line = line + in.nextLine();   
			}
		
			pstmt = con.prepareStatement(line);
		
			pstmt.executeUpdate();
			pstmt.close();
		} catch (FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			Utils.escreverLog("Erro teste insert : " + e.getMessage());
		}
		
		
		
		Desconectar();
    }

}
