package com.ExampleValcode.valcode.helper;

import com.ExampleValcode.valcode.model.entity.Movimentos;
import com.ExampleValcode.valcode.model.entity.Operacoes;
import com.ExampleValcode.valcode.model.repository.FonteRepository;
import com.ExampleValcode.valcode.model.repository.PessoaFisicaRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvOperacoesHelper {

    public static List<Operacoes> csvToFonte(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Operacoes> operacoes = new ArrayList<Operacoes>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {

                Operacoes operacao = new Operacoes(
                        csvRecord.get("doc_cli"),
                        csvRecord.get("tip_cli"),
                        Integer.parseInt(checkIfNull(csvRecord.get("num_unc"))),
                        Integer.parseInt(checkIfNull(csvRecord.get("id_mdl"))),
                        csvRecord.get("cod_mdl"),
                        csvRecord.get("qtd_pcl"),
                        csvRecord.get("dat_ctrc"),
                        csvRecord.get("dat_vct_ult_pcl"),
                        csvRecord.get("dat_vct"),
                        Double.parseDouble(checkIfNull(csvRecord.get("vlr_ctrd_fta"))),
                        Double.parseDouble(checkIfNull(csvRecord.get("vlr_ctrd"))),
                        Double.parseDouble(checkIfNull(csvRecord.get("sdo_ddr")))
                );

                operacoes.add(operacao);
            }

            return operacoes;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    private LocalDate convertToDate(String value){
        System.out.println(value);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (value.equals("NULL")){
            String dateToConvert = "1969-12-31";
            return LocalDate.parse(dateToConvert, formatter);
        }
        else{
            String[] splitValue = value.split("");

            String day = splitValue[0] + splitValue[1];
            String month = splitValue[2] + splitValue[3];
            String year = splitValue[4] + splitValue[5] + splitValue[6] + splitValue[7];
            String dateToConvert = year + '-' + month + '-' + day;
            return LocalDate.parse(dateToConvert, formatter);
        }
    }

    private static String checkIfNull(String value){
        if (value.equals("NULL")){
            return "0";
        }
        else {
            return value;
        }
    }
}
