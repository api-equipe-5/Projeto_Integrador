package br.com.pineapple.domain;

public class Funcionario {
	private String cpf;
	private String nome;
	private String email;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	
	//PARA CONVERTER SELECT
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String saida = cpf + " " + nome + " " + email;
		return saida;
	}
	
}
