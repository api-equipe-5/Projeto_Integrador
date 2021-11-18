package com.tecsus.ddc.user;

import lombok.Builder;
import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Builder
@Data
public class User {

    private String login;
    private String username;
    private String password;
    private Date creationDate;

    private List<Role> roles;

    public static User constructFrom(final ResultSet resultSet) {
        try {
            return User.builder()
                    .login(resultSet.getString("LOGIN"))
                    .username(resultSet.getString("USER_NAME"))
                    .password(resultSet.getString("PASS"))
                    .creationDate(resultSet.getDate("CREATION_DATE"))
                    .build();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
