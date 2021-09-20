package com.spring.gantt.GanttBubbleSort.funcionario;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer>{

    ArrayList<Funcionario> findAll();

}
