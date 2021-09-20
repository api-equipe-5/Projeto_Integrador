package com.si.safe_share.repository;

import com.si.safe_share.model.Chaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContainerDeChavesRepository extends JpaRepository<Chaves, Integer> {
    Optional<Chaves> findByClienteId(Integer cliente);
}
