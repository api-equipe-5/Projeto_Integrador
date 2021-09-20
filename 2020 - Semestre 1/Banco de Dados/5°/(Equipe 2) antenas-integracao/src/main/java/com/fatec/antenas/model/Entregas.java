package com.fatec.antenas.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Reuniao")
public class Entregas {
	
	private String alunoReponsavel;
	private List<String> alunos;
	private String linkReponsitorio;
	private String linkCloud;
	private String comentario;
	
	public Entregas(String alunoReponsavel, List<String> alunos, String linkReponsitorio, String linkCloud,
			String comentario) {
		super();
		this.alunoReponsavel = alunoReponsavel;
		this.alunos = alunos;
		this.linkReponsitorio = linkReponsitorio;
		this.linkCloud = linkCloud;
		this.comentario = comentario;
	}

	public String getAlunoReponsavel() {
		return alunoReponsavel;
	}

	public void setAlunoReponsavel(String alunoReponsavel) {
		this.alunoReponsavel = alunoReponsavel;
	}

	public List<String> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<String> alunos) {
		this.alunos = alunos;
	}

	public String getLinkReponsitorio() {
		return linkReponsitorio;
	}

	public void setLinkReponsitorio(String linkReponsitorio) {
		this.linkReponsitorio = linkReponsitorio;
	}

	public String getLinkCloud() {
		return linkCloud;
	}

	public void setLinkCloud(String linkCloud) {
		this.linkCloud = linkCloud;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
	
}
