package com.iacit.iacit.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="jornada_alerta")
public class JornadaAlerta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "jornada")
    private Jornadas jornada;

    @ManyToOne
    @JoinColumn(name = "alerta")
    private Alerta alerta;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private LocalDateTime data;

    public Alerta getAlerta() {
        return alerta;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Long getId() {
        return id;
    }

    public Jornadas getJornada() {
        return jornada;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setJornada(Jornadas jornada) {
        this.jornada = jornada;
    }

    

}
