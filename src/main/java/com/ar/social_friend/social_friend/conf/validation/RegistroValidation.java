package com.ar.social_friend.social_friend.conf.validation;

import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
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
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validation.NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "validation.NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "validation.NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validation.NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "validation.NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "validation.NotEmpty");

        if( user.getBirthDate() == null || user.getBirthDate().toString().isEmpty())
            errors.rejectValue("birthDate", "validation.NotEmpty");

        if(!user.getEmail().endsWith("@gmail.com"))
            errors.rejectValue("email", "validation.email.format");

        if(user.getUsername().length() <6 || user.getUsername().length() > 10)
            errors.rejectValue("username", "validation.username.size");

        if(user.getPassword().length() < 8)
            errors.rejectValue("password", "validation.password.size");
    }
}
