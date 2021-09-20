package br.com.fatec.model;

public class Municipio {
	
	private String codigoMunicipio;
	
	private String municipioDescricao;
	
	private String codigoEstado;

	public Municipio() {
		
	}
	
	public Municipio(String codigoMunicipio, String municipioDescricao) {
		this.codigoMunicipio = codigoMunicipio;
		this.municipioDescricao = municipioDescricao;
	}

	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public String getMunicipioDescricao() {
		return municipioDescricao;
	}

	public void setMunicipioDescricao(String municipioDescricao) {
		this.municipioDescricao = municipioDescricao;
	}

	public String getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

}
