package app.models.repository;

import app.models.entities.Operacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static app.Main.*;
import static java.sql.DriverManager.getConnection;

public class OperacaoRepository {

    public List<Operacao> selectOperacoesPorCpf(String cpf) throws SQLException {
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD)) {
            ResultSet resultSet;
            final String selectString = "SELECT * FROM OPERACOES WHERE OPE_DOC_CLI = ?";

            List<Operacao> operacoes = new ArrayList<>();
            try (PreparedStatement selectStatement = con.prepareStatement(selectString)) {
                selectStatement.setString(1, cpf);
                resultSet = selectStatement.executeQuery();
                while(resultSet.next()) {
                    operacoes.add(new Operacao(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getLong(3),
                            resultSet.getInt(4),
                            resultSet.getString(5),
                            resultSet.getInt(6),
                            resultSet.getDate(7),
                            resultSet.getDate(8),
                            resultSet.getDate(9),
                            resultSet.getBigDecimal(10),
                            resultSet.getBigDecimal(11),
                            resultSet.getBigDecimal(12)
                    ));
                }
            }

            return operacoes;
        }
    }
}
