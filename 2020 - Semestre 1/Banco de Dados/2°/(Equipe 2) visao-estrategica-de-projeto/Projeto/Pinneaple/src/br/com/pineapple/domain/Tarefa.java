package br.com.pineapple.domain;

public class Tarefa {
	String nome_tarefa;
	String data_inicio;
	String data_termino;
	
	public String getNome_tarefa() {
		return nome_tarefa;
	}
	public void setNome_tarefa(String nome_tarefa) {
		this.nome_tarefa = nome_tarefa;
	}
	public String getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}
	public String getData_termino() {
		return data_termino;
	}
	public void setData_termino(String data_termino) {
		this.data_termino = data_termino;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		String saida = nome_tarefa + " " + data_inicio + " " + data_termino;
		return saida;
	}
	
}
