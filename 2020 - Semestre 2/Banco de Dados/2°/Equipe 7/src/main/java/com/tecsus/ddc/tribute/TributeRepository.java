package com.tecsus.ddc.tribute;

import com.tecsus.ddc.connection.ConnectionImpl;
import com.tecsus.ddc.repository.InnerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TributeRepository implements InnerRepository<Tribute> {

    private final ConnectionImpl<Tribute> connection;

    public TributeRepository(Connection connection) {
        this.connection = new ConnectionImpl<Tribute>(connection, this);
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement, Tribute tribute, String key) throws SQLException {
        preparedStatement.setString(1, key);
        preparedStatement.setString(2, tribute.getType().name());
        preparedStatement.setBigDecimal(3, tribute.getValue());
        preparedStatement.setBigDecimal(4, tribute.getAliquot());
        preparedStatement.setBigDecimal(5, tribute.getCalculationBasis());
    }

    @Override
    public void saveAll(List<Tribute> list, String key) {
        list.forEach(tribute -> save(tribute, key));
    }

    @Override
    public void save(Tribute object, String key) {
        connection.save(TributeQueryFactory.insert(), object, key);
    }

    @Override
    public Optional<Tribute> find(Tribute object, String key) {
        return Optional.empty();
    }

    @Override
    public List<Tribute> findAll(Tribute object, String key) {
        return null;
    }
}
