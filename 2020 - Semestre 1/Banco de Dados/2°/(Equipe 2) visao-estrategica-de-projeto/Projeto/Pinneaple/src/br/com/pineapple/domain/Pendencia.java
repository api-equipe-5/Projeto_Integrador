package br.com.pineapple.domain;

public class Pendencia {

	int id;
	String tarefa_pai;
	String tarefa_filha;
	
	
	public String getTarefa_pai() {
		return tarefa_pai;
	}


	public void setTarefa_pai(String tarefa_pai) {
		this.tarefa_pai = tarefa_pai;
	}


	public String getTarefa_filha() {
		return tarefa_filha;
	}


	public void setTarefa_filha(String tarefa_filha) {
		this.tarefa_filha = tarefa_filha;
	}


	//PARA CONVERTER SELECT
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String saida = tarefa_pai + " " + tarefa_filha;
		return saida;
	}
	
}
