package com.fatec.antenas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Reuniao")
public class Reuniao {
	private String data;
	private String local;
	private String horario;
	private String assunto;
	
	
	public Reuniao(String data, String local, String horario, String assunto) {
		super();
		this.data = data;
		this.local = local;
		this.horario = horario;
		this.assunto = assunto;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	
}
