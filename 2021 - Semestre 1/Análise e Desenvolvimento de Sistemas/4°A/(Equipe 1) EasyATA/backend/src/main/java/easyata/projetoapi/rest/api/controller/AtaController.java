package easyata.projetoapi.rest.api.controller;

import easyata.projetoapi.rest.api.model.Ata;
import easyata.projetoapi.rest.api.repository.AtaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class AtaController {

    @Autowired
    AtaRepository ataRepository;

    @GetMapping("/atas")
    public List<Ata> listaAtas(){
        return ataRepository.findAll();
    }

    @GetMapping("/ata/{id}")
    public Ata listaAtaUnica(@PathVariable(value = "id") long id){
        return ataRepository.findById(id);
    }
    @PostMapping("/saveAta")
    public Ata salvarAta(@RequestBody Ata ata){
        return ataRepository.save(ata);
    }

    @DeleteMapping("/ata")
    public void deletaAta(@RequestBody Ata ata){
        ataRepository.delete(ata);
    }

    @PutMapping("/ata")
    public Ata atualizaAta(@RequestBody Ata ata){
        return ataRepository.save(ata);
    }

}
