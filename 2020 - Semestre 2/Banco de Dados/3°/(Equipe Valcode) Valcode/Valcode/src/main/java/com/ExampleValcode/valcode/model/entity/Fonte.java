package com.ExampleValcode.valcode.model.entity;

import lombok.*;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Builder
@Table(name = "FONTE")
public class Fonte {

    @Id
    private Integer id;

    @Column(length = 50, nullable = false, name = "FONTE_NOME_COMERCIAL")
    private String fonte_nome;
}
