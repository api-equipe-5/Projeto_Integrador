package com.si.safe_share.resource.form;

import com.si.safe_share.model.Categoria;

public class CategoriaForm {
    private String descricao;

    public Categoria toModel(CategoriaForm categoriaForm) {
        Categoria categoria = Categoria.builder()
                .descricao(categoriaForm.getDescricao())
                .build();
        return categoria;
    }

    public Categoria toModelUpdated(Categoria categoriaAntiga, Categoria categoriaNova) {
        categoriaAntiga.setDescricao(categoriaNova.getDescricao());
        Categoria categoriaAtualizada = categoriaAntiga;
        return categoriaAtualizada;
    }

    public String getDescricao() {
        return descricao;
    }
}
