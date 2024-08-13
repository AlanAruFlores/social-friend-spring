package com.ar.social_friend.social_friend.controllers;

import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.exceptions.UserNotFoundException;
import com.ar.social_friend.social_friend.services.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    public LoginService loginService;


    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping(path="/access", method = RequestMethod.POST)
    public String access(User user){
        try{
           User result = this.loginService.searchUserByUsernameAndPassword(user);
        }catch(UserNotFoundException ex){
            return "redirect:/login/";
        }
        return "home";
    }
}
