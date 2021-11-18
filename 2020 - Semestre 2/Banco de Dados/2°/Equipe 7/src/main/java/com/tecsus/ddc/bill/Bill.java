package com.tecsus.ddc.bill;

import com.tecsus.ddc.bill.type.BillType;
import com.tecsus.ddc.instalation.Instalation;
import com.tecsus.ddc.meter.Meter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    protected String billNum;
    protected Instalation instalation;
    protected BigDecimal value;
    protected Date refMonth;
    protected Date previousRead;
    protected BigDecimal previousReadValue;
    protected Date actualRead;
    protected BigDecimal actualReadValue;
    protected Date nextRead;
    protected Date dueDate;
    protected Integer consum;
    protected Integer consumPeriod;
    protected Meter meter;
    protected BillType billType;

    public static Bill constructFrom(ResultSet resultSet) {
        try {
            return Bill.builder()
                    .billNum(resultSet.getString("bill_num"))
                    .instalation(Instalation.builder()
                            .instalationNumber(resultSet.getString("instalation"))
                            .build())
                    .value(resultSet.getBigDecimal("value"))
                    .refMonth(resultSet.getDate("ref_month"))
                    .previousRead(resultSet.getDate("previous_read"))
                    .previousReadValue(resultSet.getBigDecimal("previous_read_value"))
                    .actualRead(resultSet.getDate("actual_read"))
                    .actualReadValue(resultSet.getBigDecimal("actual_read_value"))
                    .nextRead(resultSet.getDate("next_read"))
                    .dueDate(resultSet.getDate("due_date"))
                    .consum(resultSet.getInt("consum"))
                    .consumPeriod(resultSet.getInt("consum_period"))
                    .meter(Meter.builder()
                            .instalationNumber(resultSet.getString("instalation"))
                            .meterNumber(resultSet.getString("meter_num"))
                            .build())
                    .billType(BillType.fromString(resultSet.getString("bill_type")))
                    .build();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
