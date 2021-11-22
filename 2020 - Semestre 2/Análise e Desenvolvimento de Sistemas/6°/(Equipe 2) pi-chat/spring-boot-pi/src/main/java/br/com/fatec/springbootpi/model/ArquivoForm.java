package br.com.fatec.springbootpi.model;

import java.util.List;

public class ArquivoForm {
    private String descricao, nome;
    private List<Long> idUsuarios;

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public List<Long> getIdUsuarios() {
        return idUsuarios;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdUsuarios(List<Long> idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
}