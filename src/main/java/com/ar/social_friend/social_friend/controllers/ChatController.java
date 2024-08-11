package com.ar.social_friend.social_friend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @RequestMapping("/")
    public String chat() {
        return "chat";
    }
}
