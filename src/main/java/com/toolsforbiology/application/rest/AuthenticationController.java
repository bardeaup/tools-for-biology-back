package com.toolsforbiology.application.rest;

import com.toolsforbiology.application.services.UserService;
import com.toolsforbiology.security.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pascalbardeau on 06/11/2017.
 */
@RestController
@RequestMapping(value = "/api")
public class AuthenticationController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDto) {
        return ResponseEntity.status(HttpStatus.OK).body(createUser(userDto));
    }
}
