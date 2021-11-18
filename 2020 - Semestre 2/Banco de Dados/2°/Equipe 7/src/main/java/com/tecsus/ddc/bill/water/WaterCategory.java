package com.tecsus.ddc.bill.water;

import lombok.Getter;

@Getter
public enum WaterCategory {
    INDUSTRIAL("Industrial"),
    RESIDENTIAL("Residencial");

    private String value;

    WaterCategory(String value) {
        this.value = value;
    }

    public static WaterCategory fromString(final String text) {
        for (WaterCategory category : WaterCategory.values())
            if (category.value.equalsIgnoreCase(text))
                return category;
        return null;
    }
}
