package com.mitimAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Revisao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String responsavel;
	private String assunto;
	private String comentario;
	private Integer idusuario;
	private Integer idata;
	
	
	public Integer getIdata() {
		return idata;
	}
	public void setIdata(Integer idata) {
		this.idata = idata;
	}
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

}
