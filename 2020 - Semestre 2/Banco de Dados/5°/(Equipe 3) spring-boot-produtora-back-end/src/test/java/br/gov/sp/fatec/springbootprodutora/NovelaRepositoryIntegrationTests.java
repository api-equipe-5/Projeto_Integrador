package br.gov.sp.fatec.springbootprodutora;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootprodutora.entity.Ator;
import br.gov.sp.fatec.springbootprodutora.entity.Diretor;
import br.gov.sp.fatec.springbootprodutora.entity.Duble;
import br.gov.sp.fatec.springbootprodutora.entity.Novela;
import br.gov.sp.fatec.springbootprodutora.entity.Pessoa;
import br.gov.sp.fatec.springbootprodutora.repository.AtorRepository;
import br.gov.sp.fatec.springbootprodutora.repository.DiretorRepository;
import br.gov.sp.fatec.springbootprodutora.repository.DubleRepository;
import br.gov.sp.fatec.springbootprodutora.repository.NovelaRepository;

@SpringBootTest
@Transactional
public class NovelaRepositoryIntegrationTests {

    @Autowired
    private NovelaRepository novelaRepo;

    @Autowired
    private DiretorRepository diretorRepo;

    @Autowired
    private AtorRepository atorRepo;

    @Autowired
    private DubleRepository dubleRepo;

    /*@BeforeAll
    static void init(@Autowired JdbcTemplate jdbcTemplate) {
        //diretor
        jdbcTemplate.update("INSERT INTO pes_pessoa (pes_nome, pes_cpf, tipo) VALUES (?, ?, ?)",
                            "Carlos Augusto", "48963215869", "T");
        jdbcTemplate.update("INSERT INTO pes_pessoa (pes_nome, pes_cpf, tipo) VALUES (?, ?, ?)",
                            "Flavio Santos", "63250159803", "T");
        //ator
        jdbcTemplate.update("INSERT INTO pes_pessoa (pes_nome, pes_cpf, tipo, atr_fama) VALUES (?, ?, ?, ?)",
                            "Fabiano Pereira", "49846515184", "A", "Musica");
        jdbcTemplate.update("INSERT INTO pes_pessoa (pes_nome, pes_cpf, tipo, atr_fama) VALUES (?, ?, ?, ?)",
                            "João Ferreira", "897845646521", "A", "Musica");
        //duble
        jdbcTemplate.update("INSERT INTO pes_pessoa (pes_nome, pes_cpf, tipo, dub_especialidade) VALUES (?, ?, ?, ?)",
                            "Nathan Xaier", "26659871555", "D", "Luta");
        jdbcTemplate.update("INSERT INTO pes_pessoa (pes_nome, pes_cpf, tipo, dub_especialidade) VALUES (?, ?, ?, ?)",
                            "Daniel Paulo", "65974112185", "D", "Dança");
        //filmagem
        jdbcTemplate.update("INSERT INTO fmg_filmagem (fmg_nome, fmg_ano, fmg_duracao, diretor) VALUES (?, ?, ?, ?)",
                            "Chiquititas", 2008L, 75F, 7L); // por algum motivo obscuro não pode setar o diretor 1, que resulta em erro de Foreign Key
        jdbcTemplate.update("INSERT INTO fmg_filmagem (fmg_nome, fmg_ano, fmg_duracao, diretor) VALUES (?, ?, ?, ?)",
                            "Demolidor", 2005L, 120.5F, 8L);
        //novela                  
        jdbcTemplate.update("INSERT INTO nov_novela (fmg_id, nov_capitulo, nov_desc_cap) VALUES (?, ?, ?)",
                            3, 88, "Lorem ipsum");
        jdbcTemplate.update("INSERT INTO nov_novela (fmg_id, nov_capitulo, nov_desc_cap) VALUES (?, ?, ?)",
                            4, 134, "Lorem ipsum");
        //atuacao
        jdbcTemplate.update("INSERT INTO atu_atuacao(pes_id, fmg_id) VALUES (?, ?)", 9L, 3L);
        jdbcTemplate.update("INSERT INTO atu_atuacao(pes_id, fmg_id) VALUES (?, ?)", 11L, 3L);
        jdbcTemplate.update("INSERT INTO atu_atuacao(pes_id, fmg_id) VALUES (?, ?)", 10L, 4L);
        jdbcTemplate.update("INSERT INTO atu_atuacao(pes_id, fmg_id) VALUES (?, ?)", 12L, 4L);
        jdbcTemplate.update("INSERT INTO atu_atuacao(pes_id, fmg_id) VALUES (?, ?)", 13L, 4L);    
    }

    @Test
    void testaInsercaoNovela() {
        Diretor diretor = diretorRepo.findByNome("Flavio Santos");
        Ator ator = atorRepo.findByNome("Fabiano Pereira");
        Duble duble = dubleRepo.findByNome("Nathan Xaier");

        Novela novela = new Novela();
        novela.setNome("A carminha");
        novela.setAno(2002l);
        novela.setDuracao(2.45f);
        novela.setDiretor(diretor);
        novela.setCapitulo(30l);
        novela.setDescricaoCap("Uma empregada rica");
        novela.setPessoas(new HashSet<Pessoa>());
        novela.getPessoas().add(ator);
        novela.getPessoas().add(duble);
        novelaRepo.save(novela);

        assertNotNull(novela.getId());
    }

    @Test
    void testBuscaNovelaPorAnoEQuantidadeCapitulo() {
        Novela novela = novelaRepo.findByAnoAndCapitulo(2008l, 88l);
        assertNotNull(novela);
    }*/
}