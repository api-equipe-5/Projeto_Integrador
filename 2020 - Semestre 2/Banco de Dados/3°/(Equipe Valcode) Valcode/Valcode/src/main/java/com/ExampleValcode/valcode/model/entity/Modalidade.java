package com.ExampleValcode.valcode.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Modalidade {
    @Id
    private String MODALIDADE_COD_MODALIDADE;

    @Column
    private String MODALIDADE_DES_MODALIDADE;


}
