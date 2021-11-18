package com.tecsus.ddc.register;

public class RegisterQueryFactory {

    public static String insert() {
        return "INSERT INTO DDC_BILL_REGISTER (USERNAME, BILL_NUM, INSTALATION, REGISTER_DATE) VALUES (?,?,?,?)";
    }
}
