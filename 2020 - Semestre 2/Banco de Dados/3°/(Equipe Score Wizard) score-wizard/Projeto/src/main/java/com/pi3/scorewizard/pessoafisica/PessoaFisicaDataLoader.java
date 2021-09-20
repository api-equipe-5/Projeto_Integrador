package com.pi3.scorewizard.pessoafisica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
@Order(3)
public class PessoaFisicaDataLoader implements CommandLineRunner {
    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;
    
    private CSVParser csvParser;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() throws IOException {

        File file = new File("data/pessoa_fisica.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        if(pessoaFisicaRepository.count() == 0) {
            for (CSVRecord csvRecord : csvRecords) {
                PessoaFisica pessoaFisica = new PessoaFisica(
                    csvRecord.get("doc_cli"),
                    csvRecord.get("idc_sexo"),
                    csvRecord.get("ano_dat_nascimento").equals("NULL") ? 0 : Integer.parseInt(csvRecord.get("ano_dat_nascimento")),
                    csvRecord.get("nom_cidade"),
                    csvRecord.get("des_estado"), 0);
                pessoaFisicaRepository.save(pessoaFisica);
            }
        }
        System.out.println("Quantidade de pessoaFisicas: " + pessoaFisicaRepository.count());
    }
}