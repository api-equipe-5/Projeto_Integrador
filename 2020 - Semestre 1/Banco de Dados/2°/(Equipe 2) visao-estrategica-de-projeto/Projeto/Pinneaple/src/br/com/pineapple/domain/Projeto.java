package br.com.pineapple.domain;

import java.sql.Date;

public class Projeto {
	private String nome;
	private String inicio;
	private String entrega;

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getEntrega() {
		return entrega;
	}
	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}

	public String toString() {
		// TODO Auto-generated method stub
		String saida = nome + " " + inicio + " " + entrega;
		return saida;
	}
	
	
}
