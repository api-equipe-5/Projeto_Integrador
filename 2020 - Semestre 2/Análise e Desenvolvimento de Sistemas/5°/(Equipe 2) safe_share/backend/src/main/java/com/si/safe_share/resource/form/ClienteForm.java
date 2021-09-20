package com.si.safe_share.resource.form;

import com.si.safe_share.model.Cliente;

public class ClienteForm {
    private String cpf;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String endereco;
    private String email;
    private String senha;

    public Cliente toModel(ClienteForm clienteForm) {
        Cliente cliente = Cliente.builder()
                .nome(clienteForm.getNome())
                .sobrenome(clienteForm.getSobrenome())
                .cpf(clienteForm.getCpf())
                .email(clienteForm.getEmail())
                .senha(clienteForm.getSenha())
                .telefone(clienteForm.getTelefone())
                .endereco(clienteForm.getEndereco())
                .build();
        return cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
