package com.ExampleValcode.valcode.helper;


import com.ExampleValcode.valcode.model.entity.Fonte;
import com.ExampleValcode.valcode.model.entity.Modalidade;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class CsvFonteHelper {
    public static String TYPE = "text/csv";
    public final String[] HEADERs = {"id", "nom_comercial"};
    public static List<Fonte> csvToFonte(InputStream is) {

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Fonte> fontes = new ArrayList<Fonte>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Fonte fonte = new Fonte(
                        Integer.parseInt(csvRecord.get("id")),
                        csvRecord.get("nom_comercial")
                );

                fontes.add(fonte);
            }

            return fontes;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
