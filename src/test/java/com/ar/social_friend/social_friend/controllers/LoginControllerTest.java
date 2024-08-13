package com.ar.social_friend.social_friend.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ar.social_friend.social_friend.DataProvider;
import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.exceptions.UserNotFoundException;
import com.ar.social_friend.social_friend.services.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private LoginService loginService;

    private HttpServletRequest request;

    private RedirectAttributes redirectAttributes;

    private Model model;

    @BeforeEach
    public void init(){
        this.request = mock(HttpServletRequest.class);
        this.redirectAttributes = mock(RedirectAttributes.class);
        this.model = mock(Model.class);
    }

    /*Testeo si puedo ir a la vista principal del login*/
    @Test
    public void testIfICanGoToMainViewOfLoginController(){
        String view = whenGoToLogin();
        assertEquals("login",view);
    }

    private String whenGoToLogin(){
        return this.loginController.login(model);
    }

    @Test
    public void testICanAccessToTheMainPage() throws UserNotFoundException {
        User user = DataProvider.getNewUser();
        when(this.loginService.searchUserByUsernameAndPassword(user)).thenReturn(user);
        when(request.getSession()).thenReturn(mock(HttpSession.class));

        String view = this.loginController.access(user,request, redirectAttributes);
        assertEquals("home", view);
    }

    @Test
    public void testICanNotAccessToTheMainPage() throws UserNotFoundException {
        User user = DataProvider.getNewUser();
        when(this.loginService.searchUserByUsernameAndPassword(user)).thenThrow(UserNotFoundException.class);
        String view = this.loginController.access(user,request, redirectAttributes);
        assertEquals("redirect:/login/", view);
    }


}
