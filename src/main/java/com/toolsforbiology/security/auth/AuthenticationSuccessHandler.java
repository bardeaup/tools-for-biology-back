package com.toolsforbiology.security.auth;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.toolsforbiology.security.TokenHelper;
import com.toolsforbiology.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_AUTH_STRING = "Authorization";
    static final String HEADER_REFRESH_STRING = "refresh";

    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        clearAuthenticationAttributes(request);

        User utilisateur = (User) authentication.getPrincipal();

        // creation token JWT
        String jws = tokenHelper.generateToken(utilisateur);
        response.addHeader(HEADER_AUTH_STRING, TOKEN_PREFIX + " " + jws);

    }
}