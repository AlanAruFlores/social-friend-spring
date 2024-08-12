package com.ar.social_friend.social_friend.controllers;

import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    private RegistroService registroService;

    @Autowired
    public RegistroController(RegistroService registroService){
        this.registroService = registroService;
    }

    @RequestMapping("/")
    public String registro(Model model){
        model.addAttribute("user", new User());
        return "registro";
    }

    @RequestMapping("/crear-cuenta")
    public String createNewAccount(@ModelAttribute("user") User user) {
        this.registroService.registerNewUser(user);
        return "login";
    }
}
