package br.com.fatec.model;

public class Estado {
	
	private String codigoEstado;
	
	private String estadoSigla;
	
	private String estadoDescricao;	
	
	public Estado() {
		
	}

	public Estado(String codigoEstado, String estadoSigla, String estadoDescricao) {
		this.codigoEstado = codigoEstado;
		this.estadoSigla = estadoSigla;
		this.estadoDescricao = estadoDescricao;
	}

	public String getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public String getEstadoSigla() {
		return estadoSigla;
	}

	public void setEstadoSigla(String estadoSigla) {
		this.estadoSigla = estadoSigla;
	}

	public String getEstadoDescricao() {
		return estadoDescricao;
	}

	public void setEstadoDescricao(String estadoDescricao) {
		this.estadoDescricao = estadoDescricao;
	}

}
