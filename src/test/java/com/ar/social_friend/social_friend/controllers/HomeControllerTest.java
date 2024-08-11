package com.ar.social_friend.social_friend.controllers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class HomeControllerTest {

    @InjectMocks
    private HomeControlller homeControlller;



    @Test
    public void testGoToMainHomePage(){
        String view = whenGoToHomePage();
        assertEquals("home", view);
    }

    private String whenGoToHomePage() {
        return this.homeControlller.home();
    }
}
