package application.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.models.DadosListaConta;

public class DadosListaContaSQL extends ConnectionBase {
	
	public ArrayList<DadosListaConta> all(int codigoIdentificacao) {

		ArrayList<DadosListaConta> resultado = new ArrayList<>();

		open();

		try {
			String sql = "";
			sql += " SELECT cl.nome_cli, co.datavenc_conta, co.valortotal_conta, co.id_conta, co.cod_identif_conta ";
			sql += " FROM cliente cl ";
			sql += " JOIN conta co ON co.id_cliente_conta = cl.id_cli ";
			sql += " AND cod_identif_conta = " + codigoIdentificacao;
			sql += " ORDER BY datavenc_conta ASC;";
			
			PreparedStatement stm = conexao.prepareStatement(sql);

			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				DadosListaConta dadosListaAgua = new DadosListaConta(rs.getString(1), rs.getDate(2), rs.getFloat(3), rs.getInt(4));
				resultado.add(dadosListaAgua);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return resultado;
	}

//---------------------------DAO----------------------------------------

	private static DadosListaContaSQL dao = new DadosListaContaSQL();

	public void save() {

	}

}
