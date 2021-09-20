package com.pi3.scorewizard.operacao;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pi3.scorewizard.fonte.Fonte;
import com.pi3.scorewizard.modalidade.Modalidade;
import com.pi3.scorewizard.pessoafisica.PessoaFisica;

import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Operacao {
	@Id
	private int id;

	@Nullable
	@ManyToOne
	@JoinColumn(name="pessoaFisica_documento")
	@JsonBackReference
	private PessoaFisica pessoaFisica;

	@Nullable
	@ManyToOne
	@JoinColumn(name="fonte_id")
	private Fonte fonte;

	@Nullable
	@ManyToOne
	@JoinColumn(name="modalidade_id")
	private Modalidade modalidade;
	
	private String tipoCliente;
	private String numUnc;
	private int qtdParcela;
	
	@Nullable
	private Date dataVencimentoUltimaParcela;

	@Nullable
	private Date dataContrato;
	private Double valorContratoParcelado;
	private Double valorContrato;
	private Double valorSaldoDevedor;
	
	public Operacao(){}
	
	public Operacao(int id, PessoaFisica pessoaFisica, Fonte fonte, Modalidade modalidade,
					String tipoCliente, String numUnc, int qtdParcela, Date dataVencimentoUltimaParcela,
					Date dataContrato, Double valorContratoParcelado, Double valorContrato, Double valorSaldoDevedor) {
		super();
		this.id = id;
		this.pessoaFisica = pessoaFisica;
		this.fonte = fonte;
		this.modalidade = modalidade;
		this.tipoCliente = tipoCliente;
		this.numUnc = numUnc;
		this.qtdParcela = qtdParcela;
		this.dataVencimentoUltimaParcela = dataVencimentoUltimaParcela;
		this.dataContrato = dataContrato;
		this.valorContratoParcelado = valorContratoParcelado;
		this.valorContrato = valorContrato;
		this.valorSaldoDevedor = valorSaldoDevedor;
	}
	
}
