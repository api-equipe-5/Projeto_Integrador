package com.tecsus.ddc.user;

import com.tecsus.ddc.connection.ConnectionImpl;
import com.tecsus.ddc.repository.Repository;
import com.tecsus.ddc.repository.RepositoryStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserRepository implements RepositoryStatement<User>, Repository<User> {

    private ConnectionImpl<User> connection;

    public UserRepository(Connection connection) {
        this.connection = new ConnectionImpl<User>(connection, this);
    }

    @Override
    public void saveAll(List<User> list) {

    }

    @Override
    public void save(User object) {

    }

    @Override
    public Optional<User> find(Object id) {
        if (!(id instanceof User)) {
            System.out.println("Usuário invalido");
            return Optional.empty();
        }
        User user = (User) id;
        Optional<ResultSet> resultSet = connection.find(UserQueryFactory.select(), user);
        if (resultSet.isPresent()) {
            User response = User.constructFrom(resultSet.get());
            ConnectionImpl.closeResultSet(resultSet.get());
            return Optional.of(response);
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
    }
}
