package easyata.projetoapi.rest.api.controller;

import easyata.projetoapi.rest.api.model.AtaRevisao;
import easyata.projetoapi.rest.api.repository.RevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class RevController {

    @Autowired
    RevRepository revRepository;

    @GetMapping("/revisoes")
    public List<AtaRevisao> listaRevisoes(){
        return revRepository.findAll();
    }

    @GetMapping("/revisao/{id}")
    public AtaRevisao listaRevisaoUnica(@PathVariable(value = "id") long id){
        return revRepository.findById(id);
    }

    @PostMapping("/salvar/revisao")
    public AtaRevisao salvarRev(@RequestBody AtaRevisao ataRevisao){
        return revRepository.save(ataRevisao);
    }

    @DeleteMapping("/deletar/revisao")
    public void deletaRev(@RequestBody AtaRevisao ataRevisao){
        revRepository.delete(ataRevisao);
    }

    @PutMapping("/atualizar/revisao")
    public AtaRevisao atualizaRev(@RequestBody AtaRevisao ataRevisao){
        return revRepository.save(ataRevisao);
    }
}
