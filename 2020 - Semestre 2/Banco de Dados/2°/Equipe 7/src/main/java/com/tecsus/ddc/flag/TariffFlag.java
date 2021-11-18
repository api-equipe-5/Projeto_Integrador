package com.tecsus.ddc.flag;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class TariffFlag {

    private TariffFlagColor color;
    private Date start;
    private Date finish;
}
