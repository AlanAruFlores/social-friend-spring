package com.ar.social_friend.social_friend.services;

import com.ar.social_friend.social_friend.DataProvider;
import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.exceptions.UserNotFoundException;
import com.ar.social_friend.social_friend.repositories.UserRepository;
import com.ar.social_friend.social_friend.services.impl.LoginServiceImpl;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {
    @InjectMocks
    private LoginServiceImpl loginService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private Base64.Encoder encode;

    @Mock
    private Base64.Decoder decode;

    @Test
    public void testICanSearchAUserByUserNameAndPassword() throws UserNotFoundException {
        User user = DataProvider.getNewUser();

        when(encode.encodeToString(user.getPassword().getBytes())).thenReturn(user.getPassword());

        when(this.userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(user);
        User result = this.loginService.searchUserByUsernameAndPassword(user);

        assertNotNull(result);
        assertEquals(user, result);
    }

    @Test
    public void testICanNOTGetAUserByUserNameAndPassword() {
        User user = DataProvider.getNewUser();
        when(encode.encodeToString(user.getPassword().getBytes())).thenReturn(user.getPassword());

        when(this.userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(null);

        assertThrows(UserNotFoundException.class, () -> {
            this.loginService.searchUserByUsernameAndPassword(user);
        });
    }

}
