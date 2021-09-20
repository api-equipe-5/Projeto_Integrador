package modeloDAO;

import modelo.ModeloCliente;
import modeloConnection.ConexaoBD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DaoCliente {

	ConexaoBD conex = new ConexaoBD();
	ModeloCliente mode = new ModeloCliente();

	public void salvar(ModeloCliente mod) {

		conex.conexao();
		try {
			PreparedStatement pst = conex.con.prepareStatement("insert into cliente(cliente_hidrometro, cliente_nome, cliente_cnpj) values(?,?,?)");
			pst.setInt(1, mod.getHidrometro());
			pst.setString(2, mod.getNome());
			pst.setInt(3, mod.getCnpj());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Dados registrados com sucesso! ");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir os dados! \n " + e);

		}

	}

	public ModeloCliente buscaCliente(ModeloCliente mode) {
		conex.conexao();
		conex.executaSql("select *from cliente where cliente_nome like'%"+mode.getPesquisa()+"%'");
		try {
			conex.rs.first();
			mode.setHidrometro(conex.rs.getInt("cliente_hidrometro"));
			mode.setNome(conex.rs.getString("cliente_nome"));
			mode.setCnpj(conex.rs.getInt("cliente_cnpj"));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar cliente! \n " + e);

		}
		
		conex.desconecta();
		return mode;

	}

}
