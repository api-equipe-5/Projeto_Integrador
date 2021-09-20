package com.si.safe_share.resource;

import com.si.safe_share.model.Empresa;
import com.si.safe_share.repository.EmpresaRepository;
import com.si.safe_share.resource.form.EmpresaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api")
class EmpresaResource {

    //    Injeção de dependência
    @Autowired
    EmpresaRepository empresaRepository;

    @PostMapping("/empresa")
    public Empresa salva(@RequestBody EmpresaForm empresaForm) {
        Empresa empresa = Empresa.builder()
                .nome(empresaForm.getNome())
                .build();
        Empresa nova = empresaRepository.save(empresa);
        return nova;

    }

    @GetMapping("/empresa/{id}")
    public Optional<Empresa> buscaPorId(@PathVariable(value = "id") Integer id) {
        return empresaRepository.findById(id);
    }

    @PutMapping("/empresa/{id}")
    @Transactional
    public ResponseEntity<Empresa> atualiza(@PathVariable(value = "id") Integer id,
                                            @RequestBody EmpresaForm empresaForm) {

        return empresaRepository.findById(id)
                .map(empresa -> {
                    empresa.setNome(empresaForm.getNome());
                    Empresa atualizada = empresaRepository.save(empresa);
                    return ResponseEntity.ok().body(atualizada);
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/empresas")
    public List<Empresa> lista() {
        return empresaRepository.findAll();
    }
}