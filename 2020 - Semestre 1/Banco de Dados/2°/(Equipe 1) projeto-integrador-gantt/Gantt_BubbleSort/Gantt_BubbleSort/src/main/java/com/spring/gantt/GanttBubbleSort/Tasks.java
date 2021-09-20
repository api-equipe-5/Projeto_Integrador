package com.spring.gantt.GanttBubbleSort;

public class Tasks {
	
	private int id;
	private String text;
	private String start_date;
	private String end_date;
	private int progress;
	private int parent;
	
	public Tasks(String text, String start_date, String end_date, int progress, int parent) {
		super();
		this.text = text;
		this.start_date = start_date;
		this.end_date = end_date;
		this.progress = progress;
		this.parent = parent;
	}

	public Tasks(int id, String text, String start_date, String end_date, int progress, int parent) {
		super();
		this.id = id;
		this.text = text;
		this.start_date = start_date;
		this.end_date = end_date;
		this.progress = progress;
		this.parent = parent;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}	
}

