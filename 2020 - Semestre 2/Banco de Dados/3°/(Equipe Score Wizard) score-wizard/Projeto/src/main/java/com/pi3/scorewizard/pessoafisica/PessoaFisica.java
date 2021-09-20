package com.pi3.scorewizard.pessoafisica;

import java.util.List;

import javax.persistence.*;

import com.pi3.scorewizard.movimento.Movimento;
import com.pi3.scorewizard.operacao.Operacao;
import com.pi3.scorewizard.pagamento.Pagamento;

import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter
@Setter
public class PessoaFisica {
	@Id
	private String documento;
	private String nome;

	@OneToMany(mappedBy = "pessoaFisica")
	private List<Movimento> movimentos;

	@OneToMany(mappedBy = "pessoaFisica")
	private List<Operacao> operacoes;
	
	@OneToMany(mappedBy = "pessoaFisica")
	private List<Pagamento> pagamentos;
	
	private String sexo;
	private int anoNascimento;
	private String cidade;
	private String estado;
	private String senha;
	private int XP;
	
	public String getDocumento() {
		return this.documento;
	}

	public int getOperacoesCount() {
		return operacoes.size();
	}

	public int getMovimentosCount() {
		return movimentos.size();
	}

	public int getPagamentosCount() {
		return pagamentos.size();
	}

	public PessoaFisica(){}

	public PessoaFisica(String documento,String nome, String sexo, int anoNascimento, String cidade, String estado, String senha, int XP) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.senha = senha;
		this.sexo = sexo;
		this.anoNascimento = anoNascimento;
		this.cidade = cidade;
		this.estado = estado;
		this.XP = XP;
	}
	
	public PessoaFisica(String documento, String sexo, int anoNascimento, String cidade, String estado, int XP) {
		super();
		this.documento = documento;
		this.sexo = sexo;
		this.anoNascimento = anoNascimento;
		this.cidade = cidade;
		this.estado = estado;
		this.XP = XP;
	}
}
