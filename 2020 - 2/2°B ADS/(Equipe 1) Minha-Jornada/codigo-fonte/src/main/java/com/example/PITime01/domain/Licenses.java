package com.example.PITime01.domain;

public enum Licenses {
    A("B"),
    B("C"),
    C("D");

    public final String label;

    Licenses(String label) {
        this.label = label;
    }
}
