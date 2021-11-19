package com.fatec.team1.TeachingPlatform.application.services;

import com.fatec.team1.TeachingPlatform.application.dto.UserAccountDTO;
import com.fatec.team1.TeachingPlatform.application.repositories.CursoRepository;
import com.fatec.team1.TeachingPlatform.domain.AccountRole;
import com.fatec.team1.TeachingPlatform.domain.Curso;
import com.fatec.team1.TeachingPlatform.domain.UserAccount;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<Curso> listAll() {
        return repository.findAll()
                .stream()
                .map(Curso::new)
                .collect(Collectors.toList());
    }

    public Curso findById(Long id) {
        return repository.findById(id).get();
    }

    public Curso findByEmail(String curso) {
        return repository.findByNomeCurso(curso).get();
    }

    public void save(Curso curso) {
        repository.save(curso);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
