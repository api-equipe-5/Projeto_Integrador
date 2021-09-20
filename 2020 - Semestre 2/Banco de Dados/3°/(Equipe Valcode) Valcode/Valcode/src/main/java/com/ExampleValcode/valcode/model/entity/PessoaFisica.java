package com.ExampleValcode.valcode.model.entity;

import lombok.*;

import javax.persistence.*;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PESSOA_FISICA")
public class PessoaFisica {
    @Id
    @Column(name = "PF_DOC_CLI")
    private String doc_cli;

    @Column(name = "PF_IDC_SEXO", length = 1)
    private String idc_sexo;

    @Column(name = "pf_ano_nasc")
    private Integer ano_dat_nascimento;

    @Column(name = "pf_nome_cidade", length = 100)
    private String cidade;

    @Column(name = "pf_des_estado")
    private String estado;
}
