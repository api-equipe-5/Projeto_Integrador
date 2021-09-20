package com.mitimAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Assunto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String responsavel;
	private String prazo;
	private String assunto;
	private Integer idata;
	
	public Integer getIdata() {
		return idata;
	}
	public void setIdata(Integer idata) {
		this.idata = idata;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getPrazo() {
		return prazo;
	}
	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	

}
