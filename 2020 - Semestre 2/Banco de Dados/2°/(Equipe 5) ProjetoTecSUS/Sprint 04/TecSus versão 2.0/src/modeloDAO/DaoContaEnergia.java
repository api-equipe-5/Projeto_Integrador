package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.ModeloContaEnergia;
import modeloConnection.ConexaoBD;

public class DaoContaEnergia {

	ConexaoBD conex = new ConexaoBD();
	ModeloContaEnergia mod = new ModeloContaEnergia();

	public void salvar(ModeloContaEnergia mod) {

		conex.conexao();
		try {
			PreparedStatement pst = conex.con.prepareStatement(
					"insert into contaluz(ContaLuzID, ContaLuzValorTotal, ContaLuzDataVencimento, ContaLuzMes, ContaLuzEmissao, ContaLuzAnterior, ContaLuzAtual, ContaLuzDiasFaturamento, ContaLuzStatus, ContaLuzPrevisaoProximaLuz, ContaLuzValorFornecedor, ContaLuzDataFaturamento, ContaLuzQtdkWh, ContaLuzAviso, ContaLuzFiscalMulta, ContaLuzFiscalJurosMulta, ContaLuzFiscalTipoFornecimento, ContaLuzFiscalModalidadeTarifaria) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, mod.getContaLuzID());
			pst.setString(2, mod.getContaLuzValorTotal());
			pst.setString(3, mod.getContaLuzDataVencimento());
			pst.setString(4, mod.getContaLuzMes());
			pst.setString(5, mod.getContaLuzEmissao());
			pst.setString(6, mod.getContaLuzAnterior());
			pst.setString(7, mod.getContaLuzAtual());
			pst.setInt(8, mod.getContaLuzDiasFaturamento());
			pst.setString(9, mod.getContaLuzStatus());
			pst.setString(10, mod.getContaLuzPrevisaoProximaLuz());
			pst.setString(11, mod.getContaLuzValorFornecedor());
			pst.setString(12, mod.getContaLuzDataFaturamento());
			pst.setString(13, mod.getContaLuzQtdkWh());
			pst.setString(14, mod.getContaLuzAviso());
			pst.setString(15, mod.getContaLuzFiscalMulta());
			pst.setString(16, mod.getContaLuzFiscalJurosMulta());
			pst.setString(17, mod.getContaLuzFiscalTipoFornecimento());
			pst.setString(18, mod.getContaLuzFiscalModalidadeTarifaria());

			pst.execute();
			JOptionPane.showMessageDialog(null, "Dados registrados com sucesso! ");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir os dados! \n " + e);

		}
	}

	public void Editar(ModeloContaEnergia mod) {
		conex.conexao();
		try {
			PreparedStatement pst = conex.con.prepareStatement(
					"update contaluz set ContaLuzValorTotal=?, ContaLuzDataVencimento=?, ContaLuzMes=?, ContaLuzEmissao=?, ContaLuzAnterior=?, ContaLuzAtual=?, ContaLuzDiasFaturamento=?, ContaLuzStatus=?, ContaLuzPrevisaoProximaLuz=?, ContaLuzValorFornecedor=?, ContaLuzDataFaturamento=?, ContaLuzQtdkWh=?, ContaLuzAviso=?, ContaLuzFiscalMulta=?, ContaLuzFiscalJurosMulta=?, ContaLuzFiscalTipoFornecimento=?, ContaLuzFiscalModalidadeTarifaria=? where ContaLuzID=?");
			pst.setString(1, mod.getContaLuzValorTotal());
			pst.setString(2, mod.getContaLuzDataVencimento());
			pst.setString(3, mod.getContaLuzMes());
			pst.setString(4, mod.getContaLuzEmissao());
			pst.setString(5, mod.getContaLuzAnterior());
			pst.setString(6, mod.getContaLuzAtual());
			pst.setInt(7, mod.getContaLuzDiasFaturamento());
			pst.setString(8, mod.getContaLuzStatus());
			pst.setString(9, mod.getContaLuzPrevisaoProximaLuz());
			pst.setString(10, mod.getContaLuzValorFornecedor());
			pst.setString(11, mod.getContaLuzDataFaturamento());
			pst.setString(12, mod.getContaLuzQtdkWh());
			pst.setString(13, mod.getContaLuzAviso());
			pst.setString(14, mod.getContaLuzFiscalMulta());
			pst.setString(15, mod.getContaLuzFiscalJurosMulta());
			pst.setString(16, mod.getContaLuzFiscalTipoFornecimento());
			pst.setString(17, mod.getContaLuzFiscalModalidadeTarifaria());
			pst.setInt(18, mod.getContaLuzID());

			pst.execute();

			JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso! ");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados! \n " + e);

		}

		conex.desconecta();

	}

	public ModeloContaEnergia buscaContaEnergia(ModeloContaEnergia mod) {
		conex.conexao();
		conex.executaSql("select *from contaluz where ContaLuzID like'%" + mod.getPesquisa() + "%'");
		try {
			conex.rs.first();
			mod.setContaLuzID(conex.rs.getInt("ContaLuzID"));
			mod.setContaLuzValorTotal(conex.rs.getString("ContaLuzValorTotal"));
			mod.setContaLuzDataVencimento(conex.rs.getString("ContaLuzDataVencimento"));
			mod.setContaLuzMes(conex.rs.getString("ContaLuzMes"));
			mod.setContaLuzEmissao(conex.rs.getString("ContaLuzEmissao"));
			mod.setContaLuzAnterior(conex.rs.getString("ContaLuzAnterior"));
			mod.setContaLuzAtual(conex.rs.getString("ContaLuzAtual"));
			mod.setContaLuzDiasFaturamento(conex.rs.getInt("ContaLuzDiasFaturamento"));
			mod.setContaLuzStatus(conex.rs.getString("ContaLuzStatus"));
			mod.setContaLuzPrevisaoProximaLuz(conex.rs.getString("ContaLuzPrevisaoProximaLuz"));
			mod.setContaLuzValorFornecedor(conex.rs.getString("ContaLuzValorFornecedor"));
			mod.setContaLuzDataFaturamento(conex.rs.getString("ContaLuzDataFaturamento"));
			mod.setContaLuzQtdkWh(conex.rs.getString("ContaLuzQtdkWh"));
			mod.setContaLuzAviso(conex.rs.getString("ContaLuzAviso"));
			mod.setContaLuzFiscalMulta(conex.rs.getString("ContaLuzFiscalMulta"));
			mod.setContaLuzFiscalMulta(conex.rs.getString("ContaLuzFiscalJurosMulta"));
			mod.setContaLuzFiscalTipoFornecimento(conex.rs.getString("ContaLuzFiscalTipoFornecimento"));
			mod.setContaLuzFiscalModalidadeTarifaria(conex.rs.getString("ContaLuzFiscalModalidadeTarifaria"));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar cliente! \n " + e);

		}

		conex.desconecta();
		return mod;

	}
}
