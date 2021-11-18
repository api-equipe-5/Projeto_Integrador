package com.tecsus.ddc.register;

import com.tecsus.ddc.IntegrationTest;
import com.tecsus.ddc.connection.Connector;
import com.tecsus.ddc.security.SecurityContext;
import com.tecsus.ddc.security.WithUser;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.junit.Test;

import java.sql.Connection;
import java.util.Date;

public class RegisterControllerTest extends IntegrationTest {

    @Test
    @WithUser(login = "tslino", username = "Tobias Lino", password = "123", authorities = {"ADMIN"})
    public void saveTest() throws JSONException {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        RegisterRepository registerRepository = new RegisterRepository(connection);
        RegisterController controller = new RegisterController(registerRepository);

        final Register register = mockedRegister();

        controller.save(register);

        JSONAssert.assertEquals(getJsonAsString("expected-register.json"), register.toJson(), true);
    }

    private Register mockedRegister() {
        return Register.builder()
                .bill(null)
                .instalation(null)
                .user(SecurityContext.loggedUser.getUser())
                .registerDate(new Date())
                .build();
    }
}
