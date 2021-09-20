package com.pi3.scorewizard.modalidade;

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
@Order(2)
public class ModalidadeDataLoader implements CommandLineRunner {
    @Autowired
    ModalidadeRepository modalidadeRepository;
    private CSVParser csvParser;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() throws IOException {
        File file = new File("data/modalidade.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        if(modalidadeRepository.count() == 0) {
            for (CSVRecord csvRecord : csvRecords) {
                Modalidade modalidade = new Modalidade(
                    csvRecord.get("cod_modalidade"),
                    csvRecord.get("des_modalidade")
                    );
                modalidadeRepository.save(modalidade);
            }
        }
        System.out.println("Quantidade de modalidades: " + modalidadeRepository.count());
    }
}