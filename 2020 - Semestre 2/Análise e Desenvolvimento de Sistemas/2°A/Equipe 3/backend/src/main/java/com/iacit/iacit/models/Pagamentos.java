package com.iacit.iacit.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pagamento")
public class Pagamentos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Float valor;

    private String observacao;

    private String status;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate data;
    
    @ManyToOne
    @JoinColumn(name="usuario", nullable=false)
    private Users usuario;

    public LocalDate getData() {
        return data;
    }

    public Long getId() {
        return id;
    }

    public String getObservacao() {
        return observacao;
    }

    public Users getUsuario() {
        return usuario;
    }

    public Float getValor() {
        return valor;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
