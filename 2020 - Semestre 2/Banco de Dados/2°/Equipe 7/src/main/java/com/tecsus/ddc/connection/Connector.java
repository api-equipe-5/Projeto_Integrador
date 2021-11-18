package com.tecsus.ddc.connection;

import com.tecsus.ddc.config.ConnectorConfig;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
@Getter
public class Connector {

    private final ConnectorConfig config;
    private Connection connection;

    public Connector() {
        this.config = ConnectorConfig.getConfig();
        connect();
    }

    private void connect() {
        log.info("Connecting to the database..");
        try {
            Class.forName(config.getDriver());
            log.info("Loading connection..");
            connection = DriverManager.getConnection(
                        config.getUri(),
                        config.getUsername(),
                        config.getPasswd()
                    );
            log.info("Connection Established!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            log.info("Could not connect to the database");
        }
    }
}
