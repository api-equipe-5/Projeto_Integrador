package DAO;

import DigiCont.CadastroAgua;
import DigiCont.CadastroCliente;

import java.lang.System.Logger;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

public class CadastroAguaDAO {

	private Connection connection;
	public String ContaAguaRGI;
	public String ContaAguaNConta;
	public String ContaAguaGrupo;
	public String ContaAguaMesRef;
	public String ContaAguaTipoLigacao;
	public String ContaAguaTipoFaturamento;
	public String ContaAguaConsumo;
	public String ContaAguaDataLeituraAtual;
	public String ContaAguaLeituraAtual;
	public String ContaAguaDataLeituraAnterior;
	public String ContaAguaLeituraAnterior;
	public String ContaAguaObservacao;
	public String ContaAguaValorAgua;
	public String ContaAguaValorEsgoto;
	public String ContaAguaValorTotal;

	public CadastroAguaDAO() {

		this.connection = new Conexao().getConnection();

	}

	public void adiciona(CadastroAgua cadaguadao) {
		String sql = "INSERT INTO contaagua(ContaAguaRGI, ContaAguaNConta, ContaAguaGrupo, ContaAguaMesRef, ContaAguaTipoLigacao, ContaAguaTipoFaturamento, ContaAguaConsumo, ContaAguaDataLeituraAtual, ContaAguaLeituraAtual, ContaAguaDataLeituraAnterior,  ContaAguaLeituraAnterior, ContaAguaObservacao, ContaAguaValorAgua, ContaAguaValorEsgoto, ContaAguaValorTotal  ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cadaguadao.getContaAguaRGI());
			stmt.setString(2, cadaguadao.getContaAguaNConta());
			stmt.setString(3, cadaguadao.getContaAguaGrupo());
			stmt.setString(4, cadaguadao.getContaAguaMesRef());
			stmt.setString(5, cadaguadao.getContaAguaTipoLigacao());
			stmt.setString(6, cadaguadao.getContaAguaTipoFaturamento());
			stmt.setString(7, cadaguadao.getContaAguaConsumo());
			stmt.setString(8, cadaguadao.getContaAguaDataLeituraAtual());
			stmt.setString(9, cadaguadao.getContaAguaLeituraAtual());
			stmt.setString(10, cadaguadao.getContaAguaDataLeituraAnterior());
			stmt.setString(11, cadaguadao.getContaAguaLeituraAnterior());
			stmt.setString(12, cadaguadao.getContaAguaObservacao());
			stmt.setString(13, cadaguadao.getContaAguaValorAgua());
			stmt.setString(14, cadaguadao.getContaAguaValorEsgoto());
			stmt.setString(15, cadaguadao.getContaAguaValorTotal());

			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

	}

	public List<CadastroAgua> getCadastroAgua(String ContaAguaRGI) {
		this.connection = new Conexao().getConnection();
		PreparedStatement stm = null;
		ResultSet rset = null;

		List<CadastroAgua> cadagua = new ArrayList<CadastroAgua>();

		
		try {
			
			stm = connection.prepareStatement("SELECT * FROM contaagua WHERE ContaAguaRGI LIKE ?");
			stm.setString(1, "%" + ContaAguaRGI + "%");

			rset = stm.executeQuery();

			while (rset.next()) {

				CadastroAgua contagua = new CadastroAgua();

				contagua.setContaAguaRGI(rset.getString("ContaAguaRGI"));
				contagua.setContaAguaNConta(rset.getString("ContaAguaNConta"));
				contagua.setContaAguaGrupo(rset.getString("ContaAguaGrupo"));
				contagua.setContaAguaMesRef(rset.getString("ContaAguaMesRef"));
				contagua.setContaAguaTipoLigacao(rset.getString("ContaAguaTipoLigacao"));
				contagua.setContaAguaTipoFaturamento(rset.getString("ContaAguaTipoFaturamento"));
				contagua.setContaAguaConsumo(rset.getString("ContaAguaConsumo"));
				contagua.setContaAguaDataLeituraAtual(rset.getString("ContaAguaDataLeituraAtual"));
				contagua.setContaAguaLeituraAtual(rset.getString("ContaAguaLeituraAtual"));
				contagua.setContaAguaDataLeituraAnterior(rset.getString("ContaAguaDataLeituraAnterior"));
				contagua.setContaAguaLeituraAnterior(rset.getString("ContaAguaLeituraAnterior"));
				contagua.setContaAguaObservacao(rset.getString("ContaAguaObservacao"));
				contagua.setContaAguaValorAgua(rset.getString("ContaAguaValorAgua"));
				contagua.setContaAguaValorEsgoto(rset.getString("ContaAguaValorEsgoto"));
				contagua.setContaAguaValorTotal(rset.getString("ContaAguaValorTotal"));
				cadagua.add(contagua);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		try {
			if (rset != null) {
				rset.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cadagua;
	}

}

