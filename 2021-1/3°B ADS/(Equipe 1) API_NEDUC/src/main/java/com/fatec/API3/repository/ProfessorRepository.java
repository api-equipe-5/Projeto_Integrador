package com.fatec.API3.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fatec.API3.model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, String> {
	Professor findByid(long id);
	
	
	Optional<Professor> findByemail(String email);
	
	
	boolean existsByemail(String email);
}
