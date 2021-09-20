package com.ExampleValcode.valcode.rest;

import com.ExampleValcode.valcode.model.entity.Modalidade;
import com.ExampleValcode.valcode.model.repository.ModalidadeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/modalidade")
@RestController
public class ModalidadeController {

    private final ModalidadeRepository repository;

    public ModalidadeController(ModalidadeRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Modalidade save(@RequestBody Modalidade modalidade){
        return this.repository.save(modalidade);
    }

    @GetMapping
    public List<Modalidade> getAll(){
        return this.repository.findAll();
    }
}
