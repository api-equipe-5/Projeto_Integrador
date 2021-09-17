package application.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.models.Cliente;
import application.models.Usuario;

public class ClienteSQL extends ConnectionBase {
	
	public void create(Cliente cliente) {
	
		open();
		
		try {
			String sql = "INSERT INTO cliente ";
			sql += " (nome_cli, cpf_cnpj_cli, rua_cli, numero_cli, complemento_cli, bairro_cli, cidade_cli, estado_cli, cep_cli, telefone_cli) ";
			sql += "VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stm = conexao.prepareStatement(sql);
			
			stm.setString(1, cliente.getNome_cli());
			stm.setString(2, cliente.getCpf_cnpj_cli());
			stm.setString(3, cliente.getRua_cli());
			stm.setInt(4, cliente.getNumero_cli());
			stm.setString(5, cliente.getComplemento_cli());
			stm.setString(6, cliente.getBairro_cli());
			stm.setString(7, cliente.getCidade_cli());
			stm.setString(8, cliente.getEstado_cli());
			stm.setString(9, cliente.getCep_cli());
			stm.setString(10, cliente.getTelefone_cli());
			
			stm.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			close();
		}
	}
	
	
	public Cliente buscarClientePorId(int idCliente) {
		open();
		Cliente cliente = new Cliente();
		
		try {
			PreparedStatement stm = conexao.prepareStatement("SELECT id_cli, nome_cli FROM Cliente WHERE id_cli='" + idCliente + "'");
			ResultSet rs = stm.executeQuery();

			if (rs != null && rs.next()) {
				cliente.setId_cli(rs.getInt(1));
				cliente.setNome_cli(rs.getString(2));	
			}
			
		} catch(SQLException e) {
			System.out.println("Erro ao buscar cliente por Id");
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public Cliente buscarClientePeloNome(String nome) {

		open();

		ArrayList<Cliente> result = new ArrayList<>();

		try {
			PreparedStatement stm = conexao.prepareStatement("SELECT * FROM cliente WHERE nome_cli LIKE '" + nome + "%'");
//			stm.setString(0, nome);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {

				Cliente cliente = new Cliente(rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getInt(5),
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getString(9), 
						rs.getString(10), 
						rs.getString(11)
				);
				result.add(cliente);
			}
		} catch (SQLException e) {
			System.out.println("Exception método all");
			e.printStackTrace();
		} finally {
			close();
		}
		return result.get(0);
	}
		

}
	