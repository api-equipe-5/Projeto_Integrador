package dao;

import factory.ConnectionFactory;
import modelo.funcionario;
import java.sql.*;
import java.sql.PreparedStatement;

public class funcionarioDAO {
    
    private Connection connection;
    
    String id_func;
    String cpf_func;
    String rg_func;
    String id_filial;
    String num_func;
    String cep_func;
    String tel_func;
    String cel_func;
    String nome_func;
    String cargo_func;
    String endereco_func;
    String cidade_func;
    String estado_func;
    String email_func;
    String login_func;
    String senha_func;
    
        public funcionarioDAO(){
            this.connection = new ConnectionFactory().getConnection();
        }
        
        public void adiciona(funcionario funcionario){
            String sql = "insert into funcionario(nome_func, cpf_func, rg_func, id_filial, cargo_func, endereco_func, "
                    + "num_func, cep_func, cidade_func, estado_func, tel_func, cel_func, email_func,"
                    + "login_func, senha_func) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, funcionario.getNome_func());
                stmt.setString(2, funcionario.getCpf_func());
                stmt.setString(3, funcionario.getRg_func());
                stmt.setString(4, funcionario.getId_filial());             
                stmt.setString(5, funcionario.getCargo_func());                
                stmt.setString(6, funcionario.getEndereco_func());                
                stmt.setString(7, funcionario.getNum_func());                
                stmt.setString(8, funcionario.getCep_func());                
                stmt.setString(9, funcionario.getCidade_func());               
                stmt.setString(10, funcionario.getEstado_func());
                stmt.setString(11, funcionario.getTel_func());
                stmt.setString(12, funcionario.getCel_func());
                stmt.setString(13, funcionario.getEmail_func());
                stmt.setString(14, funcionario.getLogin_func());
                stmt.setString(15, funcionario.getSenha_func());
                
                stmt.execute();
                stmt.close();               
            }
            catch(SQLException u){
                throw new RuntimeException(u);                
            }
        }
    
}
