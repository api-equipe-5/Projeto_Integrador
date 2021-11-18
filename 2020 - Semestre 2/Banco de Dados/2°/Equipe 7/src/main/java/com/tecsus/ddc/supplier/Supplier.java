package com.tecsus.ddc.supplier;

import com.tecsus.ddc.address.Address;
import com.tecsus.ddc.identification.Identification;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Supplier {

    private Identification cnpj;
    private String name;
    private Address address;
    private String IE;
    private String site;
}
