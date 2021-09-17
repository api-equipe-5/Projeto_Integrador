package br.gov.sp.fatec.springbootprodutora.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springbootprodutora.controller.View;

@Entity
@Table(name = "USR_USUARIO")
public class Usuario {
    
    @JsonView(View.UsuarioCompleto.class)
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USR_ID")
    private Long id;

    @JsonView(View.UsuarioResumo.class)
	@Column(name = "USR_NOME", unique = true, length = 20, nullable = false)
    private String nome;
    
	@Column(name = "USR_SENHA", length = 100, nullable = false)
    private String senha;

    @JsonView(View.UsuarioResumo.class)
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UAU_USUARIO_AUTORIZACAO",  
                joinColumns = { @JoinColumn(name = "USR_ID") }, 
                inverseJoinColumns = { @JoinColumn(name = "AUT_ID") })
	private Set<Autorizacao> autorizacoes;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Set<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}
	public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}
}