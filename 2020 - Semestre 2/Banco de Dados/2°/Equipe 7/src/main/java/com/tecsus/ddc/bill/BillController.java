package com.tecsus.ddc.bill;

import com.tecsus.ddc.security.SecurityContext;
import com.tecsus.ddc.security.WithRole;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.AccessDeniedException;
import java.sql.Connection;

@Slf4j
public class BillController {

    private BillRepository billRepository;

    public BillController(Connection connection) {
        billRepository = new BillRepository(connection);
    }

    @WithRole(roles = {"ADMIN", "KEY_USER", "TYPIST"})
    public void save(Bill bill) {
        try {
            if (!SecurityContext.loggedUser.hasRole(this))
                throw new AccessDeniedException(String.format("User %s not have permission", SecurityContext.loggedUser.getUser().getUsername()));
            billRepository.save(bill);
        } catch (AccessDeniedException e) {
            log.error("User cannot do this operation");
            e.printStackTrace();
        }
    }

    public Bill find(String billNum) {
        return billRepository.find(billNum).orElse(new Bill());
    }
}
