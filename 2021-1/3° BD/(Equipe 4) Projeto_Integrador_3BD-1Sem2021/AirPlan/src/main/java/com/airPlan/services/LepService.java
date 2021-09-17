package com.airPlan.services;

import com.airPlan.entities.CodeList;
import com.airPlan.entities.Lep;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
import com.itextpdf.kernel.pdf.canvas.parser.listener.SimpleTextExtractionStrategy;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

@Service
public class LepService
{
    private final ManualService manualService;
    private final CodeListService codeListService;
    private String currentRevision;

    @Autowired
    public LepService(ManualService manualService, CodeListService codeListService) {
        this.manualService = manualService;
        this.codeListService = codeListService;
        this.currentRevision = "";
    }

    public boolean checkIntegrity(Lep lep) {

        if(lep.getRevision_dates().length() == 0) {
            return false;
        } else if(lep.getCdl_code().length() == 0){
            return false;
        } else if(lep.getMnl_name().length() == 0) {
            return false;
        } else return lep.getFlg_tag().length() != 0;
    }

    public void createLep1(final Lep lep) throws IOException {
        List<String> filterRevisionDates = new ArrayList<>();
        final String[] rvParts = lep.getRevision_dates().split("-");
        for (int i = 0; i < rvParts.length; ++i) {
            StringBuilder rvFinal = new StringBuilder();
            for (int j = 0; j < rvParts[i].length(); ++j) {
                rvFinal.append(rvParts[i].charAt(j));
                if (j == 7 || j == 8) {
                    rvFinal.append(".................");
                }
                if(i == rvParts.length-1 && j <= 8) {
                    if(Character.isDigit(rvParts[i].charAt(j))) {
                        if(Character.isDigit(rvParts[i].charAt(j+1))) {
                            currentRevision+= " ";
                        } else {
                            currentRevision+=" 0";
                        }
                    }
                    currentRevision+=rvParts[i].charAt(j);
                }
            }
            filterRevisionDates.add(rvFinal.toString());
        }

        final Integer mnl_id = this.manualService.findManualByName(lep.getMnl_name());
        this.createLep2(lep, mnl_id, filterRevisionDates);
    }

