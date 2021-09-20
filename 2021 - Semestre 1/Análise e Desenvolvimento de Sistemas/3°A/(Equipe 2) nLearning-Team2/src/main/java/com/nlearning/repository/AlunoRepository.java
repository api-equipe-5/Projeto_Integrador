package com.nlearning.repository;


import org.springframework.data.repository.CrudRepository;

import com.nlearning.models.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, String>{
	//Procura Aluno por ID
	Aluno findByIdAluno(Long codigo);
	//Procura Aluno por Email
	Aluno findByEmail(String email);
	//Procura todos alunos
	Aluno findAllByIdAluno(Long codigo);
	
}