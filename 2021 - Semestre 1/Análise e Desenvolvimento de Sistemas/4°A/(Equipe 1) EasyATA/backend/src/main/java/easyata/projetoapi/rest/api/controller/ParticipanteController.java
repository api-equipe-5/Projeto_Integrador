package easyata.projetoapi.rest.api.controller;

import easyata.projetoapi.rest.api.model.Ata;
import easyata.projetoapi.rest.api.model.Participantes;
import easyata.projetoapi.rest.api.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ParticipanteController {

    @Autowired
    ParticipanteRepository participanteRepository;

    @GetMapping("/participantes")
    public List<Participantes> listaParticipantes(){
        return participanteRepository.findAll();
    }

    @GetMapping("/participantes/{id}")
    public Participantes listaParticipanteUnico(@PathVariable(value = "id") long id){
        return participanteRepository.findById(id);
    }

    @PostMapping("/salvar/participantes")
    public Participantes salvarParticipante(@RequestBody Participantes participantes){

        return participanteRepository.save(participantes);
    }

    @DeleteMapping("/deleta/participante")
    public void deletaParticipante(@RequestBody Participantes participantes){
        participanteRepository.delete(participantes);
    }

    @PutMapping("/atualiza/participante")
    public Participantes atualizaParticipantes(@RequestBody Participantes participantes){
        return participanteRepository.save(participantes);
    }
}
