package com.tecsus.ddc.security;

import com.tecsus.ddc.user.LoggedUser;
import com.tecsus.ddc.user.Role;
import com.tecsus.ddc.user.User;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class SecurityContextFactory implements WithSecurityContextFactory<WithUser> {

    @Override
    public SecurityContext createSecurityContext(Object obj) {
        Class<Object> clazz = (Class<Object>) obj.getClass();

        final LoggedUser loggedUser = new LoggedUser();
        final ArrayList<Role> authorities = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(WithUser.class)) {
                WithUser annotatedUser = method.getAnnotation(WithUser.class);
                for (String str : annotatedUser.authorities())
                    authorities.add(Role.valueOf(str));
                final User user = User.builder()
                        .login(annotatedUser.login())
                        .username(annotatedUser.username())
                        .password(annotatedUser.password())
                        .roles(authorities)
                        .build();
                loggedUser.setUser(user);
            }
        }
        SecurityContext context = new SecurityContext();
        SecurityContext.loggedUser = loggedUser;
        return context;
    }
}
