package com.nlearning.models;

import java.io.Serializable;

public class BibliotecaControllerModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long idLivro;

	private String nomeLivro;
	private String descricao;
	private String autor;
	
	public long getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(long idLivro) {
		this.idLivro = idLivro;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
}
