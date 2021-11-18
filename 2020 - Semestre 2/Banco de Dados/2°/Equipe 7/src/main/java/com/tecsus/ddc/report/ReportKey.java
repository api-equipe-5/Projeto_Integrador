package com.tecsus.ddc.report;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReportKey {

    private Date start;
    private Date finish;
    private String client;
}
