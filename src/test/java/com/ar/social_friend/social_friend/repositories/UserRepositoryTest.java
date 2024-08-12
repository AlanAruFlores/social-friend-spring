package com.ar.social_friend.social_friend.repositories;

import com.ar.social_friend.social_friend.DataProvider;
import com.ar.social_friend.social_friend.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    @Rollback(value=true)
    public void testIfIcanRegisterUsers(){
        User user = DataProvider.getNewUser();
        whenSaveUser(user);
        thenIHaveNUsers(1L);
    }


    private void whenSaveUser(User user){
        this.userRepository.save(user);
    }

    private void thenIHaveNUsers(Long n){
        assertFalse(this.userRepository.findAll().isEmpty());
        assertEquals(n, this.userRepository.count());
    }

}
