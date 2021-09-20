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
	
	
	
	
}
