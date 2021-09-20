package com.ExampleValcode.valcode.helper;

import com.ExampleValcode.valcode.model.entity.Modalidade;
import com.ExampleValcode.valcode.model.entity.Pagamentos;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvPagamenosHelper {

    public static List<Pagamentos> csvToFonte(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Pagamentos> pagamentos = new ArrayList<Pagamentos>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                Pagamentos pagamento = new Pagamentos(
                        csvRecord.get("doc_cli"),
                        csvRecord.get("tip_cli"),
                        csvRecord.get("id_fnt"),
                        csvRecord.get("num_unc"),
                        LocalDateTime.parse(csvRecord.get("dat_pgt"), formatter),
                        LocalDateTime.parse(csvRecord.get("dat_vct"), formatter),
                        Double.parseDouble(csvRecord.get("vlr_pgt")),
                        csvRecord.get("cod_mdl")
                );

                pagamentos.add(pagamento);
            }

            return pagamentos;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
