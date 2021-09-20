package com.nlearning.repository;

import org.springframework.data.repository.CrudRepository;

import com.nlearning.models.Tutor;

public interface TutorRepository extends CrudRepository<Tutor, String>{
	//Procura Tutor por ID
	Tutor findByIdTutor(Long codigo);
	//Procura Tutor por Email
	Tutor findByEmail(String email);
}
