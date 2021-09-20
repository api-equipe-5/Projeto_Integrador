package com.mitimAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Ata {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String numero;
	private String data;
	private String tema;
	private String inicio;
	private String fim;
	private String local;
	private String pauta;
	private String criador;
	private String datacriacao;
	private String aprovacao;
	private String status;
	private String prazo;
	private String codassinatura;

	public String getCodassinatura() {
		return codassinatura;
	}
	public void setCodassinatura(String codassinatura) {
		this.codassinatura = codassinatura;
	}
	public String getPrazo() {
		return prazo;
	}
	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAprovacao() {
		return aprovacao;
	}
	public void setAprovacao(String aprovacao) {
		this.aprovacao = aprovacao;
	}
	public String getCriador() {
		return criador;
	}
	public void setCriador(String criador) {
		this.criador = criador;
	}
	public String getDatacriacao() {
		return datacriacao;
	}
	public void setDatacriacao(String datacriacao) {
		this.datacriacao = datacriacao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getPauta() {
		return pauta;
	}
	public void setPauta(String pauta) {
		this.pauta = pauta;
	}


	
	

}
