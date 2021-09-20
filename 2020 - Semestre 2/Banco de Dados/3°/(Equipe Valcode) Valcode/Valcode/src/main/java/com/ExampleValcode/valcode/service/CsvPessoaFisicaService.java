package com.ExampleValcode.valcode.service;

import com.ExampleValcode.valcode.helper.CsvMovimentosHelper;
import com.ExampleValcode.valcode.helper.CsvPessoaFisicaHelper;
import com.ExampleValcode.valcode.model.entity.Movimentos;
import com.ExampleValcode.valcode.model.entity.PessoaFisica;
import com.ExampleValcode.valcode.model.repository.MovimentosRepository;
import com.ExampleValcode.valcode.model.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CsvPessoaFisicaService {
    private final PessoaFisicaRepository repository;

    @Autowired
    public CsvPessoaFisicaService(PessoaFisicaRepository repository){
        this.repository = repository;
    }

    public void save(MultipartFile file){
        try{
            List<PessoaFisica> pessoas = CsvPessoaFisicaHelper.csvToFonte(file.getInputStream());
            repository.saveAll(pessoas);
        } catch (IOException e){
            throw new RuntimeException("Fail to Store csv data " + e.getMessage());
        }
    }
}
