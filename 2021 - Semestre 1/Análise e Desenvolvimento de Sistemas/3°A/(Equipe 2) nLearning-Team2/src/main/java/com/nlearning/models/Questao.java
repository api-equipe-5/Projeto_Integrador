package com.nlearning.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Questao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idQuestao;
	
	private byte[] pergunta;
	private byte[] video;
	private String forms;
	private long idCurso;
	private String pdfStringQuestao;
	private String videoString;
	private String nome;
	
	public long getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(long idQuestao) {
		this.idQuestao = idQuestao;
	}
	public byte[] getPergunta() {
		return pergunta;
	}
	public void setPergunta(byte[] pergunta) {
		this.pergunta = pergunta;
	}
	public long getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}
	public String getPdfStringQuestao() {
		return pdfStringQuestao;
	}
	public void setPdfStringQuestao(String pdfStringQuestao) {
		this.pdfStringQuestao = pdfStringQuestao;
	}
	public byte[] getVideo() {
		return video;
	}
	public void setVideo(byte[] video) {
		this.video = video;
	}
	public String getVideoString() {
		return videoString;
	}
	public void setVideoString(String videoString) {
		this.videoString = videoString;
	}
	
	public String getForms() {
		return forms;
	}
	public void setForms(String forms) {
		this.forms = forms;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
