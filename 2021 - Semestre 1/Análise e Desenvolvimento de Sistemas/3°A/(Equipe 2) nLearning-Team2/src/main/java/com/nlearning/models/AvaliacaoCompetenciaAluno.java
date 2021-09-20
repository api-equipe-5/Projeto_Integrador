package com.nlearning.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AvaliacaoCompetenciaAluno implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAval;
	private long idAluno;
	private long idTutor;
	private String Titulo;
	private String avaliacaoCompt;
	private String avaliacaoTecnica;
	
	public long getIdAval() {
		return idAval;
	}
	public void setIdAval(long idAval) {
		this.idAval = idAval;
	}
	public long getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
	}
	public long getIdTutor() {
		return idTutor;
	}
	public void setIdTutor(long idTutor) {
		this.idTutor = idTutor;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getAvaliacaoCompt() {
		return avaliacaoCompt;
	}
	public void setAvaliacaoCompt(String avaliacaoCompt) {
		this.avaliacaoCompt = avaliacaoCompt;
	}
	public String getAvaliacaoTecnica() {
		return avaliacaoTecnica;
	}
	public void setAvaliacaoTecnica(String avaliacaoTecnica) {
		this.avaliacaoTecnica = avaliacaoTecnica;
	}
	
}
