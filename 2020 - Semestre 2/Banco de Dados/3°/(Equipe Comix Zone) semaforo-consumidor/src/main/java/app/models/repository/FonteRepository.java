package app.models.repository;

import app.models.entities.Fonte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static app.Main.*;
import static java.sql.DriverManager.getConnection;

public class FonteRepository {

    public Fonte selectFontePorId(Integer id) throws SQLException {
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD)) {
            ResultSet resultSet;
            final String selectString = "SELECT * FROM FONTE WHERE FON_ID = ?";

            Fonte fonte = null;
            try (PreparedStatement selectStatement = con.prepareStatement(selectString)) {
                selectStatement.setInt(1, id);
                resultSet = selectStatement.executeQuery();
                if(resultSet.next()) {
                    fonte = new Fonte(
                            resultSet.getInt(1),
                            resultSet.getString(2)
                    );
                }
            }

            return fonte;
        }
    }

    public List<Fonte> selectTodasFontes() throws SQLException {
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD)) {
            ResultSet resultSet;
            final String selectString = "SELECT * FROM FONTE";
            final List<Fonte> fontes = new ArrayList<>();
            try (PreparedStatement selectStatement = con.prepareStatement(selectString)) {
                resultSet = selectStatement.executeQuery();
                while(resultSet.next()) {
                    fontes.add(new Fonte(
                            resultSet.getInt(1),
                            resultSet.getString(2)
                    ));
                }
            }
            return fontes;
        }
    }
}
