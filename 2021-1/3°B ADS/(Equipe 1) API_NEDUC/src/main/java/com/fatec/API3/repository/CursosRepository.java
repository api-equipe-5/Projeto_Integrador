package com.fatec.API3.repository;

import org.springframework.data.repository.CrudRepository;

import com.fatec.API3.model.Cursos;

public interface CursosRepository extends CrudRepository<Cursos, String>{
	
	Cursos findByid(long id);
	
	Cursos findBytipo(String tipo);

}
