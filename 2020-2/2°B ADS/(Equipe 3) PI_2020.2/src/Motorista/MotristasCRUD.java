package br.com.cliente.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cliente.bean.Motoristas;
import br.com.cliente.util.Conectar;
import br.com.cliente.util.Dao;

public class MotoristaDAO implements Dao {

    public void insert(Object arg0) {
        Motoristas m = (Motoristas) arg0;
        String sql = "insert into motoristas (nome,endereco,municipio,estado,cep,tel,cpf,email,genero) values(?,?,?,?,?,?,?,?,?)";
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

                ps.execute();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
    }

    public void delete(Object arg0) {
        Motoristas m = (Motoristas) arg0;
        String sql = "delete from motoristas where id=?";
        try {
            PreparedStatement ps = Conectar.getConexao().prepareStatement(sql);
            ps.setInt(1, m.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Object arg0) {
           Motoristas m = (Motoristas) arg0;
           String sql = "update motoristas set nome=?,endereco=?,municipio=?,estado=?,cep=?,tel=?,cpf=?,email=?,genero=? where id=?";
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
        Motoristas m = new Motoristas();
        String sql = "Select * from motoristas where id=?";
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
        String sql = "select * from motoristas";
        PreparedStatement ps;
        try {
            ps = Conectar.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Motoristas m = new Motoristas();
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
