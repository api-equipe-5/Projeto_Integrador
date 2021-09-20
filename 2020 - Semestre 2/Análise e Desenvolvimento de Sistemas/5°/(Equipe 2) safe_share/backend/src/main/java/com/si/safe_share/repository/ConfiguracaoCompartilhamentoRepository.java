package com.si.safe_share.repository;

import com.si.safe_share.model.ConfiguracaoCompartilhamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfiguracaoCompartilhamentoRepository extends JpaRepository<ConfiguracaoCompartilhamento, Integer> {
    Optional<ConfiguracaoCompartilhamento> findById(Integer id);
}
