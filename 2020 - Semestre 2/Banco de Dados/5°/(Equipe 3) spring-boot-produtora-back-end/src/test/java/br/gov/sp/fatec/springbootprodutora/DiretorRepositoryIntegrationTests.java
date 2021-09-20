package br.gov.sp.fatec.springbootprodutora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootprodutora.entity.Diretor;
import br.gov.sp.fatec.springbootprodutora.repository.DiretorRepository;


@SpringBootTest
@Transactional
public class DiretorRepositoryIntegrationTests {

    @Autowired
    private DiretorRepository diretorRepo;

    @Test
	void contextLoads() {
    }

    @Test
    void testaInsercaoDiretor() {
        Diretor diretor = new Diretor();
        diretor.setNome("Luiz Fernando");
        diretor.setCpf(46990126856l);
        diretorRepo.save(diretor);

        assertNotNull(diretor.getId());
    }
}