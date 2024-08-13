package com.ar.social_friend.social_friend.services;

import com.ar.social_friend.social_friend.DataProvider;
import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.exceptions.ResultsNotFoundException;
import com.ar.social_friend.social_friend.repositories.UserRepository;
import com.ar.social_friend.social_friend.services.impl.UserServiceImpl;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testICanSearchUsersByUsername() throws ResultsNotFoundException {
        String username = "username";
        List<User> results = whenIWantToSearchByUsername(username, DataProvider.getUsers());
        thenResultsToExpect(4,results);
    }


    @Test
    public void testICanNOTGetUsersByUsername(){
        String username = "asdasdsa";
        //List<User> results = whenIWantToSearchByUsername(username, List.of());
        //thenResultsToExpect(0,results);
        assertThrows(ResultsNotFoundException.class, ()->whenIWantToSearchByUsername(username,List.of()));
    }

    private List<User> whenIWantToSearchByUsername(String username, List<User> expected) throws ResultsNotFoundException {
        if(!expected.isEmpty())
            when(this.userRepository.findAllByUsernameContainsIgnoreCase(username)).thenReturn(expected);
        else
            when(this.userService.searchUsersByUsername(username)).thenThrow(ResultsNotFoundException.class);

        return this.userService.searchUsersByUsername(username);
    }

    private void thenResultsToExpect(Integer count, List<User> results){
        assertNotNull(results);
        assertEquals(count, results.size());
    }
}
