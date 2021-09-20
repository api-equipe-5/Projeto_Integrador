package com.fatec.antenas.model;

import com.fatec.antenas.repository.CadiRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;




@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DocumentCadiTest {

    @Autowired
    private CadiRepository cadiDAO;

    @Test
    public void testeDocumentCadi (){
        Assert.assertEquals(cadiDAO.findByEmail("teste@teste.com"), null);
        DocumentCadi documentCadi = new DocumentCadi(null,"Nome Teste", "teste@teste.com","senhaTeste" );
        cadiDAO.save(documentCadi);
        DocumentCadi documentCadiFound = cadiDAO.findByEmail("teste@teste.com");
        Assert.assertEquals(documentCadiFound.getNome(), documentCadi.getNome());
        cadiDAO.delete(documentCadi);
        Assert.assertEquals(cadiDAO.findByEmail("teste@teste.com"), null);
    }



}
