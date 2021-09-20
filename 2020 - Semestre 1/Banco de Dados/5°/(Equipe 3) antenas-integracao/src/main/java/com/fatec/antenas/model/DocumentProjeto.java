package com.fatec.antenas.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Projeto")
public class DocumentProjeto {
	@Id
	private String _id;
	private String chave;
	private String titulo;
	private String descricaoBreve;
	private String descricaoCompleta;
	private String descricaoTecnologica;
	private String linkExterno1;
	private String linkExterno2;
	private Integer fase;
	private Reuniao reuniao;
	private Status status;
	private Set<String> entregas = new HashSet<String>();
	private String responsavelCadi;
	private String responsavelEmpresario;
	private Set<String> responsavelProfessor = new HashSet<String>();
	private Set<String> alunos = new HashSet<String>();
	
	

	
	public DocumentProjeto() {
		super();
	}
	
	public DocumentProjeto(String titulo, String descricaoBreve, String descricaoCompleta, String descricaoTecnologica,
			String linkExterno1, String linkExterno2, Integer fase, Status status, String responsavelEmpresario) {
		super();
		this.titulo = titulo;
		this.descricaoBreve = descricaoBreve;
		this.descricaoCompleta = descricaoCompleta;
		this.descricaoTecnologica = descricaoTecnologica;
		this.linkExterno1 = linkExterno1;
		this.linkExterno2 = linkExterno2;
		this.fase = fase;
		this.status = status;
		this.responsavelEmpresario = responsavelEmpresario;
		this.responsavelCadi = null;
		
	}	

	public DocumentProjeto(String _id, String chave, String titulo, String descricaoBreve, String descricaoCompleta,
			String descricaoTecnologica, String linkExterno1, String linkExterno2, Integer fase, Reuniao reuniao,
			Status status, Set<String> entregas, String responsavelCadi, String responsavelEmpresario,
			Set<String> responsavelProfessor, Set<String> alunos) {
		super();
		this._id = _id;
		this.chave = chave;
		this.titulo = titulo;
		this.descricaoBreve = descricaoBreve;
		this.descricaoCompleta = descricaoCompleta;
		this.descricaoTecnologica = descricaoTecnologica;
		this.linkExterno1 = linkExterno1;
		this.linkExterno2 = linkExterno2;
		this.fase = fase;
		this.reuniao = reuniao;
		this.status = status;
		this.entregas = entregas;
		this.responsavelCadi = responsavelCadi;
		this.responsavelEmpresario = responsavelEmpresario;
		this.responsavelProfessor = responsavelProfessor;
		this.alunos = alunos;
	}

	public Set<String> getEntregas() {
		return entregas;
	}

	public void setEntregas(Set<String> entregas) {
		this.entregas = entregas;
	}

	public Set<String> getResponsavelProfessor() {
		return responsavelProfessor;
	}

	public void setResponsavelProfessor(Set<String> responsavelProfessor) {
		this.responsavelProfessor = responsavelProfessor;
	}

	public Set<String> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<String> alunos) {
		this.alunos = alunos;
	}

	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricaoBreve() {
		return descricaoBreve;
	}
	public void setDescricaoBreve(String descricaoBreve) {
		this.descricaoBreve = descricaoBreve;
	}
	public String getDescricaoCompleta() {
		return descricaoCompleta;
	}
	public void setDescricaoCompleta(String descricaoCompleta) {
		this.descricaoCompleta = descricaoCompleta;
	}
	public String getDescricaoTecnologica() {
		return descricaoTecnologica;
	}
	public void setDescricaoTecnologica(String descricaoTecnologica) {
		this.descricaoTecnologica = descricaoTecnologica;
	}
	public String getLinkExterno1() {
		return linkExterno1;
	}
	public void setLinkExterno1(String linkExterno1) {
		this.linkExterno1 = linkExterno1;
	}
	public String getLinkExterno2() {
		return linkExterno2;
	}
	public void setLinkExterno2(String linkExterno2) {
		this.linkExterno2 = linkExterno2;
	}
	public Integer getFase() {
		return fase;
	}
	public void setFase(Integer fase) {
		this.fase = fase;
	}
	
	public Reuniao getReuniao() {
		return reuniao;
	}

	public void setReuniao(Reuniao reuniao) {
		this.reuniao = reuniao;
	}

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getResponsavelCadi() {
		return responsavelCadi;
	}
	public void setResponsavelCadi(String responsavelCadi) {
		this.responsavelCadi = responsavelCadi;
	}
	public String getResponsavelEmpresario() {
		return responsavelEmpresario;
	}
	public void setResponsavelEmpresario(String responsavelEmpresario) {
		this.responsavelEmpresario = responsavelEmpresario;
	}
	
}
