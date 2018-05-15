package com.toolsforbiology.security.service;

import com.toolsforbiology.application.services.UserService;
import com.toolsforbiology.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by pascalbardeau on 05/12/2017.
 */
@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Value("${message.login.email}")
    private String messageLoginNotFound;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userService.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException(messageLoginNotFound);
        }


        return user;
    }
}
