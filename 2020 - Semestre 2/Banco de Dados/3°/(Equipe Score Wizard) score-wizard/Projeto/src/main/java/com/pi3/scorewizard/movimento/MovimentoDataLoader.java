package com.pi3.scorewizard.movimento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.pi3.scorewizard.fonte.Fonte;
import com.pi3.scorewizard.fonte.FonteRepository;
import com.pi3.scorewizard.pessoafisica.PessoaFisica;
import com.pi3.scorewizard.pessoafisica.PessoaFisicaRepository;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class MovimentoDataLoader implements CommandLineRunner {
    @Autowired
    MovimentoRepository movimentoRepository;
    
    @Autowired
    FonteRepository fonteRepository;
    
    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;

    private CSVParser csvParser;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() throws IOException, NumberFormatException, ParseException {

        File file = new File("data/movimentos.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        if(movimentoRepository.count() == 0) {
            int count = 1;
            Fonte fonte;
            PessoaFisica pf;
            
            for (CSVRecord csvRecord : csvRecords) {
                fonte = fonteRepository.findById(Integer.parseInt(csvRecord.get("id_fnt"))).isPresent() ? fonteRepository.findById(Integer.parseInt(csvRecord.get("id_fnt"))).get() : null; 
                pf = pessoaFisicaRepository.findById(csvRecord.get("doc_cli")).isPresent() ? pessoaFisicaRepository.findById(csvRecord.get("doc_cli")).get() : null;
              
                Movimento movimento = new Movimento(
                    count,pf,fonte,
                    csvRecord.get("dat_vct").equals("NULL") ? null : new SimpleDateFormat("ddMMyyyy").parse(csvRecord.get("dat_vct")),
                    csvRecord.get("qtd_pcl_vnc").equals("NULL") ? 0 : Integer.parseInt(csvRecord.get("qtd_pcl_vnc")),
                    csvRecord.get("qtd_pcl_pgr").equals("NULL") ? 0 : Integer.parseInt(csvRecord.get("qtd_pcl_pgr")),
                    csvRecord.get("vlr_tot_fat").equals("NULL") ? 0.00 : Double.parseDouble(csvRecord.get("vlr_tot_fat")),
                    csvRecord.get("vlr_min_fat").equals("NULL") ? 0.00 : Double.parseDouble(csvRecord.get("vlr_min_fat")),
                    csvRecord.get("vlr_pcl").equals("NULL") ? 0.00 : Double.parseDouble(csvRecord.get("vlr_pcl")),
                    csvRecord.get("tip_mvt"),
                    csvRecord.get("prd"),
                    csvRecord.get("tip_cli"),
                    csvRecord.get("num_unc").trim()
                );
                movimentoRepository.save(movimento);
                count++;

                // if( count > 100){
                //     break;
                // }
            }
        }
        System.out.println("Quantidade de movimentos: " + movimentoRepository.count());
    }
}
