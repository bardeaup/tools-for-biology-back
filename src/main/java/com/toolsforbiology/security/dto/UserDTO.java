package com.toolsforbiology.security.dto;

import lombok.Data;

/**
 * Created by pascalbardeau on 07/10/2017.
 */

@Data
public class UserDTO {

    private String username;
    private String email;
    private String password;
    private String confirm_password;

}
