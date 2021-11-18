package com.tecsus.ddc.bill;

import com.tecsus.ddc.bill.type.BillType;
import com.tecsus.ddc.connection.Connector;
import com.tecsus.ddc.instalation.Instalation;
import com.tecsus.ddc.meter.Meter;
import com.tecsus.ddc.register.Register;
import com.tecsus.ddc.register.RegisterController;
import com.tecsus.ddc.register.RegisterRepository;
import com.tecsus.ddc.security.SecurityContext;
import com.tecsus.ddc.security.SecurityContextFactory;
import com.tecsus.ddc.security.WithUser;
import com.tecsus.ddc.user.LoggedUser;
import com.tecsus.ddc.user.Role;
import com.tecsus.ddc.user.User;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class BillControllerTest {

    SecurityContextFactory factory = new SecurityContextFactory();

    @Before
    public void initialize() {
        LoggedUser loggedUser = new LoggedUser();
        User user = simpleUser();
        loggedUser.setUser(user);
        SecurityContext.loggedUser = loggedUser;
    }

    @Test
    @WithUser(login = "tslino", username = "Tobias Lino", password = "123", authorities = {"ADMIN"})
    public void saveTest() {
        SecurityContext securityContext = factory.createSecurityContext(this);

        Connector connector = new Connector();
        BillController controller = new BillController(connector.getConnection());
        RegisterController registerController = new RegisterController(new RegisterRepository(connector.getConnection()));


        int billNum = 101015, consum = 122;
        double valor = 212.4;
        for (int i = 1; i <= 12; ++i) {
            final Bill bill = simpleBill(i, String.valueOf(billNum), consum, String.valueOf(valor));
            final Register register = Register.builder()
                    .user(SecurityContext.loggedUser.getUser())
                    .bill(bill)
                    .instalation(bill.getInstalation())
                    .build();

            controller.save(bill);
            registerController.save(register);

            billNum++;
            if (consum == 122) consum = 134;
            else consum = 122;
            if (valor ==  212.4) valor = 250.9;
            else valor = 212.4;
        }
    }

    private Bill simpleBill(int month, String billNum, int consum, String value) {
        return Bill.builder()
                .billType(BillType.ENERGY)
                .instalation(Instalation.builder().instalationNumber("2599675-4").build())
                .billNum(billNum)
                .meter(Meter.builder().meterNumber("12345").build())
                .refMonth(new DateTime().withDate(2019,month,1).toDate())
                .value(new BigDecimal(value))
                .actualRead(new DateTime().withDate(2019,1,1).toDate())
                .actualReadValue(new BigDecimal("200"))
                .previousRead(new DateTime().withDate(2019,12,1).toDate())
                .previousReadValue(new BigDecimal("150.0"))
                .nextRead(new DateTime().withDate(2019,9,1).toDate())
                .dueDate(new DateTime().withDate(2019,1,31).toDate())
                .consum(consum)
                .consumPeriod(30)
                .build();
    }

    private User simpleUser() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.ADMIN);
        return User.builder()
                .login("tslino")
                .username("Tobias Lino")
                .password("123")
                .roles(roles)
                .build();
    }

    @Test
    public void find() {
        Connector connector = new Connector();
        BillController controller = new BillController(connector.getConnection());

        Bill bill = controller.find("12345");
        System.out.println(bill);
    }
}
