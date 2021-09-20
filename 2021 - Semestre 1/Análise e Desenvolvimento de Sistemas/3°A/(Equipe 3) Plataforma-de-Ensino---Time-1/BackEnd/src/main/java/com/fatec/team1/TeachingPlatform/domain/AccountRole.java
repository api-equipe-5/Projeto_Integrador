package com.fatec.team1.TeachingPlatform.domain;

public enum AccountRole {


    PROFESSOR("Professor"),
    STUDENT("Aluno"),
    ADMIN("Administrador");

    private final String label;

    public String getLabel() {
        return label;
    }

    AccountRole(String label) {
        this.label = label;
    }

}
