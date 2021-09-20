package com.example.PITime01.domain;

public enum Status {
    ACTIVE("Ativo"),
    INACTIVE("Inativo");

    public final String label;

    Status(String label) {
        this.label = label;
    }
}
