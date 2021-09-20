package com.nlearning.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trilha implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idTrilha;

	private long idCurso;
	private long idAluno;
	private long aulasFeitas;
	private long AulasCurso;
	
	public long getIdTrilha() {
		return idTrilha;
	}
	public void setIdTrilha(long idTrilha) {
		this.idTrilha = idTrilha;
	}
	public long getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}
	public long getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
	}
	public long getAulasFeitas() {
		return aulasFeitas;
	}
	public void setAulasFeitas(long aulasFeitas) {
		this.aulasFeitas = aulasFeitas;
	}
	public long getAulasCurso() {
		return AulasCurso;
	}
	public void setAulasCurso(long aulasCurso) {
		AulasCurso = aulasCurso;
	}
}