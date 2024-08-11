package com.ar.social_friend.social_friend.controllers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;


    /*Testeo si puedo ir a la vista principal del login*/
    @Test
    public void testIfICanGoToMainViewOfLoginController(){
        String view = whenGoToLogin();
        assertEquals("login",view);
    }

    private String whenGoToLogin(){
        return this.loginController.login();
    }


}
