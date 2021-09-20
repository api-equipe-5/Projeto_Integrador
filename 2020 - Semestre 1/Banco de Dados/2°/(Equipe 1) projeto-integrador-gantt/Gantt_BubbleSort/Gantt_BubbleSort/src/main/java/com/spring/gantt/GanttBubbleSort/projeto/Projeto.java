package com.spring.gantt.GanttBubbleSort.projeto;
import javax.persistence.*;

@Entity
public class Projeto {

    @Id
    private int id;
	private String text;
	private String start_date;
	private String end_date;
	private int progress;
	private int parent;
	private int duration;
	private String priority;
	private String type;
	
	public Projeto(){}

	public Projeto(int id,
				   String text,
				   String start_date,
				   String end_date,
				   int progress,
				   int parent,
				   int duration,
				   String priority,
				   String type ) {
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
    }
  
}