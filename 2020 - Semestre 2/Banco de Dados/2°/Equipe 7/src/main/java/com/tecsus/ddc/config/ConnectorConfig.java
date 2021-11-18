package com.tecsus.ddc.config;

import com.tecsus.ddc.utils.PropertiesLoaderImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConnectorConfig {

    private final String uri;
    private final String username;
    private final String passwd;
    private final String driver;

    private ConnectorConfig() {
        final PropertiesLoaderImpl loader = new PropertiesLoaderImpl(Properties.CONNECTOR.getPropertiesFileName());

        this.driver = loader.getProperty("database.driver");
        this.uri = loader.getProperty("database.uri");
        this.username = loader.getProperty("database.user.username");
        this.passwd = loader.getProperty("database.user.password");
    }

    public static ConnectorConfig getConfig() {
        log.info("Loading configurations");
        ConnectorConfig config = new ConnectorConfig();
        log.info("Configurations loaded");
        return config;
    }

    public String getDriver() {
        return driver;
    }

    public String getUri() {
        return uri;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return passwd;
    }
}
