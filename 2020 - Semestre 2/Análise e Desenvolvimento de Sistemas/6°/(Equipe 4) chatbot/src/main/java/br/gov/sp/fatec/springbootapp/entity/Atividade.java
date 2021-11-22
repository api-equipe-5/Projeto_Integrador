package br.gov.sp.fatec.springbootapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springbootapp.controller.View;

import javax.persistence.JoinColumn;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usr_atividades")
public class Atividade implements Serializable{

    private static final long serialVersionUID = 1L;

    @JsonView(View.AtividadeResumo.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atv_id")
    private Long id;

    @JsonView(View.AtividadeResumo.class)
    @Column(name = "atv_titulo")
    private String titulo;

    @JsonView(View.AtividadeResumo.class)
    @Column(name = "atv_conteudo")
    private String conteudo;

    @JsonView(View.AtividadeResumo.class)
    @Column(name = "atv_data_disparo")
    @Temporal(TemporalType.DATE)
    private Date dataDisparo;
    
    @JsonView(View.AtividadeResumo.class)
    @Column(name = "atv_data_limite")
    @Temporal(TemporalType.DATE)
    private Date dataLimite;

    @JsonView(View.AtividadeResumo.class)
    @Column(name = "atv_data_conclusao")
    @Temporal(TemporalType.DATE)
    private Date dataConclusao;

    @JsonView(View.AtividadeResumo.class)
    @Column(name = "atv_status")
    private Integer status;

    @ManyToOne
    @JsonView(View.AtividadeResumo.class)
    @JoinColumn(name = "atv_remetente_id")
    private Usuario atvRemetente;
    
    @ManyToOne
    @JsonView(View.AtividadeResumo.class)
    @JoinColumn(name = "atv_destinatario_id")
    private Usuario atvDestinatario;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataDisparo() {
        return dataDisparo;
    }

    public void setDataDisparo(Date dataDisparo) {
        this.dataDisparo = dataDisparo;
    }

    public Date getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Usuario getAtvRemetente() {
        return atvRemetente;
    }

    public void setAtvRemetente(Usuario atvRemetente) {
        this.atvRemetente = atvRemetente;
    }

    public Usuario getAtvDestinatario() {
        return atvDestinatario;
    }

    public void setAtvDestinatario(Usuario atvDestinatario) {
        this.atvDestinatario = atvDestinatario;
    }

}