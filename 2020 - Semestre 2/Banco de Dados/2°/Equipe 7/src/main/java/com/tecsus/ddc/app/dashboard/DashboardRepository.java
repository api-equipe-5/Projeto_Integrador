package com.tecsus.ddc.app.dashboard;

import com.tecsus.ddc.connection.ConnectionImpl;
import com.tecsus.ddc.instalation.TransformTo;
import com.tecsus.ddc.repository.Repository;
import com.tecsus.ddc.repository.RepositoryStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DashboardRepository implements Repository<DashboardBill>, RepositoryStatement<DashboardBill>, TransformTo<DashboardBill> {

    ConnectionImpl<DashboardBill> connection;

    public DashboardRepository(Connection connection) {
        this.connection = new ConnectionImpl<>(connection, this);
    }

    @Override
    public void saveAll(List<DashboardBill> list) {

    }

    @Override
    public void save(DashboardBill object) {

    }

    @Override
    public Optional<DashboardBill> find(Object id) {
        return Optional.empty();
    }

    @Override
    public List<DashboardBill> findAll() {
        return connection.findAll(DashboardBill.select(), this, DashboardBill.class);
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement, DashboardBill object) throws SQLException {

    }

    @Override
    public DashboardBill object(ResultSet resultSet, Class<DashboardBill> object) {
        try {
            return DashboardBill.builder()
                    .number(resultSet.getString("billnum"))
                    .instalation(resultSet.getString("instalation"))
                    .supplier(resultSet.getString("supplier"))
                    .clientCNPJ(resultSet.getString("clientcnpj"))
                    .clientName(resultSet.getString("clientname"))
                    .type(resultSet.getString("billtype"))
                    .hidrometer(resultSet.getString("meter"))
                    .register(resultSet.getString("register_date"))
                    .build();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
