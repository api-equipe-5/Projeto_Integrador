package com.ExampleValcode.valcode.rest;

import com.ExampleValcode.valcode.model.entity.Pagamentos;
import com.ExampleValcode.valcode.model.repository.PagamentoRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentosController {

    private final PagamentoRepository repository;

    @Autowired
    public PagamentosController(PagamentoRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamentos save(@RequestBody Pagamentos pagamentos){
        return this.repository.save(pagamentos);
    }

    @GetMapping
    public List<Pagamentos> getAll(){
        return this.repository.findAll();
    }
}
