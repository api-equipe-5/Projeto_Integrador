package com.si.safe_share.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ConfiguracaoCompartilhamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Cliente cliente;

    private Boolean compartilha_dados_pessoais;
    private Boolean compartilha_dados_compras;

    public ConfiguracaoCompartilhamento(Cliente cliente, Boolean compartilha_dados_pessoais, Boolean compartilha_dados_compras) {
        this.cliente = cliente;
        this.compartilha_dados_pessoais = compartilha_dados_pessoais;
        this.compartilha_dados_compras = compartilha_dados_compras;
    }
}


