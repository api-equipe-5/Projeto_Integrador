package com.fatec.antenas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fatec.antenas.model.DocumentProfessor;

public interface ProfessorRepository extends MongoRepository<DocumentProfessor, String>{
	DocumentProfessor findByEmail(String email);
}
