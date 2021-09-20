package com.nlearning.repository;

import org.springframework.data.repository.CrudRepository;

import com.nlearning.models.Curso;

public interface CursoRepository extends CrudRepository<Curso, String>{
	//Procura Aluno por ID
	Curso findByIdCurso(Long codigo);
	//Procura Aluno por Email
	Curso findByNomeCurso(String nome);
	//Procura curso já comprado
	Curso findAllByIdCurso(long codigo);
	//Procura tutor do curso
	Iterable<Curso> findIdCursoByIdTutor(long codigo);
	//Procura curso cadastrado pelo tutor especifico
	Iterable<Curso> findAllByIdTutor(Long idUsu);
}