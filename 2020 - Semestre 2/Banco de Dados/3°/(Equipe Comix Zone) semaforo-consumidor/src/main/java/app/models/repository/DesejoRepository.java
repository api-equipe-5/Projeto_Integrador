package app.models.repository;

import app.models.dtos.desejo.PostDesejoDTO;
import app.models.entities.Desejo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static app.Main.*;
import static java.sql.DriverManager.getConnection;

public class DesejoRepository {

    public List<Desejo> selectDesejos(String cpf) throws SQLException {
        String selectString = "SELECT * FROM DESEJOS WHERE UPF_DOC_CLI = ?";
        ResultSet resultSet;
        List<Desejo> desejos = new ArrayList<>();
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD);
             PreparedStatement selectStatement = con.prepareStatement(selectString)) {
            selectStatement.setString(1, cpf);
            resultSet = selectStatement.executeQuery();
            while(resultSet.next()) {
                desejos.add(new Desejo(resultSet.getString(1), resultSet.getInt(2)));
            }
        }
        return desejos;
    }

    public void insertDesejos(PostDesejoDTO postDesejoDTO) throws SQLException {
        String insertString = "INSERT INTO DESEJOS (UPF_DOC_CLI, CAT_ID) VALUES(?,?)";
        try (Connection con = getConnection(ORACLE_URL, ORACLE_USER, ORACLE_USER_PASSWORD);
             PreparedStatement insertStatement = con.prepareStatement(insertString)) {
            for(Integer id: postDesejoDTO.getIdDesejosList()) {
                insertStatement.setString(1, postDesejoDTO.getCpf());
                insertStatement.setInt(2, id);
                insertStatement.executeUpdate();
            }
        }
    }
}
