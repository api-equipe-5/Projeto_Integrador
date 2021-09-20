package com.si.safe_share.resource.form;

import com.si.safe_share.model.Cliente;
import com.si.safe_share.model.Empresa;
import com.si.safe_share.model.LogCompartilhamento;
import com.si.safe_share.repository.ClienteRepository;
import com.si.safe_share.repository.EmpresaRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

public class LogCompartilhamentoForm {
    private LocalDate dataDeInicio;
    private LocalDate dataFinal;
    private String dadoCompartilhado;
    private Integer cliente;
    private Integer empresa;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    public LogCompartilhamento toModel(LogCompartilhamentoForm logCompartilhamentoForm) {


        Optional<Cliente> cliente = clienteRepository.findById(logCompartilhamentoForm.getCliente());
        Optional<Empresa> empresa = empresaRepository.findById(logCompartilhamentoForm.getEmpresa());

        LogCompartilhamento logCompartilhamento = LogCompartilhamento.builder()
                .cliente(cliente.get())
                .empresa(empresa.get())
                .dataDeInicio(logCompartilhamentoForm.getDataDeInicio())
                .dataFinal(logCompartilhamentoForm.getDataFinal())
                .dadoCompartilhado(logCompartilhamentoForm.getDadoCompartilhado())
                .build();
        return logCompartilhamento;
    }

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public String getDadoCompartilhado() {
        return dadoCompartilhado;
    }

    public Integer getCliente() {
        return cliente;
    }

    public Integer getEmpresa() {
        return empresa;
    }
}
