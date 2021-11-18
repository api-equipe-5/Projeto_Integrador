package com.tecsus.ddc;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONValue;

@Slf4j
public abstract class IntegrationTest {

    protected String getJsonAsString(final String path) {
        try {
            InputStream resource = IntegrationTest.class.getResourceAsStream(String.format("/com/tecsus/ddc/jsons/%s", path));
            if (resource == null) {
                log.error("Resource Not Found");
                return "{}";
            }
            InputStreamReader inputStreamReader = new InputStreamReader(resource, "UTF-8");

            return JSONValue.parse(inputStreamReader)
                    .toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
