package com.ar.social_friend.social_friend.services;

import com.ar.social_friend.social_friend.DataProvider;
import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.repositories.UserRepository;
import com.ar.social_friend.social_friend.services.impl.RegistroServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RegistroServiceTest {

    @InjectMocks
    private RegistroServiceImpl registroService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testICanRegisterNewUser(){
        //given
        User user = DataProvider.getNewUser();
        //when
        this.registroService.registerNewUser(user);

        //then
        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(this.userRepository, times(1)).save(argumentCaptor.capture());

        assertEquals(user.getName(), argumentCaptor.getValue().getName());
        assertEquals(user.getEmail(), argumentCaptor.getValue().getEmail());
        assertEquals(user.getBirthDate(), argumentCaptor.getValue().getBirthDate());
        assertEquals(user.getPassword(), argumentCaptor.getValue().getPassword());
        assertEquals(user.getSurname(), argumentCaptor.getValue().getSurname());

    }

}
