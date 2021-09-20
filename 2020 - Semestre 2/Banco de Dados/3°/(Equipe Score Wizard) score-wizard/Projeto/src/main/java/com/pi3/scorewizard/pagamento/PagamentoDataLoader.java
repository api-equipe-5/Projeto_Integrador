package com.pi3.scorewizard.pagamento;

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

import com.pi3.scorewizard.fonte.Fonte;
import com.pi3.scorewizard.fonte.FonteRepository;
import com.pi3.scorewizard.modalidade.Modalidade;
import com.pi3.scorewizard.modalidade.ModalidadeRepository;
import com.pi3.scorewizard.pessoafisica.PessoaFisica;
import com.pi3.scorewizard.pessoafisica.PessoaFisicaRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
@Order(5)
public class PagamentoDataLoader implements CommandLineRunner {
    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    ModalidadeRepository modalidadeRepository;

    @Autowired
    FonteRepository fonteRepository;

    private CSVParser csvParser;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() throws IOException, NumberFormatException, ParseException {

        File file = new File("data/pagamentos.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        if(pagamentoRepository.count() == 0) {
            int count = 1;
            Fonte fonte;
            PessoaFisica pf;
            Modalidade mod;

            for (CSVRecord csvRecord : csvRecords) {
                fonte = fonteRepository.findById(Integer.parseInt(csvRecord.get("id_fnt"))).isPresent() ? fonteRepository.findById(Integer.parseInt(csvRecord.get("id_fnt"))).get() : null; 
                pf = pessoaFisicaRepository.findById(csvRecord.get("doc_cli")).isPresent() ? pessoaFisicaRepository.findById(csvRecord.get("doc_cli")).get() : null;
                mod = modalidadeRepository.findById(csvRecord.get("cod_mdl")).isPresent() ? modalidadeRepository.findById(csvRecord.get("cod_mdl")).get() : null;
                
                Pagamento pagamento = new Pagamento(
                    count,fonte,pf,mod,
                    new SimpleDateFormat("yyyy-MM-dd h:mm:ss").parse(csvRecord.get("dat_pgt")),
                    Double.parseDouble(csvRecord.get("vlr_pgt")),
                    csvRecord.get("num_unc"),
                    csvRecord.get("tip_cli"),
                    new SimpleDateFormat("yyyy-MM-dd h:mm:ss").parse(csvRecord.get("dat_vct"))
                    );
                pagamentoRepository.save(pagamento);
                count++;
            }
        }
        System.out.println("Quantidade de pagamentos: " + pagamentoRepository.count());
    }
} 