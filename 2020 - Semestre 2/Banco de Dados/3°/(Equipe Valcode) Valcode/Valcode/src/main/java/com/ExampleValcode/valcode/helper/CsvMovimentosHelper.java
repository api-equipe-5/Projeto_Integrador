package com.ExampleValcode.valcode.helper;

import com.ExampleValcode.valcode.model.entity.Fonte;
import com.ExampleValcode.valcode.model.entity.Modalidade;
import com.ExampleValcode.valcode.model.entity.Movimentos;
import com.ExampleValcode.valcode.model.entity.PessoaFisica;
import com.ExampleValcode.valcode.model.repository.FonteRepository;
import com.ExampleValcode.valcode.model.repository.PessoaFisicaRepository;
import lombok.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
@Getter
@Setter

public class CsvMovimentosHelper {


    private static Fonte fonte;



    private final FonteRepository fonteRepository;
    private  final PessoaFisicaRepository pessoaFisicaRepository;


    public final String[] HEADERs = {
            "doc_cli",
            "tip_cli",
            "id_fnt",
            "num_unc",
            "dat_vct",
            "qtd_pcl_vnc",
            "qtd_pcl_pgr",
            "vlr_tot_fat",
            "vlr_min_fat",
            "vlr_pcl",
            "tip_mvt",
            "prd"
    };

    @Autowired
    public CsvMovimentosHelper(PessoaFisicaRepository pessoaFisicaRepository, FonteRepository fonteRepository){
        this.pessoaFisicaRepository = pessoaFisicaRepository;
        this.fonteRepository = fonteRepository;

    }


    public  List<Movimentos> csvToFonte(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Movimentos> movimentos = new ArrayList<Movimentos>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {

                Movimentos movimento = new Movimentos(
                        csvRecord.get("doc_cli"),
                        csvRecord.get("tip_cli"),
                        csvRecord.get("id_fnt"),
                        csvRecord.get("num_unc"),

                        convertToDate(csvRecord.get("dat_vct")),
                        new BigInteger(checkIfNull(csvRecord.get("qtd_pcl_vnc"))),
                        new BigDecimal((checkIfNull(csvRecord.get("qtd_pcl_pgr")))),
                        new BigDecimal(checkIfNull(csvRecord.get("vlr_tot_fat"))),
                        new BigDecimal(checkIfNull(csvRecord.get("vlr_min_fat"))),
                        new BigDecimal(checkIfNull(csvRecord.get("vlr_pcl"))),
                        csvRecord.get("tip_mvt"),
                        csvRecord.get("prd")
                );

                movimentos.add(movimento);
            }

            return movimentos;
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

    private String checkIfNull(String value){
        if (value.equals("NULL")){
            return "0";
        }
        else {
            return value;
        }
    }

}
