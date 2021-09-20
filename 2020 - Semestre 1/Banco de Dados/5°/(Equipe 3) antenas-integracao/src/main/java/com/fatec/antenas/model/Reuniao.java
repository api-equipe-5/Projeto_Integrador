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
	private List<String> datasPossiveis = new ArrayList<String>();
	
	
	




	public Reuniao(String data, String local, String horario, List<String> datasPossiveis) {
		super();
		this.data = data;
		this.local = local;
		this.horario = horario;
		this.datasPossiveis = datasPossiveis;
	}




	public List<String> getDatasPossiveis() {
		return datasPossiveis;
	}




	public void setDatasPossiveis(List<String> datasPossiveis) {
		this.datasPossiveis = datasPossiveis;
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

	
	
	
	
}
