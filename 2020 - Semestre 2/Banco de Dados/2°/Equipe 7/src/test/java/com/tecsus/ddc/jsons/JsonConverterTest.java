package com.tecsus.ddc.jsons;

import com.tecsus.ddc.IntegrationTest;
import com.tecsus.ddc.client.Client;
import com.tecsus.ddc.identification.Identification;
import com.tecsus.ddc.identification.IdentificationType;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonConverterTest extends IntegrationTest {

    @Test
    public void jsonAsStringTest() throws JSONException {
        Client client = Client.builder()
                .name("Teste Silva")
                .identification(Identification.builder()
                        .identificationType(IdentificationType.CNPJ)
                        .document("123456789101112")
                        .build())
                .build();
        System.out.println(client.toJson());
        JSONAssert.assertEquals(getJsonAsString("expected-register.json"), "{}", true);
    }
}
