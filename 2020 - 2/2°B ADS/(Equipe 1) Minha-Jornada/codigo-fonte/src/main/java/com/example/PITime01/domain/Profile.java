package com.example.PITime01.domain;

public enum Profile {
    ADMIN("Administrativo"),
    RH("Equipe RH"),
    DRIVER("Motorista"),
    USER("Usuario");

    public final String label;

    Profile(String label) {
        this.label = label;
    }
}
