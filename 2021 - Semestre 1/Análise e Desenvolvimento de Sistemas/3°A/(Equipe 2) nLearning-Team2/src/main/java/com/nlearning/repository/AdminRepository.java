package com.nlearning.repository;

import org.springframework.data.repository.CrudRepository;

import com.nlearning.models.Admin;

public interface AdminRepository extends CrudRepository<Admin, String>{
	//Procura Admin por ID
		Admin findByIdAdmin(Long codigo);
	//Procurar Admin por Email
		Admin findByEmail(String email);
}