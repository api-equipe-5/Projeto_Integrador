package com.tecsus.ddc.app.dashboard;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardBill {

    private String number;
    private String clientCNPJ;
    private String clientName;
    private String supplier;
    private String type;
    private String instalation;
    private String hidrometer;
    private String register;

    public static String select() {
        return "select db.bill_num billNum,  db.instalation instalation, di.supplier supplier, dc.ident clientCNPJ, dc.cl_name clientName, dbt.bill_type billType, dm.mt_number meter, dbr.register_date from ddc_bill db inner join ddc_instalation di on di.num_inst = db.instalation inner join ddc_client dc on dc.ident = di.client inner join ddc_supplier ds on ds.cnpj = di.supplier inner join ddc_bill_type dbt on dbt.bill_num = db.bill_num inner join ddc_meter dm on dm.instalation = db.instalation inner join ddc_bill_register dbr on dbr.bill_num = db.bill_num";
    }
}
