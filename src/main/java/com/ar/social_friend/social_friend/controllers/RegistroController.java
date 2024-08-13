package com.ar.social_friend.social_friend.controllers;

import com.ar.social_friend.social_friend.conf.validation.RegistroValidation;
import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.services.RegistroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    private RegistroService registroService;

    private RegistroValidation registroValidation;

    @Autowired
    public RegistroController(RegistroService registroService, RegistroValidation registroValidation){
        this.registroService = registroService;
        this.registroValidation = registroValidation;
    }

    @RequestMapping("/")
    public String registro(Model model){
        model.addAttribute("user", new User());
        return "registro";
    }

    @RequestMapping(path = "/crear-cuenta", method = RequestMethod.POST)
    public String createNewAccount(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        this.registroValidation.validate(user, result);
        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "registro";
        }

        this.registroService.registerNewUser(user);
        redirectAttributes.addFlashAttribute("success", "Se registro con exito");
        return "redirect:/login/";
    }
}
