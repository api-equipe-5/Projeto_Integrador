package com.ExampleValcode.valcode.model.repository;

import com.ExampleValcode.valcode.model.entity.Operacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacoesRepository extends JpaRepository<Operacoes, Integer> {
}
