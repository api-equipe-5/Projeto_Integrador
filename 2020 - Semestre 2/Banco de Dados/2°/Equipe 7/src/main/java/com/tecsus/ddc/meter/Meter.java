package com.tecsus.ddc.meter;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Meter {

    private String meterNumber;
    private String instalationNumber;
}
