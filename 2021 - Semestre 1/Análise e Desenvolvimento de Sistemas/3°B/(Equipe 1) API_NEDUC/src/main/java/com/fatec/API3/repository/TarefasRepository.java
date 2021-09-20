package com.fatec.API3.repository;

import org.springframework.data.repository.CrudRepository;

import com.fatec.API3.model.Cursos;
import com.fatec.API3.model.Tarefas;

public interface TarefasRepository extends CrudRepository<Tarefas, String>{

	Tarefas findByid(long id);
	
	Iterable<Tarefas> findByCurso(Cursos cursos);
	
	Tarefas findById(long id);
	
}
