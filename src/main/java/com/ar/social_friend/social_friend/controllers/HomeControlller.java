package com.ar.social_friend.social_friend.controllers;

import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.dto.UserSearchDTO;
import com.ar.social_friend.social_friend.exceptions.ResultsNotFoundException;
import com.ar.social_friend.social_friend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeControlller {

    private UserService userService;

    @Autowired
    public HomeControlller(UserService userService){
        this.userService  = userService;
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("userToSearch", new UserSearchDTO());
        return "home";
    }

    @RequestMapping(value = "/search-users", method = RequestMethod.GET)
    public String searchUsers(String username, Model model){

        try{
            List<UserSearchDTO> results = userService.searchUsersByUsername(username);
            model.addAttribute("results", results);
        }catch (ResultsNotFoundException ex){
            model.addAttribute("error", "No hay resultados");
        }

        return "users_search";
    }
}
