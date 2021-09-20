package br.gov.sp.fatec.spc.operacoes.model;

public enum TipoCliente {
    J("J"), F("F");

    TipoCliente(final String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    private String tipoCliente;
}
