package br.com.fatec.springbootpi.entity;

import java.util.Date;
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

import br.com.fatec.springbootpi.controller.View;

@Entity
@Table(name = "atividade")
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atividade")
    @JsonView(View.AtividadeResumo.class)
    private Long idAtividade;

    @JsonView(View.AtividadeResumo.class)
    @Column(name = "titulo_atividade")
    private String tituloAtividade;

    @JsonView(View.AtividadeResumo.class)
    @Column(name = "desc_atividade")
    private String descAtividade;

    @JsonView(View.AtividadeResumo.class)
    @Column(name = "cor_atividade")
    private String corAtividade;

    @Column(name = "data_criado")
    private Date dataCriado;

    @JsonView(View.AtividadeResumo.class)
    @Column(name = "data_prevista")
    private Date dataPrevista;

    @JsonView(View.AtividadeResumo.class)
    @Column(name = "data_fechamento")
    private Date dataFechamento;

    @JsonView(View.AtividadeResumo.class)
    @Column(name = "atividade_aberta")
    private Boolean atividadeAberta;

    @JsonView(View.AtividadeResumo.class)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_atividade",
    joinColumns = { @JoinColumn(name = "id_atividade") },
    inverseJoinColumns = { @JoinColumn(name = "id_usuario") })
    private Set<Usuario> usuarios;

    public Long getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Long idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getTituloAtividade() {
        return tituloAtividade;
    }

    public void setTituloAtividade(String tituloAtividade) {
        this.tituloAtividade = tituloAtividade;
    }

    public String getDescAtividade() {
        return descAtividade;
    }

    public void setDescAtividade(String descAtividade) {
        this.descAtividade = descAtividade;
    }

    public String getCorAtividade() {
        return corAtividade;
    }

    public void setCorAtividade(String corAtividade) {
        this.corAtividade = corAtividade;
    }

    public Date getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(Date dataCriado) {
        this.dataCriado = dataCriado;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

	public Date getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(Date dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Boolean getAtividadeAberta() {
        return atividadeAberta;
    }

    public void setAtividadeAberta(Boolean atividadeAberta) {
        this.atividadeAberta = atividadeAberta;
    }
}