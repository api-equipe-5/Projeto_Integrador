package com.spring.gantt.GanttBubbleSort.tarefa;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface TarefaRepository extends CrudRepository<Tarefa, Integer>{
    
    List<Tarefa> findByParent(int parent);

    List<Tarefa> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM tarefa WHERE projeto_id = 8;")
    List<Tarefa> findtarefas();
    
}