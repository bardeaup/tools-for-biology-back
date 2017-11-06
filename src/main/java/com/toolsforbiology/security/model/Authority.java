package com.toolsforbiology.security.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pascalbardeau on 25/10/2017.
 */


@Data
@Entity
@Table(name = "AUTHORITY")
public class Authority implements GrantedAuthority {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "expiration_date")
    Date expirationDate;

    @Override
    public String getAuthority() {
        return name;
    }

}
