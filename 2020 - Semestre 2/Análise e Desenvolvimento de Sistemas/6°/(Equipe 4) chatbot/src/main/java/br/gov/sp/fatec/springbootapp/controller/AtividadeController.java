package br.gov.sp.fatec.springbootapp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.sp.fatec.springbootapp.entity.Atividade;
import br.gov.sp.fatec.springbootapp.service.AtividadeService;

@RestController
@RequestMapping(value = "/atv")
@CrossOrigin
public class AtividadeController {

    @Autowired
    private AtividadeService atvService;

    @JsonView({ View.AtividadeResumo.class })
    @PostMapping
    public ResponseEntity<Atividade> criarAtividade(@RequestBody ObjectNode body,
            UriComponentsBuilder uriComponentsBuilder) {
        String nomeRemetente = body.get("nomeRemetente").asText();
        String nomeDestinatario = body.get("nomeDestinatario").asText();

        Atividade atividade = atvService.criarAtividade(nomeDestinatario, nomeRemetente,
                body.get("titulo").asText(), body.get("conteudo").asText(), body.get("dataDisparo").asText(),
                body.get("dataAgendada").asText(), body.get("status").asInt());

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/atv/" + atividade.getId()).build().toUri());

        return new ResponseEntity<Atividade>(atividade, responseHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping
    public void apagarMensagem(@RequestBody Atividade atividade) {
        atvService.deletarAtividade(atividade.getId());

    }

    @PostMapping(value = "/deletar")
    public void deletarAtividade(@RequestBody Atividade atividade) {
        atvService.deletarAtividade(atividade.getId());
    }

    @PostMapping(value = "/alterarStatus")
    public Atividade atualizarStatus(@RequestBody ObjectNode body) {
        return atvService.atualizarStatusAtividade(body.get("id").asLong(), body.get("status").asInt());
    }

    @PostMapping(value = "/concluirAtividade")
    public Atividade concluirAtividade(@RequestBody ObjectNode body) {
        return atvService.concluirAtividade(body.get("id").asLong(), body.get("status").asInt(), body.get("dataConclusao").asText());
    }
}
