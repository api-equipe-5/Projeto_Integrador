package com.tecsus.ddc.product;

import lombok.Getter;

@Getter
public enum ProductType {
    WATER("Agua"),
    SEWER("Esgoto"),

    TUSD_CONSUM("TUSD - Consumo"),
    TE_CONSUM("TE - Consumo"),
    ADDITIONAL_YELLOW_FLAG("Adicional Bandeira Amarela"),
    ADDITIONAL_RED_I_FLAG("Adicional Bandeira Vermelha Patamar I"),
    ADDITIONAL_RED_II_FLAG("Adicional Bandeira Vermelha Patamar II");

    private String value;

    ProductType(String value) {
        this.value = value;
    }

    public static ProductType fromString(final String productType) {
        for (ProductType type : ProductType.values())
            if (type.value.equalsIgnoreCase(productType))
                return type;
        return null;
    }
}
