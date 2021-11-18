package com.tecsus.ddc.security;

import java.lang.annotation.Annotation;

public interface WithSecurityContextFactory<A extends Annotation> {
    SecurityContext createSecurityContext(Object obj);
}
