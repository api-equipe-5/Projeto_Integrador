package com.fatec.antenas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fatec.antenas.model.DocumentAluno;

public interface AlunoRepository extends MongoRepository<DocumentAluno, String>{
	DocumentAluno findByEmail(String email);
}
