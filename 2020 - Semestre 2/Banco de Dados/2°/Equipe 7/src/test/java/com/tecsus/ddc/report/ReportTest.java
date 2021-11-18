package com.tecsus.ddc.report;

import com.tecsus.ddc.connection.Connector;
import com.tecsus.ddc.utils.FileConverter;
import org.joda.time.DateTime;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ReportTest {

    @Test
    public void findAll() {
        Connector connector = new Connector();
        ReportController reportController = new ReportController(connector.getConnection());

        Report.createReportCharts(reportController.getReportByClient(simpleReportKey()));


        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        FileConverter.insertIntoPDF(
                "/report-line-chart.jpg",
            String.format("/report-%s.pdf", format.format(new Date())));
    }

    private ReportKey simpleReportKey() {
        DateTime start = new DateTime().withDate(2019, 1, 1);
        DateTime finish = new DateTime().withDate(2019, 12, 31);
        return ReportKey.builder()
                .start(start.toDate())
                .finish(finish.toDate())
                .client("05005727000185")
                .build();
    }
}
