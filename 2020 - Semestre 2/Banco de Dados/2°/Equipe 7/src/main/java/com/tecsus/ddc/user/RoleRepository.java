package com.tecsus.ddc.user;

import com.tecsus.ddc.connection.ConnectionImpl;
import com.tecsus.ddc.repository.InnerRepository;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RoleRepository implements InnerRepository<Role> {

    private ConnectionImpl<Role> connection;

    public RoleRepository(Connection connection) {
        this.connection = new ConnectionImpl<Role>(connection, this);
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement, Role role, String key) throws SQLException {
        preparedStatement.setString(1, key);
    }

    @Override
    public void saveAll(List<Role> list, String key) {

    }

    @Override
    public void save(Role object, String key) {

    }

    @Override
    public Optional<Role> find(Role object, String key) {
        return Optional.empty();
    }

    @Override
    public List<Role> findAll(Role object, String key) {
        List<Role> roles = new ArrayList<>();
        Optional<ResultSet> resultSet = connection.find(UserQueryFactory.selectRole(), object, key);
        if (resultSet.isPresent()) {
            try {
                do {
                    Role role = Role.valueOf(resultSet.get().getString("DDC_ROLE"));
                    roles.add(role);
                } while (resultSet.get().next());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return roles;
        }
        return Collections.emptyList();
    }

    public List<Role> findAll(String key) {
        return findAll(Role.TYPIST, key);
    }
}
