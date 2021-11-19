package com.fatec.team1.TeachingPlatform.application.repositories;

import com.fatec.team1.TeachingPlatform.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    Optional<Matricula> findByidUsuarioFk(String idUsuarioFk);
}
