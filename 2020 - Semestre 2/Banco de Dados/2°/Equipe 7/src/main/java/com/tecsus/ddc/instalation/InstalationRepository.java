package com.tecsus.ddc.instalation;

import com.tecsus.ddc.connection.ConnectionImpl;
import com.tecsus.ddc.repository.Repository;
import com.tecsus.ddc.repository.RepositoryStatement;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Slf4j
public class InstalationRepository implements Repository<Instalation>, RepositoryStatement<Instalation> {

    private final ConnectionImpl<Instalation> connection;

    public InstalationRepository(Connection connection) {
        this.connection = new ConnectionImpl<Instalation>(connection, this);
    }

    @Override
    public void saveAll(List<Instalation> list) {

    }

    @Override
    public void save(Instalation object) {

    }

    @Override
    public Optional<Instalation> find(Object id) {
        if (!(id instanceof Instalation)) {
            log.error("Instalation not found");
            return Optional.empty();
        }
        Instalation instalation = (Instalation) id;
        Optional<ResultSet> resultSet = connection.find(InstalationQueryFactory.select(), instalation);
        if (resultSet.isPresent()) {
            instalation = Instalation.constructFrom(resultSet.get());
            ConnectionImpl.closeResultSet(resultSet.get());
            return Optional.of(instalation);
        }
        return Optional.empty();
    }

    @Override
    public List<Instalation> findAll() {
        return null;
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement, Instalation instalation) throws SQLException {
        preparedStatement.setString(1, instalation.getInstalationNumber());
    }
}
