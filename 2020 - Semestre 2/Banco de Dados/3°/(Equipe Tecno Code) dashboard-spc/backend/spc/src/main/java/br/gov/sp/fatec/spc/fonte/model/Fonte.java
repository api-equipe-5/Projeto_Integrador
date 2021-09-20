package br.gov.sp.fatec.spc.fonte.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fonte")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Fonte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fnt")
    private Long id;

    @Column(name = "nom_comercial", length = 100)
    private String nomeComercial;
}
