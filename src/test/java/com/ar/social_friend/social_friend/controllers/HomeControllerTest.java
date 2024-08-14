package com.ar.social_friend.social_friend.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ar.social_friend.social_friend.DataProvider;
import com.ar.social_friend.social_friend.exceptions.ResultsNotFoundException;
import com.ar.social_friend.social_friend.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class HomeControllerTest {

    @InjectMocks
    private HomeControlller homeControlller;

    @Mock
    private UserService userService;

    private Model model;

    @BeforeEach
    void init(){
        this.model = mock(Model.class);
    }

    @Test
    public void testGoToMainHomePage(){
        String view = whenGoToHomePage();
        assertEquals("home", view);
    }

    private String whenGoToHomePage() {
        return this.homeControlller.home(model);
    }

    @Test
    public void testSearchUsers() throws ResultsNotFoundException {
        String toSearch="name";

        when(this.userService.searchUsersByUsername(toSearch)).thenReturn(DataProvider.getUsers());

        String view = this.homeControlller.searchUsers(toSearch,model);
        assertEquals("users_search", view);
    }
    @Test
    public void testNotSearchUsers() throws ResultsNotFoundException {
        String toSearch="name";

        when(this.userService.searchUsersByUsername(toSearch)).thenThrow(ResultsNotFoundException.class);

        String view = this.homeControlller.searchUsers(toSearch,model);
        assertEquals("users_search", view);
    }
}
