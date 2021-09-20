package app.models.repository;

import app.models.entities.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static app.Main.*;
import static java.sql.DriverManager.getConnection;

public class CategoriaRepository {
    public List<Categoria> selectCategorias() throws SQLException {
        String selectString = "SELECT * FROM CATEGORIAS";
        ResultSet resultSet;
        List<Categoria> categorias = new ArrayList<>();
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD);
             PreparedStatement selectStatement = con.prepareStatement(selectString)) {
            resultSet = selectStatement.executeQuery();
            while(resultSet.next()) {
                categorias.add(new Categoria(resultSet.getInt(1), resultSet.getString(2)));
            }
        }
        return categorias;
    }
}
