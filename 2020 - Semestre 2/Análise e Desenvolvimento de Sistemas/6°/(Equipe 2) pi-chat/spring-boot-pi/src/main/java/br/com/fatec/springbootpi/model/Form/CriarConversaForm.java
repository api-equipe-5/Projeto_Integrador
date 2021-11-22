package br.com.fatec.springbootpi.model.Form;

import java.util.List;

import javax.validation.constraints.NotNull;

public class CriarConversaForm {
    @NotNull
    private List<Long> idUsuarios;

    public List<Long> getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(List<Long> idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
    
}