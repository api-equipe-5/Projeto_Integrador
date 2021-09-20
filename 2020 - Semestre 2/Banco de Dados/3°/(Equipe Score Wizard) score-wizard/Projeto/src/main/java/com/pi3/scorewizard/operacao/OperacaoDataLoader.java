package com.pi3.scorewizard.operacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.pi3.scorewizard.fonte.FonteRepository;
import com.pi3.scorewizard.modalidade.Modalidade;
import com.pi3.scorewizard.modalidade.ModalidadeRepository;
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
@Order(6)
public class OperacaoDataLoader implements CommandLineRunner {
    @Autowired
    OperacaoRepository operacaoRepository;

    @Autowired
    ModalidadeRepository modalidadeRepository;

    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    FonteRepository fonteRepository;

    private CSVParser csvParser;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() throws IOException, NumberFormatException, ParseException {
        File file = new File("data/operacoes.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        if(operacaoRepository.count() == 0) {
            int count = 1;

            for (CSVRecord csvRecord : csvRecords) {

                // Fonte fonte = fonteRepository.findById(Integer.parseInt(csvRecord.get("id_fnt"))).isPresent() ? fonteRepository.findById(Integer.parseInt(csvRecord.get("id_fnt"))).get() : null; 
                PessoaFisica pf = pessoaFisicaRepository.findById(csvRecord.get("doc_cli")).isPresent() ? pessoaFisicaRepository.findById(csvRecord.get("doc_cli")).get() : null;
                Modalidade mod = modalidadeRepository.findById(csvRecord.get("cod_mdl")).isPresent() ? modalidadeRepository.findById(csvRecord.get("cod_mdl")).get() : null;
                
                Operacao operacao = new Operacao(
                    count, pf, null, mod,
                    csvRecord.get("tip_cli"),
                    csvRecord.get("num_unc"),
                    csvRecord.get("qtd_pcl").equals("NULL") ? 0 : Integer.parseInt(csvRecord.get("qtd_pcl")),
                    csvRecord.get("dat_vct_ult_pcl").equals("NULL") ? null : new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(csvRecord.get("dat_vct_ult_pcl")),
                    csvRecord.get("dat_vct").equals("NULL") ? null : new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(csvRecord.get("dat_vct")),
                    csvRecord.get("vlr_ctrd_fta").equals("NULL") ? 0.00 : Double.parseDouble(csvRecord.get("vlr_ctrd_fta")),
                    csvRecord.get("vlr_ctrd").equals("NULL") ? 0.00 : Double.parseDouble(csvRecord.get("vlr_ctrd")),
                    csvRecord.get("sdo_ddr").equals("NULL") ? 0.00 : Double.parseDouble(csvRecord.get("sdo_ddr"))
                    );
                operacaoRepository.save(operacao);
                count++;
            }
        }
        System.out.println("Quantidade de operações: " + operacaoRepository.count());
    }
}