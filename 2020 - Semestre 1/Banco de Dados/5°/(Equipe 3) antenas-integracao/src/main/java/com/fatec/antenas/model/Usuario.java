package com.fatec.antenas.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Usuario {
	private String _id;
	@NotEmpty(message = "Name is mandatory")
	private String nome;
	@NotEmpty(message = "Email is mandatory")
	@Email 
	private String email;
	@NotEmpty(message = "Password is mandatory")
	private String senha;
	
	private boolean admin;
	private Boolean ativo;
	

	

	public Usuario(String _id, @NotEmpty(message = "Name is mandatory") String nome,
			@NotEmpty(message = "Email is mandatory") @Email String email,
			@NotEmpty(message = "Password is mandatory") String senha, boolean admin, Boolean ativo) {
		super();
		this._id = _id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.admin = admin;
		this.ativo = ativo;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}



	public boolean isAdmin() {
		return admin;
	}



	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	
	
}
