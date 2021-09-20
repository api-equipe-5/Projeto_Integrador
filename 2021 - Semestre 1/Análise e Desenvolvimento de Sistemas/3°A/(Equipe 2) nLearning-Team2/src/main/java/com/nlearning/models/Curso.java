package com.nlearning.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCurso;

	private String nomeCurso;
	private String descricao;
	private String tutor;
	private byte[] imagem;
	private String imagem_string;
	private Long idTutor;
	private Long idAdmin;
	private byte[] pilula;
	private String pilula_string;

	public long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getImagem_string() {
		return imagem_string;
	}

	public void setImagem_string(String imagem_string) {
		this.imagem_string = imagem_string;
	}

	public Long getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(Long idTutor) {
		this.idTutor = idTutor;
	}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public byte[] getPilula() {
		return pilula;
	}

	public void setPilula(byte[] pilula) {
		this.pilula = pilula;
	}

	public String getPilula_string() {
		return pilula_string;
	}

	public void setPilula_string(String pilula_string) {
		this.pilula_string = pilula_string;
	}


}
