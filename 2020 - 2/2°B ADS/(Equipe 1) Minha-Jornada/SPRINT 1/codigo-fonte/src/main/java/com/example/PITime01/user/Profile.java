package com.example.PITime01.user;

public enum Profile {
    ADMIN("Administrativo"),
    FINANCIAL("Financeiro"),
    USER("Usuario");

    public final String label;

    Profile(String label) {
        this.label = label;
    }
}
