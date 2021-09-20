package com.nlearning.repository;

import org.springframework.data.repository.CrudRepository;

import com.nlearning.models.Questao;

public interface QuestaoRepository extends CrudRepository<Questao, String>{
	//Procura Questao por ID
	Iterable<Questao> findByIdCurso(Long codigo);

	
}