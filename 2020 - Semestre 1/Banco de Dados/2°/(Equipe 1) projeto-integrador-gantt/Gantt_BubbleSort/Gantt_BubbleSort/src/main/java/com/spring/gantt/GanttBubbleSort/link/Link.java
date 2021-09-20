package com.spring.gantt.GanttBubbleSort.link;
import javax.persistence.*;

@Entity
public class Link {

    @Id
    private int id;
	private String source;
	private String target;
	private String type;

	public Link(){}

	public Link(int id,
            String source,
            String target,
            String type) {
		this.id = id;
		this.source = source;
		this.target = target;
		this.type = type;
    }
  
}