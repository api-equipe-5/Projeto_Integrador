package com.fatec.team1.TeachingPlatform.application.http.controllers;

import com.fatec.team1.TeachingPlatform.application.repositories.CursoRepository;
import com.fatec.team1.TeachingPlatform.domain.Curso;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
public class CursoController implements WebMvcConfigurer {

    private final CursoRepository repository;

    public CursoController(CursoRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/curso/new")
    Curso newCurso(@RequestBody Curso curso){
        return repository.save(curso);
    }
}