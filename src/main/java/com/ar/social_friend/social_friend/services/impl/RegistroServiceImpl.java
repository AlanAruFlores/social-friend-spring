package com.ar.social_friend.social_friend.services.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCryptParser;
import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.repositories.UserRepository;
import com.ar.social_friend.social_friend.services.RegistroService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;

@Service
@Transactional
public class RegistroServiceImpl implements RegistroService {

    private UserRepository userRepository;

    private Base64.Encoder encode;

    private Base64.Decoder decode;

    @Autowired
    public RegistroServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.encode = Base64.getEncoder();
        this.decode  = Base64.getDecoder();
    }

    @Override
    public void registerNewUser(User user) {
        //Codifico la contraseña
        user.setPassword(this.encode.encodeToString(user.getPassword().getBytes()));

        this.userRepository.save(user);
    }
}
