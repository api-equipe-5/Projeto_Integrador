package com.ExampleValcode.valcode.service;

import com.ExampleValcode.valcode.helper.CsvFonteHelper;
import com.ExampleValcode.valcode.model.entity.Fonte;
import com.ExampleValcode.valcode.model.repository.FonteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CsvFonteService {


    private final FonteRepository repository;

    @Autowired
    public CsvFonteService(FonteRepository repository){
        this.repository = repository;
    }

    public void save(MultipartFile file){
        try{
            List<Fonte> fontes = CsvFonteHelper.csvToFonte(file.getInputStream());
            repository.saveAll(fontes);
        } catch (IOException e){
            throw new RuntimeException("Fail to Store csv data " + e.getMessage());
        }
    }

    public List<Fonte> getAllFontes(){
        return repository.findAll();
    }
}
