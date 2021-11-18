package com.tecsus.ddc.identification;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Identification {

    private String document;
    private IdentificationType identificationType;
}
