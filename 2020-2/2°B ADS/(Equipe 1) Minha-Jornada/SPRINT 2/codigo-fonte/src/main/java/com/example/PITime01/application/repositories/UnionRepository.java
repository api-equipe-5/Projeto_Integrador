package com.example.PITime01.application.repositories;

import com.example.PITime01.domain.Union;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnionRepository extends JpaRepository<Union, Long> {
    Optional<Union> findByName(String name);
}
