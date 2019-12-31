package com.example.demo.utils;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class JwtToken {
    public static String getJWTToken() {
        KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken) SecurityContextHolder.getContext()
                .getAuthentication();
        KeycloakPrincipal<KeycloakSecurityContext> keycloakPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) authentication
                .getPrincipal();
        return keycloakPrincipal.getKeycloakSecurityContext().getTokenString();
    }
}
