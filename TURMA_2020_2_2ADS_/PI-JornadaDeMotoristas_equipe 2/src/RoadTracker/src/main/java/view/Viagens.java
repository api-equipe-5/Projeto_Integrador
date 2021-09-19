package view;

import model.Motorista;

public class Viagens {
	private int id;
	private String destino;
	private Motorista motorista;
	private String carga;
	private String prazo;
	private String situacao;
	private String nomeMotorista;
	
	public Viagens(int id, String empresaDestino, Motorista motorista, String carga, String prazo, String situacao) {
		this.id = id;
		this.destino = empresaDestino;
		this.motorista = motorista;
		this.carga = carga;
		this.prazo = prazo;
		this.situacao = situacao;
		this.nomeMotorista = this.getMotorista().getNome();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String empresaDestino) {
		this.destino = empresaDestino;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public String getCarga() {
		return carga;
	}

	public void setCarga(String carga) {
		this.carga = carga;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getNomeMotorista() {
		return nomeMotorista;
	}

	public void setNomeMotorista(String nomeMotorista) {
		this.nomeMotorista = nomeMotorista;
	}

}
