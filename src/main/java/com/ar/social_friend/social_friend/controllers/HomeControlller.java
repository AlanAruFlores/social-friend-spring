package com.ar.social_friend.social_friend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeControlller {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

}
