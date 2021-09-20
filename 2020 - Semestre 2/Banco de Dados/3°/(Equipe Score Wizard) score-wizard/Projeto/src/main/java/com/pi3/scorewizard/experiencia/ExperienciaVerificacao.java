package com.pi3.scorewizard.experiencia;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity 
public class ExperienciaVerificacao {

	@Id
	private String documentoCliente;
	private String tipoPagamento;
	private int qtd_parcelas_operacoes;
	private int qtd_parcelas_movimentos;
	private Date data_login;
	
	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public int getQtd_parcelas_operacoes() {
		return qtd_parcelas_operacoes;
	}

	public void setQtd_parcelas_operacoes(int qtd_parcelas_operacoes) {
		this.qtd_parcelas_operacoes = qtd_parcelas_operacoes;
	}

	public int getQtd_parcelas_movimentos() {
		return qtd_parcelas_movimentos;
	}

	public void setQtd_parcelas_movimentos(int qtd_parcelas_movimentos) {
		this.qtd_parcelas_movimentos = qtd_parcelas_movimentos;
	}

	public Date getData_login() {
		return data_login;
	}

	public void setData_login(Date data_login) {
		this.data_login = data_login;
	}

	public ExperienciaVerificacao(){}
	
	public ExperienciaVerificacao(String documentoCliente, String tipoPagamento, int qtd_parcelas_operacoes,
			int qtd_parcelas_movimentos, Date data_login) {
		super();
		this.documentoCliente = documentoCliente;
		this.tipoPagamento = tipoPagamento;
		this.qtd_parcelas_operacoes = qtd_parcelas_operacoes;
		this.qtd_parcelas_movimentos = qtd_parcelas_movimentos;
		this.data_login = data_login;
	}
	
	
}
