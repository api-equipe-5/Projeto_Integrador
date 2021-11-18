package com.tecsus.ddc.tribute;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Tribute {

    private TributeType type;
    private BigDecimal value;
    private BigDecimal aliquot;
    private BigDecimal calculationBasis;
}
