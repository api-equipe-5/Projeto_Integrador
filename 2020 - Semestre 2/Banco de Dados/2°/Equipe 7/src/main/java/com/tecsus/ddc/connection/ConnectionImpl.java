package com.tecsus.ddc.connection;

import com.tecsus.ddc.instalation.TransformTo;
import com.tecsus.ddc.repository.InnerRepository;
import com.tecsus.ddc.repository.MidRepository;
import com.tecsus.ddc.repository.RepositoryStatement;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.*;

@Slf4j
public class ConnectionImpl<T> {

    private final Connection connection;
    private RepositoryStatement<T> repositoryStatement;
    private InnerRepository<T> innerRepository;

    public ConnectionImpl(Connection connection, RepositoryStatement<T> repositoryStatement) {
        this.connection = connection;
        this.repositoryStatement = repositoryStatement;
    }

    public ConnectionImpl(Connection connection, InnerRepository<T> innerRepository) {
        this.connection = connection;
        this.innerRepository = innerRepository;
    }

    public void save(final String query, final T object) {
        try {
            log.debug(query);
            PreparedStatement statement = connection.prepareStatement(query);

            repositoryStatement.prepareStatement(statement, object);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            log.error("Insert failed");
            e.printStackTrace();
        }
    }

    public void save(final String query, final T object, final String key) {
        try {
            log.debug(query);
            PreparedStatement statement = connection.prepareStatement(query);

            innerRepository.prepareStatement(statement, object, key);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            log.error("Insert failed");
            e.printStackTrace();
        }
    }

    public Optional<ResultSet> find(final String query, final T object) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            repositoryStatement.prepareStatement(statement, object);
            log.debug(statement.toString());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next())
                return Optional.of(resultSet);
        } catch (SQLException throwables) {
            log.error("Select Failed");
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<ResultSet> find(final String query, final T object, final String key) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            innerRepository.prepareStatement(statement, object, key);
            log.debug(statement.toString());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next())
                return Optional.of(resultSet);
        } catch (SQLException throwables) {
            log.error("Select Failed");
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    public static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("ResultSet close failed");
        }
    }

    public List<T> findAll(final String query, final TransformTo<T> transformTo, Class<T> objectType) {
        ArrayList<T> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            log.debug(statement.toString());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    list.add(transformTo.object(resultSet, objectType));
                }
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<T> findAll(final String query, final TransformTo<T> transformTo, Class<T> objectType, MidRepository midRepository, Object object, String key) {
        ArrayList<T> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            midRepository.prepareStatement(statement, object);
            log.debug(statement.toString());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    list.add(transformTo.object(resultSet, objectType));
                }
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Collections.emptyList();
    }
}
