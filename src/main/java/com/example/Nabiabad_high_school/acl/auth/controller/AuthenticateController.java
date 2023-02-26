package com.example.Nabiabad_high_school.acl.auth.controller;

import com.example.Nabiabad_high_school.acl.auth.entity.jwt.JwtRequest;
import com.example.Nabiabad_high_school.acl.auth.entity.jwt.JwtResponse;
import com.example.Nabiabad_high_school.acl.auth.springUser.UserServiceImpl;
import com.example.Nabiabad_high_school.config.JwtUtils;
import com.example.Nabiabad_high_school.exception.InvalidCredentialsException;
import com.example.Nabiabad_high_school.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticateController {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private JwtUtils jwtUtils;


    //generate token
    @PostMapping("/generateToken")
    public ResponseEntity<?> generateToken(@Valid @RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

        } catch (NotFoundException e) {
            throw new Exception("User not found");
        }
        //authenticate
        UserDetails userDetails = this.userServiceImpl.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        boolean validate = this.jwtUtils.validateToken(token, userDetails);
        System.out.println("Token is validate " + validate);
        JwtResponse jwtResponse = new JwtResponse(token);
        return ResponseEntity.ok(jwtResponse);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {
            throw new Exception("User Disabled" + e.getMessage());
        } catch (BadCredentialsException e) {
            throw new InvalidCredentialsException("Invalid Credentials");
        }
    }


}
