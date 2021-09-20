package app.models.repository;

import app.models.dtos.produto.PostProdutoDTO;
import app.models.entities.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static app.Main.*;
import static java.sql.DriverManager.getConnection;

public class ProdutoRepository {
    public List<Produto> selectDesejosPorCNPJ(String cnpj) throws SQLException {
        String selectString = "SELECT * FROM PRODUTOS WHERE UPJ_DOC_CLI = ?";
        ResultSet resultSet;
        List<Produto> produtos = new ArrayList<>();
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD);
             PreparedStatement selectStatement = con.prepareStatement(selectString)) {
            selectStatement.setString(1, cnpj);
            resultSet = selectStatement.executeQuery();
            while(resultSet.next()) {
                produtos.add(new Produto(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }
        }
        return produtos;
    }

    public List<Produto> selectDesejosPorCategoria(Integer idCategoria) throws SQLException {
        String selectString = "SELECT * FROM PRODUTOS WHERE CAT_ID = ?";
        ResultSet resultSet;
        List<Produto> produtos = new ArrayList<>();
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD);
             PreparedStatement selectStatement = con.prepareStatement(selectString)) {
            selectStatement.setInt(1, idCategoria);
            resultSet = selectStatement.executeQuery();
            while(resultSet.next()) {
                produtos.add(new Produto(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }
        }
        return produtos;
    }

    public void insertProduto(PostProdutoDTO postProdutoDTO) throws SQLException {
        String insertString = "INSERT INTO PRODUTOS (CAT_ID, UPJ_DOC_CLI, PRO_URL) VALUES(?,?,?)";
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD);
             PreparedStatement insertStatement = con.prepareStatement(insertString)) {
            insertStatement.setInt(1, postProdutoDTO.getIdCategoria());
            insertStatement.setString(2, postProdutoDTO.getCnpj());
            insertStatement.setString(3, postProdutoDTO.getUrl());
            insertStatement.executeUpdate();
        }
    }
}
