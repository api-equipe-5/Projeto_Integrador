package com.spring.gantt.GanttBubbleSort.link;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public interface LinkRepository extends CrudRepository<Link, Integer>{

    ArrayList<Link> findAll();
    
}