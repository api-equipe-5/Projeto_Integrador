package com.tecsus.ddc.user;

import com.tecsus.ddc.security.WithRole;
import lombok.Data;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Data
public class LoggedUser {

    private User user;

    public boolean hasRole(Object obj) {
        Class<Object> clazz = (Class<Object>) obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(WithRole.class)) {
                WithRole withRole = method.getAnnotation(WithRole.class);
                String[] roles = withRole.roles();
                if (roles.length > 0) {
                    List<Role> userRoles = user.getRoles();
                    if (userRoles == null) return false;
                    return Arrays.stream(roles).anyMatch(r -> {
                        boolean containsRole = false;
                        for (Role role : userRoles)
                            if (role.toString().equalsIgnoreCase(r))
                                containsRole = true;
                        return containsRole;
                    });
                }
            }
        }
        return false;
    }
}
