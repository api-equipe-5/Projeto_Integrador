package br.gov.sp.fatec.springbootprodutora.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootprodutora.entity.Novela;
import br.gov.sp.fatec.springbootprodutora.service.ProdutoraServiceProvider;

@RestController
@RequestMapping(value = "/novela")
@CrossOrigin //permite acessar de qualquer servidor
public class NovelaController {

    @Autowired
    private ProdutoraServiceProvider produtoraService;

    @JsonView(View.Novela.class)
    @GetMapping
    public List<Novela> buscarTodos(){
        return produtoraService.buscarTodasNovelas();        
    }

    @JsonView(View.Novela.class)
    @GetMapping(value="/id/{id}")
    public Novela buscarPorID(@PathVariable("id") Long id){ //public Filme buscarPorID(@RequestParam(value="id") Long id) <--- Outra forma de receber valores via GET mas chama na URL /id?id=valor
        return produtoraService.buscarNovelaPorId(id);
    }

    @JsonView(View.Novela.class)
    @GetMapping (value = "/nome/{nome}")
    public Novela buscarPorNome(@PathVariable("nome")  String nome)
    {
        return produtoraService.buscarNovelaPorNome(nome);
    }
    
}