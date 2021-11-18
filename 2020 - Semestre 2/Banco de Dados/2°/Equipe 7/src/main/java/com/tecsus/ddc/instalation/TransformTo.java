package com.tecsus.ddc.instalation;

import java.sql.ResultSet;

public interface TransformTo<T> {
    T  object(ResultSet resultSet, Class<T> object);
}
