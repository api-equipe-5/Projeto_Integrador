package com.tecsus.ddc.utils;

import lombok.Getter;

@Getter
public enum  ReportKey {
    USER_REPORT("<!DOCTYPE html>" +
            "<html lang=\"en\">" +
            "<head>" +
            "    <meta charset=\"UTF-8\">" +
            "    <title>Title</title>" +
            "</head>" +
            "<body>" +
            "" +
            "</body>" +
            "</html>");

    private String text;

    ReportKey(String text) {
        this.text = text;
    }
}
