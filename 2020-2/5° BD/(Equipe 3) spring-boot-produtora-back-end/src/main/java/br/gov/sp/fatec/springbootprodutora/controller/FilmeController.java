package br.gov.sp.fatec.springbootprodutora.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.sp.fatec.springbootprodutora.entity.Filme;
import br.gov.sp.fatec.springbootprodutora.service.ProdutoraServiceProvider;

@RestController
@RequestMapping(value = "/filme")
@CrossOrigin //permite acessar de qualquer servidor

public class FilmeController {

    @Autowired
    private ProdutoraServiceProvider produtoraService;

    @JsonView(View.Filme.class)
    @GetMapping
    public List<Filme> buscarTodos(){
        return produtoraService.buscarTodosFilmes();        
    }
    
    @JsonView(View.Filme.class)
    @GetMapping(value="/id/{id}")
    public Filme buscarPorID(@PathVariable("id") Long id){ //public Filme buscarPorID(@RequestParam(value="id") Long id) <--- Outra forma de receber valores via GET mas chama na URL /id?id=valor
        return produtoraService.buscarFilmePorId(id);
    }

    @JsonView(View.Filme.class)
    @GetMapping (value = "/nome/{nome}")
    public Filme buscarPorNome(@PathVariable("nome")  String nome)
    {
        return produtoraService.buscarFilmePorNome(nome);
    }

    @PostMapping
    public ResponseEntity <Filme> cadastraNovoFilme(@RequestBody Filme filme,
        UriComponentsBuilder uriComponentsBuilder)
    {
        filme = produtoraService.criaFilme(filme.getNome(), filme.getAno(), filme.getDuracao(), 
                                            filme.getDescricao(), filme.getDiretor().getNome(), "Owen Simpson", "Tyler Briggs");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(
            uriComponentsBuilder.path(
                "/filme/id/" + filme.getId()).build().toUri());      
        return new ResponseEntity<Filme>(filme,responseHeaders,HttpStatus.CREATED);
    }
}