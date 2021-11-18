package com.tecsus.ddc.flag;

public class TariffFlagQueryFactory {
    public static String insert() {
        return "INSERT INTO DDC_ENERGY_BILL_FLAG (color, fl_start, fl_finish, bill_num) " +
                "VALUES(?,?,?,?)";
    }
}
