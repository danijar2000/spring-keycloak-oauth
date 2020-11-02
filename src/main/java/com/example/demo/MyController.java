package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import java.security.Principal;

@Controller
class ProductController {

    @GetMapping(path = "/my")
    public String myPage(Model model) {
        AccessToken token = getKeycloakSecurityContext().getToken();
        model.addAttribute("first_name", token.getGivenName());
        model.addAttribute("last_name", token.getFamilyName());
        return "my";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/";
    }

    protected KeycloakSecurityContext getKeycloakSecurityContext() {

        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes(); Principal principal = attributes.getRequest().getUserPrincipal();

        if (principal instanceof KeycloakPrincipal)
        {
            KeycloakSecurityContext koj = KeycloakPrincipal.class.cast(principal).getKeycloakSecurityContext();

            return KeycloakPrincipal.class.cast(principal).getKeycloakSecurityContext();
        }

        return null;
    }

    public String getUserGroup() {
        return getKeycloakSecurityContext().getToken().getOtherClaims().get("group").
                toString();
    }

    public String getUserName() {
        return getKeycloakSecurityContext().getToken().getName();
    }
}
