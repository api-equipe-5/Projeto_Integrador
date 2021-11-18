package com.tecsus.ddc.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@WithSecurityContext(factory = SecurityContextFactory.class)
public @interface WithUser {

    String[] authorities();

    String login();

    String username();

    String password();
}
