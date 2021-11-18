package com.tecsus.ddc.user;

public enum Role {
    ADMIN,
    KEY_USER,
    TYPIST,
    BUSINESS_ANALYST;

    @Override
    public String toString() {
        return this.name();
    }
}
