package com.ar.social_friend.social_friend.controllers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RegistroControllerTest {

    @InjectMocks
    private RegistroController registroController;

    /*Test para ir a la vista de registro*/
    @Test
    public void testGoToTheRegisterMainView(){
        String view = whenGoToTheRegisterMainView();
        assertEquals("registro", view);
    }

    private String whenGoToTheRegisterMainView(){
        return this.registroController.registro();
    }
}
