package com.tecsus.ddc.tribute;

public class TributeQueryFactory {
    public static String insert() {
        return "INSERT INTO DDC_BILL_TRIBUTES (bill_num, tr_type, value, aliquot, calculation_basis) VALUES(?,?,?,?,?)";
    }
}
