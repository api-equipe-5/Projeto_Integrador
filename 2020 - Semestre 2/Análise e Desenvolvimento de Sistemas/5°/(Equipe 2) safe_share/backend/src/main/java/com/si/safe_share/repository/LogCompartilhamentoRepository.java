package com.si.safe_share.repository;

import com.si.safe_share.model.LogCompartilhamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogCompartilhamentoRepository extends JpaRepository<LogCompartilhamento, Integer> {
    public List<LogCompartilhamento> findByCliente_Id(Integer id);
}