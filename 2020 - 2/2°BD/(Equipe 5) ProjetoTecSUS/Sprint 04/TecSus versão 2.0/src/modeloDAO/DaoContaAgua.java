package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.ModeloContaAgua;

import javax.swing.JOptionPane;
import modeloConnection.ConexaoBD;

public class DaoContaAgua {

	ConexaoBD conex = new ConexaoBD();
	ModeloContaAgua mod = new ModeloContaAgua();

	public void salvar(ModeloContaAgua mod) {

		conex.conexao();
		try {
			PreparedStatement pst = conex.con.prepareStatement("insert into contaagua(ContaAguaRGI, ContaAguaNConta, ContaAguaGrupo, ContaAguaMesRef, ContaAguaTipoLigacao, ContaAguaTipoFaturamento, ContaAguaConsumo, ContaAguaDataLeituraAtual, ContaAguaLeituraAtual, ContaAguaDataLeituraAnterior,  ContaAguaLeituraAnterior, ContaAguaObservacao, ContaAguaValorAgua, ContaAguaValorEsgoto, ContaAguaValorTotal) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, mod.getContaAguaRGI());
			pst.setInt(2, mod.getContaAguaNConta());
			pst.setInt(3, mod.getContaAguaGrupo());
			pst.setString(4, mod.getContaAguaMesRef());
			pst.setString(5, mod.getContaAguaTipoLigacao());
			pst.setString(6, mod.getContaAguaTipoFaturamento());
			pst.setInt(7, mod.getContaAguaConsumo());
			pst.setString(8, mod.getContaAguaDataLeituraAtual());
			pst.setString(9, mod.getContaAguaLeituraAtual());
			pst.setString(10, mod.getContaAguaDataLeituraAnterior());
			pst.setString(11, mod.getContaAguaLeituraAnterior());
			pst.setString(12, mod.getContaAguaObservacao());
			pst.setString(13, mod.getContaAguaValorAgua());
			pst.setString(14, mod.getContaAguaValorEsgoto());
			pst.setString(15, mod.getContaAguaValorTotal());

			pst.execute();
			JOptionPane.showMessageDialog(null, "Dados registrados com sucesso! ");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir os dados! \n " + e);

		}

	}

	public void Editar(ModeloContaAgua mod) {
		conex.conexao();
		try {
			PreparedStatement pst = conex.con.prepareStatement("update contaagua set ContaAguaNConta=?,ContaAguaGrupo=?,ContaAguaMesRef=?,ContaAguaTipoLigacao=?,ContaAguaTipoFaturamento=?,ContaAguaConsumo=?,ContaAguaDataLeituraAtual=?,ContaAguaLeituraAtual=?,ContaAguaDataLeituraAnterior=?, ContaAguaLeituraAnterior=?,ContaAguaObservacao=?,ContaAguaValorAgua=?,ContaAguaValorEsgoto=?,ContaAguaValorTotal=? where ContaAguaRGI=?");
			pst.setInt(1, mod.getContaAguaNConta());
			pst.setInt(2, mod.getContaAguaGrupo());
			pst.setString(3, mod.getContaAguaMesRef());
			pst.setString(4, mod.getContaAguaTipoLigacao());
			pst.setString(5, mod.getContaAguaTipoFaturamento());
			pst.setInt(6, mod.getContaAguaConsumo());
			pst.setString(7, mod.getContaAguaDataLeituraAtual());
			pst.setString(8, mod.getContaAguaLeituraAtual());
			pst.setString(9, mod.getContaAguaDataLeituraAnterior());
			pst.setString(10, mod.getContaAguaLeituraAnterior());
			pst.setString(11, mod.getContaAguaObservacao());
			pst.setString(12, mod.getContaAguaValorAgua());
			pst.setString(13, mod.getContaAguaValorEsgoto());
			pst.setString(14, mod.getContaAguaValorTotal());
			pst.setInt(15, mod.getContaAguaRGI());
			pst.execute();

			JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso! ");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados! \n " + e);

		}

		conex.desconecta();

	}

	public ModeloContaAgua buscaContaAgua(ModeloContaAgua mod) {
		conex.conexao();
		conex.executaSql("select *from contaagua where ContaAguaRGI like'%" + mod.getPesquisa() + "%'");
		try {
			conex.rs.first();
			mod.setContaAguaRGI(conex.rs.getInt("ContaAguaRGI"));
			mod.setContaAguaNConta(conex.rs.getInt("ContaAguaNConta"));
			mod.setContaAguaGrupo(conex.rs.getInt("ContaAguaGrupo"));
			mod.setContaAguaMesRef(conex.rs.getString("ContaAguaMesRef"));
			mod.setContaAguaTipoLigacao(conex.rs.getString("ContaAguaTipoLigacao"));
			mod.setContaAguaTipoFaturamento(conex.rs.getString("ContaAguaTipoFaturamento"));
			mod.setContaAguaConsumo(conex.rs.getInt("ContaAguaConsumo"));
			mod.setContaAguaDataLeituraAtual(conex.rs.getString("ContaAguaDataLeituraAtual"));
			mod.setContaAguaLeituraAtual(conex.rs.getString("ContaAguaLeituraAtual"));
			mod.setContaAguaDataLeituraAnterior(conex.rs.getString("ContaAguaDataLeituraAnterior"));
			mod.setContaAguaLeituraAnterior(conex.rs.getString("ContaAguaLeituraAnterior"));
			mod.setContaAguaObservacao(conex.rs.getString("ContaAguaObservacao"));
			mod.setContaAguaValorAgua(conex.rs.getString("ContaAguaValorAgua"));
			mod.setContaAguaValorEsgoto(conex.rs.getString("ContaAguaValorEsgoto"));
			mod.setContaAguaValorTotal(conex.rs.getString("ContaAguaValorTotal"));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar cliente! \n " + e);

		}

		conex.desconecta();
		return mod;

	}
}
