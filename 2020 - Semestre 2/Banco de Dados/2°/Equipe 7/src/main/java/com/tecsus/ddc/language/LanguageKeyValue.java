package com.tecsus.ddc.language;

import lombok.Getter;

@Getter
public enum LanguageKeyValue {

    login_errors("Erro de login"),

    empty_username("Por favor, preencha o nome de usuário."),
    empty_password("Por favor, preencha a senha."),
    user_not_found("Usuário inválido."),
    wrong_password("A senha está errada."),

    global_cancel("Cancelar"),
    global_confirm("Ok"),

    confirmation("Confirmar"),
    delete_selected_bill("Deseja mesmo apagar a conta selecionada?"),

    report_value("Valor"),
    report_consum("Consumo"),
    report_value_consum("Valor/Consumo"),
    report_title("Valor/Consumo por mês"),
    global_period("Período");

    private String text;

    LanguageKeyValue(String text) {
        this.text = text;
    }
}
