package com.ExampleValcode.valcode.model.repository;

import com.ExampleValcode.valcode.model.entity.Movimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/pagamentos")
@RestController
public interface MovimentosRepository extends JpaRepository<Movimentos, Integer> {

}
