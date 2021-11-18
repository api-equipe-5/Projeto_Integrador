package com.tecsus.ddc.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface MidRepository {
    void prepareStatement(PreparedStatement preparedStatement, Object object) throws SQLException;
}
