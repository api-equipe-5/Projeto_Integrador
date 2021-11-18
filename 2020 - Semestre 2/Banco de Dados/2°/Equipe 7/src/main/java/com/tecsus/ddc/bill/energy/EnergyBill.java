package com.tecsus.ddc.bill.energy;

import com.tecsus.ddc.bill.Bill;
import com.tecsus.ddc.flag.TariffFlag;
import com.tecsus.ddc.product.Product;
import com.tecsus.ddc.tribute.Tribute;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public final class EnergyBill {

    private Bill bill;

    private Group group;
    private SubGroup subGroup;
    private Classe classe;
    private SubClasse subClasse;
    private Date emission;
    private Integer tension;
    private Phase phase;
    private List<TariffFlag> tariffFlags;
    private List<Product> products;
    private List<Tribute> tributes;
}
