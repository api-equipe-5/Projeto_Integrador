package com.pi3.scorewizard.movimento;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pi3.scorewizard.fonte.Fonte;
import com.pi3.scorewizard.pessoafisica.PessoaFisica;

import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movimento {
	@Id
	private int id;

	@ManyToOne
	@JoinColumn(name="pessoaFisica_documento")
	@JsonBackReference
	private PessoaFisica pessoaFisica;

	@ManyToOne
	@JoinColumn(name="fonte_id")
	@JsonBackReference
	private Fonte fonte;

	@Nullable
	private Date dataVencimento;
	
	private int qtdParcelasAVencer;
	private int qtdParcelasAPagar;
	private Double valorFatura;
	private Double valorMinimoFatura;
	private Double valorParcela;
	private String movimentoAtual;
	private String periodo;
	private String tipoCliente;
	private String numUnc;
	
	public Movimento(){}
	
	public Movimento(int id, PessoaFisica pessoaFisica, Fonte fonte, Date dataVencimento, int qtdParcelasAVencer, int qtdParcelasAPagar,
			Double valorFatura, Double valorMinimoFatura, Double valorParcela, String movimentoAtual,
			String periodo, String tipoCliente, String numUnc) {
		super();
		this.id = id;
		this.pessoaFisica = pessoaFisica;
		this.fonte = fonte;
		this.dataVencimento = dataVencimento;
		this.qtdParcelasAVencer = qtdParcelasAVencer;
		this.qtdParcelasAPagar = qtdParcelasAPagar;
		this.valorFatura = valorFatura;
		this.valorMinimoFatura = valorMinimoFatura;
		this.valorParcela = valorParcela;
		this.movimentoAtual = movimentoAtual;
		this.periodo = periodo;
		this.tipoCliente = tipoCliente;
		this.numUnc = numUnc;
	}
	
	
}
