package com.ExampleValcode.valcode.helper;

import com.ExampleValcode.valcode.model.entity.Fonte;
import com.ExampleValcode.valcode.model.entity.Modalidade;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class CsvModalidadeHelper {

    public final String[] HEADERs = {"cod_modalidade", "des_modalidade"};

    public static List<Modalidade> csvToFonte(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Modalidade> modalidades = new ArrayList<Modalidade>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Modalidade modalidade = new Modalidade(
                        csvRecord.get("cod_modalidade"),
                        csvRecord.get("des_modalidade")
                );

                modalidades.add(modalidade);
            }

            return modalidades;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
