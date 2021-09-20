package com.fatec.antenas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.fatec.antenas.model.DocumentProjeto;

public interface ProjetoRepository extends MongoRepository<DocumentProjeto, String>{
	List<DocumentProjeto> findByresponsavelCadi(String responsavelCadi);
	List<DocumentProjeto> findByresponsavelEmpresario(String responsavelEmpresario);
}
