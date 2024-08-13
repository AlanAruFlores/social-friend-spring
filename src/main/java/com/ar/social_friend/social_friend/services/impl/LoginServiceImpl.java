package com.ar.social_friend.social_friend.services.impl;

import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.exceptions.UserNotFoundException;
import com.ar.social_friend.social_friend.repositories.UserRepository;
import com.ar.social_friend.social_friend.services.LoginService;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    private UserRepository userRepository;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User searchUserByUsernameAndPassword(User user) throws UserNotFoundException{
        User result =  this.userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(result == null)
            throw new UserNotFoundException();
        return result;
    }
}
