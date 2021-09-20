package com.spring.gantt.GanttBubbleSort.projeto;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public interface ProjetoRepository extends CrudRepository<Projeto, Integer>{

    ArrayList<Projeto> findAll();

}