package com.fatec.team1.TeachingPlatform.application.services;

import com.fatec.team1.TeachingPlatform.application.repositories.MatriculaRepository;
import com.fatec.team1.TeachingPlatform.domain.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatriculaService {

    private final MatriculaRepository repository;

    @Autowired
    private final CursoService cursoService;

    public MatriculaService(MatriculaRepository repository, CursoService cursoService) {
        this.repository = repository;
        this.cursoService = cursoService;
    }

    public List<Matricula> listAll() {
        return repository.findAll()
                .stream()
                .map(Matricula::new)
                .collect(Collectors.toList());
    }

    public HashSet listUser(Long idUsuarioFk) {
        List<Matricula> list = repository.findAll()
                .stream()
                .filter(matricula -> (matricula.getIdUsuarioFk()) == (idUsuarioFk))
                .collect(Collectors.toList());
        HashSet newlist = new HashSet();
        list.forEach((temp) ->{
            newlist.add(cursoService.findById(temp.getIdCursoFk()));
        });
        return newlist;
    }

    public Matricula findById(Long id) {
        return repository.findById(id).get();
    }

    public void save(Matricula matricula) {
        repository.save(matricula);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
