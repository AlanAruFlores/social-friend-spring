package com.ar.social_friend.social_friend.controllers;

import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.exceptions.UserNotFoundException;
import com.ar.social_friend.social_friend.services.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
public class LoginController {

    public LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @RequestMapping("/")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(path="/access", method = RequestMethod.POST)
    public String access(@ModelAttribute("user")User user, HttpServletRequest request, RedirectAttributes redirectAttributes){
        try{
           User result = this.loginService.searchUserByUsernameAndPassword(user);
           request.getSession().setAttribute("userLogged",result);
        }catch(UserNotFoundException ex){
            redirectAttributes.addFlashAttribute("error", "Usuario y contraseña invalidos");
            return "redirect:/login/";
        }
        return "home";
    }
}
