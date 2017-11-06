package com.toolsforbiology.security.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by pascalbardeau on 06/11/2017.
 */
@Getter
@Setter
public class AuthenticationUser extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID = 1L;

    private Long id;

    public AuthenticationUser(Long id, Object principal, Object credentials,
                              Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.id = id;
    }
}