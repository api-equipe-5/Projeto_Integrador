package com.nlearning.repository;

import org.springframework.data.repository.CrudRepository;

import com.nlearning.models.Curriculo;

public interface CurriculoRepository extends CrudRepository<Curriculo, String> {
	// Procura Aluno por ID
	Curriculo findByIdCandidato(Long codigo);
}