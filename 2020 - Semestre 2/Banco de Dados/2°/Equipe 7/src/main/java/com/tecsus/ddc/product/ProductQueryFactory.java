package com.tecsus.ddc.product;

public class ProductQueryFactory {

    public static String insert() {
        return "INSERT INTO DDC_BILL_PRODUCT (prod_type, prod_value, bill_num, quantity) " +
                "VALUES(?, ?, ?, ?)";
    }
}
