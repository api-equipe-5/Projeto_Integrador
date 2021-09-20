package com.si.safe_share.resource.form;

import com.si.safe_share.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfiguracaoCompartilhamentoForm {

    private Integer cliente;
    private Boolean compartilha_dados_pessoais;
    private Boolean compartilha_dados_compras;

    @Autowired
    ClienteRepository clienteRepository;

    public Integer getCliente() {
        return cliente;
    }

    public Boolean getCompartilha_dados_pessoais() {
        return compartilha_dados_pessoais;
    }

    public Boolean getCompartilha_dados_compras() {
        return compartilha_dados_compras;
    }
}
