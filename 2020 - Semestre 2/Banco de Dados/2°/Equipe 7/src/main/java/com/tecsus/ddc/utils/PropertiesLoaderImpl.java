package com.tecsus.ddc.utils;

/**
 * @author TOBIASDASILVALINO
 */
public class PropertiesLoaderImpl {

    private PropertiesLoader loader;

    public PropertiesLoaderImpl(String properties) {
        this.loader = new PropertiesLoader(properties);
    }

    public String getProperty(String key) {
        return loader.getProperty(key);
    }
}
