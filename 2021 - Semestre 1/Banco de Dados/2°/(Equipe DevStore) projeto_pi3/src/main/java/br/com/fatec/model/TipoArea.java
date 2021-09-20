package br.com.fatec.model;

public class TipoArea {
	
	private Long tipoId;
	
	private String tipoDescricao;

	public TipoArea() {
		
	}
	
	public TipoArea(Long tipoId, String tipoDescricao) {
		this.tipoId = tipoId;
		this.tipoDescricao = tipoDescricao;
	}
		

	public String getTipoDescricao() {
		return tipoDescricao;
	}

	public void setTipoDescricao(String tipoDescricao) {
		this.tipoDescricao = tipoDescricao;
	}

	public Long getTipoId() {
		return tipoId;
	}

	public void setTipoId(Long tipoId) {
		this.tipoId = tipoId;
	}
	
}
