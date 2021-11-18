package com.tecsus.ddc.bill.water;

import com.tecsus.ddc.bill.Bill;
import com.tecsus.ddc.product.Product;
import com.tecsus.ddc.tribute.Tribute;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Builder
@Data
public final class WaterBill {

    private Bill bill;

    private String location;
    private WaterCategory category;
    private Integer group;
    private List<Product> products;
    private List<Tribute> tributes;
}
