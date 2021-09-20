package com.pi3.scorewizard.fonte;

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
@Order(1)
public class FonteDataLoader implements CommandLineRunner {
    @Autowired
    FonteRepository fonteRepository;
    
    private CSVParser csvParser;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() throws IOException {

        File file = new File("data/fonte.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        if(fonteRepository.count() == 0) {
            for (CSVRecord csvRecord : csvRecords) {
                Fonte fonte = new Fonte(
                    Integer.parseInt(csvRecord.get("id")),
                    csvRecord.get("nom_comercial")
                    );
                fonteRepository.save(fonte);
            }
        }
        System.out.println("Quantidade de fontes: " + fonteRepository.count());
    }
}
