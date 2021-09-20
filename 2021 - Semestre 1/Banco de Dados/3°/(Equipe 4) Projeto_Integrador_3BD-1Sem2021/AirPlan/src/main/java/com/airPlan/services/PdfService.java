package com.airPlan.services;

import com.airPlan.entities.CodeList;
import com.airPlan.entities.Pdf;
import com.airPlan.repository.CodeListRepository;
import com.airPlan.repository.ManualRepository;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PdfService {

    private final ManualRepository manualRepository;
    private final CodeListRepository codeListRepository;

    public PdfService(ManualRepository manualRepository, CodeListRepository codeListRepository) {
        this.manualRepository = manualRepository;
        this.codeListRepository = codeListRepository;
    }

    public static boolean checkIntegrity(Pdf pdf) {
        if(pdf.getMnl_name().length() == 0) {
            return false;
        } else if(pdf.getFlg_tag().length() == 0) {
            return false;
        } return pdf.getRevision().length() != 0;
    }


    public void full(final Pdf pdf) throws IOException {

        final String manualName, flgTag;
        final Integer mnlId;

        manualName = pdf.getMnl_name();
        flgTag = pdf.getFlg_tag();
        mnlId = this.manualRepository.findManualByName(pdf.getMnl_name());

        List<CodeList> listCode1 = this.codeListRepository.filtroLep(mnlId, flgTag);

        HashMap<String, ArrayList<String>> lepTable = new HashMap<>();
        ArrayList<String> coverList = new ArrayList<>();
        lepTable.put("01 Cover", coverList);
        ArrayList<String> lepList = new ArrayList<>();
        lepTable.put("02 List of Effective Pages", lepList);
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
            Stream<Path> filepath = Files.walk(Paths.get("./manuals/"+manualName+"/Master/"));
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
                        else if (tempStr.contains("02 List of Effective Pages")
                                && y.getCdl_block_name().equals("LEP") && tempStr.contains(".pdf")){
                            if (y.getCdl_code() < 10) {
                                if (tempStr.contains("02 List of Effective Pages")) {
                                    if (tempStr.contains("c0" + y.getCdl_code())) {
                                        lepTable.get("02 List of Effective Pages").add(tempStr);
                                    }
                                }
                            }
                            else if (tempStr.contains("02 List of Effective Pages")) {
                                if (tempStr.contains("c" + y.getCdl_code())) {
                                    lepTable.get("02 List of Effective Pages").add(tempStr);
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
        lepTable.forEach((key, value) -> Collections.sort(value));

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter("./manuals/"
                + manualName+flgTag+"-"+pdf.getRevision().toUpperCase()+"-FULL.pdf"));
        PdfMerger merger = new PdfMerger(pdfDoc);

        List<String> blockNames = new ArrayList<>();
        blockNames.add("01 Cover");
        blockNames.add("02 List of Effective Pages");
        blockNames.add("03 Table of Contents");
        blockNames.add("02 Story");
        blockNames.add("03 Chapter");
        blockNames.add("04 Middle");
        blockNames.add("05 General Data");
        blockNames.add("AP01 Appendix");
        blockNames.add("S03 Supplement");


        for(String s1: blockNames) {
            ArrayList<String> arr = lepTable.get(s1);

            for(Object s: arr){
                PdfDocument tempPdf = new PdfDocument(new PdfReader(String.valueOf(s)));
                merger.merge(tempPdf, 1, tempPdf.getNumberOfPages());
                tempPdf.close();
            }

        }

        pdfDoc.close();
    }

    public void delta(Pdf pdf) throws IOException {

        final String manualName, flgTag;
        final Integer mnlId;

        manualName = pdf.getMnl_name();
        flgTag = pdf.getFlg_tag();
        mnlId = this.manualRepository.findManualByName(pdf.getMnl_name());

        List<CodeList> listCode1 = this.codeListRepository.filtroLep(mnlId, flgTag);

        HashMap<String, ArrayList<String>> lepTable = new HashMap<>();
        ArrayList<String> coverList = new ArrayList<>();
        lepTable.put("01 Cover", coverList);
        ArrayList<String> lepList = new ArrayList<>();
        lepTable.put("02 List of Effective Pages", lepList);
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
            Stream<Path> filepath = Files.walk(Paths.get("./manuals/"+manualName+"/Rev/"));
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
                        else if (tempStr.contains("02 List of Effective Pages")
                                && y.getCdl_block_name().equals("LEP") && tempStr.contains(".pdf")){
                            if (y.getCdl_code() < 10) {
                                if (tempStr.contains("02 List of Effective Pages")) {
                                    if (tempStr.contains("c0" + y.getCdl_code())) {
                                        lepTable.get("02 List of Effective Pages").add(tempStr);
                                    }
                                }
                            }
                            else if (tempStr.contains("02 List of Effective Pages")) {
                                if (tempStr.contains("c" + y.getCdl_code())) {
                                    lepTable.get("02 List of Effective Pages").add(tempStr);
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
        lepTable.forEach((key, value) -> Collections.sort(value));

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter("./manuals/"
                + manualName+flgTag+"-"+pdf.getRevision().toUpperCase()+"-DELTA.pdf"));
        PdfMerger merger = new PdfMerger(pdfDoc);

        List<String> blockNames = new ArrayList<>();
        blockNames.add("01 Cover");
        blockNames.add("02 List of Effective Pages");
        blockNames.add("03 Table of Contents");
        blockNames.add("02 Story");
        blockNames.add("03 Chapter");
        blockNames.add("04 Middle");
        blockNames.add("05 General Data");
        blockNames.add("AP01 Appendix");
        blockNames.add("S03 Supplement");


        for(String s1: blockNames) {
            ArrayList<String> arr = lepTable.get(s1);

            for(Object s: arr){
                PdfDocument tempPdf = new PdfDocument(new PdfReader(String.valueOf(s)));
                merger.merge(tempPdf, 1, tempPdf.getNumberOfPages());
                tempPdf.close();
            }

        }

        pdfDoc.close();
    }

}
