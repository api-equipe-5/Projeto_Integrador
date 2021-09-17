package br.gov.sp.fatec.springbootprodutora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springbootprodutora.controller.View;

@Entity
@Table(name="nov_novela")
public class Novela extends Filmagem{
    
    
    @JsonView(View.Novela.class)
	@Column (name="nov_capitulo")
	private Long capitulo;
    
    @JsonView(View.Novela.class)
	@Column (name="nov_desc_cap", length = 100)
	private String descricaoCap;

	public Long getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Long capitulo) {
		this.capitulo = capitulo;
	}

	public String getDescricaoCap() {
		return descricaoCap;
	}

	public void setDescricaoCap(String descricaoCap) {
		this.descricaoCap = descricaoCap;
	}	
}
