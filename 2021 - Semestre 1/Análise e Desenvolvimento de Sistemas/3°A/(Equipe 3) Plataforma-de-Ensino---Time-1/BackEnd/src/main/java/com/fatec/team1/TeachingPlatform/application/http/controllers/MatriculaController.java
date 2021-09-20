package com.fatec.team1.TeachingPlatform.application.http.controllers;

import com.fatec.team1.TeachingPlatform.application.repositories.MatriculaRepository;
import com.fatec.team1.TeachingPlatform.application.services.MatriculaService;
import com.fatec.team1.TeachingPlatform.domain.Matricula;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;

@RestController
public class MatriculaController implements WebMvcConfigurer {

    private final MatriculaRepository repository;

    private final MatriculaService service;

    public MatriculaController(MatriculaRepository repository, MatriculaService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("/matricula/new")
    Matricula newMatricula(@RequestBody Matricula matricula){
        return repository.save(matricula);
    }

    @DeleteMapping("/matricula/delete")
    void deleteMatricula(@RequestBody Matricula matricula){
        repository.deleteById(matricula.getId());
    }

    @GetMapping("/matricula/userList")
    HashSet all(@RequestBody Matricula matricula){
        return service.listUser(matricula.getIdUsuarioFk());
    }
}