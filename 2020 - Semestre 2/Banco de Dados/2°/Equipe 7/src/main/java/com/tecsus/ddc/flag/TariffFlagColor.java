package com.tecsus.ddc.flag;

import lombok.Getter;

@Getter
public enum TariffFlagColor {
    GREEN("Verde"),
    YELLOW("Amarela"),
    RED_I("Vermelha Patamar I"),
    RED_II("Vermelha Patamar II");

    private String color;

    TariffFlagColor(String color) {
        this.color = color;
    }

    public static TariffFlagColor fromString(final String color) {
        for (TariffFlagColor flag : TariffFlagColor.values())
            if (flag.color.equalsIgnoreCase(color))
                return flag;
        return null;
    }
}
