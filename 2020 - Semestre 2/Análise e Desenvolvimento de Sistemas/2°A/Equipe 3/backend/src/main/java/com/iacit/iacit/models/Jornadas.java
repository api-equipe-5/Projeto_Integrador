package com.iacit.iacit.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="jornadas")
public class Jornadas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private LocalDateTime data_inicio;
    
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private LocalDateTime data_final;
    
    private String destino;

    @ManyToMany
    @JoinTable(name = "user_jornada",
        joinColumns = {
        @JoinColumn(name = "jornada", referencedColumnName = "id",
        nullable = false, updatable = false)},
        inverseJoinColumns = {
        @JoinColumn(name = "usuario", referencedColumnName = "matricula",
        nullable = false, updatable = false)}
    )
    private Set<Users> motorista;

    @ManyToMany
    @JoinTable(name = "veiculo_jornada",
        joinColumns = {
        @JoinColumn(name = "jornada", referencedColumnName = "id",
        nullable = false, updatable = false)},
        inverseJoinColumns = {
        @JoinColumn(name = "veiculo", referencedColumnName = "chassi",
        nullable = false, updatable = false)}
    )
    private Set<Veiculos> veiculo;

    @OneToMany(mappedBy = "jornada")
    private Set<JornadaStatus> status;

    @OneToMany(mappedBy = "jornada")
    private Set<JornadaAlerta> alerta;

    @OneToMany(mappedBy = "jornada",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Cargas> carga;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDateTime data_inicio) {
        this.data_inicio = data_inicio;
    } 

    public Set<Users> getMotorista() {
        return motorista;
    }

    public void setMotorista(Set<Users> motorista) {
        this.motorista = motorista;
    }

    public Set<Veiculos> getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Set<Veiculos> veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getData_final() {
        return data_final;
    }

    public void setData_final(LocalDateTime data_final) {
        this.data_final = data_final;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Set<JornadaStatus> getStatus() {
        return status;
    }

    public void setStatus(Set<JornadaStatus> status) {
        this.status = status;
    }

    public Set<JornadaAlerta> getAlerta() {
        return alerta;
    }

    public void setAlerta(Set<JornadaAlerta> alerta) {
        this.alerta = alerta;
    }

    public Set<Cargas> getCarga() {
        return carga;
    }

    public void setCarga(Set<Cargas> carga) {
        this.carga = carga;
    }

}
