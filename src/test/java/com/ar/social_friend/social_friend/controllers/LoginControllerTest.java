package com.ar.social_friend.social_friend.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.ar.social_friend.social_friend.DataProvider;
import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.exceptions.UserNotFoundException;
import com.ar.social_friend.social_friend.services.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private LoginService loginService;

    /*Testeo si puedo ir a la vista principal del login*/
    @Test
    public void testIfICanGoToMainViewOfLoginController(){
        String view = whenGoToLogin();
        assertEquals("login",view);
    }

    private String whenGoToLogin(){
        return this.loginController.login();
    }

    @Test
    public void testICanAccessToTheMainPage() throws UserNotFoundException {
        User user = DataProvider.getNewUser();
        when(this.loginService.searchUserByUsernameAndPassword(user)).thenReturn(new User());
        String view = this.loginController.access();

        assertEquals("home", view);

    }



}
