package com.spring.gantt.GanttBubbleSort;

public class Projects {
	private int id;
	private String text;
	private String start_date;
	private int progress;
	private String type;
	
	public Projects(int id, String text, String start_date, int progress, String type) {
		super();
		this.id = id;
		this.text = text;
		this.start_date = start_date;
		this.progress = progress;
		this.type = type;
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
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

