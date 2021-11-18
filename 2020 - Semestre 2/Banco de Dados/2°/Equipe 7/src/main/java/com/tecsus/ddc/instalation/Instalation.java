package com.tecsus.ddc.instalation;

import com.google.gson.Gson;
import com.tecsus.ddc.address.Address;
import com.tecsus.ddc.client.Client;
import com.tecsus.ddc.identification.Identification;
import com.tecsus.ddc.identification.IdentificationType;
import com.tecsus.ddc.supplier.Supplier;
import lombok.Builder;
import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

@Builder
@Data
public class Instalation {

    private String instalationNumber;
    private Supplier supplier;
    private Client client;
    private Address address;

    public static Instalation constructFrom(ResultSet resultSet) {
        try {
            return Instalation.builder()
                    .instalationNumber(resultSet.getString("instalation"))
                    .supplier(Supplier.builder()
                            .cnpj(Identification.builder()
                                    .identificationType(IdentificationType.CNPJ)
                                    .document(resultSet.getString("supplier_cnpj"))
                                    .build())
                            .name(resultSet.getString("supplier_name"))
                            .address(Address.builder()
                                    .zip(resultSet.getString("supplier_add_zip"))
                                    .number(resultSet.getString("supplier_add_num"))
                                    .build())
                            .site(resultSet.getString("supplier_ie"))
                            .site(resultSet.getString("supplier_site"))
                            .build())
                    .client(Client.builder()
                            .identification(Identification.builder()
                                    .identificationType(IdentificationType.CNPJ)
                                    .document(resultSet.getString("client_ident"))
                                    .build())
                            .name(resultSet.getString("client_name"))
                            .build())
                    .address(Address.builder()
                            .number(resultSet.getString("inst_add_num"))
                            .zip(resultSet.getString("inst_add_zip"))
                            .city(resultSet.getString("inst_add_city"))
                            .complement(resultSet.getString("inst_add_complement"))
                            .neighborhood(resultSet.getString("inst_add_neighborhood"))
                            .state(resultSet.getString("inst_add_state"))
                            .street(resultSet.getString("inst_add_street"))
                            .build())
                    .build();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
