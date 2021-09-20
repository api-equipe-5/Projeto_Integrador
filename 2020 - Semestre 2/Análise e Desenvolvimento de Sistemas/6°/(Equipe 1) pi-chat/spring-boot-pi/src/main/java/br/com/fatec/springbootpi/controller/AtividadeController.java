package br.com.fatec.springbootpi.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.fatec.springbootpi.entity.Atividade;
import br.com.fatec.springbootpi.model.AtividadeForm;
import br.com.fatec.springbootpi.repository.AtividadeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import br.com.fatec.springbootpi.service.AtividadeService;

@RestController
@RequestMapping(value = "/atividade")
@CrossOrigin(origins = "*")
@Api(value = "Atividade")
public class AtividadeController {
    
    @Autowired
    private AtividadeService atividadeService;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @JsonView(View.AtividadeResumo.class)
    @PostMapping
    @ApiOperation(value = "Inserir uma nova atividade")
    public ResponseEntity<Atividade> cadastrarNovaAtividade(@RequestBody AtividadeForm novaAtividade,
            UriComponentsBuilder uriComponentsBuilder) {

        Atividade atividade = atividadeService.criarAtividade(novaAtividade);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/atividade/" + atividade.getIdAtividade()).build().toUri());
        return new ResponseEntity<Atividade>(atividade, responseHeaders, HttpStatus.CREATED);
    }

    @JsonView(View.AtividadeResumo.class)
    @GetMapping(value = "{id}")
    @ApiOperation(value = "Buscar atividades por ID do usuário")
    public List<Atividade> pegarMensagensPorConversa(@PathVariable("id") Long id) {
        return atividadeRepository.getAtividadesPorUsuario(id);
    }

    @JsonView(View.AtividadeResumo.class)
    @GetMapping(value = "/open/usuario/{id}")
    @ApiOperation(value = "Buscar atividades abertas de um usuário")
    public List<Atividade> openAtividades(@PathVariable("id") Long id) {
        return atividadeService.getOpenAtividade(id);
    }

    @JsonView(View.AtividadeResumo.class)
    @GetMapping(value = "/close/usuario/{id}")
    @ApiOperation(value = "Buscar atividades fechadas de um usuário")
    public List<Atividade> closeAtividades(@PathVariable("id") Long id) {
        return atividadeService.getCloseAtividade(id);
    }

    @JsonView(View.AtividadeResumo.class)
    @PutMapping(value="/{id}")
    @ApiOperation(value = "Atualizar data fechamento da atividade")
    public Atividade fecharAtividade(@PathVariable("id") Long id){
        return atividadeService.fecharAtividade(id);
    }
}