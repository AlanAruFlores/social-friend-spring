package com.ar.social_friend.social_friend.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ar.social_friend.social_friend.DataProvider;
import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.services.RegistroService;
import com.ar.social_friend.social_friend.services.impl.RegistroServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RegistroControllerTest {

    @InjectMocks
    private RegistroController registroController;

    @Mock
    private RegistroService registroService;

    Model model;

    @BeforeEach
    void init(){
        model = mock(Model.class);
    }

    /*Test para ir a la vista de registro*/
    @Test
    public void testGoToTheRegisterMainView(){
        String view = whenGoToTheRegisterMainView();
        assertEquals("registro", view);
    }

    private String whenGoToTheRegisterMainView(){
        return this.registroController.registro(model);
    }

    @Test
    public void testICanRegisterNewAccount(){
        User user = DataProvider.getNewUser();

        String view = whenPostNewUser(user);

        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(this.registroService,times(1)).registerNewUser(argumentCaptor.capture());
        assertEquals("login", view);
        assertNotNull(argumentCaptor.getValue());
        assertEquals(user.getName(), argumentCaptor.getValue().getName());
        assertEquals(user.getEmail(), argumentCaptor.getValue().getEmail());
        assertEquals(user.getBirthDate(), argumentCaptor.getValue().getBirthDate());
        assertEquals(user.getPassword(), argumentCaptor.getValue().getPassword());
        assertEquals(user.getSurname(), argumentCaptor.getValue().getSurname());
    }

    private String whenPostNewUser(User user){
        return this.registroController.createNewAccount(user);
    }

}
