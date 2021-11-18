package com.tecsus.ddc.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class FileConverter {

    public static void insertIntoPDF(String chart, String outputFileName) {
        try {

            PDDocument document = new PDDocument();
            PDPage page1 = new PDPage(PDPage.PAGE_SIZE_A4);
            page1.setRotation(90);
            document.addPage(page1);

            InputStream inputStream1 = new FileInputStream(chart);
            PDJpeg im1 = new PDJpeg(document, inputStream1);

            PDPageContentStream contentStream1 = new PDPageContentStream(document, page1);

            contentStream1.drawImage(im1, -10, 50);
            contentStream1.close();

            File pdf = new File(outputFileName);
            document.save(outputFileName);
        } catch (IOException | COSVisitorException e) {
            System.out.println(e);
        }
    }
}
