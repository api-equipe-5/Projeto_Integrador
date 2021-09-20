package com.spring.gantt.GanttBubbleSort.tarefa;

import javax.persistence.*;

@Entity
public class Tarefa {
    
    @Id
    private int id;
	private String text;
	private String start_date;
	private String end_date;
	private int progress;
	private String parent;
	private int duration;
	private String priority;
	private String type;
	private String render;
	private String owner;

	public Tarefa(){}

	public Tarefa(int id,
				  String text,
				  String start_date,
				  String end_date,
				  int progress,
				  String parent,
				  int duration,
				  String priority,
				  String type,
				  String render,
				  String owner) {
		super();
	
		this.id = id;
		this.text = text;
		this.start_date = start_date;
		this.end_date = end_date;
		this.progress = progress;
		this.parent = parent;
		this.duration = duration;
		this.priority = priority;
		this.type = type;
		this.render = render;
		this.owner = owner;
	}
    
}