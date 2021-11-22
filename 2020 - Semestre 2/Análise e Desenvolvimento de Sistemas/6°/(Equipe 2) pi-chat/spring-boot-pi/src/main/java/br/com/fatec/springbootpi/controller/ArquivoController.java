package br.com.fatec.springbootpi.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.fatec.springbootpi.entity.Arquivo;
import br.com.fatec.springbootpi.model.ArquivoForm;
import br.com.fatec.springbootpi.repository.ArquivoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import br.com.fatec.springbootpi.service.ArquivoService;

@RestController
@RequestMapping(value = "/arquivo")
@CrossOrigin(origins = "*")
@Api(value = "Arquivo")
public class ArquivoController {
    
    @Autowired
    private ArquivoService arquivoService;

    @Autowired
    private ArquivoRepository arquivoRepository;


    @PostMapping
    @JsonView(View.ArquivoResumo.class)
    @ApiOperation(value = "Inserir um novo arquivo")
    public ResponseEntity<Arquivo> cadastrarNovoArquivo(@RequestBody ArquivoForm novoArquivo,
            UriComponentsBuilder uriComponentsBuilder) {

        Arquivo arquivo = arquivoService.criarArquivo(novoArquivo);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/arquivo/" + arquivo.getIdArquivo()).build().toUri());
        return new ResponseEntity<Arquivo>(arquivo, responseHeaders, HttpStatus.CREATED);
    }

    @JsonView(View.ArquivoResumo.class)
    @GetMapping(value = "{id}")
    @ApiOperation(value = "Buscar arquivos por ID do usuário")
    public List<Arquivo> pegarMensagensPorConversa(@PathVariable("id") Long id) {
        return arquivoRepository.getArquivosPorUsuario(id);
    }
}