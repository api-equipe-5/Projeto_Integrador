package com.pi3.scorewizard.modalidade;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pi3.scorewizard.operacao.Operacao;
import com.pi3.scorewizard.pagamento.Pagamento;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Modalidade {
	@Id
	private String id;
	
	private String descricao;

	@OneToMany(mappedBy = "modalidade")
	@JsonBackReference
	private List<Operacao> operacoes;

	@OneToMany(mappedBy = "modalidade")
	@JsonBackReference
	private List<Pagamento> pagamentos;
	
	public Modalidade(){}
	
	public Modalidade(String cod, String descModalidade) {
		super();
		this.id = cod;
		this.descricao = descModalidade;
	}
	
	
}
