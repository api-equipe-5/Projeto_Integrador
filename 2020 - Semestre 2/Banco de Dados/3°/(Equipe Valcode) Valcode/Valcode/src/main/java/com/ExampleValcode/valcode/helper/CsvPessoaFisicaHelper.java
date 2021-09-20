package com.ExampleValcode.valcode.helper;

import com.ExampleValcode.valcode.model.entity.Fonte;
import com.ExampleValcode.valcode.model.entity.Movimentos;
import com.ExampleValcode.valcode.model.entity.PessoaFisica;
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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class CsvPessoaFisicaHelper {
    public static String TYPE = "text/csv";
    public final String[] HEADERs = {"doc_cli", "idc_sexo", "ano_dat_nascimento", "nom_cidade", "des_estado"};
    public static List<PessoaFisica> csvToFonte(InputStream is) {

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<PessoaFisica> pfs = new ArrayList<PessoaFisica>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                PessoaFisica pf = new PessoaFisica(
                        csvRecord.get("doc_cli"),
                        csvRecord.get("idc_sexo"),
                        verifyIfNull(csvRecord.get("ano_dat_nascimento")),
                        csvRecord.get("nom_cidade"),
                        csvRecord.get("des_estado")
                );

                pfs.add(pf);
            }

            return pfs;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    private static Integer verifyIfNull(String value){
        int newValue;
        if (value.equals("NULL")){
            newValue = 0;
        }
        else{
            newValue = Integer.parseInt(value);
        }
        return newValue;
    }

}