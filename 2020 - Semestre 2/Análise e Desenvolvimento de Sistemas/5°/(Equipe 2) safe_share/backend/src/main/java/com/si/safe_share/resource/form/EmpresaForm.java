package com.si.safe_share.resource.form;

import com.si.safe_share.model.Empresa;
import lombok.Getter;

@Getter
public class EmpresaForm {
    private String nome;


    public Empresa toModel(EmpresaForm empresaForm) {
        Empresa empresa = Empresa.builder()
                .nome(empresaForm.getNome())
                .build();
        return empresa;
    }

    public Empresa toModelUpdated(Empresa empresaAntiga, Empresa empresaNova) {
        empresaAntiga.setNome(empresaNova.getNome());
        return empresaAntiga;
    }

}
