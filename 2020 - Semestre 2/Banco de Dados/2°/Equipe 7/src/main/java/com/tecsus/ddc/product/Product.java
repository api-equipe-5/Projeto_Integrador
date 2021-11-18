package com.tecsus.ddc.product;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Product {

    private ProductType productType;
    private BigDecimal value;
    private BigDecimal quantity;
}
