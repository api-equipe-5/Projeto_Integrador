package com.ExampleValcode.valcode.rest;

import com.ExampleValcode.valcode.model.entity.PessoaFisica;
import com.ExampleValcode.valcode.model.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Table;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/pessoafisica")
public class PessoaFisicaController {

    private final PessoaFisicaRepository repository;

    @Autowired
    public PessoaFisicaController(PessoaFisicaRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaFisica save(@RequestBody PessoaFisica pessoa){
        return this.repository.save(pessoa);
    }

    @GetMapping
    public List<PessoaFisica> getAlll(){
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    public PessoaFisica getById(@PathVariable("id") String id){
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PessoaFisica update(@RequestBody PessoaFisica pessoaAtualizada, @PathVariable("id") String id){
        return this.repository.findById(id).map(pessoaFisica -> {
            pessoaAtualizada.setDoc_cli(pessoaFisica.getDoc_cli());
            return this.repository.save(pessoaAtualizada);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Class<Void> delete(@PathVariable("id") String id){
        return this.repository.findById(id).map(pessoaFisica -> {
            this.repository.delete(pessoaFisica);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
