package br.com.cliente.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.cliente.bean.Motoristas;
import br.com.cliente.util.Conectar;
import br.com.cliente.util.Dao;

public class FuncionarioDAO implements Dao {

    public void insert(Object arg0) {
        Funcionario f = (Funcionario) arg0;
        String sql = "insert into funcionário (nome,endereco,municipio,estado,cep,tel,cpf,email,genero) values(?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = Conectar.getConexao().prepareStatement(sql);
                ps.setString(1, f.getNome());
                ps.setString(2, f.getEndereco());
                ps.setString(3, f.getMunicipio());
                ps.setString(4, f.getEstado());
                ps.setString(5, f.getCep());
                ps.setString(6, f.getTel());
                ps.setString(7, f.getCpf());
                ps.setString(8, f.getEmail());
                ps.setString(9, f.getGenero());

                ps.execute();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
    }

    public void delete(Object arg0) {
        Funcionario f = (Funcionario) arg0;
        String sql = "delete from funcinário where id=?";
        try {
            PreparedStatement ps = Conectar.getConexao().prepareStatement(sql);
            ps.setInt(1, m.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Object arg0) {
           Funcionario f = (Funcionario) arg0;
           String sql = "update funcionário set nome=?,endereco=?,municipio=?,estado=?,cep=?,tel=?,cpf=?,email=?,genero=? where id=?";
           try {
                PreparedStatement ps = Conectar.getConexao().prepareStatement(sql);
               ps.setString(1, m.getNome());
               ps.setString(2, m.getEndereco());
               ps.setString(3, m.getMunicipio());
               ps.setString(4, m.getEstado());
               ps.setString(5, m.getCep());
               ps.setString(6,m.getTel());
               ps.setString(7, m.getCpf());
               ps.setString(8, m.getEmail());
               ps.setString(9, m.getGenero());
               ps.setInt(10, m.getId());
                ps.execute();
            } catch (SQLException e) {
              e.printStackTrace();
             }
    }
    public Object select(int arg0) {
        Funcinario f = new Funcionario();
        String sql = "Select * from funcionário where id=?";
        try {
            PreparedStatement ps = Conectar.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m.setNome(rs.getString("Nome"));
                m.setEndereco(rs.getString("endereco"));
                m.setMunicipio(rs.getString("municipio"));
                m.setEstado(rs.getString("estado"));
                m.setEstado(rs.getString("cep"));
                m.setEstado(rs.getString("tel"));
                m.setEstado(rs.getString("cpf"));
                m.setEstado(rs.getString("email"));
                m.setEstado(rs.getString("genero"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }


    public List select() {
        List list = new ArrayList();
        String sql = "select * from funcionário";
        PreparedStatement ps;
        try {
            ps = Conectar.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Funcionario m = new Funcionario();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setEndereco(rs.getString("endereco"));
                m.setMunicipio(rs.getString("municipio"));
                m.setEstado(rs.getString("estado"));
                m.setCep(rs.getString("cep"));
                m.setTel(rs.getString("tel"));
                m.setCpf(rs.getString("cpf"));
                m.setEmail(rs.getString("email"));
                m.setGenero(rs.getString("genero"));

                list.add(m);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}
