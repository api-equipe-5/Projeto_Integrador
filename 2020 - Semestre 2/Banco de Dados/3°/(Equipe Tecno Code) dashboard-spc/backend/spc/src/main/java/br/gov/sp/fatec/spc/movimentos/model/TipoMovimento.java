package br.gov.sp.fatec.spc.movimentos.model;

public enum TipoMovimento {
    ATU("ATU"), FUT("FUT"), ANT("ANT");

    TipoMovimento(final String tipoMovimento){
        this.tipoMovimento = tipoMovimento;
    }

    private String tipoMovimento;

}
