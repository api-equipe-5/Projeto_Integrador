package com.si.safe_share.resource;

import com.si.safe_share.model.Cliente;
import com.si.safe_share.repository.ClienteRepository;
import com.si.safe_share.resource.form.ClienteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ClienteResource {

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping("/cliente")
    public Cliente salva(@RequestBody ClienteForm clienteForm) {
        Cliente cliente = clienteForm.toModel(clienteForm);
        return clienteRepository.save(cliente);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/cliente/{id}")
    public ResponseEntity buscaPorId(@PathVariable Integer id) {

        return clienteRepository.findById(id)
                .map(cliente -> ResponseEntity.ok().body(cliente))
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/cliente/{id}")
    public ResponseEntity<Cliente> atualiza(@PathVariable(value = "id") Integer id,
                                            @RequestBody ClienteForm clienteForm) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteForm.getNome());
                    cliente.setEmail(clienteForm.getEmail());
                    cliente.setSobrenome(clienteForm.getSobrenome());
                    cliente.setEndereco(clienteForm.getEndereco());
                    cliente.setTelefone(clienteForm.getTelefone());
                    cliente.setCpf(clienteForm.getCpf());
                    cliente.setSenha(clienteForm.getSenha());
                    Cliente atualizado = clienteRepository.save(cliente);
                    return ResponseEntity.ok().body(atualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/clientes")
    public List<Cliente> lista() {
        return clienteRepository.findAll();
    }
}
