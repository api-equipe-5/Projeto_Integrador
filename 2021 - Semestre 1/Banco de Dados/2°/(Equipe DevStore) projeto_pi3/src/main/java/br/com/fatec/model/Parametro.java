package br.com.fatec.model;

public class Parametro {
	
	private String extensao;
	
	private Boolean habilitado;

	public Parametro() {
		
	}
	
	public Parametro(String extensao, Boolean habilitado) {
		this.extensao = extensao;
		this.habilitado = habilitado;
	}
	

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	

}
