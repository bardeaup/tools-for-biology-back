package com.toolsforbiology.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pascalbardeau on 11/10/2017.
 */
@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="username",nullable = false)
    private String username;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="email")
    private String email;

    @ManyToOne
    private Profile profile;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Transient
    public List<GrantedAuthority> getGrantedAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(!getProfile().getAuthorities().isEmpty()){
            for(Authority authority : getProfile().getAuthorities()){
                authorities.add(new SimpleGrantedAuthority(authority.getName()));
            }
        }
        return authorities;
    }
}
