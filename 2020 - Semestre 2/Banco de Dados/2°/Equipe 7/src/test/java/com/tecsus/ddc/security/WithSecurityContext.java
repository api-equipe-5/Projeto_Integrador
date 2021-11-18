package com.tecsus.ddc.security;

import java.lang.annotation.*;

@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface WithSecurityContext {
    Class<? extends WithSecurityContextFactory<? extends Annotation>> factory();
}
