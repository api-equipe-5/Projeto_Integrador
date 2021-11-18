package com.tecsus.ddc.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface RepositoryStatement<T> {
    void prepareStatement(final PreparedStatement preparedStatement, final T object) throws SQLException;
}
