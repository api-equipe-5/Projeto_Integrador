package com.fatec.API3.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Tarefas implements  Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	
	@NotEmpty
	private String nome;
	
	private String descricao;
	
	private String url_form;
	
	@ManyToOne
	private Cursos curso;
	
	private String id_curso;
	

	public Cursos getCurso() {
		return curso;
	}

	public void setCurso(Cursos curso) {
		this.curso = curso;
	}

	public String getUrl_form() {
		return url_form;
	}

	public void setUrl_form(String url_form) {
		this.url_form = url_form;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getId_curso() {
		return id_curso;
	}

	public void setId_curso(String id_curso) {
		this.id_curso = id_curso;
	}

}