    public void addCell(String block, String code, Integer page,
                        String change, Table table, Integer lastPage) {

        if (page == 1) {
            table.addCell(new Cell().add(block).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)
                    .setBorderTop(new SolidBorder(0.5f)));
            table.addCell(new Cell().add(code).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)
                    .setBorderTop(new SolidBorder(0.5f)));
            table.addCell(new Cell().add(String.valueOf(page)).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)
                    .setBorderTop(new SolidBorder(0.5f)));
            if (change.equals(currentRevision)) {
                table.addCell(new Cell().add("*").setBorder(Border.NO_BORDER)
                        .setBorderTop(new SolidBorder(0.5f)));
            } else {
                table.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)
                        .setBorderTop(new SolidBorder(0.5f)));
            }
            table.addCell(new Cell().add(change).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)
                    .setBorderTop(new SolidBorder(0.5f)));

        } else if (page == lastPage) {
            table.addCell(new Cell().add(block).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)
                    .setBorderBottom(new SolidBorder(0.5f)));
            table.addCell(new Cell().add(code).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)
                    .setBorderBottom(new SolidBorder(0.5f)));
            table.addCell(new Cell().add(String.valueOf(page)).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)
                    .setBorderBottom(new SolidBorder(0.5f)));
            if (change.equals(currentRevision)) {
                table.addCell(new Cell().add("*").setBorder(Border.NO_BORDER)
                        .setBorderBottom(new SolidBorder(0.5f)));
            } else {
                table.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)
                        .setBorderBottom(new SolidBorder(0.5f)));
            }
            table.addCell(new Cell().add(change).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)
                    .setBorderBottom(new SolidBorder(0.5f)));
        } else {
            table.addCell(new Cell().add(block).setBorder(Border.NO_BORDER)).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(code).setBorder(Border.NO_BORDER)).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(String.valueOf(page)).setBorder(Border.NO_BORDER)).setTextAlignment(TextAlignment.CENTER);
            if (change.equals(currentRevision)) {
                table.addCell(new Cell().add("*").setBorder(Border.NO_BORDER));
            }
            else {
                table.addCell(new Cell().add("").setBorder(Border.NO_BORDER)).setTextAlignment(TextAlignment.CENTER);
            }
            table.addCell(new Cell().add(change).setBorder(Border.NO_BORDER)).setTextAlignment(TextAlignment.CENTER);
        }
    }


    public void createLep2(Lep lep, final Integer mnlId,
                            List<String> filterRevisionDates) throws IOException {

        final String code, manualName, flgTag;
        code = lep.getCdl_code();
        manualName = lep.getMnl_name();
        flgTag = lep.getFlg_tag();

        List<CodeList> listCode1 = this.codeListService.filtroLep(mnlId, flgTag);
        String destPath = String.valueOf(Paths.get("./manuals/" + manualName.toUpperCase() + "-00-02c" + code + ".pdf"));
        final Paragraph paragraph1 = new Paragraph("LIST OF EFFECTIVE PAGES");
        final PdfWriter pdfWriter = new PdfWriter(destPath);
        final PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();
        final Document document = new Document(pdfDocument, PageSize.A4,false);
        document.setTopMargin(40f);
        document.add(paragraph1.setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(18.0f));
        for (Object s2 : filterRevisionDates) {
            final Paragraph temp = new Paragraph(String.valueOf(s2));
            temp.setMultipliedLeading(0.5f);
            document.add(temp.setTextAlignment(TextAlignment.CENTER).setFontSize(12.0f));
        }

        // Create and select next page
        document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));

        document.showTextAligned(new Paragraph(String.format("INTENTIONALLY BLANK")).setFontSize(14),
                300, 500, 2, TextAlignment.CENTER,
                VerticalAlignment.MIDDLE, 0);


        HashMap<String, ArrayList<String>> lepTable = new HashMap<>();
        ArrayList<String> coverList = new ArrayList<>();
        lepTable.put("01 Cover", coverList);
        ArrayList<String> tocList = new ArrayList<>();
        lepTable.put("03 Table of Contents", tocList);
        ArrayList<String> storyList = new ArrayList<>();
        lepTable.put("02 Story", storyList);
        ArrayList<String> chapterList = new ArrayList<>();
        lepTable.put("03 Chapter", chapterList);
        ArrayList<String> middleList = new ArrayList<>();
        lepTable.put("04 Middle", middleList);
        ArrayList<String> generalDataList = new ArrayList<>();
        lepTable.put("05 General Data", generalDataList);
        ArrayList<String> appendixList = new ArrayList<>();
        lepTable.put("AP01 Appendix", appendixList);
        ArrayList<String> supplementList = new ArrayList<>();
        lepTable.put("S03 Supplement", supplementList);
        try {
            Stream<Path> filepath = Files.walk(Paths.get("./manuals/" + manualName + "/Master/"));
            try {
                filepath.forEach(s -> {
                    String tempStr = s.toString();
                    for (CodeList y: listCode1) {
                        if (tempStr.contains(y.getCdl_block_name()) && tempStr.contains(".pdf")) {
                            if (y.getCdl_code() < 10) {
                                if (tempStr.contains("01 Cover")) {
                                    if (tempStr.contains("c0" + y.getCdl_code())) {
                                        lepTable.get("01 Cover").add(tempStr);
                                    }
                                }
                                else if (tempStr.contains("03 Table of Contents")) {
                                    if (tempStr.contains("c0" + y.getCdl_code())) {
                                        lepTable.get("03 Table of Contents").add(tempStr);
                                    }
                                }
                                else if (tempStr.contains("02 Story")) {
                                    if (tempStr.contains("c0" + y.getCdl_code())) {
                                        lepTable.get("02 Story").add(tempStr);
                                    }
                                }
                                else if (tempStr.contains("03 Chapter")) {
                                    if (tempStr.contains("c0" + y.getCdl_code())) {
                                        lepTable.get("03 Chapter").add(tempStr);
                                    }
                                }
                                else if (tempStr.contains("04 Middle")) {
                                    if (tempStr.contains("c0" + y.getCdl_code())) {
                                        lepTable.get("04 Middle").add(tempStr);
                                    }
                                }
                                else if (tempStr.contains("05 General Data")) {
                                    if (tempStr.contains("c0" + y.getCdl_code())) {
                                        lepTable.get("05 General Data").add(tempStr);
                                    }
                                }
                                else if (tempStr.contains("AP01 Appendix")) {
                                    if (tempStr.contains("c0" + y.getCdl_code())) {
                                        lepTable.get("AP01 Appendix").add(tempStr);
                                    }
                                }
                                else if (tempStr.contains("S03 Supplement")) {
                                    if (tempStr.contains("c0" + y.getCdl_code())) {
                                        lepTable.get("S03 Supplement").add(tempStr);
                                    }
                                }
                            }
                            else {
                                if (tempStr.contains("Cover")) {
                                    if (tempStr.contains("c" + y.getCdl_code())) {
                                        lepTable.get("01 Cover").add(tempStr);
                                    }
                                }
                                else if (tempStr.contains("03 Table of Contents")) {
                                    if (tempStr.contains("c" + y.getCdl_code())) {
                                        lepTable.get("03 Table of Contents").add(tempStr);
                                    }
                                }
                                else if (tempStr.contains("02 Story")) {
                                    if (tempStr.contains("c" + y.getCdl_code())) {
                                        lepTable.get("02 Story").add(tempStr);
                                    }
                                }
                                else if (tempStr.contains("03 Chapter")) {
                                    if (tempStr.contains("c" + y.getCdl_code())) {
                                        lepTable.get("03 Chapter").add(tempStr);
                                    }
                                }
                                else if (tempStr.contains("04 Middle")) {
                                    if (tempStr.contains("c" + y.getCdl_code())) {
                                        lepTable.get("04 Middle").add(tempStr);
                                    }
                                }
                                else if (tempStr.contains("05 General Data")) {
                                    if (tempStr.contains("c" + y.getCdl_code())) {
                                        lepTable.get("05 General Data").add(tempStr);
                                    }
                                }
                                else if (tempStr.contains("AP01 Appendix")) {
                                    if (tempStr.contains("c" + y.getCdl_code())) {
                                        lepTable.get("AP01 Appendix").add(tempStr);
                                    }
                                }
                                else if (tempStr.contains("S03 Supplement")) {
                                    if (tempStr.contains("c" + y.getCdl_code())) {
                                        lepTable.get("S03 Supplement").add(tempStr);
                                    }
                                }
                            }
                        }
                        else if (tempStr.contains("03 Table of Contents") && y.getCdl_block_name().equals("TOC") && tempStr.contains(".pdf")) {
                            if (y.getCdl_code() < 10) {
                                if (tempStr.contains("03 Table of Contents")) {
                                    if (tempStr.contains("c0" + y.getCdl_code())) {
                                        lepTable.get("03 Table of Contents").add(tempStr);
                                    }
                                }
                            }
                            else if (tempStr.contains("03 Table of Contents")) {
                                if (tempStr.contains("c" + y.getCdl_code())) {
                                    lepTable.get("03 Table of Contents").add(tempStr);
                                }
                            }
                        }
                    }
                });
                if (filepath != null) {
                    filepath.close();
                }
            }
            catch (Throwable t) {
                if (filepath != null) {
                    try {
                        filepath.close();
                    }
                    catch (Throwable exception) {
                        t.addSuppressed(exception);
                    }
                }
                throw t;
            }
        }
        catch (IOException e) {
            throw new IOException("Directory Not Present!");
        }

        // sort dict
        lepTable.forEach((key, value) -> Collections.sort(value));

        document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
        float[] columnWidths = { 60.0f, 60.0f, 60.0f, 90.0f, 60.0f };
        Table table = new Table(columnWidths);
        table.addCell(new Cell().add("Block").setBorder(Border.NO_BORDER).setBorderBottom(new SolidBorder(0.5f))
                .setBorderTop(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell().add("Code").setBorder(Border.NO_BORDER).setBorderBottom(new SolidBorder(0.5f))
                .setBorderTop(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell().add("Page").setBorder(Border.NO_BORDER).setBorderBottom(new SolidBorder(0.5f))
                .setBorderTop(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell().add("    ").setBorder(Border.NO_BORDER).setBorderBottom(new SolidBorder(0.5f))
                .setBorderTop(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell().add("Change").setBorder(Border.NO_BORDER).setBorderBottom(new SolidBorder(0.5f))
                .setBorderTop(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
        if (lepTable.get("01 Cover") != null) {
            table.addCell(new Cell().add("0-TITLE").setBorder(Border.NO_BORDER)
                    .setBorderBottom(new SolidBorder(0.5f))
                    .setBorderTop(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add("00").setBorder(Border.NO_BORDER)
                    .setBorderBottom(new SolidBorder(0.5f))
                    .setBorderTop(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add("cover").setBold().setBorder(Border.NO_BORDER)
                    .setBorderBottom(new SolidBorder(0.5f))
                    .setBorderTop(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add("*").setBorder(Border.NO_BORDER)
                    .setBorderBottom(new SolidBorder(0.5f))
                    .setBorderTop(new SolidBorder(0.5f)));
            table.addCell(new Cell().add("REVISION 06").setBorder(Border.NO_BORDER)
                    .setBorderBottom(new SolidBorder(0.5f))
                    .setBorderTop(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
        }
        for (int i = 1; i <= 4; ++i) {
            switch(i) {
                case 1:
                    table.addCell(new Cell().add("0-LEP").setBorder(Border.NO_BORDER)
                            .setBorderTop(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
                    table.addCell(new Cell().add(code).setBorder(Border.NO_BORDER)
                            .setBorderTop(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
                    table.addCell(new Cell().add(String.valueOf(i)).setBorder(Border.NO_BORDER)
                            .setBorderTop(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
                    table.addCell(new Cell().add("*").setBorder(Border.NO_BORDER)
                            .setBorderTop(new SolidBorder(0.5f)));
                    table.addCell(new Cell().add("REVISION 06").setBorder(Border.NO_BORDER)
                            .setBorderTop(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
                    break;

                case 4:
                    table.addCell(new Cell().add("0-LEP").setBorder(Border.NO_BORDER)
                            .setBorderBottom(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
                    table.addCell(new Cell().add(code).setBorder(Border.NO_BORDER)
                            .setBorderBottom(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
                    table.addCell(new Cell().add(String.valueOf(i)).setBorder(Border.NO_BORDER)
                            .setBorderBottom(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
                    table.addCell(new Cell().add("*").setBorder(Border.NO_BORDER)
                            .setBorderBottom(new SolidBorder(0.5f)));
                    table.addCell(new Cell().add("REVISION 06").setBorder(Border.NO_BORDER)
                            .setBorderBottom(new SolidBorder(0.5f)).setTextAlignment(TextAlignment.CENTER));
                    break;

                default:
                    table.addCell(new Cell().add("0-LEP").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
                    table.addCell(new Cell().add(code).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
                    table.addCell(new Cell().add(String.valueOf(i)).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
                    table.addCell(new Cell().add("*").setBorder(Border.NO_BORDER));
                    table.addCell(new Cell().add("REVISION 06").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
                    break;
            }
        }

        for (int j = 0; j < lepTable.get("03 Table of Contents").size(); ++j) {
            String path = String.valueOf(lepTable.get("03 Table of Contents").get(j));
            PdfReader pdfReader = new PdfReader(path);
            PdfDocument doc1 = new PdfDocument(pdfReader);
            for (int n2 = doc1.getNumberOfPages(), k = 1; k <= n2; ++k) {
                String text = PdfTextExtractor.getTextFromPage(doc1.getPage(k), new SimpleTextExtractionStrategy());
                String[] textParts = text.split("\n");
                ArrayList<String> textPartsf = new ArrayList<>();
                for (final String x1 : textParts) {
                    if (!x1.equals(" ") && !x1.equals("\\n")) {
                        textPartsf.add(x1);
                    }
                }
                String x2 = textPartsf.get(2) + textPartsf.get(3);
                String[] x3 = x2.split(" ");
                final String block, code2, change;
                block = x3[1];
                if (k % 2 == 0) {
                    code2 = x3[6];
                    change = x3[7];
                } else {
                    code2 = x3[4];
                    change = x3[2];
                }
                addCell(block, code2, k, change, table, n2);
            }
            pdfReader.close();
            doc1.close();
        }
        for (int j = 0; j < lepTable.get("02 Story").size(); ++j) {
            PdfReader pdfReader2 = new PdfReader(String.valueOf(lepTable.get("02 Story").get(j)));
            PdfDocument doc2 = new PdfDocument(pdfReader2);
            for (int n3 = doc2.getNumberOfPages(), l = 1; l <= n3; ++l) {
                String text2 = PdfTextExtractor.getTextFromPage(doc2.getPage(l), new SimpleTextExtractionStrategy());
                String[] textParts2 = text2.split("\n");
                ArrayList<String> textPartsf2 = new ArrayList<>();
                for (final String x4 : textParts2) {
                    if (!x4.equals(" ")) {
                        textPartsf2.add(x4);
                    }
                }
                String x5 = textPartsf2.get(0) + textPartsf2.get(1);
                String[] x6 = x5.split(" ");
                final String block2, code3, change2;
                if (l % 2 == 0) {
                    if (x6.length == 9) {
                        block2 = x6[1];
                        code3 = x6[6];
                        change2 = x6[7] + " " + x6[8];
                        addCell(block2, code3, l, change2, table, n3);
                    }
                    else {
                        block2 = x6[1];
                        code3 = x6[6];
                        change2 = x6[7];
                        addCell(block2, code3, l, change2, table, n3);
                    }
                }
                else if (x6.length == 9) {
                    block2 = x6[1];
                    code3 = x6[6];
                    change2 = x6[3] + " " + x6[4];
                    addCell(block2, code3, l, change2, table, n3);
                }
                else if (x6.length == 8) {
                    block2 = x6[1];
                    code3 = x6[4];
                    change2 = x6[2];
                    addCell(block2, code3, l, change2, table, n3);
                }
            }
            pdfReader2.close();
            doc2.close();
        }
        for (int j = 0; j < lepTable.get("03 Chapter").size(); ++j) {
            PdfReader pdfReader2 = new PdfReader(String.valueOf(lepTable.get("03 Chapter").get(j)));
            PdfDocument doc2 = new PdfDocument(pdfReader2);
            for (int n3 = doc2.getNumberOfPages(), l = 1; l <= n3; ++l) {
                String text2 = PdfTextExtractor.getTextFromPage(doc2.getPage(l), new SimpleTextExtractionStrategy());
                String[] textParts2 = text2.split("\n");
                ArrayList<String> textPartsf2 = new ArrayList<>();
                for (final String x4 : textParts2) {
                    if (!x4.equals(" ")) {
                        textPartsf2.add(x4);
                    }
                }
                String x5 = textPartsf2.get(0) + textPartsf2.get(1);
                String[] x6 = x5.split(" ");
                final String block2, code3, change2;
                if (l % 2 == 0) {
                    if (x6.length == 9) {
                        block2 = x6[1];
                        code3 = x6[6];
                        change2 = x6[7] + " " + x6[8];
                        addCell(block2, code3, l, change2, table, n3);
                    }
                    else {
                        block2 = x6[1];
                        code3 = x6[6];
                        change2 = x6[7];
                        addCell(block2, code3, l, change2, table, n3);
                    }
                }
                else if (x6.length == 9) {
                    block2 = x6[1];
                    code3 = x6[6];
                    change2 = x6[3] + " " + x6[4];
                    addCell(block2, code3, l, change2, table, n3);
                }
                else if (x6.length == 8) {
                    block2 = x6[1];
                    code3 = x6[4];
                    change2 = x6[2];
                    addCell(block2, code3, l, change2, table, n3);
                }
            }
            pdfReader2.close();
            doc2.close();
        }
        for (int j = 0; j < lepTable.get("04 Middle").size(); ++j) {
            final PdfReader pdfReader2 = new PdfReader(String.valueOf(lepTable.get("04 Middle").get(j)));
            final PdfDocument doc2 = new PdfDocument(pdfReader2);
            for (int n3 = doc2.getNumberOfPages(), l = 1; l <= n3; ++l) {
                final String text2 = PdfTextExtractor.getTextFromPage(doc2.getPage(l), new SimpleTextExtractionStrategy());
                final String[] textParts2 = text2.split("\n");
                final ArrayList<String> textPartsf2 = new ArrayList<>();
                for (final String x4 : textParts2) {
                    if (!x4.equals(" ")) {
                        textPartsf2.add(x4);
                    }
                }
                final String x5 = textPartsf2.get(0) + textPartsf2.get(1);
                final String[] x6 = x5.split(" ");
                final String block2, code3, change2;
                if (l % 2 == 0) {
                    if (x6.length == 9) {
                        block2 = x6[1];
                        code3 = x6[6];
                        change2 = x6[7] + " " + x6[8];
                        addCell(block2, code3, l, change2, table, n3);
                    }
                    else {
                        block2 = x6[1];
                        code3 = x6[6];
                        change2 = x6[7];
                        addCell(block2, code3, l, change2, table, n3);
                    }
                }
                else if (x6.length == 9) {
                    block2 = x6[1];
                    code3 = x6[6];
                    change2 = x6[3] + " " + x6[4];
                    addCell(block2, code3, l, change2, table, n3);
                }
                else if (x6.length == 8) {
                    block2 = x6[1];
                    code3 = x6[4];
                    change2 = x6[2];
                    addCell(block2, code3, l, change2, table, n3);
                }
            }
            pdfReader2.close();
            doc2.close();
        }

        for (int j = 0; j < lepTable.get("05 General Data").size(); ++j) {
            final PdfReader pdfReader2 = new PdfReader(String.valueOf(lepTable.get("05 General Data").get(j)));
            final PdfDocument doc2 = new PdfDocument(pdfReader2);
            for (int n3 = doc2.getNumberOfPages(), l = 1; l <= n3; ++l) {
                final String text2 = PdfTextExtractor.getTextFromPage(doc2.getPage(l), new SimpleTextExtractionStrategy());
                final String[] textParts2 = text2.split("\n");
                final ArrayList<String> textPartsf2 = new ArrayList<>();
                for (final String x4 : textParts2) {
                    if (!x4.equals(" ")) {
                        textPartsf2.add(x4);
                    }
                }
                if(textPartsf2.get(0).charAt(1) == '5') {

                    String x5 = textPartsf2.get(0) + textPartsf2.get(1);

                    final String[] x6 = x5.split(" ");
                    if(l%2!=0) {
                        if (x6.length == 9) {
                            final String block2 = x6[1];
                            final String code3 = x6[6];
                            final String change2 = x6[3] + " " + x6[4];
                            addCell(block2, code3, l, change2, table, n3);
                        } else if (x6.length == 8) {
                            final String block2 = x6[1];
                            final String code3 = x6[5];
                            final String change2 = x6[6];
                            addCell(block2, code3, l, change2, table, n3);
                        }
                    } else {
                        if (x6.length == 9) {
                            final String block2 = x6[1];
                            final String code3 = x6[6];
                            final String change2 = x6[7] + " " + x6[8];
                            addCell(block2, code3, l, change2, table, n3);
                        } else if (x6.length == 8) {
                            final String block2 = x6[1];
                            final String code3 = x6[6];
                            final String change2 = x6[7];
                            addCell(block2, code3, l, change2, table, n3);
                        }
                    }

                } else {
                    String x5;
                    if (l % 2 == 0) {
                        if (textPartsf2.size() > 3) {
                            x5 = textPartsf2.get(2) + textPartsf2.get(3);
                        }
                        else {
                            x5 = textPartsf2.get(0) + textPartsf2.get(1);
                        }
                    } else {
                        if (textPartsf2.size() > 3) {
                            x5 = textPartsf2.get(1) + textPartsf2.get(2);
                        }
                        else {
                            x5 = textPartsf2.get(0) + textPartsf2.get(1);
                        }
                    }
                    final String[] x6 = x5.split(" ");
                    if (l % 2 == 0) {
                        if (x6.length == 9) {
                            final String block2 = x6[1];
                            final String code3 = x6[6];
                            final String change2 = x6[7] + " " + x6[8];
                            addCell(block2, code3, l, change2, table, n3);
                        }
                        else if (x6.length == 8) {
                            final String block2 = x6[1];
                            final String code3 = x6[5];
                            final String change2 = x6[3];
                            addCell(block2, code3, l, change2, table, n3);
                        }
                    }
                    else if (x6.length == 9) {
                        final String block2 = x6[1];
                        final String code3 = x6[6];
                        final String change2 = x6[3] + " " + x6[6];
                        addCell(block2, code3, l, change2, table, n3);
                    }
                    else if (x6.length == 8) {
                        final String block2 = x6[1];
                        final String code3 = x6[5];
                        final String change2 = x6[3];
                        addCell(block2, code3, l, change2, table, n3);
                    }
                }
            }
            pdfReader2.close();
            doc2.close();
        }
        for (int j = 0; j < lepTable.get("AP01 Appendix").size(); ++j) {
            final PdfReader pdfReader2 = new PdfReader(String.valueOf(lepTable.get("AP01 Appendix").get(j)));
            final PdfDocument doc2 = new PdfDocument(pdfReader2);
            for (int n3 = doc2.getNumberOfPages(), l = 1; l <= n3; ++l) {
                final String text2 = PdfTextExtractor.getTextFromPage(doc2.getPage(l), new SimpleTextExtractionStrategy());
                final String[] textParts2 = text2.split("\n");
                final ArrayList<String> textPartsf2 = new ArrayList<>();
                for (final String x4 : textParts2) {
                    if (!x4.equals(" ")) {
                        textPartsf2.add(x4);
                    }
                }
                final String x5 = textPartsf2.get(1) + textPartsf2.get(2);
                final String[] x6 = x5.split(" ");
                final String block2, code3, change2;
                if (l % 2 == 0) {
                    if (x6.length == 9) {
                        block2 = x6[1];
                        code3 = x6[6];
                        change2 = x6[7] + " " + x6[8];
                        addCell(block2, code3, l, change2, table, n3);
                    }
                    else {
                        block2 = x6[1];
                        code3 = x6[6];
                        change2 = x6[7];
                        addCell(block2, code3, l, change2, table, n3);
                    }
                }
                else if (x6.length == 9) {
                    block2 = x6[1];
                    code3 = x6[6];
                    change2 = x6[3] + " " + x6[4];
                    addCell(block2, code3, l, change2, table, n3);
                }
                else if (x6.length == 8) {
                    block2 = x6[1];
                    code3 = x6[4];
                    change2 = x6[2];
                    addCell(block2, code3, l, change2, table, n3);
                }
            }
            pdfReader2.close();
            doc2.close();
        }
        for (int j = 0; j < lepTable.get("S03 Supplement").size(); ++j) {
            final PdfReader pdfReader2 = new PdfReader(String.valueOf(lepTable.get("S03 Supplement").get(j)));
            final PdfDocument doc2 = new PdfDocument(pdfReader2);
            for (int n3 = doc2.getNumberOfPages(), l = 1; l <= n3; ++l) {
                final String text2 = PdfTextExtractor.getTextFromPage(doc2.getPage(l), new SimpleTextExtractionStrategy());
                final String[] textParts2 = text2.split("\n");
                final ArrayList<String> textPartsf2 = new ArrayList<>();
                for (final String x4 : textParts2) {
                    if (!x4.equals(" ")) {
                        textPartsf2.add(x4);
                    }
                }
                final String x5 = textPartsf2.get(1) + textPartsf2.get(2);
                final String[] x6 = x5.split(" ");
                final String block2, code3, change2;
                if (l % 2 == 0) {
                    if (x6.length == 9) {
                        block2 = x6[1];
                        code3 = x6[6];
                        change2 = x6[7] + " " + x6[8];
                        addCell(block2, code3, l, change2, table, n3);
                    }
                    else {
                        block2 = x6[1];
                        code3 = x6[6];
                        change2 = x6[7];
                        addCell(block2, code3, l, change2, table, n3);
                    }
                }
                else if (x6.length == 9) {
                    block2 = x6[1];
                    code3 = x6[6];
                    change2 = x6[3] + " " + x6[4];
                    addCell(block2, code3, l, change2, table, n3);
                }
                else if (x6.length == 8) {
                    block2 = x6[1];
                    code3 = x6[4];
                    change2 = x6[2];
                    addCell(block2, code3, l, change2, table, n3);
                }
            }
            pdfReader2.close();
            doc2.close();
        }


        document.add(table.setHorizontalAlignment(HorizontalAlignment.CENTER).setMarginBottom(30));

        createDetails(document, pdfDocument, manualName, code);

        document.flush();
        pdfDocument.close();
        pdfWriter.close();
        document.close();
    }

    public void createDetails(Document document, PdfDocument pdfDocument, String manualName, String code) {
        SolidLine line = new SolidLine(1f);
        LineSeparator ls= new LineSeparator(line);

        for(int i=1;i<=pdfDocument.getNumberOfPages();i++) {
            ls.setFixedPosition(i, 550f, 20f, 800f);
            document.add(ls);

            if(i%2 == 0) {
                document.showTextAligned(new Paragraph(String
                                .format("Page " + i)).setFontSize(14),
                        100, 20, i, TextAlignment.RIGHT,
                        VerticalAlignment.BOTTOM, 0);

                document.showTextAligned(new Paragraph(String.format("List of Effective Pages")),
                        50, 830, i, TextAlignment.LEFT,
                        VerticalAlignment.TOP, 0);

                document.showTextAligned(new Paragraph(String.format(manualName)).setFontSize(8),
                        560, 80, i, TextAlignment.LEFT,
                        VerticalAlignment.BOTTOM, 300);

                document.showTextAligned(new Paragraph(String.format("0-LEP")).setBold().setFontSize(16),
                        300, 60, i, TextAlignment.CENTER,
                        VerticalAlignment.TOP, 0);

                document.showTextAligned(new Paragraph(String.format("Code " + code)).setFontSize(14),
                        300, 35, i, TextAlignment.CENTER,
                        VerticalAlignment.TOP, 0);

                document.showTextAligned(new Paragraph(String
                                .format(currentRevision)).setFontSize(14),
                        550, 20, i, TextAlignment.RIGHT,
                        VerticalAlignment.BOTTOM, 0);

            } else {
                document.showTextAligned(new Paragraph(String
                                .format("Page " + i )).setFontSize(14),
                        550, 20, i, TextAlignment.RIGHT,
                        VerticalAlignment.BOTTOM, 0);

                document.showTextAligned(new Paragraph(String.format("List of Effective Pages")),
                        560, 830, i, TextAlignment.RIGHT,
                        VerticalAlignment.TOP, 0);

                document.showTextAligned(new Paragraph(String.format(manualName)).setFontSize(8),
                        50, 80, i, TextAlignment.LEFT,
                        VerticalAlignment.TOP, 300);

                document.showTextAligned(new Paragraph(String.format("0-LEP")).setBold().setFontSize(16),
                        300, 60, i, TextAlignment.CENTER,
                        VerticalAlignment.TOP, 0);

                document.showTextAligned(new Paragraph(String.format("Code " + code)).setFontSize(14),
                        300, 35, i, TextAlignment.CENTER,
                        VerticalAlignment.TOP, 0);

                document.showTextAligned(new Paragraph(String
                                .format(currentRevision)).setFontSize(14),
                        50, 20, i, TextAlignment.LEFT,
                        VerticalAlignment.BOTTOM, 0);
            }
        }

        this.currentRevision = "";
    }

}
