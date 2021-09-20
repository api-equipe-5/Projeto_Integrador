package com.pi3.scorewizard.fonte;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pi3.scorewizard.movimento.Movimento;
import com.pi3.scorewizard.operacao.Operacao;
import com.pi3.scorewizard.pagamento.Pagamento;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Fonte {

	@Id
	private int id;

	private String nomeFonte;

	@OneToMany(mappedBy = "fonte")
	@JsonBackReference
	private List<Movimento> movimento;

	@OneToMany(mappedBy = "fonte")
	@JsonBackReference
	private List<Operacao> operacoes;

	@OneToMany(mappedBy = "fonte")
	private List<Pagamento> pagamentos;

	public Fonte() {
	}

	public int getId() {
		return id;
	}

	public String getNomeFonte() {
		return nomeFonte;
	}

	public void setNomeFonte(String nomeFonte) {
		this.nomeFonte = nomeFonte;
	}

	public Fonte(String nomeFonte) {
		super();
		this.setNomeFonte(nomeFonte);
	}

	public Fonte(int id, String nomeFonte) {
		super();
		this.id = id;
		this.setNomeFonte(nomeFonte);
	}
	
	
}
