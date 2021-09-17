package application.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.models.ContaLuz;

public class ContaLuzSQL extends ConnectionBase {

	public ContaLuzSQL() {
		open();

		try {
			PreparedStatement stm = conexao.prepareStatement("CREATE TABLE IF NOT EXISTS conta_luz ("
					+ "primary key(id_contaluz)" + "id_contaluz int not null auto_increment,"
					+ "id_cliente_contaluz int not null," + "references cliente(id_cli),"
					+ "cod_identif_contaluz int not null," + "grupo_subgrupo_contaluz char(10) not null,"
					+ "tpfornecimento_contaluz char(15) not null," + "modtarifaria_contluz char(15) not null,"
					+ "rotleitura_contluz char(20) not null," + "codfiscal_contaluz char(10) not null,"
					+ "classe_subclasse_contaluz char(20) not null," + "tensaonominal_contaluz char(15) not null,"
					+ "medidor_contaluz int not null," + "id_clienteconsumo_contaluz int not null,"
					+ "references cliente(id_cli)," + "valortotal_contaluz float not null,"
					+ "numeroinstalacao_contaluz int not null," + "consumo_contluz int not null,"
					+ "datavenc_contaluz date not null," + "contames_contaluz char(20),"
					+ "bandtarifarias varchar(300) not null," + "emissao_contaluz date not null,"
					+ "leituraanterior_contaluz date not null," + "leituraatual_contaluz date not null,"
					+ "prevproxleit_contaluz date not null," + "diasfatura_contaluz int not null,"
					+ "leit_ant_contaluz float not null," + "leit_atual_contaluz float not null,"
					+ "const_mult_contaluz float not null," + ")");

			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void create(ContaLuz luz) {

		open();

		try {
			PreparedStatement stm = conexao.prepareStatement(
					"INSERT INTO conta (id_conta,id_cliente_conta,cod_identificacao_luz, grupo_subgrupo_conta,tpfornecimento_conta,"
					+ "modtarifaria_conta,rotleitura_conta, codfiscal_conta, classe_subclasse_conta, tensaonominal_conta, medidor_conta, "
					+ "id_clienteconsumo_conta, valortotal_conta, cod_identif_conta, consumo_conta, datavenc_conta, contames_conta, "
					+ "bandtarifarias, emissao_conta, leituraanterior_conta, leituraatual_conta, prevproxleit_conta, diasfatura_conta, "
					+ "leit_ant_conta, leit_atual_conta, const_mult_conta)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

			stm.setInt(1, luz.getId_contaluz());
			stm.setInt(2, luz.getId_cliente_contaluz());
			stm.setInt(3, luz.getCod_identif_contaluz());
			stm.setString(4, luz.getGrupo_subgrupo_contaluz());
			stm.setString(5, luz.getTpfornecimento_contaluz());
			stm.setString(6, luz.getModtarifaria_contluz());
			stm.setString(7, luz.getRotleitura_contluz());
			stm.setString(8, luz.getCodfiscal_contaluz());
			stm.setString(9, luz.getClasse_subclasse_contaluz());
			stm.setString(10, luz.getTensaonominal_contaluz());
			stm.setInt(11, luz.getMedidor_contaluz());
			stm.setInt(12, luz.getId_clienteconsumo_contaluz());

			stm.setFloat(13, luz.getValortotal_contaluz());
			stm.setInt(14, luz.getNumeroinstalacao_contaluz());
			stm.setInt(15, luz.getConsumo_contluz());
			stm.setDate(16, (java.sql.Date) luz.getDatavenc_contaluz());
			stm.setString(17, luz.getContames_contaluz());
			stm.setString(18, luz.getBandtarifarias());
			stm.setDate(19, (java.sql.Date) luz.getEmissao_contaluz());
			stm.setDate(20, (java.sql.Date) luz.getLeituraanterior_contaluz());
			stm.setDate(21, (java.sql.Date) luz.getLeituraatual_contaluz());
			stm.setDate(22, (java.sql.Date) luz.getPrevproxleit_contaluz());
			stm.setInt(23, luz.getDiasfatura_contaluz());
			
			stm.setFloat(24, luz.getLeit_ant_contaluz());
			stm.setFloat(25, luz.getLeit_atual_contaluz());
			stm.setFloat(26, luz.getConst_mult_contaluz());

			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public List<ContaLuz> all() {

		ArrayList<ContaLuz> resultado = new ArrayList<>();

		open();

		try {
			PreparedStatement stm = conexao.prepareStatement("SELECT * FROM conta_luz  ORDER BY id ASC");

			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				ContaLuz contaLuz = new ContaLuz(rs.getInt(1), // id_contaluz
						rs.getInt(2), // id_cliente_contaluz
						rs.getInt(3), // cod_identif_contaluz
						rs.getString(4), // grupo_subgrupo_contaluz
						rs.getString(5), // tpfornecimento_contaluz
						rs.getString(6), // modtarifaria_contluz
						rs.getString(7), // rotleitura_contluz
						rs.getString(8), // codfiscal_contaluz
						rs.getString(9), // classe_subclasse_contaluz
						rs.getString(10), // tensaonominal_contaluz
						rs.getInt(11), // medidor_contaluz
						rs.getInt(12), // id_clienteconsumo_contaluz
						rs.getFloat(13), // valortotal_contaluz
						rs.getInt(14), // numeroinstalacao_contaluz
						rs.getInt(15), // consumo_contluz
						rs.getDate(16), // datavenc_contaluz
						rs.getString(17), // contames_contaluz
						rs.getString(18), // bandtarifarias
						rs.getDate(19), // emissao_contaluz
						rs.getDate(20), // leituraanterior_contaluz
						rs.getDate(21), // leituraatual_contaluz
						rs.getDate(22), // prevproxleit_contaluz
						rs.getInt(23), // diasfatura_contaluz
						rs.getString(24), // avisos_contaluz
						rs.getFloat(25), // leit_ant_contaluz
						rs.getFloat(26), // leit_atual_contaluz
						rs.getFloat(27) // const_mult_contaluz
				);
				resultado.add(contaLuz);
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