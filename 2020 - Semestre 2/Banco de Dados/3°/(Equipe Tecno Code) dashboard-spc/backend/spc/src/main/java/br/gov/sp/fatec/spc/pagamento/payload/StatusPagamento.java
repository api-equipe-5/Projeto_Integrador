package br.gov.sp.fatec.spc.pagamento.payload;

import lombok.Getter;

public enum StatusPagamento {
    PENDENTE("Pendente"),
    PAGO("Pago"),
    ATRASADO("Atrasado"),
    PAGO_ATRASADO("Pago em atraso"),
    PAGO_EM_DIA("Pago em dia");

    @Getter
    private String descricao;

    StatusPagamento(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }
}
