package com.ar.social_friend.social_friend.services;

import com.ar.social_friend.social_friend.repositories.UserRepository;
import com.ar.social_friend.social_friend.services.impl.LoginServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {
    @InjectMocks
    private LoginServiceImpl loginService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testICanSearchANewUser(){

    }

}
