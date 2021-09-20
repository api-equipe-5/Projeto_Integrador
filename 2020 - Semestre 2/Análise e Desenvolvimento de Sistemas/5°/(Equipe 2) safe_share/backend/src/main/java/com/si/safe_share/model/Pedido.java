package com.si.safe_share.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Carrinho carrinho;

    private LocalDateTime dataDoPedido;

    private BigDecimal valorTotal;

    public Pedido(Cliente cliente, Carrinho carrinho, LocalDateTime dataDoPedido) {
        this.cliente = cliente;
        this.carrinho = carrinho;
        this.dataDoPedido = dataDoPedido;
    }
}


