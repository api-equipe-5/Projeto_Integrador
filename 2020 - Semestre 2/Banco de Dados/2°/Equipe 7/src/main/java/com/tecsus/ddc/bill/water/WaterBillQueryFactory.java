package com.tecsus.ddc.bill.water;

public class WaterBillQueryFactory {
    public static String insert() {
        return "INSERT INTO DDC_WATER_BILL (bill_num, wa_location, category, wa_group) VALUES(?,?,?,?)";
    }
}
