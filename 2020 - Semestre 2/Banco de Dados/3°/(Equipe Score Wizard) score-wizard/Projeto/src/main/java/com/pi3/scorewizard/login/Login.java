package com.pi3.scorewizard.login;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Login {
	@Id
	private String cpf;
	private String senha_usu;
	
	
	public Login(){}
	
	public Login(String cpf,String senha_usu) {
		super();
		this.senha_usu = senha_usu;
		this.cpf = cpf;
	}
}
