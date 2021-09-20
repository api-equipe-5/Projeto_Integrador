package com.fatec.antenas.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fatec.antenas.model.DocumentEmpresario;


public interface EmpresarioRepository extends MongoRepository<DocumentEmpresario, String>{
	 DocumentEmpresario findByEmail(String email);
}
