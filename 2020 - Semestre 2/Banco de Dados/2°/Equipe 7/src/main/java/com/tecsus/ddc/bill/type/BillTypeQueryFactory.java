package com.tecsus.ddc.bill.type;

import com.tecsus.ddc.bill.Bill;

public class BillTypeQueryFactory {

    public static String insert() {
        return "INSERT INTO DDC_BILL_TYPE (BILL_TYPE, BILL_NUM) VALUES (?, ?)";
    }
}
