package com.tecsus.ddc.config;

/**
 * @author TOBIASDASILVALINO
 */
public enum Properties {
    CONNECTOR("database-connection.properties"),
    TRIBUTES("tributes.properties");

    private String propertiesFileName;

    Properties(final String propertiesFileName) {
        this.propertiesFileName = propertiesFileName;
    }

    public String getPropertiesFileName() {
        return propertiesFileName;
    }
}
