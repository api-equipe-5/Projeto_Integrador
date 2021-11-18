package com.tecsus.ddc.report.graph;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ChartTest {

    @Test
    public void create() {
        DefaultCategoryDataset lineChartDataset = new DefaultCategoryDataset();
        lineChartDataset.setValue(200, "Consumo", "Jan");
        lineChartDataset.setValue(210, "Consumo", "Fev");
        lineChartDataset.setValue(250, "Consumo", "Mar");
        lineChartDataset.setValue(310, "Consumo", "Abr");
        lineChartDataset.setValue(200, "Consumo", "Mai");
        lineChartDataset.setValue(150, "Consumo", "Jun");
        lineChartDataset.setValue(160, "Consumo", "Jul");
        lineChartDataset.setValue(180, "Consumo", "Ago");
        lineChartDataset.setValue(210, "Consumo", "Set");
        lineChartDataset.setValue(240, "Consumo", "Out");
        lineChartDataset.setValue(300, "Consumo", "Nov");
        lineChartDataset.setValue(250, "Consumo", "Dez");
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Consumo por mês",
                "Consumo",
                "Mês",
                lineChartDataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );
        try {
            ChartUtils.saveChartAsJPEG(new File("/line-chart.jpg"), lineChart, 500, 300);
        } catch (Exception e) {
            System.out.println("Problem occurred creating chart.");
        }
    }

    @Test
    public void createUserReport() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(90, "tslino", "Contas");
        dataset.addValue(60, "Wallace", "Contas");
        dataset.addValue(120, "Ruan", "Contas");
        dataset.addValue(80, "William", "Contas");

        JFreeChart barChart = ChartFactory.createBarChart(
                "Contas cadastradas no mês",
                "Digitador",
                "Contas",
                dataset, PlotOrientation.VERTICAL,
                true, true, false
        );

        try {
            ChartUtils.saveChartAsJPEG(new File("/bar-chart.jpg"), barChart, 500, 300);
        } catch (Exception e) {
            System.out.println("Problem occurred creating chart.");
        }
    }

    @Test
    public void insertIntoPDF() {
        try {

            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDPage.PAGE_SIZE_A4);
            document.addPage(page);

            InputStream input1 = new FileInputStream(new File("/line-chart.jpg"));
            PDJpeg img1 = new PDJpeg(document, input1);

            InputStream input2 = new FileInputStream(new File("/bar-chart.jpg"));
            PDJpeg img2 = new PDJpeg(document, input2);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.drawImage(img1, 10, 30);
            contentStream.drawImage(img2, 10, 400);
            contentStream.close();

            File pdf = new File("/image.pdf");
            document.save("/image.pdf");
        } catch (IOException | COSVisitorException e) {
            System.out.println(e);
        }
    }
}
