package com.si.safe_share.resource;

import com.si.safe_share.model.Categoria;
import com.si.safe_share.repository.CategoriaRepository;
import com.si.safe_share.resource.form.CategoriaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class CategoriaResource {
    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping("/categoria")
    public Categoria salva(@RequestBody CategoriaForm categoriaForm) {
        Categoria categoria = categoriaForm.toModel(categoriaForm);
        return categoriaRepository.save(categoria);
    }

    @GetMapping("/categoria/{id}")
    public Optional<Categoria> buscaPorId(@PathVariable(value = "id") Integer id) {
        return categoriaRepository.findById(id);
    }

    @PutMapping("/categoria/{id}")
    public ResponseEntity<Categoria> atualiza(@PathVariable(value = "id") Integer id,
                                              @RequestBody CategoriaForm categoriaForm) {
        return categoriaRepository.findById(id)
                .map(categoria -> {
                    categoria.setDescricao(categoriaForm.getDescricao());
                    Categoria atualizada = categoriaRepository.save(categoria);
                    return ResponseEntity.ok().body(atualizada);
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/categorias")
    public List<Categoria> lista() {
        return categoriaRepository.findAll();
    }
}
