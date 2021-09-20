package br.gov.sp.fatec.spc.pessoafisica.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import java.io.Serializable;


@Entity
@Table(name = "pessoa_fisica")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisica implements Serializable {
    @Id
    @Column(name = "doc_cli", length = 11)
    private String id;

    @Column(name = "idc_sexo")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "ano_dat_nascimento")
    private Integer anoDatNascimento;

    @Column(name = "nom_cidade", length = 50)
    private String nomeCidade;

    @Column(name = "des_estado", length = 30)
    private String descricaoEstado;
}
