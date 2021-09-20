package com.spring.gantt.GanttBubbleSort.funcionario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int key;
	private String label;
	
	public Funcionario(){}
	
	public Funcionario(String label) {
		super();
		this.label = label;
	}
	
	public String getlabel() {
		return label;
	}
	public void setlabel(String label) {
		this.label = label;
	}

	public int getId() {
		return key;
	}

	public void setId(int key) {
		this.key = key;
	}

}
