package com.tecsus.ddc.register;

import com.tecsus.ddc.security.SecurityContext;
import com.tecsus.ddc.security.WithRole;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.AccessDeniedException;

@AllArgsConstructor
@Slf4j
public class RegisterController {

    private final RegisterRepository registerRepository;

    @WithRole(roles = {"ADMIN", "KEY_USER", "TYPIST"})
    public void save(final Register register) {
        try {
            if (!SecurityContext.loggedUser.hasRole(this))
                throw new AccessDeniedException(String.format("User %s not have permission", SecurityContext.loggedUser.getUser().getUsername()));
            registerRepository.save(register);
        } catch (AccessDeniedException e) {
            log.error("User cannot do this operation");
            e.printStackTrace();
        }
    }
}
