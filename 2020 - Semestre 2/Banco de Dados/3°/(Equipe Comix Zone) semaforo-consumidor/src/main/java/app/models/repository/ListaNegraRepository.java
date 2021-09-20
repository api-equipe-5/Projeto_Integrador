package app.models.repository;

import app.models.dtos.listanegra.ListaNegraDTO;
import app.models.entities.ListaNegra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static app.Main.*;
import static java.sql.DriverManager.getConnection;

public class ListaNegraRepository {

    public ListaNegra selectListaNegra(ListaNegraDTO lista) throws SQLException {
        String selectString = "SELECT * FROM LISTA_NEGRA WHERE LIS_BLOQUEADOR_DOC_CLI = ? AND LIS_BLOQUEADO_DOC_CLI = ?";
        ResultSet resultSet;
        ListaNegra selectListaNegra = null;
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD);
             PreparedStatement selectStatement = con.prepareStatement(selectString)) {
            selectStatement.setString(1, lista.getDocCliBloqueador());
            selectStatement.setString(2, lista.getDocCliBloqueado());
            resultSet = selectStatement.executeQuery();
            if(resultSet.next()) {
                selectListaNegra = new ListaNegra(
                        resultSet.getString(1),
                        resultSet.getString(2)
                );
            }
        }
        return selectListaNegra;
    }

    public void insertListaNegra(ListaNegraDTO novaLista) throws SQLException {
        String insertString = "INSERT INTO LISTA_NEGRA (LIS_BLOQUEADOR_DOC_CLI, LIS_BLOQUEADO_DOC_CLI) VALUES(?,?)";
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD);
             PreparedStatement insertStatement = con.prepareStatement(insertString)) {
            insertStatement.setString(1, novaLista.getDocCliBloqueador());
            insertStatement.setString(2, novaLista.getDocCliBloqueado());
            insertStatement.executeUpdate();
        }
    }

    public void deleteListaNegra(ListaNegra lista) throws SQLException {
        String deleteString = "DELETE FROM LISTA_NEGRA WHERE LIS_BLOQUEADOR_DOC_CLI = ? AND LIS_BLOQUEADO_DOC_CLI = ?";
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD);
             PreparedStatement updateStatement = con.prepareStatement(deleteString)) {
            updateStatement.setString(1, lista.getDocCliBloqueador());
            updateStatement.setString(2, lista.getDocCliBloqueado());
            updateStatement.executeUpdate();
        }
    }
}
