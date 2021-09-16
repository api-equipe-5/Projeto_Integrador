package modeloConnection;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConexaoBD {

	private String driver = "DriverManager.getConnection";
	private String caminho = "jdbc:mysql://localhost:3306/projetointegrador?&Timezone=true&serverTimezone=UTC";
	private String usuario = "root";
	private String senha = "Amor041612#";

	public Connection con;
	public Statement stm;
	public ResultSet rs;

	public void conexao() {
		try {
			System.setProperty("jdbc.Drivers", driver);
			con = DriverManager.getConnection(caminho, usuario, senha);
			//JOptionPane.showMessageDialog(null, "Conexão Efetuada");

		} catch

		(SQLException e) {
			JOptionPane.showMessageDialog(null, "Conexão com Erro \n" + e);

		}
	}
	
	public void executaSql(String sql) {
		try {
			stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ExecutaSQL: \n " + e.getMessage());

		}

	}

	public void desconecta() {

		try {
			con.close();
			//JOptionPane.showMessageDialog(null, "Desconectado");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e);

		}
	}

	
}
