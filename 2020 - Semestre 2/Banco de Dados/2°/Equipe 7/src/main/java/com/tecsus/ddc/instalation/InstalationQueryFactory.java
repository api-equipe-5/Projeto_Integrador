package com.tecsus.ddc.instalation;

public class InstalationQueryFactory {

    public static String select() {
        return "select " +
                "num_inst instalation, " +
                "supplier, " +
                "client, " +
                "dc.cl_name client_name, " +
                "dc.ident client_ident, " +
                "ds.cnpj  supplier_cnpj, " +
                "ds.sup_name supplier_name, " +
                "ds.address_num supplier_add_num, " +
                "ds.address_zip supplier_add_zip, " +
                "ds.ie supplier_ie, " +
                "ds.site supplier_site, " +
                "da.zip inst_add_zip, " +
                "da.ad_number inst_add_num, " +
                "da.city inst_add_city, " +
                "da.complement inst_add_complement, " +
                "da.neighborhood inst_add_neighborhood, " +
                "da.state inst_add_state, " +
                "da.street inst_add_street " +
                "from ddc_instalation di inner join ddc_client dc on di.client = dc.ident inner join ddc_supplier ds on di.supplier = ds.cnpj  inner join ddc_address da on ds.address_zip = da.zip  inner join ddc_meter dm on di.num_inst = dm.instalation where di.num_inst = ?;";
    }
}
