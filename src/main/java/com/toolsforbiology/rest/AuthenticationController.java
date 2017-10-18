package com.toolsforbiology.rest;

import com.toolsforbiology.dto.LoginDTO;
import com.toolsforbiology.dto.UserDTO;
import com.toolsforbiology.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pascalbardeau on 07/10/2017.
 */
@RestController
@RequestMapping(value = "/toolsForBiology")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public UserDTO authenticate(@RequestBody LoginDTO loginDTO, HttpServletRequest request, HttpServletResponse response) throws Exception{
        return authenticationService.authenticate(loginDTO, request, response);
    }

    @GetMapping("/authenticate")
    public String authenticate(HttpServletRequest request) {
        return request.getRemoteUser();
    }
}
