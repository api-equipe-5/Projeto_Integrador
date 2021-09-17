package br.gov.sp.fatec.springbootprodutora;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootprodutora.entity.Ator;
import br.gov.sp.fatec.springbootprodutora.entity.Diretor;
import br.gov.sp.fatec.springbootprodutora.entity.Duble;
import br.gov.sp.fatec.springbootprodutora.entity.Filme;
import br.gov.sp.fatec.springbootprodutora.entity.Pessoa;
import br.gov.sp.fatec.springbootprodutora.repository.AtorRepository;
import br.gov.sp.fatec.springbootprodutora.repository.DiretorRepository;
import br.gov.sp.fatec.springbootprodutora.repository.DubleRepository;
import br.gov.sp.fatec.springbootprodutora.repository.FilmeRepository;

@SpringBootTest
@Transactional
public class FilmeRepositoryIntegrationTests {

     @Autowired
    private FilmeRepository filmeRepo;

    @Autowired
    private DiretorRepository diretorRepo;

    @Autowired
    private AtorRepository atorRepo;

    @Autowired
    private DubleRepository dubleRepo;

    private static final Logger logger = LoggerFactory.getLogger(FilmeRepositoryIntegrationTests.class);

    @BeforeAll
    static void init(@Autowired JdbcTemplate jdbcTemplate) {
        //diretor
        jdbcTemplate.update("INSERT INTO pes_pessoa (pes_nome, pes_cpf, tipo) VALUES (?, ?, ?)",
                            "Hop Bowman", "29949872899", "T");
        jdbcTemplate.update("INSERT INTO pes_pessoa (pes_nome, pes_cpf, tipo) VALUES (?, ?, ?)",
                            "Luke Winters", "92427130099", "T");
        //ator
        jdbcTemplate.update("INSERT INTO pes_pessoa (pes_nome, pes_cpf, tipo, atr_fama) VALUES (?, ?, ?, ?)",
                            "Owen Simpson", "16725546299", "A", "Musica");
        jdbcTemplate.update("INSERT INTO pes_pessoa (pes_nome, pes_cpf, tipo, atr_fama) VALUES (?, ?, ?, ?)",
                            "Cairo Head", "45516724899", "A", "Musica");
        //duble
        jdbcTemplate.update("INSERT INTO pes_pessoa (pes_nome, pes_cpf, tipo, dub_especialidade) VALUES (?, ?, ?, ?)",
                            "Tyler Briggs", "38314493399", "D", "Luta");
        jdbcTemplate.update("INSERT INTO pes_pessoa (pes_nome, pes_cpf, tipo, dub_especialidade) VALUES (?, ?, ?, ?)",
                            "Clark Knox", "47725317999", "D", "Dança");
        //filmagem
        jdbcTemplate.update("INSERT INTO fmg_filmagem (fmg_nome, fmg_ano, fmg_duracao, diretor) VALUES (?, ?, ?, ?)",
                            "Casa Sombria", 1998L, 4F, 2L); // por algum motivo obscuro não pode setar o diretor 1, que resulta em erro de Foreign Key
        jdbcTemplate.update("INSERT INTO fmg_filmagem (fmg_nome, fmg_ano, fmg_duracao, diretor) VALUES (?, ?, ?, ?)",
                            "Uma noite na floresta", 2012L, 2.3F, 2L);
        //filme                  
        jdbcTemplate.update("INSERT INTO flm_filme (fmg_id, flm_descricao) VALUES (?, ?)",
                            1,"Lorem ipsum velit justo nec ante.");
        jdbcTemplate.update("INSERT INTO flm_filme (fmg_id, flm_descricao) VALUES (?, ?)",
                            2,"Lorem ipsum velit justo nec ante.");
        //atuacao
        jdbcTemplate.update("INSERT INTO atu_atuacao(pes_id, fmg_id) VALUES (?, ?)", 3L, 1L);
        jdbcTemplate.update("INSERT INTO atu_atuacao(pes_id, fmg_id) VALUES (?, ?)", 5L, 1L);
        jdbcTemplate.update("INSERT INTO atu_atuacao(pes_id, fmg_id) VALUES (?, ?)", 3L, 2L);
        jdbcTemplate.update("INSERT INTO atu_atuacao(pes_id, fmg_id) VALUES (?, ?)", 4L, 2L);
        jdbcTemplate.update("INSERT INTO atu_atuacao(pes_id, fmg_id) VALUES (?, ?)", 6L, 2L);    
    }

    @Test
    void testaInsercaoFilme() {
        Diretor diretor = diretorRepo.findByNome("Hop Bowman");
        logger.info("find diretor by name HOP BOWMAN", FilmeRepositoryIntegrationTests.class.getSimpleName());
        Ator ator = atorRepo.findByNome("Owen Simpson");
        logger.info("find ator by name OWEN SIMPSON", FilmeRepositoryIntegrationTests.class.getSimpleName());
        Duble duble = dubleRepo.findByNome("Tyler Briggs");
        logger.info("find duble by name TYLER BRIGGS", FilmeRepositoryIntegrationTests.class.getSimpleName());

        Filme filme = new Filme();
        filme.setNome("O atirador");
        filme.setAno(2002l);
        filme.setDuracao(2.45f);
        filme.setDescricao("Um filme de guerra!");
        filme.setDiretor(diretor);
        filme.setPessoas(new HashSet<Pessoa>());
        filme.getPessoas().add(ator);
        filme.getPessoas().add(duble);
        filmeRepo.save(filme);
        assertNotNull(filme.getId());
    }

     @Test
    void testBuscaFilmePorDiretor() {
        List<Filme> filme = filmeRepo.findByDiretorNome("Luke Winters");
        assertNotNull(filme);
    }

    @Test
    void testBuscaFilmePorDiretorQuery() {
        List<Filme> filme = filmeRepo.buscaFilmePorDiretor("Luke Winters");
        assertNotNull(filme);
    }

    /*@Test
    void testBuscaFilmePorNomeEDiretorQuery() {
        Filme filme = filmeRepo.buscaFilmePorNomeEDiretor("Uma noite na floresta", "Luke Winters");
        assertNotNull(filme);
    }*/
}