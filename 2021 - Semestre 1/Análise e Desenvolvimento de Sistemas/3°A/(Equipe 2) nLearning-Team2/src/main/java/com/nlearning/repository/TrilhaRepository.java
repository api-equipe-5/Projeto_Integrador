package com.nlearning.repository;

import org.springframework.data.repository.CrudRepository;

import com.nlearning.models.Trilha;

public interface TrilhaRepository extends CrudRepository<Trilha, String> {

	Trilha findByIdCursoAndIdAluno(Long idCurso, Long idAluno);

}