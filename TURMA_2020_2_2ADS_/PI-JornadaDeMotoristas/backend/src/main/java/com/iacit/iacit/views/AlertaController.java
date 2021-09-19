package com.iacit.iacit.views;

import java.util.Optional;

import com.iacit.iacit.IacitApplication;
import com.iacit.iacit.models.Alerta;
import com.iacit.iacit.repository.AlertaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin
@RequestMapping("/alerta")
public class AlertaController {
    
    @Autowired
    AlertaRepository aRepository;

    private static Logger logger = LoggerFactory.getLogger(IacitApplication.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Alerta createAlerta(@RequestBody final Alerta alerta) {
        logger.info("Nova alerta criado");
        return aRepository.save(alerta);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Alerta>> findAlerta(@PathVariable Long id){
        Optional<Alerta> alerta;
        alerta = aRepository.findById(id);
            return alerta.map(Exist -> {
                logger.info("Alerta " + id + " encontrado");
                return new ResponseEntity<Optional<Alerta>>(alerta, HttpStatus.OK);
            }).orElseThrow(() -> {
                logger.info("Alerta " + id + " não encontrado");
                return new ResponseStatusException(HttpStatus.NOT_FOUND,"Carga não encontrado");
            });
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlerta(@PathVariable final Long id,@RequestBody final Alerta alerta)
    {
        aRepository.findById(id).map(alertaExist -> {
            alerta.setId(alertaExist.getId());
            aRepository.save(alerta);
            logger.info("Alerta "+id+" alterado");
            return ResponseEntity.noContent().build();
        })
        .orElseThrow(() -> {
            logger.info("Alerta "+id+" não encontrado");
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Alerta não encontrado");
        });
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlerta (@PathVariable final Long id){
        aRepository.findById(id).map(alerta -> {
            aRepository.delete(alerta);
            logger.info("Alerta "+id+" deletado");
            return alerta;
        })
        .orElseThrow(() -> {
            logger.info("Alerta "+id+" não encontrado");
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Alerta não encontrado");
        });
    }

}
