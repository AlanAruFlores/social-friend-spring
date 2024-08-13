package com.ar.social_friend.social_friend.controllers;

import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    public LoginService loginService;


    @RequestMapping("/")
    public String login() {
        return "login";
    }

    public String access() {
        return "home";
    }
}
