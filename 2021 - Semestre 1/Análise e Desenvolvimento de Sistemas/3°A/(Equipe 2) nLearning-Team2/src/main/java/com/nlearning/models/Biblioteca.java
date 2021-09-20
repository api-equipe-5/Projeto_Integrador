package com.nlearning.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Biblioteca implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLivro;

	private String nomeLivro;
	private String descricao;
	private String autor;
	private byte[] imagem;
	private String imagem_string;
	private byte[] pdf;
	private String pdf_string;
	
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
	public byte[] getPdf() {
		return pdf;
	}
	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}
	public String getPdf_string() {
		return pdf_string;
	}
	public void setPdf_string(String pdf_string) {
		this.pdf_string = pdf_string;
	}
}
