package com.geniusbrain.bookmycab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String homePage(){
        return "Welcome to BookMyCab!";
    }

    @RequestMapping("/users")
    public String userPage(){
        return "Welcome to BookMyCab, enjoy your journey!";
    }

    @RequestMapping("/admin")
    public String adminPage(){
        return "Hello boss, what can do for you!";
    }
}
