package com.ExampleValcode.valcode.service;

import com.ExampleValcode.valcode.helper.CsvMovimentosHelper;
import com.ExampleValcode.valcode.helper.CsvOperacoesHelper;
import com.ExampleValcode.valcode.model.entity.Movimentos;
import com.ExampleValcode.valcode.model.entity.Operacoes;
import com.ExampleValcode.valcode.model.repository.FonteRepository;
import com.ExampleValcode.valcode.model.repository.MovimentosRepository;
import com.ExampleValcode.valcode.model.repository.OperacoesRepository;
import com.ExampleValcode.valcode.model.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CsvOperacoesService {
    private final OperacoesRepository repository;

    @Autowired
    public CsvOperacoesService(OperacoesRepository repository){
        this.repository = repository;
    }

    @Autowired
    private static FonteRepository fonteRepository;
    @Autowired
    private static PessoaFisicaRepository pessoaFisicaRepository;

    public void save(MultipartFile file){
        try{

            List<Operacoes> operacoes = CsvOperacoesHelper.csvToFonte(file.getInputStream());
            repository.saveAll(operacoes);
        } catch (IOException e){
            throw new RuntimeException("Fail to Store csv data " + e.getMessage());
        }
    }
}
