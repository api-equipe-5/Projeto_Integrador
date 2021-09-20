package com.fatec.antenas.model;

import static org.assertj.core.api.Assertions.assertThat;
import com.fatec.antenas.repository.CadiRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;


@DataMongoTest
@ExtendWith(SpringExtension.class)
public class DocumentCadiUnitTest {
    
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
