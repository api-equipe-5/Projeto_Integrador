package com.tecsus.ddc.register;

import com.tecsus.ddc.connection.ConnectionImpl;
import com.tecsus.ddc.repository.Repository;
import com.tecsus.ddc.repository.RepositoryStatement;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Slf4j
public class RegisterRepository implements RepositoryStatement<Register>, Repository<Register> {

    private final ConnectionImpl<Register> connection;

    public RegisterRepository(final Connection connection) {
        this.connection = new ConnectionImpl<Register>(connection, this);
    }

    @Override
    public void saveAll(final List<Register> registers) {
        registers.forEach(this::save);
    }

    @Override
    public void save(final Register register) {
        connection.save(RegisterQueryFactory.insert(), register);
    }

    @Override
    public Optional<Register> find(Object id) {
        return Optional.empty();
    }

    @Override
    public List<Register> findAll() {
        return null;
    }

    @Override
    public void prepareStatement(final PreparedStatement preparedStatement, final Register register) throws SQLException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        preparedStatement.setString(1, register.getUser().getLogin());
        preparedStatement.setString(2, register.getBill().getBillNum());
        preparedStatement.setString(3, register.getInstalation().getInstalationNumber());
        preparedStatement.setDate(4, Date.valueOf(format.format(new java.util.Date())));
    }
}
