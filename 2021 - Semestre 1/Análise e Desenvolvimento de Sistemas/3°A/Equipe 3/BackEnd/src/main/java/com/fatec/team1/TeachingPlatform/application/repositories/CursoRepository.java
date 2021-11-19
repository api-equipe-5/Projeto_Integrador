package com.fatec.team1.TeachingPlatform.application.repositories;

import com.fatec.team1.TeachingPlatform.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    Optional<Curso> findByNomeCurso(String curso);
}

