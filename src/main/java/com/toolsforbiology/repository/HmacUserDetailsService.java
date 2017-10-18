package com.toolsforbiology.repository;

import com.toolsforbiology.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Hmac user details service
 * Created by Michael DESIGAUD on 15/02/2016.
 */
@Service
public class HmacUserDetailsService implements UserDetailsService{

    private UserRepository userRepository;

    public HmacUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User "+username+" not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),
                user.getGrantedAuthorities());
    }
}
