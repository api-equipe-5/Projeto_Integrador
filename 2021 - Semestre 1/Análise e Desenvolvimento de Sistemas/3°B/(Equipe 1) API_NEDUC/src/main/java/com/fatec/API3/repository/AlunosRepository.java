package com.fatec.API3.repository;

import org.springframework.data.repository.CrudRepository;

import com.fatec.API3.model.Alunos;

public interface AlunosRepository extends CrudRepository<Alunos, String>{
	Alunos findByid(long id);
	
	Alunos findBylogin(String login);
	
	Alunos findByemail(String email);
	
	
	boolean existsByemail(String email);
}
