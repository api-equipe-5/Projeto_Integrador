package com.nlearning.repository;

import org.springframework.data.repository.CrudRepository;

import com.nlearning.models.Gestor;

public interface GestorRepository extends CrudRepository<Gestor, String>{
	//Procura Gestor por ID
	Gestor findByIdGestor(Long codigo);
	//Procura Gestor por Email
	Gestor findByEmail(String email);
}
