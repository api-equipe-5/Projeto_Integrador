package com.tecsus.ddc.report;

import com.tecsus.ddc.language.LanguageKeyValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    private BigDecimal value;
    private BigDecimal consum;
    private Date refMonth;

    public static String selectByClientName() {
        return "select db.consum, db.value, db.ref_month from ddc_bill db inner join ddc_instalation di on di.num_inst = db.instalation inner join ddc_client dc on dc.ident = di.client where (db.ref_month between ? and ?) and  dc.cl_name = ?";
    }

    public static String selectByClient() {
        return "select db.consum, db.value, db.ref_month from ddc_bill db inner join ddc_instalation di on di.num_inst = db.instalation where (db.ref_month between ? and ?) and  di.client = ?";
    }


    private static void createValueChart(List<Report> reports) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM/yyyy");
        DefaultCategoryDataset lineChartDataset = new DefaultCategoryDataset();

        for (Report report : reports) {
            lineChartDataset.setValue(report.value.longValue(), LanguageKeyValue.report_value.getText(), dateFormat.format(report.refMonth));
            lineChartDataset.setValue(report.consum.longValue(), LanguageKeyValue.report_consum.getText(), dateFormat.format(report.refMonth));
        }
        JFreeChart lineChart = ChartFactory.createLineChart(
                LanguageKeyValue.report_title.getText(),
                LanguageKeyValue.global_period.getText(),
                LanguageKeyValue.report_value_consum.getText(),
                lineChartDataset,
                PlotOrientation.VERTICAL,
                true, true, false );
        try {
            ChartUtils.saveChartAsJPEG(new File("/report-line-chart.jpg"), lineChart, 550, 300);
        } catch (Exception e) {
            System.out.println("Problem occurred creating chart.");
        }
    }


    public static void createReportCharts(List<Report> reports) {
        createValueChart(reports);
    }

    public void createUserReport() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(90, "tslino", "Contas");
        dataset.addValue(60, "Wallace", "Contas");
        dataset.addValue(120, "Ruan", "Contas");
        dataset.addValue(80, "William", "Contas");

        JFreeChart chart = ChartFactory.createBarChart(
                "Contas cadastradas no mês",
                "Digitador",
                "Contas",
                dataset, PlotOrientation.VERTICAL,
                true, true, false
        );
        BarRenderer renderer = null;
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis xAxis = plot.getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        renderer = new BarRenderer();

        try {
            ChartUtils.saveChartAsJPEG(new File("/bar-chart.jpg"), chart, 500, 300);
        } catch (Exception e) {
            System.out.println("Problem occurred creating chart.");
        }
    }
}
