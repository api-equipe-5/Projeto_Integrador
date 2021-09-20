package com.airPlan.services;

import com.airPlan.entities.CodeList;
import com.airPlan.entities.Flag;
import com.airPlan.entities.Manual;
import com.airPlan.entities.User;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;

@Service
@Transactional
public class ImportCodeList {

    @Autowired
    private ManualService manualService;
    @Autowired
    private FlagService flagService;
    @Autowired
    private CodeListService codeListService;


    /*public void trimCodeList(CodeList codeList) {

        codeList.setFlg_secundary(codeList.getFlg_secundary().trim());
        codeList.setCdl_section(codeList.getCdl_section().trim());
        codeList.setCdl_sub_section(codeList.getCdl_sub_section().trim());
        codeList.setCdl_block_name(codeList.getCdl_block_name().trim());
    }*/

    public void getCellData(String manualName, String fileName, User user) {
        try {
            String excelPath = "./uploads/" + fileName;
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
            XSSFSheet sheet = workbook.getSheet("Jedi Codex");

            int n = getRowCount(workbook);

            DataFormatter formatter1 = new DataFormatter();
            ArrayList<String> tags = new ArrayList<>();
            ArrayList<String> tagNames = new ArrayList<>();

            /* Manual Name */
            Manual manual = new Manual(manualName.trim());
            manualService.save(manual);
            manual.setMnl_id(manualService.findManualByName(manual.getMnl_name()));


            String tagName = ".";
            int count = 7;
            while (true) {
                tagName = formatter1.formatCellValue(sheet.getRow(1).getCell(count));
                count++;
                if(tagName.equals("")) {
                    break;
                }
                tagNames.add(tagName);

            }

            for (String s : tagNames) {
                String[] parts = s.split(" - ");
                Flag flag = new Flag("-" + parts[0], parts[1]);
                tags.add("-" + parts[0]);
                flagService.save(flag, manual.getMnl_id());
            }

            for (int i = 2; i < n; i++) {
                DataFormatter formatter = new DataFormatter();
                count = 0;
                for (int j = 7; j < 7 + tags.size(); j++,count++) {
                    if (formatter.formatCellValue(sheet.getRow(i).getCell(j)).equals("1")) {
                        CodeList codeList = new CodeList(manual.getMnl_id(),
                                tags.get(count), formatter.formatCellValue(sheet.getRow(i).getCell(1)),
                                Integer.parseInt(formatter.formatCellValue(sheet.getRow(i).getCell(3))),
                                formatter.formatCellValue(sheet.getRow(i).getCell(2)).equals("")
                                        ? null : formatter.formatCellValue(sheet.getRow(i).getCell(2)),
                                formatter.formatCellValue(sheet.getRow(i).getCell(4)),
                                Integer.parseInt(formatter.formatCellValue(sheet.getRow(i).getCell(5))),
                                user.getEmp_id());

                        codeListService.save(codeList);
                    }
                }
            }

            workbook.close();

        } catch(IOException e){
                e.printStackTrace();
        }
    }

        public int getRowCount(XSSFWorkbook workbook) {

        try {

            XSSFSheet sheet = workbook.getSheet(workbook.getSheetName(0));
            return sheet.getPhysicalNumberOfRows();

        }catch(Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return 0;

    }

}
