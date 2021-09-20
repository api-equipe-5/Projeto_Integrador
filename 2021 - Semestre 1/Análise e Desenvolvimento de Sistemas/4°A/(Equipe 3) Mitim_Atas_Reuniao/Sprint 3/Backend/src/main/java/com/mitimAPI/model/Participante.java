package com.mitimAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Participante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String nome;
	private String cargo;
	private String area;
	private String email;
	private Long telefone;
	private Integer idata;
	private Integer idusuario;
	private String assinante;
	private String assinatura;
	private String revisao;
	
	
	
	public String getRevisao() {
		return revisao;
	}
	public void setRevisao(String revisao) {
		this.revisao = revisao;
	}
	public String getAssinante() {
		return assinante;
	}
	public void setAssinante(String assinante) {
		this.assinante = assinante;
	}
	public String getAssinatura() {
		return assinatura;
	}
	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
	}
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	

}
