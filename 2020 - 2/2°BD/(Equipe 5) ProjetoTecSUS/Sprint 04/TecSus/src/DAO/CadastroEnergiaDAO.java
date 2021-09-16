package DAO;

import DigiCont.CadastroEnegia;

import java.awt.Container;
import java.sql.*;
import java.util.*;

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
	public String ContaLuzStatus;
	public String ContaLuzPrevisaoProximaLuz;
	public String ContaLuzValorFornecedor;
	public String ContaLuzDataFaturamento;
	public String ContaLuzQtdkWh;
	public String ContaLuzAviso;
	public String ContaLuzFiscalCFOP;
	public String ContaLuzFiscalGrupo;
	public String ContaLuzFiscalSubGrupo;
	public String ContaLuzFiscalClasse;
	public String ContaLuzFiscalSubClasse;
	public String ContaLuzFiscalMulta;
	public String ContaLuzFiscalJurosMulta;
	public String ContaLuzFiscalTipoFornecimento;
	public String ContaLuzFiscalModalidadeTarifaria;

	public CadastroEnergiaDAO() {

		this.connection = new Conexao().getConnection();

	}

	public void adiciona(CadastroEnegia cadenergiadao) {
		String sql = "INSERT INTO contaluz(ContaLuzID, ContaLuzValorTotal, ContaLuzDataVencimento, ContaLuzMes, ContaLuzEmissao, ContaLuzAnterior, ContaLuzAtual, ContaLuzDiasFaturamento, ContaLuzStatus, ContaLuzPrevisaoProximaLuz, ContaLuzValorFornecedor, ContaLuzDataFaturamento, ContaLuzQtdkWh, ContaLuzAviso, ContaLuzFiscalCFOP, ContaLuzFiscalGrupo, ContaLuzFiscalSubGrupo, ContaLuzFiscalClasse, ContaLuzFiscalSubClasse, ContaLuzFiscalMulta, ContaLuzFiscalJurosMulta, ContaLuzFiscalTipoFornecimento, ContaLuzFiscalModalidadeTarifaria) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			stmt.setString(9, cadenergiadao.getContaLuzStatus());
			stmt.setString(10, cadenergiadao.getContaLuzPrevisaoProximaLuz());
			stmt.setString(11, cadenergiadao.getContaLuzValorFornecedor());
			stmt.setString(12, cadenergiadao.getContaLuzDataFaturamento());
			stmt.setString(13, cadenergiadao.getContaLuzQtdkWh());
			stmt.setString(14, cadenergiadao.getContaLuzAviso());
			stmt.setString(15, cadenergiadao.getContaLuzFiscalCFOP());
			stmt.setString(16, cadenergiadao.getContaLuzFiscalGrupo());
			stmt.setString(17, cadenergiadao.getContaLuzFiscalSubGrupo());
			stmt.setString(18, cadenergiadao.getContaLuzFiscalClasse());
			stmt.setString(19, cadenergiadao.getContaLuzFiscalSubClasse());
			stmt.setString(20, cadenergiadao.getContaLuzFiscalMulta());
			stmt.setString(21, cadenergiadao.getContaLuzFiscalJurosMulta());
			stmt.setString(22, cadenergiadao.getContaLuzFiscalTipoFornecimento());
			stmt.setString(23, cadenergiadao.getContaLuzFiscalModalidadeTarifaria());

			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

		
	}

	
}

