package com.geniusbrain.bookmycab.controller;

import com.geniusbrain.bookmycab.exception.ResourceAlreadyExistException;
import com.geniusbrain.bookmycab.model.AppUser;
import com.geniusbrain.bookmycab.model.AuthenticationRequest;
import com.geniusbrain.bookmycab.model.AuthenticationResponse;
import com.geniusbrain.bookmycab.security.JwtTokenHelper;
import com.geniusbrain.bookmycab.service.UserService;
import com.geniusbrain.bookmycab.service.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenHelper tokenHelper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private ValidationService validationService;
    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String homePage(){
        return "Welcome to BookMyCab!";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authReq){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUserId(), authReq.getPassword()));
        } catch (AuthenticationException e) {
            logger.error("Invalid userId or password");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(authReq.getUserId());
        String token = tokenHelper.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    @PostMapping("/register")
    public AppUser userRegistration(@Valid @RequestBody AppUser user) throws ResourceAlreadyExistException {
        validationService.validateNewUser(user.getUserId());
        return userService.addUser(user);
    }
}
