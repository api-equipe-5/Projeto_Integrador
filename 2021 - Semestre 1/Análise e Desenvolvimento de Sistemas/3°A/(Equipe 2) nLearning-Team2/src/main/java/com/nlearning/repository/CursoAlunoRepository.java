package com.nlearning.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nlearning.models.CursoAluno;

public interface CursoAlunoRepository extends CrudRepository<CursoAluno, String>{
	//Procura Aluno e Tutor por ID do CursoAluno
	Iterable<CursoAluno> findAllByIdCursoAluno(Long codigo);
	//Procura Aluno e Tutor por ID do aluno
	List<CursoAluno> findAllByIdAluno(Long codigo);
	
	Iterable<CursoAluno> findByIdCurso(Long codigo);
	
	

}