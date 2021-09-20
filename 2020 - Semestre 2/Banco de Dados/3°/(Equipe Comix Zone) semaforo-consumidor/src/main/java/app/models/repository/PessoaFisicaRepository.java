package app.models.repository;

import app.models.entities.PessoaFisica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static app.Main.*;
import static java.sql.DriverManager.getConnection;

public class PessoaFisicaRepository {

    public PessoaFisica selectPessoaFisicaPorCPF(String cpf) throws SQLException {
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD)) {
            ResultSet resultSet;
            final String selectString = "SELECT * FROM PESSOA_FISICA WHERE PF_DOC_CLI = ?";

            PessoaFisica pessoaFisica = null;
            try (PreparedStatement selectStatement = con.prepareStatement(selectString)) {
                selectStatement.setString(1, cpf);
                resultSet = selectStatement.executeQuery();
                if(resultSet.next()) {
                   pessoaFisica = new PessoaFisica(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                    );
                }
            }

            return pessoaFisica;
        }
    }
}
