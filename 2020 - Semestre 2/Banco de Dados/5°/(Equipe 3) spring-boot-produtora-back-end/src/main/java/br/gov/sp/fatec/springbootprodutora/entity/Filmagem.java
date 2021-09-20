package br.gov.sp.fatec.springbootprodutora.entity;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springbootprodutora.controller.View;

@Entity
@Table(name = "fmg_filmagem")
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverride(name = "id", column = @Column(name = "fmg_id"))

public class Filmagem extends Main {
    @JsonView(View.Filmagem.class)
	@Column (name="fmg_nome", length = 50)
	private String nome;
    
    @JsonView(View.Filmagem.class)
	@Column (name="fmg_ano")
	private Long ano;
    
    @JsonView(View.Filmagem.class)
	@Column (name="fmg_duracao")
	private float duracao;
    
    @JsonView(View.Filmagem.class)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "atu_atuacao",
			joinColumns = { @JoinColumn(name = "fmg_id") },
			inverseJoinColumns = { @JoinColumn(name = "pes_id") })
	private Set<Pessoa> pessoas;
    
    @JsonView(View.Filmagem.class)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "diretor")
	private Diretor diretor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public float getDuracao() {
		return duracao;
	}

	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}

	public Set<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Set<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}	
}
