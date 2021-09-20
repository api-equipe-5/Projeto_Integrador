package com.fatec.antenas.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Status")
public class Status {
	private boolean negado;
	private String motivo;
	
	
	
	public Status(boolean negado, String motivo) {
		super();
		this.negado = negado;
		this.motivo = motivo;
	}
	public boolean isNegado() {
		return negado;
	}
	public void setNegado(boolean negado) {
		this.negado = negado;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	
}
