package com.nlearning.models;

	public class ListaAlunosModel {
	private long idAluno;
	private long idTutor;
	private long idCurso;
	private String nomeTutor;
	private String nomeAluno;
	private String nomeCurso;
	
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getNomeTutor() {
		return nomeTutor;
	}
	public void setNomeTutor(String nomeTutor) {
		this.nomeTutor = nomeTutor;
	}
	public long getIdTutor() {
		return idTutor;
	}
	public void setIdTutor(long idTutor) {
		this.idTutor = idTutor;
	}
	public long getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
	}
	public long getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}
	

}
