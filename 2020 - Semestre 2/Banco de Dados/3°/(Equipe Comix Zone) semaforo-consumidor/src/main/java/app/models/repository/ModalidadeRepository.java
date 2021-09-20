package app.models.repository;

import app.models.entities.Modalidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static app.Main.*;
import static java.sql.DriverManager.getConnection;

public class ModalidadeRepository {

    public Modalidade selectFontePorId(String codigo) throws SQLException {
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD)) {
            ResultSet resultSet;
            final String selectString = "SELECT * FROM MODALIDADE WHERE MOD_COD = ?";

            Modalidade modalidade = null;
            try (PreparedStatement selectStatement = con.prepareStatement(selectString)) {
                selectStatement.setString(1, codigo);
                resultSet = selectStatement.executeQuery();
                if(resultSet.next()) {
                    modalidade = new Modalidade(
                            resultSet.getString(1),
                            resultSet.getString(2)
                    );
                }
            }

            return modalidade;
        }
    }

    public List<Modalidade> selectTodasModalidades() throws SQLException {
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD)) {
            ResultSet resultSet;
            final String selectString = "SELECT * FROM MODALIDADE";
            final List<Modalidade> modalidades = new ArrayList<>();

            try (PreparedStatement selectStatement = con.prepareStatement(selectString)) {
                resultSet = selectStatement.executeQuery();
                if(resultSet.next()) {
                    modalidades.add(new Modalidade(
                            resultSet.getString(1),
                            resultSet.getString(2)
                    ));
                }
            }

            return modalidades;
        }
    }
}
