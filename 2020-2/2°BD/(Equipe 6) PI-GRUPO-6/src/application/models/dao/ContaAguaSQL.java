package application.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.models.ContaAgua;

public class ContaAguaSQL extends ConnectionBase {

	public void create(ContaAgua agua) {
		open();
		
		try {
			PreparedStatement stm = conexao.prepareStatement(
					"INSERT INTO conta (id_conta,id_cliente_conta,cod_identif_conta,codigo_cliente_conta,tipoligacao_conta,hidrometro_conta,tipofaturamento_conta,periodoconsumo_conta,agua_conta,esgoto_conta,consumo_conta,leit_atual_conta,leit_ant_conta,leituraatual_conta,leituraanterior_conta,datavenc_conta,valortotal_conta)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

			stm.setInt(1, agua.getIdContaAgua());
			stm.setInt(2, agua.getIdClienteConta());
			stm.setInt(3, agua.getRgi());
			stm.setInt(4, agua.getCodigoCliente());
			stm.setString(5, agua.getTipoLigacao());
			stm.setString(6, agua.getHidrometro());
			stm.setString(7, agua.getTipoFaturamento());
			stm.setString(8, agua.getPeriodoConsumo());
			stm.setString(9, agua.getAgua());
			stm.setString(10, agua.getEsgoto());
			stm.setString(11, agua.getConsumo());
			stm.setFloat(12, agua.getValorLeituraAtual());
			stm.setFloat(13, agua.getValorLeituraAnterior());
			stm.setDate(14, (java.sql.Date) agua.getDataLeituraAtual());
			stm.setDate(15, (java.sql.Date) agua.getDataLeituraAnterior());
			stm.setDate(16, (java.sql.Date) agua.getDataVencimento());
			stm.setFloat(17, agua.getTotalPagar());

			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public List<ContaAgua> all() {

		ArrayList<ContaAgua> resultado = new ArrayList<>();

		open();

		try {
			PreparedStatement stm = conexao.prepareStatement("SELECT * FROM conta_agua ORDER BY id ASC");

			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				ContaAgua contaAgua = new ContaAgua(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getFloat(12), rs.getFloat(13), rs.getDate(14),
						rs.getDate(15), rs.getDate(16), rs.getFloat(17)

				);
				resultado.add(contaAgua);
			}

			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return resultado;
	}

}