package com.tecsus.ddc.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    void saveAll(final List<T> list);
    void save(final T object);
    Optional<T> find(Object id);
    List<T> findAll();
}
