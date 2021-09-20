package br.com.pineapple.domain;

public class TarFunc {
	String nome_tarefa;
	String cpf;
	
	public String getNome_tarefa() {
		return nome_tarefa;
	}
	public void setNome_tarefa(String nome_tarefa) {
		this.nome_tarefa = nome_tarefa;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		String saida = nome_tarefa + " " + cpf;
		return saida;
	}
		
}
