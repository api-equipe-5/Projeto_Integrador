package com.tecsus.ddc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author TOBIASDASILVALINO
 */
public class PropertiesLoader {

    private final String propertiesName;
    private Properties properties;

    private static Logger log = LoggerFactory.getLogger(PropertiesLoader.class);

    public PropertiesLoader(final String propertiesName) {
        this.propertiesName = propertiesName;
        properties = new Properties();
        load();
    }

    private void load() {
        log.info("Loading properties from file " + propertiesName);
        try {
            InputStream in = getClass().getClassLoader().getResourceAsStream(propertiesName);
            if (in == null) {
                throw new FileNotFoundException(propertiesName);
            }
            properties.load(in);
            in.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
