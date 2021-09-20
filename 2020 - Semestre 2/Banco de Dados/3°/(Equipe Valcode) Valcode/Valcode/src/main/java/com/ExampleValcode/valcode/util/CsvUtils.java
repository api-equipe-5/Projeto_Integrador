package com.ExampleValcode.valcode.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class CsvUtils {
    private static final String TYPE = "text/csv";


    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }
}
