package br.com.pineapple.domain;

public class TarProj {
	String nome_projeto;
	String nome_tarefa;
	
	public String getNome_projeto() {
		return nome_projeto;
	}
	public void setNome_projeto(String nome_projeto) {
		this.nome_projeto = nome_projeto;
	}
	public String getNome_tarefa() {
		return nome_tarefa;
	}
	public void setNome_tarefa(String nome_tarefa) {
		this.nome_tarefa = nome_tarefa;
	}

	//PARA CONVERTER SELECT
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String saida = nome_tarefa + " " + nome_projeto;
		return saida;
	}
	
}
