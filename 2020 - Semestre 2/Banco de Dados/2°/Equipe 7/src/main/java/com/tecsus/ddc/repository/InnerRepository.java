package com.tecsus.ddc.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface InnerRepository<T> {
    void prepareStatement(final PreparedStatement preparedStatement, final T object, final String key) throws SQLException;
    void saveAll(final List<T> list, final String key);
    void save(final T object, final String key);
    Optional<T> find(final T object, final String key);
    List<T> findAll(final T object, final String key);
}
