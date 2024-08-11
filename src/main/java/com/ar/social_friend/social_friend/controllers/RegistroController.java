package com.ar.social_friend.social_friend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    @RequestMapping("/")
    public String registro(){
        return "registro";
    }
}
