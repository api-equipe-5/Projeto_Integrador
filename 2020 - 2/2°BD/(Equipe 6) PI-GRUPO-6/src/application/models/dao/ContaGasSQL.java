package application.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.models.ContaGas;

public class ContaGasSQL extends ConnectionBase {

	public void create(ContaGas gas) {
		open();
		
		try {
			PreparedStatement stm = conexao.prepareStatement(
					"INSERT INTO conta (id_conta,id_cliente_conta,cod_identif_conta,segmento_conta, diasconsumo_conta, tipomedidor_conta, numeromedidor_conta, consumocorrigido_conta,consumo_conta,leit_atual_conta,leit_ant_conta,leituraatual_conta,leituraanterior_conta,datavenc_conta,valortotal_conta)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

			stm.setInt(1, gas.getIdContaGas());
			stm.setInt(2, gas.getIdClienteConta());
			stm.setInt(3, gas.getCodUsuario());
			stm.setString(4, gas.getSegmento());
			stm.setString(5, gas.getDiasConsumo());
			stm.setString(6, gas.getTipoMedidor());
			stm.setString(7, gas.getNumeroMedidor());
			stm.setString(8, gas.getConsumoCorrigido());
			stm.setString(9, gas.getConsumo());
			stm.setFloat(10, gas.getValorLeituraAtual());
			stm.setFloat(11, gas.getValorLeituraAnterior());
			stm.setDate(12, (java.sql.Date) gas.getDataLeituraAtual());
			stm.setDate(13, (java.sql.Date) gas.getDataLeituraAnterior());
			stm.setDate(14, (java.sql.Date) gas.getDataVencimento());
			stm.setFloat(15, gas.getTotalPagar());

			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public List<ContaGas> all() {

		ArrayList<ContaGas> resultado = new ArrayList<>();

		open();

		try {
			PreparedStatement stm = conexao.prepareStatement("SELECT * FROM conta_gas  ORDER BY id ASC");

			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				ContaGas contaGas = new ContaGas(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getFloat(10), rs.getFloat(11), rs.getDate(12), rs.getDate(13), rs.getDate(14),
						rs.getFloat(15)

				);
				resultado.add(contaGas);
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
