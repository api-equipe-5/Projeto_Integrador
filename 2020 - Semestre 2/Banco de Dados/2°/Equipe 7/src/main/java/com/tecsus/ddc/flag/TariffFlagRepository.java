package com.tecsus.ddc.flag;

import com.tecsus.ddc.connection.ConnectionImpl;
import com.tecsus.ddc.repository.InnerRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TariffFlagRepository implements InnerRepository<TariffFlag> {

    private ConnectionImpl<TariffFlag> connection;

    public TariffFlagRepository(Connection connection) {
        this.connection = new ConnectionImpl<TariffFlag>(connection, this);
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement, TariffFlag tariffFlag, String key) throws SQLException {
        preparedStatement.setString(1, tariffFlag.getColor().getColor());
        preparedStatement.setDate(2, (Date) tariffFlag.getStart());
        preparedStatement.setDate(3, (Date) tariffFlag.getFinish());
        preparedStatement.setString(4, key);
    }

    @Override
    public void saveAll(List<TariffFlag> list, String key) {
        list.forEach(tariffFlag -> save(tariffFlag, key));
    }

    @Override
    public void save(TariffFlag object, String key) {
        connection.save(TariffFlagQueryFactory.insert(), object, key);
    }

    @Override
    public Optional<TariffFlag> find(TariffFlag object, String key) {
        return Optional.empty();
    }

    @Override
    public List<TariffFlag> findAll(TariffFlag object, String key) {
        return null;
    }
}
