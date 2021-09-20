package com.ExampleValcode.valcode.rest;

import com.ExampleValcode.valcode.model.entity.Fonte;
import com.ExampleValcode.valcode.model.repository.FonteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/fonte")
public class FonteController {

    private final FonteRepository repository;

    @Autowired
    public FonteController(FonteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fonte save(@RequestBody Fonte fonte){
        return repository.save(fonte);
    }

    @GetMapping
    public List<Fonte> getAll(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Fonte getById(@PathVariable("id") Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Class<Void> delete(@PathVariable("id") Integer id){
        return repository.findById(id).map(fonte -> {
            repository.delete(fonte);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Fonte update (@PathVariable("id") Integer id, @RequestBody Fonte fonteAtualizado){
        return repository.findById(id).map(fonte -> {
            fonteAtualizado.setId(fonte.getId());
            return repository.save(fonteAtualizado);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
