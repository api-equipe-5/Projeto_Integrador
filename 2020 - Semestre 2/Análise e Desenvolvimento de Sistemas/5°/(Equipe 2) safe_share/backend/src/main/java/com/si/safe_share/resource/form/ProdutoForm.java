package com.si.safe_share.resource.form;

import com.si.safe_share.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class ProdutoForm {
    private String descricao;
    private BigDecimal valor;
    private Integer categoria;
    @Autowired
    CategoriaRepository categoriaRepository;

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getCategoria() {
        return categoria;
    }

}
