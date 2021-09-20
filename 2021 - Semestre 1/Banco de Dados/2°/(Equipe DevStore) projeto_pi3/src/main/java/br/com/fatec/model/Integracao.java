package br.com.fatec.model;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Integracao {
	
	private String areaArquivo;
	
	private Boolean integrado;
	
	private Timestamp dataHoraIntegracao;
	
	private Boolean extensaoDBF;
	
	private Boolean extensaoSHP;
	
	private Boolean extensaoSHX;
	
	private Boolean extensaoPRJ;
	
	private String shapeArquivo;
	
	private String municipioCodigo;
	
	public Integracao(String areaArquivo, Boolean integrado, Timestamp dataHoraIntegracao, Boolean extensaoDBF,
			Boolean extensaoSHP, Boolean extensaoSHX, Boolean extensaoPRJ, String shapeArquivo,
			String municipioCodigo) {
		this.areaArquivo = areaArquivo;
		this.integrado = integrado;
		this.dataHoraIntegracao = dataHoraIntegracao;
		this.extensaoDBF = extensaoDBF;
		this.extensaoSHP = extensaoSHP;
		this.extensaoSHX = extensaoSHX;
		this.extensaoPRJ = extensaoPRJ;
		this.shapeArquivo = shapeArquivo;
		this.municipioCodigo = municipioCodigo;
	}
	
	public Integracao() {
	}


	public String getAreaArquivo() {
		return areaArquivo;
	}

	public void setAreaArquivo(String areaArquivo) {
		this.areaArquivo = areaArquivo;
	}

	public Boolean getIntegrado() {
		return integrado;
	}

	public void setIntegrado(Boolean integrado) {
		this.integrado = integrado;
	}

	public Date getDataHoraIntegracao() {
		return dataHoraIntegracao;
	}

	public void setDataHoraIntegracao(Timestamp dataHoraIntegracao) {
		this.dataHoraIntegracao = dataHoraIntegracao;
	}

	public Boolean getExtensaoDBF() {
		return extensaoDBF;
	}

	public void setExtensaoDBF(Boolean extensaoDBF) {
		this.extensaoDBF = extensaoDBF;
	}

	public Boolean getExtensaoSHP() {
		return extensaoSHP;
	}

	public void setExtensaoSHP(Boolean extensaoSHP) {
		this.extensaoSHP = extensaoSHP;
	}

	public Boolean getExtensaoSHX() {
		return extensaoSHX;
	}

	public void setExtensaoSHX(Boolean extensaoSHX) {
		this.extensaoSHX = extensaoSHX;
	}

	public Boolean getExtensaoPRJ() {
		return extensaoPRJ;
	}

	public void setExtensaoPRJ(Boolean extensaoPRJ) {
		this.extensaoPRJ = extensaoPRJ;
	}

	public String getShapeArquivo() {
		return shapeArquivo;
	}

	public void setShape_arquivo(String shapeArquivo) {
		this.shapeArquivo = shapeArquivo;
	}

	public String getMunicipioCodigo() {
		return municipioCodigo;
	}

	public void setMunicipioCodigo(String municipioCodigo) {
		this.municipioCodigo = municipioCodigo;
	}
		
}
