package app.models.repository;

import app.models.entities.Movimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static app.Main.*;
import static java.sql.DriverManager.getConnection;

public class MovimentoRepository {

    public List<Movimento> selectMovimentosPorCpfENumeroContrato(String cpf, Long contrato) throws SQLException {
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD)) {
            ResultSet resultSet;
            final String selectString = "SELECT * FROM MOVIMENTOS WHERE MOV_DOC_CLI = ? AND MOV_NUM_UNC = ?";

            List<Movimento> movimentos = new ArrayList<>();
            try (PreparedStatement selectStatement = con.prepareStatement(selectString)) {
                selectStatement.setString(1, cpf);
                selectStatement.setLong(2, contrato);
                resultSet = selectStatement.executeQuery();
                while(resultSet.next()) {
                    movimentos.add(new Movimento(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getLong(4),
                            resultSet.getDate(5),
                            resultSet.getInt(6),
                            resultSet.getInt(7),
                            resultSet.getBigDecimal(8),
                            resultSet.getBigDecimal(9),
                            resultSet.getBigDecimal(10),
                            resultSet.getString(11),
                            resultSet.getString(12)
                    ));
                }
            }

            return movimentos;
        }
    }
}
