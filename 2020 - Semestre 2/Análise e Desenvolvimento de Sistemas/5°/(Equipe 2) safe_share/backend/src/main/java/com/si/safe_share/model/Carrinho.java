package com.si.safe_share.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JsonIgnore
    private Set<Produto> produtos;

    @ManyToOne
    private Cliente cliente;

    private Boolean compraFinalizada = false;

    public Carrinho(Set<Produto> produtos, Cliente cliente) {
        this.produtos = produtos;
        this.cliente = cliente;
    }
}