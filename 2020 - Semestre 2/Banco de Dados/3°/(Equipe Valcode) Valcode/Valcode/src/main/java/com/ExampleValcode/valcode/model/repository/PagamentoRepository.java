package com.ExampleValcode.valcode.model.repository;

import com.ExampleValcode.valcode.model.entity.Pagamentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository <Pagamentos, String> {
}
