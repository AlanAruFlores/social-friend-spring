package com.ar.social_friend.social_friend.conf.validation;

import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegistroValidation implements Validator {

    private RegistroService registroService;

    @Autowired
    public RegistroValidation(RegistroService registroService){
        this.registroService = registroService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
