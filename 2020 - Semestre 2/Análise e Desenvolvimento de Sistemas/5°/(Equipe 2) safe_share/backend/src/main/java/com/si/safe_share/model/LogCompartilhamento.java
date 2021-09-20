package com.si.safe_share.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class LogCompartilhamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dataDeInicio;
    private LocalDate dataFinal;
    private String dadoCompartilhado;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Empresa empresa;

    public LogCompartilhamento(LocalDate dataDeInicio, LocalDate dataFinal, String dadoCompartilhado, Cliente cliente, Empresa empresa) {
        this.dataDeInicio = dataDeInicio;
        this.dataFinal = dataFinal;
        this.dadoCompartilhado = dadoCompartilhado;
        this.cliente = cliente;
        this.empresa = empresa;
    }
}


