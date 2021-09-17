package br.gov.sp.fatec.springbootprodutora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springbootprodutora.controller.View;

@Entity
@Table(name="flm_filme")
public class Filme extends Filmagem{
    
    @JsonView(View.Filme.class)
	@Column (name="flm_descricao", nullable = false, length = 100)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}