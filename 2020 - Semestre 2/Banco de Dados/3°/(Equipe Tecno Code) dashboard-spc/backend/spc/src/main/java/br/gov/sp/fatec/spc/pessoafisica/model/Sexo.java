package br.gov.sp.fatec.spc.pessoafisica.model;

import lombok.Getter;

@Getter
public enum Sexo {
    M("M"), F("F");

    Sexo(final String sexo) {
        this.sexo = sexo;
    }

    private String sexo;
}
