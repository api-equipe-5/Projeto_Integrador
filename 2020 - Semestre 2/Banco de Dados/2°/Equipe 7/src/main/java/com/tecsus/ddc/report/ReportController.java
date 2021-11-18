package com.tecsus.ddc.report;


import java.sql.Connection;
import java.util.List;

public class ReportController {

    private ReportRepository reportRepository;

    public ReportController(Connection connection) {
        this.reportRepository = new ReportRepository(connection);
    }

    public List<Report> getReportByClient(ReportKey reportKey) {
        return reportRepository.findAll(reportKey);
    }
}
