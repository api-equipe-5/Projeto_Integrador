package com.tecsus.ddc.bill.energy;

public class EnergyBillQueryFactory {

    public static String insert() {
        return "INSERT INTO DDC_ENERGY_BILL(bill_num, en_group, en_subgroup, en_class, en_subclass, emission, tension, phase)" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    }
}
