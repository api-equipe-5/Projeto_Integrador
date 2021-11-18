package com.tecsus.ddc.bill.type;

import lombok.Getter;

@Getter
public enum BillType {
    WATER("Agua"),
    ENERGY("Energia");

    private String type;

    BillType(String type) {
        this.type = type;
    }

    public static BillType fromString(final String text) {
        for (BillType type : BillType.values())
            if (type.type.equalsIgnoreCase(text))
                return type;
        return null;
    }
}
