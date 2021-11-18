package com.iacit.iacit.views;

import java.util.Optional;

import com.iacit.iacit.IacitApplication;
import com.iacit.iacit.models.Status;
import com.iacit.iacit.repository.StatusRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
@RequestMapping("/status")
public class StatusController {
    
    @Autowired
    StatusRepository sRepository;

    private static Logger logger = LoggerFactory.getLogger(IacitApplication.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Status createStatus(@RequestBody final Status status) {
        logger.info("Novo status criado");
        return sRepository.save(status);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Status>> findStatus(@PathVariable Long id){
        Optional<Status> status;
        status = sRepository.findById(id);
            return status.map(Exist -> {
                logger.info("Status " + id + " encontrado");
                return new ResponseEntity<Optional<Status>>(status, HttpStatus.OK);
            }).orElseThrow(() -> {
                logger.info("Status " + id + " não encontrado");
                return new ResponseStatusException(HttpStatus.NOT_FOUND,"Status não encontrado");
            });
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable final Long id,@RequestBody final Status status)
    {
        sRepository.findById(id).map(statusExist -> {
            status.setId(statusExist.getId());
            sRepository.save(status);
            logger.info("Status " + id + " alterado");
            return ResponseEntity.noContent().build();
        })
        .orElseThrow(() -> {
            logger.info("Status " + id + " não encontrado");
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Status não encontrado");
        });
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStatus (@PathVariable final Long id){
        sRepository.findById(id).map(status -> {
            sRepository.delete(status);
            logger.info("Status " + id + " deletado");
            return status;
        })
        .orElseThrow(() -> {
            logger.info("Status " + id + " não encontrado");
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Alerta não encontrado");
        });
    }

}
