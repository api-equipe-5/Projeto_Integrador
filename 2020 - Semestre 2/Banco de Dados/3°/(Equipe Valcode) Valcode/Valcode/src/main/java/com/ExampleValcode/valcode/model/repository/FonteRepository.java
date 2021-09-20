package com.ExampleValcode.valcode.model.repository;

import com.ExampleValcode.valcode.model.entity.Fonte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FonteRepository extends JpaRepository<Fonte, Integer> {
}
