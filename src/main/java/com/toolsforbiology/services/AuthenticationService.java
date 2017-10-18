package com.toolsforbiology.services;

import com.toolsforbiology.configuration.SecurityProperties;
import com.toolsforbiology.configuration.security.SecurityUtils;
import com.toolsforbiology.configuration.security.hmac.HmacException;
import com.toolsforbiology.configuration.security.hmac.HmacToken;
import com.toolsforbiology.configuration.security.hmac.HmacUtils;
import com.toolsforbiology.dto.LoginDTO;
import com.toolsforbiology.dto.UserDTO;
import com.toolsforbiology.mapper.UserMapper;
import com.toolsforbiology.model.User;
import com.toolsforbiology.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pascalbardeau on 07/10/2017.
 */

@Service
public class AuthenticationService {

    public static final String ACCESS_TOKEN_COOKIE = "access_token";
    public static final String JWT_CLAIM_LOGIN = "login";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityProperties securityProperties;

    private UserMapper userMapper;

    public UserDTO authenticate(LoginDTO loginDTO, HttpServletRequest request, HttpServletResponse response) throws HmacException {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),loginDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //Get Hmac signed token
        Map<String,String> customClaims = new HashMap<>();
        customClaims.put(SecurityUtils.ENCODING_CLAIM_PROPERTY, HmacUtils.HMAC_SHA_256);
        customClaims.put(JWT_CLAIM_LOGIN, loginDTO.getUsername());

        //Get jwt secret from properties
        String jwtSecret = securityProperties.getJwt().getSecret();

        //Get hmac secret from config
        String hmacSharedSecret = securityProperties.getHmac().getSecret();

        // Jwt is generated using the secret defined in configuration file
        HmacToken hmacToken = SecurityUtils.getSignedToken(jwtSecret,loginDTO.getUsername(), SecurityService.JWT_TTL,customClaims);

        // Add jwt as a cookie
        Cookie jwtCookie = new Cookie(ACCESS_TOKEN_COOKIE,hmacToken.getJwt());
        jwtCookie.setPath(request.getContextPath().length() > 0 ? request.getContextPath() : "/");
        jwtCookie.setMaxAge(securityProperties.getJwt().getMaxAge());
        //Cookie cannot be accessed via JavaScript
        jwtCookie.setHttpOnly(true);

        // Add shared secret and encoding method in headers
        response.setHeader(HmacUtils.X_SECRET, hmacSharedSecret);
        response.setHeader(HttpHeaders.WWW_AUTHENTICATE, HmacUtils.HMAC_SHA_256);

        //Set JWT as a cookie
        response.addCookie(jwtCookie);

        User user = userRepository.findByUsername(loginDTO.getUsername());
        return userMapper.userToUserDTO(user);
    }
}
