package com.fatec.antenas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fatec.antenas.model.DocumentCadi;

public interface CadiRepository extends MongoRepository<DocumentCadi, String>{
	DocumentCadi findByEmail(String email);
}
