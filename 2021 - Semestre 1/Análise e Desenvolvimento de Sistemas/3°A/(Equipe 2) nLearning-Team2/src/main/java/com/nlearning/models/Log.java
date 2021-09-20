package com.nlearning.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Log implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLog;

	private long idUsuario;
	private String data;
	public long getIdLog() {
		return idLog;
	}
	public void setIdLog(long idLog) {
		this.idLog = idLog;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getData() {
		return data;
	}
	public void setData(String dataAtual) {
		this.data = dataAtual;
	}
}